import java.util.ArrayList;

public class Player {
    private String name;
    private String strategy;
    private int score;

    public Player(String name, String strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore){
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