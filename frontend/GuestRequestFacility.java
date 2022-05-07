package frontend;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import backend.Properties;

public class GuestRequestFacility {

	JFrame frame;
	private JTextField propIDTextInput;
	private static int propertyID;
	private static String guestID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestRequestFacility window = new GuestRequestFacility(guestID,propertyID);
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
	public GuestRequestFacility(String guestID, int propertyID) {
		this.guestID = guestID;
		this.propertyID = propertyID;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(350, 200, 450, 250);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setBounds(129, 171, 200, 21);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(e -> {

			GuestHomepage host = new GuestHomepage(guestID);
        	host.frame.setVisible(true);
        	 frame.dispose();
	      });
		
		JLabel propIDLabel = new JLabel("Property ID :");
		propIDLabel.setBounds(55, 55, 100, 13);
		frame.getContentPane().add(propIDLabel);
		
		JButton requestButton = new JButton("View Detailed Facility");
		requestButton.setBounds(129, 141, 200, 21);
		frame.getContentPane().add(requestButton);
		
		propIDTextInput = new JTextField();
		propIDTextInput.setBounds(165, 55, 140, 17);
		frame.getContentPane().add(propIDTextInput);
		propIDTextInput.setColumns(10);
		
		requestButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// TODO Auto-generated method stub
				            	
				String id = propIDTextInput.getText();
				
				if (id.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter the property ID.");
				} else {
					DetailedFacility back= new DetailedFacility(guestID,Integer.parseInt(id));
            		back.frame.setVisible(true);
            		frame.dispose();				}
			}
		});
	}

}
