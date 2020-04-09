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
public class Lab7Final {

   
    
    public static void main(String[] args) {
        /*
        --Exempl pentru a demontra functionalitatea RandomPlayer cu timeKeeper ce inceateaza jocul dupa o limita de timp
        Board board = new Board(105, 105,100, "Player 1");
        Game progressionGame = new ProgressionGame(board);
        progressionGame.startGame();
        */
        
        
  /*      
        //--Exemplu pentru a demonstra functionalitatea RandomPlayer fara timekeeper, intrucat valorile din constructor sunt mici(5,5,3).folosind 105, 105, 100 ar dura enorm intrucat extrage valorile random;
        Board board = new Board(5, 5,3, "Player 1");
        Game progressionGame = new ProgressionGame(board);
        progressionGame.startGame();
        
*/
        
        //pentru clique game am folosit ca si paramentri de intrare n=4 si k=3 (cititi de la tastatura)
        //iar ca si alegri pentru Player 2: muchiile cu indicii: 0, 1, 3
        //iar pentru Player 1: 2, 4, 5
        Game  cliqueGame = new CliqueGame();
        cliqueGame.startGame();
        
         
        }
    
}
