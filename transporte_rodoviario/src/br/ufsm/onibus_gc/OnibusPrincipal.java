/* Arquivo gerado automaticamente */

package br.ufsm.onibus_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

public class OnibusPrincipal {

public static void main(String[] args) {
   InputOutputTela tela = new InputOutputTela<OnibusModelo>("Onibus");
   OnibusExemplo exemplo = new OnibusExemplo(tela);

   int opcao = -1;
   while(opcao != 0) {
       tela.exibe("CRUD gerado da tabela Onibus ");
       tela.exibe("Escolha uma opcao: ");
       tela.exibe("1 - Cadastrar Onibus ");
       tela.exibe("2 - Alterar Onibus ");
       tela.exibe("3 - Pesquisar Onibus ");
       tela.exibe("4 - Remover Onibus ");
       tela.exibe("5 - Imprimir Todos(as) Onibuss ");
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
