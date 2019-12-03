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
public class Intermediaria {
    private Integer idCidade;
    private Integer idTrecho;
    private Integer sequencia;

    public Intermediaria(Integer idCidade, Integer idTrecho, Integer sequencia) {
        this.idCidade = idCidade;
        this.idTrecho = idTrecho;
        this.sequencia = sequencia;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public Integer getIdTrecho() {
        return idTrecho;
    }

    public void setIdTrecho(Integer idTrecho) {
        this.idTrecho = idTrecho;
    }

    public Integer getSequencia() {
        return sequencia;
    }

    public void setSequencia(Integer sequencia) {
        this.sequencia = sequencia;
    }
    
    
}
