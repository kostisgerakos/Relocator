package eu.rawfie.relocator.kafka.consumers;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import eu.rawfie.uxv.commands.DynamicGoto;

public class DynamicGotoConsumer {
	public static void main(String[] args) {
		final String topic = "aeroloop_DynamicGoto";
		final int partition =1;
		final Properties props = new Properties();
		//Basic properties values
		props.put("bootstrap.servers", "172.19.0.18:9092");
		props.put("enable.auto.commit", "false");
		props.put("group.id", "RelocatorExperimentConsumer");
		props.put("key.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
		props.put("value.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
		props.put("schema.registry.url", "http://172.19.0.18:8081");
		//props.put("specific.avro.reader", "true");
		props.put("auto.offset.reset", "earliest");

		final KafkaConsumer<String, DynamicGoto> consumer = new KafkaConsumer<>(props);
		TopicPartition topicPartition = new TopicPartition(topic, partition);
	    consumer.assign(Arrays.asList(topicPartition));
		//consumer.subscribe(Arrays.asList(topic));
		while (true) {
			//poll loop
			final ConsumerRecords<String, DynamicGoto> r = consumer.poll(1000);
			for (ConsumerRecord<String, DynamicGoto> rr : r) {
				System.out.println(rr.value());
			}
		}

	}
}
