package org.acme.funcionarios.application;

import java.util.Optional;

import org.acme.funcionarios.domain.dto.response.FuncionarioResponse;
import org.acme.funcionarios.domain.repository.FuncionarioRepository;
import org.acme.funcionarios.domain.uc.DetalhaFuncionarioUC;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@ApplicationScoped
@AllArgsConstructor
public class DetalhaFuncionarioUCImpl implements DetalhaFuncionarioUC{

    private @NonNull FuncionarioRepository funcionarioRepository;

    @Override
    public Optional<FuncionarioResponse> execute(Long id) {
        return funcionarioRepository.findById(id);
    }
    
}
