/* Arquivo gerado automaticamente */

package br.ufsm.marca_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

import java.util.ArrayList;

public class MarcaExemplo implements EntidadeExemplo {
private InputOutputTela tela;
private MarcaDAO dao;

public MarcaExemplo (InputOutputTela tela){
   this.tela = tela;
   this.dao = new MarcaDAO(tela);
}

@Override
public void cadastrar(){
   MarcaModelo novo = new MarcaModelo();
   this.tela.exibe("Cadastro de Marcas:");
   this.tela.exibe("Digite os dados a seguir: ");
   this.tela.exibe("idMarca: ");
   novo.setidMarca(this.tela.leLong());
   this.tela.exibe("nomeMarca: ");
   novo.setnomeMarca(this.tela.leString());
   this.tela.exibe("numeroDePoltronas: ");
   novo.setnumeroDePoltronas(this.tela.leLong());
   this.dao.cadastrar(novo);
}

@Override
public void alterar(){
   ArrayList<MarcaModelo> consulta;
   this.tela.exibe("Alterar Marca:");
   consulta = pesquisarInterna();
   if(consulta.size() == 1){
       this.tela.imprimirArrayList(consulta);
       this.tela.exibe("Digite os dados a seguir: ");
       this.tela.exibe("nomeMarca: ");
       consulta.get(0).setnomeMarca(this.tela.leString());
       this.tela.exibe("numeroDePoltronas: ");
       consulta.get(0).setnumeroDePoltronas(this.tela.leLong());
       this.dao.alterar(consulta.get(0));
   }else{
       this.tela.exibe("Erro: Marca nao encontrado(a)!");
   }
}

@Override
public void remover(){
   ArrayList<MarcaModelo> consulta;
   this.tela.exibe("Remover Marca:");
   consulta = pesquisarInterna();
   if(consulta.size() == 1){
       this.dao.remover(consulta.get(0));
   }else{
       this.tela.exibe("Erro: Marca nao encontrado(a)!");
   }
}

public ArrayList<MarcaModelo> pesquisarInterna(){
   ArrayList<MarcaModelo> consulta;
   MarcaModelo atual = new MarcaModelo();
   this.tela.exibe("Digite a informacao a seguir: ");
   this.tela.exibe("idMarca: ");
   atual.setidMarca(this.tela.leLong());
   consulta = this.dao.pesquisar(atual);
   return consulta;
}

@Override
public void pesquisar(){
   this.tela.exibe("Pesquisa de Marcas:");
   this.tela.imprimirArrayList(pesquisarInterna());
}

@Override
public void imprimirTodos(){
   this.tela.exibe("Lista de Marcas: ");
   this.tela.imprimirArrayList(this.dao.imprimirTodos());
}
}
