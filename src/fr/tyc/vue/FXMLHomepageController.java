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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import fr.tyc.jobs.*;

/**
 *
 * @author 59013-52-07
 */
public class FXMLHomepageController implements Initializable {
    
    //Déclaration des champs de login
    @FXML
    private TextField textNickname;
    @FXML
    private PasswordField pwPassword;
    //Déclaration du bouton de connection
    @FXML
    private Button buttonConnection;
    
    //Méthode du bouton de connection
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        connection(event);
    }

    //Méthode de connection
    private void connection(ActionEvent event) throws IOException {
    try
    {
        if (textNickname.getText().equals("Admin") && pwPassword.getText().equals("Admin"))
        {
            Parent home_Page_parent = FXMLLoader.load(getClass().getResource("FXMLSearchpage.fxml"));
            Scene home_page_scene = new Scene(home_Page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(home_page_scene);
            app_stage.setTitle("Searchpage");
            app_stage.show();
        }
    }
    catch (Exception e)
        {
            e.printStackTrace();
            //System.out.print("Error");
        }   
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        textNickname.setText("Admin");
        pwPassword.setText("Admin");
    }

}
