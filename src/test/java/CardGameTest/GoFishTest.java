package CardGameTest;

import CardGame.Card;
import CardGame.CardDeck;
import CardGame.GoFish;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by alfatihmukhtar on 1/30/17.
 */
public class GoFishTest {

    @Before
    public void setUp() {
        CardDeck cardDeck = new CardDeck();
        ArrayList<Card> userHand = new ArrayList<Card>();
        ArrayList<Card> dealerHand = new ArrayList<Card>();
    }

    @Test
    public void TestDealGoFishHand() {
        CardDeck cardDeck = new CardDeck();
        ArrayList<Card> userHand = new ArrayList<Card>();
        ArrayList<Card> dealerHand = new ArrayList<Card>();
        GoFish game = new GoFish();
        game.dealGoFishHand();
        int expected = 4;
        int actual = userHand.size();
        assertEquals("This is not correct",expected,actual);
    }
}
