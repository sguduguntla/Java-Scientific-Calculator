import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame {
	private JFrame frame;
	private JTextField fname;
	private JTextField lname;
	private JTextField email;
	private JTextField grade;
	private JTextField userfield;
	private JPasswordField passfield;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private JTextField userfield2;
	private JTextField passfield2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		String a = "Hello, I am the man who says hello to the man named Hello.";
        String g = a.substring(a.indexOf("sa"), a.lastIndexOf("o to"));
        System.out.println("");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new LoginFrame().connectToDatabase();
					LoginFrame window = new LoginFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginFrame() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("");
		dataSource.setServerName("localhost");

		try {
			conn = dataSource.getConnection();
			System.out.println("Connected.");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery("SELECT * FROM testdb.users");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(240, 255, 240));
		frame.setBounds(100, 100, 620, 668);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel title1 = new JLabel("Welcome to Sai's");
		title1.setForeground(new Color(0, 0, 255));
		title1.setFont(new Font("Gill Sans MT", Font.PLAIN, 25));
		title1.setBounds(212, 6, 185, 65);
		frame.getContentPane().add(title1);

		JLabel title2 = new JLabel("Scientific Calculator!");
		title2.setForeground(new Color(0, 0, 255));
		title2.setFont(new Font("Gill Sans MT", Font.PLAIN, 25));
		title2.setBounds(199, 44, 207, 65);
		frame.getContentPane().add(title2);

		JLabel signedUpLabel = new JLabel("Already signed up?");
		signedUpLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		signedUpLabel.setBounds(107, 421, 185, 65);
		frame.getContentPane().add(signedUpLabel);

		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		firstNameLabel.setBounds(31, 157, 104, 30);
		frame.getContentPane().add(firstNameLabel);

		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lastNameLabel.setBounds(31, 215, 114, 30);
		frame.getContentPane().add(lastNameLabel);

		fname = new JTextField();
		fname.setBounds(147, 161, 162, 28);
		frame.getContentPane().add(fname);
		fname.setColumns(10);

		lname = new JTextField();
		lname.setBounds(147, 219, 162, 28);
		frame.getContentPane().add(lname);
		lname.setColumns(10);

		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		emailLabel.setBounds(78, 275, 57, 30);
		frame.getContentPane().add(emailLabel);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(147, 279, 162, 28);
		frame.getContentPane().add(email);

		JLabel gradeLabel = new JLabel("Grade");
		gradeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		gradeLabel.setBounds(78, 327, 57, 30);
		frame.getContentPane().add(gradeLabel);

		grade = new JTextField();
		grade.setColumns(10);
		grade.setBounds(147, 331, 162, 28);
		frame.getContentPane().add(grade);

		JLabel userLabel = new JLabel("Username");
		userLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		userLabel.setBounds(321, 160, 104, 30);
		frame.getContentPane().add(userLabel);

		userfield = new JTextField();
		userfield.setColumns(10);
		userfield.setBounds(437, 161, 162, 28);
		frame.getContentPane().add(userfield);

		JLabel passLabel = new JLabel("Password");
		passLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		passLabel.setBounds(321, 215, 104, 30);
		frame.getContentPane().add(passLabel);

		passfield = new JPasswordField();
		passfield.setBounds(437, 219, 162, 28);
		frame.getContentPane().add(passfield);

		JLabel star1 = new JLabel("*");
		star1.setForeground(Color.RED);
		star1.setFont(new Font("Monaco", Font.BOLD, 22));
		star1.setBounds(16, 155, 44, 36);
		frame.getContentPane().add(star1);

		JLabel star2 = new JLabel("*");
		star2.setForeground(Color.RED);
		star2.setFont(new Font("Monaco", Font.BOLD, 22));
		star2.setBounds(16, 209, 44, 36);
		frame.getContentPane().add(star2);

		JLabel star3 = new JLabel("*");
		star3.setForeground(Color.RED);
		star3.setFont(new Font("Monaco", Font.BOLD, 22));
		star3.setBounds(66, 317, 44, 36);
		frame.getContentPane().add(star3);

		JLabel copyright = new JLabel("\u00A9 3551 Tech Industries 2015");
		copyright.setBounds(199, 624, 207, 16);
		frame.getContentPane().add(copyright);

		JButton signUpBtn = new JButton("Sign Up!");
		signUpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String userTxt = userfield.getText().trim();
					char[] password = passfield.getPassword();
					String fName = fname.getText().trim();
					String lName = lname.getText().trim();
					String emailTxt = email.getText().trim();
					int gradeTxt = 0;
					String passTxt = "";
					for (int i = 0; i < password.length; i++) {
						passTxt += password[i];
					}
					passTxt = passTxt.trim();
					if (userTxt.trim().equals("") || fName.trim().equals("")
							|| lName.trim().equals("")
							|| passTxt.trim().equals("")) {
						JOptionPane.showMessageDialog(null,
								"You have not filled out all required fields!");
					} else {
						try {

							gradeTxt = Integer.parseInt(grade.getText());

							rs = stmt
									.executeQuery("SELECT username FROM testdb.users WHERE username = '"
											+ userTxt + "'");
							int counter = 0;
							while (rs.next()) {
								counter++;
							}
							if (counter >= 1) {
								JOptionPane
										.showMessageDialog(
												null,
												"Username ("
														+ userTxt
														+ ") already exists! Please choose a different username.");
							} else {
								rs = stmt
										.executeQuery("SELECT * FROM testdb.users");
								JOptionPane.showMessageDialog(null,
										"Thank you for signing up!");
								rs.moveToInsertRow();
								rs.updateString("username", userTxt);
								rs.updateString("password", passTxt);
								rs.updateString("first name", fName);
								rs.updateString("last name", lName);
								rs.updateInt("grade", gradeTxt);
								rs.updateString("email", emailTxt);
								rs.insertRow();

								System.out.println(passTxt);
								while (rs.next()) {
									System.out.println(rs.getString("username"));
									System.out.println(rs.getString("password"));
								}

								rs.close();
								stmt.close();

								stmt = conn.createStatement(
										ResultSet.TYPE_SCROLL_INSENSITIVE,
										ResultSet.CONCUR_UPDATABLE);
								rs = stmt
										.executeQuery("SELECT * FROM testdb.users");
								frame.setVisible(false);
								new CalculatorFrame();
							}

						} catch (NumberFormatException e2) {
							JOptionPane
									.showMessageDialog(
											null,
											"You have entered an invalid value for \"Grade\". Please enter a number between 1 - 12 inclusive.");
						}
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		signUpBtn.setToolTipText("Sign Up");
		signUpBtn.setOpaque(true);
		signUpBtn.setBorder(BorderFactory.createLineBorder(Color.RED));
		signUpBtn.setForeground(new Color(255, 0, 0));
		signUpBtn.setBackground(new Color(255, 255, 0));
		signUpBtn.setFont(new Font("Lithos Pro", Font.PLAIN, 35));
		signUpBtn.setBounds(354, 275, 207, 81);
		frame.getContentPane().add(signUpBtn);

		JLabel userLabel2 = new JLabel("Username");
		userLabel2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		userLabel2.setBounds(321, 403, 104, 30);
		frame.getContentPane().add(userLabel2);

		JLabel passLabel2 = new JLabel("Password");
		passLabel2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		passLabel2.setBounds(321, 456, 104, 30);
		frame.getContentPane().add(passLabel2);

		userfield2 = new JTextField();
		userfield2.setColumns(10);
		userfield2.setBounds(437, 407, 162, 28);
		frame.getContentPane().add(userfield2);

		passfield2 = new JPasswordField();
		passfield2.setColumns(10);
		passfield2.setBounds(437, 458, 162, 28);
		frame.getContentPane().add(passfield2);

		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String userTxt = userfield2.getText().trim();
					char[] password = ((JPasswordField) passfield2).getPassword();
					String passTxt = "";
					for (int i = 0; i < password.length; i++) {
						passTxt += password[i];
					}
					passTxt = passTxt.trim();
					if (userTxt.trim().equals("") || passTxt.trim().equals("")) {
						JOptionPane.showMessageDialog(null,
								"You have not entered a username or password!");
					} else {

						rs = stmt
								.executeQuery("SELECT username FROM testdb.users WHERE username = '"
										+ userTxt + "'");
						int counter = 0;
						while (rs.next()) {
							counter++;
						}

						if (counter == 1) {
							rs = stmt
									.executeQuery("SELECT password FROM testdb.users WHERE password = '"
											+ passTxt + "'");
							int counter2 = 0;
							while (rs.next()) {
								counter2++;
							}
							if (counter2 == 1) {
								JOptionPane.showMessageDialog(null,
										"You have successfully logged in!");
								rs = stmt
										.executeQuery("SELECT * FROM testdb.users");

								frame.setVisible(false);
								new CalculatorFrame();
							} else {
								JOptionPane.showMessageDialog(null,
										"Username or password doesn't exist!");
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Username or password doesn't exist!");
						}
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		loginBtn.setToolTipText("Sign Up");
		loginBtn.setOpaque(true);
		loginBtn.setForeground(Color.RED);
		loginBtn.setFont(new Font("Lithos Pro", Font.PLAIN, 35));
		loginBtn.setBorder(BorderFactory.createLineBorder(Color.RED));
		loginBtn.setBackground(Color.YELLOW);
		loginBtn.setBounds(354, 510, 207, 81);
		frame.getContentPane().add(loginBtn);

	}

	private void connectToDatabase() {
		try {
			System.out.println("Loading driver...");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(
					"Cannot find the driver in the classpath!", e);
		}
	}
}
