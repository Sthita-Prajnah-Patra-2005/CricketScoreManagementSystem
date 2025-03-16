
package cricketscoremanagement;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddStadium extends JFrame implements ActionListener{
    
    
    
    JTextField tfstadium_id,tfstadiumname, tflocation, tfcapacity;
    JButton submit, cancel;
    
	AddStadium() {
		
	
	setSize(900,700);
	setLocation(250, 50);
	
	setLayout(null);
	
	JLabel heading = new JLabel("Insert Stadium Details");
	heading.setBounds(300, 30, 500, 50);
	heading.setFont(new Font("serif",Font.BOLD, 30));
	add(heading);
        
        //stadium id
        JLabel lblsid = new JLabel("Stadium ID");
	lblsid.setBounds(50, 150, 150, 30);
	lblsid.setFont(new Font("serif",Font.BOLD, 20));
	add(lblsid);
	
        tfstadium_id = new JTextField();
        tfstadium_id.setBounds(200, 150, 150, 30);
        add(tfstadium_id);
        
        //stadium name
        JLabel lblsname = new JLabel("Stadium Name");
	lblsname.setBounds(50, 250, 150, 30);
	lblsname.setFont(new Font("serif",Font.BOLD, 20));
	add(lblsname);
	
        tfstadiumname = new JTextField();
        tfstadiumname.setBounds(200, 250, 200, 30);
        add(tfstadiumname);
       
     
        //location
        JLabel lbllocation = new JLabel("Location of the Stadium ");
	lbllocation.setBounds(430, 150, 300, 30);
	lbllocation.setFont(new Font("serif",Font.BOLD, 20));
	add(lbllocation);
	
        tflocation = new JTextField();
        tflocation.setBounds(650, 150, 200, 30);
        add(tflocation);
        
        //capacity
        JLabel lblcapacity = new JLabel("Capacity of the Stadium ");
	lblcapacity.setBounds(430, 250, 300, 30);
	lblcapacity.setFont(new Font("serif",Font.BOLD, 20));
	add(lblcapacity);
	
        tfcapacity = new JTextField();
        tfcapacity.setBounds(650, 250, 200, 30);
        add(tfcapacity);
        
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
               
                String stadium_id = tfstadium_id.getText();
                String stadiumname = tfstadiumname.getText();
                String location = tflocation.getText();
                String capacity = tfcapacity.getText();
                
                try{
                    String query = "insert into stadium values('"+stadium_id+"','"+stadiumname+"','"+location+"','"+capacity+"')";
                    conn con = new conn();
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Stadium Details Inserted Successfully");
                    setVisible(false);
                    
                }catch(Exception e){
                    e.printStackTrace();
                }

            }else {
                setVisible(false);
            }
        }
public static void main(String[]args) {
	new AddStadium();
}
   }
