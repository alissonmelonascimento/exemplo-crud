package org.acme.shared.exceptions.providers;

import org.acme.shared.exceptions.BusinessException;
import org.acme.shared.exceptions.Problem;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class BusinessExceptionsProvider implements ExceptionMapper<BusinessException>{

    @Override
    public Response toResponse(BusinessException e) {
        Problem problem = new Problem(e);
        return Response.status(422).entity(problem).type(MediaType.APPLICATION_JSON).build();
    }
    
}
