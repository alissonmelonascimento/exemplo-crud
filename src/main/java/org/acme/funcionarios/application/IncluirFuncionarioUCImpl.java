package org.acme.funcionarios.application;

import org.acme.funcionarios.domain.dto.request.FuncionarioRequest;
import org.acme.funcionarios.domain.dto.response.FuncionarioResponse;
import org.acme.funcionarios.domain.repository.FuncionarioRepository;
import org.acme.funcionarios.domain.uc.IncluirFuncionarioUC;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@ApplicationScoped
@AllArgsConstructor
public class IncluirFuncionarioUCImpl implements IncluirFuncionarioUC{

    private @NonNull FuncionarioRepository funcionarioRepository;

    @Override
    public FuncionarioResponse execute(final FuncionarioRequest funcionario) {
        return funcionarioRepository.persist(funcionario);
    }
    
}
