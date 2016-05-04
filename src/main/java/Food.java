import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Food {
    private List<List<Block>> map;
    private Random random;

    public Food(List<List<Block>> map) {
        this.map = map;
        random = new Random();
    }

    public int generateFood() {
        List<Point> empty = new ArrayList<Point>();
        for (List<Block> row : map) {
            for (Block block : row) {
                if (block.getFrame() == 1) {
                    int y = map.indexOf(row);
                    int x = row.indexOf(block);
                    empty.add(new Point(x, y));
                }
            }
        }
        if (empty.size() == 0) return -1;
        int food = random.nextInt(empty.size());
        Point p = empty.get(food);
        map.get(p.y).get(p.x).gotoAndStop(3);
        return 0;
    }
}
