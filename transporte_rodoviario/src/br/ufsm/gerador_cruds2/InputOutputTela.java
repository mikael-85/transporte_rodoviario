/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufsm.gerador_cruds2;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Patrick Guerra
 */
public class InputOutputTela<T>{
    private String nomeEntidade;
    private Scanner entrada; 
    private ManipulaArquivos ma;

    public InputOutputTela(String nomeEntidade) {
        this.nomeEntidade = nomeEntidade;
        this.entrada = new Scanner(System.in);
        this.ma = new ManipulaArquivos("logs");
    }
    
    // leitura
    public String leString(){
        String leitura;
        leitura = this.entrada.nextLine();
        return leitura;
    }
    
    public Long leLong(){
        Long leitura;
        leitura = Long.valueOf(this.entrada.nextLine());
        return leitura;
    }
    
    public Integer leInteger(){
        Integer leitura;
        leitura = Integer.valueOf(this.entrada.nextLine());
        return leitura;
    }
    
    public Double leDouble(){
        Double leitura;
        leitura = Double.valueOf(this.entrada.nextLine());
        return leitura;
    }
    
    public Date leDate(){
        String leitura;
        leitura = this.entrada.nextLine();
        String dataString = leitura;
        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy"); 
        java.sql.Date data = null;
        try {
            data = new java.sql.Date(fmt.parse(dataString).getTime());
        } catch (ParseException ex) {
            //Logger.getLogger(InputOutputTela.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.toString());
        }
        return data;
    }
    
    // mensagens 
    public void sucessoCadastro(){
        System.out.println(this.nomeEntidade + " cadastrado(a) com sucesso!");
    }
    
    public void sucessoAlteracao(){
        System.out.println(this.nomeEntidade + " alterado(a) com sucesso!");
    }
    
    public void sucessoExclusao(){
        System.out.println(this.nomeEntidade + " excluido(a) com sucesso!");
        //this.ma.gravarNoFinalDoArquivo(this.nomeEntidade+".txt",this.nomeEntidade + " excluido(a) com sucesso!");
    }
    
    public void exibe(String conteudo){
        System.out.println(conteudo);
    }
    
    public void imprimirArrayList(ArrayList<T> linhas){
        if(linhas.size() > 0){  
            for (T linha : linhas) {
                System.out.print(linha+"\n"); 
            }
        }else{
            System.out.println("Nenhum(a) "+ this.nomeEntidade + " foi encontrado(a)!");
        }
    }
    
    public void imprimirList(ArrayList<String> linhas){
        for (String linha : linhas) {
            System.out.println(linha); 
        }
    }
    
    // erros
    public void imprimeErro(String erro){
        System.err.println(erro);
    }
    
    public void imprimeErroArray(ArrayList<String> linhas){
        if(linhas.size() > 0){  
            for (String linha : linhas) {
                System.out.print(linha+"\n"); 
            }
        }else{
            System.out.println("Nenhum(a) "+ this.nomeEntidade + " foi encontrado(a)!");
        }
    }
}
