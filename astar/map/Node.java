package astar.map;

import java.util.ArrayList;

public class Node {
    private int line;
    private int column;

    private int cost;
    private int heuristic;
    private int weight;
    Node predecessor;
    private ArrayList<Node> neighbors;

    public Node(int line, int column) {
        this.line = line ;
        this.column = column ;
        this.neighbors = new ArrayList<Node>();
    }

    public void weight(){
        this.weight = predecessor.weight +1 ;
    }

    public void setCostStart(){
        this.weight = 0;
        this.heuristic = 500;
        this.cost = 500;
    }
    public void setValues(int cost,int weight,int heuristic){
        this.weight = weight;
        this.heuristic = heuristic;
        this.cost = cost;
    }

    public void heuristic(Node arrive){
        int dline = this.line - arrive.getLine();
        int dcolumn = this.column - arrive.getColumn();
        this.heuristic = Math.abs(dline) + Math.abs(dcolumn);
    }

    public void cost(Node arrive){
        weight();
        heuristic(arrive);
        this.cost = this.heuristic + this.weight;
    }

    public ArrayList<Node> getNeighbors() {
        return this.neighbors;
    }
    public void setPredecessor(Node pere){
        this.predecessor = pere ;
    }

    public int getWeight(){ return this.weight;}

    public int getCost(){ return this.cost;}

    public int getHeuristic(){ return this.heuristic;}

    public int getLine(){ return this.line;}

    public int getColumn() { return this.column;}

    public Node getPredecessor(){ return this.predecessor;}

    public boolean isaTrap() {
        if (this != null) {
            if (this instanceof Trap) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }else if(obj != null) {
            if(obj instanceof Node) {
                Node node = (Node) obj ;
                if (node.getLine() != 0 && node.getColumn() != 0){
                    if (node.getLine() == this.getLine()
                            && node.getColumn() == this.getColumn()){
                        return true ;
                    }
                }
            }
        }
        return false ;
    }

    public String toString(){
        String s ;
        s = "line=" + this.line +" column="+ this.column+"\n";
        return s;
    }


}
