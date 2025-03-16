

package cricketscoremanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateMatches extends JFrame implements ActionListener {

    JTextField tfstadium_id, tfteam1id, tfteam2id,dcdate;
   
    JButton submit, cancel;
    Choice cmatchid;

    UpdateMatches() {

        setSize(900, 450);
        setLocation(350, 50);
        setLayout(null);

        JLabel heading = new JLabel("Update Matches Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma", Font.ITALIC, 35));
        add(heading);

        JLabel lblNo = new JLabel("Select Match ID");
        lblNo.setBounds(50, 100, 200, 20);
        lblNo.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblNo);

        cmatchid = new Choice();
        cmatchid.setBounds(250, 100, 200, 20);
        add(cmatchid);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from matches1");
            while(rs.next()) {
                cmatchid.add(rs.getString("matchid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblid = new JLabel("Stadium ID");
        lblid.setBounds(50, 150, 150, 30);
        lblid.setFont(new Font("serif", Font.BOLD, 20));
        add(lblid);

        tfstadium_id = new JTextField();
        tfstadium_id.setBounds(200, 150, 150, 30);
        tfstadium_id.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(tfstadium_id);
        
        JLabel lbl1id = new JLabel("Team1 ID");
        lbl1id.setBounds(450, 150, 150, 30);
        lbl1id.setFont(new Font("serif", Font.BOLD, 20));
        add(lbl1id);

        tfteam1id = new JTextField();
        tfteam1id.setBounds(600, 150, 150, 30);
        tfteam1id.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(tfteam1id);
        
        JLabel lbl2id = new JLabel("Team2 ID");
        lbl2id.setBounds(450, 250, 150, 30);
        lbl2id.setFont(new Font("serif", Font.BOLD, 20));
        add(lbl2id);

        tfteam2id = new JTextField();
        tfteam2id.setBounds(600, 250, 150, 30);
        tfteam2id.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(tfteam2id);
        
        JLabel lbldate = new JLabel("Match date");
        lbldate.setBounds(50, 250, 200, 30);
        lbldate.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldate);

        dcdate = new JTextField();
        dcdate.setBounds(200, 250, 150, 30);
        dcdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(dcdate);

        
        cmatchid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    conn c = new conn();
                    String query = "select * from matches1 where matchid='" + cmatchid.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
                        tfstadium_id.setText(rs.getString("Stadium ID"));
                        tfteam1id.setText(rs.getString("Team 1 ID"));
                        tfteam2id.setText(rs.getString("Team 2 ID"));
                        dcdate.setText(rs.getString("Match date"));
                       
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
            String matchid = cmatchid.getSelectedItem();
            String stadium_id = tfstadium_id.getText();
            String team1_id = tfteam1id.getText();
            String team2_id = tfteam2id.getText();
            String matchdate = dcdate.getText();

            try {
                conn con = new conn();
                String query = "update matches1 set stadium_id='" + stadium_id + "', team1_id='" + team1_id +"',team2_id='" + team2_id+ "',matchdate='"+matchdate+ "' where matchid='" + matchid + "'";
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Match Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateMatches();
    }
}
