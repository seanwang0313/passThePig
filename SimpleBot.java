public class SimpleBot extends Player{
    public SimpleBot (String n, String s) {
        name = n;
        strategy = s;
    }

     public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        return handScore < 20; // simple strategy
    }
}