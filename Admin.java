package Lib;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Admin extends JFrame implements ActionListener {
    
    JLabel Login,Name,Password;
    JTextField tf,tf1;
    
    JButton Loginbtn;
    Admin()
    {
        setSize(500, 500);
        setLayout(null);
        setLocation(50, 50);
        setBackground(Color.GRAY);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Login = new JLabel("Admin Login");
        Login.setBounds(200, 50, 120, 20);
        Login.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(Login);
         Name = new JLabel("Name  :");
        Name.setBounds(50, 170, 120, 20);
        Name.setFont(new Font("Serif", Font.PLAIN, 17));
        add(Name);
        tf = new JTextField(20);
        tf.setBounds(170,170, 170, 20);
        add(tf);
        Password = new JLabel("Password  :");
        Password.setBounds(50, 220, 120, 20);
        Password.setFont(new Font("Serif", Font.PLAIN, 17));
        add(Password);
        tf1 = new JPasswordField(15);
        tf1.setBounds(170, 220, 170, 20);
        add(tf1);
        Loginbtn = new JButton("Login");
        Loginbtn.setBounds(180, 340, 120, 22);
        Loginbtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        Loginbtn.addActionListener(this);
        add(Loginbtn);

    }
    public static void main(String[] args) {
        new Admin();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
       {  
        String userValue = tf.getText();      
        String passValue = tf1.getText();     
          
        
        if (userValue.equals("test1@gmail.com") && passValue.equals("test")) { 
              
           
                    new NewPage();  
                    setVisible(false);
              
           
        }  
        else{  
            //show error message  
            System.out.println("Please enter valid username and password");  
        }  
    }  
    }
    
}
