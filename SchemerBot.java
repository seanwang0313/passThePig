import java.util.ArrayList;

public class SchemerBot extends Player{
    public SchemerBot (String n) {
        super(n);
        setStrategy("plays with strategy");
    }

     public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        if (myScore + handScore > winningScore) {
            return false; // if bot can win, stop rolling
        }

        if (handScore > 30) {
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