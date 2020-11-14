import java.util.Comparator;

public class CardSorter implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {

        int f = Integer.parseInt(o1.imageName.substring(0, o1.imageName.length() - 4));
        int g = (Integer.parseInt(o2.imageName.substring(0, o2.imageName.length() - 4)));
        return f - g;
    }
}