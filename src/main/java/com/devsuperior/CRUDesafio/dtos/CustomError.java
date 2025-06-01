package com.devsuperior.CRUDesafio.dtos;

import java.time.Instant;

public class CustomError {
    private Instant timestamp; // Ou LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String path;
    public CustomError(){}

    public CustomError(Instant timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }

    public Integer getStatus() {
        return status;
    }
}
