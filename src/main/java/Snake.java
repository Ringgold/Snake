import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<List<Block>> map;
    private List<Point> body;
    public static String direction;

    public Snake(List<List<Block>> map) {
        this.map = map;
        body = new ArrayList<Point>();
        direction = "right";
    }

    public void show() {
        body.add(new Point(0, 0));
        body.add(new Point(1, 0));
        body.add(new Point(2, 0));
        for (Point p: body) {
            map.get(p.y).get(p.x).gotoAndStop(2);
        }
    }

    public void move() {
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
        body.add(np);
        map.get(np.y).get(np.x).gotoAndStop(2);
        p = body.get(0);
        map.get(p.y).get(p.x).gotoAndStop(1);
        body.remove(0);
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
}
