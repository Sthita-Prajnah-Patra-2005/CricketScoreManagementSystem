
package cricketscoremanagement;


import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class AddTeam extends JFrame implements ActionListener{
    
    
    JTextField tfteamid, tftname; 
   
    JButton submit, cancel;
    
 
	AddTeam() {
		
	
	setSize(900,400);
	setLocation(250, 50);
	
	setLayout(null);
	
	JLabel heading = new JLabel("Insert Team Details");
	heading.setBounds(200, 30, 500, 50);
	heading.setFont(new Font("serif",Font.BOLD, 30));
	add(heading);
       
        
        //player name
        JLabel lblname = new JLabel("Team Name");
	lblname.setBounds(470, 150, 200, 30);
	lblname.setFont(new Font("serif",Font.BOLD, 20));
	add(lblname);
	
        tftname = new JTextField();
        tftname.setBounds(650, 150, 200, 30);
        add(tftname);
        
         
        //player id
        JLabel lblteamid = new JLabel("Team ID");
	lblteamid.setBounds(50, 150, 150, 30);
	lblteamid.setFont(new Font("serif",Font.BOLD, 20));
	add(lblteamid);
	
        tfteamid = new JTextField();
        tfteamid.setBounds(200, 150, 150, 30);
        add(tfteamid);
        
        submit = new JButton("Submit");
        submit.setBounds(250, 300, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 300, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
	setVisible(true);
	}
        
        public void actionPerformed(ActionEvent ae){
            if (ae.getSource() == submit){
                String name = tftname.getText();
               
                String teamID = tfteamid.getText();
                
                try{
                    String query = "insert into team values('"+name+"','"+teamID+"')";
                    conn con = new conn();
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Team Details Inserted Successfully");
                    setVisible(false);
                    
                }catch(Exception e){
                    e.printStackTrace();
                }

            }else {
                setVisible(false);
            }
        }
public static void main(String[]args) {
	new AddTeam();
}
   }
