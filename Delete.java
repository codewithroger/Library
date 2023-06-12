package Lib;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Delete extends JFrame implements ActionListener{
     JButton Add,back;
    JLabel header,callID,callIDs;
     JTextField tf,tf1;
     
    String url = "jdbc:MySQL://localhost:3306/library";         //db is the name of the database
		String user ="root";                                                  
		String password = "yoges*****04";
        ResultSet rs;
          Connection myConn;
          Statement myStmt;
    Delete()
    {
         setSize(500, 500);
        setLayout(null);
        setLocation(50, 50);
        setBackground(Color.GRAY);
        setVisible(true);
         header = new JLabel("Return Book");
        header.setBounds(180, 30, 120, 30);
        header.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(header);
        callID = new JLabel("Book ID *");
        callID.setBounds(70, 170, 70, 20);
        callID.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(callID); 
         tf = new JTextField(30);
        tf.setBounds(160, 170, 150, 20);
        add(tf);
          callIDs = new JLabel("Library ID *");
        callIDs.setBounds(70, 100, 90, 20);
        callIDs.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(callIDs);
        tf1= new JTextField(30);
        tf1.setBounds(160, 100, 150, 20);
        add(tf1);
         Add = new JButton("Return Book");
        Add.setBounds(40, 300, 120, 20);
        Add.addActionListener(this);
        add(Add);
         back = new JButton("Back");
        back.setBounds(300, 300, 90, 20);
        back.addActionListener(this);
        add(back);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == Add) {
        try {
            myConn = DriverManager.getConnection(url, user, password);
            myStmt = myConn.createStatement();

            String sql  = "DELETE FROM issuebook WHERE library_id = '" + tf1.getText() + "'";
 ;
                   
            myStmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Your Book  "+tf1.getText()+"  is Return");

            myConn.close();
            new NewPage();
            setVisible(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } else if (ae.getSource() == back) {
        new NewPage();
    }
       
    }
    public static void main(String[] args) {
        new Delete();
    }
}
