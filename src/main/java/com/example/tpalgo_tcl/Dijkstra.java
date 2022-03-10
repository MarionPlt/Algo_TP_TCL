/**
 * @author Marion Playout
 */

package com.example.tpalgo_tcl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Dijkstra {
    private int id;
    private String name;
    private List<Edge> children;
    private boolean visited;
    private double distanceFromSource; //distance optimale de la source au noeud Dijsktra
    private Dijkstra bestParentFromSource; //itineraire associe au distanceFromSource

    public Dijkstra(int id, String name, List<Edge> children) {
        this.id = id;
        this.name = name;
        this.children = children;
    }

    public Dijkstra(int id, String name, List<Edge> children, boolean visited, double distanceFromSource, Dijkstra bestParentFromSource) {
        this.id = id;
        this.name = name;
        this.children = children;
        this.visited = visited;
        this.distanceFromSource = distanceFromSource;
        this.bestParentFromSource = bestParentFromSource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getChildren() {
        return children;
    }

    public void setChildren(List<Edge> children) {
        this.children = children;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public double getDistanceFromSource() {
        return distanceFromSource;
    }

    public void setDistanceFromSource(double distanceFromSource) {
        this.distanceFromSource = distanceFromSource;
    }

    public Dijkstra getBestParentFromSource() {
        return bestParentFromSource;
    }

    public void setBestParentFromSource(Dijkstra bestParentFromSource) {
        this.bestParentFromSource = bestParentFromSource;
    }

    public void setEdges(double weight, List<Dijkstra> dijkstraNodes) {
        List<Edge> edges = dijkstraNodes.stream().map(node -> new Edge(weight, node)).collect(Collectors.toList());
        this.setChildren(edges);
    }

    /**
     * Genere le reseau de stations
     *
     * @return une liste de stations (Dijsktra)
     */
    public static List<Dijkstra> getReseauTCL() {

        Dijkstra gareOullins = new Dijkstra(1, "Gare d'Oullins", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra stadeDeGerland = new Dijkstra(2, "Stade De Gerland", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra debourg = new Dijkstra(3, "Debourg", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra placeJeanJaures = new Dijkstra(4, "Place Jean Jaures", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra jeanMace = new Dijkstra(5, "Jean Mace", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra saxeGambetta = new Dijkstra(6, "Saxe Gambetta", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra placeGuichard = new Dijkstra(7, "Place Guichard", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra partDieu = new Dijkstra(8, "Part Dieu", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra charpennes = new Dijkstra(9, "Charpennes", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra perrache = new Dijkstra(10, "Perrache", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra ampere = new Dijkstra(11, "Ampere", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra bellecour = new Dijkstra(12, "Bellecour", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra cordeliers = new Dijkstra(13, "Cordeliers", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra hotelDeVille = new Dijkstra(14, "Hotel De Ville", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra foch = new Dijkstra(15, "Foch", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra massena = new Dijkstra(16, "Massena", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra republique = new Dijkstra(17, "Republique", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra gratteCiel = new Dijkstra(18, "Gratte Ciel", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra flachet = new Dijkstra(19, "Flachet", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra cusset = new Dijkstra(20, "Cusset", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra laurentBonnevay = new Dijkstra(21, "Laurent Bonnevay", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra vaulxEnVelin = new Dijkstra(22, "Vaulx-En-Velin", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra gareDeVaise = new Dijkstra(23, "Gare De Vaise", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra valmy = new Dijkstra(24, "Valmy", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra gorgeDeLoup = new Dijkstra(25, "Gorge De Loup", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra vieuxLyon = new Dijkstra(26, "Vieux Lyon", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra guillotiere = new Dijkstra(27, "Guillotiere", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra garibaldi = new Dijkstra(28, "Garibaldi", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra sansSoucis = new Dijkstra(29, "Sans-Soucis", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra monplaisirLumiere = new Dijkstra(30, "Monplaisir-Lumiere", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra grangeBlanche = new Dijkstra(31, "Grange Blanche", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra laennec = new Dijkstra(32, "Laennec", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra mermoz = new Dijkstra(33, "Mermoz Pinel", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra parilly = new Dijkstra(34, "Parilly", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra gareDeVenissieux = new Dijkstra(35, "Gare De Venissieux", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra croixPaquet = new Dijkstra(36, "Croix-Paquet", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra croixRousse = new Dijkstra(37, "Croix-Rousse", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra henon = new Dijkstra(38, "Henon", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra cuire = new Dijkstra(39, "Cuire", null, false, Double.POSITIVE_INFINITY, null);
        Dijkstra brotteaux = new Dijkstra(40, "Brotteaux", null, false, Double.POSITIVE_INFINITY, null);

        valmy.setEdges(1, List.of(gareDeVaise, gorgeDeLoup));
        gareDeVaise.setEdges(1, List.of(valmy));
        gorgeDeLoup.setEdges(1, List.of(valmy, vieuxLyon));
        vieuxLyon.setEdges(1, List.of(gorgeDeLoup, bellecour));
        bellecour.setEdges(2, List.of(vieuxLyon, guillotiere, ampere, cordeliers));
        guillotiere.setEdges(1, List.of(bellecour, saxeGambetta));
        saxeGambetta.setEdges(2, List.of(placeGuichard, jeanMace, guillotiere, garibaldi));
        garibaldi.setEdges(1, List.of(saxeGambetta, sansSoucis));
        sansSoucis.setEdges(1, List.of(garibaldi, monplaisirLumiere));
        monplaisirLumiere.setEdges(1, List.of(sansSoucis, grangeBlanche));
        grangeBlanche.setEdges(1, List.of(monplaisirLumiere, laennec));
        laennec.setEdges(1, List.of(grangeBlanche, mermoz));
        mermoz.setEdges(1, List.of(laennec, parilly));
        parilly.setEdges(1, List.of(mermoz, gareDeVenissieux));
        gareDeVenissieux.setEdges(1, List.of(parilly));
        gareOullins.setEdges(1, List.of(stadeDeGerland));
        stadeDeGerland.setEdges(1, List.of(gareOullins, debourg));
        debourg.setEdges(1, List.of(stadeDeGerland, placeJeanJaures));
        placeJeanJaures.setEdges(1, List.of(debourg, jeanMace));
        jeanMace.setEdges(1, List.of(placeJeanJaures, saxeGambetta));
        placeGuichard.setEdges(1, List.of(saxeGambetta, partDieu));
        partDieu.setEdges(1, List.of(placeGuichard, brotteaux));
        brotteaux.setEdges(1, List.of(partDieu, charpennes));
        charpennes.setEdges(2, List.of(brotteaux, massena, republique));
        perrache.setEdges(1, List.of(ampere));
        ampere.setEdges(1, List.of(perrache, bellecour));
        cordeliers.setEdges(1, List.of(bellecour, hotelDeVille));
        hotelDeVille.setEdges(2, List.of(cordeliers, foch, croixPaquet));
        foch.setEdges(1, List.of(hotelDeVille, massena));
        massena.setEdges(1, List.of(foch, charpennes));
        republique.setEdges(1, List.of(charpennes, gratteCiel));
        gratteCiel.setEdges(1, List.of(republique, flachet));
        flachet.setEdges(1, List.of(gratteCiel, cusset));
        cusset.setEdges(1, List.of(flachet, laurentBonnevay));
        laurentBonnevay.setEdges(1, List.of(cusset, vaulxEnVelin));
        vaulxEnVelin.setEdges(1, List.of(laurentBonnevay));
        croixPaquet.setEdges(1, List.of(hotelDeVille, croixRousse));
        croixRousse.setEdges(1, List.of(croixPaquet, henon));
        henon.setEdges(1, List.of(croixRousse, cuire));
        cuire.setEdges(1, List.of(henon));

        return List.of(//
                gareOullins, stadeDeGerland, debourg, placeJeanJaures, jeanMace, saxeGambetta, placeGuichard, partDieu, charpennes,//
                croixPaquet, croixRousse, henon, cuire,//
                perrache, ampere, bellecour, cordeliers, hotelDeVille, foch, massena, republique, gratteCiel, flachet, cusset, laurentBonnevay, vaulxEnVelin,//
                gareDeVaise, valmy, gorgeDeLoup, vieuxLyon, guillotiere, garibaldi, sansSoucis, monplaisirLumiere, grangeBlanche, laennec, mermoz, parilly, gareDeVenissieux);

    }


    /**
     * * Donne le chemin entre deux stations a partir d'un parcours en profondeur infixe
     *
     * @param arrivee     station d'arrivée (Dijkstra)
     * @param reversedWay liste de stations (Dijkstra)
     * @return liste de stations (Dijsktra)
     */

    public boolean determineTheWayInfixeMode(List<Dijkstra> reversedWay, Dijkstra arrivee) {
        if (this.getId() == arrivee.getId()) {
            return true;
        } else if (!isVisited()) {
            setVisited(true);
            if (getChildren() != null) {
                for (Edge g : getChildren()) {
                    if (g.getDestination().determineTheWayInfixeMode(reversedWay, arrivee)) {
                        reversedWay.add(this);
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /**
     * Determine la longueur des chemins par algorithme de Dijkstra
     *
     * @param listNodes   : liste de stations
     * @param currentNode :station de départ (Dijsktra)
     */
    public static void setWaysWithDijkstra(List<Dijkstra> listNodes, Dijkstra currentNode) {
        currentNode.setDistanceFromSource(0);
        while (currentNode != null) {
            currentNode.setVisited(true);
            if (!currentNode.getChildren().isEmpty()) {
                for (Edge child : currentNode.getChildren()) {
                    if (child.getDestination().getDistanceFromSource() > (currentNode.getDistanceFromSource() + child.getWeight())) {
                        child.getDestination().setDistanceFromSource(currentNode.getDistanceFromSource() + child.getWeight());
                        child.getDestination().setBestParentFromSource(currentNode);
                    }

                }
            }
            List<Dijkstra> unVisitedNodes = listNodes.stream().filter(n -> !n.isVisited()).collect(Collectors.toList());
            if (unVisitedNodes.isEmpty()) {
                currentNode = null;
            } else {
                currentNode = Collections.min(unVisitedNodes, Comparator.comparing(Dijkstra::getDistanceFromSource));

            }

        }
    }

    /**
     * Calcule le chemin le plus court pour aller d'un point a un autre
     *
     * @return le chemin de stations a parcourir (liste)
     */
    public static List<Dijkstra> getTheQuickestWayWithDijkstra(Dijkstra arrivee) {
        List<Dijkstra> revertedPath = new ArrayList<>();
        Dijkstra currentNode = arrivee;
        while (currentNode.getDistanceFromSource() != 0) {
            revertedPath.add(currentNode);
            currentNode = currentNode.getBestParentFromSource();
        }

        return revertedPath;
    }

    /**
     * Regroupe tous les noms de stations en une seule string
     *
     * @param way :liste d'objets Dijkstra
     * @return une chaine de caracteres (string)
     */
    public static String getTheWayForTheLabel(List<Dijkstra> way) {
        List<Dijkstra> path = new ArrayList<>();
        for (int i = way.size() - 1; i >= 0; i--) {
            path.add(way.get(i));
        }

        return path.stream().map(Dijkstra::getName).collect(Collectors.joining("->"));

    }

    /**
     * Remet les stations a leurs parametres par défaut
     *
     * @param stations liste de stations (Dijkstra)
     */
    public static void resetStationsParameters(List<Dijkstra> stations) {
        for (Dijkstra station : stations) {
            station.setVisited(false);
            station.setDistanceFromSource(Double.POSITIVE_INFINITY);
            station.setBestParentFromSource(null);
        }
    }


}



