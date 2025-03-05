package com.sampson.design_patterns.service;

import com.sampson.design_patterns.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<Client> findALl();

    Optional<Client> findById(Long id);

    void insertClient(Client client);

    void updateClient(Long id, Client client);

    void deleteClient(Long id);
}
