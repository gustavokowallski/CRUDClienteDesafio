package com.devsuperior.CRUDesafio.service;


import com.devsuperior.CRUDesafio.dtos.ClientDTO;
import com.devsuperior.CRUDesafio.entities.Client;
import com.devsuperior.CRUDesafio.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;


    @Transactional
    public ResponseEntity<ClientDTO> insert (Client entity){
        clientRepository.save(entity);
        ClientDTO dto = new ClientDTO(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);

    }
    @Transactional(readOnly = true)
    public ResponseEntity<ClientDTO> findById (Long id){
        Client client = clientRepository.findById(id).get();
        return ResponseEntity.ok(new ClientDTO(client));
   }
    @Transactional(readOnly = true)
    public ResponseEntity<Page<ClientDTO>> findAll (Pageable pagea){
    Page<Client> result  = clientRepository.findAll(pagea);
        return ResponseEntity.ok(result.map(x -> new ClientDTO(x)));
    }
}
