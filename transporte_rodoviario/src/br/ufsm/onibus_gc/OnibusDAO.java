/* Arquivo gerado automaticamente */

package br.ufsm.onibus_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class OnibusDAO implements EntidadeDAO<OnibusModelo> {
private ConexaoBD bd;
private InputOutputTela tela;

public OnibusDAO(InputOutputTela tela){
   this.bd = new ConexaoBD();
   this.tela = tela;
}

@Override
public void cadastrar(OnibusModelo onibus){
   Connection conexao = null;
   PreparedStatement sql = null;
   try {
      conexao = this.bd.getConexao();
      sql = conexao.prepareStatement(
      "INSERT INTO onibus (idOnibus, marcaModelo, numeroDePoltronas) VALUES (?, ?, ?)");
       sql.setLong(1, onibus.getidOnibus());
       sql.setString(2, onibus.getmarcaModelo());
       sql.setLong(3, onibus.getnumeroDePoltronas());
       sql.execute();
       this.tela.sucessoCadastro();

   } catch (SQLException ex) {
       this.tela.imprimeErro(ex.getMessage());
   }finally {
       try {
           if(sql != null){
               sql.close();
           }
           if(conexao != null){
               conexao.close();
           }
       } catch (SQLException e) {
           this.tela.imprimeErro(e.getMessage());
       }
   }
}

@Override
public void alterar(OnibusModelo onibus){
   try {
      Connection conexao = this.bd.getConexao();
      PreparedStatement sql = conexao.prepareStatement(
      "UPDATE onibus SET marcaModelo = ?, numeroDePoltronas = ? WHERE idOnibus = ?");
       sql.setLong(3, onibus.getidOnibus());
       sql.setString(1, onibus.getmarcaModelo());
       sql.setLong(2, onibus.getnumeroDePoltronas());
       sql.execute();
       this.tela.sucessoAlteracao();
       sql.close();
       conexao.close();
   } catch (SQLException ex) {
       System.err.println(ex.getMessage());
   }
}

@Override
public void remover(OnibusModelo onibus){
   try {
       Connection conexao = this.bd.getConexao();
       PreparedStatement sql = conexao.prepareStatement(
       "DELETE FROM onibus WHERE idOnibus = ?");
       sql.setLong(1, onibus.getidOnibus());
       sql.execute();
       this.tela.sucessoExclusao();
       sql.close();
       conexao.close();

   } catch (SQLException ex) {
       System.err.println(ex.getMessage());
   }
}

@Override
public ArrayList<OnibusModelo> pesquisar(OnibusModelo onibus){
   ArrayList<OnibusModelo> resultadosConsulta = new ArrayList<OnibusModelo>();
   try {
       Connection conexao = this.bd.getConexao();
       PreparedStatement sql = conexao.prepareStatement(
       "SELECT * FROM onibus WHERE idOnibus = ?");
       sql.setLong(1, onibus.getidOnibus());
       ResultSet resultado = sql.executeQuery();
       resultadosConsulta = resultadoConsulta(resultado);
       resultado.close();
       sql.close();
       conexao.close();
   } catch (SQLException ex) {
       System.err.println(ex.getMessage());
   }
   return resultadosConsulta;
}

@Override
public ArrayList<OnibusModelo> imprimirTodos(){
   ArrayList<OnibusModelo> resultadosConsulta = new ArrayList<OnibusModelo>();
   try {
       Connection conexao = this.bd.getConexao();
       PreparedStatement sql = conexao.prepareStatement(
       "SELECT * FROM onibus");
       ResultSet resultado = sql.executeQuery();
       resultadosConsulta = resultadoConsulta(resultado);
       resultado.close();
       sql.close();
       conexao.close();
   } catch (SQLException ex) {
       System.err.println(ex.getMessage());
   }
   return resultadosConsulta;
}

@Override
public ArrayList<OnibusModelo> resultadoConsulta(ResultSet resposta){
   ArrayList<OnibusModelo> resultados = new ArrayList<OnibusModelo>();
   try {
       while(resposta.next()){
           OnibusModelo atual = new OnibusModelo();
           atual.setidOnibus(resposta.getLong("idOnibus"));
           atual.setmarcaModelo(resposta.getString("marcaModelo"));
           atual.setnumeroDePoltronas(resposta.getLong("numeroDePoltronas"));
           resultados.add(atual);
       }
   } catch (SQLException ex){
       System.err.println(ex.getMessage());
   }
   return resultados;
}
}
