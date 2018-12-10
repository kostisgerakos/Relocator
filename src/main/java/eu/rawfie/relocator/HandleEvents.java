package eu.rawfie.relocator;

import java.util.Properties;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import eu.rawfie.general.service.types.ExperimentChangeRequest;
import eu.rawfie.relocator.JSON.JSON_Generator;
import eu.rawfie.relocator.JSON.JSON_parser;
import net.sf.json.JSONObject;

public class HandleEvents {
	
	private Relocator relocator;
	private boolean experimentChanged;
	
	public HandleEvents(Relocator relocator) {
		this.relocator = relocator;
		experimentChanged = false;
		//eventBus.register(this);
	}
	public void receiveExperimentStartRequest(ConsumerRecord<String, GenericRecord> record) {
		System.out.println("received ExperimentStart:"+ record.value().toString());
		JSON_parser.parseExperimentStartRequest(record.value().toString());
	}

	@Subscribe
	public void receiveDynamicGoTo(ConsumerRecord<String, GenericRecord> record) {

		System.out.println("received:"+ record.value().toString());
		JSON_parser.parseDynamicGoto(record.value().toString());
        boolean dn = relocator.validateAlternativePath(JSON_parser.getDynamicGoto(), record.partition());
        System.out.println(dn);

        if(dn){
//            String data = JSON_parser.getScriptData().toString();
            JSONObject script = JSON_Generator.generateScript(relocator.getLastTimestep(),
                    JSON_parser.getDynamicGoto(), record.partition());
//            script.element("data", data);
//            script.element("nodeNames", JSON_parser.getNodeNames());
//            script.element("nodeEvents", JSON_parser.getNodeEvents());
//            script.element("Testbed", JSON_parser.getTestbed());
//            script.element("TestbedArea", JSON_parser.getTestbedArea());
            
            //if(!experimentChanged) {
            	experimentChanged = true;
	            ExperimentChangeRequest experimentChangeRequest = JSON_Generator.generateExperimentChangeRequest(script.toString(), true);
	            
	            Properties props = new Properties();
	            props.put("bootstrap.servers", "eagle5.di.uoa.gr:9092");
	    		props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
	    		props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
	    		props.put("schema.registry.url", "http://eagle5.di.uoa.gr:8081");
	    		final KafkaProducer<String, GenericRecord> producer = new KafkaProducer<>(props);

	    		String topic = "ExperimentChangeRequest";
	    		producer.send(new ProducerRecord<String, GenericRecord>("ExperimentChangeRequest","key", experimentChangeRequest));
	    		producer.close();

	            
	            System.out.println(experimentChangeRequest);
          //}

            relocator.navigateDevices();

            if(JSON_parser.getDynamicGoto().getLocation().getLatitude() == -1 &&
                    JSON_parser.getDynamicGoto().getLocation().getLongitude() == -1) {
            	//ExperimentChangeRequest
            	experimentChangeRequest = JSON_Generator.generateExperimentChangeRequest(script.toString(), false);
                System.out.println(experimentChangeRequest);
            }
        }
	}
}
