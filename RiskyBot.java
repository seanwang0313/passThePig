public class RiskyBot extends Player{
    public RiskyBot (String n, String s) {
        name = n;
        strategy = s;
    }

     public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        return handScore < 60; // risky strategy
    }
}