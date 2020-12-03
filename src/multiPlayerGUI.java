import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class MultiPlayer {


    static JButton hostServer = new JButton();
    static JButton connectServer = new JButton();
    static JButton returnMenu = new JButton();
    static JTextField ipField = new JTextField();
    static JTextField addrField = new JTextField();



    static void Start() throws IOException, FontFormatException {


        GUI.panel.setVisible(false);
        GUI.multiplayerPanel.setLayout(null);
        GUI.multiplayerPanel.setVisible(true);
        GUI.multiplayerPanel.setBackground(Color.GREEN.darker());
        GUI.frame.setContentPane(GUI.multiplayerPanel);

        GUI.multiplayerPanel.add(hostServer);
        GUI.multiplayerPanel.add(connectServer);
        GUI.multiplayerPanel.add(ipField);
        GUI.multiplayerPanel.add(addrField);
        GUI.multiplayerPanel.add(returnMenu);

        hostServer.setBounds(305, 136, 350, 60);
        connectServer.setBounds(305, 217, 350, 60);
        returnMenu.setBounds(488, 297, 159, 40);

        hostServer.setBackground(GUI.buttonColor);
        connectServer.setBackground(GUI.buttonColor);
        returnMenu.setBackground(GUI.buttonColor);

        hostServer.setBorder(GUI.border);
        connectServer.setBorder(GUI.border);
        returnMenu.setBorder(GUI.border);

        Font font = Font.createFont(Font.TRUETYPE_FONT, new File(".\\CasinoFlat.ttf"));
        Font buttonFont = font.deriveFont(20f);


        hostServer.setText("Host Server");
        connectServer.setText("Connect to Server");
        returnMenu.setText("Back");

        hostServer.setFont(buttonFont);
        connectServer.setFont(buttonFont);
        returnMenu.setFont(buttonFont);





    }






}
