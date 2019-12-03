/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporte_rodoviario;

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
    private final String URL_CONEXAO = "jdbc:mariadb://localhost:3306/transporte_rodoviaria";
    
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
}
