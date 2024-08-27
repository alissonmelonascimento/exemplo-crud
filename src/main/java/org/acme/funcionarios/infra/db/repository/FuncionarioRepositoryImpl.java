package org.acme.funcionarios.infra.db.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.acme.funcionarios.domain.dto.request.FuncionarioRequest;
import org.acme.funcionarios.domain.dto.response.FuncionarioResponse;
import org.acme.funcionarios.domain.repository.FuncionarioRepository;

import io.agroal.api.AgroalDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@ApplicationScoped
@AllArgsConstructor
public class FuncionarioRepositoryImpl implements FuncionarioRepository{

    private @NonNull AgroalDataSource datasource;

    @Override
    public List<FuncionarioResponse> findAll() {

        List<FuncionarioResponse> funcionarios = new ArrayList<>();
        try (var con = datasource.getConnection();
             PreparedStatement ps = con.prepareStatement(" select * from public.funcionario ");) {

            try (java.sql.ResultSet rs = ps.executeQuery();) {
                while(rs.next()){
                    funcionarios.add(
                        FuncionarioResponse.builder()
                                .id(rs.getLong("id"))
                                .cpf(rs.getString("cpf"))
                                .nome(rs.getString("nome"))
                                .salario(rs.getDouble("salario"))
                            .build()
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionarios;
    }

    @Override
    public Optional<FuncionarioResponse> findById(final Long id) {
        
        try (var con = datasource.getConnection();
             PreparedStatement ps = con.prepareStatement(" select * from public.funcionario where id = ? ");) {
            ps.setLong(1, id);
            try (java.sql.ResultSet rs = ps.executeQuery();) {
                rs.next();

                return Optional.of(
                    FuncionarioResponse.builder()
                            .id(rs.getLong("id"))
                            .cpf(rs.getString("cpf"))
                            .nome(rs.getString("nome"))
                            .salario(rs.getDouble("salario"))
                        .build()
                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return Optional.empty();
    }

    @Override
    public FuncionarioResponse persist(FuncionarioRequest funcionario) {

        try (var con = datasource.getConnection();
             PreparedStatement ps = con.prepareStatement(" insert into public.funcionario(id, cpf, nome, salario) values(?, ?, ?, ?) ");) {

             ps.setLong(1, funcionario.getId());
             ps.setString(2, funcionario.getCpf());
             ps.setString(3, funcionario.getNome());
             ps.setDouble(4, funcionario.getSalario());

             ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return FuncionarioResponse.builder().id(funcionario.getId()).cpf(funcionario.getCpf())
                .nome(funcionario.getNome()).salario(funcionario.getSalario()).build();
    }
    
}
