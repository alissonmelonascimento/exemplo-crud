package org.acme.funcionarios.domain.uc;

import java.util.Optional;

import org.acme.funcionarios.domain.dto.response.FuncionarioResponse;

public interface DetalhaFuncionarioUC {

    Optional<FuncionarioResponse> execute(Long id);
    
}
