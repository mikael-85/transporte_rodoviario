/* Arquivo gerado automaticamente */

package br.ufsm.desconto_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

public class DescontoPrincipal {

public static void main(String[] args) {
   InputOutputTela tela = new InputOutputTela<DescontoModelo>("Desconto");
   DescontoExemplo exemplo = new DescontoExemplo(tela);

   int opcao = -1;
   while(opcao != 0) {
       tela.exibe("CRUD gerado da tabela Desconto ");
       tela.exibe("Escolha uma opcao: ");
       tela.exibe("1 - Cadastrar Desconto ");
       tela.exibe("2 - Alterar Desconto ");
       tela.exibe("3 - Pesquisar Desconto ");
       tela.exibe("4 - Remover Desconto ");
       tela.exibe("5 - Imprimir Todos(as) Descontos ");
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
