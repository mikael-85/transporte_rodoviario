/* Arquivo gerado automaticamente */

package br.ufsm.trecho_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class TrechoDAO implements EntidadeDAO<TrechoModelo> {
private ConexaoBD bd;
private InputOutputTela tela;

public TrechoDAO(InputOutputTela tela){
   this.bd = new ConexaoBD();
   this.tela = tela;
}

@Override
public void cadastrar(TrechoModelo trecho){
   Connection conexao = null;
   PreparedStatement sql = null;
   try {
      conexao = this.bd.getConexao();
      sql = conexao.prepareStatement(
      "INSERT INTO trecho (idTrecho, idCidadeOrigem, idCidadeDestino) VALUES (?, ?, ?)");
       sql.setLong(1, trecho.getidTrecho());
       sql.setLong(2, trecho.getidCidadeOrigem());
       sql.setLong(3, trecho.getidCidadeDestino());
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
public void alterar(TrechoModelo trecho){
   try {
      Connection conexao = this.bd.getConexao();
      PreparedStatement sql = conexao.prepareStatement(
      "UPDATE trecho SET idCidadeOrigem = ?, idCidadeDestino = ? WHERE idTrecho = ?");
       sql.setLong(3, trecho.getidTrecho());
       sql.setLong(1, trecho.getidCidadeOrigem());
       sql.setLong(2, trecho.getidCidadeDestino());
       sql.execute();
       this.tela.sucessoAlteracao();
       sql.close();
       conexao.close();
   } catch (SQLException ex) {
       System.err.println(ex.getMessage());
   }
}

@Override
public void remover(TrechoModelo trecho){
   try {
       Connection conexao = this.bd.getConexao();
       PreparedStatement sql = conexao.prepareStatement(
       "DELETE FROM trecho WHERE idTrecho = ?");
       sql.setLong(1, trecho.getidTrecho());
       sql.execute();
       this.tela.sucessoExclusao();
       sql.close();
       conexao.close();

   } catch (SQLException ex) {
       System.err.println(ex.getMessage());
   }
}

@Override
public ArrayList<TrechoModelo> pesquisar(TrechoModelo trecho){
   ArrayList<TrechoModelo> resultadosConsulta = new ArrayList<TrechoModelo>();
   try {
       Connection conexao = this.bd.getConexao();
       PreparedStatement sql = conexao.prepareStatement(
       "SELECT * FROM trecho WHERE idTrecho = ?");
       sql.setLong(1, trecho.getidTrecho());
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
public ArrayList<TrechoModelo> imprimirTodos(){
   ArrayList<TrechoModelo> resultadosConsulta = new ArrayList<TrechoModelo>();
   try {
       Connection conexao = this.bd.getConexao();
       PreparedStatement sql = conexao.prepareStatement(
       "SELECT * FROM trecho");
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
public ArrayList<TrechoModelo> resultadoConsulta(ResultSet resposta){
   ArrayList<TrechoModelo> resultados = new ArrayList<TrechoModelo>();
   try {
       while(resposta.next()){
           TrechoModelo atual = new TrechoModelo();
           atual.setidTrecho(resposta.getLong("idTrecho"));
           atual.setidCidadeOrigem(resposta.getLong("idCidadeOrigem"));
           atual.setidCidadeDestino(resposta.getLong("idCidadeDestino"));
           resultados.add(atual);
       }
   } catch (SQLException ex){
       System.err.println(ex.getMessage());
   }
   return resultados;
}
}
