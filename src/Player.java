import java.util.ArrayList;
import java.util.Random;

public class Player {

    static ArrayList<Cards> playerHand = new ArrayList<>();
    static int chipCounter = 100;

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

    public static void playerStand() {


        if(Player.getPlayerHandValue() == Dealer.getDealerHandValue()) {
            SinglePlayer.tie();
        }

        if (Player.getPlayerHandValue() > Dealer.getDealerHandValue() && Player.getPlayerHandValue() <= 21 || Dealer.getDealerHandValue() > 21) {

            SinglePlayer.playerWon();

        } else if (Player.getPlayerHandValue() < Dealer.getDealerHandValue() || Player.getPlayerHandValue() > 21) {


            SinglePlayer.playerLost();

        }

    }

    static void generateHand() {

        playerHand.clear();
        SinglePlayer.playerCards.clear();
        playerHand.add(Main.cardsShuffled.get(0));
        playerHand.add(Main.cardsShuffled.get(1));

        playerHand.get(0).visible = true;
        playerHand.get(1).visible = true;

    }

    public static void playerHit() {

        Random rand = new Random();

        int randidx = rand.nextInt(52);

        playerHand.add(Main.cardsShuffled.get(randidx));
        SinglePlayer.playerCards.get(SinglePlayer.playerhandCounter).setIcon(Main.cardsShuffled.get(randidx).imageIcon);


        if (Player.getPlayerHand().size() == 5 && Player.getPlayerHandValue() <= 21) {

            SinglePlayer.dealerCards.get(1).setIcon(Dealer.getDealerHand().get(1).imageIcon);
            SinglePlayer.playerWon();

        } else if (Player.getPlayerHandValue() > 21) {

            SinglePlayer.dealerCards.get(1).setIcon(Dealer.getDealerHand().get(1).imageIcon);
            SinglePlayer.playerLost();

        }

        SinglePlayer.playerhandCounter++;


    }


}
