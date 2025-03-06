import java.util.ArrayList;

public class RiskyBot extends Player{
    public RiskyBot (String n) {
        super(n);
        setStrategy("takes risks");
    }

     public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        return handScore < 60; // risky strategy
    }
}