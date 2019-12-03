/* Arquivo gerado automaticamente */

package br.ufsm.trecho_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

import java.util.ArrayList;

public class TrechoExemplo implements EntidadeExemplo {
private InputOutputTela tela;
private TrechoDAO dao;

public TrechoExemplo (InputOutputTela tela){
   this.tela = tela;
   this.dao = new TrechoDAO(tela);
}

@Override
public void cadastrar(){
   TrechoModelo novo = new TrechoModelo();
   this.tela.exibe("Cadastro de Trechos:");
   this.tela.exibe("Digite os dados a seguir: ");
   this.tela.exibe("idTrecho: ");
   novo.setidTrecho(this.tela.leLong());
   this.tela.exibe("idCidadeOrigem: ");
   novo.setidCidadeOrigem(this.tela.leLong());
   this.tela.exibe("idCidadeDestino: ");
   novo.setidCidadeDestino(this.tela.leLong());
   this.dao.cadastrar(novo);
}

@Override
public void alterar(){
   ArrayList<TrechoModelo> consulta;
   this.tela.exibe("Alterar Trecho:");
   consulta = pesquisarInterna();
   if(consulta.size() == 1){
       this.tela.imprimirArrayList(consulta);
       this.tela.exibe("Digite os dados a seguir: ");
       this.tela.exibe("idCidadeOrigem: ");
       consulta.get(0).setidCidadeOrigem(this.tela.leLong());
       this.tela.exibe("idCidadeDestino: ");
       consulta.get(0).setidCidadeDestino(this.tela.leLong());
       this.dao.alterar(consulta.get(0));
   }else{
       this.tela.exibe("Erro: Trecho nao encontrado(a)!");
   }
}

@Override
public void remover(){
   ArrayList<TrechoModelo> consulta;
   this.tela.exibe("Remover Trecho:");
   consulta = pesquisarInterna();
   if(consulta.size() == 1){
       this.dao.remover(consulta.get(0));
   }else{
       this.tela.exibe("Erro: Trecho nao encontrado(a)!");
   }
}

public ArrayList<TrechoModelo> pesquisarInterna(){
   ArrayList<TrechoModelo> consulta;
   TrechoModelo atual = new TrechoModelo();
   this.tela.exibe("Digite a informacao a seguir: ");
   this.tela.exibe("idTrecho: ");
   atual.setidTrecho(this.tela.leLong());
   consulta = this.dao.pesquisar(atual);
   return consulta;
}

@Override
public void pesquisar(){
   this.tela.exibe("Pesquisa de Trechos:");
   this.tela.imprimirArrayList(pesquisarInterna());
}

@Override
public void imprimirTodos(){
   this.tela.exibe("Lista de Trechos: ");
   this.tela.imprimirArrayList(this.dao.imprimirTodos());
}
}
