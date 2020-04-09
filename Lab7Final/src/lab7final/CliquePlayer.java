/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7final;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author XPS-Claudiu
 */
public class CliquePlayer implements Runnable {

    String name;
    List<Edge> edgeList = Collections.synchronizedList(new ArrayList<Edge>());
    Graph graph = new Graph();
    public boolean running = true;
    public boolean winningStatus = false;

    public CliquePlayer() {
    }

    public CliquePlayer(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public boolean sizeReached() {
        if (edgeList.size() == graph.k) {
            return true;
        } else {
            return false;
        }
    }

    public void takeTurn() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        Edge edge = new Edge();
       
        edge = graph.pickEdge(this.name);

        System.out.println(this.name + " a ales muchia " + edge.toString());

        if (edge.getX() != -2 && edge.getY() != -2) {
            edgeList.add(edge);
        }
    }

    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name + " started playing clique game..");

        while (true == running && true == graph.anyEdgeLeft() && false == sizeReached()) {
         
            takeTurn();
        
        }
        
        System.out.println(this.name + " solution:");
        for (int i = 0; i < edgeList.size(); i++) {
            System.out.println(edgeList.get(i));
        }
        
        boolean sts = graph.isKClique(edgeList);
        if (sts == true) {
            running = false;
            System.out.println(this.name + " has won! ");
            graph.setGameOver(true);
            this.winningStatus = true;
        }
    }
}
