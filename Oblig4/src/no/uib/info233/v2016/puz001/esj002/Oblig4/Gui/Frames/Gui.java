package no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Frames;

import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.ControlPanel;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Models.ModelFactory;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels.LoginPanel;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels.PartPanel;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels.RegisterPanel;
import no.uib.info233.v2016.puz001.esj002.Oblig4.Gui.Panels.TablePanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created 18.04.2016.
 */
public class Gui extends JFrame {


    //These are the fields of the IssuePanel class.
    private static final long serialVersionUID = 4161520540703687836L;
    private LayoutManager layout = new BorderLayout(1, 1);

    //Labels


    //TextFields
    private JTextField courseNameField = new JTextField();
    private JTextField descriptionField = new JTextField();
    private JTextField professorField = new JTextField();

    //Buttons
    private JButton partButton = new JButton(("New part"));

    //Panels
    private JPanel spine = new JPanel(layout);
    private LoginPanel lp = new LoginPanel();
    private RegisterPanel rp = new RegisterPanel();
    private TablePanel tp;
    private ControlPanel cp = new ControlPanel();
    private PartPanel pp = new PartPanel();



    //Models and tables
    private DefaultTableModel model = ModelFactory.createCourseModel();
    private JTable table = new JTable(model);
    private JScrollPane tablePane;

    //Strings

    //Menu
    private JMenuBar menuBar = new JMenuBar();
    private JMenu file = new JMenu("File");
    private JMenuItem logout = new JMenuItem("Logout");

    //Frames
    private AddStudentsFrame asf = new AddStudentsFrame();


    /**
     * This is the constructor for the Gui class
     * which is the class that basicly presents
     * entire program.
     */
    public Gui(){
        super("Course planner");
        tableRows();
        tablePane = new JScrollPane(table);
        tp = new TablePanel(tablePane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 650));
        setResizable(true);
        this.setLayout(layout);
        setupComponents();
        spine.add(cp, BorderLayout.WEST);
        spine.add(tp, BorderLayout.CENTER);
        setContentPane(lp);
        pack();
        setVisible(true);
    }

    /**
     * This method sets up the size of some of the components
     * and adds a menubar to the frame.
     */
    public void setupComponents(){
        courseNameField.setPreferredSize(new Dimension(150, 24));
        descriptionField.setPreferredSize(new Dimension(150, 24));
        professorField.setPreferredSize(new Dimension(150, 24));

        this.setJMenuBar(menuBar);

        this.menuBar.add(file);
        file.add(logout);
    }
    /**
     * This method clears the model and readds the rows
     * and columns again.
     * It was primarily made to reduce code duplication
     * by reusing some code where possible.
     */
    public void tableRows(){
        model.setRowCount(0);
        model.setColumnCount(0);
        model.addColumn("ID");
        model.addColumn("Title");
        model.addColumn("Description");
        model.addColumn("Professor");
    }

    public void loopOverTableTest(){
        for(int i = 0; i < table.getRowCount(); i++){
            Boolean checked = ((Boolean) table.getValueAt(i, 4));
            if(checked == true) {
                System.out.println(table.getValueAt(i, 3).toString());
            }
        }
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public LoginPanel getLp() {
        return lp;
    }

    public JPanel getSpine() {
        return spine;
    }

    public RegisterPanel getRp() {
        return rp;
    }

    public ControlPanel getCp() {
        return cp;
    }

    public JMenuItem getLogout() {
        return logout;
    }

    public PartPanel getPp() {
        return pp;
    }

    public JTable getTable() {
        return table;
    }

    public AddStudentsFrame getAsf() {
        return asf;
    }
}
