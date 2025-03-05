public class WimpyBot extends Player{
    public WimpyBot (String n, String s) {
        name = n;
        strategy = s;
    }

     public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        return handScore < 10; // plays very cautiously
    }
}