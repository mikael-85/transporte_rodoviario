/* Arquivo gerado automaticamente */

package br.ufsm.intermediaria_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

public class IntermediariaPrincipal {

public static void main(String[] args) {
   InputOutputTela tela = new InputOutputTela<IntermediariaModelo>("Intermediaria");
   IntermediariaExemplo exemplo = new IntermediariaExemplo(tela);

   int opcao = -1;
   while(opcao != 0) {
       tela.exibe("CRUD gerado da tabela Intermediaria ");
       tela.exibe("Escolha uma opcao: ");
       tela.exibe("1 - Cadastrar Intermediaria ");
       tela.exibe("2 - Alterar Intermediaria ");
       tela.exibe("3 - Pesquisar Intermediaria ");
       tela.exibe("4 - Remover Intermediaria ");
       tela.exibe("5 - Imprimir Todos(as) Intermediarias ");
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
