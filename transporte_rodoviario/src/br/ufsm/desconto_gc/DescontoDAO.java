/* Arquivo gerado automaticamente */
package br.ufsm.desconto_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class DescontoDAO implements EntidadeDAO<DescontoModelo> {

    private ConexaoBD bd;
    private InputOutputTela tela;

    public DescontoDAO(InputOutputTela tela) {
        this.bd = new ConexaoBD();
        this.tela = tela;
    }

    @Override
    public void cadastrar(DescontoModelo desconto) {
        Connection conexao = null;
        PreparedStatement sql = null;
        try {
            conexao = this.bd.getConexao();
            sql = conexao.prepareStatement(
                    "INSERT INTO desconto (dataInicio, dataTermino, horaInicio, horaTermino, desconto) VALUES (?, ?, ?, ?, ?)");
            sql.setDate(1, desconto.getdataInicio());
            sql.setDate(2, desconto.getdataTermino());
            sql.setString(3, desconto.gethoraInicio());
            sql.setString(4, desconto.gethoraTermino());
            sql.setString(5, desconto.getdesconto());
            sql.execute();
            this.tela.sucessoCadastro();

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
    public void alterar(DescontoModelo desconto) {
        try {
            Connection conexao = this.bd.getConexao();
            PreparedStatement sql = conexao.prepareStatement(
                    "UPDATE desconto SET desconto = ? WHERE dataInicio = ? AND dataTermino = ? AND horaInicio = ? AND horaTermino = ?");
            sql.setString(1, desconto.getdesconto());
            sql.setDate(2, desconto.getdataInicio());
            sql.setDate(3, desconto.getdataTermino());
            sql.setString(4, desconto.gethoraInicio());
            sql.setString(5, desconto.gethoraTermino());
            sql.execute();
            this.tela.sucessoAlteracao();
            sql.close();
            conexao.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void remover(DescontoModelo desconto) {
        try {
            Connection conexao = this.bd.getConexao();
            PreparedStatement sql = conexao.prepareStatement(
                    "DELETE FROM desconto WHERE dataInicio = ? AND dataTermino = ? AND horaInicio = ? AND horaTermino = ?");
            sql.setDate(1, desconto.getdataInicio());
            sql.setDate(2, desconto.getdataTermino());
            sql.setString(3, desconto.gethoraInicio());
            sql.setString(4, desconto.gethoraTermino());
            sql.execute();
            this.tela.sucessoExclusao();
            sql.close();
            conexao.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public ArrayList<DescontoModelo> pesquisar(DescontoModelo desconto) {
        ArrayList<DescontoModelo> resultadosConsulta = new ArrayList<DescontoModelo>();
        try {
            Connection conexao = this.bd.getConexao();
            PreparedStatement sql = conexao.prepareStatement(
                    "SELECT * FROM desconto WHERE dataInicio = ? AND dataTermino = ? AND horaInicio = ? AND horaTermino = ?");
            sql.setDate(1, desconto.getdataInicio());
            sql.setDate(2, desconto.getdataTermino());
            sql.setString(3, desconto.gethoraInicio());
            sql.setString(4, desconto.gethoraTermino());
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
    public ArrayList<DescontoModelo> imprimirTodos() {
        ArrayList<DescontoModelo> resultadosConsulta = new ArrayList<DescontoModelo>();
        try {
            Connection conexao = this.bd.getConexao();
            PreparedStatement sql = conexao.prepareStatement(
                    "SELECT * FROM desconto");
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
    public ArrayList<DescontoModelo> resultadoConsulta(ResultSet resposta) {
        ArrayList<DescontoModelo> resultados = new ArrayList<DescontoModelo>();
        try {
            while (resposta.next()) {
                DescontoModelo atual = new DescontoModelo();
                atual.setdataInicio(resposta.getDate("dataInicio"));
                atual.setdataTermino(resposta.getDate("dataTermino"));
                atual.sethoraInicio(resposta.getString("horaInicio"));
                atual.sethoraTermino(resposta.getString("horaTermino"));
                atual.setdesconto(resposta.getString("desconto"));
                resultados.add(atual);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultados;
    }
}
