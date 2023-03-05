/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24;

import workshop3a24.Entities.Personne;
import workshop3a24.Entities.Voiture;
import workshop3a24.Services.ServicePersonne;
import workshop3a24.Services.ServiceVehicule;
import workshop3a24.Utils.MyDB;

/**
 *
 * @author Mohamed
 */
public class Workshop3A24 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServicePersonne sp = new ServicePersonne();
        ServiceVehicule sv = new ServiceVehicule();
        //Personne p = new Personne("Fahed Stal");
        //sp.add(p);
        //System.out.println(sp.afficher());
        Voiture v = new Voiture("406", 3);
        sv.add(v);
        System.out.println(sv.afficher());
    }

}
