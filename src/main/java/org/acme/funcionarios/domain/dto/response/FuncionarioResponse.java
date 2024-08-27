package org.acme.funcionarios.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class FuncionarioResponse {

    private Long id;
    private String cpf;
    private String nome;
    private Double salario;
    
}
