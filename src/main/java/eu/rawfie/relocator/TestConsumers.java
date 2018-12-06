package eu.rawfie.relocator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.javatuples.Quartet;

import com.google.common.eventbus.EventBus;

import eu.rawfie.general.service.types.ExperimentChangeRequest;
import eu.rawfie.relocator.JSON.NodeEvent;
import eu.rawfie.relocator.kafka.consumers.MultiplePartitionConsumers;
import eu.rawfie.relocator.kafka.producers.EventProducer;
import eu.rawfie.uxv.Header;
import eu.rawfie.uxv.Location;
import eu.rawfie.uxv.commands.Goto;

public class TestConsumers {

	private static Map<String, NodeEvent> eventsMap;

	public static void main(String[] args) {
		String brokers = "172.19.0.18:9092";
		String schemaRegistry = "http://172.19.0.18:8081";
		String groupId = "RelocatorConsumersTesting";
		String topic = "hmod_CpuUsage";

		EventBus eventBus = new EventBus();
		EventProducer producer = new EventProducer(eventBus);

		Predicate<Integer> biggerequalthan = i -> (i >= 10 && i <= 20);
		Predicate<Integer> logicalor = i -> (i == 10 || i == 20);
		Predicate<Integer> biggerthan = i -> (i >= 27);


//map gia to topic pou 8a akouei sto telos 
		/*for (Map.Entry<String, NodeEvent> eventsEntry : eventsMap.entrySet()) {
			// System.out.println(entry.getKey() + "/" + entry.getValue());
			for (Map.Entry<String, List<String>> nodeEventsEntry : eventsEntry.getValue().getConditionAndWaypoints()
					.entrySet()) {
				// System.out.println(entry.getKey() + "/" + entry.getValue());
				if (nodeEventsEntry.getKey().equals("temperatureSensor== 10  || temperatureSensor== 20 ")) {
					Quartet<String, Integer, Predicate, NodeEvent> quartet = Quartet.with(topic, 36, logicalor,
							eventsEntry.getValue());
				} else if (nodeEventsEntry.getKey().equals("temperatureSensor> 10 && temperatureSensor<= 20  ")) {
					Quartet<String, Integer, Predicate, NodeEvent> quartet = Quartet.with(topic, 36, biggerequalthan,
							eventsEntry.getValue());
				}

			}
		}*/

	/*	Quartet<String, Integer, Predicate, ExperimentChangeRequest> quartet = Quartet.with(topic, 36, biggerthan,
				new ExperimentChangeRequest("reg", "reg", "reg", false, Arrays.asList("reg"), Arrays.asList(0), 0.0,
						Arrays.asList(0.0), false));
		ArrayList<Quartet<String, Integer, Predicate, ExperimentChangeRequest>> quartetsWithPredicates = new ArrayList<>();
		quartetsWithPredicates.add(quartet);
*/
		Quartet<String, Integer, Predicate, Goto> quartet = Quartet.with(topic, 36, biggerthan,
				new Goto(new Header("Resource Controller","Planner",(long) 1531479680300L),new Location(new Header("Resource Controller","Planner",(long) 1531479680300L),0.6631475411085819,0.4115725625936492, -0.4073188f, 0.0, 0.0, 0.0, 0.0f, null), 1.0f, 3600.0f));
		ArrayList<Quartet<String, Integer, Predicate, Goto>> quartetsWithPredicates = new ArrayList<>();
		quartetsWithPredicates.add(quartet);
		
		MultiplePartitionConsumers partitonConsumerGroup = new MultiplePartitionConsumers(brokers, schemaRegistry,
				groupId, quartetsWithPredicates, eventBus);
		partitonConsumerGroup.execute();

		try {
			Thread.sleep(100000);
		} catch (InterruptedException ie) {

		}

	}
}
