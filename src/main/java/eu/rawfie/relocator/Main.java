package eu.rawfie.relocator;

import eu.rawfie.relocator.database.Database;
import eu.rawfie.relocator.kafka.consumers.MultiplePartitionConsumers;
import eu.rawfie.uxv.Header;
import eu.rawfie.uxv.Location;
import eu.rawfie.uxv.commands.Goto;
import eu.rawfie.relocator.Geofencing;
import eu.rawfie.relocator.JSON.JSON_Generator;
import eu.rawfie.relocator.JSON.JSON_parser;
import eu.rawfie.relocator.JSON.NodeEvent;
import eu.rawfie.relocator.Relocator;
import net.sf.json.JSONObject;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.serialization.*;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.KStream;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

import com.google.common.eventbus.EventBus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.nio.charset.Charset;

public class Main {


	
	
    public static void main(String[] args)
    {
        Relocator relocator;
        Geofencing geofencing;
        String topic, script1, script2, responseMessage;

        JSON_parser.init_JSON_parser();
        relocator  = new Relocator();
        EventBus eventBus = new EventBus();
        HandleEvents handle = new HandleEvents(relocator);
        eventBus.register(handle);

        try {
            /*parse data from json*/
            //TODO remove once kafka consumers are included
            topic      = "ExperimentStartRequest";
            byte[] bytes = Files.readAllBytes(Paths.get("src/main/resources/ExperimentScripts/" + topic));
            script1 = new String(bytes, Charset.defaultCharset());
            topic      = "aeroloop_DynamicGoto";
            
            ///////////////////////////////CONSUMERS////////////////////////////////////////////

            //no use for now
    		Predicate<Integer> biggerthan = i -> (i >= 27);

    		//static properties for now
    		String brokers = "172.19.0.18:9092";
    		String schemaRegistry = "http://172.19.0.18:8081";
    		String groupId = "RelocatorConsumersTesting";
            
            Triplet<String, Integer, Predicate> triplet = Triplet.with(topic, 3, biggerthan);
            Triplet<String, Integer, Predicate> triplet2 = Triplet.with(topic, 4, biggerthan);

    		ArrayList<Triplet<String, Integer, Predicate>> tripletsWithPredicates = new ArrayList<>();
    		tripletsWithPredicates.add(triplet);
    		tripletsWithPredicates.add(triplet2);

    		
    		MultiplePartitionConsumers partitonConsumerGroup = new MultiplePartitionConsumers(brokers, schemaRegistry,
    				groupId, tripletsWithPredicates, eventBus);
    		partitonConsumerGroup.execute();

            ///////////////////////////////CONSUMERS////////////////////////////////////////////

    		
    		//bytes = Files.readAllBytes(Paths.get("src/main/resources/ExperimentScripts/" + topic));
            //script2 = new String(bytes, Charset.defaultCharset());

           /* //minimum acceptable distance between 2 devices during
            //the execution of an experiment to avoid collision
            relocator.setMinDistance(6.734);

            //TODO consumer edw gia to ExperimentStartRequest
            JSON_parser.parseExperimentStartRequest(script1);
            System.out.println("experiment passed");

            event handling
            NodeEvent nodeEvent = JSON_parser.getEventsMap().get("porto.mst.auv.1");
            String condition = "temperatureSensor> 10 && temperatureSensor<= 20  ";
            System.out.println(relocator.validateAlternativePath(nodeEvent, condition));
*/
            //TODO consumer kai gia to DynamicGoto
            /*dynamic relocation of the device*/
            
    		

            /*camera activation*/
//            responseMessage = relocator.cameraActivation();
//            Thread.sleep(10000);
//            /*camera deactivation*/
//            relocator.cameraDeactivation(responseMessage);

            /*Geo-fencing*/
//            String waypoint = "41.19022439107971,-8.708129940074775";
//            geofencing = new Geofencing(JSON_parser.getTestbedID());
//            System.out.println(geofencing.inTestbedArea(waypoint));
//            System.out.println(Database.inTestbedArea(transformedPolygon, waypoint));
    		
    		

        } catch (IOException e) {
            e.printStackTrace();
        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
