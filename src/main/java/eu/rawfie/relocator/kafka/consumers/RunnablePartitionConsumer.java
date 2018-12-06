package eu.rawfie.relocator.kafka.consumers;

import java.util.Arrays;
import java.util.Properties;
import java.util.function.Predicate;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import com.google.common.eventbus.EventBus;

import eu.rawfie.general.service.types.ExperimentChangeRequest;
import eu.rawfie.relocator.kafka.producers.TriggeredEvent;
import eu.rawfie.uxv.CpuUsage;
import eu.rawfie.uxv.commands.Goto;


 
public class RunnablePartitionConsumer implements Runnable {
 
  private final KafkaConsumer<String, CpuUsage> consumer;
  private final String topic;
  private final int partitionNumber;
  
  private final Predicate predicate;
  private final Goto change;
  private final EventBus eventBus;
 
  public RunnablePartitionConsumer(String brokers, String schemaRegistry, String groupId, String topic, int partitionNumber, Predicate predicate, Goto change, EventBus eventBus) {
    Properties prop = createConsumerConfig(brokers, schemaRegistry, groupId);
    this.consumer = new KafkaConsumer<>(prop);
    this.topic = topic;
    this.partitionNumber = partitionNumber;
    
    this.predicate = predicate;
    this.change = change;
    this.eventBus = eventBus;
    
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
        final ConsumerRecords<String, CpuUsage> r = consumer.poll(1000);
		for (ConsumerRecord<String, CpuUsage> rr : r) {
			if(predicate.test(rr.value().value)){
				TriggeredEvent event = new TriggeredEvent("hmod_Goto",partitionNumber,"key",change); 
			    eventBus.post(event);
			}
			System.out.println(rr.value() + ", by consumerID: "
		            + Thread.currentThread().getId());
		}
    }
 
  }
 
 
}