
package cricketscoremanagement;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddPlayers extends JFrame implements ActionListener{
    
    Random ran = new Random();
    long first3 = Math.abs((ran.nextLong() % 900L)+ 100L);
    
    JTextField tfid, tfname, tfaddress, tfphone,tfsalary,tfrole ,tfteamid;
    JLabel labelno;
    JDateChooser dcdob, dcjoining;
    JButton submit, cancel;
    
 
	AddPlayers() {
		
	
	setSize(900,700);
	setLocation(250, 50);
	
	setLayout(null);
	
	JLabel heading = new JLabel("Insert Player Details");
	heading.setBounds(200, 30, 500, 50);
	heading.setFont(new Font("serif",Font.BOLD, 30));
	add(heading);
        
        //player id
        JLabel lblid = new JLabel("Jersey Number");
	lblid.setBounds(50, 150, 150, 30);
	lblid.setFont(new Font("serif",Font.BOLD, 20));
	add(lblid);
	
        tfid = new JTextField();
        tfid.setBounds(200, 150, 150, 30);
        add(tfid);
        
        //player name
        JLabel lblname = new JLabel("Name");
	lblname.setBounds(470, 150, 100, 30);
	lblname.setFont(new Font("serif",Font.BOLD, 20));
	add(lblname);
	
        tfname = new JTextField();
        tfname.setBounds(650, 150, 200, 30);
        add(tfname);
        
        //cap num
        JLabel lblno = new JLabel("Cap number");
	lblno.setBounds(50, 300, 150, 30);
	lblno.setFont(new Font("serif",Font.BOLD, 20));
	add(lblno);
        labelno = new JLabel(""+first3);
	labelno.setBounds(200, 300, 100, 30);
	labelno.setFont(new Font("serif",Font.BOLD, 20));
	add(labelno);
        
        //dob
        JLabel lbldob = new JLabel("Date of Birth");
	lbldob.setBounds(50, 200, 150, 30);
	lbldob.setFont(new Font("serif",Font.BOLD, 20));
	add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 200, 30);
        add(dcdob);
        
        //address
        
        JLabel lbladdress = new JLabel("State");
	lbladdress.setBounds(50, 250, 200, 30);
	lbladdress.setFont(new Font("serif",Font.BOLD, 20));
	add(lbladdress);
	
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 200, 30);
        add(tfaddress);
        
        //phone number
        
        JLabel lblphone = new JLabel("Phone Number");
	lblphone.setBounds(470, 250, 200, 30);
	lblphone.setFont(new Font("serif",Font.BOLD, 20));
	add(lblphone);
	
        tfphone = new JTextField();
        tfphone.setBounds(650, 250, 200, 30);
        add(tfphone);
        
        
        //joining date
        
        JLabel lbljoining = new JLabel("Joining Date");
	lbljoining.setBounds(50, 400, 150, 30);
	lbljoining.setFont(new Font("serif",Font.BOLD, 20));
	add(lbljoining);
        
        dcjoining = new JDateChooser();
        dcjoining.setBounds(200, 400, 200, 30);
        add(dcjoining);
        
        //salary
        JLabel lblsalary = new JLabel("Player Salary");
	lblsalary.setBounds(470, 300, 200, 30);
	lblsalary.setFont(new Font("serif",Font.BOLD, 20));
	add(lblsalary);
	
        tfsalary = new JTextField();
        tfsalary.setBounds(650, 300, 200, 30);
        add(tfsalary);
        
        //role/type of player
        JLabel lblrole = new JLabel("Role of Player");
	lblrole.setBounds(470, 400, 200, 30);
	lblrole.setFont(new Font("serif",Font.BOLD, 20));
	add(lblrole);
	
        tfrole = new JTextField();
        tfrole.setBounds(650, 400, 200, 30);
        add(tfrole);
        
        //team id of player
        JLabel lblteamid = new JLabel("Team ID of Player");
	lblteamid.setBounds(470, 200, 200, 30);
	lblteamid.setFont(new Font("serif",Font.BOLD, 20));
	add(lblteamid);
	
        tfteamid = new JTextField();
        tfteamid.setBounds(650, 200, 200, 30);
        add(tfteamid);
        
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
	setVisible(true);
	}
        
        public void actionPerformed(ActionEvent ae){
            if (ae.getSource() == submit){
                
                String id = tfid.getText();
                String name = tfname.getText();
                String rollno = labelno.getText();
                String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
                String joining = ((JTextField) dcjoining.getDateEditor().getUiComponent()).getText();
                String address = tfaddress.getText();
                String phone = tfphone.getText();
                String salary = tfsalary.getText();
                String role = tfrole.getText();
                String teamid = tfteamid.getText();
                
                try{
                    String query = "insert into player values('"+id+"','"+name+"','"+rollno+"','"+dob+"','"+joining+"','"+address+"','"+phone+"','"+salary+"','"+role+"','"+teamid+"')";
                    conn con = new conn();
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Strudent Details Inserted Successfully");
                    setVisible(false);
                    
                }catch(Exception e){
                    e.printStackTrace();
                }

            }else {
                setVisible(false);
            }
        }
public static void main(String[]args) {
	new AddPlayers();
}
   }
