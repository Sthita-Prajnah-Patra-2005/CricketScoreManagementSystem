
package cricketscoremanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateTeam extends JFrame implements ActionListener {

    JTextField tftname;
   
    JButton submit, cancel;
    Choice cteamid;

    UpdateTeam() {

        setSize(900, 450);
        setLocation(350, 50);
        setLayout(null);

        JLabel heading = new JLabel("Update team Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 35));
        add(heading);

        JLabel lblNo = new JLabel("Select Team ID");
        lblNo.setBounds(50, 100, 200, 20);
        lblNo.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblNo);

        cteamid = new Choice();
        cteamid.setBounds(250, 100, 200, 20);
        add(cteamid);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from team");
            while(rs.next()) {
                cteamid.add(rs.getString("teamid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblName = new JLabel("Team Name");
        lblName.setBounds(50, 150, 150, 30);
        lblName.setFont(new Font("serif", Font.BOLD, 20));
        add(lblName);

        tftname = new JTextField();
        tftname.setBounds(200, 150, 150, 30);
        tftname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(tftname);

        
        cteamid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    conn c = new conn();
                    String query = "select * from team where teamid='" + cteamid.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
                        tftname.setText(rs.getString("name"));
                    }
                  
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        submit = new JButton("Update");
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

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String teamID = cteamid.getSelectedItem();
            String teamName = tftname.getText();

            try {
                conn con = new conn();
                String query = "update team set name='" + teamName + "' where teamid='" + teamID + "'";
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Team Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateTeam();
    }
}
