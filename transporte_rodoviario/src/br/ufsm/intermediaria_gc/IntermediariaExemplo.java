/* Arquivo gerado automaticamente */

package br.ufsm.intermediaria_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

import java.util.ArrayList;

public class IntermediariaExemplo implements EntidadeExemplo {
private InputOutputTela tela;
private IntermediariaDAO dao;

public IntermediariaExemplo (InputOutputTela tela){
   this.tela = tela;
   this.dao = new IntermediariaDAO(tela);
}

@Override
public void cadastrar(){
   IntermediariaModelo novo = new IntermediariaModelo();
   this.tela.exibe("Cadastro de Intermediarias:");
   this.tela.exibe("Digite os dados a seguir: ");
   this.tela.exibe("idCidade: ");
   novo.setidCidade(this.tela.leLong());
   this.tela.exibe("idTrecho: ");
   novo.setidTrecho(this.tela.leLong());
   this.tela.exibe("sequencia: ");
   novo.setsequencia(this.tela.leLong());
   this.dao.cadastrar(novo);
}

@Override
public void alterar(){
   ArrayList<IntermediariaModelo> consulta;
   this.tela.exibe("Alterar Intermediaria:");
   consulta = pesquisarInterna();
   if(consulta.size() == 1){
       this.tela.imprimirArrayList(consulta);
       this.tela.exibe("Digite os dados a seguir: ");
       this.tela.exibe("sequencia: ");
       consulta.get(0).setsequencia(this.tela.leLong());
       this.dao.alterar(consulta.get(0));
   }else{
       this.tela.exibe("Erro: Intermediaria nao encontrado(a)!");
   }
}

@Override
public void remover(){
   ArrayList<IntermediariaModelo> consulta;
   this.tela.exibe("Remover Intermediaria:");
   consulta = pesquisarInterna();
   if(consulta.size() == 1){
       this.dao.remover(consulta.get(0));
   }else{
       this.tela.exibe("Erro: Intermediaria nao encontrado(a)!");
   }
}

public ArrayList<IntermediariaModelo> pesquisarInterna(){
   ArrayList<IntermediariaModelo> consulta;
   IntermediariaModelo atual = new IntermediariaModelo();
   this.tela.exibe("Digite a informacao a seguir: ");
   this.tela.exibe("idCidade: ");
   atual.setidCidade(this.tela.leLong());
   this.tela.exibe("idTrecho: ");
   atual.setidTrecho(this.tela.leLong());
   consulta = this.dao.pesquisar(atual);
   return consulta;
}

@Override
public void pesquisar(){
   this.tela.exibe("Pesquisa de Intermediarias:");
   this.tela.imprimirArrayList(pesquisarInterna());
}

public void pesquisarTrecho(){
   ArrayList<IntermediariaModelo> consulta;
   IntermediariaModelo atual = new IntermediariaModelo();
   this.tela.exibe("Pesquisa de Cidades Intermediarias por Trecho:");
   this.tela.exibe("Digite a informacao a seguir: ");
   this.tela.exibe("idTrecho: ");
   atual.setidTrecho(this.tela.leLong());
   consulta = this.dao.pesquisarTrecho(atual);
   this.tela.imprimirArrayList(consulta);
}

@Override
public void imprimirTodos(){
   this.tela.exibe("Lista de Intermediarias: ");
   this.tela.imprimirArrayList(this.dao.imprimirTodos());
}
}
