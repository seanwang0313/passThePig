import java.util.ArrayList;
import java.util.Scanner;

public class PassThePig {
    static ArrayList<Player> players = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main (String[] args) {
        System.out.println("Welcome to Pass the Pigs!");

        // initialize players and add them to players array list
        players.add(new HumanPlayer("You"));
        players.add(new RiskyBot("RiskyBot"));
        players.add(new SimpleBot("SimpleBot"));
        players.add(new WimpyBot("WimpyBot"));
        players.add(new SchemerBot("SchemerBot"));

        final int WINNING_SCORE = 100;
        boolean gameOn = true;

        while (gameOn) {
            for (Player p : players) {
                int handScore = 0;
                boolean rolling = true;

                while (rolling) {
                    String roll1 = getRoll();
                    String roll2 = getRoll();
                    int roll = getScore(roll1, roll2);
                    if (roll == 0) {
                        System.out.println(p.getName() + " got a pig out!");
                        handScore = 0;
                        rolling = false;
                        break;
                    } else {
                        handScore += roll;
                        System.out.println(p.getName() + " rolls a " + roll1 + " and a " + roll2 + " for a roll of " + roll);
                    }
                    ArrayList<Integer> otherScores = getOtherScores(players, p);
                    rolling = p.wantsToRoll(p.getScore(), handScore, otherScores, WINNING_SCORE);
                }
                p.addScore(handScore);
                System.out.println(p.getName() + " banks " + handScore + " points! Total: " + p.getScore());

                if (p.getScore() >= WINNING_SCORE) {
                    gameOn = false;
                    System.out.println("Game over! " + p.getName() + " wins with score: " + p.getScore() + " !" + " His strategy was " + p.getStrategy());
                    break;
                }
            }
        }
    }

    public static int getScore(String roll1,  String roll2) {
        if ((roll1.equals("dot") && roll2.equals("no dot")) || (roll2.equals("dot") && roll1.equals("no dot"))) {
            return 0; // pig out
        }

        if (roll1.equals(roll2)) {
            if (roll1.equals("dot") || roll1.equals("no dot")) {
                return 1; // double for dot or no dot
            } else if (roll1.equals("razorback") || roll1.equals("trotter")) {
                return 20; // double for razorback or trotter
            } else if (roll1.equals("snouter")) {
                return 40; // double for snouter
            } else {
                return 60; // double for leaning jowler
            }
        }

        if (rollScore(roll1)>rollScore(roll2)) {
            return rollScore(roll1);
        }
        return rollScore(roll2);
    }

    public static String getRoll() {
        double roll = Math.random() * 100;
        if (roll < 34.9) {
            return "dot"; // dot
        } else if (roll < 65.1) {
            return "no dot"; // no dot
        } else if (roll < 87.5) {
            return "razorback"; // razorback
        } else if (roll < 96.3) {
            return "trotter"; // trotter
        } else if (roll < 99.3) {
            return "snouter"; // snouter
        } 
        return "jowler"; // leaning jowler
    }

    public static int rollScore(String roll) {
        if (roll.equals("dot") || roll.equals("no dot")) {
            return 1; // dot or no dot
        } else if (roll.equals("razorback") || roll.equals("trotter")) {
            return 5; // razorback or trotter
        } else if (roll.equals("snouter")) {
            return 10; // snouter
        } 
        return 15; // leaning jowler
    }

    public static ArrayList<Integer> getOtherScores(ArrayList<Player> Players, Player current) {
        ArrayList <Integer> scores = new ArrayList<>();

        for (Player player: Players) {
            if (player != current) {
                scores.add(player.getScore());
            }
        }
        return scores;
    }
}