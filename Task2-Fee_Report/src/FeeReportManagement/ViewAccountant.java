package FeeReportManagement;

import javax.swing.*;
import java.sql.ResultSet;

public class ViewAccountant extends JFrame{

    String[] x = {"Name","Password","Email","Contact","Address"};
    String[][] y = new String[20][5];
    int i=0,j=0;
    JTable t1 ;

    ViewAccountant() {
        super("Accountant Information");
        setSize(1300,400);
        setLocation(1,1);

        try{
            Connection_Class con = new Connection_Class();
            String q = "SELECT * FROM accountant";
            ResultSet rest = con.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++] = rest.getString("name");
                y[i][j++] = rest.getString("password");
                y[i][j++] = rest.getString("email");
                y[i][j++] = rest.getString("contact");
                y[i][j++] = rest.getString("address");
                i++;
                j=0;
            }

            t1 = new JTable(y,x);

        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        setVisible(true);


    }
    public static void main(String[] args) {
        new ViewAccountant();
    }
}
