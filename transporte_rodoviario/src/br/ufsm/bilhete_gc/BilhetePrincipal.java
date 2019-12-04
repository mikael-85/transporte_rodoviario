/* Arquivo gerado automaticamente */
package br.ufsm.bilhete_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

public class BilhetePrincipal {

    public static void main(String[] args) {
        InputOutputTela tela = new InputOutputTela<BilheteModelo>("Bilhete");
        BilheteExemplo exemplo = new BilheteExemplo(tela);

        int opcao = -1;
        while (opcao != 0) {
            tela.exibe("Bilhete ");
            tela.exibe("Escolha uma opcao: ");
//            tela.exibe("1 - Cadastrar Bilhete ");
            tela.exibe("2 - Adicionar Reserva Poltrona ");
            tela.exibe("3 - Pesquisar Bilhete(s) Reservado(s)");
            tela.exibe("4 - Remover Reserva Poltrona ");
            tela.exibe("5 - Imprimir Todos(as) Bilhetes ");
            tela.exibe("6 - Poltronas Disponiveis Nesta Viagem ");
            tela.exibe("7 - Poltronas Ocupadas Nesta Viagem ");
            tela.exibe("0 - Voltar ");

            opcao = tela.leInteger();

            switch (opcao) {
//                case 1:
//                    exemplo.cadastrar();
//                    break;
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
                case 6:
                    exemplo.pesquisaPoltronasDisponiveis();
                    break;
                case 7:
                    exemplo.pesquisaPoltronasNaoDisponiveis();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        }
    }
}
