package CardGame;

import java.util.Scanner;

/**
 * Created by alfatihmukhtar on 1/30/17.
 */
public class Main {

    public static void main(String[] args) {
        boolean playing = true;

        while(playing) {
            playing = getGameChoice();
        }
    }

    public static boolean getGameChoice() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Please choose your game: (1)-BlackJack (2)-GoFish (3)-Exit ");
        int choice = kb.nextInt();
        switch (choice) {
            case 1:
                BlackJack blackJack = new BlackJack();
                return blackJack.playBlackJack();
            case 2:
                GoFish goFish = new GoFish();
                return goFish.playGoFish();
            case 3:
            default:
                return false;
        }
    }


}
