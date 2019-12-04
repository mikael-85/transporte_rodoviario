/* Arquivo gerado automaticamente */

package br.ufsm.viagem_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import br.ufsm.bilhete_gc.BilheteDAO;
import br.ufsm.bilhete_gc.BilheteModelo;

public class ViagemDAO implements EntidadeDAO<ViagemModelo> {
private ConexaoBD bd;
private InputOutputTela tela;
private BilheteDAO bilhete;

public ViagemDAO(InputOutputTela tela){
   this.bd = new ConexaoBD();
   this.tela = tela;
   this.bilhete = new BilheteDAO(tela);
}

public void cadastrarBilhetesSemReserva(ViagemModelo viagem){
    int numeroDePoltronas = 0;
    try {
        Connection conexao = this.bd.getConexao();
        PreparedStatement sql = conexao.prepareStatement(
        "select numeroDePoltronas from Marca where idMarca in (select idMarca from Onibus where idOnibus in (select idOnibus from Viagem where idViagem = ?))");
        sql.setLong(1, viagem.getidViagem());
        ResultSet resultado = sql.executeQuery();
        try {
            while(resultado.next()){
                numeroDePoltronas = (int)resultado.getLong("numeroDePoltronas");
            }
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
        resultado.close();
        sql.close();
        conexao.close();
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    //select numeroDePoltronas from Marca where idMarca in (select idMarca from Onibus where idOnibus in (select idOnibus from Viagem where idViagem = 1));
    for (int i = 1; i <= numeroDePoltronas; i++) {
        BilheteModelo novoBilhete = new BilheteModelo();
        novoBilhete.setidViagem(viagem.getidViagem());
        novoBilhete.setidPoltrona(new Long(i));
        novoBilhete.setnomeCliente(null);
        novoBilhete.setdataReserva(null);
        novoBilhete.sethoraReserva(null);
        this.bilhete.cadastrar(novoBilhete);
    }
}

@Override
public void cadastrar(ViagemModelo viagem){
   Connection conexao = null;
   PreparedStatement sql = null;
   try {
      conexao = this.bd.getConexao();
      sql = conexao.prepareStatement(
      "INSERT INTO viagem (idViagem, idOnibus, idTrecho, dataOrigem, horaOrigem, dataDestino, horaDestino) VALUES (?, ?, ?, ?, ?, ?, ?)");
       sql.setLong(1, viagem.getidViagem());
       sql.setLong(2, viagem.getidOnibus());
       sql.setLong(3, viagem.getidTrecho());
       sql.setDate(4, viagem.getdataOrigem());
       sql.setString(5, viagem.gethoraOrigem());
       sql.setDate(6, viagem.getdataDestino());
       sql.setString(7, viagem.gethoraDestino());
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
public void alterar(ViagemModelo viagem){
   try {
      Connection conexao = this.bd.getConexao();
      PreparedStatement sql = conexao.prepareStatement(
      "UPDATE viagem SET idOnibus = ?, idTrecho = ?, dataOrigem = ?, horaOrigem = ?, dataDestino = ?, horaDestino = ? WHERE idViagem = ?");
       sql.setLong(7, viagem.getidViagem());
       sql.setLong(1, viagem.getidOnibus());
       sql.setLong(2, viagem.getidTrecho());
       sql.setDate(3, viagem.getdataOrigem());
       sql.setString(4, viagem.gethoraOrigem());
       sql.setDate(5, viagem.getdataDestino());
       sql.setString(6, viagem.gethoraDestino());
       sql.execute();
       this.tela.sucessoAlteracao();
       sql.close();
       conexao.close();
   } catch (SQLException ex) {
       System.err.println(ex.getMessage());
   }
}

@Override
public void remover(ViagemModelo viagem){
   try {
       Connection conexao = this.bd.getConexao();
       PreparedStatement sql = conexao.prepareStatement(
       "DELETE FROM viagem WHERE idViagem = ?");
       sql.setLong(1, viagem.getidViagem());
       sql.execute();
       this.tela.sucessoExclusao();
       sql.close();
       conexao.close();

   } catch (SQLException ex) {
       System.err.println(ex.getMessage());
   }
}

@Override
public ArrayList<ViagemModelo> pesquisar(ViagemModelo viagem){
   ArrayList<ViagemModelo> resultadosConsulta = new ArrayList<ViagemModelo>();
   try {
       Connection conexao = this.bd.getConexao();
       PreparedStatement sql = conexao.prepareStatement(
       "SELECT * FROM viagem WHERE idViagem = ?");
       sql.setLong(1, viagem.getidViagem());
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
public ArrayList<ViagemModelo> imprimirTodos(){
   ArrayList<ViagemModelo> resultadosConsulta = new ArrayList<ViagemModelo>();
   try {
       Connection conexao = this.bd.getConexao();
       PreparedStatement sql = conexao.prepareStatement(
       "SELECT * FROM viagem");
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
public ArrayList<ViagemModelo> resultadoConsulta(ResultSet resposta){
   ArrayList<ViagemModelo> resultados = new ArrayList<ViagemModelo>();
   try {
       while(resposta.next()){
           ViagemModelo atual = new ViagemModelo();
           atual.setidViagem(resposta.getLong("idViagem"));
           atual.setidOnibus(resposta.getLong("idOnibus"));
           atual.setidTrecho(resposta.getLong("idTrecho"));
           atual.setdataOrigem(resposta.getDate("dataOrigem"));
           atual.sethoraOrigem(resposta.getString("horaOrigem"));
           atual.setdataDestino(resposta.getDate("dataDestino"));
           atual.sethoraDestino(resposta.getString("horaDestino"));
           resultados.add(atual);
       }
   } catch (SQLException ex){
       System.err.println(ex.getMessage());
   }
   return resultados;
}
}
