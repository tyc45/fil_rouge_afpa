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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import fr.tyc.jobs.*;

/**
 * FXML Controller class
 *
 * @author 59013-52-07
 */
public class FXMLContactInfosController implements Initializable {

    //todo try to return on close
    @FXML
    private Label firstNameDetail;
    @FXML
    private Label lastNameDetail;
    @FXML
    private Label phoneDetail;
    @FXML
    private Label adressDetail;
    @FXML
    private Label mailDetail;
    @FXML
    private Button buttonReturn;
    @FXML
    private GridPane gridContactInfos;
    
    //Méthode de retour à la page de recherche
    @FXML
    private void returnToSearchPage(ActionEvent event) throws IOException {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("FXMLSearchpage.fxml"));
            Scene scene = new Scene(parent);
            Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.setTitle("Searchpage");
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
