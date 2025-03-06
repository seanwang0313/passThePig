import java.util.ArrayList;

public class SimpleBotSean extends Player{
    public SimpleBotSean (String n) {
        super(n);
        strategy = "simple strategy";
    }

     public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        return handScore < 20; // simple strategy
    }
}