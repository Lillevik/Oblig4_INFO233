package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by goat on 22.04.16.
 */
public class RegisterPanel extends JPanel {

    //JLabels
    private JLabel userLabel= new JLabel("Username: ");
    private JLabel passwordLabel= new JLabel("Password: ");

    //JTextfields
    private JTextField userField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();

    //JButtons
    private JButton registerButton = new JButton("Register new user");


    public RegisterPanel(){
        this.setLayout(new GridBagLayout());
        setupComponents();
        setVisible(true);
    }

    public void setupComponents(){
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.BASELINE;

        userField.setPreferredSize(new Dimension(150, 24));
        passwordField.setPreferredSize(new Dimension(150, 24));

        gc.gridx = 0;
        gc.gridy = 0;
        this.add(userLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        this.add(userField, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        this.add(passwordLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        this.add(passwordField, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        this.add(registerButton, gc);


    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JTextField getUserField() {
        return userField;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }
}
