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
public class CriaClasseModelo implements Runnable {
    MetadataEntidadeModelo tabela;
    ArrayList<String> linhas; // linhas Arquivo
    ManipulaArquivos manipulaArquivos;

    public CriaClasseModelo(MetadataEntidadeModelo tabela, ArrayList<String> cabecalho, ManipulaArquivos manipulaArquivos) {
        this.tabela = tabela;
        this.linhas = new ArrayList<String>();
        // copia as linhas do cabecalho
        for (String string : cabecalho) {
            this.linhas.add(string);
        }
        this.manipulaArquivos = manipulaArquivos;
    }
    
        
    
    
    @Override
    public void run () {
        String classe = this.tabela.getNomeEntidade();
        classe = classe.substring(0,1).toUpperCase().concat(classe.substring(1));
        this.linhas.add("public class " + classe + "Modelo implements EntidadeModelo {");
        this.linhas.add("/* Atributos */");
        for (MetadataAtributoModelo atributoAtual : this.tabela.getAtributosEntidade()) {
            this.linhas.add("private " + atributoAtual.tipoToString()  + 
                    " " + atributoAtual.getNomeAtributo() + ";"
            );
        }
        this.linhas.add("");
        this.linhas.add("/* Metodos Get e Set */");
        for (MetadataAtributoModelo atributoAtual : this.tabela.getAtributosEntidade()) {
            
            // get
            this.linhas.add("public " + atributoAtual.tipoToString() + 
                    " get" + atributoAtual.getNomeAtributo() + "() {"
            );
            this.linhas.add("    return this." + atributoAtual.getNomeAtributo()+";");
            this.linhas.add("}");
            this.linhas.add("");
            
            // set  
            this.linhas.add("public void " +
                    "set" + atributoAtual.getNomeAtributo() + "(" +
                    atributoAtual.tipoToString()
                    + " " + atributoAtual.getNomeAtributo() + ") {"
            );
            this.linhas.add("    this." + atributoAtual.getNomeAtributo()+
                    " = " + atributoAtual.getNomeAtributo() + ";");
            this.linhas.add("}");
            this.linhas.add("");
        }
        
        // toString 
        this.linhas.add("@Override");
        this.linhas.add("public String toString() {");
        this.linhas.add("   String print = \"\""+";");
        for (MetadataAtributoModelo atributoAtual : this.tabela.getAtributosEntidade()) {
            this.linhas.add("   print += \"" + atributoAtual.getNomeAtributo() 
                + ": \" + this.get" + atributoAtual.getNomeAtributo()+ "() + \"\\n\" "+";"
            );
        }
        this.linhas.add("   return print;");
        this.linhas.add("}");
        
        // final da classe
        this.linhas.add("}");
        
        // salvar linhas no arquivo
        String nomeArquivo = classe + "Modelo.java";
        this.manipulaArquivos.gravarNoFinalDoArquivoArray(
            nomeArquivo, 
            this.linhas
        );
    }
}
