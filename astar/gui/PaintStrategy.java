package astar.gui;

import astar.map.*;
import astar.config.GameConfiguration;

import java.awt.*;
import java.util.ArrayList;

public class PaintStrategy {

    public void paint(Graph graph, Graphics graphics) {
        int nodeSize = GameConfiguration.NODE_SIZE;
        Node[][] nodes = graph.getNodes();

        for (int lineIndex = 0; lineIndex < graph.getLineCount(); lineIndex++ ){
            for(int columnIndex = 0; columnIndex < graph.getColumnCount(); columnIndex++){
                Node node = nodes[lineIndex][columnIndex];

                if (node.isaTrap()){
                    graphics.setColor(Color.BLACK);
                    graphics.fillRect(node.getColumn() * nodeSize, node.getLine() * nodeSize, nodeSize, nodeSize);

                }
                else{
                    graphics.setColor(Color.WHITE);
                    graphics.fillRect(node.getColumn() * nodeSize, node.getLine() * nodeSize, nodeSize, nodeSize);
                }

            }
        }

    }

    public void paint(Node position, Graphics graphics){
        int nodeSize = GameConfiguration.NODE_SIZE;
        int x = position.getLine();
        int y = position.getColumn();

        graphics.setColor(Color.RED);
        graphics.fillRect(y * nodeSize, x * nodeSize, nodeSize, nodeSize);
    }

    public void paint(ArrayList<Node> path, Graphics graphics){
        int nodeSize = GameConfiguration.NODE_SIZE;

        for (int i= 0; i <path.size() ; i++ ){

            Node node = path.get(i);

            graphics.setColor(Color.BLUE);
            graphics.fillRect(node.getColumn() * nodeSize, node.getLine() * nodeSize, nodeSize, nodeSize);
        }
    }
    public void paint(OpenList openList, Graphics graphics){
        int nodeSize = GameConfiguration.NODE_SIZE;

        for (int i= 0; i < openList.size() ; i++ ){

            Node node = openList.get(i);

            graphics.setColor(Color.YELLOW);
            graphics.fillRect(node.getColumn() * nodeSize, node.getLine() * nodeSize, nodeSize, nodeSize);
        }
    }
    public void paint(OpenList openList,int action, Graphics graphics){
        int nodeSize = GameConfiguration.NODE_SIZE;

        for (int i= 0; i < openList.size() ; i++ ){

            Node node = openList.get(i);

            graphics.setFont(new Font("Dialog", 0, 10   ));
            graphics.setColor(Color.BLACK);
            graphics.drawString("coût: "+node.getCost(), node.getColumn() * nodeSize, node.getLine()* nodeSize);
        }
    }

    public void paint(ClosedList closedList, Graphics graphics){
        int nodeSize = GameConfiguration.NODE_SIZE;

        for (int i= 0; i < closedList.size() ; i++ ) {

            Node node = closedList.get(i);

            graphics.setColor(Color.GREEN);
            graphics.fillRect(node.getColumn() * nodeSize, node.getLine() * nodeSize, nodeSize, nodeSize);
        }
    }

    public void paint(String string,Graphics graphics){
        int nodeSize = GameConfiguration.NODE_SIZE;

        if(string == "position"){
            graphics.setColor(Color.RED);
            graphics.fillRect(nodeSize, nodeSize, nodeSize, nodeSize);
        }
        else if(string == "trap"){
            graphics.setColor(Color.BLACK);
            graphics.fillRect(nodeSize, nodeSize+50, nodeSize, nodeSize);
        }
        else if(string == "openlist"){
            graphics.setColor(Color.YELLOW);
            graphics.fillRect(nodeSize, nodeSize+100, nodeSize, nodeSize);
        }
        else if(string == "closedlist"){
            graphics.setColor(Color.GREEN);
            graphics.fillRect( nodeSize, nodeSize+150, nodeSize, nodeSize);
        }
        else{
            graphics.setColor(Color.BLUE);
            graphics.fillRect(nodeSize, nodeSize+200, nodeSize, nodeSize);
        }
    }
    public void paint(String string,int action,Graphics graphics){
        int nodeSize = GameConfiguration.NODE_SIZE;

        int xpref = 50;
        int ypref = 30;

        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Dialog", 0, 15   ));

        if(string == "position"){
            graphics.drawString("Start/Goal",nodeSize+xpref,nodeSize+ypref);
        }
        else if(string == "trap"){
            graphics.drawString("Trap",nodeSize+xpref, nodeSize+50+ypref);
        }
        else if(string == "openlist"){
            graphics.drawString("Open list",nodeSize+xpref,nodeSize+100+ypref);
        }
        else if(string == "closedlist"){
            graphics.drawString("Closed list",nodeSize+xpref,nodeSize+150+ypref);
        }
        else{
            graphics.drawString("Final list",nodeSize+xpref,nodeSize+200+ypref);
        }
    }
    public void paint(Graph graph, Node position, ArrayList<Node> path, OpenList openList, ClosedList closedList, Graphics graphics){
        int nodeSize = GameConfiguration.NODE_SIZE;
        Node[][] nodes = graph.getNodes();

        for (int lineIndex = 0; lineIndex < graph.getLineCount(); lineIndex++ ){
            for(int columnIndex = 0; columnIndex < graph.getColumnCount(); columnIndex++){
                Node node = nodes[lineIndex][columnIndex];

                if (node.isaTrap()){
                    graphics.setColor(Color.WHITE);
                    graphics.fillRect(node.getColumn() * nodeSize, node.getLine() * nodeSize, nodeSize, nodeSize);

                }
                else{
                    graphics.setColor(Color.WHITE);
                    graphics.fillRect(node.getColumn() * nodeSize, node.getLine() * nodeSize, nodeSize, nodeSize);
                }

            }
        }
        int x = position.getLine();
        int y = position.getColumn();

        graphics.setColor(Color.WHITE);
        graphics.fillRect(y * nodeSize, x * nodeSize, nodeSize, nodeSize);

        for (int i= 0; i <path.size() ; i++ ){

            Node node = path.get(i);

            graphics.setColor(Color.WHITE);
            graphics.fillRect(node.getColumn() * nodeSize, node.getLine() * nodeSize, nodeSize, nodeSize);
        }
        for (int i= 0; i < openList.size() ; i++ ){

            Node node = openList.get(i);

            graphics.setColor(Color.WHITE);
            graphics.fillRect(node.getColumn() * nodeSize, node.getLine() * nodeSize, nodeSize, nodeSize);
        }
        for (int i= 0; i < closedList.size() ; i++ ) {

            Node node = closedList.get(i);

            graphics.setColor(Color.WHITE);
            graphics.fillRect(node.getColumn() * nodeSize, node.getLine() * nodeSize, nodeSize, nodeSize);
        }
    }

    public void paint(Node position,OpenList openList ,Graphics graphics){
        int nodeSize = GameConfiguration.NODE_SIZE;
        int x = position.getLine();
        int y = position.getColumn();

        graphics.setColor(Color.WHITE);
        graphics.fillRect(y * nodeSize, x * nodeSize, nodeSize, nodeSize);

        for (int i= 0; i < openList.size() ; i++ ){

            Node node = openList.get(i);

            graphics.setFont(new Font("Dialog", 0, 10   ));
            graphics.setColor(Color.BLACK);
            graphics.drawString("", node.getColumn() * nodeSize, node.getLine()* nodeSize);
        }

    }

}


