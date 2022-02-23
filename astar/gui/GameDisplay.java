package astar.gui;

import astar.map.ClosedList;
import astar.map.OpenList;
import astar.process.Astar;
import astar.map.Graph;
import astar.map.Node;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameDisplay extends JPanel {

    private static final long serialVersionUID = 1L ;

    private Graph graph;
    private Astar manager;
    private PaintStrategy paintStrategy = new PaintStrategy();

    public GameDisplay(Graph graph, Astar manager){
        this.graph = graph;
        this.manager = manager;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        this.paintStrategy.paint(this.graph,g);

        if (manager.getOpenList() != null){
            OpenList openList = manager.getOpenList();
            this.paintStrategy.paint(openList, g);
            this.paintStrategy.paint(openList,  1, g);
        }
        if (manager.getClosedList() != null){
            ClosedList closedList = manager.getClosedList();
            this.paintStrategy.paint(closedList, g);
            this.paintStrategy.paint(closedList,  1, g);
        }
        if (manager.getFinalList() != null){
            ArrayList<Node> path = manager.getFinalList();
            this.paintStrategy.paint(path, g);
        }

        Node start = manager.getStart();
        this.paintStrategy.paint(start,g);

        Node goal = manager.getGoal();
        this.paintStrategy.paint(goal,g);

    }

}
