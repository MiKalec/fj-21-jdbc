package br.com.caelum.jdbc.dao;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContatoDao {
    private Connection connection;

    public ContatoDao(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Contato contato){
        String sql = "insert into contatos " +
                "(nome,email,endereco,dataNascimento)" +
                " values (?,?,?,?)";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, contato.getNome());
            statement.setString(2, contato.getEmail());
            statement.setString(3, contato.getEndereco());
            statement.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

            statement.execute();
            statement.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
