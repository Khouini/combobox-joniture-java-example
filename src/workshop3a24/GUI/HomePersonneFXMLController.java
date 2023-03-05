/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import workshop3a24.Entities.Personne;
import workshop3a24.Entities.Voiture;
import workshop3a24.Services.ServicePersonne;
import workshop3a24.Services.ServiceVehicule;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class HomePersonneFXMLController implements Initializable {

    @FXML
    private TextField voitureField;

    @FXML
        private ComboBox<String> personneField;

    @FXML
    private Label lresultat;
    
    private int idPersonneToAdd;
    
    private void setIdPersonneToAdd(int id){
        this.idPersonneToAdd = id;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ServicePersonne sp = new ServicePersonne();
        List<String> noms = new ArrayList<>();
        for (Personne p : sp.afficher()) {
            noms.add(p.getNom());
        }
        personneField.setItems(FXCollections.observableArrayList(noms));
        
        personneField.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // get the selected Personne object based on the selected nom value
                Personne selectedPersonne = null;
                for (Personne p : sp.afficher()) {
                    if (p.getNom().equals(newValue)) {
                        selectedPersonne = p;
                        break;
                    }
                }

                if (selectedPersonne != null) {
                    int id = selectedPersonne.getId();
                    System.out.println("Selected Personne id: " + id);
                    // do something with the id...
                    setIdPersonneToAdd(id);
                }
            }
        });
    }

    @FXML
    private void ajouter(ActionEvent event) {
        ServiceVehicule sp= new ServiceVehicule();
        Voiture v = new Voiture(voitureField.getText(), idPersonneToAdd);
        sp.add(v);
        System.out.println("adding success");
    }

    @FXML
    private void afficher(ActionEvent event) {
        ServiceVehicule sp= new ServiceVehicule();
        lresultat.setText(sp.afficher().toString());

    }

}
