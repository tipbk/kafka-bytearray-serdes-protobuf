package com.example.kafkaproducer.listener;

import com.example.kafka.producer.type.GenericMessage;
import com.example.kafka.producer.type.TipMessage;
import com.example.kafkaproducer.model.User;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.util.JsonFormat;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "tip.topic",groupId = "group_generic_message")
    public void consume(byte[] byteArrayMessage) throws InvalidProtocolBufferException {
        TipMessage tipMessage = TipMessage.parseFrom(byteArrayMessage);
        System.out.println(tipMessage.getSecond().getWivesNameList().contains("Mama"));
        System.out.println(JsonFormat.printer().print(tipMessage));
    }

}
