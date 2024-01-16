// David Fraenkel - ll76ba@student.aau.dk
package blackjack;

public class Card {
    private CardType cardType;
    private Suit suit;
    public Card(CardType cardType, Suit suit) {
        this.cardType = cardType;
        this.suit = suit;
    }

    // A copy constructor that set the suit and card type of a Card equal to that of another Card.
    public Card(Card card) {
        this.cardType = card.getCardType();
        this.suit = card.getSuit();
    }

    public int getValue() {
        return cardType.cardValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public CardType getCardType() {
        return cardType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Card otherCard = (Card) obj;
        return cardType == otherCard.cardType && suit == otherCard.suit;
    }

    public String toString(){
        return ("[" + cardType + " of " + suit + "] (" + this.getValue()+")");
    }
}
