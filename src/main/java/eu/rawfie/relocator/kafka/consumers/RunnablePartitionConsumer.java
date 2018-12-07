package eu.rawfie.relocator.kafka.consumers;

import java.util.Arrays;
import java.util.Properties;
import java.util.function.Predicate;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import com.google.common.eventbus.EventBus;

import eu.rawfie.general.service.types.ExperimentChangeRequest;
import eu.rawfie.relocator.HandleEvents;
import eu.rawfie.relocator.kafka.producers.TriggeredEvent;
import eu.rawfie.uxv.CpuUsage;
import eu.rawfie.uxv.commands.Goto;


 
public class RunnablePartitionConsumer implements Runnable {
 
  private final KafkaConsumer<String, GenericRecord> consumer;
  private final String topic;
  private final int partitionNumber;
  
  private final Predicate predicate;
  private final EventBus eventBus;
  HandleEvents handle;
  
  public RunnablePartitionConsumer(String brokers, String schemaRegistry, String groupId, String topic, int partitionNumber, Predicate predicate, EventBus eventBus,HandleEvents handle) {
    Properties prop = createConsumerConfig(brokers, schemaRegistry, groupId);
    this.consumer = new KafkaConsumer<>(prop);
    this.topic = topic;
    this.partitionNumber = partitionNumber;
    
    this.predicate = predicate;
    this.eventBus = eventBus;
    this.handle = handle;
    TopicPartition partition = new TopicPartition(this.topic, this.partitionNumber);
    consumer.assign(Arrays.asList(partition));
  }
 
  private static Properties createConsumerConfig(String brokers, String schemaRegistry, String groupId) {
    Properties props = new Properties();
    props.put("bootstrap.servers", brokers);
	props.put("enable.auto.commit", "false");
	props.put("group.id", groupId);
	props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	props.put("value.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
	props.put("schema.registry.url", schemaRegistry);
	props.put("specific.avro.reader", "true");
	props.put("auto.offset.reset", "latest");

    return props;
  }
 
  @Override
  public void run() {
    while (true) {
        final ConsumerRecords<String, GenericRecord> r = consumer.poll(1000);
		for (ConsumerRecord<String, GenericRecord> rr : r) {
			/*if(predicate.test(rr.value().value)){
				TriggeredEvent event = new TriggeredEvent("hmod_Goto",partitionNumber,"key"); 
			    eventBus.post(event);
			}*/
			//eventBus.post(rr.toString());
			handle.receiveDynamicGoTo(rr);
			//System.out.println(rr.value() + ", by partition: " + rr.partition());
		}
    }
 
  }
 
 
}