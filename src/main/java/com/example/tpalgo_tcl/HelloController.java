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
import java.util.*;
import java.util.stream.Collectors;

public class HelloController implements Initializable {

    List<Dijkstra> stationsTCL = Dijkstra.getReseauTCL();
    Map<String, Dijkstra> stationsMap = new HashMap<>();
    ObservableList<String> stationsTclNames = FXCollections.observableArrayList(stationsTCL.stream().map(Dijkstra::getName).collect(Collectors.toList()));

    StringProperty valuePropertyProf = new SimpleStringProperty();
    StringProperty valuePropertyDijkstra = new SimpleStringProperty();
    StringProperty valuePropertyGareDepart = new SimpleStringProperty();


    @FXML
    private ComboBox comboDepart;

    @FXML
    private ComboBox comboArrivee;

    @FXML
    private ImageView ivPlan;
    @FXML
    private Label resultProfondeur;

    @FXML
    private Label resultDijkstra;
    @FXML
    private Label labelGareDeDepart;


    @FXML
    private void btnRechercherAction(ActionEvent event) {
        Dijkstra depart = stationsMap.get(comboDepart.getValue());
        if (depart == null) {
            System.out.println("pas de gare de depart selectionnée!");
        }
        Dijkstra arrivee = stationsMap.get(comboArrivee.getValue());
        if (arrivee == null) {
            System.out.println("pas de gare d'arrivée selectionnée!");
        }
        valuePropertyGareDepart.setValue("Gare de départ : " + depart.getName());

        Dijkstra.setWaysWithDijkstra(stationsTCL, depart);
        String wayDijkstra = Dijkstra.getTheWayForTheLabel(Dijkstra.getTheQuickestWayWithDijkstra(arrivee), false);
        valuePropertyDijkstra.setValue(wayDijkstra);

        //après chaque opération de calcul d'itinéraire, remettre à false le parametre isVisited pour toutes les stations
        stationsTCL.forEach(d -> d.setVisited(false));

        List<Dijkstra> reverseway = new ArrayList<>();
        depart.determineTheWayInfixeMode(reverseway, arrivee);
        String wayInfixe = Dijkstra.getTheWayForTheLabel(reverseway, true);
        valuePropertyProf.setValue(wayInfixe);

        //après chaque opération de calcul d'itinéraire, remettre à false le parametre isVisited pour toutes les stations
        stationsTCL.forEach(d -> d.setVisited(false));

        labelGareDeDepart.textProperty().bind(valuePropertyGareDepart);
        resultProfondeur.textProperty().bind(valuePropertyProf);
        resultDijkstra.textProperty().bind(valuePropertyDijkstra);

    }

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        File file = new File("src/main/resources/images/planMetroTCL.png");
        Image image = new Image(file.toURI().toString());
        ivPlan.setImage(image);


        for (Dijkstra d : stationsTCL) {
            stationsMap.putIfAbsent(d.getName(), d);
        }

        // get the list of the stations
        comboDepart.setItems(stationsTclNames);
        comboArrivee.setItems(stationsTclNames);

        resultDijkstra.textProperty().bind(new SimpleStringProperty(""));
        resultProfondeur.textProperty().bind(new SimpleStringProperty(""));

    }
}

