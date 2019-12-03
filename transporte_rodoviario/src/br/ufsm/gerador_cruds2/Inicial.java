/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufsm.gerador_cruds2;

/**
 *
 * @author Patrick Guerra
 */
public class Inicial {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Metadata metadata;
        ControladorClasses controladorClasses;
    
        // Obter metadados do BD
        metadata = new Metadata();
        controladorClasses = new ControladorClasses(metadata.getTabelas());
    }

}
