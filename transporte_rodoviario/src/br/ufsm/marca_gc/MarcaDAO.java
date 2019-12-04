/* Arquivo gerado automaticamente */

package br.ufsm.marca_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class MarcaDAO implements EntidadeDAO<MarcaModelo> {
private ConexaoBD bd;
private InputOutputTela tela;

public MarcaDAO(InputOutputTela tela){
   this.bd = new ConexaoBD();
   this.tela = tela;
}

@Override
public void cadastrar(MarcaModelo marca){
   Connection conexao = null;
   PreparedStatement sql = null;
   try {
      conexao = this.bd.getConexao();
      sql = conexao.prepareStatement(
      "INSERT INTO marca (idMarca, nomeMarca, numeroDePoltronas) VALUES (?, ?, ?)");
       sql.setLong(1, marca.getidMarca());
       sql.setString(2, marca.getnomeMarca());
       sql.setLong(3, marca.getnumeroDePoltronas());
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
public void alterar(MarcaModelo marca){
   try {
      Connection conexao = this.bd.getConexao();
      PreparedStatement sql = conexao.prepareStatement(
      "UPDATE marca SET nomeMarca = ?, numeroDePoltronas = ? WHERE idMarca = ?");
       sql.setLong(3, marca.getidMarca());
       sql.setString(1, marca.getnomeMarca());
       sql.setLong(2, marca.getnumeroDePoltronas());
       sql.execute();
       this.tela.sucessoAlteracao();
       sql.close();
       conexao.close();
   } catch (SQLException ex) {
       System.err.println(ex.getMessage());
   }
}

@Override
public void remover(MarcaModelo marca){
   try {
       Connection conexao = this.bd.getConexao();
       PreparedStatement sql = conexao.prepareStatement(
       "DELETE FROM marca WHERE idMarca = ?");
       sql.setLong(1, marca.getidMarca());
       sql.execute();
       this.tela.sucessoExclusao();
       sql.close();
       conexao.close();

   } catch (SQLException ex) {
       System.err.println(ex.getMessage());
   }
}

@Override
public ArrayList<MarcaModelo> pesquisar(MarcaModelo marca){
   ArrayList<MarcaModelo> resultadosConsulta = new ArrayList<MarcaModelo>();
   try {
       Connection conexao = this.bd.getConexao();
       PreparedStatement sql = conexao.prepareStatement(
       "SELECT * FROM marca WHERE idMarca = ?");
       sql.setLong(1, marca.getidMarca());
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
public ArrayList<MarcaModelo> imprimirTodos(){
   ArrayList<MarcaModelo> resultadosConsulta = new ArrayList<MarcaModelo>();
   try {
       Connection conexao = this.bd.getConexao();
       PreparedStatement sql = conexao.prepareStatement(
       "SELECT * FROM marca");
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
public ArrayList<MarcaModelo> resultadoConsulta(ResultSet resposta){
   ArrayList<MarcaModelo> resultados = new ArrayList<MarcaModelo>();
   try {
       while(resposta.next()){
           MarcaModelo atual = new MarcaModelo();
           atual.setidMarca(resposta.getLong("idMarca"));
           atual.setnomeMarca(resposta.getString("nomeMarca"));
           atual.setnumeroDePoltronas(resposta.getLong("numeroDePoltronas"));
           resultados.add(atual);
       }
   } catch (SQLException ex){
       System.err.println(ex.getMessage());
   }
   return resultados;
}
}
