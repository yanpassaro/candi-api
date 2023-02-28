package com.example.candi.service;

import com.example.candi.domain.dto.AccountDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class SenderService {

    @RabbitListener(queues = "account")
    public void rabbitListen(@Payload String message) throws JsonProcessingException {
        AccountDTO account = new ObjectMapper().readValue(message, AccountDTO.class);
    }
}

