import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class App {
    static final String cardDirectoryLinux = "./Card PNGs sequential/";
    static final String cardDirectoryWindows = "\\Card PNgs sequential";
    public static ArrayList<Card> cardSelection = new ArrayList<>();
    private final Client client = new Client();
    private final Server server = new Server();
    public JPanel multiplayerPanel;
    private JPanel mainPanel;
    private JTextField selectAMenuOptionTextField;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JTextField ipaddrTextField;
    private JTextField PortTextField;
    private JButton hostServerButton;
    private JButton joinServerButton;
    private JPanel singleplayerPanel;
    private JLabel jLabel;
    private static String osName = System.getProperty("os.name");

    public App() {


        jLabel.setVisible(false);
        multiplayerPanel.setVisible(false);
        singleplayerPanel.setVisible(false);
        //main button
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                singleplayerPanel.setVisible(true);
                jLabel.setIcon(cardSelection.get(0).imageIcon);
                jLabel.setVisible(true);


            }
        });


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                multiplayerPanel.setVisible(true);

            }

        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Host server button
        hostServerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                server.port = Integer.parseInt(PortTextField.getText());


                try {
                    ServerSocket ss = new ServerSocket(server.port);
                    Socket s = ss.accept();

                    if (s.isConnected()) {
                        selectAMenuOptionTextField.setText("Client Connected: " + s.getRemoteSocketAddress());
                    }

                    InputStream inputStream = s.getInputStream();
                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);


                    jLabel.setIcon((Icon) objectInputStream.readObject());
                    jLabel.setVisible(true);


                } catch (IOException | ClassNotFoundException ioException) {
                    ioException.printStackTrace();
                }


            }
        });
        //Join server button
        joinServerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                client.ipaddr = ipaddrTextField.getText();
                client.port = Integer.parseInt(PortTextField.getText());

                if (client.ipaddr == "localhost") {

                    try {
                        client.ipaddr = InetAddress.getLocalHost().toString();
                    } catch (UnknownHostException unknownHostException) {
                        unknownHostException.printStackTrace();
                    }
                }

                try {
                    Socket s = new Socket(client.ipaddr, client.port);

                    if (s.isConnected()) {
                        selectAMenuOptionTextField.setText("Connected to Server " + s.getRemoteSocketAddress());
                    }

                    OutputStream outputStream = s.getOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                    objectOutputStream.writeObject(cardSelection.get(0).imageIcon);
                    objectOutputStream.flush();


                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) throws IOException {


        switch (osName) {

            case "Linux":
                File directory = new File(cardDirectoryLinux);
                File[] filesList = directory.listFiles();


                //For loop that adds all images as an ImageIcon object in the cardSelection ArrayList

                for (int i = 0; i < filesList.length; i++) {

                    if (filesList[i].isFile()) {

                        try {

                            BufferedImage img = ImageIO.read(new File(cardDirectoryLinux + filesList[i].getName()));
                            cardSelection.add(new Card(new ImageIcon(img), filesList[i].getName().substring(1)));
                            System.out.println("Card added: " + cardSelection.get(i).imageName);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                }
                break;
            case "Windows":

                directory = new File(cardDirectoryWindows);
                filesList = directory.listFiles();


                //For loop that adds all images as an ImageIcon object in the cardSelection ArrayList

                for (int i = 0; i < filesList.length; i++) {

                    if (filesList[i].isFile()) {

                        try {

                            BufferedImage img = ImageIO.read(new File(cardDirectoryWindows + filesList[i].getName()));
                            cardSelection.add(new Card(new ImageIcon(img), filesList[i].getName().substring(1)));
                            System.out.println("Card added: " + cardSelection.get(i).imageName);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                }
        }

        cardSelection.sort(new CardSorter());

        JFrame jframe = new JFrame("Blackjack");

        jframe.setContentPane(new App().mainPanel);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.pack();
        jframe.setVisible(true);


    }

}
