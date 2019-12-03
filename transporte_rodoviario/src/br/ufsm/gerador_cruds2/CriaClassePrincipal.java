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
public class CriaClassePrincipal implements Runnable{
    MetadataEntidadeModelo tabela;
    ArrayList<String> linhas; // linhas Arquivo
    ManipulaArquivos manipulaArquivos;

    public CriaClassePrincipal(MetadataEntidadeModelo tabela, ArrayList<String> cabecalho, ManipulaArquivos manipulaArquivos) {
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
        
        this.linhas.add("public class " + classe + "Principal {");
        this.linhas.add("");
        this.linhas.add("public static void main(String[] args) {");
            this.linhas.add("   InputOutputTela tela = new InputOutputTela<"+ classe +"Modelo"
                +">(\"" + classe + "\");");
            this.linhas.add("   " + classe + "Exemplo exemplo = new " + classe + "Exemplo(tela);");
            this.linhas.add("");
            this.linhas.add("   int opcao = -1;");
            this.linhas.add("   while(opcao != 0) {");
            this.linhas.add("       tela.exibe(\"CRUD gerado da tabela " + classe + " \");");
            this.linhas.add("       tela.exibe(\"Escolha uma opcao: \");");
            this.linhas.add("       tela.exibe(\"1 - Cadastrar " + classe + " \");");
            this.linhas.add("       tela.exibe(\"2 - Alterar " + classe + " \");");
            this.linhas.add("       tela.exibe(\"3 - Pesquisar " + classe + " \");");
            this.linhas.add("       tela.exibe(\"4 - Remover " + classe + " \");");
            this.linhas.add("       tela.exibe(\"5 - Imprimir Todos(as) " + classe + "s \");");
            this.linhas.add("       tela.exibe(\"0 - Sair \");");
            this.linhas.add("");
            this.linhas.add("       opcao = tela.leInteger();");
            this.linhas.add("");
            this.linhas.add("       switch (opcao) {");
            this.linhas.add("           case 1:");
            this.linhas.add("               exemplo.cadastrar();");
            this.linhas.add("               break;");
            this.linhas.add("           case 2:");
            this.linhas.add("               exemplo.alterar();");
            this.linhas.add("               break;");
            this.linhas.add("           case 3:");
            this.linhas.add("               exemplo.pesquisar();");
            this.linhas.add("               break;");
            this.linhas.add("           case 4:");
            this.linhas.add("               exemplo.remover();");
            this.linhas.add("               break;");
            this.linhas.add("           case 5:");
            this.linhas.add("               exemplo.imprimirTodos();");
            this.linhas.add("               break;");
            this.linhas.add("           case 0:");
            this.linhas.add("               break;");
            this.linhas.add("           default:");
            this.linhas.add("               break;");
            this.linhas.add("       }");
            this.linhas.add("   }");
        this.linhas.add("}");
        // fim das classe
        this.linhas.add("}");
        
        // salvar linhas no arquivo
        String nomeArquivo = classe + "Principal.java";
        this.manipulaArquivos.gravarNoFinalDoArquivoArray(
            nomeArquivo, 
            this.linhas
        );
    }
}
