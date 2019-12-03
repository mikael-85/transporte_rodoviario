/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufsm.gerador_cruds2;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Patrick Guerra
 */
public interface EntidadeDAO<T> {
    public void cadastrar(T obj);
    public void alterar(T obj);
    public void remover(T obj);
    public ArrayList<T> pesquisar(T obj);
    public ArrayList<T> imprimirTodos();
    public ArrayList<T> resultadoConsulta(ResultSet obj);
}
