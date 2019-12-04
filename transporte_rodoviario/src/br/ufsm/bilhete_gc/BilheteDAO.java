/* Arquivo gerado automaticamente */
package br.ufsm.bilhete_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import br.ufsm.desconto_gc.DescontoDAO;
import br.ufsm.desconto_gc.DescontoModelo;
import java.sql.Time;

public class BilheteDAO implements EntidadeDAO<BilheteModelo> {

    private ConexaoBD bd;
    private InputOutputTela tela;
    private DescontoDAO descontoDAO;

    public BilheteDAO(InputOutputTela tela) {
        this.bd = new ConexaoBD();
        this.tela = tela;
        this.descontoDAO = new DescontoDAO(tela);
    }

    @Override
    public void cadastrar(BilheteModelo bilhete) {
        Connection conexao = null;
        PreparedStatement sql = null;
        try {
            conexao = this.bd.getConexao();
            sql = conexao.prepareStatement(
                    "INSERT INTO bilhete (idPoltrona, idViagem, nomeCliente, dataReserva, horaReserva) VALUES (?, ?, ?, ?, ?)");
            sql.setLong(1, bilhete.getidPoltrona());
            sql.setLong(2, bilhete.getidViagem());
            sql.setString(3, bilhete.getnomeCliente());
            sql.setDate(4, bilhete.getdataReserva());
            sql.setString(5, bilhete.gethoraReserva());
            sql.execute();
            //this.tela.sucessoCadastro();

        } catch (SQLException ex) {
            this.tela.imprimeErro(ex.getMessage());
        } finally {
            try {
                if (sql != null) {
                    sql.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                this.tela.imprimeErro(e.getMessage());
            }
        }
    }

    @Override
    public void alterar(BilheteModelo bilhete) {
        try {
            Connection conexao = this.bd.getConexao();
            PreparedStatement sql = conexao.prepareStatement(
                    "UPDATE bilhete SET nomeCliente = ?, dataReserva = ?, horaReserva = ? WHERE idPoltrona = ? AND idViagem = ?");
            sql.setString(1, bilhete.getnomeCliente());
            sql.setDate(2, bilhete.getdataReserva());
            sql.setString(3, bilhete.gethoraReserva());
            sql.setLong(4, bilhete.getidPoltrona());
            sql.setLong(5, bilhete.getidViagem());
            sql.execute();
            this.tela.sucessoAlteracao();
            sql.close();
            conexao.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void remover(BilheteModelo bilhete) {
        try {
            Connection conexao = this.bd.getConexao();
            PreparedStatement sql = conexao.prepareStatement(
                    "UPDATE bilhete SET nomeCliente = NULL, dataReserva = NULL, horaReserva = NULL WHERE idPoltrona = ? AND idViagem = ?");
            sql.setLong(1, bilhete.getidPoltrona());
            sql.setLong(2, bilhete.getidViagem());
            sql.execute();
            //this.tela.sucessoExclusao();
            this.tela.exibe("Reserva removida com sucesso.");
            sql.close();
            conexao.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public ArrayList<BilheteModelo> pesquisar(BilheteModelo bilhete) {
        ArrayList<BilheteModelo> resultadosConsulta = new ArrayList<BilheteModelo>();
        try {
            Connection conexao = this.bd.getConexao();
            PreparedStatement sql = conexao.prepareStatement(
                    "SELECT * FROM bilhete WHERE idPoltrona = ? AND idViagem = ?");
            sql.setLong(1, bilhete.getidPoltrona());
            sql.setLong(2, bilhete.getidViagem());
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

    public ArrayList<BilheteModelo> pesquisarPoltronasDisponiveisNaViagem(BilheteModelo bilhete) {
        ArrayList<BilheteModelo> resultadosConsulta = new ArrayList<BilheteModelo>();
        try {
            Connection conexao = this.bd.getConexao();
            PreparedStatement sql = conexao.prepareStatement(
                    "SELECT * FROM bilhete WHERE idViagem = ? AND nomeCliente IS NULL");
            sql.setLong(1, bilhete.getidViagem());
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

    public ArrayList<BilheteModelo> pesquisarPoltronasNaoDisponiveisNaViagem(BilheteModelo bilhete) {
        ArrayList<BilheteModelo> resultadosConsulta = new ArrayList<BilheteModelo>();
        try {
            Connection conexao = this.bd.getConexao();
            PreparedStatement sql = conexao.prepareStatement(
                    "SELECT * FROM bilhete WHERE idViagem = ? AND nomeCliente IS NOT NULL");
            sql.setLong(1, bilhete.getidViagem());
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
    public ArrayList<BilheteModelo> imprimirTodos() {
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
    public ArrayList<BilheteModelo> resultadoConsulta(ResultSet resposta) {
        ArrayList<BilheteModelo> resultados = new ArrayList<BilheteModelo>();
        try {
            while (resposta.next()) {
                BilheteModelo atual = new BilheteModelo();
                atual.setidPoltrona(resposta.getLong("idPoltrona"));
                atual.setidViagem(resposta.getLong("idViagem"));
                atual.setnomeCliente(resposta.getString("nomeCliente"));
                atual.setdataReserva(resposta.getDate("dataReserva"));
                atual.sethoraReserva(resposta.getString("horaReserva"));
                resultados.add(atual);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultados;
    }

    public String verificaDesconto(BilheteModelo bilhete) {
        ArrayList<DescontoModelo> descontoTodos = this.descontoDAO.imprimirTodos();
        String desconto = "Bilhete sem desconto";
//        Time horaBilhete = Time.valueOf(bilhete.gethoraReserva());
        for (DescontoModelo descontoAtual : descontoTodos) {
//            Time horaDescontoInicio = Time.valueOf(descontoAtual.gethoraInicio());
//            Time horaDescontoTermino = Time.valueOf(descontoAtual.gethoraTermino());
            if (   bilhete.getdataReserva().getDate() >= descontoAtual.getdataInicio().getDate()
                && bilhete.getdataReserva().getMonth() >= descontoAtual.getdataInicio().getMonth()
                && bilhete.getdataReserva().getYear() >= descontoAtual.getdataInicio().getYear()
                    
                && bilhete.getdataReserva().getDate() <= descontoAtual.getdataTermino().getDate()
                && bilhete.getdataReserva().getMonth() <= descontoAtual.getdataTermino().getMonth()
                && bilhete.getdataReserva().getYear() <= descontoAtual.getdataTermino().getYear() 
                    
//                && horaBilhete.getHours() >= horaDescontoInicio.getHours()
//                && horaBilhete.getMinutes() >= horaDescontoInicio.getMinutes()
//                    
//                && horaBilhete.getHours() <= horaDescontoTermino.getHours()
//                && horaBilhete.getMinutes() <= horaDescontoTermino.getMinutes()
                ) {
                desconto = descontoAtual.getdesconto();
            }
        }
        return desconto;
    }
   }
