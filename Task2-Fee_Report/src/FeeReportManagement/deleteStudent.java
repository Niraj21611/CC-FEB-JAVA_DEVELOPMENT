package FeeReportManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class deleteStudent extends JFrame implements ActionListener {

    JLabel l1;
    JTextField tf;
    JPanel p1,p2;
    JButton b1,b2;

    deleteStudent(){
        super("Delete Student");
        setLocation(100,100);
        setSize(350,300);

        l1 = new JLabel("Enter roll no. to delete: ");
        l1.setHorizontalAlignment(JLabel.CENTER);

        tf = new JTextField();
        tf.setPreferredSize(new Dimension(300,50));

        b1 = new JButton("Enter");
        b1.setFocusable(false);
        b1.addActionListener(this);

        b2 = new JButton("Back");
        b2.setFocusable(false);
        b2.addActionListener(this);

        p1 = new JPanel();
        p1.setPreferredSize(new Dimension(60,60));


        p2 = new JPanel();
        p2.setPreferredSize(new Dimension(100,100));
        p2.add(l1);
        p2.add(tf);
        p2.add(b1);
        p2.add(b2);

        setResizable(false);
        setLocationRelativeTo(null);
        add(p1,"North");
        add(p2, "Center");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            int res = Integer.parseInt(tf.getText());
            try{
                Connection_Class con = new Connection_Class();
                String q = "DELETE FROM student WHERE roll_no="+res+"";
                int a = con.stm.executeUpdate(q);
                   if(a == 1){
                       JOptionPane.showMessageDialog(null,"Successfully Deleted!");
                   }else{
                       JOptionPane.showMessageDialog(null,"Your credentials are wrong!");
                   }
                new AccountantSection();
                this.setVisible(false);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        if(e.getSource() == b2){
            new AccountantSection();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new deleteStudent();
    }
}
