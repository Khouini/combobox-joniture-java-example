/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import workshop3a24.Entities.Personne;
import workshop3a24.Entities.Voiture;
import workshop3a24.Utils.MyDB;

/**
 *
 * @author Trunks
 */
public class ServiceVehicule implements IService<Voiture> {

    Connection cnx;

    @Override
    public void add(Voiture t) {
        try {
            String qry = "INSERT INTO `voiture` (`label`, `idPersonne`) VALUES ('" + t.getLabel() + "', '" + t.getIdPersonne() + "')";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            stm.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Voiture> afficher() {
        List<Voiture> voitures = new ArrayList<>();
        try {
            String qry = "SELECT label, nom FROM `personne` JOIN `voiture` ON personne.id = voiture.idPersonne;";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Voiture p = new Voiture();
                p.setNomPersonne(rs.getString("nom"));
                p.setLabel(rs.getString("label"));
                voitures.add(p);
            }
            return voitures;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return voitures;

    }

    @Override
    public void modifier(Voiture t) {
    }

    @Override
    public void supprimer(Voiture t) {
    }

}
