package eu.rawfie.relocator.kafka.producers;


import java.util.Properties;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;



public class EventProducer {
	
    private final org.apache.kafka.clients.producer.Producer<String, GenericRecord> producer;

    public EventProducer(final EventBus eventBus) {
    	final Properties props = new Properties();
    	props.put("bootstrap.servers", "eagle5.di.uoa.gr:9092");
    	props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
    	props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
        //props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("schema.registry.url", "http://eagle5.di.uoa.gr:8081");
        //props.put(KafkaAvroSerializerConfig. , true); 

        this.producer  = new KafkaProducer<>(props);
        eventBus.register(this);
    }
    
    @Subscribe
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
	
	
	
}