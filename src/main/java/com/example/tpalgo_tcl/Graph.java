package com.example.tpalgo_tcl;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    int id;
    String name;
    Boolean alreadyDone = false;
    List<Graph> destinations;

    public Graph(int id, List<Graph> destinations) {
        this.id = id;
        this.destinations = destinations;
    }

    public Graph(int id, List<Graph> destinations, String name) {
        this.id = id;
        this.name = name;
        this.destinations = destinations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setDestinations(List<Graph> destinations) {
        this.destinations = destinations;
    }

    public List<Graph> getDestinations() {
        return destinations;
    }

    public void addDestination(Graph g) {
        destinations.add(g);
    }


    /**
     * donne le degré de chaque sommet du graph
     *
     * @param g le sommet
     * @return degré (int)
     */
    public int nodeDegree(Graph g) {
        return g.getDestinations().size();
    }

    /**
     * parcours en largeur
     *
     * @return liste de sommets (integer)
     */
    public List<Integer> breadthFirstSearch() {
        List<Graph> currentPoints = new ArrayList();
        currentPoints.add(this);
        List<Integer> result = new ArrayList();

        while (!currentPoints.isEmpty()) {
            Graph currentGraph = currentPoints.get(0);

            currentPoints.remove(currentGraph);
            if (!result.contains(currentGraph.id)) {
                result.add(currentGraph.id);

                if (currentGraph.destinations != null) {
                    currentPoints.addAll(currentGraph.destinations);
                }
            }
        }
        return result;
    }


    /**
     * parcours en profondeur
     *
     * @param result liste de sommets (int)
     * @return liste de sommets (int)
     */
    public List<Integer> prefixSearch(List<Integer> result) {
        if (!result.contains(this.id)) {
            result.add(this.id);
            if (destinations != null) {
                for (Graph g : destinations) {
                    g.prefixSearch(result);
                }
            }
        }
        return result;
    }


    /**
     * * trouver le chemin entre deux stations a partir parcours infixe
     *
     * @param arrivee     station to go to (Graph)
     * @param reversedWay liste de sommets inversée (Graph)
     * @return liste de sommets (Graph)
     */

    public boolean determineTheWayInfixeMode(List<Graph> reversedWay, Graph arrivee) {
        if (this.id == arrivee.id) {
            return true;
        } else if (!alreadyDone) {
            alreadyDone = true;
            if (destinations != null) {
                for (Graph g : destinations) {
                    if (g.determineTheWayInfixeMode(reversedWay, arrivee)) {
                        reversedWay.add(this);
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /**
     * trouver le chemin entre deux stations a partir parcours en largeur
     */
    public void determineTheWayInfixeModebreadthFirstSearchMode(List<Graph> path, Graph arrivee) {
        List<Graph> currentPoints = new ArrayList();
        currentPoints.add(this);
        while (!currentPoints.isEmpty() && currentPoints.get(0).id != arrivee.id) {
            Graph currentGraph = currentPoints.get(0);
            currentPoints.remove(currentGraph);
            if (!path.contains(currentGraph)) {
                path.add(currentGraph);

                if (currentGraph.destinations != null) {
                    currentPoints.addAll(currentGraph.destinations);
                }
            }
        }
    }


    public String calculEtAfficheLeMeilleurTrajet(Graph depart,Graph arrivee) {
        List<Graph> firstWay = new ArrayList<>();


        String path = "";
        for (Graph w : way) {
            path.concat(w.name + "->");
        }
        return path;

    }

    public static List<Graph> getReseauTCL() {

        Graph gareOullins = new Graph(1, null, "Gare d'Oullins");
        Graph stadeDeGerland = new Graph(2, null, "Stade De Gerland");
        Graph debourg = new Graph(3, null, "Debourg");
        Graph placeJeanJaures = new Graph(4, null, "Place Jean Jaures");
        Graph jeanMace = new Graph(5, null, "Jean Mace");
        Graph saxeGambetta = new Graph(6, null, "Saxe Gambetta");
        Graph placeGuichard = new Graph(7, null, "Place Guichard");
        Graph partDieu = new Graph(8, null, "Part Dieu");
        Graph charpennes = new Graph(9, null, "Charpennes");
        Graph perrache = new Graph(10, null, "Perrache");
        Graph ampere = new Graph(11, null, "Ampere");
        Graph bellecour = new Graph(12, null, "Bellecour");
        Graph cordeliers = new Graph(13, null, "Cordeliers");
        Graph hotelDeVille = new Graph(14, null, "Hotel De Ville");
        Graph foch = new Graph(15, null, "Foch");
        Graph massena = new Graph(16, null, "Massena");
        Graph republique = new Graph(17, null, "Republique");
        Graph gratteCiel = new Graph(18, null, "Gratte Ciel");
        Graph flachet = new Graph(19, null, "Flachet");
        Graph cusset = new Graph(20, null, "cusset");
        Graph laurentBonnevay = new Graph(21, null, "Laurent Bonnevay");
        Graph vaulxEnVelin = new Graph(22, null, "Vaulx-En-Velin");
        Graph gareDeVaise = new Graph(23, null, "Gare De Vaise");
        Graph valmy = new Graph(24, null, "Valmy");
        Graph gorgeDeLoup = new Graph(25, null, "Gorge De Loup");
        Graph vieuxLyon = new Graph(26, null, "Vieux Lyon");
        Graph guillotiere = new Graph(27, null, "Guillotiere");
        Graph garibaldi = new Graph(28, null, "Garibaldi");
        Graph sansSoucis = new Graph(29, null, "Sans-Soucis");
        Graph monplaisirLumiere = new Graph(30, null, "Monplaisir-Lumiere");
        Graph grangeBlanche = new Graph(31, null, "Grange Blanche");
        Graph laennec = new Graph(32, null, "Laennec");
        Graph mermoz = new Graph(33, null, "Mermoz Pinel");
        Graph parilly = new Graph(34, null, "Parilly");
        Graph gareDeVenissieux = new Graph(35, null, "Gare De Venissieux");
        Graph croixPaquet = new Graph(36, null, "Croix-Paquet");
        Graph croixRousse = new Graph(37, null, "Croix-Rousse");
        Graph henon = new Graph(38, null, "Henon");
        Graph cuire = new Graph(39, null, "Cuire");
        Graph brotteaux = new Graph(40, null, "Brotteaux");

        gareDeVaise.setDestinations(List.of(valmy));
        valmy.setDestinations(List.of(gareDeVaise, gorgeDeLoup));
        gorgeDeLoup.setDestinations(List.of(valmy, vieuxLyon));
        vieuxLyon.setDestinations(List.of(gorgeDeLoup, bellecour));
        bellecour.setDestinations(List.of(vieuxLyon, guillotiere, ampere, cordeliers));
        guillotiere.setDestinations(List.of(bellecour, saxeGambetta));
        saxeGambetta.setDestinations(List.of(guillotiere, garibaldi, placeGuichard, jeanMace));
        garibaldi.setDestinations(List.of(saxeGambetta, sansSoucis));
        sansSoucis.setDestinations(List.of(garibaldi, monplaisirLumiere));
        monplaisirLumiere.setDestinations(List.of(sansSoucis, grangeBlanche));
        grangeBlanche.setDestinations(List.of(monplaisirLumiere, laennec));
        laennec.setDestinations(List.of(grangeBlanche, mermoz));
        mermoz.setDestinations(List.of(laennec, parilly));
        parilly.setDestinations(List.of(mermoz, gareDeVenissieux));
        gareDeVenissieux.setDestinations(List.of(parilly));
        gareOullins.setDestinations(List.of(stadeDeGerland));
        stadeDeGerland.setDestinations(List.of(gareOullins, debourg));
        debourg.setDestinations(List.of(stadeDeGerland, placeJeanJaures));
        placeJeanJaures.setDestinations(List.of(debourg, jeanMace));
        jeanMace.setDestinations(List.of(placeJeanJaures, saxeGambetta));
        placeGuichard.setDestinations(List.of(saxeGambetta, partDieu));
        partDieu.setDestinations(List.of(placeGuichard, brotteaux));
        brotteaux.setDestinations(List.of(partDieu, charpennes));
        charpennes.setDestinations(List.of(brotteaux, massena, republique));
        perrache.setDestinations(List.of(ampere));
        ampere.setDestinations(List.of(perrache, bellecour));
        cordeliers.setDestinations(List.of(bellecour, hotelDeVille));
        hotelDeVille.setDestinations(List.of(cordeliers, foch, croixPaquet));
        foch.setDestinations(List.of(hotelDeVille, massena));
        massena.setDestinations(List.of(foch, charpennes));
        republique.setDestinations(List.of(charpennes, gratteCiel));
        gratteCiel.setDestinations(List.of(republique, flachet));
        flachet.setDestinations(List.of(gratteCiel, cusset));
        cusset.setDestinations(List.of(flachet, laurentBonnevay));
        laurentBonnevay.setDestinations(List.of(cusset, vaulxEnVelin));
        vaulxEnVelin.setDestinations(List.of(laurentBonnevay));
        croixPaquet.setDestinations(List.of(hotelDeVille, croixRousse));
        croixRousse.setDestinations(List.of(croixPaquet, henon));
        henon.setDestinations(List.of(croixRousse, cuire));
        cuire.setDestinations(List.of(henon));

        return List.of(//
                gareOullins, stadeDeGerland, debourg, placeJeanJaures, jeanMace, saxeGambetta, placeGuichard, partDieu, charpennes,//
                croixPaquet, croixRousse, henon, cuire,//
                perrache, ampere, bellecour, cordeliers, hotelDeVille, foch, massena, republique, gratteCiel, flachet, cusset, laurentBonnevay, vaulxEnVelin,//
                gareDeVaise, gorgeDeLoup, vieuxLyon, guillotiere, garibaldi, sansSoucis, monplaisirLumiere, grangeBlanche, laennec, mermoz, parilly, gareDeVenissieux);
    }
}


