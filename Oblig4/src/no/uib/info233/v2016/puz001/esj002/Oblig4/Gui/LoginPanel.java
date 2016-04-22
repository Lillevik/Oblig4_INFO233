package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by goat on 22.04.16.
 */
public class LoginPanel extends JPanel {

    //JLabels
    private JLabel userLabel= new JLabel("Username: ");
    private JLabel passwordLabel= new JLabel("Password: ");

    //JTextfields
    private JTextField userField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();

    public LoginPanel(){
        setLayout(new GridBagLayout());
        setVisible(true);
    }

    public void setupComponents(){
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.BASELINE;
    }





}
