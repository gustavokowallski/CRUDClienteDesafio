package com.devsuperior.CRUDesafio.dtos;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError{
    List<FieldMessage> field = new ArrayList<>();



    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
        this.field = field;
    }

    public List<FieldMessage> getField() {
        return field;
    }

    public void addError(String fieldName, String fieldMessage){
        field.add(new FieldMessage(fieldName,fieldMessage));
    }
}
