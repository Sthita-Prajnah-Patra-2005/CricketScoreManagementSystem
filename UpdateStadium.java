

package cricketscoremanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStadium extends JFrame implements ActionListener {

    JTextField tfstadiumname, tflocation, tfcapacity;
    JButton submit, cancel;
    Choice cstadium_id;

    UpdateStadium() {

        setSize(900, 450);
        setLocation(350, 50);
        setLayout(null);

        JLabel heading = new JLabel("Update Stadium Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 35));
        add(heading);

        JLabel lblid = new JLabel("Select stadium_id");
        lblid.setBounds(50, 100, 200, 20);
        lblid.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblid);

        cstadium_id = new Choice();
        cstadium_id.setBounds(250, 100, 200, 20);
        add(cstadium_id);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from stadium");
            while(rs.next()) {
                cstadium_id.add(rs.getString("stadium_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblname = new JLabel("Stadium Name");
        lblname.setBounds(50, 150, 150, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        tfstadiumname = new JTextField();
        tfstadiumname.setBounds(200, 150, 150, 30);
        tfstadiumname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(tfstadiumname);
        
        JLabel lblloc = new JLabel("Location");
        lblloc.setBounds(450, 150, 150, 30);
        lblloc.setFont(new Font("serif", Font.BOLD, 20));
        add(lblloc);

        tflocation = new JTextField();
        tflocation.setBounds(600, 150, 150, 30);
        tflocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(tflocation);
        
        JLabel lblcap = new JLabel("Capacity");
        lblcap.setBounds(50, 250, 150, 30);
        lblcap.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcap);

        tfcapacity = new JTextField();
        tfcapacity.setBounds(200, 250, 150, 30);
        tfcapacity.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(tfcapacity);
        
      
        
        cstadium_id.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    conn c = new conn();
                    String query = "select * from stadium where stadium_id='" + cstadium_id.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
                        tfstadiumname.setText(rs.getString("stadium_id"));
                        tflocation.setText(rs.getString("stadium_location"));
                        tfcapacity.setText(rs.getString("capacity"));
                       
                       
                    }
                  
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        submit = new JButton("Update");
        submit.setBounds(250, 350, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 350, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String stadium_id = cstadium_id.getSelectedItem();
            String stadium_name = tfstadiumname.getText();
            String stadium_location = tflocation.getText();
            String capacity = tfcapacity.getText();
       

            try {
                conn con = new conn();
                String query = "update stadium set stadium_name='" + stadium_name + "', stadium_location='" + stadium_location +"',capacity='" + capacity+ "' where stadium_id='" + stadium_id + "'";
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Stadium Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateStadium();
    }
}
