package eu.rawfie.relocator;

import java.util.Arrays;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.google.common.eventbus.EventBus;

import eu.rawfie.general.service.types.ExperimentChangeRequest;
import eu.rawfie.relocator.kafka.producers.EventProducer;
import eu.rawfie.relocator.kafka.producers.SimpleProducer;
import eu.rawfie.relocator.kafka.producers.TriggeredEvent;

public class TestProducer {

	public static void main(String[] args) {
		//EventBus eventBus = new EventBus();
		//EventProducer producer = new EventProducer(eventBus);
		//ExperimentChangeRequest experimentChangeRequest = new ExperimentChangeRequest("reg","reg", "reg", false, Arrays.asList("reg"),  Arrays.asList(0), 0.0, Arrays.asList(0.0),false);
		//ProducerRecord<String, GenericRecord> record = new ProducerRecord<String, GenericRecord>(topic,"key", experimentChangeRequest);
		//TriggeredEvent event = new TriggeredEvent("ExperimentChangeRequest",1,"key",experimentChangeRequest); 
	    //eventBus.post(event);
		//producer.dispatchEvent(new TriggeredEvent("ExperimentChangeRequest",1,"key",experimentChangeRequest));
		SimpleProducer producer = new SimpleProducer();
		ExperimentChangeRequest experimentChangeRequest = new ExperimentChangeRequest("reg","reg", "reg", false, Arrays.asList("reg"),  Arrays.asList(0), 0.0, Arrays.asList(0.0),false);
		ProducerRecord<String, GenericRecord> record = new ProducerRecord<String, GenericRecord>("ExperimentChangeRequest","key", experimentChangeRequest);
		//producer.dispatchEvent(new TriggeredEvent("ExperimentChangeRequest",1,"key",experimentChangeRequest));
		producer.getProducer().send(record);
	}

}
