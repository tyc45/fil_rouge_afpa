/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.tyc.vue;

import fr.tyc.dao.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.ListSelectionView;
import org.controlsfx.control.RangeSlider;
import fr.tyc.jobs.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import outils.*;

/**
 * FXML Controller class
 *
 * @author 59013-52-07
 */
public class FXMLSearchpageController implements Initializable {

    //Description des champs de recherche
    @FXML
    private TextField townSearch;
    @FXML
    private TextField zipCodeSearch;
    @FXML
    private DatePicker startDateSearch;
    @FXML
    private DatePicker endDateSearch;
    @FXML
    private ComboBox departementSearch;
    @FXML
    private ComboBox radiusSearch;
    @FXML
    private ComboBox regionSearch;
    @FXML
    private RangeSlider priceSearch;
    @FXML
    private ListSelectionView equipServSearch;

    //Description de la table
    @FXML
    private TableView<Gite> tableSearch;
    @FXML
    private TableColumn<Gite, String> nameColumn;
    @FXML
    private TableColumn<Gite, Integer> zipCodeColumn;
    @FXML
    private TableColumn<Gite, String> townColumn;
    @FXML
    private TableColumn<Gite, Integer> capacityColumn;
    @FXML
    private TableColumn<Gite, Integer> animalColumn;

    //Description des champs de détail
    @FXML
    private Label labelName;
    @FXML
    private Label labelOpen;
    @FXML
    private Label labelAdress;
    @FXML
    private Label labelZipCode;
    @FXML
    private Label labelTown;
    @FXML
    private Label labelChambers;
    @FXML
    private Label labelCapacity;
    @FXML
    private Label labelAnimal;
    @FXML
    private Label labelArea;
    @FXML
    private ListView listEquipServ;
    //Description des boutons de détail
    @FXML
    private Button buttonContact;
    @FXML
    private Button buttonOpenningRange;

    //Description des boutons de Crud
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonModifiy;

    //Description des differentes liste utilisées
    private ArrayList<String> townFilter;
    private ObservableList<String> departementFilter;
    //private ArrayList<Rayon> radiusFilter;
    private ObservableList<String> regionFilter;
    private ArrayList<Integer> zipCodeFilter;
    private ArrayList<Gite> filteredGites;
    private GiteDAO choixGite;
    AutoCompletionBinding<String> autoCompletionVille;
     
    
    public FXMLSearchpageController() {

    }

    //Connection à la page ajouter
    @FXML
    private void addPageCon(ActionEvent event) throws IOException {
        String name = "FXMLAddpage.fxml";
        String title = "Addpage";
        connection(event, name, title);
    }
    //Connection à la page modifier
    @FXML
    private void modifyPageCon(ActionEvent event) throws IOException {
        String name = "FXMLAddpage.fxml";
        String title = "Modifypage";
        //todo changename
        /*String labelName = "Modifier un Gite :";
        String buttonName = "Modifier";
        FXMLAddpageController modify = new FXMLAddpageController();
        modify.buttonAdd.setText(buttonName);
        modify.labelTitle.setText(labelName);*/
        connection(event, name, title);
    }
    //Connection aux infos du contact
    @FXML
    private void contactPopUp(ActionEvent event) throws IOException {
        String name = "FXMLContactInfos.fxml";
        String title = "Informations propriétaire";
        connection(event, name, title);
    }
    //Connection aux disponibilitées du gite
    @FXML
    private void openningRangePopUp(ActionEvent event) throws IOException {
        String name = "FXMLOpenningRange.fxml";
        String title = "Informations d'ouverture";
        connection(event, name, title);
    }
    //Méthode de connection lambda à une autre page
    private void connection(ActionEvent event, String name, String title) throws IOException {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(name));
            Scene scene = new Scene(parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene);
            app_stage.setTitle(title);
            app_stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //METHODENONFINAL (init?)
    private void setOnVisibleInformation() {
        //todo setvisibleonwithdata
        /*labelName.setVisible(false);
        labelOpen.setVisible(false);
        labelAdress.setVisible(false);
        labelZipCode.setVisible(false);
        labelTown.setVisible(false);
        labelChambers.setVisible(false);
        labelCapacity.setVisible(false);
        labelAnimal.setVisible(false);
        labelArea.setVisible(false);*/
    }

@Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        //tableSearch.setItems(GiteDAO.getAll());
        tableSearch.setItems(GiteDAO.getLike(0, "", "", ""));
        
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        zipCodeColumn.setCellValueFactory(cellData -> cellData.getValue().cpProperty().asObject());
        townColumn.setCellValueFactory(cellData -> cellData.getValue().nomVilleProperty());
        capacityColumn.setCellValueFactory(cellData -> cellData.getValue().nbCouchagesProperty().asObject());
        animalColumn.setCellValueFactory(cellData -> cellData.getValue().animauxProperty().asObject());
        
