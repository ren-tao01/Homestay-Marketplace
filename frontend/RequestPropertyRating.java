package frontend;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import backend.Bookings;
import backend.Properties;
import backend.Review;

public class RequestPropertyRating {

	JFrame frame;
	private JTextField propIDTextInput;
	private static int propertyID;
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RequestPropertyRating window = new RequestPropertyRating(propertyID);
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
	public RequestPropertyRating(int propertyID) {
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
		
		JLabel propIDLabel = new JLabel("Property ID :");
		propIDLabel.setBounds(55, 55, 100, 13);
		frame.getContentPane().add(propIDLabel);
		
		JButton requestButton = new JButton("View Property Rating");
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
				
				int propID = Integer.valueOf(propIDTextInput.getText());
				int rating = Review.getAverageReviews(propID);
				
				JOptionPane.showMessageDialog(null, rating);

			}
		});

	}
	
	
	
	public JFrame getFrame() {
		return this.frame;
	}

}
