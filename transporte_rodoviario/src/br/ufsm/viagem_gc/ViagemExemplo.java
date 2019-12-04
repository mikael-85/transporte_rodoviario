/* Arquivo gerado automaticamente */

package br.ufsm.viagem_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

import java.util.ArrayList;

public class ViagemExemplo implements EntidadeExemplo {
private InputOutputTela tela;
private ViagemDAO dao;

public ViagemExemplo (InputOutputTela tela){
   this.tela = tela;
   this.dao = new ViagemDAO(tela);
}

@Override
public void cadastrar(){
   ViagemModelo novo = new ViagemModelo();
   this.tela.exibe("Cadastro de Viagens:");
   this.tela.exibe("Digite os dados a seguir: ");
   this.tela.exibe("idViagem: ");
   novo.setidViagem(this.tela.leLong());
   this.tela.exibe("idOnibus: ");
   novo.setidOnibus(this.tela.leLong());
   this.tela.exibe("idTrecho: ");
   novo.setidTrecho(this.tela.leLong());
   this.tela.exibe("dataOrigem: ");
   novo.setdataOrigem(this.tela.leDate());
   this.tela.exibe("horaOrigem: ");
   novo.sethoraOrigem(this.tela.leString());
   this.tela.exibe("dataDestino: ");
   novo.setdataDestino(this.tela.leDate());
   this.tela.exibe("horaDestino: ");
   novo.sethoraDestino(this.tela.leString());
   this.dao.cadastrar(novo);
   this.dao.cadastrarBilhetesSemReserva(novo);
}

@Override
public void alterar(){
   ArrayList<ViagemModelo> consulta;
   this.tela.exibe("Alterar Viagem:");
   consulta = pesquisarInterna();
   if(consulta.size() == 1){
       this.tela.imprimirArrayList(consulta);
       this.tela.exibe("Digite os dados a seguir: ");
       this.tela.exibe("idOnibus: ");
       consulta.get(0).setidOnibus(this.tela.leLong());
       this.tela.exibe("idTrecho: ");
       consulta.get(0).setidTrecho(this.tela.leLong());
       this.tela.exibe("dataOrigem: ");
       consulta.get(0).setdataOrigem(this.tela.leDate());
       this.tela.exibe("horaOrigem: ");
       consulta.get(0).sethoraOrigem(this.tela.leString());
       this.tela.exibe("dataDestino: ");
       consulta.get(0).setdataDestino(this.tela.leDate());
       this.tela.exibe("horaDestino: ");
       consulta.get(0).sethoraDestino(this.tela.leString());
       this.dao.alterar(consulta.get(0));
   }else{
       this.tela.exibe("Erro: Viagem nao encontrado(a)!");
   }
}

@Override
public void remover(){
   ArrayList<ViagemModelo> consulta;
   this.tela.exibe("Remover Viagem:");
   consulta = pesquisarInterna();
   if(consulta.size() == 1){
       this.dao.remover(consulta.get(0));
   }else{
       this.tela.exibe("Erro: Viagem nao encontrado(a)!");
   }
}

public ArrayList<ViagemModelo> pesquisarInterna(){
   ArrayList<ViagemModelo> consulta;
   ViagemModelo atual = new ViagemModelo();
   this.tela.exibe("Digite a informacao a seguir: ");
   this.tela.exibe("idViagem: ");
   atual.setidViagem(this.tela.leLong());
   consulta = this.dao.pesquisar(atual);
   return consulta;
}

@Override
public void pesquisar(){
   this.tela.exibe("Pesquisa de Viagems:");
   this.tela.imprimirArrayList(pesquisarInterna());
}

@Override
public void imprimirTodos(){
   this.tela.exibe("Lista de Viagems: ");
   this.tela.imprimirArrayList(this.dao.imprimirTodos());
}
}
