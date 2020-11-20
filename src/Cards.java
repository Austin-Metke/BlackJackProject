import javax.swing.*;

public class Cards {
    ImageIcon imageIcon;
    String imageName;
    int value;
    boolean ace;
    public Cards(ImageIcon imageIcon, String imageName, int value) {
        this.imageIcon = imageIcon;
        this.imageName = imageName;
        this.value = value;
    }

    public Cards(ImageIcon imageIcon, String imageName, int value, boolean ace) {
        this.imageIcon = imageIcon;
        this.imageName = imageName;
        this.value = value;
        this.ace = ace;
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
}
