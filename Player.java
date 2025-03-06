import java.util.ArrayList;

public class Player {
    private String name;
    private String strategy = "";
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public void setStrategy(String s) {
        this.strategy = s;
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int WINNINGSCORE){
        if (myScore + handScore > WINNINGSCORE) {
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