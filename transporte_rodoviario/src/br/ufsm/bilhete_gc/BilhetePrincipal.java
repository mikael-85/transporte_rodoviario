/* Arquivo gerado automaticamente */

package br.ufsm.bilhete_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

public class BilhetePrincipal {

public static void main(String[] args) {
   InputOutputTela tela = new InputOutputTela<BilheteModelo>("Bilhete");
   BilheteExemplo exemplo = new BilheteExemplo(tela);

   int opcao = -1;
   while(opcao != 0) {
       tela.exibe("CRUD gerado da tabela Bilhete ");
       tela.exibe("Escolha uma opcao: ");
       tela.exibe("1 - Cadastrar Bilhete ");
       tela.exibe("2 - Alterar Bilhete ");
       tela.exibe("3 - Pesquisar Bilhete ");
       tela.exibe("4 - Remover Bilhete ");
       tela.exibe("5 - Imprimir Todos(as) Bilhetes ");
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
