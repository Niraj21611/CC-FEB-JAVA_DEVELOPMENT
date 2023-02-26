package FeeReportManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudent extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11;
    JPanel p1,p2;
    JButton b1,b2;
    Font f = new Font("Arial",Font.BOLD,20);

    AddStudent(){

        super("Add Student");
        setLocation(100,100);
        setSize(450,650);

        l1 = new JLabel("Accountant Section");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f);

        l2 = new JLabel("Name");
        l2.setFont(new Font("Poppins", Font.BOLD, 15));
        tf1 = new JTextField();

        l3 = new JLabel("Email");
        l3.setFont(new Font("Poppins", Font.BOLD, 15));
        tf2 = new JTextField();

        l4 = new JLabel("Course");
        l4.setFont(new Font("Poppins", Font.BOLD, 15));
        tf3 = new JTextField();

        l5 = new JLabel("Fee");
        l5.setFont(new Font("Poppins", Font.BOLD, 15));
        tf4 = new JTextField();

        l6 = new JLabel("Paid");
        l6.setFont(new Font("Poppins", Font.BOLD, 15));
        tf5 = new JTextField();

        l7 = new JLabel("Due");
        l7.setFont(new Font("Poppins", Font.BOLD, 15));
        tf6 = new JTextField();

        l8 = new JLabel("Address");
        l8.setFont(new Font("Poppins", Font.BOLD, 15));
        tf7 = new JTextField();

        l9 = new JLabel("City");
        l9.setFont(new Font("Poppins", Font.BOLD, 15));
        tf8 = new JTextField();

        l10 = new JLabel("State");
        l10.setFont(new Font("Poppins", Font.BOLD, 15));
        tf9 = new JTextField();

        l11 = new JLabel("Country");
        l11.setFont(new Font("Poppins", Font.BOLD, 15));
        tf10 = new JTextField();

        l12 = new JLabel("Contact No.");
        l12.setFont(new Font("Poppins", Font.BOLD, 15));
        tf11 = new JTextField();

        b1 = new JButton("Add Student");
        b1.setFocusable(false);
        b1.addActionListener(this);

        b2 = new JButton("Back");
        b2.setFocusable(false);
        b2.addActionListener(this);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(12,2,10,10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(tf2);
        p2.add(l4);
        p2.add(tf3);
        p2.add(l5);
        p2.add(tf4);
        p2.add(l6);
        p2.add(tf5);
        p2.add(l7);
        p2.add(tf6);
        p2.add(l8);
        p2.add(tf7);
        p2.add(l9);
        p2.add(tf8);
        p2.add(l10);
        p2.add(tf9);
        p2.add(l11);
        p2.add(tf10);
        p2.add(l12);
        p2.add(tf11);
        p2.add(b1);
        p2.add(b2);

        this.setLayout(new BorderLayout(10,10));
        this.add(p1, "North");
        this.add(p2, "Center");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1){

            String name = tf1.getText();
            String email = tf2.getText();
            String course = tf3.getText();
            float fee = Float.parseFloat(tf4.getText());
            float paid = Float.parseFloat(tf5.getText());
            float due = Float.parseFloat(tf6.getText());
            String add = tf7.getText();
            String city = tf8.getText();
            String state = tf9.getText();
            String country = tf10.getText();
            String contact = tf11.getText();    

            try{
                Connection_Class con = new Connection_Class();
                String q = "INSERT INTO student(name,email,course,fee,paid,due,address,city,state,country,contact) VALUES('"+name+"','"+email+"','"+course+"','"+fee+"','"+paid+"','"+due+"','"+add+"','"+city+"','"+state+"','"+country+"','"+contact+"')";
                int a = con.stm.executeUpdate(q);
                if(a == 1){
                    this.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Your data was inserted successfully!");
                    new AddStudent();
                }else{
                    this.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Your data was not inserted!");
                }
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }

        if(e.getSource() == b2){
            new AccountantSection();
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
