package org.acme.funcionarios.api.v1;

import java.util.List;

import org.acme.funcionarios.domain.dto.request.FuncionarioRequest;
import org.acme.funcionarios.domain.dto.response.FuncionarioResponse;
import org.acme.funcionarios.domain.uc.DetalhaFuncionarioUC;
import org.acme.funcionarios.domain.uc.IncluirFuncionarioUC;
import org.acme.funcionarios.domain.uc.ListaTodosRegistrosUC;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@Path("/funcionarios")
@AllArgsConstructor
public class FuncionariosResource {

    private @NonNull ListaTodosRegistrosUC listaTodosRegistrosUC;
    private @NonNull DetalhaFuncionarioUC  detalhaFuncionarioUC;
    private @NonNull IncluirFuncionarioUC  incluirFuncionarioUC;

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FuncionarioResponse> listaTodos() {
        return listaTodosRegistrosUC.execute();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public FuncionarioResponse detalha(@PathParam("id") Long id) {
        return detalhaFuncionarioUC.execute(id).get();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public FuncionarioResponse inserir(@Valid FuncionarioRequest funcionario){
        return incluirFuncionarioUC.execute(funcionario);
    }

}
