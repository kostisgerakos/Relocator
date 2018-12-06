package eu.rawfie.relocator;

import eu.rawfie.general.service.types.ExperimentStartRequest;
import eu.rawfie.relocator.Geofencing;
import eu.rawfie.relocator.JSON.JSON_Generator;
import eu.rawfie.relocator.JSON.JSON_parser;
import eu.rawfie.relocator.JSON.NodeEvent;
import eu.rawfie.relocator.database.Database;
import eu.rawfie.relocator.kafka.consumers.SinglePartitionConsumer;
import eu.rawfie.relocator.Relocator;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.serialization.*;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.KStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args)
    {
        Relocator relocator;
        Geofencing geofencing;
        String topic, script1, script2, responseMessage;

        JSON_parser.init_JSON_parser();
        relocator  = new Relocator();

        try {
            /*parse data from json*/
            //TODO remove once kafka consumers are included
            topic      = "ExperimentStartRequest";
            byte[] bytes = Files.readAllBytes(Paths.get("src/main/resources/ExperimentScripts/" + topic));
            script1 = new String(bytes, Charset.defaultCharset());
            topic      = "DynamicGoto";
            bytes = Files.readAllBytes(Paths.get("src/main/resources/ExperimentScripts/" + topic));
            script2 = new String(bytes, Charset.defaultCharset());

            //minimum acceptable distance between 2 devices during
            //the execution of an experiment to avoid collision
            relocator.setMinDistance(6.734);

            //TODO consumer edw gia to ExperimentStartRequest
        
            
            JSON_parser.parseExperimentStartRequest(script1);

            /*event handling*/
            NodeEvent nodeEvent = JSON_parser.getEventsMap().get("porto.mst.auv.1");
            String condition = "temperatureSensor> 10 && temperatureSensor<= 20";
            System.out.println(relocator.validateAlternativePath(nodeEvent, condition));

            //TODO consumer kai gia to DynamicGoto
            /*dynamic relocation of the device*/
            JSON_parser.parseDynamicGoto(script2);
            System.out.println(relocator.validateAlternativePath(JSON_parser.getDynamicGoto(), 4));

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
