package com.example.kafkaproducer.serilizer;

import com.example.kafka.producer.type.GenericMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.kafka.support.serializer.DeserializationException;


public class GenericMessageDeserializer implements Deserializer<GenericMessage> {
    @Override
    public GenericMessage deserialize(String s, byte[] bytes) {
        try {
            return GenericMessage.parseFrom(bytes);
        } catch (InvalidProtocolBufferException e) {
            throw new DeserializationException("Deserialization Error", bytes, false, e);
        }
    }

}
