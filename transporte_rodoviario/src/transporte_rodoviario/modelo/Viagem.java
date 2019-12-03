/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transporte_rodoviario.modelo;
import java.sql.Time;
import java.util.Date;
/**
 *
 * @author Patrick Guerra
 */
public class Viagem {

    private Integer idViagem;
    private Integer idOnibus;
    private Integer idTrecho;
    private Date dataOrigem;
    private Time horaOrigem;
    private Date dataDestino;
    private Time horaDestino; 

    public Viagem(Integer idViagem, Integer idOnibus, Integer idTrecho, Date dataOrigem, Time horaOrigem, Date dataDestino, Time horaDestino) {
        this.idViagem = idViagem;
        this.idOnibus = idOnibus;
        this.idTrecho = idTrecho;
        this.dataOrigem = dataOrigem;
        this.horaOrigem = horaOrigem;
        this.dataDestino = dataDestino;
        this.horaDestino = horaDestino;
    }

    public Integer getIdViagem() {
        return idViagem;
    }

    public void setIdViagem(Integer idViagem) {
        this.idViagem = idViagem;
    }

    public Integer getIdOnibus() {
        return idOnibus;
    }

    public void setIdOnibus(Integer idOnibus) {
        this.idOnibus = idOnibus;
    }

    public Integer getIdTrecho() {
        return idTrecho;
    }

    public void setIdTrecho(Integer idTrecho) {
        this.idTrecho = idTrecho;
    }

    public Date getDataOrigem() {
        return dataOrigem;
    }

    public void setDataOrigem(Date dataOrigem) {
        this.dataOrigem = dataOrigem;
    }

    public Time getHoraOrigem() {
        return horaOrigem;
    }

    public void setHoraOrigem(Time horaOrigem) {
        this.horaOrigem = horaOrigem;
    }

    public Date getDataDestino() {
        return dataDestino;
    }

    public void setDataDestino(Date dataDestino) {
        this.dataDestino = dataDestino;
    }

    public Time getHoraDestino() {
        return horaDestino;
    }

    public void setHoraDestino(Time horaDestino) {
        this.horaDestino = horaDestino;
    }

}
