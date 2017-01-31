package CardGame;

import java.util.ArrayList;

/**
 * Created by alfatihmukhtar on 1/28/17.
 */
public class CardGame {
    CardDeck cardDeck = new CardDeck();
    ArrayList<Card> userHand = new ArrayList<Card>();
    ArrayList<Card> dealerHand = new ArrayList<Card>();

    public void dealCard(ArrayList<Card> hand) {
        hand.add(cardDeck.getNextCard());
    }


}
