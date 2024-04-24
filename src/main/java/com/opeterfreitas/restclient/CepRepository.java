package com.opeterfreitas.restclient;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CepRepository implements PanacheRepository<Cep> {
}
