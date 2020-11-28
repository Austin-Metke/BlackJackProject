import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//TODO Set fonts and font sizes, add functionality to everything
public class Options {


    static JToggleButton charlieToggle = new JToggleButton();
    static JToggleButton randaceToggle = new JToggleButton();
    static JButton returnMenu = new JButton();
    boolean Charlie;
    boolean randdelcareAce;

    public static void optionsGUI() {

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


        returnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GUI.optionsPanel.setVisible(false);
                GUI.panel.setVisible(true);
                GUI.frame.setContentPane(GUI.panel);

            }
        });


    }


}


