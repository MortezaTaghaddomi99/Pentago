import com.sun.org.glassfish.gmbal.GmbalException;

import java.util.Scanner;

public class Game {

    private Player one;
    private Player two;
    private Board board;
    private boolean isWon;
    private boolean isWonOne;
    private boolean isWonTwo;

    public static void main(String[] args) {

        Game game = new Game();
        game.play();

    }

    public Game(){
        Scanner scanner = new Scanner(System.in);
        board = new Board();
        System.out.println("The game is starting now.");

        System.out.println("Player 1, pick your color.");
        String color = scanner.next();
        one = new Player(color);
        two = new Player(Slot.SlotType.flip(one.getColor()));
    }

    public void play(){
        int turnCounter = 0;

        while (!isWon){
            if (turnCounter >= 36){
                System.out.println("Tie. All slots are taken.");
                return;
            }
            if (turnCounter%2 == 0){
                one.play();
            }
            else {
                two.play();
            }
            isWonOne = board.isWon(one);
            isWonTwo = board.isWon(two);
            isWon = isWonOne || isWonTwo;

            if (isWonOne && isWonTwo){
                System.out.println("Tie. Somehow, you both won. Good job I guess.");
                return;
            }
            else if (isWonOne){
                System.out.println("Congratulations! Player one wins.");
                return;
            }
            else if (isWonTwo){
                System.out.println("Congratulations! Player two wins.");
                return;
            }

            turnCounter++;
        }
    }
}