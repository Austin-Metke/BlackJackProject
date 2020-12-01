import java.util.ArrayList;
import java.util.Random;

public class Dealer {

    static ArrayList<Cards> dealerHand = new ArrayList<>();

    public static int getDealerHandValue() {

        int handValue = 0;

        for (int i = 0; i < dealerHand.size(); i++) {

            int g = dealerHand.get(i).value;

            handValue += g;

            if (dealerHand.get(i).getValue() == 1) {

                handValue = (handValue <= 21 - 10) ? handValue + 10 : handValue;

            }

        }
        return handValue;
    }

    public static ArrayList<Cards> getDealerHand() {
        return dealerHand;
    }


    public static void dealerHit() {

        SinglePlayer.dealerCards.get(1).setIcon(Dealer.getDealerHand().get(1).imageIcon);

        Random rand = new Random();

        int randidx = rand.nextInt(52);

        while (true) {

            if (Dealer.getDealerHandValue() < 17) {

                Dealer.dealerHand.add(Main.cardsShuffled.get(randidx));
                SinglePlayer.dealerCards.get(SinglePlayer.dealerhandCounter).setIcon(Main.cardsShuffled.get(randidx).imageIcon);
                continue;
            }

            break;
        }
        SinglePlayer.dealerhandCounter++;

    }

    static void generateHand() {
        dealerHand.clear();
        SinglePlayer.dealerCards.clear();
        dealerHand.add(Main.cardsShuffled.get(2));
        dealerHand.add(Main.cardsShuffled.get(3));
        dealerHand.get(0).visible = true;
        dealerHand.get(1).visible = false;
    }


}
