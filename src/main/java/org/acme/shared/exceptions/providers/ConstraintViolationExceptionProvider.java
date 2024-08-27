package org.acme.shared.exceptions.providers;

import java.util.Iterator;

import org.acme.shared.exceptions.Problem;
import org.acme.shared.exceptions.ProblemObject;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationExceptionProvider implements ExceptionMapper<ConstraintViolationException>{

    @Override
    public Response toResponse(ConstraintViolationException e) {
        Problem problem = new Problem(e);

        e.getConstraintViolations().forEach( (c) -> {
            problem.messages
                    .add(new ProblemObject(lastFieldName(c.getPropertyPath().iterator()), c.getMessage()));
        } );

        return Response.status(Status.BAD_REQUEST).entity(problem).type(MediaType.APPLICATION_JSON).build();
    }

    String lastFieldName(Iterator<Path.Node> nodes){
        Path.Node last = null;
        while(nodes.hasNext()){
            last = nodes.next();
        }

        return last.getName();
    }
    
}
