package frontend;
import frontend.Login;
import backend.Host;
import backend.Guest;
import backend.Person;
import backend.Validate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Registration {

	JFrame frame;
	private JTextField email;
	private JTextField forename;
	private JTextField surname;
	private JTextField mobile;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
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
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 759, 608);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(29, 29, 130, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(29, 92, 74, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		email = new JTextField();
		email.setBounds(154, 95, 251, 25);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Account Type:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(29, 141, 130, 27);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JComboBox account = new JComboBox();
		account.setModel(new DefaultComboBoxModel(new String[] {"HOST", "GUEST", "ADMIN"}));
		account.setBounds(154, 146, 251, 25);
		frame.getContentPane().add(account);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Title:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(29, 191, 130, 27);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JComboBox title = new JComboBox();
		title.setModel(new DefaultComboBoxModel(new String[] {"Ms", "Mr", "Miss", "Mrs"}));
		title.setBounds(154, 196, 251, 25);
		frame.getContentPane().add(title);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Forename:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(29, 239, 130, 27);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		forename = new JTextField();
		forename.setColumns(10);
		forename.setBounds(154, 242, 251, 25);
		frame.getContentPane().add(forename);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Surname:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1.setBounds(29, 291, 130, 27);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		surname = new JTextField();
		surname.setColumns(10);
		surname.setBounds(154, 293, 251, 25);
		frame.getContentPane().add(surname);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Mobile Number:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_1.setBounds(29, 340, 130, 27);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1_1);
		
		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(154, 346, 251, 25);
		frame.getContentPane().add(mobile);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("Password:");
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_2.setBounds(29, 393, 130, 27);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1_2);
		
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(154, 399, 251, 25);
		frame.getContentPane().add(password);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(29, 470, 130, 27);
		frame.getContentPane().add(btnNewButton);
		
		//add action listener for register button
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (evt.getSource()==btnNewButton) {
					
					String emailInput = Validate.Validation(email.getText());
					String accountInput = account.getSelectedItem().toString();
					String titleInput = title.getSelectedItem().toString();
					String forenameInput = Validate.Validation(forename.getText());
					String surnameInput = Validate.Validation(surname.getText());
					String mobileInput = Validate.Validation(mobile.getText());
					String passwordInput = Validate.Validation(password.getText());
					
					if (emailInput.equals("") || accountInput.equals("") || titleInput.equals("") || forenameInput.equals("") || surnameInput.equals("") || mobileInput.equals("") || passwordInput.equals("")) {
						JOptionPane.showMessageDialog(null, "One or more fields empty");
					} else { 
						try {
							Person.addPerson(emailInput, titleInput, surnameInput, surnameInput, accountInput, mobileInput, passwordInput);
							JOptionPane.showMessageDialog(null, "Successfully registered.");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			}
		});
		
		JButton btnLogin = new JButton("Login ");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(233, 528, 130, 27);
		frame.getContentPane().add(btnLogin);
		
		//add action listener for login now button
		btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (evt.getSource()==btnLogin) {
                	
                	Login login = new Login();
                	login.frame.setVisible(true);
                	 frame.dispose();
                }
            }
        });
		
		JLabel lblNewLabel_1_1_1_1_1_2_1 = new JLabel("Already have an account?");
		lblNewLabel_1_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_2_1.setBounds(29, 528, 173, 27);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1_2_1);
	}
}
