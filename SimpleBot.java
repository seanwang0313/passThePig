import java.util.ArrayList;

public class SimpleBot extends Player{
    public SimpleBot (String n) {
        super(n);
        setStrategy("simple strategy");
    }

     public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        return handScore < 20; // simple strategy
    }
}