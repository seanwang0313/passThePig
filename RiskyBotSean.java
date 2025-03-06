import java.util.ArrayList;

public class RiskyBotSean extends Player{
    public RiskyBotSean (String n) {
        super(n);
        setStrategy("takes risks");
    }

     public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        return handScore < 40; // risky strategy
    }
}