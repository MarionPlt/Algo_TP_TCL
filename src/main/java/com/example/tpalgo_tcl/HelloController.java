package com.example.tpalgo_tcl;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class HelloController implements Initializable {

    ObservableList<String> stationsTcl = FXCollections.observableArrayList(Graph.getReseauTCL().stream().map(Graph::getName).collect(Collectors.toList()));

    @FXML
    private ComboBox comboDepart;

    @FXML
    private ComboBox comboArrivee;

    @FXML
    private ImageView ivPlan;
    @FXML
    private Label result;
    @FXML
    private void btnRechercherAction (ActionEvent event){


    }

    private StringProperty trajet = new SimpleStringProperty("");




    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        File file = new File("src/main/resources/images/planMetroTCL.png");
        Image image = new Image(file.toURI().toString());
        ivPlan.setImage(image);

        result.textProperty().bind(trajet);

        // get the list of the stations
        comboDepart.setItems(stationsTcl);
        comboArrivee.setItems(stationsTcl);

        //comboDepart.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {


    }

    public ObservableList<String> getStationsTcl() {
        return stationsTcl;
    }

    public void setStationsTcl(ObservableList<String> stationsTcl) {
        this.stationsTcl = stationsTcl;
    }
}

