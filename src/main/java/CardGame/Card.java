package CardGame;

/**
 * Created by alfatihmukhtar on 1/28/17.
 */
public class Card {
    // FIELDS
    private Suits suit;
    private Ranks rank;

    // CONSTRUCTORS
    public Card(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // GETTERS
    public Ranks getRank() {
        return rank;
    }
    public Suits getSuit() {
        return suit;
    }

    // METHODDS
    public void showCard() {
        System.out.println(getRank() + " of " + getSuit());
    }
}
