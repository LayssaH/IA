package astar.config;

public class GameConfiguration {

    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 400;

    public static final int NODE_SIZE = 40;

    public static final int LINE_COUNT = WINDOW_HEIGHT / NODE_SIZE;
    public static final int COLUMN_COUNT = WINDOW_WIDTH / NODE_SIZE;

    public static final int NUMBER_TRAP = 40;

    public static int STARTLINE = 0;
    public static int STARTCOLUMN = 0;

    public static int GOALLINE = 9;
    public static int GOALCOLUMN = 9;

    public static int GAME_SPEED = 1000;

}
