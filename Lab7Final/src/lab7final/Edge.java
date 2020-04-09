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
public class Edge {
    int x;
    int y;
    
    public Edge() {}
    
    public Edge(int x, int y) {
        if (x > y) {
            this.x = y;
            this.y = x;
        } else {
            this.x = x;
            this.y = y;
        }
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    @Override
    public String toString() {
        return "{ " + x + ", " + y + "}";
    }
}