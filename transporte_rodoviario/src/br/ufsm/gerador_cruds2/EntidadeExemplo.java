/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufsm.gerador_cruds2;

/**
 *
 * @author Patrick Guerra
 */
public interface EntidadeExemplo {
    public void cadastrar();
    public void alterar();
    public void remover();
    public void pesquisar();
    public void imprimirTodos();
}
