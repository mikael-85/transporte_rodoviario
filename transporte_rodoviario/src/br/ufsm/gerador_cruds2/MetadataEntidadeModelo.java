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
public class MetadataEntidadeModelo {
    private String nomeEntidade;
    private ArrayList<MetadataAtributoModelo> atributosEntidade;

    public MetadataEntidadeModelo() {
        this.nomeEntidade = null;
        this.atributosEntidade = new ArrayList<MetadataAtributoModelo>();
    }
    
    public MetadataEntidadeModelo(String nomeEntidade) {
        this.nomeEntidade = nomeEntidade;
        this.atributosEntidade = new ArrayList<MetadataAtributoModelo>();
    }
    
    public void adicionarAtributo(MetadataAtributoModelo atributo){
        this.atributosEntidade.add(atributo);
    }
    
    public void adicionarAtributo(String nomeAtributo, String tipoAtributo, int tamanhoAtributo, Tipo valor){
        MetadataAtributoModelo novoAtributo;
        novoAtributo = new MetadataAtributoModelo(nomeAtributo, tipoAtributo, tamanhoAtributo, valor);
        this.atributosEntidade.add(novoAtributo);
    }

    public String getNomeEntidade() {
        return nomeEntidade;
    }

    public void setNomeEntidade(String nomeEntidade) {
        this.nomeEntidade = nomeEntidade;
    }

    public ArrayList<MetadataAtributoModelo> getAtributosEntidade() {
        return atributosEntidade;
    }

    public void setAtributosEntidade(ArrayList<MetadataAtributoModelo> atributosEntidade) {
        this.atributosEntidade = atributosEntidade;
    }

}
