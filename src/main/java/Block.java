import java.awt.Color;
import java.awt.Graphics2D;


public class Block {
    private Graphics2D g2d;
    private int x, y, width, height;
    private int frame;

    public Block(int x, int y, Graphics2D g2d) {
        width = Constants.BOX_WIDTH;
        height = Constants.BOX_HEIGHT;
        this.x = x * width;
        this.y = y * height;
        this.g2d = g2d;
    }

    public int getFrame() {
        return frame;
    }

    public void gotoAndStop(int frame) {
        this.frame = frame;
        if (frame == 1) {
            g2d.setColor(Color.black);
        } else if (frame == 2) {
            g2d.setColor(new Color(0, 80, 0));
        } else if (frame == 3) {
            g2d.setColor(new Color(200, 0, 0));
        }
        g2d.fillRect(x, y, width, height);
    }
}
