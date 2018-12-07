package eu.rawfie.relocator.kafka.producers;


import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;


import eu.rawfie.general.service.types.ExperimentChangeRequest;

public class ExperimentChangeRequestProducer {

	final static ExperimentChangeRequestProducer prod = new ExperimentChangeRequestProducer();
	final static Integer partition = 4; 
	public static void main(String[] args) throws InterruptedException, ExecutionException, FileNotFoundException {
		final Properties props = new Properties();
		props.put("bootstrap.servers", "eagle5.di.uoa.gr:9092");
		props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
		props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
		props.put("schema.registry.url", "http://eagle5.di.uoa.gr:8081");
		final KafkaProducer<String, GenericRecord> producer = new KafkaProducer<>(props);

		String topic = "ExperimentChangeRequest";
		producer.send(prod.getExperiment(topic));
		producer.close();

	}
	public ProducerRecord<String, GenericRecord> getExperiment(String topic){
		ExperimentChangeRequest experimentChangeRequest = new ExperimentChangeRequest("reg","reg", "reg", false, Arrays.asList("reg"),  Arrays.asList(0), 0.0, Arrays.asList(0.0),false);
		ProducerRecord<String, GenericRecord> record = new ProducerRecord<String, GenericRecord>("ExperimentChangeRequest","key", experimentChangeRequest);
		return record;
	}
}
