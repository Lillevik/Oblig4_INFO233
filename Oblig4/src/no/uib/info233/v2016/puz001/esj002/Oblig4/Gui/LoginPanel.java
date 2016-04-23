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
    private JLabel loggedInLabel = new JLabel(("Not logged in."));

    //JTextfields
    private JTextField userField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();

    //JButtons
    private JButton loginButton = new JButton("Login");
    private JButton registerButton = new JButton("Register");


    public LoginPanel(){
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

        gc.gridx = 0;
        gc.gridy = 2;
        this.add(loginButton, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        this.add(registerButton, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        this.add(loggedInLabel, gc);


    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JTextField getUserField() {
        return userField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public JLabel getLoggedInLabel() {
        return loggedInLabel;
    }
}
