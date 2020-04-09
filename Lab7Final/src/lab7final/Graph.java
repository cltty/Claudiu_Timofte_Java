/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7final;

/**
 *
 * @author XPS-Claudiu
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import sun.rmi.runtime.Log;

public class Graph {

    int n;
    int k;
    boolean gameOver = false;
    
    List<Edge> edgeList = Collections.synchronizedList(new ArrayList<Edge>());
    List<Edge> usedEdges = Collections.synchronizedList(new ArrayList<Edge>());
    
    String waitingPlayer = "Player 1";
    public Graph() {}

    public Graph(int n, int k) {
        this.n = n;
        this.k = k;        
    }
    
    public void setN(int n) {
        this.n = n;
    }
    
    public void setK(int k) {
        this.k = k;
    } 
    
    
    
    public void setEdges() {
        for (int i = 1 ; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                edgeList.add(new Edge(i, j));
            }
        }
    }
    
    public void setGameOver(boolean sts) {
        this.gameOver = sts;
    }
    
    
    public void setWaitingPlayer(String waitingPlayer) {
        this.waitingPlayer = waitingPlayer;
    }
    
    public String getWaitingPlayer() {
        return waitingPlayer;
    }
    
    public boolean adjancyEdges(Edge e1, Edge e2) {
        //pentru ca muchiile sa fie adiacente este necesar sa aiba o extremitate comuna
        if (e1.getX() == e2.getX() || e1.getX() == e2.getY() || e1.getY() == e2.getX() || e1.getY() == e2.getY())
            return true;
        else
            return false;
    }
    
    public boolean adjancyVerges(int x, int y, List<Edge> muchii) {
        if (x == y) {
            return true;
        } else {
            for (int i = 0; i < muchii.size(); i++) {
                int x1 = muchii.get(i).getX();
                int y1 = muchii.get(i).getY();
                if (x == x1 && y == y1) {
                    return true;
                }
                if (x == y1 && y == x1) {
                    return true;
                }
            }
            return false;
        }
    }
    
    public boolean isKClique(List<Edge> muchii) {
        List<Integer> vergesList = Collections.synchronizedList(new ArrayList<Integer>());
        for (int i = 0; i < muchii.size(); i++) {
            vergesList.add(muchii.get(i).getX());
            vergesList.add(muchii.get(i).getY());
        }
        for (int i = 0; i <vergesList.size() - 1; i++) {
            for (int j = i + 1; j < vergesList.size() j++) {
                if (!adjancyVerges(vergesList.get(i), vergesList.get(j), muchii)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean anyEdgeLeft() {
        if (edgeList.size() == usedEdges.size()) {
            return false;
        } else {
            return true;
        }
    }
     

    public boolean isUsed(Edge edge) {
        for (int i = 0; i < usedEdges.size(); i++) {
            if (usedEdges.get(i).getX() == edge.getX() && usedEdges.get(i).getY() == edge.getY()) {
                return true;//muchia a fost aleasa deja
            }
        }
        return false;
    }
    
    public synchronized Edge pickEdge(String name) {
        if (false == anyEdgeLeft()) {
            return new Edge(-2, -2);
        }
        
        while (name == waitingPlayer) {
            try {
                System.out.println(name + " is waiting..");
                wait();
                System.out.println(name + " starts executing..");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                Log.error("Thread interrupted", e);
            }
        }
      
        this.waitingPlayer = name;
        
        if (false == anyEdgeLeft()) {
            notifyAll();
            return new Edge(-2, -2);
        }
        
        System.out.println("Choose an edge number from bellow..");
        for (int i = 0; i < edgeList.size(); i++) {
            if (!isUsed(edgeList.get(i)))
                System.out.print(i + " -> { " + edgeList.get(i).getX() + ", "+ edgeList.get(i).getY() + "} ");
        }
        System.out.println(" .");
        
        //ar trebui un pic de error Handling here
        Scanner keyboardInput = new Scanner(System.in);
        int edgeIndex = keyboardInput.nextInt();
       
        usedEdges.add(edgeList.get(edgeIndex));
        
        notifyAll();
        return edgeList.get(edgeIndex); 
    }
}
