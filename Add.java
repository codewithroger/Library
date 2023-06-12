package Lib;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Add extends JFrame implements ActionListener{
    JButton Add,back;
    JLabel header,callID,name,Auth,publ,Qua,qual;
    JTextField tf,tf1,tf2,tf3,tf4,tf5;
    String url = "jdbc:MySQL://localhost:3306/library";         //db is the name of the database
		String user ="root";                                                  
		String password = "yogesh$2004";
        ResultSet rs;
          Connection myConn;
          Statement myStmt;
    Add()
    { 
        setSize(500, 500);
        setLayout(null);
        setLocation(50, 50);
        setBackground(Color.GRAY);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        header = new JLabel("Add Book");
        header.setBounds(180, 30, 120, 30);
        header.setFont(new Font("SansSerif", Font.BOLD, 16));
        add(header);
       
        name = new JLabel("Book Name *");
        name.setBounds(50, 100, 70, 20);
        name.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(name);
         tf1 = new JTextField(30);
        tf1.setBounds(160, 100, 150, 20);
        add(tf1); 
         Auth = new JLabel(" Book ID *");
       Auth.setBounds(50, 140, 70, 20);
        Auth.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(Auth);
         tf2 = new JTextField(30);
        tf2.setBounds(160, 140, 150, 20);
        add(tf2); 
         
         publ = new JLabel("Author *");
       publ.setBounds(50, 180, 70, 20);
        publ.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(publ);
         tf3 = new JTextField(30);
        tf3.setBounds(160, 180, 150, 20);
        add(tf3); 
         Qua = new JLabel("Publisher *");
       Qua.setBounds(50, 220, 90, 20);
        Qua.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(Qua);
        tf4 = new JTextField(30);
        tf4.setBounds(160, 220, 150, 20);
        add(tf4);
        qual= new JLabel("Quantity *");
       qual.setBounds(50, 260, 90, 20);
        qual.setFont(new Font("SansSerif", Font.BOLD, 14));
        add(qual); 
          tf5 = new JTextField(30);
        tf5.setBounds(160, 260, 150, 20);
        add(tf5);

        Add = new JButton("Add Book");
        Add.setBounds(30, 350, 90, 20);
        Add.addActionListener(this);
        add(Add);
         back = new JButton("Back");
        back.setBounds(300, 350, 90, 20);
        back.addActionListener(this);
        add(back);
       
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == Add) {
        try {
            myConn = DriverManager.getConnection(url, user, password);
            myStmt = myConn.createStatement();

            String sql = "INSERT INTO addbook (BookID, Book_Name, Author, Publisher, Quantity) "
                    + "VALUES ('" + tf2.getText() + "','" + tf1.getText() + "','" + tf3.getText() + "','"
                    + tf4.getText() + "','" + tf5.getText() + "')";
            myStmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Insert complete.");

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
        new Add();
    }
}
