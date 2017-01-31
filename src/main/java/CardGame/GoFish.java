package CardGame;

import java.util.ArrayList;
import java.util.Scanner;

import static com.sun.jmx.snmp.EnumRowStatus.active;

/**
 * Created by alfatihmukhtar on 1/30/17.
 */
public class GoFish extends CardGame{
    int userScore;
    int dealerScore;

    public void dealCards() {
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
        checkWinCondition(userHand);
        singleTurn(dealerHand, userHand);
        checkWinCondition(dealerHand);
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
        ArrayList<ArrayList<Card>> stacks = checkForStacks(activePlayer);
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

    public void userTurn() {
        Scanner ask = new Scanner(System.in);
        System.out.println("User's current hand value is " + userHandValue);
        System.out.println("(1)- Hit or (2)- stay? ");
        int choice = ask.nextInt();
        while (choice==1) {
            dealCard(userHand);
            this.userHandValue = calculateValue(userHand);
            if(this.userHandValue==21) {
                break;
                // Ensure BlackJack game ends...
            } else {
                System.out.println(calculateValue(userHand));
                System.out.println("(1)- Hit or (2)- stay? ");
                choice = ask.nextInt();

            }
            //checkBustCondition();
        }
    }

    // Write code to display cards in both hands.
    public boolean checkWinCondition(ArrayList<Card> user, ArrayList<Card> dealer) {
        if(calculateValue(user) > calculateValue(dealer)) {
            System.out.println("You win!");
            return true;
        } else {
            System.out.println("You lose!");
            return false;
        }
    }

    public boolean compareHandValues(ArrayList<Card> userHand, ArrayList<Card> dealerHand) {
        int userHandValue = calculateValue(userHand);
        int dealerHandValue = calculateValue(dealerHand);
        if(userHandValue != 21 && dealerHandValue != 21){
            return false;
        } else
            return true;
    }
}
