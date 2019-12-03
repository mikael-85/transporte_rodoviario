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
public class CriaClasseDAO implements Runnable {
    MetadataEntidadeModelo tabela;
    ArrayList<String> linhas; // linhas Arquivo
    ManipulaArquivos manipulaArquivos;

    public CriaClasseDAO(MetadataEntidadeModelo tabela, ArrayList<String> cabecalho, ManipulaArquivos manipulaArquivos) {
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
        this.linhas.add("import java.sql.Connection;");
        this.linhas.add("import java.sql.PreparedStatement;");
        this.linhas.add("import java.sql.SQLException;");
        this.linhas.add("import java.util.ArrayList;");
        this.linhas.add("import java.sql.ResultSet;");
        this.linhas.add("");
        
        String classe = this.tabela.getNomeEntidade();
        classe = classe.substring(0,1).toUpperCase().concat(classe.substring(1));
        this.linhas.add("public class " + classe + "DAO implements EntidadeDAO<"+classe+"Modelo> {");
        this.linhas.add("private ConexaoBD bd;");
        this.linhas.add("private InputOutputTela tela;");
        this.linhas.add("");
        this.linhas.add("public " + classe + "DAO(InputOutputTela tela){");
        this.linhas.add("   this.bd = new ConexaoBD();");
        this.linhas.add("   this.tela = tela;");
        this.linhas.add("}");
        this.linhas.add("");
        this.linhas.add("@Override");
        this.linhas.add("public void cadastrar(" + classe +"Modelo "+
                this.tabela.getNomeEntidade() + "){");
        this.linhas.add("   Connection conexao = null;");
        this.linhas.add("   PreparedStatement sql = null;");
        this.linhas.add("   try {");
            this.linhas.add("      conexao = this.bd.getConexao();");
            this.linhas.add("      sql = conexao.prepareStatement(");
            String camposTabela = "      \"INSERT INTO "+this.tabela.getNomeEntidade()+" (";
            for (MetadataAtributoModelo atributo : this.tabela.getAtributosEntidade()) {
                camposTabela += atributo.getNomeAtributo() + ", ";
            }
            camposTabela = camposTabela.substring(0, camposTabela.length() - 2);
            camposTabela += ") VALUES (";
            for (int i = 0; i < this.tabela.getAtributosEntidade().size(); i++) {
                camposTabela += "?";
                if(this.tabela.getAtributosEntidade().size()-1 != i){
                    camposTabela += ", ";
                }
            }
            camposTabela += ")\");";
        this.linhas.add(camposTabela);
        int cAtributos = 1;
        for (MetadataAtributoModelo atributo : this.tabela.getAtributosEntidade()) {
            this.linhas.add("       sql.set" +
                    ((atributo.tipoToString().compareTo("Integer") == 0) ? "Int" : atributo.tipoToString())
                     + "(" + cAtributos + ", " + this.tabela.getNomeEntidade() + ".get" +
                    atributo.getNomeAtributo() + "());"
            );
            cAtributos++;
        }
        
        this.linhas.add("       sql.execute();");
        this.linhas.add("       this.tela.sucessoCadastro();");
        //this.linhas.add("       sql.close();");
        //this.linhas.add("       conexao.close();");
        this.linhas.add("");
        this.linhas.add("   } catch (SQLException ex) {");
        this.linhas.add("       this.tela.imprimeErro(ex.getMessage());");
        this.linhas.add("   }finally {");
        this.linhas.add("       try {");
        this.linhas.add("           if(sql != null){");
        this.linhas.add("               sql.close();");
        this.linhas.add("           }");
        this.linhas.add("           if(conexao != null){");
        this.linhas.add("               conexao.close();");
        this.linhas.add("           }");
        this.linhas.add("       } catch (SQLException e) {");
        this.linhas.add("           this.tela.imprimeErro(e.getMessage());");
        this.linhas.add("       }");
        this.linhas.add("   }");  
        this.linhas.add("}");
        this.linhas.add("");
        this.linhas.add("@Override");
        this.linhas.add("public void alterar(" + classe +"Modelo "+
                this.tabela.getNomeEntidade() + "){");
        this.linhas.add("   try {");
            this.linhas.add("      Connection conexao = this.bd.getConexao();");
            this.linhas.add("      PreparedStatement sql = conexao.prepareStatement(");
            camposTabela = "      \"UPDATE "+this.tabela.getNomeEntidade()+" SET ";
            for (int i = 0; i < this.tabela.getAtributosEntidade().size(); i++) {
                if(i != 0){
                    // se nao for o primeiro
                    camposTabela += this.tabela.getAtributosEntidade().get(i).getNomeAtributo() +" = ?";
                    if(this.tabela.getAtributosEntidade().size()-1 != i){
                        // se nao for o ultimo
                        camposTabela += ", ";
                    }
                }
            }
            camposTabela += " WHERE " + this.tabela.getAtributosEntidade().get(0).getNomeAtributo() + " = ?";
            camposTabela += "\");";
        this.linhas.add(camposTabela);
        cAtributos = 1;
        for (int i = 0; i < this.tabela.getAtributosEntidade().size(); i++) {
            MetadataAtributoModelo atributo = this.tabela.getAtributosEntidade().get(i);
            if(i != 0){
                // se nao for o primeiro
                this.linhas.add("       sql.set" +
                    ((atributo.tipoToString().compareTo("Integer") == 0) ? "Int" : atributo.tipoToString())
                            + "(" + cAtributos + ", " + this.tabela.getNomeEntidade() + ".get" +
                           atributo.getNomeAtributo() + "());"
                   );
                   cAtributos++;
            }else{
                // e o primeiro
                this.linhas.add("       sql.set" +
                    ((atributo.tipoToString().compareTo("Integer") == 0) ? "Int" : atributo.tipoToString())
                            + "(" + this.tabela.getAtributosEntidade().size() + ", " + this.tabela.getNomeEntidade() + ".get" +
                           atributo.getNomeAtributo() + "());"
                   );
            }
        }
        
        this.linhas.add("       sql.execute();");
        this.linhas.add("       this.tela.sucessoAlteracao();");
        this.linhas.add("       sql.close();");
        this.linhas.add("       conexao.close();");
        this.linhas.add("   } catch (SQLException ex) {");
        this.linhas.add("       System.err.println(ex.getMessage());");

        this.linhas.add("   }");
        this.linhas.add("}");
        this.linhas.add("");
        this.linhas.add("@Override");
        this.linhas.add("public void remover(" + classe +"Modelo "+
            this.tabela.getNomeEntidade() + "){");
            this.linhas.add("   try {");
            this.linhas.add("       Connection conexao = this.bd.getConexao();");
            this.linhas.add("       PreparedStatement sql = conexao.prepareStatement(");
            this.linhas.add("       \"DELETE FROM "+this.tabela.getNomeEntidade()+ " WHERE "
                + this.tabela.getAtributosEntidade().get(0).getNomeAtributo()
                + " = ?\");"
            );
            this.linhas.add("       sql.set" +
                ((this.tabela.getAtributosEntidade().get(0).tipoToString().compareTo("Integer") == 0) ? "Int" :
                this.tabela.getAtributosEntidade().get(0).tipoToString())
                + "(1, " + this.tabela.getNomeEntidade() + ".get" +
                this.tabela.getAtributosEntidade().get(0).getNomeAtributo() + "());"
            );

            this.linhas.add("       sql.execute();");
            this.linhas.add("       this.tela.sucessoExclusao();");
            this.linhas.add("       sql.close();");
            this.linhas.add("       conexao.close();");
            this.linhas.add("");
            this.linhas.add("   } catch (SQLException ex) {");
            this.linhas.add("       System.err.println(ex.getMessage());");

            this.linhas.add("   }");
        this.linhas.add("}");
        this.linhas.add("");
        this.linhas.add("@Override");
        this.linhas.add("public ArrayList<"+ classe +"Modelo"+ "> pesquisar(" 
            + classe +"Modelo "+
            this.tabela.getNomeEntidade() + "){");
            this.linhas.add("   ArrayList<"+ classe +"Modelo"+
                    "> resultadosConsulta = new ArrayList<"+ classe +"Modelo"+">();");
            this.linhas.add("   try {");
            this.linhas.add("       Connection conexao = this.bd.getConexao();");
            this.linhas.add("       PreparedStatement sql = conexao.prepareStatement(");
            this.linhas.add("       \"SELECT * FROM "+this.tabela.getNomeEntidade()+ 
                    " WHERE " + this.tabela.getAtributosEntidade().get(0).getNomeAtributo() +
                    " = ?\");"
            );
            this.linhas.add("       sql.set" +
                ((this.tabela.getAtributosEntidade().get(0).tipoToString().compareTo("Integer") == 0) ? "Int" :
                this.tabela.getAtributosEntidade().get(0).tipoToString())
                + "(1, " + this.tabela.getNomeEntidade() + ".get" +
                this.tabela.getAtributosEntidade().get(0).getNomeAtributo() + "());"
            );
            
            this.linhas.add("       ResultSet resultado = sql.executeQuery();");
            this.linhas.add("       resultadosConsulta = resultadoConsulta(resultado);");
            this.linhas.add("       resultado.close();");
            this.linhas.add("       sql.close();");
            this.linhas.add("       conexao.close();");
            this.linhas.add("   } catch (SQLException ex) {");
            this.linhas.add("       System.err.println(ex.getMessage());");
            this.linhas.add("   }");
            this.linhas.add("   return resultadosConsulta;");
        this.linhas.add("}");
        this.linhas.add("");
        this.linhas.add("@Override");
        this.linhas.add("public ArrayList<"+ classe +"Modelo"+ "> imprimirTodos(){");
            this.linhas.add("   ArrayList<"+ classe +"Modelo"+
                    "> resultadosConsulta = new ArrayList<"+ classe +"Modelo"+">();");
            this.linhas.add("   try {");
            this.linhas.add("       Connection conexao = this.bd.getConexao();");
            this.linhas.add("       PreparedStatement sql = conexao.prepareStatement(");
            this.linhas.add("       \"SELECT * FROM "+this.tabela.getNomeEntidade()+ "\");");
            this.linhas.add("       ResultSet resultado = sql.executeQuery();");
            this.linhas.add("       resultadosConsulta = resultadoConsulta(resultado);");
            this.linhas.add("       resultado.close();");
            this.linhas.add("       sql.close();");
            this.linhas.add("       conexao.close();");
            this.linhas.add("   } catch (SQLException ex) {");
            this.linhas.add("       System.err.println(ex.getMessage());");
            this.linhas.add("   }");
            this.linhas.add("   return resultadosConsulta;");
        this.linhas.add("}");
        this.linhas.add("");
        this.linhas.add("@Override");
        this.linhas.add("public ArrayList<"+ classe +"Modelo"+ "> resultadoConsulta(ResultSet resposta){");
        this.linhas.add("   ArrayList<"+ classe +"Modelo"+ "> resultados = new ArrayList<"+ 
                classe +"Modelo"+ ">();"
        );
        this.linhas.add("   try {");
        this.linhas.add("       while(resposta.next()){");
        this.linhas.add("           "+ classe +"Modelo"+" atual = new "+ classe +"Modelo"+"();");
        for (MetadataAtributoModelo atributo : this.tabela.getAtributosEntidade()) {
            this.linhas.add("           atual.set" + atributo.getNomeAtributo() + "(resposta.get"+
                ((atributo.tipoToString().compareTo("Integer") == 0) ? "Int" : atributo.tipoToString())
                    + "(\"" + atributo.getNomeAtributo() + "\"));"
                );
        }
        this.linhas.add("           resultados.add(atual);");
        this.linhas.add("       }");
        this.linhas.add("   } catch (SQLException ex){");
        this.linhas.add("       System.err.println(ex.getMessage());");
        this.linhas.add("   }");
        this.linhas.add("   return resultados;");
        this.linhas.add("}");
        // fim das classe
        this.linhas.add("}");
        
        // salvar linhas no arquivo
        String nomeArquivo = classe + "DAO.java";
        this.manipulaArquivos.gravarNoFinalDoArquivoArray(
            nomeArquivo, 
            this.linhas
        );
    }
}
