/* Arquivo gerado automaticamente */

package br.ufsm.onibus_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

public class OnibusModelo implements EntidadeModelo {
/* Atributos */
private Long idOnibus;
private Long idMarca;

/* Metodos Get e Set */
public Long getidOnibus() {
    return this.idOnibus;
}

public void setidOnibus(Long idOnibus) {
    this.idOnibus = idOnibus;
}

public Long getidMarca() {
    return this.idMarca;
}

public void setidMarca(Long idMarca) {
    this.idMarca = idMarca;
}

@Override
public String toString() {
   String print = "";
   print += "idOnibus: " + this.getidOnibus() + "\n" ;
   print += "idMarca: " + this.getidMarca() + "\n" ;
   return print;
}
}