        //Ajout d'un écouteur sur la giteTable
        tableSearch.getSelectionModel().selectedItemProperty()
            .addListener((observable,oldValue,newValue) -> showGiteDetail(newValue));
        
        zipCodeSearch.textProperty().addListener(observable -> filterGite());
        
        townFilter = new VilleDAO().getNom();
        autoCompletionVille = TextFields.bindAutoCompletion(townSearch, townFilter);
        townSearch.textProperty().addListener(observable -> filterGite());
        //todo autocompletion
        //Initialisation des comboBox
        departementFilter = new DepartementDAO().getNom();
        departementFilter.add(0, "Choisir un département : ");
        departementSearch.setItems(departementFilter);
        departementSearch.valueProperty().addListener(observable -> filterGite());
        
        regionFilter = new RegionDAO().getNom();
        regionFilter.add(0,"Choisir une région : ");
        regionSearch.setItems(regionFilter);
        regionSearch.valueProperty().addListener(observable -> filterGite());
        
        ObservableList<String> radius = FXCollections.observableArrayList
        ("0", "0-10km", "10-20km", "20-50km", "+50km");
        radiusSearch.setItems(radius);
        //radiusSearch.valueProperty().addListener(observable -> filterGite());
    }

    
 public void showGiteDetail(Gite gite) 
    {
        //Affichage dans le détail
        if (gite != null)
        {
            showDetail();
            labelName.setText(gite.getNom());
            labelZipCode.setText(Integer.toString(gite.getCp()));
            labelTown.setText(gite.getVille().getNom());
            labelAdress.setText(gite.getAdresse());
            labelChambers.setText(Integer.toString(gite.getNbChambres()));
            labelCapacity.setText(Integer.toString(gite.getNbCouchages()));
            labelAnimal.setText(Integer.toString(gite.getAnimaux()));
            labelArea.setText(Integer.toString(gite.getSurface()));
        }
        else
        {
            labelName.setText("");
            labelZipCode.setText("");
            labelTown.setText("");
            labelAdress.setText("");
            labelChambers.setText("");
            labelCapacity.setText("");
            labelAnimal.setText("");
            labelArea.setText("");
        }   
    }
    
    private void showDetail()
    {
        labelName.setVisible(true);
        labelAdress.setVisible(true);
        labelZipCode.setVisible(true);
        labelTown.setVisible(true);
        labelChambers.setVisible(true);
        labelCapacity.setVisible(true);
        labelAnimal.setVisible(true);
        labelArea.setVisible(true);
    }
    /*
    private void deleteGite()
    {
    
    }
    
    private void addGite()
    {
    
    }
    
    private void modifyGite()
    {
    
    }
    
    //Permet de réinitialiser le text town si un département ou une région
    //dont la ville ne fait pas partie est sélectionner
    private void filterTown()
    {
        
    }
    
    //Permet de réinitialiser le text département si ce dernier ne fait pas partie
    // de la région
    private void filterRegion()
    {
    
    }
    */
    @FXML
    private void filterGite()
    {
        int zipCode = 0;
        if(!(zipCodeSearch.getText().equals("")))
        {
            zipCode = Integer.parseInt(zipCodeSearch.getText());
        }
        
        String town = "";
        if(!(townSearch.getText().isEmpty()))
        {
            town = townSearch.getText();
        }
        
        String departement = "";
        if(!(departementSearch.getSelectionModel().getSelectedItem() == null) 
                && (departementSearch.getSelectionModel().getSelectedItem() != "Choisir un département : "))
        {
            departement = ((String) departementSearch.getSelectionModel().getSelectedItem());
        }
        
        String region = "";
        if(!(regionSearch.getSelectionModel().getSelectedItem() == null)
                && (regionSearch.getSelectionModel().getSelectedItem() != "Choisir une région : "))
        {
            region = ((String) regionSearch.getSelectionModel().getSelectedItem());
        }
                
        //PeriodeGite periodeGite = (PeriodeGite) startDateSearch.getValue().get
        //tarif
        //equipement/service
        filterBoxes(departement, region);
        ObservableList<Gite> filteredGite = GiteDAO.getLike(zipCode, town, departement, region);
        tableSearch.setItems(filteredGite);
    }
    
    
    
    private void filterBoxes(String departement, String region)
    {
        departementFilter = new DepartementDAO().getNom(region);
        departementFilter.add(0,"Choisir un département : ");
        departementSearch.setItems(departementFilter);
        
        if(departement != "")
        {
            regionFilter = new RegionDAO().getNom(departement);
        }
        else
        {
            regionFilter = new RegionDAO().getNom();
        }
        regionFilter.add(0,"Choisir une région : ");
        regionSearch.setItems(regionFilter);
        
        if(departement != null && !(departement.equals("Choisir un département : ")))
        {
            townFilter = new VilleDAO().getNom(departement, false);
        }
        else
        {
            townFilter = new VilleDAO().getNom(region, true);
        }
        autoCompletionVille = TextFields.bindAutoCompletion(townSearch, townFilter);
    }
}