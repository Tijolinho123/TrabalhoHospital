/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsuldeminas.hospital.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 15843968650
 */

/*
A classe  ConnectionFactory é um exemplo clássico do padrão de design Singleton aplicado para gerenciar
conexões com um banco de dados em uma aplicação java. O objetivo da classe é encapsular a lógica para criar
conexões com o banco de dados e garantir que apenas uma instância da ConnectionFactory seja criada durante
o ciclo de vidade da aplicação

*/
public class ConnectionFactory {
    
    //Constantes requeridas para conexão
    //Constants required for connection
    private static final String DB_URL = "jdbc:mysql://localhost:3307/bdestudo?useSSL=false";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_USER = "root";
    private static final String DB_PASSWD = "1234";
    
    //Variável estática que mantém a instância única da classe.
    //Static variable that mantains a single instance of the class.
    private static ConnectionFactory instance;
    
    //O contrutor é privado para impedir a criação direta de instâncias da classe fora dela.
    //The constructor is made private to stop the direct creation of instances outside of itself.
    private ConnectionFactory() {
        
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver do banco de dados não encontrado!");
        }
        
    }
    
    /*
    Método públic estático que permite o acesso à instância única da
    ConnectionFactory: Padrão Singleton: Garante que apenas uma instância
    seja usada em toda aplicação.
    
    Public static method that grants acess to the single instance of 
    ConnectionFactory: Singleton pattern: Makes so only a single instance
    is used in the entire application.
    */
    public static ConnectionFactory getInstance() {
        
        if(instance==null) {
            instance = new ConnectionFactory();
        }
        
        return instance;
    
    }
 
    //Determina em qual banco conectar e com qual usuario
    //Determines wich DB to connect to and wich user
    public Connection getConnection() throws SQLException {
        
        return DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
        
    }
    
    public PreparedStatement getPreparedStatement(String sql) throws SQLException {

        Connection con = getConnection();
        
        return con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        
    }
    
}
