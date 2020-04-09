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
import java.util.Scanner;
import sun.rmi.runtime.Log;

public class Board {

    public List<Token> tokens = Collections.synchronizedList(new ArrayList<Token>());
    public List<Token> usedTokens = Collections.synchronizedList(new ArrayList<Token>());

    int tokensNumber;
    int maxTokenValue;
    int progressionLength;
    boolean gameOver = false;
    String waitingPlayer;

    public Board() {
        this.gameOver = false;
        this.waitingPlayer = "Player 1";
    }

    public Board(int tokensNumber, int maxTokenValue, int progressionLength, String waitingPlayer) {
        this.tokensNumber = tokensNumber;
        this.maxTokenValue = maxTokenValue;
        this.progressionLength = progressionLength;
        this.gameOver = false;
        this.waitingPlayer = waitingPlayer;
    }

    public void setWaitingPlayer(String name) {
        System.out.println("NOW " + name + "SHOULD WAIT!");
        this.waitingPlayer = name;
    }

    public String getWaitingPlayer() {
        return waitingPlayer;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean getGameOver() {
        return gameOver;
    }

    public void setTokens() {
        System.out.println("A random list of unique tokens is being generated.Be patient!");
        try {
            System.out.println("Player is preparing to play..")
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < tokensNumber; i++) {
            int value = 0 + (int) (Math.random() * maxTokenValue);
            Token t = new Token(value);

            if (false == isUsed(t)) {
                tokens.add(t);
                usedTokens.add(t);
            } else {
                while (true == isUsed(t)) {
                    //updatez token-ul curent pana obtin unul nefolosit
                    value = 0 + (int) (Math.random() * maxTokenValue);
                    t.setValue(value);
                }
                usedTokens.add(t);
                tokens.add(t);
            }
        }
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
        this.usedTokens = tokens;
    }

    public void resetUsedTokens() {
        System.out.println("Reseting usedTokens list..");
        this.usedTokens.clear();
    }

    public void printUsedTokens() {
        System.out.println("Used tokens are");
        for (int i = 0; i < usedTokens.size(); i++) {
            System.out.print(usedTokens.get(i).getValue() + " ");
        }
        System.out.println("**");
    }

    public void printTokenList() {
        for (int i = 0; i < tokens.size(); i++) {
            System.out.print(tokens.get(i).getValue() + " ");
        }
        System.out.println(" ** ");
    }

    private boolean isUsed(Token token) {
        if (usedTokens.size() == 0) {
            return false;
        }
        int tokenValue = token.getValue();

        /*
        
         if (tokenValue == -1) {
         //this is a blank TOKEN.paote lua orice valoare, deci resturnez false;
         //poate fi un feature ptr modul Smart, astfel player-ul alegand doar Tokenii blank, care pot lua orice valoare 
         return false;
         }
         */
        for (int i = 0; i < usedTokens.size(); i++) {
            if (usedTokens.get(i).getValue() == tokenValue) {
                return true;
            }
        }
        return false;
    }

    public int getProgressionLength() {
        return this.progressionLength;
    }

    public int getLeftTokens() {
        int x = tokens.size() - usedTokens.size();
        return x;
    }

    public boolean tokenUsed(int value) {
        for (int i = 0; i < usedTokens.size(); i++) {
            if (value == usedTokens.get(i).getValue()) {
                return true;//is used
            }
        }
        return false;
    }

    public boolean anyTokenLeft() {
        int x = this.tokens.size() - this.usedTokens.size();
        if (x > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getSmaller(int biggest) {
        int newBiggest = tokens.get(0).getValue();
        for (int i = 1; i < tokens.size(); i++) {
            int val = tokens.get(i).getValue();
            if (val < biggest) {
                if (val > newBiggest) {
                    newBiggest = val;
                }
            }
        }
        return newBiggest;
    }

    public synchronized int getManualToken(String name) {
        if (false == anyTokenLeft()) {
            return -2;
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
        
        if (false == anyTokenLeft()) {
            notifyAll();
            return -2;
        }

        Scanner keyboardInput = new Scanner(System.in);
        int manualToken = keyboardInput.nextInt();
        if (usedTokens.size() == 0) {
            //niciun token ales pana in momentul dat
            //usedTokens.add(new Token(value)); //marchez ca si folosit
            System.out.println("There are no tokens selected so far.Choose any!Type bellow Token Value!");
            int manualToken = keyboardInput.nextInt();
        
            usedTokens.add(new Token(manualToken));

            notifyAll();

            return manualToken;
        } else {
           System.out.println("Used tokens so far:");
           for (int i = 0; i < usedTokens.size(); i++) {
               System.out.print(usedTokens.get(i).getValue() + "   ") ;
           } System.out.println(".");
           
            manualToken = keyboardInput.nextInt();
            
            while (tokenUsed(manualToken) == true) {
               manualToken = keyboardInput.nextInt();//get another one thay my be unused
            }

            usedTokens.add(new Token(manualToken));
            notifyAll();
            return manualToken;
        }

    }
    

    public synchronized int getSmartToken(String name) {
        if (false == anyTokenLeft()) {
            return -2;
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

        if (false == anyTokenLeft()) {
            notifyAll();
            return -2;
        }

        if (usedTokens.size() == 0) {
            //niciun token ales pana in momentul dat
            //usedTokens.add(new Token(value)); //marchez ca si folosit
            int smallest = tokens.get(0).getValue();
            for (int i = 1; i < tokens.size(); i++) {
                if (tokens.get(i).getValue() < smallest) {
                    smallest = tokens.get(i).getValue();
                }
            }
            usedTokens.add(new Token(smallest));

            notifyAll();

            return smallest;
        } else {
            int biggest = tokens.get(0).getValue();

            while (tokenUsed(biggest) == true) {
                biggest = getSmaller(biggest);//get another one thay my be unused
            }

            usedTokens.add(new Token(biggest));
            notifyAll();
            return biggest;
        }
    }

    public synchronized int getRandomToken(String name) {
        if (false == anyTokenLeft()) {
            return -2;
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

        if (false == anyTokenLeft()) {
            notifyAll();
            return -2;
        }

        int index = 0 + (int) (Math.random() * tokens.size() - 1);
        int value = tokens.get(index).getValue();

        if (usedTokens.size() == 0) {
            //niciun token ales pana in momentul dat
            //usedTokens.add(new Token(value)); //marchez ca si folosit
            usedTokens.add(new Token(value));

            notifyAll();

            return value;
        } else {
            //nu este primul token extras de pe tabla, deci trebuie verificata unicitatea
            if (tokenUsed(value) == false) {
                usedTokens.add(new Token(value));

                notifyAll();

                return value;
            } else {
                while (tokenUsed(value) == true) {
                    index = 0 + (int) (Math.random() * tokens.size());

                    value = tokens.get(index).getValue();
                }

                usedTokens.add(new Token(value));
                notifyAll();
                return value;
            }
        }
    }
}
