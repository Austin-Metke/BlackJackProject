import java.util.ArrayList;
import java.util.Random;

public class Dealer implements PlayerInterface {

    static ArrayList<Cards> dealerHand = new ArrayList<>();


    @Override
    public void bet() {

    }

    @Override
    public int gethandValue() {

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

    @Override
    public void stand() {

    }

    @Override
    public void hit() {

        SinglePlayer.dealerCards.get(1).setIcon(getHand().get(1).imageIcon);

        Random rand = new Random();

        int randidx = rand.nextInt(52);

        while (gethandValue() < 17) {

            Dealer.dealerHand.add(Main.cardsShuffled.get(randidx));
            SinglePlayer.dealerCards.get(SinglePlayer.dealerhandCounter).setIcon(Main.cardsShuffled.get(randidx).imageIcon);
            SinglePlayer.dealerhandCounter++;

        }

        System.out.println("Dealer hand value: " + gethandValue());

    }

    @Override
    public void generateHand() {
        dealerHand.clear();
        SinglePlayer.dealerCards.clear();
        dealerHand.add(Main.cardsShuffled.get(2));
        dealerHand.add(Main.cardsShuffled.get(3));
        dealerHand.get(0).visible = true;
        dealerHand.get(1).visible = false;
    }

    @Override
    public ArrayList<Cards> getHand() {
        return dealerHand;
    }


}
