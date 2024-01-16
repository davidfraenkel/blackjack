// David Fraenkel - ll76ba@student.aau.dk
package blackjack;

public enum Suit {
    CLUB("Clubs"),
    DIAMOND("Diamonds"),
    HEART("Hearts"),
    SPADE("Spades");

    String suitName;
    Suit(String suitName) {
       this.suitName = suitName;
   }

   // Returns the Suit name - CLUB would return Clubs
   public String toString() {
       return suitName;
   }
}
