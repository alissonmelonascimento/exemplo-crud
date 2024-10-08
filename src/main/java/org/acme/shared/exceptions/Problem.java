package org.acme.shared.exceptions;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.ConstraintViolationException;
import lombok.Getter;

@Getter
public class Problem {

    public int status;
    public OffsetDateTime timestamp;
    public String title;
    public String detail;
    public List<ProblemObject> messages;

    public Problem(){
        
    }

    public Problem(BusinessException e){
        this.status = 422;
        this.timestamp = OffsetDateTime.now();
        this.title = "Business";
        this.detail = e.getLocalizedMessage();
    }

    public Problem(ConstraintViolationException e){
        this.status = 400;
        this.timestamp = OffsetDateTime.now();
        this.title = "Invalid data";
        this.detail  = "Dados inválidos";
        this.messages = new ArrayList<>();
    }

}
