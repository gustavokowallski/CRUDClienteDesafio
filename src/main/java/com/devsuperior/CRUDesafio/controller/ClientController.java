package com.devsuperior.CRUDesafio.controller;

import com.devsuperior.CRUDesafio.dtos.ClientDTO;
import com.devsuperior.CRUDesafio.entities.Client;
import com.devsuperior.CRUDesafio.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDTO> insert(@RequestBody ClientDTO client){
        ClientDTO dto = clientService.insert(client);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);

    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findByID(@PathVariable  Long id){
        return ResponseEntity.ok().body(clientService.findById(id));

    }
    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll (Pageable pagea){
        return ResponseEntity.ok().body(clientService.findAll(pagea));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @RequestBody ClientDTO entity){
        ClientDTO dto = clientService.update(id, entity);
        return ResponseEntity.ok().body(dto);

    }

}
