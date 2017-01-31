package CardGame;

import java.util.ArrayList;

/**
 * Created by alfatihmukhtar on 1/30/17.
 */
public class GoFish extends CardGame{
    int userScore;
    int dealerScore;

    public void dealGoFishHand() {
        for(int i=0;i<5;i++) {
            this.dealCard(userHand);
            this.dealCard(dealerHand);
        }
    }

    public boolean playGoFish() {
        boolean gameEnd = false;
        cardDeck.shuffle();
        for(int i=0;i<5;i++) {
            dealCard(userHand);
            dealCard(dealerHand);
        }
        while(!gameEnd) {
        singleTurn(userHand, dealerHand);
//        checkWinCondition(userHand);
        singleTurn(dealerHand, userHand);
//        checkWinCondition(dealerHand);
        return gameEnd;
        }
        return gameEnd;
    }

    public void singleTurn(ArrayList<Card> activePlayer, ArrayList<Card> inactivePlayer){
        Card userCard = activePlayer.get(0);
        Ranks userRank = userCard.getRank();
        boolean hasAMatch = false;
        for(int i=0;i<inactivePlayer.size();i++) {
            if (userRank == inactivePlayer.get(i).getRank()) {
                activePlayer.add(inactivePlayer.get(i));
                inactivePlayer.remove(i);
                hasAMatch = true;
            }
        }
        if(hasAMatch) {
            dealCard(activePlayer);
        }
//        ArrayList<ArrayList<Card>> stacks = checkForStacks(activePlayer);
    }

    public ArrayList<Card> checkForStacks(ArrayList<Card> hand) {
        ArrayList<Card> tempHand = new ArrayList<Card>();
        for(int i=0;i<hand.size();i++) {
            Ranks rank = hand.get(i).getRank();
            for(int j=0;j<hand.size();j++) {
                if(rank == hand.get(j).getRank()) {
                    tempHand.add(hand.get(j));
                    hand.remove(j);
                }
            }
        }
        if(tempHand.size()>=4) {
            return tempHand;
        } else {
            for(int k=0;k<tempHand.size();k++) {
                hand.add(tempHand.get(k));
            } return tempHand;
        }
    }
}
