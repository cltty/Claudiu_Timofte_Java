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
import static java.lang.Thread.sleep;
import java.util.Scanner;

public class CliqueGame extends Game {
    public Graph graph = new Graph();
    
    public CliqueGame() {
        System.out.println("Type values for n and k..");
        Scanner myInput = new Scanner(System.in);
        
        int n = myInput.nextInt();
        int k = myInput.nextInt();
        
        graph.setN(n);
        graph.setK(k);
        graph.setEdges();
        
    }
    
    public void startGame() {
        System.out.println("Start clique game");
        
        try {
            System.out.println("The game is about to start..Loading..")
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
       
        
        System.out.println("Start game");
        
        CliquePlayer p2 = new CliquePlayer("Player 2");
        p2.setGraph(graph);
        new Thread(p2).start();
        
        CliquePlayer p1 = new CliquePlayer("Player 1");
        p1.setGraph(graph);
        new Thread(p1).start();

    }
    
}
