package com.example.candi.service;

import com.example.candi.domain.Account;
import com.example.candi.repository.AccountRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class AccountService {
    final AccountRepository accountRepository;
    final ObjectMapper objectMapper;

    @RabbitListener(queues = "account")
    public void rabbitListen(@Payload String message) throws JsonProcessingException {
        Account account = accountRepository.save(objectMapper.readValue(message, Account.class));
        log.info("New Account in Candi: {}", account);
    }
}
