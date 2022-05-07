package frontend;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import backend.Bookings;
import backend.Properties;

public class GuestRequest {

	private JFrame frame;
	
	private String guestID;
	private List listOfProperties;
	private String inputStartDate;
	private String inputEndDate;
	
	private JTextField propIDTextInput;
	private JTextField startDateTextInput;
	private JTextField endDateTextInput;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestRequest window = new GuestRequest("@p.co.uk", null, null, null);
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
	public GuestRequest(String guestID, List pList, String inputStartD, String inputEndD) {
		this.guestID = guestID;
		this.listOfProperties = pList;
		this.inputStartDate = inputStartD;
		this.inputEndDate = inputEndD;
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
		
//		JLabel startDateLabel = new JLabel("Start Date :");
//		startDateLabel.setBounds(55, 80, 80, 13);
//		frame.getContentPane().add(startDateLabel);
//		
//		JLabel endDateLabel = new JLabel("End Date :");
//		endDateLabel.setBounds(55, 105, 60, 13);
//		frame.getContentPane().add(endDateLabel);
		
		JButton requestButton = new JButton("Request Booking");
		requestButton.setBounds(129, 141, 200, 21);
		frame.getContentPane().add(requestButton);
		
		propIDTextInput = new JTextField();
		propIDTextInput.setBounds(165, 55, 140, 17);
		frame.getContentPane().add(propIDTextInput);
		propIDTextInput.setColumns(10);
		
//		startDateTextInput = new JTextField();
//		startDateTextInput.setBounds(145, 80, 90, 17);
//		frame.getContentPane().add(startDateTextInput);
//		startDateTextInput.setColumns(10);
//		
//		endDateTextInput = new JTextField();
//		endDateTextInput.setBounds(145, 105, 90, 17);
//		frame.getContentPane().add(endDateTextInput);
//		endDateTextInput.setColumns(10);
		
		String guestid = this.guestID;
		
		requestButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// TODO Auto-generated method stub
				
				int propID = Integer.valueOf(propIDTextInput.getText());
		
				
				try {
					Properties.setRequestedBy(propID, guestid);
					Bookings.addBooking(propID, inputStartDate, inputEndDate, guestid);
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				frame.setVisible(false);
			}
		});
	}
	
	public JFrame getFrame() {
		return this.frame;
	}

}
