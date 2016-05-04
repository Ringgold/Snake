import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    public static String direction;
    private List<List<Block>> map;
    private List<Point> body;
    private Food food;

    public Snake(List<List<Block>> map) {
        this.map = map;
        body = new ArrayList<Point>();
        direction = "right";
        food = new Food(map);
    }

    public static void changeDirection(String dic) {
        if (dic.equals("up") || dic.equals("down")) {
            if (direction.equals("left") || direction.equals("right")) {
                direction = dic;
                return;
            }
        }
        if (dic.equals("left") || dic.equals("right")) {
            if (direction.equals("up") || direction.equals("down")) {
                direction = dic;
            }
        }
    }

    public void show() {
        body.clear();
        direction = "right";
        body.add(new Point(0, 0));
        body.add(new Point(1, 0));
        body.add(new Point(2, 0));
        for (Point p : body) {
            map.get(p.y).get(p.x).gotoAndStop(2);
        }
        food.generateFood();
    }

    public int move() {
        Point p = body.get(body.size() - 1);
        Point np = new Point(p.x, p.y);
        if (direction.equals("right")) {
            np.x++;
        } else if (direction.equals("left")) {
            np.x--;
        } else if (direction.equals("up")) {
            np.y--;
        } else if (direction.equals("down")) {
            np.y++;
        }
        if (np.x < 0 || np.x >= Constants.COL || np.y < 0 || np.y >= Constants.ROW) {
            return -1;
        }
        int frame = map.get(np.y).get(np.x).getFrame();
        if (frame == 2) {
            return -1;
        }
        body.add(np);
        map.get(np.y).get(np.x).gotoAndStop(2);
        if (frame == 1) {
            p = body.get(0);
            map.get(p.y).get(p.x).gotoAndStop(1);
            body.remove(0);
        } else {
            food.generateFood();
        }
        return 0;
    }
}
