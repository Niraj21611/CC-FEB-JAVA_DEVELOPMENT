package FeeReportManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class index extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4;
    JButton b1,b2;
    JPanel p1,p2,p3;
    Font f = new Font("Arial",Font.BOLD,20);

    index(){
        super("Home Page");
        setSize(400,200);
        setLocation(100,100);
        setVisible(true);

        l1 = new JLabel("Fee Report");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f);

        l2 = new JLabel("Admin Login");

        l3 = new JLabel("Accountant Login");

        b1 = new JButton("Login");
        b1.setFocusable(false);
        b1.addActionListener(this);

        b2 = new JButton("Login");
        b2.setFocusable(false);
        b2.addActionListener(this);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image img = i.getImage().getScaledInstance(130,100,Image.SCALE_DEFAULT);
        ImageIcon ii = new ImageIcon(img);
        l4 = new JLabel(ii);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(2,2,10,10));
        p2.add(l2);
        p2.add(b1);
        p2.add(l3);
        p2.add(b2);

        p3 = new JPanel();
        p3.setLayout(new GridLayout(1,1,10,10));
        p3.add(l4);

        this.setLayout(new BorderLayout(0,0));
        this.add(p1,"North");
        this.add(p2, "Center");
        this.add(p3,"West");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            new Admin();
            this.setVisible(false);
        }
        if(e.getSource() == b2){
            new Accountant();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new index();
    }
}
