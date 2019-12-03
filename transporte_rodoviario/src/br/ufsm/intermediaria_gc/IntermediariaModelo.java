/* Arquivo gerado automaticamente */

package br.ufsm.intermediaria_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

public class IntermediariaModelo implements EntidadeModelo {
/* Atributos */
private Long idCidade;
private Long idTrecho;
private Long sequencia;

/* Metodos Get e Set */
public Long getidCidade() {
    return this.idCidade;
}

public void setidCidade(Long idCidade) {
    this.idCidade = idCidade;
}

public Long getidTrecho() {
    return this.idTrecho;
}

public void setidTrecho(Long idTrecho) {
    this.idTrecho = idTrecho;
}

public Long getsequencia() {
    return this.sequencia;
}

public void setsequencia(Long sequencia) {
    this.sequencia = sequencia;
}

@Override
public String toString() {
   String print = "";
   print += "idCidade: " + this.getidCidade() + "\n" ;
   print += "idTrecho: " + this.getidTrecho() + "\n" ;
   print += "sequencia: " + this.getsequencia() + "\n" ;
   return print;
}
}
