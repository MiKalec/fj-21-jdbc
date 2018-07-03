package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "Mik@k@1234");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
