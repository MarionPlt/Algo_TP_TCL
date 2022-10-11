package com.playout.tpfinalalgo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    //La liste de stations et la liste de noms de stations sont immutables grâce au mot clé "final"
    final List<Dijkstra> stationsTCL = Dijkstra.getReseauTCL();
    Map<String, Dijkstra> stationsMap = new HashMap<>();
    //Utilisation d'une fonction d'ordre supérieur (map)
    final ObservableList<String> stationsTclNames = FXCollections.observableArrayList(stationsTCL.stream().map(Dijkstra::getName).sorted().collect(Collectors.toList()));

    StringProperty valuePropertyProf = new SimpleStringProperty();
    StringProperty valuePropertyDijkstra = new SimpleStringProperty();


    @FXML
    private ComboBox<String> comboDepart;

    @FXML
    private ComboBox<String> comboArrivee;

    @FXML
    private ImageView ivPlan;
    @FXML
    private Label resultProfondeur;

    @FXML
    private Label resultDijkstra;

    /**
     * Procédure lorsqu'on appuie sur le bouton "Rechercher"
     */
    @FXML
    private void btnRechercherAction() {
        Dijkstra depart = stationsMap.get(comboDepart.getValue());
        Dijkstra arrivee = stationsMap.get(comboArrivee.getValue());

        if (depart == null) {
            valuePropertyDijkstra.setValue("pas de gare de depart selectionnée!");
            if (arrivee == null) {
                valuePropertyProf.setValue("pas de gare d'arrivée selectionnée!");
            } else {
                valuePropertyProf.setValue("");
            }

        } else if (arrivee == null) {
            valuePropertyProf.setValue("pas de gare d'arrivée selectionnée!");
            valuePropertyDijkstra.setValue("");

        } else {
            //Parcours de Dijsktra
            Dijkstra.setWaysWithDijkstra(stationsTCL, Objects.requireNonNull(depart));
            long startTime = System.nanoTime();
            String wayDijkstra = Dijkstra.getTheWayForTheLabel(Dijkstra.getTheQuickestWayWithDijkstra(arrivee));
            long stopTime = System.nanoTime();
            String tempsExecDijkstra = "\n Temps d'exécution : ".concat(((Long) (stopTime - startTime)).toString()).concat("ns");
            String parcoursDijsktra = wayDijkstra.concat(tempsExecDijkstra);

            valuePropertyDijkstra.setValue(parcoursDijsktra);

            //après chaque opération de calcul d'itinéraire, remettre les stations aux paramètres initiaux
            Dijkstra.resetStationsParameters(stationsTCL);

            //Parcours en profondeur
            List<Dijkstra> reverseway = new ArrayList<>();
            reverseway.add(arrivee);
            startTime = System.nanoTime();
            depart.determineTheWayInfixeMode(reverseway, Objects.requireNonNull(arrivee));
            String wayInfixe = Dijkstra.getTheWayForTheLabel(reverseway);
            stopTime = System.nanoTime();
            final String tempsExecLongueur = "\n Temps d'exécution : ".concat(((Long) (stopTime - startTime)).toString()).concat("ns");
            final String parcoursLongueur = wayInfixe.concat(tempsExecLongueur);

            valuePropertyProf.setValue(parcoursLongueur);
        }

        resultProfondeur.textProperty().bind(valuePropertyProf);
        resultDijkstra.textProperty().bind(valuePropertyDijkstra);


        //après les deux calculs, remettre les stations aux paramètres initiaux
        Dijkstra.resetStationsParameters(stationsTCL);
    }

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

        //pour générer le .jar
        // Image image = new Image(this.getClass().getResource("/planMetroTCL.png").toString());
        //pour executer en local
        File file = new File("src/main/resources/com/playout/tpfinalalgo/images/planMetroTCL.png");
        Image image = new Image(file.toURI().toString());
        ivPlan.setImage(image);


        for (Dijkstra d : stationsTCL) {
            stationsMap.putIfAbsent(d.getName(), d);
        }

        // récupère la liste des noms de stations du réseau TCL
        comboDepart.setItems(stationsTclNames);
        comboArrivee.setItems(stationsTclNames);

        resultDijkstra.textProperty().bind(new SimpleStringProperty(""));
        resultProfondeur.textProperty().bind(new SimpleStringProperty(""));

    }
}