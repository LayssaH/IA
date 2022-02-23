package astar.map;

import java.util.ArrayList;

public class OpenList extends ArrayList<Node>{

    public OpenList(){
        super();
    }

    public boolean isaClosedList() {
        if (this != null) {
            if (this instanceof ClosedList) {
                return true;
            }
        }
        return false;
    }
}
