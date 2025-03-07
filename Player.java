import java.util.ArrayList;

public class Player {
    private String name;
    public String strategy = "";
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int WINNINGSCORE){
        if (myScore + handScore > WINNINGSCORE) { // if can win, don't roll
            return false;
        }
        return true;
    }
    
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int handScore) {
        score += handScore;
    }

    public String getStrategy() {
        return strategy;
    }
}