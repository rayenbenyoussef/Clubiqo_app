import javax.swing.*;
import java.awt.*;

public class MembersWindow extends JFrame {
    public MembersWindow(int width,int height) {
        this.setLayout(new FlowLayout());
        this.setTitle("Clubiqo Manager Members");
        this.setSize(width,height);

        this.setVisible(true);
    }
}
