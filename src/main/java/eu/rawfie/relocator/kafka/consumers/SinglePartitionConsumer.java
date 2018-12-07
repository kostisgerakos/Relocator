package eu.rawfie.relocator.kafka.consumers;

import java.util.Arrays;
import java.util.Properties;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

public class SinglePartitionConsumer {

	private final KafkaConsumer<String, GenericRecord> consumer;
	private final String topic;
	private final int partitionNumber;

	public SinglePartitionConsumer(String brokers, String schemaRegistry, String groupId, String topic,
			Integer partitionNumber) {
		Properties prop = createConsumerConfig(brokers, schemaRegistry, groupId);
		this.consumer = new KafkaConsumer<>(prop);
		this.topic = topic;
		//this.partitionNumber = partitionNumber;
		if (partitionNumber == null) {
			consumer.subscribe(Arrays.asList(topic));
			while (true) {
				// poll loop
				final ConsumerRecords<String, GenericRecord> r = consumer.poll(1000);
				for (ConsumerRecord<String, GenericRecord> rr : r) {
					System.out.println(rr.value());
				}
			}
		} else {
			this.partitionNumber = partitionNumber;
			TopicPartition partition = new TopicPartition(this.topic, this.partitionNumber);
			consumer.assign(Arrays.asList(partition));
			while (true) {
				// poll loop
				final ConsumerRecords<String, GenericRecord> r = consumer.poll(1000);
				for (ConsumerRecord<String, GenericRecord> rr : r) {
					System.out.println(rr.value());
				}
			}
		}
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

}
