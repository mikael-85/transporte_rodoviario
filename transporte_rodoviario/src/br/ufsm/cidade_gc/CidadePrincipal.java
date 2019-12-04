/* Arquivo gerado automaticamente */

package br.ufsm.cidade_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

public class CidadePrincipal {

public static void main(String[] args) {
   InputOutputTela tela = new InputOutputTela<CidadeModelo>("Cidade");
   CidadeExemplo exemplo = new CidadeExemplo(tela);

   int opcao = -1;
   while(opcao != 0) {
       tela.exibe("CRUD gerado da tabela Cidade ");
       tela.exibe("Escolha uma opcao: ");
       tela.exibe("1 - Cadastrar Cidade ");
       tela.exibe("2 - Alterar Cidade ");
       tela.exibe("3 - Pesquisar Cidade ");
       tela.exibe("4 - Remover Cidade ");
       tela.exibe("5 - Imprimir Todos(as) Cidades ");
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
