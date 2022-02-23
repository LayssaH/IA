package astar.process;

import astar.map.Graph;
import astar.config.GameConfiguration;

public class AstarBuilder {

    public static Graph buildMap() { return new Graph(GameConfiguration.LINE_COUNT, GameConfiguration.COLUMN_COUNT);}

    public static Astar buildInitAstar(Graph graph) {
        Astar manager = new Astar(GameConfiguration.STARTLINE,GameConfiguration.STARTCOLUMN,GameConfiguration.GOALLINE,GameConfiguration.GOALCOLUMN, graph);

        return manager;
    }
}
