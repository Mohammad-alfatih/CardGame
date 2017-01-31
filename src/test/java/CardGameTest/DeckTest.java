package CardGameTest;

import CardGame.Card;
import CardGame.Deck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by alfatihmukhtar on 1/30/17.
 */
public class DeckTest {
    Deck deckObject;
//    ArrayList<Card> myHand;

    @Before
    public void setUp() {
        deckObject = new Deck();
//        myHand = deck.giveHand();
    }

    @Test
    public void TestGetCardDeck() {
        ArrayList<Card> deck = deckObject.getCardDeck();
        int expected = 52;
        int actual = deck.size();
        Assert.assertEquals("This did not work",expected,actual);
    }

    @Test
    public void TestGetNextCard() {
        Card nextCard = deckObject.getNextCard();
        String expexted = "ACE of CLUBS";
        String actual = nextCard.getRank() + " of " + nextCard.getSuit();
        assertEquals("You do not return a Card object",expexted,actual);
    }

    @Test
    public void TestShuffle() {
        deckObject.shuffle();
        Card testCard = deckObject.getCardDeck().get(1);
        String expected = "KING of CLUBS";
        String actual = testCard.getRank() + " of " + testCard.getSuit();
        assertEquals("This deck is not shuffled",expected,actual);
    }

    @Test
    public void TestDealCard() {
        ArrayList<Card> drawHand = deckObject.dealCard(2);
        int expected = 2;
        int actual = drawHand.size();
        assertEquals("Your hand is not the right size",expected,actual);
    }

    @Test
    public void TestRemoveCardsFromDeck() {
        deckObject.getCardDeck().remove(1);
        int expected = 51;
        int actual = deckObject.getCardDeck().size();
        assertEquals("Nothing was deleted from this list",expected,actual);
    }
}
