import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Handler implements Runnable {
    private List<List<Block>> map;
    private Gui gui;
    private Snake snake;

    public Handler() {
        map = new ArrayList<List<Block>>();
        gui = new Gui();
        Graphics2D g2d = gui.getBuffer().createGraphics();
        for (int i = 0; i < Constants.ROW; i++) {
            List<Block> row = new ArrayList<Block>();
            for (int j = 0; j < Constants.COL; j++) {
                Block block = new Block(j, i, g2d);
                row.add(block);
            }
            map.add(row);
        }
        snake = new Snake(map);
    }

    private void generateMap() {
        for (List<Block> row : map) {
            for (Block block : row) {
                block.gotoAndStop(1);
            }
        }
        snake.show();
        gui.repaint();
    }

    public void run() {
        generateMap();
        try {
            Thread.sleep(Constants.INTERVAL);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //noinspection InfiniteLoopStatement
        while (true) {
            int fb = snake.move();
            gui.repaint();
            if (fb == -1) {
                generateMap();
            }
            try {
                Thread.sleep(Constants.INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
