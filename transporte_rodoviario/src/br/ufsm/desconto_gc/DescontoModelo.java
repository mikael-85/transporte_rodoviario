/* Arquivo gerado automaticamente */

package br.ufsm.desconto_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

public class DescontoModelo implements EntidadeModelo {
/* Atributos */
private Date dataInicio;
private Date dataTermino;
private String horaInicio;
private String horaTermino;
private String desconto;

/* Metodos Get e Set */
public Date getdataInicio() {
    return this.dataInicio;
}

public void setdataInicio(Date dataInicio) {
    this.dataInicio = dataInicio;
}

public Date getdataTermino() {
    return this.dataTermino;
}

public void setdataTermino(Date dataTermino) {
    this.dataTermino = dataTermino;
}

public String gethoraInicio() {
    return this.horaInicio;
}

public void sethoraInicio(String horaInicio) {
    this.horaInicio = horaInicio;
}

public String gethoraTermino() {
    return this.horaTermino;
}

public void sethoraTermino(String horaTermino) {
    this.horaTermino = horaTermino;
}

public String getdesconto() {
    return this.desconto;
}

public void setdesconto(String desconto) {
    this.desconto = desconto;
}

@Override
public String toString() {
   String print = "";
   print += "dataInicio: " + this.getdataInicio() + "\n" ;
   print += "dataTermino: " + this.getdataTermino() + "\n" ;
   print += "horaInicio: " + this.gethoraInicio() + "\n" ;
   print += "horaTermino: " + this.gethoraTermino() + "\n" ;
   print += "desconto: " + this.getdesconto() + "\n" ;
   return print;
}
}
