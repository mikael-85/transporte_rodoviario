/* Arquivo gerado automaticamente */

package br.ufsm.onibus_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

import java.util.ArrayList;

public class OnibusExemplo implements EntidadeExemplo {
private InputOutputTela tela;
private OnibusDAO dao;

public OnibusExemplo (InputOutputTela tela){
   this.tela = tela;
   this.dao = new OnibusDAO(tela);
}

@Override
public void cadastrar(){
   OnibusModelo novo = new OnibusModelo();
   this.tela.exibe("Cadastro de Onibuss:");
   this.tela.exibe("Digite os dados a seguir: ");
   this.tela.exibe("idOnibus: ");
   novo.setidOnibus(this.tela.leLong());
   this.tela.exibe("idMarca: ");
   novo.setidMarca(this.tela.leLong());
   this.dao.cadastrar(novo);
}

@Override
public void alterar(){
   ArrayList<OnibusModelo> consulta;
   this.tela.exibe("Alterar Onibus:");
   consulta = pesquisarInterna();
   if(consulta.size() == 1){
       this.tela.imprimirArrayList(consulta);
       this.tela.exibe("Digite os dados a seguir: ");
       this.tela.exibe("idMarca: ");
       consulta.get(0).setidMarca(this.tela.leLong());
       this.dao.alterar(consulta.get(0));
   }else{
       this.tela.exibe("Erro: Onibus nao encontrado(a)!");
   }
}

@Override
public void remover(){
   ArrayList<OnibusModelo> consulta;
   this.tela.exibe("Remover Onibus:");
   consulta = pesquisarInterna();
   if(consulta.size() == 1){
       this.dao.remover(consulta.get(0));
   }else{
       this.tela.exibe("Erro: Onibus nao encontrado(a)!");
   }
}

public ArrayList<OnibusModelo> pesquisarInterna(){
   ArrayList<OnibusModelo> consulta;
   OnibusModelo atual = new OnibusModelo();
   this.tela.exibe("Digite a informacao a seguir: ");
   this.tela.exibe("idOnibus: ");
   atual.setidOnibus(this.tela.leLong());
   consulta = this.dao.pesquisar(atual);
   return consulta;
}

@Override
public void pesquisar(){
   this.tela.exibe("Pesquisa de Onibuss:");
   this.tela.imprimirArrayList(pesquisarInterna());
}

@Override
public void imprimirTodos(){
   this.tela.exibe("Lista de Onibuss: ");
   this.tela.imprimirArrayList(this.dao.imprimirTodos());
}
}
