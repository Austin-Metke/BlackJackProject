import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


//TODO implement random ace toggle functionality
public class Options {


    static JToggleButton charlieToggle = new JToggleButton();
    static JToggleButton randaceToggle = new JToggleButton();
    static JButton returnMenu = new JButton();
    static boolean Charlie;
    static boolean randdelcareAce;

    public static void Start() throws IOException, FontFormatException {

        //Set bounds of toggle buttons
        charlieToggle.setBounds(305, 136, 350, 60);
        randaceToggle.setBounds(305, 217, 350, 60);
        returnMenu.setBounds(488, 297, 159, 40);

        //Set text of toggle buttons


        //Set toggle buttons to be visible
        charlieToggle.setVisible(true);
        randaceToggle.setVisible(true);
        returnMenu.setVisible(true);

        //add toggle buttons to JFrame
        GUI.frame.add(charlieToggle);
        GUI.frame.add(randaceToggle);
        GUI.frame.add(returnMenu);


        charlieToggle.setText("Charlie Rule Disabled");
        randaceToggle.setText("Random Ace Disabled");
        returnMenu.setText("Back");

        Font font = Font.createFont(Font.TRUETYPE_FONT, new File(".\\CasinoFlat.ttf"));
        Font buttonFont = font.deriveFont(20f);

        charlieToggle.setFont(buttonFont);
        randaceToggle.setFont(buttonFont);
        returnMenu.setFont(buttonFont);

        charlieToggle.setBackground(GUI.buttonColor);
        charlieToggle.setBorder(GUI.border);
        randaceToggle.setBackground(GUI.buttonColor);
        randaceToggle.setBorder(GUI.border);
        returnMenu.setBackground(GUI.buttonColor);
        returnMenu.setBorder(GUI.border);

        charlieToggle.setForeground(Color.red);
        randaceToggle.setForeground(Color.red);


        if (Charlie) {
            Charlie = true;
            Options.charlieToggle.setText("Charlie Rule Enabled");
            charlieToggle.setForeground(Color.GREEN.darker());


        } else {
            Charlie = false;
            Options.charlieToggle.setText("Charlie Rule Disabled");
            charlieToggle.setForeground(Color.RED);


        }


        if (randdelcareAce) {
            randdelcareAce = true;
            randaceToggle.setText("Random Ace Enabled");
            randaceToggle.setForeground(Color.GREEN.darker());

        } else {
            randdelcareAce = false;
            randaceToggle.setText("Random Ace Disabled");
            randaceToggle.setForeground(Color.RED);


        }


    }


}


