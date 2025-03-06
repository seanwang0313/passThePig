import java.util.ArrayList;

public class SchemerBotSean extends Player{
    public SchemerBotSean (String n) {
        super(n);
        strategy = "plays with strategy";
    }

     public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        if (myScore + handScore > winningScore) {
            return false; // if bot can win, stop rolling
        }

        if (handScore > 23) { // Shawn did trial and errrors and suggested 23 as the threshold to me
            return false; // to stop bot for being too greedy
        }

        for (int opponentScores : otherScores) {
            if (opponentScores > 80) {
                return true; // if opponent is close to winning, keep rolling to get more points
            }
        }
        return true;
    }

}