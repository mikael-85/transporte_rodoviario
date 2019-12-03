/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transporte_rodoviario.modelo;

/**
 *
 * @author Patrick Guerra
 */
public class Bilhete {
    private Integer idPoltrona;
    private Integer idViagem;
    private String nomeCliente;

    public Bilhete(Integer idPoltrona, Integer idViagem, String nomeCliente) {
        this.idPoltrona = idPoltrona;
        this.idViagem = idViagem;
        this.nomeCliente = nomeCliente;
    }

    public Integer getIdPoltrona() {
        return idPoltrona;
    }

    public void setIdPoltrona(Integer idPoltrona) {
        this.idPoltrona = idPoltrona;
    }

    public Integer getIdViagem() {
        return idViagem;
    }

    public void setIdViagem(Integer idViagem) {
        this.idViagem = idViagem;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    
}
