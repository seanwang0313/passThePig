import java.util.ArrayList;
import java.util.Scanner;

public class PassThePig {
    static ArrayList<Player> players = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main (String[] args) {
        System.out.println("Welcome to Pass the Pigs!");

        // initialize players and add them to players array list
        players.add(new HumanPlayer("You", sc));
        players.add(new RiskyBot("RiskyBot"));
        players.add(new SimpleBot("SimpleBot"));
        players.add(new WimpyBot("WimpyBot"));
        players.add(new SchemerBot("SchemerBot"));

        int winningScore = 100;
        boolean gameOn = true;

        while (gameOn) {
            for (Player p : players) {
                int handScore = 0;
                boolean rolling = true;

                while (rolling) {
                    int roll1 = getRoll();
                    int roll2 = getRoll();
                    int roll = getScore(roll1, roll2);
                    if (roll == 0) {
                        System.out.println(p.getName() + " got a pig out!");
                        handScore = 0;
                        rolling = false;
                    } else {
                        handScore += roll;
                        System.out.println(p.getName() + " rolls a " + getStringForScore(roll1) + " and a " + getStringForScore(roll2) + "for a roll of " + roll);
                    }
                    ArrayList<Integer> otherScores = getOtherScores(players, p);
                    rolling = p.wantsToRoll(p.getScore(), handScore, otherScores, winningScore);
                }
                p.addScore(handScore);
                System.out.println(p.getName() + " banks " + handScore + " points! Total: " + p.getScore());

                if (p.getScore() >= winningScore) {
                    gameOn = false;
                    System.out.println("Game over! " + p.getName() + "wins with score: " + p.getScore() + " !");
                }
            }
        }
    }

    public static String getStringForScore(int i) {
        if (i == 1) {
            return "dot";
        } else if (i == 2) {
            return "no dot";
        } else if (i == 3) {
            return "razorback";
        } else if (i == 4) {
            return "trotter";
        } else if (i == 6) {
            return "snouter";
        }
        return "leaning jowler";
    }

    public static int getScore(int roll1,  int roll2) {
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

        return rollScore(roll1) + rollScore(roll2); // get score if different results
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

    public static int rollScore(int roll) {
        if (roll == 1 || roll == 2) {
            return 1; // dot or no dot
        } else if (roll == 3 || roll == 4) {
            return 5; // razorback or trotter
        } else if (roll == 5) {
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