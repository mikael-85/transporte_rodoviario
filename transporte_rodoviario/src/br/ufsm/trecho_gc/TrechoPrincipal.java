/* Arquivo gerado automaticamente */

package br.ufsm.trecho_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

public class TrechoPrincipal {

public static void main(String[] args) {
   InputOutputTela tela = new InputOutputTela<TrechoModelo>("Trecho");
   TrechoExemplo exemplo = new TrechoExemplo(tela);

   int opcao = -1;
   while(opcao != 0) {
       tela.exibe("CRUD gerado da tabela Trecho ");
       tela.exibe("Escolha uma opcao: ");
       tela.exibe("1 - Cadastrar Trecho ");
       tela.exibe("2 - Alterar Trecho ");
       tela.exibe("3 - Pesquisar Trecho ");
       tela.exibe("4 - Remover Trecho ");
       tela.exibe("5 - Imprimir Todos(as) Trechos ");
       tela.exibe("0 - Sair ");

       opcao = tela.leInteger();

       switch (opcao) {
           case 1:
               exemplo.cadastrar();
               break;
           case 2:
               exemplo.alterar();
               break;
           case 3:
               exemplo.pesquisar();
               break;
           case 4:
               exemplo.remover();
               break;
           case 5:
               exemplo.imprimirTodos();
               break;
           case 0:
               break;
           default:
               break;
       }
   }
}
}
