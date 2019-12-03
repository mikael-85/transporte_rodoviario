/* Arquivo gerado automaticamente */

package br.ufsm.cidade_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class CidadeDAO implements EntidadeDAO<CidadeModelo> {
private ConexaoBD bd;
private InputOutputTela tela;

public CidadeDAO(InputOutputTela tela){
   this.bd = new ConexaoBD();
   this.tela = tela;
}

@Override
public void cadastrar(CidadeModelo cidade){
   Connection conexao = null;
   PreparedStatement sql = null;
   try {
      conexao = this.bd.getConexao();
      sql = conexao.prepareStatement(
      "INSERT INTO cidade (idCidade, nomeCidade) VALUES (?, ?)");
       sql.setLong(1, cidade.getidCidade());
       sql.setString(2, cidade.getnomeCidade());
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
public void alterar(CidadeModelo cidade){
   try {
      Connection conexao = this.bd.getConexao();
      PreparedStatement sql = conexao.prepareStatement(
      "UPDATE cidade SET nomeCidade = ? WHERE idCidade = ?");
       sql.setLong(2, cidade.getidCidade());
       sql.setString(1, cidade.getnomeCidade());
       sql.execute();
       this.tela.sucessoAlteracao();
       sql.close();
       conexao.close();
   } catch (SQLException ex) {
       System.err.println(ex.getMessage());
   }
}

@Override
public void remover(CidadeModelo cidade){
   try {
       Connection conexao = this.bd.getConexao();
       PreparedStatement sql = conexao.prepareStatement(
       "DELETE FROM cidade WHERE idCidade = ?");
       sql.setLong(1, cidade.getidCidade());
       sql.execute();
       this.tela.sucessoExclusao();
       sql.close();
       conexao.close();

   } catch (SQLException ex) {
       System.err.println(ex.getMessage());
   }
}

@Override
public ArrayList<CidadeModelo> pesquisar(CidadeModelo cidade){
   ArrayList<CidadeModelo> resultadosConsulta = new ArrayList<CidadeModelo>();
   try {
       Connection conexao = this.bd.getConexao();
       PreparedStatement sql = conexao.prepareStatement(
       "SELECT * FROM cidade WHERE idCidade = ?");
       sql.setLong(1, cidade.getidCidade());
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
public ArrayList<CidadeModelo> imprimirTodos(){
   ArrayList<CidadeModelo> resultadosConsulta = new ArrayList<CidadeModelo>();
   try {
       Connection conexao = this.bd.getConexao();
       PreparedStatement sql = conexao.prepareStatement(
       "SELECT * FROM cidade");
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
public ArrayList<CidadeModelo> resultadoConsulta(ResultSet resposta){
   ArrayList<CidadeModelo> resultados = new ArrayList<CidadeModelo>();
   try {
       while(resposta.next()){
           CidadeModelo atual = new CidadeModelo();
           atual.setidCidade(resposta.getLong("idCidade"));
           atual.setnomeCidade(resposta.getString("nomeCidade"));
           resultados.add(atual);
       }
   } catch (SQLException ex){
       System.err.println(ex.getMessage());
   }
   return resultados;
}
}
