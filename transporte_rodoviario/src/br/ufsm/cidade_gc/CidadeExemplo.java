/* Arquivo gerado automaticamente */

package br.ufsm.cidade_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

import java.util.ArrayList;

public class CidadeExemplo implements EntidadeExemplo {
private InputOutputTela tela;
private CidadeDAO dao;

public CidadeExemplo (InputOutputTela tela){
   this.tela = tela;
   this.dao = new CidadeDAO(tela);
}

@Override
public void cadastrar(){
   CidadeModelo novo = new CidadeModelo();
   this.tela.exibe("Cadastro de Cidades:");
   this.tela.exibe("Digite os dados a seguir: ");
   this.tela.exibe("idCidade: ");
   novo.setidCidade(this.tela.leLong());
   this.tela.exibe("nomeCidade: ");
   novo.setnomeCidade(this.tela.leString());
   this.dao.cadastrar(novo);
}

@Override
public void alterar(){
   ArrayList<CidadeModelo> consulta;
   this.tela.exibe("Alterar Cidade:");
   consulta = pesquisarInterna();
   if(consulta.size() == 1){
       this.tela.imprimirArrayList(consulta);
       this.tela.exibe("Digite os dados a seguir: ");
       this.tela.exibe("nomeCidade: ");
       consulta.get(0).setnomeCidade(this.tela.leString());
       this.dao.alterar(consulta.get(0));
   }else{
       this.tela.exibe("Erro: Cidade nao encontrado(a)!");
   }
}

@Override
public void remover(){
   ArrayList<CidadeModelo> consulta;
   this.tela.exibe("Remover Cidade:");
   consulta = pesquisarInterna();
   if(consulta.size() == 1){
       this.dao.remover(consulta.get(0));
   }else{
       this.tela.exibe("Erro: Cidade nao encontrado(a)!");
   }
}

public ArrayList<CidadeModelo> pesquisarInterna(){
   ArrayList<CidadeModelo> consulta;
   CidadeModelo atual = new CidadeModelo();
   this.tela.exibe("Digite a informacao a seguir: ");
   this.tela.exibe("idCidade: ");
   atual.setidCidade(this.tela.leLong());
   consulta = this.dao.pesquisar(atual);
   return consulta;
}

@Override
public void pesquisar(){
   this.tela.exibe("Pesquisa de Cidades:");
   this.tela.imprimirArrayList(pesquisarInterna());
}

@Override
public void imprimirTodos(){
   this.tela.exibe("Lista de Cidades: ");
   this.tela.imprimirArrayList(this.dao.imprimirTodos());
}
}
