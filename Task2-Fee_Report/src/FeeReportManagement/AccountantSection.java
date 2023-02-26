package FeeReportManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountantSection extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    JPanel p1,p2;
    Font f = new Font("Arial",Font.BOLD,20);

    AccountantSection(){
        super("Accountant Section");
        setLocation(100,100);
        setSize(450,400);

        l1 = new JLabel("Accountant Section");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f);

        b1 = new JButton("Add Student");
        b1.setFocusable(false);
        b1.addActionListener(this);

        b2 = new JButton("View Student");
        b2.setFocusable(false);
        b2.addActionListener(this);

        b3 = new JButton("Edit Student");
        b3.setFocusable(false);
        b3.addActionListener(this);

        b4 = new JButton("Due Fees");
        b4.setFocusable(false);
        b4.addActionListener(this);

        b5 = new JButton("Logout");
        b5.setFocusable(false);
        b5.addActionListener(this);

        b6 = new JButton("Back");
        b6.setFocusable(false);
        b6.addActionListener(this);

        b7 = new JButton("Delete Student");
        b7.setFocusable(false);
        b7.addActionListener(this);

        p1 = new JPanel(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2 = new JPanel(new GridLayout(7,1,5,5));
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b7);
        p2.add(b5);
        p2.add(b6);


        this.setLayout(new BorderLayout(0,0));
        this.add(p1, "North");
        this.add(p2, "Center");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            new AddStudent();
            this.setVisible(false);
        }

        if(e.getSource() == b2){
            this.setVisible(true);
            new ViewStudent();
        }

        if(e.getSource() == b3){
            new EditStudent();
            this.setVisible(false);
        }

        if(e.getSource() == b4){
            this.setVisible(true);
            new DueFees();
        }

        if(e.getSource() == b5){
            new index();
            this.setVisible(false);
        }

        if(e.getSource() == b6){
            new Accountant();
            this.setVisible(false);
        }

        if(e.getSource() == b7){
            new deleteStudent();
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AccountantSection();
    }
}
