package org.acme.funcionarios.application;

import org.acme.funcionarios.domain.dto.request.FuncionarioRequest;
import org.acme.funcionarios.domain.dto.response.FuncionarioResponse;
import org.acme.funcionarios.domain.repository.FuncionarioRepository;
import org.acme.funcionarios.domain.uc.IncluirFuncionarioUC;
import org.acme.shared.exceptions.BusinessException;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class IncluirFuncionarioUCImpl implements IncluirFuncionarioUC{

    @Inject
    FuncionarioRepository funcionarioRepository;

    //injetando propriedade presente no application.property
    @ConfigProperty(name = "SALARIO_MAXIMO")
    Double salarioMaximo;


    @Override
    public FuncionarioResponse execute(final FuncionarioRequest funcionario) {

        if(funcionario.getSalario() > salarioMaximo){
            throw new BusinessException("Salário muito alto");
        }

        return funcionarioRepository.persist(funcionario);
    }
    
}
