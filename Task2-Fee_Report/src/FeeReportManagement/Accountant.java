package FeeReportManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Accountant extends JFrame implements ActionListener {

    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf1;
    JButton b1,b2;
    JPanel p1,p2;
    Font f = new Font("Arial",Font.BOLD,20);

    Accountant(){
        super("Accountant Page");
        setLocation(100,100);
        setSize(400,200);

        l1 = new JLabel("Accountant Login");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f);

        l2 = new JLabel("Name");

        l3 = new JLabel("Password");

        tf1 = new JTextField();

        pf1 = new JPasswordField();

        b1 = new JButton("Login");
        b1.addActionListener(this);
        b1.setFocusable(false);

        b2 = new JButton("Cancel");
        b2.addActionListener(this);
        b2.setFocusable(false);

        p1 = new JPanel();
        p1.add(l1);
        p1.setLayout(new GridLayout(1,1,10,10));

        p2 = new JPanel();
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(pf1);
        p2.add(b1);
        p2.add(b2);
        p2.setLayout(new GridLayout(3,2,10,10));

        this.setLayout(new BorderLayout(0,0));
        this.add(p1,"North");
        this.add(p2,"Center");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
            String name = tf1.getText();
            String pass = pf1.getText();

        if(e.getSource() == b1){
            try {
                Connection_Class con = new Connection_Class();
                String q = "SELECT * FROM accountant WHERE name='" + name + "' AND password='" + pass + "'";
                ResultSet rest = con.stm.executeQuery(q);
                if(rest.next()){
                    new AccountantSection();
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"You're Not Registered!");

                }
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }

        if(e.getSource() == b2){
            new index();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Accountant();
    }
}
