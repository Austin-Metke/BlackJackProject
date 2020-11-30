import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class GUI {
    static Color buttonColor = new Color(245, 233, 66);
    static JPanel panel = new JPanel(new BorderLayout());
    static JPanel optionsPanel = new JPanel();
    static JFrame frame;
    static JPanel singlePlayerPanel = new JPanel();
    static JPanel multiplayerPanel = new JPanel();
    JButton settingsButton = new JButton();
    JButton singleplayerButton = new JButton();
    JButton multiplayerButton = new JButton();
    JButton exitButton = new JButton();
    JLabel mainMenuText = new JLabel();
    JLabel cardLeft = new JLabel();
    JLabel cardRight = new JLabel();
    JLabel jackblack = new JLabel();

    GUI() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, IOException, FontFormatException {

        //Sets icons for the taskbar and program
        List<Image> icons = new ArrayList<>();
        icons.add(new ImageIcon("16.png").getImage());
        icons.add(new ImageIcon("64.png").getImage());

        frame = new JFrame("Blackjack");

        //Sets default theme to that of the host machines Operating System and the default close operation
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set bounds of all J objects
        frame.setBounds(500, 500, 960, 540);
        singleplayerButton.setBounds(305, 136, 350, 60);
        frame.setIconImages(icons);
        multiplayerButton.setBounds(305, 217, 350, 60);
        settingsButton.setBounds(305, 297, 159, 40);
        exitButton.setBounds(488, 297, 159, 40);
        mainMenuText.setBounds(375, 50, 216, 60);
        cardLeft.setBounds(88, 50, 72, 96);
        cardRight.setBounds(764, 50, 72, 96);
        jackblack.setBounds(225, 350, 500, 214);

        //Sets layout to null and sets the Contentpane to the main panel
        panel.setLayout(null);
        frame.setContentPane(panel);

        //Add everything to panel
        panel.add(multiplayerButton);
        panel.add(singleplayerButton);
        panel.add(exitButton);
        panel.add(settingsButton);
        panel.add(mainMenuText);
        panel.add(cardLeft);
        panel.add(cardRight);
        panel.add(jackblack);

        //Set color of everything
        panel.setBackground(Color.GREEN.darker());
        singleplayerButton.setBackground(buttonColor);
        multiplayerButton.setBackground(buttonColor);
        settingsButton.setBackground(buttonColor);
        exitButton.setBackground(buttonColor);
        SecureRandom rand = new SecureRandom();
        cardLeft.setIcon(Main.cardsShuffled.get(rand.nextInt(52)).imageIcon);
        cardRight.setIcon(Main.cardsShuffled.get(rand.nextInt(52)).imageIcon);


        //If the two cards on the Main Menu are the same card, it displays a picture Jack Black
        if (cardLeft.getIcon() == cardRight.getIcon()) {
            jackblack.setIcon(new ImageIcon(".\\JacKBlackEasterEgg.jpg"));
            jackblack.setVisible(true);
        }

        //set borders for buttons
        Border border = BorderFactory.createLineBorder(new Color(245, 215, 66), 4);
        multiplayerButton.setBorder(border);
        settingsButton.setBorder(border);
        exitButton.setBorder(border);
        singleplayerButton.setBorder(border);


        //Set text and font for buttons
        Font font = Font.createFont(Font.TRUETYPE_FONT, new File(".\\CasinoFlat.ttf"));
        Font mainTextFont = Font.createFont(Font.TRUETYPE_FONT, new File(".\\Casino3DMarquee.ttf"));
        Font font1 = font.deriveFont(40f);
        Font font2 = font.deriveFont(30f);
        Font font3 = mainTextFont.deriveFont(45f);
        singleplayerButton.setFont(font1);
        multiplayerButton.setFont(font1);
        settingsButton.setFont(font2);
        exitButton.setFont(font2);
        mainMenuText.setFont(font3);
        singleplayerButton.setText("Singleplayer");
        multiplayerButton.setText("Multiplayer");
        settingsButton.setText("Options");
        exitButton.setText("Quit");
        mainMenuText.setText("BlackJack");

        //Set everything to be visible
        frame.setVisible(true);
        multiplayerButton.setVisible(true);
        singleplayerButton.setVisible(true);
        exitButton.setVisible(true);
        settingsButton.setVisible(true);
        mainMenuText.setVisible(true);
        cardLeft.setVisible(true);
        cardRight.setVisible(true);


        singleplayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    new SinglePlayerGUI().SinglePlayerGUI();
                } catch (IOException | FontFormatException ioException) {
                    ioException.printStackTrace();
                }

            }
        });

        multiplayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                panel.setVisible(false);
                multiplayerPanel.setLayout(null);
                multiplayerPanel.setVisible(true);
                multiplayerPanel.setBackground(Color.GREEN.darker());
                frame.setContentPane(multiplayerPanel);


            }
        });


        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                optionsPanel.setLayout(null);
                optionsPanel.setVisible(true);
                optionsPanel.setBackground(Color.GREEN.darker());
                frame.setContentPane(optionsPanel);

                Options.optionsGUI();

            }
        });


        //Exits the program
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }
        });

    }

}