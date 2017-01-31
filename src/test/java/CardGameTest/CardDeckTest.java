package CardGameTest;

import CardGame.Card;
import CardGame.CardDeck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by alfatihmukhtar on 1/30/17.
 */
public class CardDeckTest {
    CardDeck deck;
    ArrayList<Card> myHand;

    @Before
    public void setUp() {
        deck = new CardDeck();
        myHand = deck.giveHand();
    }

    @Test
    public void TestGiveHand() {
        int expected = 2;
        int actual = myHand.size();
        Assert.assertEquals("This did not work",expected,actual);
    }
}
