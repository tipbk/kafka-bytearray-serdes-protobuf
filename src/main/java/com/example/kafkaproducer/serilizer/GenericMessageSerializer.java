package com.example.kafkaproducer.serilizer;

import com.example.kafka.producer.type.GenericMessage;
import org.apache.kafka.common.serialization.Serializer;

public class GenericMessageSerializer implements Serializer<GenericMessage> {
    @Override
    public byte[] serialize(String s, GenericMessage genericMessage) {
        return genericMessage.toByteArray();
    }
}
