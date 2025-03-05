package com.sampson.design_patterns.service.impl;

import com.sampson.design_patterns.model.Address;
import com.sampson.design_patterns.model.Client;
import com.sampson.design_patterns.repository.AddressRepository;
import com.sampson.design_patterns.repository.ClientRepository;
import com.sampson.design_patterns.service.ClientService;
import com.sampson.design_patterns.service.ViaCepService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private AddressRepository addressRepository;
    private ViaCepService viaCepService;

    public ClientServiceImpl(ClientRepository clientRepository, AddressRepository addressRepository, ViaCepService viaCepService) {
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
        this.viaCepService = viaCepService;
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
        saveClientWithZipCode(client);
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

    private void saveClientWithZipCode(Client client){
        String zipCode = client.getAddress().getCep();
        Address address = addressRepository.findById(zipCode).orElseGet( () -> {
            Address newAddress = viaCepService.findCep(zipCode);
            addressRepository.save(newAddress);
            return  newAddress;});
        client.setAddress(address);
        clientRepository.save(client);

    }
}
