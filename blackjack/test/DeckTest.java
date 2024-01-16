// David Fraenkel - ll76ba@student.aau.dk
package blackjack.test;
import blackjack.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class DeckTest {

    @Test
    public void testDeckConstructor() {
        // Arrange
        boolean createNewDeck = true;
        Deck deck = new Deck(createNewDeck);

        // Act
        ArrayList<Card> cards = deck.getCards();

        // Assert
        assertEquals(Suit.values().length * CardType.values().length, cards.size(),
                "Number of cards in the deck should be equal to the product of Suit and CardType values.");

        assertTrue(cards.contains(new Card(CardType.ACE, Suit.HEART)),
                "The deck should contain the ACE of HEARTS.");
        assertTrue(cards.contains(new Card(CardType.TWO, Suit.SPADE)),
                "The deck should contain the TWO of SPADES.");
    }

    @Test
    public void testDeckConstructorEmptyDeck() {
        // Arrange
        boolean createNewDeck = false;
        Deck deck = new Deck(createNewDeck);

        // Act
        ArrayList<Card> cards = deck.getCards();

        // Assert
        assertTrue(cards.isEmpty(), "The deck should be empty when createNewDeck is false.");
    }

    @Test
    public void testShuffle() {
        // Arrange
        Deck deck = new Deck(true); // Create a new deck with ordered cards
        List<Card> originalOrder = new ArrayList<>(deck.getCards());

        // Act
        deck.shuffle();

        // Assert
        assertNotEquals(originalOrder, deck.getCards(), "Deck should be shuffled");
    }
}
