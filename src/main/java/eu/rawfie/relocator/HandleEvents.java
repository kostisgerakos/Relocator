package eu.rawfie.relocator;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import eu.rawfie.relocator.JSON.JSON_Generator;
import eu.rawfie.relocator.JSON.JSON_parser;
import net.sf.json.JSONObject;

public class HandleEvents {
	
	private Relocator relocator;
	
	public HandleEvents(Relocator relocator) {
		this.relocator = relocator;
		//eventBus.register(this);
	}

	@Subscribe
	public void receiveDynamicGoTo(ConsumerRecord<String, GenericRecord> record) {

		System.out.println("received: "+ record.toString());
		/*JSON_parser.parseDynamicGoto(record.toString());
        boolean dn = relocator.validateAlternativePath(JSON_parser.getDynamicGoto(), record.partition());
        System.out.println(dn);

        if(dn){
            String script = JSON_parser.getScriptData().toString();
            JSONObject experimentChangeRequest = JSON_Generator.generateExperimentChangeRequest(script, true);
            System.out.println(experimentChangeRequest);

            relocator.navigateDevices();

            if(JSON_parser.getDynamicGoto().getLocation().getLatitude() == -1 &&
                    JSON_parser.getDynamicGoto().getLocation().getLongitude() == -1) {
                experimentChangeRequest = JSON_Generator.generateExperimentChangeRequest(script, false);
                System.out.println(experimentChangeRequest);
            }
        }*/
	}
}
