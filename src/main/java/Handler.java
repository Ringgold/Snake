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
    }

    private void generateMap() {
        Graphics2D g2d = gui.getBuffer().createGraphics();
        for (int i = 0; i < Constants.ROW; i++) {
            List<Block> row = new ArrayList<Block>();
            for (int j = 0; j < Constants.COL; j++) {
                Block block = new Block(j, i, g2d);
                block.gotoAndStop(1);
                row.add(block);
            }
            map.add(row);
        }
        snake = new Snake(map);
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
            snake.move();
            gui.repaint();
            try {
                Thread.sleep(Constants.INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
