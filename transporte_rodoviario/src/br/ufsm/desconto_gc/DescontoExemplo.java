/* Arquivo gerado automaticamente */

package br.ufsm.desconto_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

import java.util.ArrayList;

public class DescontoExemplo implements EntidadeExemplo {
private InputOutputTela tela;
private DescontoDAO dao;

public DescontoExemplo (InputOutputTela tela){
   this.tela = tela;
   this.dao = new DescontoDAO(tela);
}

@Override
public void cadastrar(){
   DescontoModelo novo = new DescontoModelo();
   this.tela.exibe("Cadastro de Descontos:");
   this.tela.exibe("Digite os dados a seguir: ");
   this.tela.exibe("dataInicio: ");
   novo.setdataInicio(this.tela.leDate());
   this.tela.exibe("dataTermino: ");
   novo.setdataTermino(this.tela.leDate());
   this.tela.exibe("horaInicio: ");
   novo.sethoraInicio(this.tela.leString());
   this.tela.exibe("horaTermino: ");
   novo.sethoraTermino(this.tela.leString());
   this.tela.exibe("desconto: ");
   novo.setdesconto(this.tela.leString());
   this.dao.cadastrar(novo);
}

@Override
public void alterar(){
   ArrayList<DescontoModelo> consulta;
   this.tela.exibe("Alterar Desconto:");
   consulta = pesquisarInterna();
   if(consulta.size() == 1){
       this.tela.imprimirArrayList(consulta);
       this.tela.exibe("Digite os dados a seguir: ");
       this.tela.exibe("desconto: ");
       consulta.get(0).setdesconto(this.tela.leString());
       this.dao.alterar(consulta.get(0));
   }else{
       this.tela.exibe("Erro: Desconto nao encontrado(a)!");
   }
}

@Override
public void remover(){
   ArrayList<DescontoModelo> consulta;
   this.tela.exibe("Remover Desconto:");
   consulta = pesquisarInterna();
   if(consulta.size() == 1){
       this.dao.remover(consulta.get(0));
   }else{
       this.tela.exibe("Erro: Desconto nao encontrado(a)!");
   }
}

public ArrayList<DescontoModelo> pesquisarInterna(){
   ArrayList<DescontoModelo> consulta;
   DescontoModelo atual = new DescontoModelo();
   this.tela.exibe("Digite a informacao a seguir: ");
   this.tela.exibe("dataInicio: ");
   atual.setdataInicio(this.tela.leDate());
   this.tela.exibe("dataTermino: ");
   atual.setdataTermino(this.tela.leDate());
   this.tela.exibe("horaInicio: ");
   atual.sethoraInicio(this.tela.leString());
   this.tela.exibe("horaTermino: ");
   atual.sethoraTermino(this.tela.leString());
   consulta = this.dao.pesquisar(atual);
   return consulta;
}

@Override
public void pesquisar(){
   this.tela.exibe("Pesquisa de Descontos:");
   this.tela.imprimirArrayList(pesquisarInterna());
}

@Override
public void imprimirTodos(){
   this.tela.exibe("Lista de Descontos: ");
   this.tela.imprimirArrayList(this.dao.imprimirTodos());
}
}
