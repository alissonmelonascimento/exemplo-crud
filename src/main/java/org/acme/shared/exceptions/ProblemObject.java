package org.acme.shared.exceptions;

import lombok.Getter;

@Getter
public class ProblemObject {

    public String name;
    public String message;

    public ProblemObject(String name, String message) {
        this.name = name;
        this.message = message;
    }
    
}
