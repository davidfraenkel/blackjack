// David Fraenkel - ll76ba@student.aau.dk
package blackjack;

public class Game {

    private Deck deck, discarded;
    private Dealer dealer;
    private Player player;
    private int wins, losses, pushes;

    public Game() {
        deck = new Deck(true);
        discarded = new Deck();

        dealer = new Dealer();
        player = new Player();

        deck.shuffle();

        startRound();

        wins = 0;
        losses = 0;
    }

    private void startRound() {
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);

        dealer.printFirstHand();
        player.printHand();

        if(dealer.hasBlackjack()) {
            dealer.printHand();

            if(player.hasBlackjack()) {
                System.out.println("You both have 21 - Push");
                pushes++;
            } else {
                System.out.println("Dealer has blackJack. You lose");
                losses++;
            }
        }

        if(player.hasBlackjack()) {
            System.out.println("You have blackjack! You win");
            wins++;
        }
        player.makeDecision(deck, discarded);

        if(player.getHand().calculatedValue() > 21) {
            System.out.println("You have gone over 21");
            losses++;
        }

        dealer.printHand();
        // If the dealers hand is under a value of 17 continue to hit
        while(dealer.getHand().calculatedValue() < 17) {
            dealer.hit(deck,discarded);
        }

        //Check who wins the game
        if(dealer.getHand().calculatedValue() > 21) {
            System.out.println("Dealer busts");
            wins++;
        }
        else if(dealer.getHand().calculatedValue() > player.getHand().calculatedValue()) {
            System.out.println("You lose");
            losses++;
        } else if (player.getHand().calculatedValue() < dealer.getHand().calculatedValue()) {
            System.out.println("You win");
            wins++;
        } else {
            System.out.println("Push");
        }
    }
}