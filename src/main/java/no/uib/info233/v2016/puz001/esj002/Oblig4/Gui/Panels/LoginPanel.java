package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Marius on 22.04.16.
 * This class serves as a LoginPanel for the
 * program.
 * @author puz001, esj002
 */
public class LoginPanel extends JPanel {

    //JLabels
    private final JLabel userLabel= new JLabel("Username: ");
    private final JLabel passwordLabel= new JLabel("Password: ");
    private final JLabel loggedInLabel = new JLabel(("Not logged in."));

    //JTextfields
    private final JTextField userField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();

    //JButtons
    private final JButton loginButton = new JButton("Login");
    private final JButton registerButton = new JButton("Register");

    /**
     * Constructor for the panel
     */
    public LoginPanel(){
        this.setLayout(new GridBagLayout());
        setupComponents();
        setVisible(true);
    }

    /**
     * Sets up some of the components and places them all into
     * the panel using GridBagConstraints.
     */
    private void setupComponents(){
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

    /**
     * This is a getter for the passwordField field
     * @return - The JPasswordField value from the passwordField field
     */
    public JPasswordField getPasswordField() {
        return passwordField;
    }

    /**
     * This is a getter for the userField field
     * @return - The JTextField value from the userField field
     */
    public JTextField getUserField() {
        return userField;
    }

    /**
     * This is a getter for the loginButton field
     * @return - The JButton value from the loginButton field
     */
    public JButton getLoginButton() {
        return loginButton;
    }

    /**
     * This is a getter for the registerButton field
     * @return - The JButton value from the registerButton field
     */
    public JButton getRegisterButton() {
        return registerButton;
    }

    /**
     * This is a getter for the loggedInLabel field
     * @return - The JLabel value from the loggedInLabel field
     */
    public JLabel getLoggedInLabel() {
        return loggedInLabel;
    }
}
