import java.util.ArrayList;

public class WimpyBot extends Player{
    public WimpyBot (String n) {
        super(n);
        setStrategy("play safe");
    }

     public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        return handScore < 10; // plays very cautiously
    }
}