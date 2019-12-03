/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufsm.gerador_cruds2;

import java.util.ArrayList;

/**
 *
 * @author Patrick Guerra
 */
public class ControladorClasses {
    private ArrayList<MetadataEntidadeModelo> tabelas;
    private ArrayList<CriaClassesEntidade> pilhaExecucao;
    private ArrayList<Thread> threads;

    public ControladorClasses(ArrayList<MetadataEntidadeModelo> tabelas) {
        this.tabelas = tabelas;
        this.pilhaExecucao = new ArrayList<CriaClassesEntidade>();
        this.threads = new ArrayList<Thread>();
        criaClasses();
    }
    
    public void criaClasses(){
        for (MetadataEntidadeModelo tabela : tabelas) {
            CriaClassesEntidade execucao = new CriaClassesEntidade(tabela);
            Thread novaThread = new Thread(execucao);
            novaThread.start();
            // Nao perder referencia por causa do Garbage Collector
            this.pilhaExecucao.add(execucao);
            this.threads.add(novaThread);
        }
    }

}
