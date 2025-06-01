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
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;


    @Transactional
    public ClientDTO insert (ClientDTO entity){
        Client client = new Client();

        client = DTOtoEntity(entity, client);
        client = clientRepository.save(client);
        return new ClientDTO(client);


    }
    @Transactional(readOnly = true)
    public ClientDTO findById (Long id){
        Client client = clientRepository.findById(id).get();
        ClientDTO dto = new ClientDTO(client);
        return dto;

   }
    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll (Pageable pagea){
    Page<Client> result  = clientRepository.findAll(pagea);
        return result.map(x -> new ClientDTO(x));
    }

    @Transactional(readOnly = false)
    public void deleteById(Long id){
        clientRepository.deleteById(id);

    }

    @Transactional
    public ClientDTO update (Long id, ClientDTO dto){
        Client client = clientRepository.getReferenceById(id);
        client = clientRepository.save(DTOtoEntity(dto, client));
        return new ClientDTO(client);


    }


    private Client DTOtoEntity(ClientDTO dto, Client entity){

        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setChildren(dto.getChildren());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        return entity;
    }


}
