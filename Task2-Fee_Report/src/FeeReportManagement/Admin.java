package FeeReportManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.sql.ResultSet;

public class Admin extends JFrame implements ActionListener {

    JLabel l1,l2,l3;
    JButton b1,b2;
    JTextField tf;
    JPasswordField pf;
    JPanel p1,p2;
    Font f = new Font("Arial",Font.BOLD,20);

    Admin(){
        super("Admin Login Page");
        setLocation(100,100);
        setSize(400,200);

        l1 = new JLabel("Admin Login");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f);

        l2 = new JLabel("Name");

        l3 = new JLabel("Password");

        b1 = new JButton("Login");
        b1.addActionListener(this);

        b2 = new JButton("Cancel");
        b2.addActionListener(this);

        tf= new JTextField();

        pf = new JPasswordField();

        p1 = new JPanel();
        p1.add(l1);
        p1.setLayout(new GridLayout(1,1,10,10));

        p2 = new JPanel();
        p2.add(l2);
        p2.add(tf);
        p2.add(l3);
        p2.add(pf);
        p2.add(b1);
        p2.add(b2);
        p2.setLayout(new GridLayout(3,2,10,10));

        this.setLayout(new BorderLayout(0,0));
        this.add(p1, "North");
        this.add(p2, "Center");
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = tf.getText();
        String pass = pf.getText();

        if (e.getSource() == b1){
            try{
                Connection_Class con = new Connection_Class();
                String q = "SELECT * FROM admin WHERE username='"+name+"' AND password='"+pass+"'";
                ResultSet rest = con.stm.executeQuery(q);
                if(rest.next()){
                    new AdminSection();
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Your credentials are wrong !");
                    this.setVisible(true);
                }

            }catch(Exception e1){
                e1.printStackTrace();
            }
        }

        if(e.getSource() == b2){
            this.setVisible(false);
            new index().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Admin();
    }
}
