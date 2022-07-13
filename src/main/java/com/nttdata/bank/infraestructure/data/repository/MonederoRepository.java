package com.nttdata.bank.infraestructure.data.repository;

import com.nttdata.bank.infraestructure.data.document.Monedero;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MonederoRepository extends ReactiveMongoRepository<Monedero,String> {
}
