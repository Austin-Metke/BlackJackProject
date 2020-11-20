import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static ArrayList<Cards> cards = new ArrayList<>();

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
        assert filesList != null;
        Arrays.sort(filesList);

        //For loop that adds all images as an ImageIcon object in the cards ArrayList
        for (int i = 0; i < 52; i++) {

            if (filesList[i].isFile()) {

                try {

                    BufferedImage img = ImageIO.read(new File(folder + filesList[i].getName()));
                    cards.add(new Cards(new ImageIcon(img), filesList[i].getName().substring(1), i + 1));

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

        }




        for (Cards card : cards) {
            System.out.println(card.getValue());
        }

    }
}
