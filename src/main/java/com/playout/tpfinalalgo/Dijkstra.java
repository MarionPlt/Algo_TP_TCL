/*
  @author Marion Playout
 */

package com.playout.tpfinalalgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public boolean isNotVisited() {
        return !visited;
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
        final List<Edge> edges = dijkstraNodes.stream().map(node -> new Edge(weight, node)).collect(Collectors.toList());
        this.setChildren(edges);
    }

    /**
     * Genere le reseau de stations
     * Fonction pure et idempotente: retourne toujours une liste de stations Dijkstra
     *
     * @return une liste de stations (Dijsktra)
     */
    public static List<Dijkstra> getReseauTCL() {

        //Toutes les stations sont immutables grâce au mot clé "final"
        final Dijkstra gareOullins = new Dijkstra(1, "Gare d'Oullins", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra stadeDeGerland = new Dijkstra(2, "Stade De Gerland", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra debourg = new Dijkstra(3, "Debourg", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra placeJeanJaures = new Dijkstra(4, "Place Jean Jaures", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra jeanMace = new Dijkstra(5, "Jean Mace", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra saxeGambetta = new Dijkstra(6, "Saxe Gambetta", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra placeGuichard = new Dijkstra(7, "Place Guichard", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra partDieu = new Dijkstra(8, "Part Dieu", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra charpennes = new Dijkstra(9, "Charpennes", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra perrache = new Dijkstra(10, "Perrache", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra ampere = new Dijkstra(11, "Ampere", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra bellecour = new Dijkstra(12, "Bellecour", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra cordeliers = new Dijkstra(13, "Cordeliers", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra hotelDeVille = new Dijkstra(14, "Hotel De Ville", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra foch = new Dijkstra(15, "Foch", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra massena = new Dijkstra(16, "Massena", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra republique = new Dijkstra(17, "Republique", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra gratteCiel = new Dijkstra(18, "Gratte Ciel", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra flachet = new Dijkstra(19, "Flachet", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra cusset = new Dijkstra(20, "Cusset", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra laurentBonnevay = new Dijkstra(21, "Laurent Bonnevay", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra vaulxEnVelin = new Dijkstra(22, "Vaulx-En-Velin", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra gareDeVaise = new Dijkstra(23, "Gare De Vaise", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra valmy = new Dijkstra(24, "Valmy", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra gorgeDeLoup = new Dijkstra(25, "Gorge De Loup", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra vieuxLyon = new Dijkstra(26, "Vieux Lyon", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra guillotiere = new Dijkstra(27, "Guillotiere", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra garibaldi = new Dijkstra(28, "Garibaldi", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra sansSoucis = new Dijkstra(29, "Sans-Soucis", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra monplaisirLumiere = new Dijkstra(30, "Monplaisir-Lumiere", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra grangeBlanche = new Dijkstra(31, "Grange Blanche", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra laennec = new Dijkstra(32, "Laennec", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra mermoz = new Dijkstra(33, "Mermoz Pinel", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra parilly = new Dijkstra(34, "Parilly", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra gareDeVenissieux = new Dijkstra(35, "Gare De Venissieux", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra croixPaquet = new Dijkstra(36, "Croix-Paquet", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra croixRousse = new Dijkstra(37, "Croix-Rousse", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra henon = new Dijkstra(38, "Henon", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra cuire = new Dijkstra(39, "Cuire", null, false, Double.POSITIVE_INFINITY, null);
        final Dijkstra brotteaux = new Dijkstra(40, "Brotteaux", null, false, Double.POSITIVE_INFINITY, null);

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
     * Donne le chemin entre deux stations a partir d'un parcours en profondeur infixe
     * Fonction idempotente
     * @param arrivee     station d'arrivee (Dijkstra)
     * @param reversedWay liste de stations (Dijkstra)
     * @return liste de stations (Dijsktra)
     */

    public boolean determineTheWayInfixeMode(List<Dijkstra> reversedWay, Dijkstra arrivee) {
        if (this.getId() == arrivee.getId()) {
            return true;
        } else if (isNotVisited()) {
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
     * Procedure qui determine la longueur des chemins par algorithme de Dijkstra
     * Utilise une fonction d'ordre superieur (map) et de fonctions anonymes
     * @param listNodes   : liste de stations
     * @param currentNode :station de depart (Dijsktra)
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
            List<Dijkstra> unVisitedNodes = listNodes.stream().filter(Dijkstra::isNotVisited).collect(Collectors.toList());
            if (unVisitedNodes.isEmpty()) {
                currentNode = null;
            } else {
                currentNode = Collections.min(unVisitedNodes, Comparator.comparing(Dijkstra::getDistanceFromSource));

            }

        }
    }

    /**
     * Calcule le chemin le plus court pour aller d'un point a un autre
     * Fonction idempotente
     * @return le chemin de stations a parcourir (liste)
     */
    public static List<Dijkstra> getTheQuickestWayWithDijkstra(Dijkstra arrivee) {
        List<Dijkstra> revertedPath = new ArrayList<>();
        Dijkstra currentNode = arrivee;
        while (currentNode.getDistanceFromSource() != 0) {
            revertedPath.add(currentNode);
            currentNode = currentNode.getBestParentFromSource();
        }
        if(currentNode.getDistanceFromSource()==0){
            revertedPath.add(currentNode);
        }

        return revertedPath;
    }

    /**
     * Regroupe tous les noms de stations en une seule string
     * Fonction idempotente
     * Utilise une fonction d'ordre superieur (map) et de fonction anonyme
     * @param way :liste d'objets Dijkstra
     * @return une chaine de caracteres (string)
     */
    public static String getTheWayForTheLabel(List<Dijkstra> way) {
        List<Dijkstra> path = IntStream.iterate(way.size() - 1, i -> i >= 0, i -> i - 1).mapToObj(way::get).collect(Collectors.toList());

        return path.stream().map(Dijkstra::getName).collect(Collectors.joining("->"));

    }

    /**
     * Procedure : permet les stations a leurs parametres par defaut
     *
     * @param stations liste de stations (Dijkstra)
     */
    public static void resetStationsParameters(List<Dijkstra> stations) {
        stations.forEach(station -> {
            station.setVisited(false);
            station.setDistanceFromSource(Double.POSITIVE_INFINITY);
            station.setBestParentFromSource(null);
        });
    }


}



