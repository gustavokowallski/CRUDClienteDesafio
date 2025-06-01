package com.devsuperior.CRUDesafio.service;


import com.devsuperior.CRUDesafio.dtos.ClientDTO;
import com.devsuperior.CRUDesafio.entities.Client;
import com.devsuperior.CRUDesafio.repository.ClientRepository;

import com.devsuperior.CRUDesafio.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;


    @Transactional
    public ClientDTO insert (ClientDTO entity){

            Client client = new Client();
            client = clientRepository.save(DTOtoEntity(entity, client));
            return new ClientDTO(client);

        }


    @Transactional(readOnly = true)
    public ClientDTO findById (Long id){
        Client client = clientRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Recurso não encontrado"));
        return new ClientDTO(client);


   }
    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll (Pageable pagea){
    Page<Client> result  = clientRepository.findAll(pagea);
        return result.map(x -> new ClientDTO(x));
    }

    @Transactional(readOnly = false)
    public void deleteById(Long id){
        if(!clientRepository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        clientRepository.deleteById(id);

    }

    @Transactional
    public ClientDTO update (Long id, ClientDTO dto){
        try{
            Client client = clientRepository.getReferenceById(id);
            client = clientRepository.save(DTOtoEntity(dto, client));
            return new ClientDTO(client);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }



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

