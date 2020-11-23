
public class Player {

    Cards[] hand = new Cards[2];

    void generateHand() {

            hand[0] = Main.cardsShuffled.get(0);
            hand[1] = Main.cardsShuffled.get(1);
            System.out.println(hand[0].getImageName());
            System.out.println(hand[1].getImageName());
    }

    public Cards[] getHand() {
        return hand;
    }
}
