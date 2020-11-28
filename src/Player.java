import javax.swing.*;
import java.util.ArrayList;

public class Player {

    static JButton button = new JButton();
    static ArrayList<Cards> playerHand = new ArrayList<>();

    public static ArrayList<Cards> getPlayerHand() {
        return playerHand;
    }

    public static int getPlayerHandValue() {

        int handValue = 0;

        for (int i = 0; i < playerHand.size(); i++) {

            int g = playerHand.get(i).value;

            handValue += g;
            //Determines best hand when an ace is present
            if (playerHand.get(i).getValue() == 1) { //all aces are a value of 1

                handValue = (handValue <= 21 - 10) ? handValue + 10 : handValue;

            }


        }

        return handValue;
    }

    void generateHand() {

        playerHand.add(Main.cardsShuffled.get(0));
        playerHand.add(Main.cardsShuffled.get(1));

        playerHand.get(0).visible = true;
        playerHand.get(1).visible = true;


    }


}
