package astar.gui;

import javax.swing.*;
import java.awt.*;

public class GameDisplayLegends extends JPanel{
    private static final long serialVersionUID = 1L;

    private PaintStrategy paintStrategy = new PaintStrategy();

    public GameDisplayLegends(){
        this.setBackground(new Color(128, 162, 190));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.paintStrategy.paint("position",g);
        this.paintStrategy.paint("position",1,g);

        this.paintStrategy.paint("trap",g);
        this.paintStrategy.paint("trap",1,g);

        this.paintStrategy.paint("openlist",g);
        this.paintStrategy.paint("openlist",1,g);

        this.paintStrategy.paint("closedlist",g);
        this.paintStrategy.paint("closedlist",1,g);

        this.paintStrategy.paint("finallist",g);
        this.paintStrategy.paint("finallist",1,g);


    }
}
