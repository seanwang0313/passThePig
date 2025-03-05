import java.util.ArrayList;
import java.util.Scanner;

public class PassThePig {
    public static void main (String[] args) {
        System.out.println("Welcome to Pass the Pigs!");

        // initialize players and add them to players array list
        ArrayList<Player> players = new ArrayList<>(); 
        players.add(new HumanPlayer("You", "Human"));
        players.add(new RiskyBot("RiskyBot", "Takes risks"));
        players.add(new SimpleBot("SimpleBot", "Simple strategy"));
        players.add(new WimpyBot("WimpyBot", "Plays safe"));
        players.add(new SchemerBot("SchemerBot", "Plays with strategy"));

        int winningScore = 100;
        boolean gameOn = true;

        while (gameOn) {
            for (Player p : players) {
                int handScore = 0;
                boolean playing = true;

                
            }
        }
    }

    public static int rollScore() {
        int roll1 = getRoll();
        int roll2 = getRoll();

        if ((roll1 == 1 && roll2 == 2) || (roll2 == 1 && roll1 == 2)) {
            return 0; // pig out
        }

        if (roll1 == roll2) {
            if (roll1 == 1 || roll1 == 2) {
                return 1; // double for dot or no dot
            } else if (roll1 == 3 || roll1 == 4) {
                return 20; // double for razorback or trotter
            } else if (roll1 == 5) {
                return 40; // double for snouter
            } else {
                return 60; // double for leaning jowler
            }
        }

        return getScore(roll1) + getScore(roll2); // get score if different results
    }

    public static int getRoll() {
        double roll = Math.random() * 100;
        if (roll < 34.9) {
            return 1; // dot
        } else if (roll < 65.1) {
            return 2; // no dot
        } else if (roll < 87.5) {
            return 3; // razorback
        } else if (roll < 96.3) {
            return 4; // trotter
        } else if (roll < 99.3) {
            return 5; // snouter
        } 
        return 6; // leaning jowler
    }

    public static int getScore(int roll) {
        if (roll == 1 || roll == 2) {
            return 1; // dot or no dot
        } else if (roll == 3 || roll == 4) {
            return 5; // razorback or trotter
        } else if (roll == 5) {
            return 10; // snouter
        } 
        return 15; // leaning jowler
    }
}