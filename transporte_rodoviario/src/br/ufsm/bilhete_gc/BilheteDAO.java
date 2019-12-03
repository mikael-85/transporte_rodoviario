/* Arquivo gerado automaticamente */

package br.ufsm.bilhete_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class BilheteDAO implements EntidadeDAO<BilheteModelo> {
private ConexaoBD bd;
private InputOutputTela tela;

public BilheteDAO(InputOutputTela tela){
   this.bd = new ConexaoBD();
   this.tela = tela;
}

@Override
public void cadastrar(BilheteModelo bilhete){
   Connection conexao = null;
   PreparedStatement sql = null;
   try {
      conexao = this.bd.getConexao();
      sql = conexao.prepareStatement(
      "INSERT INTO bilhete (idPoltrona, idViagem, nomeCliente) VALUES (?, ?, ?)");
       sql.setLong(1, bilhete.getidPoltrona());
       sql.setLong(2, bilhete.getidViagem());
       sql.setString(3, bilhete.getnomeCliente());
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
public void alterar(BilheteModelo bilhete){
   try {
      Connection conexao = this.bd.getConexao();
      PreparedStatement sql = conexao.prepareStatement(
      "UPDATE bilhete SET idViagem = ?, nomeCliente = ? WHERE idPoltrona = ?");
       sql.setLong(3, bilhete.getidPoltrona());
       sql.setLong(1, bilhete.getidViagem());
       sql.setString(2, bilhete.getnomeCliente());
       sql.execute();
       this.tela.sucessoAlteracao();
       sql.close();
       conexao.close();
   } catch (SQLException ex) {
       System.err.println(ex.getMessage());
   }
}

@Override
public void remover(BilheteModelo bilhete){
   try {
       Connection conexao = this.bd.getConexao();
       PreparedStatement sql = conexao.prepareStatement(
       "DELETE FROM bilhete WHERE idPoltrona = ?");
       sql.setLong(1, bilhete.getidPoltrona());
       sql.execute();
       this.tela.sucessoExclusao();
       sql.close();
       conexao.close();

   } catch (SQLException ex) {
       System.err.println(ex.getMessage());
   }
}

@Override
public ArrayList<BilheteModelo> pesquisar(BilheteModelo bilhete){
   ArrayList<BilheteModelo> resultadosConsulta = new ArrayList<BilheteModelo>();
   try {
       Connection conexao = this.bd.getConexao();
       PreparedStatement sql = conexao.prepareStatement(
       "SELECT * FROM bilhete WHERE idPoltrona = ?");
       sql.setLong(1, bilhete.getidPoltrona());
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
public ArrayList<BilheteModelo> imprimirTodos(){
   ArrayList<BilheteModelo> resultadosConsulta = new ArrayList<BilheteModelo>();
   try {
       Connection conexao = this.bd.getConexao();
       PreparedStatement sql = conexao.prepareStatement(
       "SELECT * FROM bilhete");
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
public ArrayList<BilheteModelo> resultadoConsulta(ResultSet resposta){
   ArrayList<BilheteModelo> resultados = new ArrayList<BilheteModelo>();
   try {
       while(resposta.next()){
           BilheteModelo atual = new BilheteModelo();
           atual.setidPoltrona(resposta.getLong("idPoltrona"));
           atual.setidViagem(resposta.getLong("idViagem"));
           atual.setnomeCliente(resposta.getString("nomeCliente"));
           resultados.add(atual);
       }
   } catch (SQLException ex){
       System.err.println(ex.getMessage());
   }
   return resultados;
}
}
