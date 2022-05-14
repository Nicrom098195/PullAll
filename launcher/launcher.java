import java.awt.event.*;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class launcher implements ActionListener{
 
 JFrame frame = new JFrame();
 String versions[] = { "Alpha 1", "Alpha 2", "Alpha 3", "Alpha 4", "Official 1.0.0", "Official 1.0.1" };
 JComboBox version = new JComboBox<>(versions);
 JButton play = new JButton("Play");
 String playversion = "alpha1";
 Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
 launcher(){

    version.setBounds(95,400,150,40);
    version.setFocusable(true);
    version.addActionListener(this);
    version.setBackground(new Color(43, 50, 68));
    version.setForeground(new Color(185, 229, 250));
    version.setCursor(cursor);
    
    frame.add(version);

    play.setBounds(350,400,200,40);
    play.setFocusable(true);
    play.addActionListener(this);
    play.setBackground(new Color(7, 38, 0));
    play.setForeground(new Color(185, 229, 250));
    play.setCursor(cursor);
    
    frame.add(play);

	JLabel logo = new JLabel(new ImageIcon("/opt/PullAll/pullall.png"));
	logo.setBounds(0,0,900,700);

	frame.add(logo);
  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setLayout(null);
  frame.setVisible(true);
  frame.setResizable(false);
  frame.setTitle("PullAll launcher");
  frame.setSize(900,700);
  frame.setLocationRelativeTo(null);
  
 }

 @Override
 public void actionPerformed(ActionEvent e) {
  
    if(e.getSource()==play) {
        frame.dispose();
        try {
            System.out.println("Plauncher: running version: " + playversion);
            Process process = Runtime.getRuntime().exec("plauncher "+playversion);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    if (e.getSource() == version) {
        if (version.getSelectedItem() == "Alpha 1"){
            playversion = "alpha1";
        } else if (version.getSelectedItem() == "Alpha 2"){
            playversion = "alpha2";
        } else if (version.getSelectedItem() == "Alpha 3"){
            playversion = "alpha3";
        } else if (version.getSelectedItem() == "Alpha 4"){
            playversion = "alpha4";
        } else if (version.getSelectedItem() == "Official 1.0.0"){
            playversion = "official100";
        } else if (version.getSelectedItem() == "Official 1.0.1"){
            playversion = "official101";
        } 
    }
}
}
