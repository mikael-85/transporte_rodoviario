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
public class CriaClasseExemplo implements Runnable {
    MetadataEntidadeModelo tabela;
    ArrayList<String> linhas; // linhas Arquivo
    ManipulaArquivos manipulaArquivos;

    public CriaClasseExemplo(MetadataEntidadeModelo tabela, ArrayList<String> cabecalho, ManipulaArquivos manipulaArquivos) {
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
        // imports
        this.linhas.add("import java.util.ArrayList;");
        this.linhas.add("");
        
        String classe = this.tabela.getNomeEntidade();
        classe = classe.substring(0,1).toUpperCase().concat(classe.substring(1));
        this.linhas.add("public class " + classe + "Exemplo implements EntidadeExemplo {");
        this.linhas.add("private InputOutputTela tela;");
        this.linhas.add("private " + classe + "DAO dao;");
        this.linhas.add("");
        
        this.linhas.add("public " + classe + "Exemplo (InputOutputTela tela){");
            this.linhas.add("   this.tela = tela;");
            this.linhas.add("   this.dao = new "+ classe + "DAO(tela);");
        this.linhas.add("}");
        this.linhas.add("");
        
        this.linhas.add("@Override");
        this.linhas.add("public void cadastrar(){");
            this.linhas.add("   " + classe + "Modelo novo = new " + classe + "Modelo();");
            this.linhas.add("   this.tela.exibe(\"Cadastro de " + classe + "s:\");");
            this.linhas.add("   this.tela.exibe(\"Digite os dados a seguir: \");");
            for (MetadataAtributoModelo atributo : this.tabela.getAtributosEntidade()) {
                this.linhas.add("   this.tela.exibe(\""+ atributo.getNomeAtributo() +": \");");
                this.linhas.add("   novo.set" + atributo.getNomeAtributo() + "("
                    + "this.tela.le" + atributo.tipoToString() + "());"
                );
            }
            this.linhas.add("   this.dao.cadastrar(novo);");
        this.linhas.add("}");
        this.linhas.add("");
        
        this.linhas.add("@Override");
        this.linhas.add("public void alterar(){");
            this.linhas.add("   ArrayList<"+classe+"Modelo> consulta;");
            this.linhas.add("   this.tela.exibe(\"Alterar " + classe + ":\");");
            this.linhas.add("   consulta = pesquisarInterna();");
            this.linhas.add("   if(consulta.size() == 1){");
            this.linhas.add("       this.tela.imprimirArrayList(consulta);");
            this.linhas.add("       this.tela.exibe(\"Digite os dados a seguir: \");");
            for (MetadataAtributoModelo atributo : this.tabela.getAtributosEntidade()) {
                // Quando nao for o primeiro atributo vai listar:
                if(!this.tabela.getAtributosEntidade().get(0).equals(atributo)){
                    this.linhas.add("       this.tela.exibe(\""+ atributo.getNomeAtributo() +": \");");
                    this.linhas.add("       consulta.get(0).set" + atributo.getNomeAtributo() + "("
                        + "this.tela.le" + atributo.tipoToString() + "());"
                    );
                }
            }
            this.linhas.add("       this.dao.alterar(consulta.get(0));");
            this.linhas.add("   }else{");
            this.linhas.add("       this.tela.exibe(\"Erro: " + classe + " nao encontrado(a)!\");");
            this.linhas.add("   }");
        this.linhas.add("}");
        this.linhas.add("");
        
        this.linhas.add("@Override");
        this.linhas.add("public void remover(){");
            this.linhas.add("   ArrayList<"+classe+"Modelo> consulta;");
            this.linhas.add("   this.tela.exibe(\"Remover " + classe + ":\");");
            this.linhas.add("   consulta = pesquisarInterna();");
            this.linhas.add("   if(consulta.size() == 1){");
            this.linhas.add("       this.dao.remover(consulta.get(0));");
            this.linhas.add("   }else{");
            this.linhas.add("       this.tela.exibe(\"Erro: " + classe + " nao encontrado(a)!\");");
            this.linhas.add("   }");
        this.linhas.add("}");
        this.linhas.add("");
        
        this.linhas.add("public ArrayList<"+classe+"Modelo> pesquisarInterna(){");
            this.linhas.add("   ArrayList<"+classe+"Modelo> consulta;");
            this.linhas.add("   " + classe + "Modelo atual = new " + classe + "Modelo();");
            this.linhas.add("   this.tela.exibe(\"Digite a informacao a seguir: \");");
            this.linhas.add("   this.tela.exibe(\""+ 
            this.tabela.getAtributosEntidade().get(0).getNomeAtributo() +": \");");
            this.linhas.add("   atual.set" + 
                this.tabela.getAtributosEntidade().get(0).getNomeAtributo() + "("
                + "this.tela.le" + 
                this.tabela.getAtributosEntidade().get(0).tipoToString() + "());"
            );
            this.linhas.add("   consulta = this.dao.pesquisar(atual);");
            this.linhas.add("   return consulta;");
        this.linhas.add("}");
        this.linhas.add("");
        
        this.linhas.add("@Override");
        this.linhas.add("public void pesquisar(){");
            this.linhas.add("   this.tela.exibe(\"Pesquisa de " + classe + "s:\");");
            this.linhas.add("   this.tela.imprimirArrayList(pesquisarInterna());");
        this.linhas.add("}");
        this.linhas.add("");
        
        this.linhas.add("@Override");
        this.linhas.add("public void imprimirTodos(){");
            this.linhas.add("   this.tela.exibe(\"Lista de "+classe+"s: \");");
            this.linhas.add("   this.tela.imprimirArrayList(this.dao.imprimirTodos());");
        this.linhas.add("}");
        
        // fim das classe
        this.linhas.add("}");
        
        // salvar linhas no arquivo
        String nomeArquivo = classe + "Exemplo.java";
        this.manipulaArquivos.gravarNoFinalDoArquivoArray(
            nomeArquivo, 
            this.linhas
        );
    }
}
