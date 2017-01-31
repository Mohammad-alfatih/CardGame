package CardGame;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by alfatihmukhtar on 1/30/17.
 */
public class CardDeck {
    private ArrayList<Card> deck = new ArrayList<Card>();
    public ArrayList<Card> hand;

    public CardDeck() {
        for(Suits suit : Suits.values()) {
            for(Ranks rank : Ranks.values()) {
                Card card = new Card(suit, rank);
                deck.add(card);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.deck);
    }

    public ArrayList<Card> giveHand() {
        hand = new ArrayList<Card>();
        for(int i=0;i<2;i++) {
            hand.add(deck.get(i));
            deck.remove(i);
        }
        return hand;
    }

    public ArrayList<Card> getCardDeck() {
        return deck;
    }

    public void seeDeck() {
        for(Card card : deck) {
            card.showCard();
        }
    }

    public Card getNextCard() {
        Card tempCard = deck.get(0);
        deck.remove(0);
        return tempCard;
    }
}
