package astar.map;

import astar.config.GameConfiguration;

public class Graph {
    private Node[][] nodes;

    private int lineCount;
    private int columnCount;

    public Graph(int lineCount, int columnCount){
        this.lineCount = lineCount ;
        this.columnCount = columnCount ;

        int lineTrap ;
        int columnTrap ;

        nodes = new Node[lineCount][columnCount];

        for(int lineIndex = 0; lineIndex < lineCount; lineIndex++){
            for (int columnIndex = 0; columnIndex < columnCount; columnIndex++){
                nodes[lineIndex][columnIndex] = new Node(lineIndex,columnIndex);
            }
        }

        for(int nbtrap = 0; nbtrap < GameConfiguration.NUMBER_TRAP; nbtrap++){
            lineTrap = getRandomNumber(0, GameConfiguration.LINE_COUNT-1);
            columnTrap = getRandomNumber(0, GameConfiguration.COLUMN_COUNT-1);
            nodes[lineTrap][columnTrap]= new Trap(lineTrap,columnTrap);
        }
        nodes[GameConfiguration.STARTLINE][GameConfiguration.STARTCOLUMN] = new Node(GameConfiguration.STARTLINE,GameConfiguration.STARTCOLUMN);
        nodes[GameConfiguration.GOALLINE][GameConfiguration.GOALCOLUMN] = new Node(GameConfiguration.GOALLINE,GameConfiguration.GOALCOLUMN);
    }

    public Node[][] getNodes(){ return this.nodes;}

    public int getLineCount(){ return this.lineCount;}

    public int getColumnCount(){ return this.columnCount;}

    public Node getNode(int line, int column) { return nodes[line][column];}

    public boolean isOnTop(Node node) {
        int line = node.getLine();
        return line == 0;
    }

    public boolean isOnBottom(Node node){
        int line = node.getLine();
        return line == this.lineCount-1;
    }

    public  boolean isOnLeftBorder(Node node){
        int column = node.getColumn();
        return column == 0;
    }

    public boolean isOnRightBorder(Node node){
        int column = node.getColumn();
        return column == this.columnCount-1;
    }

    public String toString(){
        String s="";
        for(int i=0; i<lineCount;i++){
            for(int j=0; j<columnCount; j++){
                if(nodes[i][j].isaTrap()){
                    s+= 1;
                }
                else {
                    s+= "0";
                }
            }
            s+="\n";
        }
        return s;
    }


    private static int getRandomNumber(int min, int max) {
        return (int)(Math.random() * (double)(max + 1 - min)) + min;
    }
}
