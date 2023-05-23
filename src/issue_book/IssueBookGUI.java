/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package issue_book;

/**
 *
 * @author Eisha Tariq
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IssueBookGUI {
    public static void main(String[] args) {
        BookDao bookDao = new BookDaoImpl();
        UserDao userDao = new UserDaoImpl();
        IssueDao issueDao = new IssueDaoImpl();

        // Create a JFrame to hold the components
        JFrame frame = new JFrame("Enter Details");

        // Create a JPanel with GridBagLayout to hold the input fields and button
        JPanel panel = new JPanel(new GridBagLayout());

        // Create labels and text fields for Book ID, User ID, Period, and Issue Date
        JLabel bookIdLabel = new JLabel("Book ID (BID):");
        JTextField bookIdField = new JTextField(10);

        JLabel userIdLabel = new JLabel("User ID (UID):");
        JTextField userIdField = new JTextField(10);

        JLabel periodLabel = new JLabel("Period (days):");
        JTextField periodField = new JTextField(10);

        JLabel issueDateLabel = new JLabel("Issue Date (DD-MM-YYYY):");
        JTextField issueDateField = new JTextField(10);

        // Create a button to issue the book
        JButton issueButton = new JButton("Submit");
        issueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the input values from the text fields
                int bookId = Integer.parseInt(bookIdField.getText());
                int userId = Integer.parseInt(userIdField.getText());
                int period = Integer.parseInt(periodField.getText());
                String issueDate = issueDateField.getText();

                // Check if the book and user exist
                if (bookDao.getBookById(bookId) == null) {
                    JOptionPane.showMessageDialog(frame, "Invalid Book ID");
                    return;
                }
                if (userDao.getUserById(userId) == null) {
                    JOptionPane.showMessageDialog(frame, "Invalid User ID");
                    return;
                }

                // Issue the book
                issueDao.issueBook(bookId, userId, period, issueDate);

                // Display a message dialog
                JOptionPane.showMessageDialog(frame, "Book issued successfully!");
            }
        });

        // Create GridBagConstraints for layout control
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);

        // Add the components to the panel
        panel.add(bookIdLabel, constraints);

        constraints.gridx = 1;
        panel.add(bookIdField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(userIdLabel, constraints);

        constraints.gridx = 1;
        panel.add(userIdField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(periodLabel, constraints);

        constraints.gridx = 1;
        panel.add(periodField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(issueDateLabel, constraints);

        constraints.gridx = 1;
        panel.add(issueDateField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(issueButton, constraints);

        // Add the panel to the JFrame
        frame.getContentPane().add(panel);

        // Set the JFrame size and make it visible
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

interface BookDao {
    Book getBookById(int bookId);
}

class BookDaoImpl implements BookDao {
    // Implement the BookDao interface methods
    // Example implementation for getBookById()
    @Override
    public Book getBookById(int bookId) {
        // Simulate retrieving a book from the database using the DAO pattern
        // Replace this with your actual implementation
        if (bookId == 1) {
            return new Book(1, "Book 1");
        } else {
            return null;
        }
    }
}

interface UserDao {
    User getUserById(int userId);
}

class UserDaoImpl implements UserDao {
    // Implement the UserDao interface methods
    // Example implementation for getUserById()
    @Override
    public User getUserById(int userId) {
        // Simulate retrieving a user from the database using the DAO pattern
        // Replace this with your actual implementation
        if (userId == 1) {
            return new User(1, "John");
        } else {
            return null;
        }
    }
}

interface IssueDao {
    void issueBook(int bookId, int userId, int period, String issueDate);
}

class IssueDaoImpl implements IssueDao {
    // Implement the IssueDao interface methods
    // Example implementation for issueBook()
    @Override
    public void issueBook(int bookId, int userId, int period, String issueDate) {
        // Simulate issuing a book and storing the information in the database using the DAO pattern
        // Replace this with your actual implementation
        System.out.println("Book issued - Book ID: " + bookId + ", User ID: " + userId + ", Period: " + period + ", Issue Date: " + issueDate);
    }
}

class Book {
    private int bookId;
    private String title;

    public Book(int bookId, String title) {
        this.bookId = bookId;
        this.title = title;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }
}

class User {
    private int userId;
    private String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}

