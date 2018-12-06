package eu.rawfie.relocator.kafka.consumers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.javatuples.Quartet;

import com.google.common.eventbus.EventBus;

import eu.rawfie.general.service.types.ExperimentChangeRequest;
import eu.rawfie.uxv.commands.Goto;

 
public class MultiplePartitionConsumers {
 
  //private final int numberOfConsumers;
  //private final String groupId;
  //private final String topic;
  //private final String brokers;
  //private final String schemaRegistry;
  //private final ArrayList<Integer> partitionNumberList;
  private List<RunnablePartitionConsumer> partitionConsumers;

 
  public MultiplePartitionConsumers(final String brokers,String schemaRegistry, String groupId,final ArrayList<Quartet<String,Integer,Predicate,Goto>> quartetsWithPredicates, final EventBus eventBus ) {
    //this.brokers = brokers;
    //this.schemaRegistry = schemaRegistry;
    //this.groupId = groupId;
    //this.topic = quartet.getValue0();
    //this.partitionNumberList = partitionNumberList;
    partitionConsumers = new ArrayList<>();
    for (Quartet<String, Integer, Predicate, Goto> quartet : quartetsWithPredicates) {
    	RunnablePartitionConsumer ncThread =
          new RunnablePartitionConsumer(brokers,schemaRegistry, groupId, quartet.getValue0(), quartet.getValue1(),quartet.getValue2(),quartet.getValue3(),eventBus);
      partitionConsumers.add(ncThread);
      System.out.println("Started consumer for partition" + quartet.getValue1());
    }
  }
 
  public void execute() {
    for (RunnablePartitionConsumer ncThread : partitionConsumers) {
      Thread t = new Thread(ncThread);
      t.start();
    }
  }
 
 
}