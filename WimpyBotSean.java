import java.util.ArrayList;

public class WimpyBotSean extends Player{
    public WimpyBotSean (String n) {
        super(n);
        strategy = "play safe";
    }

     public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        return handScore < 10; // plays very cautiously
    }
}