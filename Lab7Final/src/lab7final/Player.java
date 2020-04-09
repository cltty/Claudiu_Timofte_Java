package lab7final;

/**
 *
 * @author XPS-Claudiu
 */
abstract class Player implements Runnable {
    abstract void setBoard(Board board);
    abstract void setRunning(boolean status) {};
}
