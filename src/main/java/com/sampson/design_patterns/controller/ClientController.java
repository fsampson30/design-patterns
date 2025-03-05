package com.sampson.design_patterns.controller;

import com.sampson.design_patterns.model.Client;
import com.sampson.design_patterns.service.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClienteService clienteService;

    public ClientController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Client> findAll(){
        return clienteService.findALl();
    }

}
