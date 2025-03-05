import java.util.Scanner;

public class HumanPlayer extends Player{
    private Scanner sc;
    public HumanPlayer(String n, String s) {
        name = n;
        strategy = s;
        sc = new Scanner(System.in);
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        System.out.println(getName + ", do you want to roll?");
        String input = sc.nextLine();
        return input.equals("yes");
    }

    public String getName() {
        return name;
    }

    public String getStrategy() {
        return strategy;
    }
}