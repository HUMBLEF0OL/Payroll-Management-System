import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
*
* @author HUMBLEFOOL
*/
public class List_Employee extends JFrame implements ActionListener{
  
    JTable j1;
    JButton b1;
    // h array for heading of columns
    String h[]={"Emp id","Name","Gender","Address","State","City","Email id","Phone"};
    // d for data
    String d[][]=new String[20][8];   
    int i=0,j=0;
    
    List_Employee(){
        super("View Employees");
        
        setSize(1000,400);
        setLocation(200,200);

        try{
            String q="select * from employee";
            conn c1=new conn();
            // Retrieving the data from database and storing in a resultSet
            ResultSet rs=c1.s.executeQuery(q);
            // storing the data into 2-D array
            while(rs.next()){
                // i = 0 j = 0
                d[i][j++]=rs.getString("id");
                d[i][j++]=rs.getString("name");
                d[i][j++]=rs.getString("gender");
                d[i][j++]=rs.getString("address");
                d[i][j++]=rs.getString("state");
                d[i][j++]=rs.getString("city");
                d[i][j++]=rs.getString("email");
                d[i][j++]=rs.getString("phone");
                i++;
                // resetting the column
                j=0;
            }
            // jTable require a 2-D array that holds the data
            // and a 1-D array for the labels of the table 
            // jtable = new Jtable(2-D,1-D);
            j1=new JTable(d,h); 

        }
        catch(Exception e){}
        
        b1=new JButton("Print");
        add(b1,"South");
        // adding scroll bar
        JScrollPane s1=new JScrollPane(j1);
        add(s1);
        // adding the print action on the button
        b1.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
           j1.print();
        }catch(Exception e){}
    }
     
    public static void main(String s[]){
        new List_Employee().setVisible(true);
    }
}

