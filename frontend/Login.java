package frontend;
import frontend.HostHomepage;
import frontend.Registration;
import backend.Person;
import backend.Validate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JButton;

public class Login {

	JFrame frame;
	private JTextField email;
	private JTextField password;
	private HostHomepage host;
	private GuestHomepage guest;
	private Registration register;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}    

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 517, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(29, 29, 74, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabelEmail= new JLabel("Email: ");
		lblNewLabelEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabelEmail.setBounds(29, 92, 74, 27);
		frame.getContentPane().add(lblNewLabelEmail);
		
		email = new JTextField();
		email.setBounds(113, 92, 251, 25);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		JLabel lblNewLabelPassword = new JLabel("Password:");
		lblNewLabelPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabelPassword.setBounds(29, 141, 74, 27);
		frame.getContentPane().add(lblNewLabelPassword);
		
		password = new JPasswordField();
		password .setColumns(10);
		password .setBounds(113, 141, 251, 25);
		frame.getContentPane().add(password );

		JButton btnNewButton = new JButton(""
				+ ""
				+ "Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(29, 205, 85, 27);
		frame.getContentPane().add(btnNewButton);
		
		//add action listener for login button
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (evt.getSource()==btnNewButton) {

                	String emailInput = Validate.Validation(email.getText());
                	String passwordInput = Validate.Validation(password.getText());
                	
                	if (emailInput.equals("") || passwordInput.equals("")) {
                		JOptionPane.showMessageDialog(null,"One or more fields empty");
                	} else {
                		boolean person = Person.login(emailInput, passwordInput);
                		
                		if (person == false) {
                			JOptionPane.showMessageDialog(null, "Wrong username/password");
                		} else {
                			
                			if ( Person.getAccountType(emailInput).equals("HOST")) {
                				JOptionPane.showMessageDialog(null, "Login Successful");
                            	HostHomepage host = new HostHomepage(emailInput);
                            	host.frame.setVisible(true);
                           	 	frame.dispose();
                			} else if (Person.getAccountType(emailInput).equals("GUEST")) {
                				JOptionPane.showMessageDialog(null, "Login Successful");
                            	GuestHomepage guest = new GuestHomepage(emailInput);
                            	guest.frame.setVisible(true);
                           	 	frame.dispose();
                			} else {
                				System.out.print("Admin page not done.");
                			}
             		
                		}
      
                	}	
                }
            }
        });
		
		JButton btnRegisterNow = new JButton("Register Now");
		btnRegisterNow.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegisterNow.setBounds(242, 259, 122, 27);
		frame.getContentPane().add(btnRegisterNow);
		
		//add action listener for register now button
		btnRegisterNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (evt.getSource()==btnRegisterNow) {
                	
                	Registration register = new Registration();
                	register.frame.setVisible(true);
                	 frame.dispose();
                }
            }
        });
		
		JLabel lblNewLabel_1_2 = new JLabel("Don't have an account yet? ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(29, 259, 203, 27);
		frame.getContentPane().add(lblNewLabel_1_2);
	}

	
	
}
