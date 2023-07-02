package Lib;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ViewBook extends JFrame implements ActionListener   {
    JButton add,issue,view,delete,logout;
    ViewBook()
    {
        
        setSize(500, 500);
        setLayout(null);
        setLocation(50, 50);
        setBackground(Color.GRAY);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        add = new JButton("View New Added Book");
        add.setBounds(150, 80, 190,30);
        add.addActionListener(this);
        add(add);
         issue= new JButton(" View Issue Book");
        issue.setBounds(150, 150, 190,30);
        issue.addActionListener(this);
        add(issue);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
          if(e.getSource()==add)
        {
            new View();
            setVisible(false);
        }
        
        else if(e.getSource()==issue)
        {
            new AddI();
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new ViewBook();
    }
    
}
