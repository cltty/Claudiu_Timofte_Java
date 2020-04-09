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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomPlayer extends Player{
    private boolean exit = false;
    Board board = new Board();
    String name;
    boolean winningStatus = false;

    public boolean running = true;
    
    List<Integer> valuesList = Collections.synchronizedList(new ArrayList<Integer>());
    List<Integer> usedValuesList = Collections.synchronizedList(new ArrayList<Integer>());

    public RandomPlayer() {
    }

    public RandomPlayer(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public void setRunning(boolean status) {
        running  = status;
    }
    
    public boolean checkSolution() {
        if (valuesList.size() == 2) {
            return true;
        }
        if (valuesList.size() > 2) {
            Collections.sort(valuesList);

            int ratie = valuesList.get(1) - valuesList.get(0);

            for (int i = 2; i < valuesList.size(); i++) {
                if (ratie != (valuesList.get(i) - valuesList.get(i - 1))) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean getWinningStatus() {
        return this.winningStatus;
    }

    public boolean sizeReached() {
        if (valuesList.size() == board.progressionLength) {
            return true;
        } else {
            return false;
        }
    }

    public void takeTurn() {
        try {
             System.out.println("Player is thinking..")
             sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        Token t = new Token(board.getRandomToken(this.name));

        System.out.println(this.name + " a ales tokenul cu valorea: " + t.getValue());

        int value = t.getValue();

        if (value != -2) {
            valuesList.add(value);
        }
    }

    @Override
    public void run() {
        try {
             System.out.println("Player is preparing to play..")
             sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name + " started playing");

        while (true == running && true == board.anyTokenLeft() && false == sizeReached()  && !exit ) {

            takeTurn();
        }

        boolean sts = checkSolution();
        if (sts == true) {
            System.out.println("I am " + this.name + " and  I won");
            this.winningStatus = sts;
            board.setGameOver(sts);
        }
    }
    public void stop() {
        exit = true;
    }
}
