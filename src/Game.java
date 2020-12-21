//TODO Fix chip counter

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class SinglePlayer {

    static ArrayList<JLabel> playerCards = new ArrayList<>();
    static ArrayList<JLabel> dealerCards = new ArrayList<>();
    static int playerhandCounter;
    static int dealerhandCounter;
    static JButton hitButton = new JButton();
    static JButton standButton = new JButton();
    static JButton doubleDownButton = new JButton();
    static JButton playAgainNo = new JButton();
    static JButton playAgainYes = new JButton();
    static JButton confirmBet = new JButton();
    static JLabel winText = new JLabel();
    static JLabel chipLabel = new JLabel();
    static JLabel playAgain = new JLabel();
    static JLabel betText = new JLabel();
    static JLabel dealer = new JLabel();
    static JLabel player = new JLabel();
    static JButton okButton = new JButton();
    static JTextField betInput = new JTextField();
    static int bet;


    public static void Start() throws IOException, FontFormatException {

        playerhandCounter = 2;
        dealerhandCounter = 2;
        //Shuffle deck and generate player and dealer hand
        Main.cardsShuffled = new Cards().shuffle(Main.cards);
        Main.player.generateHand();
        Main.dealer.generateHand();

        GUI.panel.setVisible(false);
        GUI.singlePlayerPanel.setLayout(null);
        GUI.singlePlayerPanel.setVisible(true);

        //Set color of everything
        playAgainNo.setBackground(GUI.buttonColor);
        playAgainYes.setBackground(GUI.buttonColor);
        hitButton.setBackground(GUI.buttonColor);
        standButton.setBackground(GUI.buttonColor);
        confirmBet.setBackground(GUI.buttonColor);
        GUI.singlePlayerPanel.setBackground(Color.GREEN.darker());

        GUI.frame.setContentPane(GUI.singlePlayerPanel);
        for (int i = 0; i < 5; i++) {

            playerCards.add(new JLabel());
            dealerCards.add(new JLabel());
        }

        //Hide and show miscellaneous items
        playAgain.setVisible(false);
        playAgainYes.setVisible(false);
        playAgainNo.setVisible(false);
        okButton.setVisible(false);
        hitButton.setVisible(false);
        standButton.setVisible(false);
        confirmBet.setVisible(true);
        betInput.setVisible(true);
        winText.setVisible(false);
        dealer.setVisible(true);
        player.setVisible(true);


        //Seems to be the only way to set a font size with custom fonts
        Font font = Font.createFont(Font.TRUETYPE_FONT, new File(".\\CasinoFlat.ttf"));
        Font buttonFont = font.deriveFont(30f);
        Font chipFont = font.deriveFont(20f);
        winText.setFont(buttonFont);
        playAgainNo.setFont(buttonFont);
        playAgainYes.setFont(buttonFont);
        playAgain.setFont(buttonFont);
        chipLabel.setFont(chipFont);
        confirmBet.setFont(chipFont);
        betInput.setFont(chipFont);
        betText.setFont(chipFont);
        okButton.setFont(buttonFont);
        dealer.setFont(chipFont);
        player.setFont(chipFont);

        //Set bounds of all JLabels and JButtons
        hitButton.setBounds(380, 350, 87, 20);
        standButton.setBounds(475, 350, 87, 20);
        winText.setBounds(420, 200, 500, 50);
        playAgainYes.setBounds(380, 350, 87, 40);
        playAgainNo.setBounds(475, 350, 87, 40);
        playAgain.setBounds(410, 300, 200, 50);
        chipLabel.setBounds(10, 405, 80, 20);
        betInput.setBounds(50, 400, 50, 25);
        betText.setBounds(80, 400, 30, 20);
        confirmBet.setBounds(125, 400, 143, 25);
        okButton.setBounds(335, 350, 250, 40);
        dealer.setBounds(440, 115, 75, 25);
        player.setBounds(440, 375, 75, 25);


        //TODO implement algorithm to do this automatically
        playerCards.get(0).setBounds(400, 400, 72, 96);
        playerCards.get(1).setBounds(475, 400, 72, 96);
        playerCards.get(2).setBounds(325, 400, 72, 96);
        playerCards.get(3).setBounds(550, 400, 72, 96);
        playerCards.get(4).setBounds(625, 400, 72, 96);
        dealerCards.get(0).setBounds(400, 10, 72, 96);
        dealerCards.get(1).setBounds(475, 10, 72, 96);
        dealerCards.get(2).setBounds(325, 10, 72, 96);
        dealerCards.get(3).setBounds(550, 10, 72, 96);
        dealerCards.get(4).setBounds(625, 10, 72, 96);


        //set Icons for player hand
        playerCards.get(0).setIcon(Main.player.getHand().get(0).imageIcon);
        playerCards.get(1).setIcon(Main.player.getHand().get(1).imageIcon);


        //set Icons for dealer hand
        dealerCards.get(0).setIcon(Main.dealer.getHand().get(0).imageIcon);
        dealerCards.get(1).setIcon(Main.dealer.getHand().get(1).imageIcon);

        //Add buttons to panel
        GUI.singlePlayerPanel.add(hitButton);
        GUI.singlePlayerPanel.add(standButton);
        GUI.singlePlayerPanel.add(doubleDownButton);
        GUI.singlePlayerPanel.add(winText);
        GUI.singlePlayerPanel.add(playAgainYes);
        GUI.singlePlayerPanel.add(playAgainNo);
        GUI.singlePlayerPanel.add(playAgain);
        GUI.singlePlayerPanel.add(chipLabel);
        GUI.singlePlayerPanel.add(betInput);
        GUI.singlePlayerPanel.add(betText);
        GUI.singlePlayerPanel.add(confirmBet);
        GUI.singlePlayerPanel.add(okButton);
        GUI.singlePlayerPanel.add(dealer);
        GUI.singlePlayerPanel.add(player);

        //set borders of all buttons

        playAgainNo.setBorder(GUI.border);
        playAgainYes.setBorder(GUI.border);
        hitButton.setBorder(GUI.border);
        standButton.setBorder(GUI.border);
        confirmBet.setBorder(GUI.border);


        //For loop to add all playerCards to panel
        for (int i = 0; i < playerCards.size(); i++) {
            GUI.singlePlayerPanel.add(playerCards.get(i));
        }

        //For loop to add all dealer cards to panel
        for (int i = 0; i < dealerCards.size(); i++) {
            GUI.singlePlayerPanel.add(dealerCards.get(i));
        }

        //Add text to buttons
        hitButton.setText("Hit");
        standButton.setText("Stand");
        doubleDownButton.setText("Double Down");
        playAgainYes.setText("Yes");
        playAgainNo.setText("No");
        playAgain.setText("Play Again?");
        confirmBet.setText("Confirm Bet");
        okButton.setText("Return to menu");
        dealer.setText("Dealer");
        player.setText("Player");

        chipLabel.setText(String.valueOf(Player.chipCounter));

        if (!Main.dealer.getHand().get(1).visible) {

            BufferedImage cardBack = ImageIO.read(new File("Card PNGs sequential\\misc\\b1fv.png"));
            dealerCards.get(1).setIcon(new ImageIcon(cardBack));

        }

    }

    public static void tie() {

        winText.setVisible(true);
        winText.setText("It's a tie!");
        System.out.println("It's a tie!");
        Player.chipCounter = Player.chipCounter + bet;
        hitButton.setVisible(false);
        standButton.setVisible(false);
        playAgain.setVisible(true);
        playAgainNo.setVisible(true);
        playAgainYes.setVisible(true);
        player.setVisible(false);
        dealer.setVisible(false);

    }

    public static void playerWon() {

        winText.setVisible(true);
        System.out.println("You won");
        winText.setForeground(new Color(245, 233, 66));
        winText.setText("You won!");
        Player.chipCounter = Player.chipCounter + (bet * 2);
        playAgain.setVisible(true);
        playAgainNo.setVisible(true);
        playAgainYes.setVisible(true);
        hitButton.setVisible(false);
        standButton.setVisible(false);
        player.setVisible(false);
        dealer.setVisible(false);
    }

    public static void playerLost() {

        winText.setVisible(true);
        System.out.println("You lost");
        winText.setForeground(new Color(245, 233, 66));
        winText.setText("You lose!");

        if (Player.chipCounter <= 0) {

            winText.setText("You ran out of chips!");
            okButton.setVisible(true);
            hitButton.setVisible(false);
            standButton.setVisible(false);
            player.setVisible(false);
            dealer.setVisible(false);

        } else {

            standButton.setVisible(false);
            hitButton.setVisible(false);
            playAgainNo.setVisible(true);
            playAgainYes.setVisible(true);
            playAgain.setVisible(true);
            player.setVisible(false);
            dealer.setVisible(false);
        }


    }

}

