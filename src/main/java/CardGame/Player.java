package CardGame;

import java.util.ArrayList;

/**
 * Created by alfatihmukhtar on 1/29/17.
 */
public class Player {
    // FIELDS
    private int score;
    private ArrayList<Card> hand;
    private ArrayList<Card>[] stacks;

    // CONSTRUCTORS


    // GETTERS


    // SETTERS
    public void setScore(int addPoints) {
        score += stacks.length;
    }
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    public void setStacks(ArrayList<Card>[] stack) {
        stacks = stack;
    }

    // METHODS

}
