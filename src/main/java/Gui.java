import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Gui extends JPanel {
    private BufferedImage buffer;

    public Gui() {
        buffer = new BufferedImage(Constants.WIDTH, Constants.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        window.add(this);
        window.pack();
        window.setVisible(true);
        window.setLocationRelativeTo(null);

        window.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    Snake.changeDirection("left");
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    Snake.changeDirection("right");
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    Snake.changeDirection("down");
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    Snake.changeDirection("up");
                }
            }
        });
    }

    public BufferedImage getBuffer() {
        return buffer;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(buffer, 0, 0, this);
    }
}
