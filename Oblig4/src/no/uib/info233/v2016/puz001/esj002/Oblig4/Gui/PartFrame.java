package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created 18.04.2016.
 * This class represents the parts of a course
 */
public class PartFrame extends JFrame {


    //These are the fields of the IssuePanel class.
    private static final long serialVersionUID = 4161520540703687836L;
    private LayoutManager layout = new BorderLayout(1, 1);

    //Labels

    //TextFields
    private JTextField courseNameField = new JTextField();
    private JTextField descriptionField = new JTextField();



    //Panels
    private JPanel spine = new JPanel(layout);
    private TablePanel tp;
    private ControlPanelPartFrame cppf = new ControlPanelPartFrame();



    //Models and tables
    private TableModel model = new TableModel();
    private JTable table = new JTable(model);
    private JScrollPane tablePane;


    /**
     * This is the constructor of the PartFrame
     * class.
     */
    public PartFrame(){
        super("Edit course parts");
        setBounds(30, 30, 30, 30);
        tableRows();
        tablePane = new JScrollPane(table);
        tp = new TablePanel(tablePane);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 650));
        setResizable(true);
        this.setLayout(layout);
        setupComponents();
        spine.add(cppf, BorderLayout.WEST);
        spine.add(tp, BorderLayout.CENTER);
        setContentPane(spine);
        pack();
        setVisible(false);
    }

    /**
     * This method sets up some components.
     */
    public void setupComponents(){
        courseNameField.setPreferredSize(new Dimension(150, 24));
        descriptionField.setPreferredSize(new Dimension(150, 24));

    }
    /**
     * This method clears the model and reads the rows
     * and columns again.
     * It was primarily made to reduce code duplication
     * by reusing some code where possible.
     */
    public void tableRows(){
        model.setRowCount(0);
        model.setColumnCount(0);
        model.addColumn("Course");
        model.addColumn("Part name");
        model.addColumn("Weigth");
    }

    public TableModel getModel() {
        return model;
    }

    public ControlPanelPartFrame getCp() {
        return cppf;
    }
}

