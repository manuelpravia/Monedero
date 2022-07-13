package com.nttdata.bank.domain.service;

import com.nttdata.bank.domain.dto.TransactionDto;
import com.nttdata.bank.events.Event;
import com.nttdata.bank.events.TransactionCreateEvent;
import com.nttdata.bank.infraestructure.data.document.Monedero;
import com.nttdata.bank.infraestructure.data.repository.MonederoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UpdateMonederoService {

    @Autowired
    MonederoRepository monederoRepository;

    @KafkaListener(
            topics = "${topic.transaccion.name:tansacciones}",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "grupo1")
    public void consumer(Event<?> event) {
        if (event.getClass().isAssignableFrom(TransactionCreateEvent.class)) {
            TransactionCreateEvent customerCreatedEvent = (TransactionCreateEvent) event;
            TransactionDto transactionDto = customerCreatedEvent.getData();
            Monedero monedero = new Monedero();
            //monedero.setId();
            monedero.setClient("rafael carlos");
            //monedero.setAmountBootCoin(monedero.getAmountBootCoin().add(transactionDto.getAmountBootCoin()));
            monedero.setAmountBootCoin(transactionDto.getAmountBootCoin());
            monederoRepository.save(monedero);
            log.info("Recibido la solicitud Id={}, data={}",
                    customerCreatedEvent.getId(),
                    customerCreatedEvent.getData().toString());
        }

    }
}
