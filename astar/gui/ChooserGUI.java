package astar.gui;

import astar.config.GameConfiguration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooserGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_WIDTH);

    private static Font font = new Font("Monospaced", 1, 15);

    private String[] texteDeLaComboBox = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    JComboBox startLine;

    JComboBox startColumn;

    JComboBox goalLine;

    JComboBox goalColumn;

    private int jtextFieldDim = 3;


    private JButton button;

    public ChooserGUI(String title){
        super();
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JLabel label = new JLabel("Choose start and goal's coordinates between 0 and 9");
        label.setFont(font);
        JLabel startL = new JLabel("Start :Line: ");
        startL.setFont(font);
        JLabel startC = new JLabel("Column: ");
        startC.setFont(font);
        JLabel goalL = new JLabel("Goal :Line: ");
        goalL.setFont(font);
        JLabel goalC = new JLabel("Column: ");
        goalC.setFont(font);

        button = new JButton("OK");
        button.setFont(font);
        button.addActionListener(new ChooserAction());
        button.setSize(5,5);


        startLine = new JComboBox(texteDeLaComboBox);
        startColumn = new JComboBox(texteDeLaComboBox);
        goalLine = new JComboBox(texteDeLaComboBox);
        goalColumn = new JComboBox(texteDeLaComboBox);


        JPanel panelStartCoordLine = new JPanel();
        panelStartCoordLine.setLayout(new BoxLayout(panelStartCoordLine,BoxLayout.LINE_AXIS));
        panelStartCoordLine.add(startL);
        panelStartCoordLine.add(startLine);

        JPanel panelStartCoordColumn = new JPanel();
        panelStartCoordColumn.setLayout(new BoxLayout(panelStartCoordColumn,BoxLayout.LINE_AXIS));
        panelStartCoordLine.add(startC);
        panelStartCoordLine.add(startColumn);

        JPanel panelStartCoord = new JPanel();
        panelStartCoord.setLayout(new BoxLayout(panelStartCoord,BoxLayout.PAGE_AXIS));
        panelStartCoord.add(panelStartCoordLine);
        panelStartCoord.add(panelStartCoordColumn);

        JPanel panelGoalCoordLine = new JPanel();
        panelGoalCoordLine.setLayout(new BoxLayout(panelGoalCoordLine,BoxLayout.LINE_AXIS));
        panelGoalCoordLine.add(goalL);
        panelGoalCoordLine.add(goalLine);

        JPanel panelGoalCoordColumn = new JPanel();
        panelGoalCoordColumn.setLayout(new BoxLayout(panelGoalCoordColumn,BoxLayout.LINE_AXIS));
        panelGoalCoordLine.add(goalC);
        panelGoalCoordLine.add(goalColumn);

        JPanel panelGoalCoord = new JPanel();
        panelGoalCoord.setLayout(new BoxLayout(panelGoalCoord,BoxLayout.PAGE_AXIS));
        panelGoalCoord.add(panelGoalCoordLine);
        panelGoalCoord.add(panelGoalCoordColumn);

        JPanel panelbutton = new JPanel();
        panelbutton.add(button);

        contentPane.add(label, "North");
        contentPane.add(panelStartCoord, "West");
        contentPane.add(panelGoalCoord, "East");
        contentPane.add(panelbutton, "South");

        setSize(preferredSize);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        this.setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    private class ChooserAction implements ActionListener{
        public void actionPerformed(ActionEvent e) {

            String startline = startLine.getSelectedItem().toString();
            String startcolumn = startColumn.getSelectedItem().toString();
            String goalline = goalLine.getSelectedItem().toString();
            String goalcolumn = goalColumn.getSelectedItem().toString();

            GameConfiguration.STARTLINE = Integer.parseInt(startline);
            GameConfiguration.STARTCOLUMN = Integer.parseInt(startcolumn);
            GameConfiguration.GOALLINE = Integer.parseInt(goalline);
            GameConfiguration.GOALCOLUMN = Integer.parseInt(goalcolumn);

            MainGUI main = new MainGUI("chemin");
            Thread gameThread = new Thread(main);
            gameThread.start();

            setVisible(false);
        }
    }


}
