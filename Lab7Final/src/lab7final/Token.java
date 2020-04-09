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
public class Token {
    int value;
    
    //constructor ptr cazul in care un token este blank(poate avea orice valoare)
    public Token() {
        this.value = -1;
    }
    
    public Token(int value) {
        this.value = value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
