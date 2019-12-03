/* Arquivo gerado automaticamente */

package br.ufsm.trecho_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

public class TrechoModelo implements EntidadeModelo {
/* Atributos */
private Long idTrecho;
private Long idCidadeOrigem;
private Long idCidadeDestino;

/* Metodos Get e Set */
public Long getidTrecho() {
    return this.idTrecho;
}

public void setidTrecho(Long idTrecho) {
    this.idTrecho = idTrecho;
}

public Long getidCidadeOrigem() {
    return this.idCidadeOrigem;
}

public void setidCidadeOrigem(Long idCidadeOrigem) {
    this.idCidadeOrigem = idCidadeOrigem;
}

public Long getidCidadeDestino() {
    return this.idCidadeDestino;
}

public void setidCidadeDestino(Long idCidadeDestino) {
    this.idCidadeDestino = idCidadeDestino;
}

@Override
public String toString() {
   String print = "";
   print += "idTrecho: " + this.getidTrecho() + "\n" ;
   print += "idCidadeOrigem: " + this.getidCidadeOrigem() + "\n" ;
   print += "idCidadeDestino: " + this.getidCidadeDestino() + "\n" ;
   return print;
}
}
