package cricketscoremanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {

    Project() {
        setSize(1540, 850);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/WhatsApp Image 2024-04-20 at 00.36.40_9b38b642.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        
       //player
        JMenu player = new JMenu("Player");
        player.setForeground(Color.BLUE);
        mb.add(player);
        
        JMenuItem updatePlayer = new JMenuItem("Insert Player Details");
        updatePlayer.setBackground(Color.WHITE);
        
        updatePlayer.addActionListener(this);
        player.add(updatePlayer);
        
        
        JMenuItem playerInfo = new JMenuItem("View Player Details");
        playerInfo.setBackground(Color.WHITE);
        playerInfo.addActionListener(this);
        player.add(playerInfo);
        
        //teams
        JMenu team = new JMenu("Team");
        team.setForeground(Color.RED);
        mb.add(team);
        
        JMenuItem updateTeam = new JMenuItem("Insert Team Details");
        updateTeam.setBackground(Color.WHITE);
        updateTeam.addActionListener(this);
        team.add(updateTeam);
        
        JMenuItem teamInfo = new JMenuItem("View Team Details");
        teamInfo.setBackground(Color.WHITE);
        teamInfo.addActionListener(this);
        team.add(teamInfo);
        
        //matches
        JMenu matches = new JMenu("Matches");
        player.setForeground(Color.BLUE);
        mb.add(matches);
        
        JMenuItem updateMatches = new JMenuItem("Insert Match Details");
        updateMatches.setBackground(Color.WHITE);
        updateMatches.addActionListener(this);
        matches.add(updateMatches);
        
        JMenuItem matchesInfo = new JMenuItem("View Match Details");
        matchesInfo.setBackground(Color.WHITE);
        matchesInfo.addActionListener(this);
        matches.add(matchesInfo);
        
        //score
        JMenu score = new JMenu("Score");
        score.setForeground(Color.RED);
        mb.add(score);
        
        JMenuItem updateScore = new JMenuItem("Insert Score Details");
        updateScore.setBackground(Color.WHITE);
        updateScore.addActionListener(this);
        score.add(updateScore);
        
        JMenuItem scoreInfo = new JMenuItem("View Score Details");
        scoreInfo.setBackground(Color.WHITE);
        scoreInfo.addActionListener(this);
        score.add(scoreInfo);
        
        //stadium
        JMenu stadium = new JMenu("Stadium");
        stadium.setForeground(Color.BLUE);
        mb.add(stadium);
        
        JMenuItem updateStadium = new JMenuItem("Insert Stadium Details");
        updateStadium.setBackground(Color.WHITE);
        updateStadium.addActionListener(this);
        stadium.add(updateStadium);
        
        JMenuItem stadiumInfo = new JMenuItem("View Stadium Details");
        stadiumInfo.setBackground(Color.WHITE);
        stadiumInfo.addActionListener(this);
        stadium.add(stadiumInfo);
        
        //update
        JMenu update = new JMenu("Update Details");
        update.setForeground(Color.RED);
        mb.add(update);
        
        JMenuItem updateP = new JMenuItem("Update Players Details");
        updateP.setBackground(Color.WHITE);
        updateP.addActionListener(this);
        update.add(updateP);
        
        JMenuItem updateT = new JMenuItem("Update Team Details");
        updateT.setBackground(Color.WHITE);
        updateT.addActionListener(this);
        update.add(updateT);
        
        JMenuItem updateSt = new JMenuItem("Update Stadium Details");
        updateSt.setBackground(Color.WHITE);
        updateSt.addActionListener(this);
        update.add(updateSt);
        
        JMenuItem updateM = new JMenuItem("Update Match Details");
        updateM.setBackground(Color.WHITE);
        updateM.addActionListener(this);
        update.add(updateM);
        
        JMenuItem updateS = new JMenuItem("Update Score Details");
        updateS.setBackground(Color.WHITE);
        updateS.addActionListener(this);
        update.add(updateS);
   
        // exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLUE);
        mb.add(exit);
        
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);
        
        setJMenuBar(mb);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        
        if (msg.equals("Exit")) {
            setVisible(false);
        }
        else if (msg.equals("Insert Player Details")){
            new AddPlayers();
        } else if (msg.equals("View Player Details")){
            new PlayerDetails();
    }else if (msg.equals("Insert Team Details")){
            new AddTeam();
    }else if (msg.equals("View Team Details")){
            new TeamDetails();
    }else if (msg.equals("Insert Stadium Details")){
            new AddStadium();
    }
        else if (msg.equals("View Stadium Details")){
            new StadiumDetails();
        }else if (msg.equals("Insert Match Details")){
            new AddMatches();
        }else if (msg.equals("View Match Details")){
            new MatchesDetails();
        }else if (msg.equals("Insert Score Details")){
            new AddScore();
        }else if (msg.equals("View Score Details")){
            new ScoreDetails();
        }else if (msg.equals("Update Players Details")){
            new UpdatePlayer();
        }else if (msg.equals("Update Team Details")){
            new UpdateTeam();
        }else if (msg.equals("Update Match Details")){
            new UpdateMatches();
        }else if (msg.equals("Update Stadium Details")){
            new UpdateStadium();
        }else if (msg.equals("Update Score Details")){
            new UpdateScore();
        }
    }
    public static void main(String[] args) {
        new Project();
    }
}

