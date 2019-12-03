/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufsm.gerador_cruds2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Patrick Guerra
 */
public class Metadata {
    private ConexaoBD conexaoBD = null;
    private Connection conexao = null;
    private DatabaseMetaData metadata = null;
    private ArrayList<MetadataEntidadeModelo> tabelas = null;

    /**
     * Instancia a conexao com BD e salva na variavel da classe
     * e obtem uma instancia de MetaData com base na conexao e salva na 
     * variavel da classe.
     */
    public Metadata() {
        this.conexaoBD = new ConexaoBD();
        this.conexao = conexaoBD.getConexao();
        try {
            this.metadata = this.conexao.getMetaData();
            obterMetadadosBD();
        } catch (SQLException | NullPointerException ex) {
            System.err.println("Erro: Nao foi possivel obter Meta Data do BD!");
            System.err.println(ex.getMessage());
            //Logger.getLogger(Metadata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Obtem os MetaDados do BD
     */
    public void obterMetadadosBD(){
        //this.conexao = conexaoBD.getConexao();
        this.obterTabelasMetadata();
        this.obterAtributosMetadata();
// TESTE imprimir tabelas e atributos
        System.out.println("Tabelas:");
        for (MetadataEntidadeModelo tabelaAtual : this.tabelas) {
            System.out.println("Tabela: "+tabelaAtual.getNomeEntidade());
            System.out.println("Atributos:");
            System.out.println("");
            for (MetadataAtributoModelo atual : tabelaAtual.getAtributosEntidade()) {
                System.out.println("Nome Atributo: "+atual.getNomeAtributo());
                System.out.println("Tipo Atributo: "+atual.getTipoAtributo());
                System.out.println("Tamanho Atributo: "+atual.getTamanhoAtributo());
                System.out.println("Valor Teste: "+atual.getValorString());
                System.out.println("");
            }
        }
// fim teste        
        try {
            this.conexao.close();
        } catch (SQLException ex) {
            System.err.println("Erro: Nao foi possivel fechar a conexao com o BD!");
            System.err.println(ex.getMessage());
            //Logger.getLogger(Metadata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Obtem os nomes das tabelas / entidades do BD e grava no ArrayList tabelas
     */
    public void obterTabelasMetadata(){
        String table[] = { "TABLE" };
        ResultSet rs = null;
        this.tabelas = new ArrayList<MetadataEntidadeModelo>();
        try {
            rs = this.metadata.getTables(conexaoBD.getNOME_BD(), null, null, table);
        } catch (SQLException ex) {
            System.err.println("Erro: Nao foi possivel obter as entidades do BD!");
            System.err.println(ex.getMessage());
            //Logger.getLogger(Metadata.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            // Continuar enquanto: 
            // - O ResultSet nao for nulo
            // - A conexao nao foi fechada
            // - Existe um proximo elemento no ResultSet
            while (rs != null && !rs.isClosed() && rs.next()) {
                MetadataEntidadeModelo tabelaAtual = new MetadataEntidadeModelo();
                tabelaAtual.setNomeEntidade(rs.getString("TABLE_NAME"));
                this.tabelas.add(tabelaAtual);
            }
        } catch (SQLException ex) {
            System.err.println("Erro: Metadata SQLException: " + ex.getMessage());
            //Logger.getLogger(Metadata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void obterAtributosMetadata(){
        ResultSet rs = null;
        for (MetadataEntidadeModelo tabelaAtual : this.tabelas) {
            try {
                rs = this.metadata.getColumns(null, null, tabelaAtual.getNomeEntidade(), null);
                
                while (rs.next()) {
                    
                    MetadataAtributoModelo novoAtributo = new MetadataAtributoModelo(
                        rs.getString("COLUMN_NAME"),
                        rs.getString("TYPE_NAME"),
                        Integer.valueOf( rs.getString("COLUMN_SIZE") ),
                        converterTipo( 
                            rs.getString("TYPE_NAME"), 
                            Integer.valueOf( rs.getString("COLUMN_SIZE") )
                        )
                    );
                    tabelaAtual.adicionarAtributo(novoAtributo);
                }
            } catch (SQLException ex) {
                System.err.println("Erro: Nao foi possivel obter os atributos "+
                    "da tabela: "+tabelaAtual.getNomeEntidade() +"! "+
                    ex.getMessage()
                );
                //Logger.getLogger(Metadata.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Recebe o tipoVariavel do BD e converte para um tipoVariavel Java valido usando Generics
     *
     * @param tipoVariavel do atributo no BD
     * @param tamanho do atributo no BD
     * @return Generico conforme o tipoVariavel recebido (Generics)
     */
    public Object converterTipo(String tipoVariavel, int tamanho){
        Object novoTipo;
        if(
            tipoVariavel.compareToIgnoreCase("varchar") == 0 ||
            tipoVariavel.compareToIgnoreCase("char") == 0 ||
            tipoVariavel.compareToIgnoreCase("character") == 0 ||
            tipoVariavel.compareToIgnoreCase("character varying") == 0 ||
            tipoVariavel.compareToIgnoreCase("text") == 0
        ){
            String valor = "";
            //novoTipo = new Tipo<String>(valor);
            novoTipo = valor;
        }else if(
            tipoVariavel.compareToIgnoreCase("integer") == 0 ||
            tipoVariavel.compareToIgnoreCase("int") == 0  ||
            tipoVariavel.compareToIgnoreCase("year") == 0  ||
            tipoVariavel.contains("int")
        ){
            if(tamanho <= 9){
                Integer valor = 0;
                novoTipo = valor;
            }else{
                Long valor = new Long(0);
                novoTipo = valor;
            }
            //novoTipo = new Tipo<Integer>(valor);
        }else if(tipoVariavel.compareToIgnoreCase("bigint") == 0){
            Long valor = new Long(0);
            //novoTipo = new Tipo<Long>(valor);
            novoTipo = valor;
        }else if(tipoVariavel.compareToIgnoreCase("date") == 0){
            Date valor = null;
            String dataString = "01/01/2000";
            DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy"); 
            try {
                valor = new java.sql.Date(fmt.parse(dataString).getTime());
            } catch (ParseException ex) {
                //Logger.getLogger(InputOutputTela.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println(ex.toString());
            }
            //novoTipo = new Tipo<Long>(valor);
            novoTipo = valor;
        }else{
            String valor = "";
            //novoTipo = new Tipo<String>(valor);
            novoTipo = valor;
        }
        return novoTipo;
    }

    public ArrayList<MetadataEntidadeModelo> getTabelas() {
        return tabelas;
    }
    
}
