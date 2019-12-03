/* Arquivo gerado automaticamente */

package br.ufsm.onibus_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

public class OnibusModelo implements EntidadeModelo {
/* Atributos */
private Long idOnibus;
private String marcaModelo;
private Long numeroDePoltronas;

/* Metodos Get e Set */
public Long getidOnibus() {
    return this.idOnibus;
}

public void setidOnibus(Long idOnibus) {
    this.idOnibus = idOnibus;
}

public String getmarcaModelo() {
    return this.marcaModelo;
}

public void setmarcaModelo(String marcaModelo) {
    this.marcaModelo = marcaModelo;
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
   print += "idOnibus: " + this.getidOnibus() + "\n" ;
   print += "marcaModelo: " + this.getmarcaModelo() + "\n" ;
   print += "numeroDePoltronas: " + this.getnumeroDePoltronas() + "\n" ;
   return print;
}
}
