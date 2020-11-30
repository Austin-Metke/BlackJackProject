import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Cards> cards = new ArrayList<>();
    public static ArrayList<Cards> cardsShuffled = new ArrayList<>();

    public static void main(String[] args) {


        SwingUtilities.invokeLater(() -> {

            try {
                new GUI();
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException | FontFormatException | IOException e) {

                e.printStackTrace();
            }

        });


        final String folder = "Card PNGs sequential\\";
        File directory = new File(folder);
        File[] filesList = directory.listFiles();


        //For loop that adds all images as an ImageIcon object in the cards ArrayList
        for (int i = 0; i < filesList.length; i++) {

            if (filesList[i].isFile()) {

                try {

                    BufferedImage img = ImageIO.read(new File(folder + filesList[i].getName()));
                    cards.add(new Cards(new ImageIcon(img), filesList[i].getName().substring(1))); //adds an imageicon and the filename without the '0' in it

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

        }

        //sort the cards ArrayList so I can add the values to the cards
        cards.sort(new Cards.CardSorter());


        //Thanks Jaxon
        for (int i = 0; i < cards.size(); i++) {
            cards.get(i).value = (i % 13 + 1 < 10) ? i % 13 + 1 : 10;
        }

        cardsShuffled = new Cards().shuffle(cards);

    }

}
