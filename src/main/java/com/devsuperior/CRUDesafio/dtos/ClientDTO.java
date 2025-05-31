package com.devsuperior.CRUDesafio.dtos;

import com.devsuperior.CRUDesafio.entities.Client;

import java.time.LocalDate;

public class ClientDTO {
    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private LocalDate bithDate;
    private Integer childer;

    public ClientDTO(Client client) {
        id = client.getId();
        name = client.getName();
        cpf = client.getCpf();
        income = client.getIncome();
        bithDate = client.getBithDate();
        childer = client.getChilder();


    }

    public Long getId() {
        return id;
    }

    public Integer getChilder() {
        return childer;
    }

    public LocalDate getBithDate() {
        return bithDate;
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
