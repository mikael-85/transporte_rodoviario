/* Arquivo gerado automaticamente */

package br.ufsm.marca_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

public class MarcaPrincipal {

public static void main(String[] args) {
   InputOutputTela tela = new InputOutputTela<MarcaModelo>("Marca");
   MarcaExemplo exemplo = new MarcaExemplo(tela);

   int opcao = -1;
   while(opcao != 0) {
       tela.exibe("CRUD gerado da tabela Marca ");
       tela.exibe("Escolha uma opcao: ");
       tela.exibe("1 - Cadastrar Marca ");
       tela.exibe("2 - Alterar Marca ");
       tela.exibe("3 - Pesquisar Marca ");
       tela.exibe("4 - Remover Marca ");
       tela.exibe("5 - Imprimir Todos(as) Marcas ");
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
