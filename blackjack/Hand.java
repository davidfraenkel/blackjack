// David Fraenkel - ll76ba@student.aau.dk
package blackjack;
import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<Card>();
    }

    public void takeCardFromDeck(Deck deck) {
        hand.add(deck.takeCard());
    }

    public int calculatedValue() {
        int value = 0;

        for(Card card: hand) {
            value += card.getValue();
        }
        return  value;
    }

    public Card getCard(int idx) {
        return hand.get(idx);
    }

    public String toString() {
        String output = "";
        for(Card card: hand) {
            output += card + " - ";
        }
        return output;
    }
}
