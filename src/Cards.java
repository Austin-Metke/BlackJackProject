import javax.swing.*;
import java.util.*;


public class Cards {
    ImageIcon imageIcon;
    String imageName;
    int value;
    boolean visible;

    public Cards(ImageIcon imageIcon, String imageName) {
        this.imageIcon = imageIcon;
        this.imageName = imageName;
    }

    public Cards() {

    }


    public ImageIcon getImageIcon() {
        return imageIcon;
    }


    public int getValue() {
        return value;
    }

    public String getImageName() {
        return imageName;
    }

    public Boolean getVisible() {
        return this.visible;
    }


    public ArrayList<Cards> shuffle(ArrayList<Cards> cards) {

        Collections.shuffle(cards);

        return cards;
    }

    public static class CardSorter implements Comparator<Cards> {
        @Override
        public int compare(Cards o1, Cards o2) {

            int f = Integer.parseInt(o1.getImageName().substring(0, o1.getImageName().length() - 4));
            int g = (Integer.parseInt(o2.getImageName().substring(0, o2.getImageName().length() - 4)));
            return f - g;

        }
    }

}


