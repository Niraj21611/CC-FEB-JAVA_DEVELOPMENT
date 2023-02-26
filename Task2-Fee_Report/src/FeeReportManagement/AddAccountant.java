package FeeReportManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAccountant extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6;
    JTextField tf1,tf2,tf3,tf4,tf5;
    JButton b1,b2;
    JPanel p1,p2;
    Font f = new Font("Poppins", Font.BOLD, 15);


    AddAccountant(){
        super("Accountant Section");
        setLocation(100,100);
        setSize(500,400);

        l1 = new JLabel("Add Accountant");
        l1.setFont(new Font("Poppins", Font.BOLD, 18));

        l2 = new JLabel("Name");
        l2.setFont(f);
        tf1 = new JTextField();

        l3 = new JLabel("Password");
        l3.setFont(f);
        tf2 = new JTextField();

        l4 = new JLabel("E-mail");
        l4.setFont(f);
        tf3 = new JTextField();

        l5 = new JLabel("Contact");
        l5.setFont(f);
        tf4 = new JTextField();

        l6 = new JLabel("Address");
        l6.setFont(f);
        tf5 = new JTextField();

        b1 = new JButton("Add Accountant");
        b1.setFocusable(false);
        b1.addActionListener(this);

        b2 = new JButton("Back");
        b2.setFocusable(false);
        b2.addActionListener(this);

        p2 = new JPanel();
        p2.add(l1);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(6,2,10,10));
        p1.add(l2);
        p1.add(tf1);
        p1.add(l3);
        p1.add(tf2);
        p1.add(l4);
        p1.add(tf3);
        p1.add(l5);
        p1.add(tf4);
        p1.add(l6);
        p1.add(tf5);
        p1.add(b1);
        p1.add(b2);

        this.setLayout(new BorderLayout(10,10));
        this.add(p1, "Center");
        this.add(p2,"North");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = tf1.getText();
        String pass = tf2.getText();
        String email = tf3.getText();
        String mobile = tf4.getText();
        String add = tf5.getText();

        if(e.getSource() == b1){
            try{
                Connection_Class con = new Connection_Class();
                String q = "INSERT INTO accountant(name,password,email,contact,address) VALUES('"+name+"','"+pass+"','"+email+"','"+mobile+"','"+add+"')";
                int a = con.stm.executeUpdate(q);
                if(a == 1){
                    this.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Your data was inserted successfully!");
                    new AddAccountant();
                }else{
                    this.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Your data was not inserted!");
                }
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }

        if(e.getSource() == b2){
            this.setVisible(false);
            new AdminSection();
        }
    }

    public static void main(String[] args) {
        new AddAccountant();
    }
}
