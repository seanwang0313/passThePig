import java.util.Scanner;
import java.util.ArrayList;

public class HumanPlayer extends Player{
    private Scanner sc;
    public HumanPlayer(String n, Scanner scanner) {
        super(n, "human");
        this.sc = scanner;
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        System.out.println("Do you want to roll?");
        String input = sc.nextLine();
        return input.equals("yes");
    }
}