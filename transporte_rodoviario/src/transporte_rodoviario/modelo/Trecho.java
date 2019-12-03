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
public class Trecho {
    private Integer idTrecho;
    private Integer idCidadeOrigem;
    private Integer idCidadeDestino;

    public Trecho(Integer idTrecho, Integer idCidadeOrigem, Integer idCidadeDestino) {
        this.idTrecho = idTrecho;
        this.idCidadeOrigem = idCidadeOrigem;
        this.idCidadeDestino = idCidadeDestino;
    }

    public Integer getIdTrecho() {
        return idTrecho;
    }

    public void setIdTrecho(Integer idTrecho) {
        this.idTrecho = idTrecho;
    }

    public Integer getIdCidadeOrigem() {
        return idCidadeOrigem;
    }

    public void setIdCidadeOrigem(Integer idCidadeOrigem) {
        this.idCidadeOrigem = idCidadeOrigem;
    }

    public Integer getIdCidadeDestino() {
        return idCidadeDestino;
    }

    public void setIdCidadeDestino(Integer idCidadeDestino) {
        this.idCidadeDestino = idCidadeDestino;
    }
    
    

}
