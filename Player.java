public class Player {
    private String name;
    private String strategy;
    private int score;

    public Player(String name, String strategy) {
        this.name = name;
        this.strategy = strategy;
        this.score = 0;
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore);
    
    public String getName() {
        return name;
    }

    public int getScore(){
        return score;
    }

    public void addScore(int handScore) {
        score += handScore;
    }

    public String getStrategy() {
        return strategy;
    }
}