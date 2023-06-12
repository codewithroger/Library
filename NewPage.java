package Lib;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class NewPage extends JFrame implements ActionListener {
    JButton add,issue,view,delete,logout;
    NewPage()
    {
        setSize(500, 500);
        setLayout(null);
        setLocation(50, 50);
        setBackground(Color.GRAY);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        add = new JButton("Add Book");
        add.setBounds(180, 80, 120,30);
        add.addActionListener(this);
        add(add);
         issue= new JButton("Issue Book");
        issue.setBounds(180, 150, 120,30);
        issue.addActionListener(this);
        add(issue);
         
        delete = new JButton("Return Book");
        delete.setBounds(180, 220, 120,30);
        delete.addActionListener(this);
        add(delete);
         logout = new JButton("Logout");
        logout.setBounds(180, 290, 120,30);
        logout.addActionListener(this);
        add(logout);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==add)
        {
            new Add();
            setVisible(false);
        }
        
        else if(e.getSource()==issue)
        {
            new Issuse();
            setVisible(false);
        }
        else if(e.getSource()==delete)
        {
            new Delete();
            setVisible(false);
        }
        else if(e.getSource()== logout)
        {
            new Logout();
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new NewPage();
    }
}
