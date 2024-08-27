package org.acme.funcionarios.application;

import java.util.List;

import org.acme.funcionarios.domain.dto.response.FuncionarioResponse;
import org.acme.funcionarios.domain.repository.FuncionarioRepository;
import org.acme.funcionarios.domain.uc.ListaTodosRegistrosUC;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@ApplicationScoped
@AllArgsConstructor
public class ListaTodosRegistrosUCImpl implements ListaTodosRegistrosUC{

    @NonNull FuncionarioRepository funcionarioRepository;

    @Override
    public List<FuncionarioResponse> execute() {        
        return funcionarioRepository.findAll();
    }
    
}
