
package cricketscoremanagement;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.Date;

public class AddMatches extends JFrame implements ActionListener {

    JTextField tfmatchid, tfstadium_id, tfteam1id, tfteam2id;
    JDateChooser dcdate;
    JButton submit, cancel;

    AddMatches() {

        setSize(900, 700);
        setLocation(250, 50);

        setLayout(null);

        JLabel heading = new JLabel("Insert Match Details");
        heading.setBounds(200, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        // Match id
        JLabel lblid = new JLabel("Match ID");
        lblid.setBounds(50, 150, 150, 30);
        lblid.setFont(new Font("serif", Font.BOLD, 20));
        add(lblid);

        tfmatchid = new JTextField();
        tfmatchid.setBounds(200, 150, 150, 30);
        add(tfmatchid);

        // stadium id
        JLabel lblsid = new JLabel("Stadium ID");
        lblsid.setBounds(50, 250, 100, 30);
        lblsid.setFont(new Font("serif", Font.BOLD, 20));
        add(lblsid);

        tfstadium_id = new JTextField();
        tfstadium_id.setBounds(200, 250, 200, 30);
        add(tfstadium_id);

        // dob
        JLabel lbldate = new JLabel("Date of the Match");
        lbldate.setBounds(430, 150, 300, 30);
        lbldate.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(650, 150, 200, 30);
        add(dcdate);

        // team id of player
        JLabel lblteam1id = new JLabel("Team-1 ID ");
        lblteam1id.setBounds(430, 250, 300, 30);
        lblteam1id.setFont(new Font("serif", Font.BOLD, 20));
        add(lblteam1id);

        tfteam1id = new JTextField();
        tfteam1id.setBounds(650, 250, 200, 30);
        add(tfteam1id);

        // team 2 id of player
        JLabel lblteam2id = new JLabel("Team-2 ID ");
        lblteam2id.setBounds(50, 350, 200, 30);
        lblteam2id.setFont(new Font("serif", Font.BOLD, 20));
        add(lblteam2id);

        tfteam2id = new JTextField();
        tfteam2id.setBounds(200, 350, 200, 30);
        add(tfteam2id);

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

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {

            String matchid = tfmatchid.getText();
            String stadium_id = tfstadium_id.getText();
            Date matchdate = dcdate.getDate();
            String team1_id = tfteam1id.getText();
            String team2_id = tfteam2id.getText();

            try {
                String query = "insert into matches1 values('" + matchid + "','" + stadium_id + "','" + matchdate + "','" + team1_id + "','" + team2_id + "')";
                conn con = new conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Match Details Inserted Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddMatches();
    }
}
