package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels;

import javax.swing.*;
import java.awt.*;

/**
 * This is the registerPanel class which is used for
 * registering new Employees.
 *
 * @author puz001, esj002
 */
public class RegisterPanel extends JPanel {

    //JLabels
    private JLabel userLabel= new JLabel("Username: ");
    private JLabel passwordLabel= new JLabel("Password: ");
    private JLabel fullNameLabel= new JLabel("Full name: ");

    //JTextfields
    private JTextField userField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JTextField fullNameField = new JTextField();



    //JButtons
    private JButton registerButton = new JButton("Register new user");
    private JButton cancelButton = new JButton("cancel");

    /**
     * The constructor of the RegisterPanel
     */
    public RegisterPanel(){
        this.setLayout(new GridBagLayout());
        setupComponents();
        setVisible(true);
    }

    /**
     * This method sets up the components in the
     * RegisterPanel and places them using GridBagConstraints
     */
    public void setupComponents(){
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.BASELINE;

        userField.setPreferredSize(new Dimension(150, 24));
        fullNameField.setPreferredSize(new Dimension(150, 24));
        passwordField.setPreferredSize(new Dimension(150, 24));

        gc.gridx = 0;
        gc.gridy = 0;
        this.add(userLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        this.add(userField, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        this.add(fullNameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        this.add(fullNameField, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        this.add(passwordLabel, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        this.add(passwordField, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        this.add(registerButton, gc);

        gc.gridx = 1;
        gc.gridy = 3;
        this.add(cancelButton, gc);


    }

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
     * This is a getter for the registerButton field
     * @return - The JButton value from the registerButton field
     */
    public JButton getRegisterButton() {
        return registerButton;
    }

    /**
     * This is a getter for the registerButton field
     * @return - The JButton value from the registerButton field
     */
    public JButton getCancelButton() {
        return cancelButton;
    }

    /**
     * This is a getter for the fullNameField field
     * @return - The JButton value from the fullNameField field
     */
    public JTextField getFullNameField() {
        return fullNameField;
    }
}
