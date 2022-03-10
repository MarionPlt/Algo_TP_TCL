/**
 * @author Marion Playout
 */


package com.playout.tpfinalalgo;

public class Edge {
    private double weight;
    private Dijkstra destination;

    public double getWeight() {
        return weight;
    }

    public Edge(double weight, Dijkstra destination) {
        this.weight = weight;
        this.destination = destination;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Dijkstra getDestination() {
        return destination;
    }

    public void setDestination(Dijkstra destination) {
        this.destination = destination;
    }
}
