import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

//TODO Make this not stupid
interface PlayerInterface {

    void bet();

    int gethandValue();

    void stand();

    void hit() throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException;

    void generateHand();

    void playSound() throws IOException, UnsupportedAudioFileException, LineUnavailableException;

    ArrayList<Cards> getHand();

}

public class Player implements PlayerInterface {

    static ArrayList<Cards> playerHand = new ArrayList<>();
    static int chipCounter = 100;
    Random rand = new Random();
    boolean isStanding;

    //Maybe need this?
    @Override
    public void bet() {

    }

    @Override
    public int gethandValue() {

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

    //Probably should put this logic elsewhere
    @Override
    public void stand() {


        if (gethandValue() == Main.dealer.gethandValue()) {

            SinglePlayer.tie();

        }

        if (gethandValue() > Main.dealer.gethandValue() && gethandValue() <= 21 || Main.dealer.gethandValue() > 21) {

            SinglePlayer.playerWon();

        } else if (gethandValue() <= 21 && Main.dealer.gethandValue() > 21) {

            SinglePlayer.playerWon();

        } else if (gethandValue() < Main.dealer.gethandValue() && Main.dealer.gethandValue() <= 21) {

            SinglePlayer.playerLost();

        } else if (gethandValue() > 21) {

            SinglePlayer.playerLost();

        }

    }

    //Probably should put this elsewhere too
    @Override
    public void hit() throws IOException, UnsupportedAudioFileException, LineUnavailableException {


        playSound();
        int randidx = rand.nextInt(52);
        int randsound = rand.nextInt(4) + 1;
        Clip clip;
        String filePath = "Sound Effects\\cardPlace" + randsound + ".wav";

        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());


        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();

        playerHand.add(Main.cardsShuffled.get(randidx));
        SinglePlayer.playerCards.get(SinglePlayer.playerhandCounter).setIcon(Main.cardsShuffled.get(randidx).imageIcon);
        SinglePlayer.playerhandCounter++;

        if (Options.Charlie) {

            if (getHand().size() == 5 && gethandValue() <= 21) {

                SinglePlayer.dealerCards.get(1).setIcon(Main.dealer.getHand().get(1).imageIcon);
                SinglePlayer.playerWon();

            }

        }
        if (gethandValue() > 21) {

            SinglePlayer.dealerCards.get(1).setIcon(Main.dealer.getHand().get(1).imageIcon);
            SinglePlayer.playerLost();

        }

        System.out.println("Player hand value: " + gethandValue());

    }

    //Will mess with later
    public void doubleDown() {


    }

    //Will mess with later
    public void split() {





    }



    //I should do this differently
    @Override
    public void generateHand() {

        playerHand.clear();
        SinglePlayer.playerCards.clear();
        playerHand.add(Main.cardsShuffled.get(0));
        playerHand.add(Main.cardsShuffled.get(1));

        playerHand.get(0).visible = true;
        playerHand.get(1).visible = true;

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

    //Is this necessary?
    @Override
    public ArrayList<Cards> getHand() {

        return playerHand;

    }


}
