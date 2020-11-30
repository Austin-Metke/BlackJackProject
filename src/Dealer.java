import java.util.ArrayList;

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

    void generateHand() {
        dealerHand.clear();
        dealerHand.add(Main.cardsShuffled.get(2));
        dealerHand.add(Main.cardsShuffled.get(3));
        dealerHand.get(0).visible = true;
        dealerHand.get(1).visible = false;
    }

}
