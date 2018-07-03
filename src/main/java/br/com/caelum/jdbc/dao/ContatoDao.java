package br.com.caelum.jdbc.dao;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

    public List<Contato> getLista(){
        try{
            List<Contato> contatos = new ArrayList<Contato>();
            PreparedStatement statement = this.connection.prepareStatement("select * from contatos");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Contato contato = new Contato();
                contato.setId(resultSet.getLong("id"));
                contato.setNome(resultSet.getString("nome"));
                contato.setEmail(resultSet.getString("email"));
                contato.setEndereco(resultSet.getString("endereco"));

                Calendar data = Calendar.getInstance();
                data.setTime(resultSet.getDate("dataNascimento"));
                contato.setDataNascimento(data);

                contatos.add(contato);
            }
            resultSet.close();
            statement.close();
            return contatos;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void altera(Contato contato){
        String sql = "update contatos set nome=?, email=?," +
                "endereco=?, dataNascimento=? where id=?";

        try{
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setString(1, contato.getNome());
            statement.setString(2, contato.getEmail());
            statement.setString(3, contato.getEndereco());
            statement.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
            statement.setLong(5, contato.getId());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Contato contato){
        try{
            PreparedStatement statement = this.connection.prepareStatement("delete from contatos where id=?");
            statement.setLong(1, contato.getId());
            statement.execute();
            statement.close();
            System.out.println("Contato removido");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Object pesquisar(Long id){
        String sql = "select * from contatos where id=?";

        try{
            PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            Contato contato = new Contato();
            contato.setId(resultSet.getLong("id"));
            contato.setNome(resultSet.getString("nome"));
            contato.setEmail(resultSet.getString("email"));
            contato.setEndereco(resultSet.getString("endereco"));

            Calendar data = Calendar.getInstance();
            data.setTime(resultSet.getDate("dataNascimento"));
            contato.setDataNascimento(data);
            statement.close();
            return contato;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
