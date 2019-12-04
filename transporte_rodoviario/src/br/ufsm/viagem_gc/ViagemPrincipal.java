/* Arquivo gerado automaticamente */

package br.ufsm.viagem_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

public class ViagemPrincipal {

public static void main(String[] args) {
   InputOutputTela tela = new InputOutputTela<ViagemModelo>("Viagem");
   ViagemExemplo exemplo = new ViagemExemplo(tela);

   int opcao = -1;
   while(opcao != 0) {
       tela.exibe("CRUD gerado da tabela Viagem ");
       tela.exibe("Escolha uma opcao: ");
       tela.exibe("1 - Cadastrar Viagem ");
       tela.exibe("2 - Alterar Viagem ");
       tela.exibe("3 - Pesquisar Viagem ");
       tela.exibe("4 - Remover Viagem ");
       tela.exibe("5 - Imprimir Todos(as) Viagems ");
       tela.exibe("0 - Voltar ");

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
