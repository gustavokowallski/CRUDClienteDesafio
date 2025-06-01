package com.devsuperior.CRUDesafio.dtos;

import com.devsuperior.CRUDesafio.entities.Client;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class ClientDTO {

    private Long id;
    @NotBlank(message = "Name está invalido")
    private String name;
    private String cpf;
    private Double income;
    @PastOrPresent(message = "Data invalida ")
    private LocalDate birthDate;
    private Integer children;

    public ClientDTO(){}

    public ClientDTO(Client client) {
        id = client.getId();

        name = client.getName();
        cpf = client.getCpf();
        income = client.getIncome();

        birthDate = client.getBirthDate();
        children = client.getChildren();

    }

    public Long getId() {
        return id;
    }

    public Integer getChildren() {
        return children;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Double getIncome() {
        return income;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }


}
