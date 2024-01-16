// David Fraenkel - ll76ba@student.aau.dk
package blackjack;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Random;

import java.util.ArrayList; // import the ArrayList class
public class Deck {
    private ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<Card>();
    }

    public Deck(boolean createNewDeck) {
        deck = new ArrayList<Card>();
        // If createNewDeck is true loop through all suits and cardtypes
        if(createNewDeck) {
            // Go through all suits
            for(Suit suit : Suit.values()) {
                // Go through all card types
                for(CardType cardType : CardType.values()) {
                    // Add a new card to the deck
                    deck.add(new Card(cardType,suit));
                }
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck, new Random());
    }

    public Card takeCard() {
        // Take a copy from the first card from the deck
        Card cardToTake = new Card(deck.get(0));

        // Remove that card from the deck
        deck.remove(0);

        return cardToTake;

    }

    public boolean hasCards() {
        return !deck.isEmpty();
    }

    public void emptyDeck() {
        deck.clear();
    }

    public void addCards(ArrayList<Card> cards) {
        deck.addAll(cards);
    }

    public ArrayList<Card> getCards() {
        return deck;
    }

    public void reloadDeckFromDiscard(Deck discard) {
        this.addCards(discard.getCards());
        this.shuffle();
        discard.emptyDeck();
        System.out.println("Ran out of cards, Creating new deck from discard pile & shuffling deck");
    }

    public void addCard(Card card) {
        deck.add(card);
    }

    public String toString() {
        String output = "";

        for(Card card: deck) {
            output += card;
            output += "\n";
        }
        return output;
    }
}
