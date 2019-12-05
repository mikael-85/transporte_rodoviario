/* Arquivo gerado automaticamente */

package br.ufsm.intermediaria_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class IntermediariaDAO implements EntidadeDAO<IntermediariaModelo> {
private ConexaoBD bd;
private InputOutputTela tela;

public IntermediariaDAO(InputOutputTela tela){
   this.bd = new ConexaoBD();
   this.tela = tela;
}

@Override
public void cadastrar(IntermediariaModelo intermediaria){
   Connection conexao = null;
   PreparedStatement sql = null;
   try {
      conexao = this.bd.getConexao();
      sql = conexao.prepareStatement(
      "INSERT INTO intermediaria (idCidade, idTrecho, sequencia) VALUES (?, ?, ?)");
       sql.setLong(1, intermediaria.getidCidade());
       sql.setLong(2, intermediaria.getidTrecho());
       sql.setLong(3, intermediaria.getsequencia());
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
public void alterar(IntermediariaModelo intermediaria){
   try {
      Connection conexao = this.bd.getConexao();
      PreparedStatement sql = conexao.prepareStatement(
      "UPDATE intermediaria SET sequencia = ? WHERE idCidade = ? AND idTrecho = ?");
      sql.setLong(1, intermediaria.getsequencia());
       sql.setLong(2, intermediaria.getidCidade());
       sql.setLong(3, intermediaria.getidTrecho());
       
       sql.execute();
       this.tela.sucessoAlteracao();
       sql.close();
       conexao.close();
   } catch (SQLException ex) {
       System.err.println(ex.getMessage());
   }
}

@Override
public void remover(IntermediariaModelo intermediaria){
   try {
       Connection conexao = this.bd.getConexao();
       PreparedStatement sql = conexao.prepareStatement(
       "DELETE FROM intermediaria WHERE idCidade = ? AND idTrecho = ?");
       sql.setLong(1, intermediaria.getidCidade());
       sql.setLong(2, intermediaria.getidTrecho());
       sql.execute();
       this.tela.sucessoExclusao();
       sql.close();
       conexao.close();

   } catch (SQLException ex) {
       System.err.println(ex.getMessage());
   }
}

@Override
public ArrayList<IntermediariaModelo> pesquisar(IntermediariaModelo intermediaria){
   ArrayList<IntermediariaModelo> resultadosConsulta = new ArrayList<IntermediariaModelo>();
   try {
       Connection conexao = this.bd.getConexao();
       PreparedStatement sql = conexao.prepareStatement(
       "SELECT * FROM intermediaria WHERE idCidade = ? AND idTrecho = ?");
       sql.setLong(1, intermediaria.getidCidade());
       sql.setLong(2, intermediaria.getidTrecho());
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

public ArrayList<IntermediariaModelo> pesquisarTrecho(IntermediariaModelo intermediaria){
   ArrayList<IntermediariaModelo> resultadosConsulta = new ArrayList<IntermediariaModelo>();
   try {
       Connection conexao = this.bd.getConexao();
       PreparedStatement sql = conexao.prepareStatement(
       "SELECT * FROM intermediaria WHERE idTrecho = ? ORDER BY sequencia ASC");
       sql.setLong(1, intermediaria.getidTrecho());
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
public ArrayList<IntermediariaModelo> imprimirTodos(){
   ArrayList<IntermediariaModelo> resultadosConsulta = new ArrayList<IntermediariaModelo>();
   try {
       Connection conexao = this.bd.getConexao();
       PreparedStatement sql = conexao.prepareStatement(
       "SELECT * FROM intermediaria");
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
public ArrayList<IntermediariaModelo> resultadoConsulta(ResultSet resposta){
   ArrayList<IntermediariaModelo> resultados = new ArrayList<IntermediariaModelo>();
   try {
       while(resposta.next()){
           IntermediariaModelo atual = new IntermediariaModelo();
           atual.setidCidade(resposta.getLong("idCidade"));
           atual.setidTrecho(resposta.getLong("idTrecho"));
           atual.setsequencia(resposta.getLong("sequencia"));
           resultados.add(atual);
       }
   } catch (SQLException ex){
       System.err.println(ex.getMessage());
   }
   return resultados;
}

    public InputOutputTela getTela() {
        return tela;
    }

}
