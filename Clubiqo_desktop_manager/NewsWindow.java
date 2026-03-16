import javax.swing.*;
import java.awt.*;

public class NewsWindow extends JFrame {
    public NewsWindow(int width, int height) {
        this.setLayout(new FlowLayout());
        this.setTitle("Clubiqo Manager News");
        this.setSize(width,height);

        this.setVisible(true);
    }
}
