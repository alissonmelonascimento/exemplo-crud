package org.acme.funcionarios.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class FuncionarioRequest {

    @NotNull(message = "Informe a matrícula do funcionário")
    @Positive(message = "Informe um número positivo")
    private Long id;

    @NotBlank(message = "Informe o CPF do funcionário")
    @Pattern(message = "CPF inválido", regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")
    private String cpf;

    @NotBlank(message = "Informe o nome do funcionário")
    private String nome;
    
}
