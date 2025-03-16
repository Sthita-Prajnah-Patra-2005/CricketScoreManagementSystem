
package cricketscoremanagement;
import java.sql.*;
public class conn {
    
    Connection c;
    Statement s;
    
    conn (){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cricketmanagementsystem","root", "2201020598");
            s = c.createStatement();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
