import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginWindow extends JFrame {
    public LoginWindow(int width,int height) {
        this.setLayout(null);
        this.setTitle("Clubiqo Manager Login");
        this.setSize(new Dimension(width,height));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(245,245,245));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBounds(this.getWidth()/4,this.getHeight()/5,this.getWidth()/2,this.getHeight()/2);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createRigidArea(new Dimension(0, 20)));

        Image img = new ImageIcon("assets/clubiqo-cover.png").getImage();
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
        loginbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new HomeWindow(width, height);
                LoginWindow.this.dispose();
            }
        });

        panel.add(loginbtn);

        this.add(panel);


        this.setVisible(true);

    }
}
