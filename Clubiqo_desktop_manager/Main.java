import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Main {
    public static final int WIDTH=700;
    public static final int HEIGHT=800;

    public static void main(String[] args){
        JFrame mywindow = new JFrame();
        mywindow.setLayout(null);
        mywindow.setTitle("Clubiqo Desktop Manager");
        mywindow.setSize(WIDTH, HEIGHT);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(245,245,245));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBounds(WIDTH/4,HEIGHT/5,WIDTH/2,HEIGHT/2);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);


        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        Image img = new ImageIcon("clubiqo-cover.png").getImage();
        ImageIcon scaledImg =  new ImageIcon(img.getScaledInstance(200, 100, Image.SCALE_SMOOTH));
        JLabel coverlab=new JLabel(scaledImg);
        coverlab.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(coverlab);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel emaillab=new JLabel("Email:");
        emaillab.setAlignmentX(Component.CENTER_ALIGNMENT);
        emaillab.setFont(new Font("s1",1,18));
        panel.add(emaillab);

        JEditorPane email = new JEditorPane();
        email.setPreferredSize(new Dimension(200, 30));
        email.setMaximumSize(new Dimension(300, 30));
        email.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(email);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        JLabel passlab=new JLabel("Password:");
        passlab.setFont(new Font("s1",1,18));
        passlab.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(passlab);

        JPasswordField password=new JPasswordField();
        password.setPreferredSize(new Dimension(200, 30));
        password.setMaximumSize(new Dimension(300, 30));
        password.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(password);

        JLabel fpasslab=new JLabel("forget password ?");
        fpasslab.setFont(new Font("s1",1,14));
        fpasslab.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(fpasslab);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton loginbtn=new JButton("login");
        loginbtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(loginbtn);

        mywindow.add(panel);


        mywindow.setVisible(true);
    }
}
