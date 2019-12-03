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
public class Onibus {
    private Integer idOnibus;
    private String marcaModelo;
    private Integer numeroDePoltronas;

    public Onibus(Integer idOnibus, String marcaModelo, Integer numeroDePoltronas) {
        this.idOnibus = idOnibus;
        this.marcaModelo = marcaModelo;
        this.numeroDePoltronas = numeroDePoltronas;
    }

    public Integer getIdOnibus() {
        return idOnibus;
    }

    public void setIdOnibus(Integer idOnibus) {
        this.idOnibus = idOnibus;
    }

    public String getMarcaModelo() {
        return marcaModelo;
    }

    public void setMarcaModelo(String marcaModelo) {
        this.marcaModelo = marcaModelo;
    }

    public Integer getNumeroDePoltronas() {
        return numeroDePoltronas;
    }

    public void setNumeroDePoltronas(Integer numeroDePoltronas) {
        this.numeroDePoltronas = numeroDePoltronas;
    }
    
}
