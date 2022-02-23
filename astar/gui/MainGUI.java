package astar.gui;

import astar.map.Node;
import astar.process.Astar;
import astar.map.Graph;
import astar.config.GameConfiguration;
import astar.process.AstarBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;

    private Graph graph;

    private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);

    private static final Dimension dashboardSize = new Dimension(400, 400);
    private static final Dimension dashboardInfoSize = new Dimension(200, 400);

    private static Font font = new Font("Monospaced", 1, 15);

    private Astar manager ;

    private GameDisplay dashboard;

    private GameDisplayLegends dashboardinfo;

    private JButton startButton = new JButton(" Pause ");

    private JButton resetButton = new JButton(" Reset ");

    private JButton coordButton = new JButton(" Change coordinates ");

    private JButton speedButton = new JButton(" Speed ");

    private JLabel currentinfo = new JLabel("Current node informations (press \"Pause\")");

    private MainGUI instance = this ;

    private boolean stop = false;

    public MainGUI(String title) {
        super(title);
        init();
    }

    private void init() {

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        startButton.addActionListener(new StartStopAction());
        startButton.setFont(font);
        resetButton.addActionListener(new ResetAction());
        resetButton.setFont(font);
        coordButton.addActionListener(new CoordAction());
        coordButton.setFont(font);
        speedButton.addActionListener(new SpeedAction());
        speedButton.setFont(font);

        JPanel remote = new JPanel();
        remote.add(startButton);
        remote.add(resetButton);
        remote.add(coordButton);
        remote.add(speedButton);
        remote.setBackground(new Color(128, 162, 190));

        graph = AstarBuilder.buildMap();
        manager = AstarBuilder.buildInitAstar(graph);
        dashboard = new GameDisplay(graph, manager);
        dashboardinfo = new GameDisplayLegends();

        Node current = manager.getCurrent();

        if(current != null) {
            currentinfo.setText("Current node :"+current.toString() + "  coût=" + current.getCost() + "  heuristique=" + current.getHeuristic() + "  poids=" + current.getWeight());
        }
        currentinfo.setFont(new Font("font", 0, 20));

        contentPane.setBackground(new Color(128, 162, 190));

        dashboard.setPreferredSize(dashboardSize);
        dashboardinfo.setPreferredSize(dashboardInfoSize);

        contentPane.add(remote,BorderLayout.NORTH);
        contentPane.add(currentinfo,BorderLayout.SOUTH);
        contentPane.add(dashboard, BorderLayout.WEST);
        contentPane.add(dashboardinfo, BorderLayout.EAST);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setPreferredSize(preferredSize);
        setResizable(false);
    }

    public void run(){
        while (!stop) {
            try {
                Thread.sleep(GameConfiguration.GAME_SPEED);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            this.manager.AstarManager();
            this.dashboard.repaint();

        }

    }

    private class ResetAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            MainGUI main = new MainGUI("chemin");
            Thread gameThread = new Thread(main);
            gameThread.start();
        }
    }

    private class StartStopAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!stop) {
                stop = true;
                startButton.setText(" Start ");
                if(manager.getCurrent()!=null) {
                    currentinfo.setText("Current node :" + manager.getCurrent().toString() + "  coût=" + manager.getCurrent().getCost() +
                            "  heuristique=" + manager.getCurrent().getHeuristic() + "  poids=" + manager.getCurrent().getWeight());
                }
            } else {
                stop = false;
                startButton.setText(" Pause ");
                currentinfo.setText("Current node informations (press \"Pause\")");
                Thread astarThread = new Thread(instance);
                astarThread.start();
            }
        }
    }

    private class CoordAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            ChooserGUI chooser = new ChooserGUI("Astar");
        }
    }

    private class SpeedAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] speed = {"Slow", "Medium", "Fast"};
            String s = (String) JOptionPane.showInputDialog(null,
                    "Choose Speed", "Speed Selection", JOptionPane.QUESTION_MESSAGE, null,
                    speed, speed[1]);
            if (s != null) {
                if (s.equals("Slow"))
                    GameConfiguration.GAME_SPEED = 1000;
                else if (s.equals("Medium"))
                    GameConfiguration.GAME_SPEED = 500;
                else
                    GameConfiguration.GAME_SPEED = 100;
            }else {
                GameConfiguration.GAME_SPEED = 1000;
            }
        }
    }


}
