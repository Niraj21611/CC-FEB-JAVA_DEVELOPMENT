package FeeReportManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminSection extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1,b2,b3;
    JPanel p1;
    Font f = new Font("Arial", Font.BOLD,20);

    AdminSection() {
        super("Admin Section");
        setLocation(100,100);
        setSize(400, 270);

        l1 = new JLabel("Admin Section");
        l1.setFont(f);
        l1.setHorizontalAlignment(JLabel.CENTER);

        b1 = new JButton("Add Accountant");
        b1.setSize(100,100);
        b1.setFocusable(false);
        b1.addActionListener(this);


        b2 = new JButton("View Accountant");
        b1.setSize(100,100);
        b2.setFocusable(false);
        b2.addActionListener(this);

        b3 = new JButton("Logout Admin");
        b1.setSize(100,100);
        b3.setFocusable(false);
        b3.addActionListener(this);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 1, 10, 10));
//        p1.setLayout(new BorderLayout(10,10));
        p1.add(l1);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);

        this.setLayout(new BorderLayout(10,10));
        this.add(p1, "Center");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            new AddAccountant();
            this.setVisible(false);
        }

        if(e.getSource() == b2){
            this.setVisible(true);
            new ViewAccountant();
        }

        if(e.getSource() == b3){
            this.setVisible(false);
            new Admin();
        }
    }

    public static void main(String[] args) {
        new AdminSection();
    }
}
