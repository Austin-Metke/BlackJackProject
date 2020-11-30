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
import java.util.Random;

public class SinglePlayerGUI {


    JButton hitButton = new JButton();
    JButton standButton = new JButton();
    JButton doubleDownButton = new JButton();
    JButton playAgainNo = new JButton();
    JButton playAgainYes = new JButton();
    JButton confirmBet = new JButton();
    ArrayList<JLabel> playerCards = new ArrayList<>();
    ArrayList<JLabel> dealerCards = new ArrayList<>();
    JLabel winText = new JLabel();
    JLabel chipLabel = new JLabel();
    JLabel playAgain = new JLabel();
    JLabel betText = new JLabel();
    JButton okButton = new JButton();
    JTextField betInput = new JTextField();
    int bet;
    int i = 2;
    int x = 2;
    int chipCounter = Player.chipCounter;

    public void SinglePlayerGUI() throws IOException, FontFormatException {


        //Shuffle deck and generate player and dealer hand
        Main.cardsShuffled = new Cards().shuffle(Main.cards);
        new Player().generateHand();
        new Dealer().generateHand();

        GUI.panel.setVisible(false);
        GUI.singlePlayerPanel.setLayout(null);
        GUI.singlePlayerPanel.setVisible(true);
        GUI.singlePlayerPanel.setBackground(Color.GREEN.darker());
        GUI.frame.setContentPane(GUI.singlePlayerPanel);

        //Hide miscellaneous items
        playAgain.setVisible(false);
        playAgainYes.setVisible(false);
        playAgainNo.setVisible(false);
        okButton.setVisible(false);

        for (int i = 0; i < 5; i++) {

            playerCards.add(new JLabel());
            dealerCards.add(new JLabel());
        }

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

        //Set color of all buttons
        Color buttonColor = new Color(245, 233, 66);
        playAgainNo.setBackground(buttonColor);
        playAgainYes.setBackground(buttonColor);
        hitButton.setBackground(buttonColor);
        standButton.setBackground(buttonColor);
        confirmBet.setBackground(buttonColor);

        //set borders of all buttons
        Border border = BorderFactory.createLineBorder(new Color(245, 215, 66), 4);
        playAgainNo.setBorder(border);
        playAgainYes.setBorder(border);
        hitButton.setBorder(border);
        standButton.setBorder(border);


        //Set bounds of all JLabels and JButtons
        hitButton.setBounds(380, 350, 87, 20);
        standButton.setBounds(475, 350, 87, 20);
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
        winText.setBounds(420, 200, 500, 50);
        playAgainYes.setBounds(380, 350, 87, 40);
        playAgainNo.setBounds(475, 350, 87, 40);
        playAgain.setBounds(410, 300, 200, 50);
        chipLabel.setBounds(10, 405, 80, 20);
        betInput.setBounds(50, 400, 50, 25);
        betText.setBounds(80, 400, 30, 20);
        confirmBet.setBounds(125, 400, 143, 25);
        okButton.setBounds(335, 350, 250, 40);

        //set Icons for player hand
        playerCards.get(0).setIcon(Player.getPlayerHand().get(0).imageIcon);
        playerCards.get(1).setIcon(Player.getPlayerHand().get(1).imageIcon);


        //set Icons for dealer hand
        dealerCards.get(0).setIcon(Dealer.getDealerHand().get(0).imageIcon);
        dealerCards.get(1).setIcon(Dealer.getDealerHand().get(1).imageIcon);

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

        chipLabel.setText(String.valueOf(chipCounter));

        if (!Dealer.getDealerHand().get(1).visible) {

            BufferedImage cardBack = ImageIO.read(new File("Card PNGs sequential\\misc\\b1fv.png"));
            dealerCards.get(1).setIcon(new ImageIcon(cardBack));

        }

        //Stand Button
        standButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                dealerCards.get(1).setIcon(Dealer.getDealerHand().get(1).imageIcon);

                Random rand = new Random();

                int index = rand.nextInt(52);

                //This is really stupid
                while (true) {
                    if (Dealer.getDealerHandValue() < 17) {
                        Dealer.getDealerHand().add(Main.cardsShuffled.get(index));
                        dealerCards.get(x).setIcon(Main.cardsShuffled.get(index).imageIcon);
                        x++;
                        continue;
                    }
                    break;
                }

                if (Player.getPlayerHandValue() == Dealer.getDealerHandValue()) {

                    winText.setText("It's a tie!");
                    System.out.println("It's a tie!");
                    Player.chipCounter = chipCounter + bet;

                } else if (Player.getPlayerHandValue() > Dealer.getDealerHandValue() && Player.getPlayerHandValue() <= 21 || Dealer.getDealerHandValue() > 21) {

                    System.out.println("You won");
                    winText.setForeground(new Color(245, 233, 66));
                    winText.setText("You won!");
                    Player.chipCounter = chipCounter + bet * 2;

                } else if (Player.getPlayerHandValue() < Dealer.getDealerHandValue() || Player.getPlayerHandValue() > 21) {

                    System.out.println("You lost");
                    winText.setForeground(new Color(245, 233, 66));
                    winText.setText("You lose!");

                    if (chipCounter == 0) {

                        winText.setText("You ran out of chips!");
                        okButton.setVisible(true);
                        hitButton.setVisible(false);
                        standButton.setVisible(false);
                        Player.chipCounter = 100;
                    } else {

                        standButton.setVisible(false);
                        hitButton.setVisible(false);
                        playAgainNo.setVisible(true);
                        playAgainYes.setVisible(true);
                        playAgain.setVisible(true);
                    }

                }
                standButton.setVisible(false);
                hitButton.setVisible(false);
                playAgainNo.setVisible(true);
                playAgainYes.setVisible(true);
                playAgain.setVisible(true);

            }


        });

        hitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Random rand = new Random();
                int index = rand.nextInt(52);

                Player.getPlayerHand().add(Main.cardsShuffled.get(index));

                playerCards.get(i).setIcon(Main.cardsShuffled.get(index).imageIcon);


                System.out.println(Player.getPlayerHandValue());

                if (Player.getPlayerHand().size() == 5) {

                    winText.setForeground(new Color(245, 233, 66));
                    winText.setText("You won!");
                    Player.chipCounter = chipCounter + bet * 2;
                }

                if (Player.getPlayerHandValue() > 21) {

                    dealerCards.get(1).setIcon(Dealer.getDealerHand().get(1).imageIcon);
                    winText.setForeground(Color.RED);
                    winText.setText("You lose!");

                    if (chipCounter == 0) {

                        winText.setText("You ran out of chips!");
                        okButton.setVisible(true);
                        hitButton.setVisible(false);
                        standButton.setVisible(false);
                        Player.chipCounter = 100;

                    } else {

                        standButton.setVisible(false);
                        hitButton.setVisible(false);
                        playAgainNo.setVisible(true);
                        playAgainYes.setVisible(true);
                        playAgain.setVisible(true);
                    }

                }

                i++;

            }
        });

        playAgainNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GUI.singlePlayerPanel.setVisible(false);
                GUI.panel.setVisible(true);
                GUI.frame.setContentPane(GUI.panel);
                GUI.singlePlayerPanel.removeAll();
                GUI.singlePlayerPanel.revalidate();
                GUI.singlePlayerPanel.repaint();


            }
        });

        playAgainYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GUI.singlePlayerPanel.removeAll();

                try {
                    new SinglePlayerGUI().SinglePlayerGUI();
                } catch (IOException | FontFormatException ioException) {
                    ioException.printStackTrace();
                }

            }
        });


        confirmBet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                bet = Integer.parseInt(betInput.getText());

                if (bet < 1 || bet > chipCounter) {

                    betInput.setText("");


                } else {

                    chipLabel.setText(String.valueOf(chipCounter - bet));
                    chipCounter = chipCounter - bet;
                    betInput.setText("");

                    betInput.setVisible(false);
                    confirmBet.setVisible(false);

                }
            }
        });


        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GUI.singlePlayerPanel.setVisible(false);
                GUI.panel.setVisible(true);
                GUI.frame.setContentPane(GUI.panel);
                GUI.singlePlayerPanel.removeAll();
                GUI.singlePlayerPanel.revalidate();
                GUI.singlePlayerPanel.repaint();


            }
        });


    }

}
