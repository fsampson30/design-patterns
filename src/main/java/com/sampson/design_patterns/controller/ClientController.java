package com.sampson.design_patterns.controller;

import com.sampson.design_patterns.model.Client;
import com.sampson.design_patterns.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
@Tag(name = "Client Management", description = "Endpoints for managing clients")
public class ClientController {

    private ClienteService clienteService;

    public ClientController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    @Operation(summary = "Get all clients", description = "Fetch all clients")
    public List<Client> findAll(){
        return clienteService.findALl();
    }

}
