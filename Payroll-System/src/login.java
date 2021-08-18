import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
/**
*
* @author HUMBLEFOOL
*/
// this class is implementing the ActionListener class
public class login extends JFrame implements ActionListener {
	// creating required fields(they are global)
	JLabel l1, l2;
	JTextField t1;
	JPasswordField t2;
	JButton b1, b2;

	// constructor which will also contains our frame
	login() {
		super("Login Page");
		/*
		 * The BorderLayout is used to arrange the components in five regions: north,
		 * south, east, west and center. Each region (area) may contain one component
		 * only. It is the default layout of frame or window.
		 */
		setLayout(new BorderLayout());
		t2 = new JPasswordField(10);
		t1 = new JTextField(10);

		JLabel l = new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon/defaultpic.png")));
		b1 = new JButton("Submit", new ImageIcon(ClassLoader.getSystemResource("icon\\login.png")));
		b2 = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("icon\\Cancel.png")));

		// adding action listener to submit and cancel button
		b1.addActionListener(this);
		b2.addActionListener(this);

		JPanel p1, p2, p3, p4;
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();

		add(l, BorderLayout.WEST);

		p2.add(new JLabel("ENTER CREDENTIALS                                              "));
		add(p2, BorderLayout.NORTH);
		p2.add(new JLabel("                                                                  "));
		add(p2, BorderLayout.NORTH);

		p2.add(new JLabel("     User Name "));
		p2.add(t1);
		p2.add(new JLabel("      Password "));
		p2.add(t2);
		add(p2, BorderLayout.CENTER);

		p4.add(b1);
		p4.add(b2);

		add(p4, BorderLayout.SOUTH);

		setSize(400, 250);
		setLocation(500, 250);
		setVisible(true);

	}

	// overriding the actionPerformed function
	public void actionPerformed(ActionEvent ae) {
		try {
			// creating the object of the conn class
			conn c1 = new conn();
			// storing the userName and Password in String u and v
			String u = t1.getText();
			String v = t2.getText();
			// writing the query for the data base
			String q = "select * from login where username='" + u + "' and password='" + v + "'";
			// storing the output of the query in the ResultSet interface
			ResultSet rs = c1.s.executeQuery(q); // query execute
			// if all the value of ResultSet is satisfied then open the project frame and
			// disable the current frame
			if (rs.next()) {
				new project().setVisible(true);
				setVisible(false);
			} else {
				// otherwise display the pop-up
				JOptionPane.showMessageDialog(null, "Invalid login");
				setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// inside the main function calling the constructor the login class
		new login();
	}
}
