package com.sampson.design_patterns.service.impl;

import com.sampson.design_patterns.model.Client;
import com.sampson.design_patterns.repository.ClientRepository;
import com.sampson.design_patterns.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private ClientRepository clientRepository;

    public ClienteServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> findALl() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public void insertClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void updateClient(Long id, Client client) {
        Optional<Client> clientFound = clientRepository.findById(id);
        if (clientFound.isPresent()) {
            clientRepository.save(client);
        }
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);

    }
}
