/* Arquivo gerado automaticamente */

package br.ufsm.bilhete_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

public class BilheteModelo implements EntidadeModelo {
/* Atributos */
private Long idPoltrona;
private Long idViagem;
private String nomeCliente;

/* Metodos Get e Set */
public Long getidPoltrona() {
    return this.idPoltrona;
}

public void setidPoltrona(Long idPoltrona) {
    this.idPoltrona = idPoltrona;
}

public Long getidViagem() {
    return this.idViagem;
}

public void setidViagem(Long idViagem) {
    this.idViagem = idViagem;
}

public String getnomeCliente() {
    return this.nomeCliente;
}

public void setnomeCliente(String nomeCliente) {
    this.nomeCliente = nomeCliente;
}

@Override
public String toString() {
   String print = "";
   print += "idPoltrona: " + this.getidPoltrona() + "\n" ;
   print += "idViagem: " + this.getidViagem() + "\n" ;
   print += "nomeCliente: " + this.getnomeCliente() + "\n" ;
   return print;
}
}
