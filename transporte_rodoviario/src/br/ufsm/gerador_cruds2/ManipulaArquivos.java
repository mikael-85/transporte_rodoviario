/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufsm.gerador_cruds2;

import java.util.ArrayList;
import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Patrick Guerra
 */
public class ManipulaArquivos {
    public String caminho;

    public ManipulaArquivos() {
        // Obtendo path do projeto
        this.caminho = null;
        this.caminho = System.getProperty("user.dir");
        this.caminho += "\\src\\br\\ufsm\\gerador_cruds2\\";
    }

    public ManipulaArquivos(String caminho) {
        this.caminho = null;
        this.caminho = System.getProperty("user.dir");
        this.caminho += "\\src\\br\\ufsm\\";
        this.caminho += caminho + "\\";
    }
    
    /**
     * Leitura do arquivo com o nome recebido. 
     * 
     * @param nomeArquivo   String com o nome do arquivo e extensao
     * @return              <code>ArrayList</code> com as linhas do arquivo;
     *                      null caso o arquivo não foi encontrado;
     *                      ArrayList vazio caso o arquivo estiver vazio;
     */
    public ArrayList<String> leituraArquivo(String nomeArquivo){
        ArrayList<String> linhas = null;
        File file = new File(this.caminho+nomeArquivo);
        if(file.exists()){
            try {
                BufferedReader buffRead = null;
                try {
                    buffRead = new BufferedReader(new InputStreamReader(
                            new FileInputStream(this.caminho+nomeArquivo), "Latin1"));
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(ManipulaArquivos.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                String linha;
                try {
                    // Le a primeira linha do arquivo
                    linha = buffRead.readLine();
                    // Se linha == null o arquivo esta em branco
                    if(linha != null){
                        linhas = new ArrayList<String>();
                        while(linha != null){
                            linhas.add(linha);
                            linha = buffRead.readLine();
                        }
                        // fecha o buffer de leitura do arquivo
                        buffRead.close();
                    }else{
                        // arquivo vazio retornando ArrayList vazio
                        linhas = new ArrayList<String>();
                        System.out.println("Aviso: Nenhuma classe automatica encontrada.");
                    }

                } catch (IOException ex) {
                    System.err.println("Erro: Nao foi possivel ler o arquivo!");
                    //Logger.getLogger(ManipulaArquivos.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                System.err.println("Erro: Arquivo nao encontrado!");
                //Logger.getLogger(ManipulaArquivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            // nao exibindo nada caso nao encontrado o arquivo
        }
        return linhas;
    }
    
    /**
     * Grava no final do arquivo o conteudo recebido.
     *
     * @param nomeArquivo   String com o nome do arquivo e extensao
     * @param conteudo      String com o conteudo a ser gravado; 
     *                      ou null caso deseja-se apenas criar o arquivo
     */
    public void gravarNoFinalDoArquivo(String nomeArquivo, String conteudo){
//        ArrayList<String> linhasExistentes = null;
//        linhasExistentes = leituraArquivo(nomeArquivo);
        try {
            OutputStreamWriter bufferOut = new OutputStreamWriter(
                new FileOutputStream(this.caminho+nomeArquivo,true),"Latin1");
            //BufferedWriter buffWrite = new BufferedWriter(new FileWriter(this.caminho+nomeArquivo));
            // Arquivo criado ou aberto para edicao
            if(conteudo != null){
                //buffWrite.append(conteudo + "\n");
//                if(linhasExistentes != null){
//                    for(String linha : linhasExistentes){
//                        bufferOut.write(linha+ "\n");
//                    }
//                }
                bufferOut.write(conteudo + "\n");
                //buffWrite.close();
                bufferOut.close();
            }else{
                System.out.println("Aviso: Arquivo "+nomeArquivo+" criado com sucesso.");
            }
        } catch (IOException ex) {
            System.err.println("Erro: Nao foi possivel criar o arquivo!");
            //Logger.getLogger(ManipulaArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Grava no final do arquivo o conteudo recebido.
     *
     * @param nomeArquivo   String com o nome do arquivo e extensao
     * @param conteudo      ArrayList de String com o conteudo a ser gravado; 
     *                      ou null caso deseja-se apenas criar o arquivo
     */
    public void gravarNoFinalDoArquivoArray(String nomeArquivo, ArrayList<String> conteudo){
        ArrayList<String> linhasExistentes = null;
        linhasExistentes = leituraArquivo(nomeArquivo);
        try {
            OutputStreamWriter bufferOut = new OutputStreamWriter(
                new FileOutputStream(this.caminho+nomeArquivo),"Latin1");
            // BufferedWriter buffWrite = new BufferedWriter(new FileWriter(this.caminho+nomeArquivo));
            // Arquivo criado ou aberto para edicao
            if(conteudo != null){
                if(linhasExistentes != null){
                    for(String linha : linhasExistentes){
                        bufferOut.write(linha+ "\n");
                    }
                }
                for (String stringAtual : conteudo) {
                    // buffWrite.append(stringAtual + "\n");
                    bufferOut.write(stringAtual + "\n");
                }
                //buffWrite.close();
                bufferOut.close();
            }else{
                System.out.println("Aviso: Arquivo "+nomeArquivo+" criado com sucesso.");
            }
        } catch (IOException ex) {
            System.err.println("Erro: Nao foi possivel criar o arquivo!");
            //Logger.getLogger(ManipulaArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Apaga o conteudo do arquivo atual e grava o conteudo recebido.
     *
     * @param nomeArquivo   String com o nome do arquivo e extensao
     * @param conteudo      String com o conteudo a ser gravado
     */
    public void sobrescreverArquivo(String nomeArquivo, String conteudo){
        File file = new File(this.caminho+nomeArquivo);
        if(file.exists()){
            file.delete();
        }
        gravarNoFinalDoArquivo(nomeArquivo, conteudo);
    }
    
    /**
     * Cria uma pasta se ela nao existe
     */
    public void criarPasta(){
        File file = new File(this.caminho);
        //se o diretorio não existe cria-lo
        if(!file.exists()){
            file.mkdir();
        }
    }
    
    public ArrayList<String> listaArquivos(){
        ArrayList<String> lista = new ArrayList<String>();
        File file = new File(this.caminho);
	File afile[] = file.listFiles();
        if(afile != null){
            for (File arquivoAtual : afile) {
                lista.add(arquivoAtual.getName());
                //System.out.println(arquivoAtual.getName());
            }
        }else{
            System.err.println("Erro: Nenhum arquivo encontrado! "+this.caminho);
        }
        return lista;
    }
    
    public ArrayList<String> listaDiretorios(){
        ArrayList<String> lista = new ArrayList<String>();
        File file = new File(this.caminho);
	File afile[] = file.listFiles();
        if(afile.length > 0){
            for (File arquivoAtual : afile) {
                if(arquivoAtual.isDirectory()){
                    lista.add(arquivoAtual.getName());
                    //System.out.println(arquivoAtual.getName());
                }
            }
        }else{
            System.err.println("Erro: Nenhum diretorio encontrado! "+this.caminho);
        }
        return lista;
    }

}
