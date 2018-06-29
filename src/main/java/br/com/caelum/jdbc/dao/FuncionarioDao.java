package br.com.caelum.jdbc.dao;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioDao {
    private Connection connection;
    public FuncionarioDao(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criaTabelaFuncionario(){
        String sql = "create table funcionarios (" +
                "id BIGINT NOT NULL AUTO_INCREMENT," +
                "nome VARCHAR(255)," +
                "usuario VARCHAR(255)," +
                "senha VARCHAR(255)," +
                "primary key (id)" +
                ");";
        try{
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.execute();
            System.out.println("Table criada!");
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void adiciona(Funcionario funcionario){
        String sql = "insert into funcionarios (nome, usuario, senha) values (?,?,?)";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getUsuario());
            statement.setString(3, funcionario.getSenha());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void remove(Funcionario funcionario){
        try{
            PreparedStatement statement = this.connection.prepareStatement("delete from funcionarios where id=?");
            statement.setLong(1, funcionario.getId());
            statement.execute();
            statement.close();
            System.out.println("Funcionário removido");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
