/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufsm.gerador_cruds2;

import java.util.ArrayList;

/**
 *
 * @author Patrick Guerra
 */
public class CriaClassesEntidade implements Runnable {
    MetadataEntidadeModelo tabela;
    ArrayList<String> cabecalho;
    ManipulaArquivos manipulaArquivos;

    public CriaClassesEntidade(MetadataEntidadeModelo tabela) {
        this.tabela = tabela;
        this.cabecalho = null;
        this.manipulaArquivos = null;
    }
    
    @Override
    public void run () {
        // Cria uma instancia de ManipulaArquivos como o caminho para o 
        // pacote dessa entidade
        this.manipulaArquivos = new ManipulaArquivos(this.tabela.getNomeEntidade()+"_gc");
        
        // Criar a pasta do pacote da entidade atual
        this.manipulaArquivos.criarPasta();
        
        // Cria cabecalho dos arquivos/classes
        this.cabecalho = new ArrayList<String>();
        this.cabecalho.add("/* Arquivo gerado automaticamente */");
        this.cabecalho.add("");
        this.cabecalho.add("package br.ufsm."+this.tabela.getNomeEntidade()+"_gc;");
        this.cabecalho.add("");
        this.cabecalho.add("import br.ufsm.gerador_cruds2.*;");
        this.cabecalho.add("import java.sql.Date;");
        this.cabecalho.add("");
        
        // Criar pacote
        // this.manipulaArquivos.gravarNoFinalDoArquivo("", null);
        
        // Contruido classe Modelo, passando o cabecalho e os dados da entidade
        CriaClasseModelo classeModelo = new CriaClasseModelo(
                this.tabela, 
                this.cabecalho,
                this.manipulaArquivos
        );
        Thread threadCriaModelo = new Thread(classeModelo);
        
        // Contruido classe DAO, passando o cabecalho e os dados da entidade
        CriaClasseDAO classeDAO = new CriaClasseDAO(
                this.tabela, 
                this.cabecalho,
                this.manipulaArquivos
        );
        Thread threadCriaDAO = new Thread(classeDAO);
        
        CriaClasseExemplo classeExemplo = new CriaClasseExemplo(
                this.tabela, 
                this.cabecalho,
                this.manipulaArquivos
        );
        Thread threadCriaExemplo = new Thread(classeExemplo);
        
        CriaClassePrincipal classePrincipal = new CriaClassePrincipal(
                this.tabela, 
                this.cabecalho,
                this.manipulaArquivos
        );
        Thread threadCriaPrincipal = new Thread(classePrincipal);
        
        // Executando as Threads
        threadCriaModelo.start();
        threadCriaDAO.start();
        threadCriaExemplo.start();
        threadCriaPrincipal.start();
    }    

}
