/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsm.gerador_cruds2;

import transporte_rodoviario.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Patrick Guerra
 */
public class ConexaoBD {
    private final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    private final String SENHA = "";
    private final String USUARIO = "root"; 
    private final String NOME_BD = "transporte_rodoviario";
    private final String URL_CONEXAO = "jdbc:mariadb://localhost:3307/transporte_rodoviario?characterEncoding=Latin1&useTimezone=true&serverTimezone=UTC&connectionCollation=latin1_general_ci";
    
    public Connection getConexao(){
        Connection c = null;
        
        try {
            c = DriverManager.getConnection(this.URL_CONEXAO, this.USUARIO, this.SENHA);
        } catch (SQLException ex) {
            System.err.println("ERRO: nao foi possvivel estabelecer conexao com BD");
            System.err.println(ex.getMessage());
            //Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    public String getJDBC_DRIVER() {
        return JDBC_DRIVER;
    }

    public String getSENHA() {
        return SENHA;
    }

    public String getUSUARIO() {
        return USUARIO;
    }

    public String getNOME_BD() {
        return NOME_BD;
    }

    public String getURL_CONEXAO() {
        return URL_CONEXAO;
    }
    
}
