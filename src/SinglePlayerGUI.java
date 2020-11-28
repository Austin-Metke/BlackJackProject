import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SinglePlayerGUI {


    static JButton hitButton = new JButton();
    static JButton stayButton = new JButton();

    static ArrayList<JLabel> playerCards = new ArrayList<>();
    static ArrayList<JLabel> dealerCards = new ArrayList<>();


    public static void SinglePlayerGUI() throws IOException {


        for (int i = 0; i < 5; i++) {

            playerCards.add(new JLabel());
            dealerCards.add(new JLabel());
        }

        //Set bounds of all JLabels and JButtons
        hitButton.setBounds(380, 350, 87, 20);
        stayButton.setBounds(475, 350, 87, 20);
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
        playerCards.get(0).setIcon(Player.getPlayerHand().get(0).imageIcon);
        playerCards.get(1).setIcon(Player.getPlayerHand().get(1).imageIcon);


        //set Icons for dealer hand
        dealerCards.get(0).setIcon(Dealer.getDealerHand().get(0).imageIcon);
        dealerCards.get(1).setIcon(Dealer.getDealerHand().get(1).imageIcon);

        //Add buttons to frame
        GUI.frame.add(hitButton);
        GUI.frame.add(stayButton);

        //For loop to add all playerCards to frame
        for (int i = 0; i < playerCards.size(); i++) {
            GUI.frame.add(playerCards.get(i));
        }

        //For loop to add all dealercards to frame
        for (int i = 0; i < dealerCards.size(); i++) {
            GUI.frame.add(dealerCards.get(i));
        }


        hitButton.setText("Hit");
        stayButton.setText("Stay");

        if (!Dealer.getDealerHand().get(1).visible) {

            BufferedImage cardBack = ImageIO.read(new File("Card PNGs sequential\\misc\\b1fv.png"));
            dealerCards.get(1).setIcon(new ImageIcon(cardBack));

        }


        stayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(Player.getPlayerHandValue() == 21 || Player.getPlayerHandValue() > Dealer.getDealerHandValue()) {

                    dealerCards.get(1).setIcon(Dealer.getDealerHand().get(1).imageIcon);
                    System.out.println("You won!");



                }

            }
        });

        hitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {




            }
        });


    }

}
