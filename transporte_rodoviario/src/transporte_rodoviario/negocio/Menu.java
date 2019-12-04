/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporte_rodoviario.negocio;

import br.ufsm.bilhete_gc.BilhetePrincipal;
import java.util.Scanner;
import br.ufsm.cidade_gc.CidadePrincipal;
import br.ufsm.intermediaria_gc.IntermediariaPrincipal;
import br.ufsm.marca_gc.MarcaPrincipal;
import br.ufsm.onibus_gc.OnibusPrincipal;
import br.ufsm.trecho_gc.TrechoPrincipal;
import br.ufsm.viagem_gc.ViagemPrincipal;

/**
 *
 * @author Patrick Guerra
 */
public class Menu {
    private Scanner entrada = new Scanner(System.in);
    Integer leitura;
    CidadePrincipal cidade = new CidadePrincipal();
    BilhetePrincipal bilhete = new BilhetePrincipal();
    ViagemPrincipal viagem = new ViagemPrincipal();
    OnibusPrincipal onibus = new OnibusPrincipal();
    TrechoPrincipal trecho = new TrechoPrincipal();
    MarcaPrincipal marca = new MarcaPrincipal();
    IntermediariaPrincipal intermediaria = new IntermediariaPrincipal();
    
    String[] args;
    
    public void menu_inicial(){
        
        int opcao = -1;
        
        while (opcao != 0) {
            System.out.println("Transporte Rodoviario - Mikael Santellano");
            System.out.println("Escolha uma opcao: ");
            System.out.println("1 - Bilhete");
            System.out.println("2 - Cidade");
            System.out.println("3 - Viagem");
            System.out.println("4 - Onibus");
            System.out.println("5 - Trecho");
            System.out.println("6 - Marca do Onibus");
            System.out.println("7 - Cidade Intermediaria");
            System.out.println("0 - Sair ");
            leitura = Integer.parseInt(this.entrada.nextLine());
            opcao = leitura;
           
            switch (opcao) {
                case 1:
                    bilhete.main(args);
                    System.out.println(opcao);
                    break;
                case 2:
                    cidade.main(args);
                    System.out.println(opcao);
                    break;
                case 3:
                    viagem.main(args);
                    System.out.println(opcao);
                    break;
                case 4:
                    onibus.main(args);
                    System.out.println(opcao);
                    break;
                case 5:
                    trecho.main(args);
                    System.out.println(opcao);
                    break;
                case 6:
                    marca.main(args);
                    System.out.println(opcao);
                    break;  
                case 7:
                    intermediaria.main(args);
                    System.out.println(opcao);
                    break;    
                case 0:
                    break;
                default:
                    break;
            }
        }
    }
}
