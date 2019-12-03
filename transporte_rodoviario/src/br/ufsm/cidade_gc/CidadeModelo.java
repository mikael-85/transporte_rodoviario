/* Arquivo gerado automaticamente */

package br.ufsm.cidade_gc;

import br.ufsm.gerador_cruds2.*;
import java.sql.Date;

public class CidadeModelo implements EntidadeModelo {
/* Atributos */
private Long idCidade;
private String nomeCidade;

/* Metodos Get e Set */
public Long getidCidade() {
    return this.idCidade;
}

public void setidCidade(Long idCidade) {
    this.idCidade = idCidade;
}

public String getnomeCidade() {
    return this.nomeCidade;
}

public void setnomeCidade(String nomeCidade) {
    this.nomeCidade = nomeCidade;
}

@Override
public String toString() {
   String print = "";
   print += "idCidade: " + this.getidCidade() + "\n" ;
   print += "nomeCidade: " + this.getnomeCidade() + "\n" ;
   return print;
}
}
