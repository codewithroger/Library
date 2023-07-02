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

public class View extends JFrame {
    String url = "jdbc:MySQL://localhost:3306/library";
  String user = "root";
    String password = "yogesh$2004";
     String drivename = "com.mysql.jdbc.Driver";
  String[] columnname = {"Library_Id", "book_id", "Book Name", "Issue Date", "Issue Name", "Contact"};

     JTable table;

    public View() {
        super("Issue Book");

        try {
            Class.forName(drivename);
            Connection connection = DriverManager.getConnection(url,user,password);
            String query = "SELECT * FROM issuebook";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columnname);

     
            while (resultSet.next()) {
                String library_id = resultSet.getString("Library_id");
                String bookid = resultSet.getString("bookid");
                String bookname = resultSet.getString("bookname");
                String issueDate = resultSet.getString("Issuse_Date");
                String issueName = resultSet.getString("Issuse_Name");
                String contact = resultSet.getString("Contact");

                model.addRow(new Object[]{library_id, bookid, bookname, issueDate, issueName, contact});
                
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
        new View();
    }
}
