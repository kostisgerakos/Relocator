package eu.rawfie.relocator.kafka.producers;

import org.apache.avro.generic.GenericRecord;


public class TriggeredEvent {
    private final String topic;
    private final int partition;
    private final String key;
    private final GenericRecord record;

    public TriggeredEvent(String topic, int partition, String key, GenericRecord record) {
        this.topic = topic;
        this.partition = partition;
        this.key = key;
        this.record = record;
    }

    public String getTopic() {
        return topic;
    }

    public int getPartition() {
        return partition;
    }

    public String getKey() {
        return key;
    }

    public GenericRecord getRecord() {
        return record;
    }
    
   
}