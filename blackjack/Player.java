// David Fraenkel - ll76ba@student.aau.dk
package blackjack;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player extends Person{

    Scanner input = new Scanner(System.in);
    public Player() {
        super.setName("Player");
    }

    public void makeDecision(Deck deck, Deck discard) {

        int decision = 0;
        boolean getDecision = true;

        while(getDecision) {
            try {
                System.out.println("Would you like to: 1) Hit or 2) Stand");
                decision = input.nextInt();
                if(!isValidDecision(decision)) {
                    throw new InvalidDecisionException("Invalid input. Please enter 1 or 2.");
                }
                getDecision = false;
            } catch (InvalidDecisionException e) {
                System.out.println(e.getMessage());
                input.next();
            }
        }
        if(decision == 1) {
            this.hit(deck, discard);

            if(this.getHand().calculatedValue() > 20) {
                return;
            }
            // If player didn't bust or got 21 allow them to take another decision
             else {
                 this.makeDecision(deck, discard);
            }
        }
        // If the decision is 2 the player will stand
        else {
            System.out.println("You stand");
        }
    }

    private static boolean isValidDecision(int decision) {
        return decision == 1 || decision == 2;
    }
}
