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
public class Tipo<T> {
    private T valor;

    public Tipo(T valor) {
        this.valor = valor;
    }
    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.valor);
    }
}
