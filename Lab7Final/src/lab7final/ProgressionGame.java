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
import java.util.Timer;
import java.util.TimerTask;

public class ProgressionGame extends Game {

    private Board board;
    private RandomPlayer player1;
    private RandomPlayer player2;

    public ProgressionGame(Board board) {
        this.board = board;
    }

    public ProgressionGame(Board board, Player player1, Player, player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startGame() {
        //board.printUsedTokens();

        try {
            System.out.println("The game is about to start..Loading..")
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Start game");

        Scanner keyboardInput = new Scanner(System.in);
        System.out.println("Which mode do you want to choose?");
        System.out.println("Type 1 for Random, 2 for Smart, 3 for Manual");
        int mode = keyboardInput.nextInt();

        
        //RandomPlayer
        if (mode == 1) {
            System.out.println("Do you want to activate timer?");
            System.out.println("Type 1 for yes and 0 for no.");

            int timerMode = keyboardInput.nextInt();

            board.setTokens();
            board.printUsedTokens();
            board.resetUsedTokens();

            Player p2 = new RandomPlayer("Player 2");
            p2.setBoard(board);
            new Thread(p2).start();
            Player p1 = new RandomPlayer("Player 1");
            p1.setBoard(board);
            new Thread(p1).start();

            boolean timeLimitExceded = false;

            //timer
            if (timerMode == 1) {
                Timer timer = new Timer(true);
                int begin = 0;
                int timeInterval = 750;
                timer.schedule(new TimerTask() {
                    int timeLimit = 5;

                    @Override
                    public void run() {
                        //call the method
                        timeLimit--;
                        System.out.println("There are " + timeLimit + " seconds left");
                        if (timeLimit == 1) {
                            timer.cancel();
                        }
                    }
                }, begin, timeInterval);

                try {
                    Thread.sleep(3500);
                    p1.setRunning(false);
                    p2.setRunning(false);
            //p1.stop();
                    //p2.stop();
                    timeLimitExceded = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                timer.cancel();
                System.out.println("TimerTask cancelled");

                //timer
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            if (true == timeLimitExceded) {
                System.out.println("Time limit was exceded.Players should think faster!");
            } /*1
            else {
                boolean player1Status = p1.getWinningStatus();
                boolean player2Status = p2.getWinningStatus();

                if (!player1Status && !player2Status) {
                    System.out.println("Remiza");
                } else {
                    if (player1Status) {
                        System.out.println("Player 1 a castigat");
                    } else {
                        System.out.println("Player 2 a castigat");
                    }
                }
            }*/

        }
        
        //SmartPlayer
        if (mode == 2) {
            board.setTokens();
            board.printUsedTokens();
            board.resetUsedTokens();

            Player p2 = new SmartPlayer("Player 2");
            p2.setBoard(board);
            new Thread(p2).start();
            Player p1 = new SmartPlayer("Player 1");
            p1.setBoard(board);
            new Thread(p1).start();
        }
        //ManualPlayer
        if (mode == 3) {
            Player p2 = new ManualPlayer("Player 2");
            p2.setBoard(board);
            new Thread(p2).start();
            Player p1 = new ManualPlayer("Player 1");
            p1.setBoard(board);
            new Thread(p1).start();
        }
    }
}
