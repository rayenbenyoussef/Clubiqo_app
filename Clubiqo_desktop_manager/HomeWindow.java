import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HomeWindow extends JFrame {

    public HomeWindow(int width,int height) {
        this.setTitle("Clubiqo Manager Home");
        this.setSize(width, height);
        this.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(245,245,245));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        JPanel memberspanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image img = new ImageIcon("assets/members.jpg").getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };

        memberspanel.setPreferredSize(new Dimension(400,150));
        memberspanel.setMaximumSize(new Dimension(600,150));
        memberspanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel text=new JLabel();
        panel.add(memberspanel);

        panel.add(Box.createRigidArea(new Dimension(0,20)));


        JPanel eventspanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image img = new ImageIcon("assets/events.jpg").getImage();
                g.drawImage(img,0,0,getWidth(),getHeight(),this);
            }
        };

        eventspanel.setPreferredSize(new Dimension(400,150));
        eventspanel.setMaximumSize(new Dimension(600,150));
        eventspanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(eventspanel);

        panel.add(Box.createRigidArea(new Dimension(0,20)));


        JPanel newspanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image img = new ImageIcon("assets/news.jpg").getImage();
                g.drawImage(img,0,0,getWidth(),getHeight(),this);
            }
        };

        newspanel.setPreferredSize(new Dimension(400,150));
        newspanel.setMaximumSize(new Dimension(600,150));
        newspanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(newspanel);

        this.add(panel, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
