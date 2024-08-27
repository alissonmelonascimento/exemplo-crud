package org.acme.funcionarios.domain.uc;

import java.util.List;

import org.acme.funcionarios.domain.dto.response.FuncionarioResponse;

public interface ListaTodosRegistrosUC {

    public List<FuncionarioResponse> execute();
    
}
