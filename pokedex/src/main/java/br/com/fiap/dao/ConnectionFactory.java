package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection;

    public static void closeConnection(){
        try {
            if(!connection.isClosed()){
                connection.close();
            }
        }catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static Connection getConnection(){
        try {
            if(connection != null && !connection.isClosed()){
                return connection;
            }else{
                Class.forName("oracle.jdbc.driver.OracleDriver"); // Evidenciando em que pacote está o Driver
                String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL"; // URL de conexão JDBC usada para conectar o Java a um banco de dados Oracle.
                String user = "rm563409";
                String password = "160507";
                connection = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro nome da classe: " + e.getMessage());
        }
        return connection;
    }
}
