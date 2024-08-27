package org.acme.funcionarios.domain.uc;

import org.acme.funcionarios.domain.dto.request.FuncionarioRequest;
import org.acme.funcionarios.domain.dto.response.FuncionarioResponse;

public interface IncluirFuncionarioUC {

    FuncionarioResponse execute(FuncionarioRequest funcionario);
    
}
