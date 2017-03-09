/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.tyc.vue;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.ListSelectionView;
import fr.tyc.jobs.*;

/**
 * FXML Controller class
 *
 * @author 59013-52-07
 */
public class FXMLAddpageController implements Initializable {

    //Déclaration du titre de la page
    @FXML
    private Label labelTitle;
    //Déclaration des champs d'ajout
    @FXML
    private TextField textName;
    @FXML
    private TextField textId;
    @FXML
    private TextField textAdress;
    @FXML
    private TextField textZipCode;
    @FXML
    private TextField textTown;
    @FXML
    private TextField textChambers;
    @FXML
    private TextField textCapacity;
    @FXML
    private TextField textAnimal;
    @FXML
    private TextField textArea;
    @FXML
    private ListSelectionView viewEquipServ;
    //Déclaration des boutons
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonCancel;
    
    //todo changename
    /*public void FXMLSearchpageController(String name, String title) {
        this.labelTitle.setText(title);
        this.buttonAdd.setText(name);
    }*/
    
    //Méthode pour retourner à la page de recherche
    @FXML
    private void returnToSearchPage(ActionEvent event) throws IOException {
        String name = "FXMLSearchpage.fxml";
        String title = "Searchpage";
        connection (event, name, title);
    }
    //Méthode de connection lambda à une autre page
    private void connection(ActionEvent event, String name, String title) throws IOException {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(name));
            Scene scene = new Scene(parent);
            Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.setTitle(title);
            app_stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
