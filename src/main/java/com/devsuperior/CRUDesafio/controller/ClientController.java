package com.devsuperior.CRUDesafio.controller;

import com.devsuperior.CRUDesafio.dtos.ClientDTO;
import com.devsuperior.CRUDesafio.entities.Client;
import com.devsuperior.CRUDesafio.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDTO> insert(@RequestBody  Client client){
        return clientService.insert(client);

    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findByID(@PathVariable  Long id){
        return clientService.findById(id);

    }
    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll (Pageable pagea){
        return clientService.findAll(pagea);
    }

}
