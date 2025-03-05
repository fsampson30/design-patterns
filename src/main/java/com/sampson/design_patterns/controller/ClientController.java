package com.sampson.design_patterns.controller;

import com.sampson.design_patterns.model.Client;
import com.sampson.design_patterns.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@Tag(name = "Client Management", description = "Endpoints for managing clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    @Operation(summary = "Get all clients", description = "Fetch all clients")
    public List<Client> findAll(){
        return clientService.findALl();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get client by ID", description = "Fetch client by ID")
    public Client findById(@PathVariable Long id){
        return clientService.findById(id).get();
    }

    @PostMapping
    @Operation(summary = "Save a new client", description = "Save a new client")
    public Client save (@RequestBody Client client){
        clientService.insertClient(client);
        return client;
    }

    @PutMapping
    @Operation(summary = "Update a client", description = "Update a client")
    public Client update(@RequestBody Client client){
        clientService.updateClient(client.getId(), client);
        return client;
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a client", description = "Delete a client")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }



}
