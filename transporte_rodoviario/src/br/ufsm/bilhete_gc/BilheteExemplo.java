/* Arquivo gerado automaticamente */

package br.ufsm.bilhete_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

import java.util.ArrayList;

public class BilheteExemplo implements EntidadeExemplo {
private InputOutputTela tela;
private BilheteDAO dao;

public BilheteExemplo (InputOutputTela tela){
   this.tela = tela;
   this.dao = new BilheteDAO(tela);
}

@Override
public void cadastrar(){
   BilheteModelo novo = new BilheteModelo();
   this.tela.exibe("Cadastro de Bilhetes:");
   this.tela.exibe("Digite os dados a seguir: ");
   this.tela.exibe("idPoltrona: ");
   novo.setidPoltrona(this.tela.leLong());
   this.tela.exibe("idViagem: ");
   novo.setidViagem(this.tela.leLong());
   this.tela.exibe("nomeCliente: ");
   novo.setnomeCliente(this.tela.leString());
   this.dao.cadastrar(novo);
}

@Override
public void alterar(){
   ArrayList<BilheteModelo> consulta;
   this.tela.exibe("Alterar Bilhete:");
   consulta = pesquisarInterna();
   if(consulta.size() == 1){
       this.tela.imprimirArrayList(consulta);
       this.tela.exibe("Digite os dados a seguir: ");
       this.tela.exibe("idViagem: ");
       consulta.get(0).setidViagem(this.tela.leLong());
       this.tela.exibe("nomeCliente: ");
       consulta.get(0).setnomeCliente(this.tela.leString());
       this.dao.alterar(consulta.get(0));
   }else{
       this.tela.exibe("Erro: Bilhete nao encontrado(a)!");
   }
}

@Override
public void remover(){
   ArrayList<BilheteModelo> consulta;
   this.tela.exibe("Remover Bilhete:");
   consulta = pesquisarInterna();
   if(consulta.size() == 1){
       this.dao.remover(consulta.get(0));
   }else{
       this.tela.exibe("Erro: Bilhete nao encontrado(a)!");
   }
}

public ArrayList<BilheteModelo> pesquisarInterna(){
   ArrayList<BilheteModelo> consulta;
   BilheteModelo atual = new BilheteModelo();
   this.tela.exibe("Digite a informacao a seguir: ");
   this.tela.exibe("idPoltrona: ");
   atual.setidPoltrona(this.tela.leLong());
   consulta = this.dao.pesquisar(atual);
   return consulta;
}

@Override
public void pesquisar(){
   this.tela.exibe("Pesquisa de Bilhetes:");
   this.tela.imprimirArrayList(pesquisarInterna());
}

@Override
public void imprimirTodos(){
   this.tela.exibe("Lista de Bilhetes: ");
   this.tela.imprimirArrayList(this.dao.imprimirTodos());
}
}
