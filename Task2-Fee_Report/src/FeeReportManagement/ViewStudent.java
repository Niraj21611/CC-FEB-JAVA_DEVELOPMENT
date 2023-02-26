package FeeReportManagement;

import javax.swing.*;
import java.sql.ResultSet;

public class ViewStudent extends JFrame{

        String[] x = {"Roll No","Name","Email","Course","Fee","Paid","Due","Address","City","State","Country","Contact"};
        String[][] y = new String[20][12];
        int i=0,j=0;
        JTable t;

    ViewStudent(){
        super("Student Information");
        setSize(1300,400);
        setLocation(1,1);

        try{
            Connection_Class con = new Connection_Class();
            String q = "SELECT * FROM student";
            ResultSet rest = con.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++] = rest.getString("roll_no");
                y[i][j++] = rest.getString("name");
                y[i][j++] = rest.getString("email");
                y[i][j++] = rest.getString("course");
                y[i][j++] = rest.getString("fee");
                y[i][j++] = rest.getString("paid");
                y[i][j++] = rest.getString("due");
                y[i][j++] = rest.getString("address");
                y[i][j++] = rest.getString("city");
                y[i][j++] = rest.getString("state");
                y[i][j++] = rest.getString("country");
                y[i][j++] = rest.getString("contact");
                i++;
                j=0;
            }

            t = new JTable(y,x);

        }catch (Exception ee){
            ee.printStackTrace();
        }
        JScrollPane sp= new JScrollPane(t);
        add(sp);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ViewStudent();
    }
}
