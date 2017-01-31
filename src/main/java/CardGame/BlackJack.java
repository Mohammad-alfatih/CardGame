package CardGame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alfatihmukhtar on 1/28/17.
 */
public class BlackJack extends CardGame {
    // Clean up the game to enable loss after passing the score of 21

    int userHandValue;
    int dealerHandValue;


    public void dealCards() {
        for(int i=0;i<2;i++) {
            this.dealCard(userHand);
            this.dealCard(dealerHand);
        }
    }

    public boolean playBlackJack() {
        boolean gameEnd;
        deck.shuffle();
        dealCards();
        gameEnd = compareHandValues(userHand, dealerHand);
        while(!gameEnd){
            this.userHandValue = calculateValue(userHand);
            this.dealerHandValue = calculateValue(dealerHand);
            userTurn();
            dealerTurn();
            checkWinCondition(userHand, dealerHand);
        }
        //recompare scores
        //restart game
        //check for win condition
        //if not hit or stay
        //dealer hits or stays
        //game ends
        return true;
    }

    public void dealerTurn(){
        int dealerScore = calculateValue(dealerHand);
        System.out.println("Dealer's current hand value is " + dealerHandValue);
        while (dealerScore <= 17) {
            dealCard(dealerHand);
            dealerScore = calculateValue(dealerHand);
        }
        System.out.println(dealerScore);
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

    public int calculateValue(ArrayList<Card> hand) {
        int score = 0;
        for(Card card : hand) {
            switch (card.getRank()) {
                case ACE:
                    score += 1;
                    break;
                case TWO:
                    score += 2;
                    break;
                case THREE:
                    score += 3;
                    break;
                case FOUR:
                    score += 4;
                    break;
                case FIVE:
                    score += 5;
                    break;
                case SIX:
                    score += 6;
                    break;
                case SEVEN:
                    score += 7;
                    break;
                case EIGHT:
                    score += 8;
                    break;
                case NINE:
                    score += 9;
                    break;
                case TEN:
                    score += 10;
                    break;
                case JACK:
                    score += 10;
                    break;
                case QUEEN:
                    score += 10;
                    break;
                case KING:
                    score += 10;
                    break;
            }
        }
        return score;
    }

}
