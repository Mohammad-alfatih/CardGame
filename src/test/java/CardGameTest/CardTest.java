package CardGameTest;

import CardGame.Card;
import CardGame.Ranks;
import CardGame.Suits;
import org.junit.Before;
import org.junit.Test;

import static CardGame.Ranks.THREE;
import static CardGame.Suits.SPADES;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by alfatihmukhtar on 1/28/17.
 */
public class CardTest {
    Card card;

    @Before
    public void setUp() {
        card = new Card(SPADES, THREE);
    }

    @Test
    public void TestGetValue() {
        Ranks expected = THREE;
        Ranks actual = card.getRank();
        assertEquals("You did not receive the correct value",expected,actual);

    }

    @Test
    public void TestGetSuit() {
        Suits expected = SPADES;
        Suits actual = card.getSuit();
        assertEquals("You did not get the correct face",expected,actual);
    }
}
