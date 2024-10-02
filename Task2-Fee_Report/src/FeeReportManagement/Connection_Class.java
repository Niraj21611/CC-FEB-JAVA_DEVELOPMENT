package FeeReportManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connection_Class {
    Connection con;
    Statement stm;
    Connection_Class(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fee_report","root", "xyz");
            stm = con.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Connection_Class();
    }
}
