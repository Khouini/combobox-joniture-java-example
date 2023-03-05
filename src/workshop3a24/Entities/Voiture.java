/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.Entities;

/**
 *
 * @author Trunks
 */
public class Voiture {

    private String label, nomPersonne;
    private int idPersonne;

    public Voiture(String label, int idPersonne) {
        this.label = label;
        this.idPersonne = idPersonne;
    }

    public Voiture() {
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNomPersonne() {
        return nomPersonne;
    }

    public void setNomPersonne(String nomPersonne) {
        this.nomPersonne = nomPersonne;
    }

    @Override
    public String toString() {
        return "Voiture{" + "label=" + label + ", nomPersonne=" + nomPersonne + '}';
    }

    
    

}
