package FeeReportManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class EditStudent extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11;
    JPanel p1,p2;
    JButton b1,b2;
    Choice ch;
    Font f = new Font("Arial",Font.BOLD,20);

    EditStudent(){

        super("Edit Student");
        setLocation(100,100);
        setSize(450,650);

        ch = new Choice();
        try{
            Connection_Class con = new Connection_Class();
            String q = "SELECT roll_no FROM student";
            ResultSet rest = con.stm.executeQuery(q);
            while(rest.next()){
                ch.add(rest.getString("roll_no"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

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

        l13 = new JLabel("Roll No.");
        l12.setFont(new Font("Poppins", Font.BOLD, 15));

        b1 = new JButton("Edit Student");
        b1.setFocusable(false);
        b1.addActionListener(this);

        b2 = new JButton("Back");
        b2.setFocusable(false);
        b2.addActionListener(this);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(13,2,10,10));
        p2.add(l13);
        p2.add(ch);
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

        ch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    try {
                        Connection_Class con1 = new Connection_Class();
                        int res = Integer.parseInt(ch.getSelectedItem());
                        String q = "SELECT * FROM student where roll_no=" + res + "";
                        ResultSet rest1 = con1.stm.executeQuery(q);
                        while (rest1.next()) {
                            tf1.setText(rest1.getString("name"));
                            tf2.setText(rest1.getString("email"));
                            tf3.setText(rest1.getString("course"));
                            tf4.setText(rest1.getString("fee"));
                            tf5.setText(rest1.getString("paid"));
                            tf6.setText(rest1.getString("due"));
                            tf7.setText(rest1.getString("address"));
                            tf8.setText(rest1.getString("city"));
                            tf9.setText(rest1.getString("state"));
                            tf10.setText(rest1.getString("country"));
                            tf11.setText(rest1.getString("contact"));
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
            }
        });

    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1) {

            int roll_no = Integer.parseInt(ch.getSelectedItem());
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

            try {
                Connection_Class con2 = new Connection_Class();
                String q = "UPDATE student SET name='" + name + "',email='" + email + "',course='" + course + "',fee='" + fee + "',paid='" + paid + "',due='" + due + "',address='" + add + "',city='" + city + "',state='" + state + "',country='" + country + "',contact='" + contact + "' WHERE roll_no='" + roll_no + "'";
                int a = con2.stm.executeUpdate(q);
                if (a == 1) {
                    JOptionPane.showMessageDialog(null, "Data was updated!");
                } else {
                    JOptionPane.showMessageDialog(null, "Data was not updated!");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }

        if(e.getSource() == b2){
            new AccountantSection();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EditStudent();
    }
}
