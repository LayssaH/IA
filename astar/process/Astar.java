package astar.process;

import astar.map.*;

import java.util.ArrayList;

public class Astar {

    private Node start;
    private Node goal;

    private Graph graph;

    private OpenList openList;
    private ClosedList closedList;
    private ArrayList<Node> finalList;

    private Node current ;

    private Node predecessor = null ;

    public Astar(int lined, int columnd, int linea, int columna, Graph graph) {

        this.graph = graph;

        start = graph.getNode(lined, columnd);
        goal = graph.getNode(linea, columna);

        start.setCostStart();
        start.setPredecessor(start);


        openList = new OpenList();
        closedList = new ClosedList();
        finalList = new ArrayList<Node>();


        openList.add(start);

    }


    public void AstarManager(){
        if ((!openList.isEmpty()) && (!closedList.contains(goal))){
            current = minCost(this.openList);
            this.closedList.add(current);
            this.openList.remove(current);
            neighbors(current);
            for (Node next : current.getNeighbors()) {
                if (!closedList.contains(next)) {
                    next.setPredecessor(current);
                    next.cost(goal);
                    if (!openList.contains(next)) {
                        openList.add(next);
                    }else{
                        Node node = new Node(next.getLine(),next.getColumn());
                        node.setPredecessor(current);
                        node.cost(goal);

                        if(node.getCost() < next.getCost()){
                            openList.add(next);
                            next.setPredecessor(current);
                            next.setValues(node.getCost(),node.getWeight(),node.getHeuristic());
                        }
                    }
                }
            }
        }
        else {
            finalList();
        }
    }

    public void finalList(){
        if(!finalList.contains(start)) {
            if ((!closedList.isEmpty()) && closedList.contains(goal)) {
                if(finalList.isEmpty()) {
                    finalList.add(goal);
                    predecessor = goal.getPredecessor();
                    upDateFinalList();
                }
                else{
                    upDateFinalList();
                }
            }
        }
    }

    public void upDateFinalList(){
        if(predecessor != null){
            finalList.add(predecessor);
            predecessor = predecessor.getPredecessor();
        }
    }


    public Node minCost(ArrayList<Node> list) {
        Node min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (min.getCost() > list.get(i).getCost()) {
                min = list.get(i);
            }
        }
        return min;
    }

    public void neighbors(Node node) {
        int line = node.getLine();
        int column = node.getColumn();
        if ((!graph.isOnTop(graph.getNode(line, column))) && (!isaTrap(this.graph.getNode(line - 1, column)))) {
            node.getNeighbors().add(this.graph.getNode(line - 1, column));
        }
        if ((!graph.isOnLeftBorder(graph.getNode(line, column)))&& (!isaTrap(this.graph.getNode(line, column - 1)))) {
            node.getNeighbors().add(this.graph.getNode(line, column - 1));
        }
        if ((!graph.isOnRightBorder(graph.getNode(line, column))) && (!isaTrap(this.graph.getNode(line, column + 1)))) {
            node.getNeighbors().add(this.graph.getNode(line, column + 1));
        }
        if ((!graph.isOnBottom(graph.getNode(line, column))) && (!isaTrap(this.graph.getNode(line + 1, column)))) {
            node.getNeighbors().add(this.graph.getNode(line + 1, column));
        }
    }

    public boolean isaTrap(Node node) {
        if (node != null) {
            if (node instanceof Trap) {
                return true;
            }
        }
        return false;
    }

    public Node getStart(){ return this.start;}

    public Node getGoal(){ return this.goal;}

    public OpenList getOpenList(){ return this.openList;}

    public ClosedList getClosedList(){ return this.closedList;}

    public ArrayList<Node> getFinalList(){ return this.finalList;}

    public Node getCurrent(){ return this.current;}

}
