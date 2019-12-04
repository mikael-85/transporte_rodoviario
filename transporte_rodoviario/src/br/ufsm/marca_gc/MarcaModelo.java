/* Arquivo gerado automaticamente */

package br.ufsm.marca_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

public class MarcaModelo implements EntidadeModelo {
/* Atributos */
private Long idMarca;
private String nomeMarca;
private Long numeroDePoltronas;

/* Metodos Get e Set */
public Long getidMarca() {
    return this.idMarca;
}

public void setidMarca(Long idMarca) {
    this.idMarca = idMarca;
}

public String getnomeMarca() {
    return this.nomeMarca;
}

public void setnomeMarca(String nomeMarca) {
    this.nomeMarca = nomeMarca;
}

public Long getnumeroDePoltronas() {
    return this.numeroDePoltronas;
}

public void setnumeroDePoltronas(Long numeroDePoltronas) {
    this.numeroDePoltronas = numeroDePoltronas;
}

@Override
public String toString() {
   String print = "";
   print += "idMarca: " + this.getidMarca() + "\n" ;
   print += "nomeMarca: " + this.getnomeMarca() + "\n" ;
   print += "numeroDePoltronas: " + this.getnumeroDePoltronas() + "\n" ;
   return print;
}
}
