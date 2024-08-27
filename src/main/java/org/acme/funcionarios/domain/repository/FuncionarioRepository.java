package org.acme.funcionarios.domain.repository;

import java.util.List;
import java.util.Optional;

import org.acme.funcionarios.domain.dto.request.FuncionarioRequest;
import org.acme.funcionarios.domain.dto.response.FuncionarioResponse;

public interface FuncionarioRepository {

    List<FuncionarioResponse> findAll();
    Optional<FuncionarioResponse> findById(Long id);
    FuncionarioResponse persist(FuncionarioRequest funcionario);
    
}
