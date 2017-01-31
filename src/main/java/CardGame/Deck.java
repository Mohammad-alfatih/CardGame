package CardGame;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by alfatihmukhtar on 1/30/17.
 */
public class Deck {
    // FIELDS
    private ArrayList<Card> deck = new ArrayList<Card>();
//    private ArrayList<Card> hand = new ArrayList<Card>();

    // CONSTRUCTORS
    public Deck() {
        for(Suits suit : Suits.values()) {
            for(Ranks rank : Ranks.values()) {
                Card card = new Card(suit, rank);
                deck.add(card);
            }
        }
    }

    // GETTERS
    public ArrayList<Card> getCardDeck() {
        return deck;
    }

    // METHODS
    public void seeDeck() {
        for(Card card : deck) {
            card.showCard();
        }
    }
    public Card getNextCard() {                                 // Returns a single Card object
        Card tempCard = deck.get(0);
        deck.remove(0);
        return tempCard;
    }
    public ArrayList<Card> dealCards(int numberOfCards) {       // Returns an ArrayList of Card objects
        ArrayList<Card> hand = new ArrayList<Card>();
        for(int i=0;i<numberOfCards;i++) {
            hand.add(deck.get(i));
            removeCardFromDeck(i);
        }
        return hand;
    }
    public void removeCardFromDeck(int index) {
        deck.remove(index);
    }
    public void shuffle() {
        Collections.shuffle(this.deck);
    }
}
