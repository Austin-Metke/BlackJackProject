import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Dealer implements PlayerInterface {
    Random rand = new Random();
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
    public void hit() throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {

        SinglePlayer.dealerCards.get(1).setIcon(getHand().get(1).imageIcon);



        int randidx = rand.nextInt(52);

        while (gethandValue() < 17) {

            playSound();

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
    public void playSound() throws IOException, UnsupportedAudioFileException, LineUnavailableException {

        Clip clip;
        int randsound = rand.nextInt(4) + 1;
        String filePath = "Sound Effects\\cardPlace" + randsound + ".wav";

        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());


        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();


    }

    @Override
    public ArrayList<Cards> getHand() {
        return dealerHand;
    }


}
