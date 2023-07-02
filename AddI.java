package Lib;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddI extends JFrame {
      String url = "jdbc:MySQL://localhost:3306/library";
  String user = "root";
    String password = "yogesh$2004";
     String drivename = "com.mysql.jdbc.Driver";
  String[] columnname = {"BookID", "Book_Name"," Author", "Publisher"," Quantity"};

     JTable table;
    AddI()
    {
 super("Issue Book");

        try {
            Class.forName(drivename);
            Connection connection = DriverManager.getConnection(url,user,password);
            String query = "SELECT * FROM addbook";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columnname);

     
            while (resultSet.next()) {
              
                String BookId = resultSet.getString("BookId");
                String Book_Name = resultSet.getString("Book_Name");
                String Author = resultSet.getString("Author");
                String Publisher = resultSet.getString("Publisher");
                String Quantity = resultSet.getString("Quantity");

                model.addRow(new Object[]{BookId, Book_Name, Author, Publisher, Quantity});
                
            }
            table = new JTable(model);

            JScrollPane scrollPane = new JScrollPane(table);
            getContentPane().removeAll();
            getContentPane().add(scrollPane, BorderLayout.CENTER);
            revalidate();
            repaint();

            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AddI();
    }
    
    
}
