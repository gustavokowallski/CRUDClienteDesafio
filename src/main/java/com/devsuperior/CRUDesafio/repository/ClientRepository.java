package com.devsuperior.CRUDesafio.repository;

import com.devsuperior.CRUDesafio.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
