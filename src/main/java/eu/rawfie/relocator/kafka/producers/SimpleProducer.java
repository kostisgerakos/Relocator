package eu.rawfie.relocator.kafka.producers;

import java.util.Properties;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;


public class SimpleProducer {
	
    public KafkaProducer<String, GenericRecord> getProducer() {
		return producer;
	}

	private KafkaProducer<String, GenericRecord> producer;

    public SimpleProducer() {
    	final Properties props = new Properties();
    	props.put("bootstrap.servers", "eagle5.di.uoa.gr:9092");
		props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
		props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
		props.put("schema.registry.url", "http://eagle5.di.uoa.gr:8081");
        this.producer  = new KafkaProducer<String, GenericRecord>(props);
        
    }
    
    
    public void dispatchEvent(TriggeredEvent event) {
        try {
            producer.send(new ProducerRecord<>(event.getTopic(),
                    event.getPartition(),
                    event.getKey(),
                    event.getRecord()));
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    public void dispatchMessage(ProducerRecord<String, GenericRecord> record) {
        try {
        	System.out.println("sending" + record.toString());
            producer.send(record);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
