/* Arquivo gerado automaticamente */

package br.ufsm.viagem_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

public class ViagemModelo implements EntidadeModelo {
/* Atributos */
private Long idViagem;
private Long idOnibus;
private Long idTrecho;
private Date dataOrigem;
private String horaOrigem;
private Date dataDestino;
private String horaDestino;

/* Metodos Get e Set */
public Long getidViagem() {
    return this.idViagem;
}

public void setidViagem(Long idViagem) {
    this.idViagem = idViagem;
}

public Long getidOnibus() {
    return this.idOnibus;
}

public void setidOnibus(Long idOnibus) {
    this.idOnibus = idOnibus;
}

public Long getidTrecho() {
    return this.idTrecho;
}

public void setidTrecho(Long idTrecho) {
    this.idTrecho = idTrecho;
}

public Date getdataOrigem() {
    return this.dataOrigem;
}

public void setdataOrigem(Date dataOrigem) {
    this.dataOrigem = dataOrigem;
}

public String gethoraOrigem() {
    return this.horaOrigem;
}

public void sethoraOrigem(String horaOrigem) {
    this.horaOrigem = horaOrigem;
}

public Date getdataDestino() {
    return this.dataDestino;
}

public void setdataDestino(Date dataDestino) {
    this.dataDestino = dataDestino;
}

public String gethoraDestino() {
    return this.horaDestino;
}

public void sethoraDestino(String horaDestino) {
    this.horaDestino = horaDestino;
}

@Override
public String toString() {
   String print = "";
   print += "idViagem: " + this.getidViagem() + "\n" ;
   print += "idOnibus: " + this.getidOnibus() + "\n" ;
   print += "idTrecho: " + this.getidTrecho() + "\n" ;
   print += "dataOrigem: " + this.getdataOrigem() + "\n" ;
   print += "horaOrigem: " + this.gethoraOrigem() + "\n" ;
   print += "dataDestino: " + this.getdataDestino() + "\n" ;
   print += "horaDestino: " + this.gethoraDestino() + "\n" ;
   return print;
}
}
