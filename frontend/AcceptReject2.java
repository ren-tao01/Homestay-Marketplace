package frontend;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import backend.Bookings;
import backend.Guest;
import backend.Properties;

public class AcceptReject2 implements ActionListener{

JFrame frame;
	
	private String hostID;
	private JTextField bookingIDinput;
	private int propertyID;
	private String guestID;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcceptReject2 window = new AcceptReject2("@hey.co.uk");
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
	public AcceptReject2(String hostID) {
		this.hostID = hostID;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(15, 15, 70, 15);
		frame.getContentPane().add(backButton);
		backButton.addActionListener(this);
		
		JLabel titleLabel = new JLabel("Provisional Booking: ");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		titleLabel.setBounds(35, 25, 235, 40);
		frame.getContentPane().add(titleLabel);
		
		JLabel propIDLabel = new JLabel("Enter the booking ID :");
		propIDLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		propIDLabel.setBounds(50, 70, 200, 20);
		frame.getContentPane().add(propIDLabel);
		
		bookingIDinput = new JTextField();
		bookingIDinput.setBounds(235, 70, 50, 20);
		frame.getContentPane().add(bookingIDinput);
		bookingIDinput.setColumns(10);
		
		JButton detailsButton = new JButton("details");
		detailsButton.setBounds(290, 70, 85, 20);
		frame.getContentPane().add(detailsButton);
		frame.getRootPane().setDefaultButton(detailsButton);
		
		JLabel guestNameLabel = new JLabel("Guest Name:");
		guestNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		guestNameLabel.setBounds(105, 105, 100, 20);
		frame.getContentPane().add(guestNameLabel);
		
		JLabel guestNameRes = new JLabel("");
		guestNameRes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		guestNameRes.setBounds(255, 107, 200, 15);
		frame.getContentPane().add(guestNameRes);
		
		JLabel guestEmailLabel = new JLabel("Guest Email:");
		guestEmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		guestEmailLabel.setBounds(105, 130, 100, 20);
		frame.getContentPane().add(guestEmailLabel);
		
		JLabel guestEmailRes = new JLabel("");
		guestEmailRes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		guestEmailRes.setBounds(255, 132, 300, 15);
		frame.getContentPane().add(guestEmailRes);
		
		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addressLabel.setBounds(105, 155, 300, 20);
		frame.getContentPane().add(addressLabel);
		
		JLabel addressRes = new JLabel("");
		addressRes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addressRes.setBounds(255, 155, 400, 15);
		frame.getContentPane().add(addressRes);
		
		JLabel dateLabel = new JLabel("Requested Date:");
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dateLabel.setBounds(105, 180, 150, 20);
		frame.getContentPane().add(dateLabel);
		
		JLabel dateRes = new JLabel("");
		dateRes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dateRes.setBounds(255, 180, 300, 15);
		frame.getContentPane().add(dateRes);
		
		
		detailsButton.addActionListener(e ->{
			String idInString = bookingIDinput.getText();
			int id = Integer.valueOf(idInString);
			
			
			HashMap deeds = Bookings.getBookingDetails(id);
			List<Integer> listOfIDs = Properties.getHostsProperties(this.hostID);
			int propid = Integer.valueOf(String.valueOf(deeds.get("propertyID")));
			this.propertyID = propid;

			System.out.println("id "+ id +" found");
			String guestEmail = String.valueOf(deeds.get("guestID"));
			this.guestID = guestEmail;
			
			String columnName = "email";
			String fullName = Guest.getFullName(columnName, guestEmail);
				
			String address = Properties.getPrivateLocation(propertyID);
			String dates = String.valueOf(deeds.get("startDate")) + "  TO  " +
					String.valueOf(deeds.get("endDate"));
			
			
			guestNameRes.setText(fullName);
			guestEmailRes.setText(guestEmail);
			addressRes.setText(address);
			dateRes.setText(dates);
			
			JButton acceptButton = new JButton("Accept");
			acceptButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
			acceptButton.setBounds(135, 210, 85, 25);
			frame.getContentPane().add(acceptButton);
				
			acceptButton.addActionListener(this);
				
			JButton rejectButton = new JButton("Reject");
			rejectButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
			rejectButton.setBounds(245, 210, 85, 25);
			frame.getContentPane().add(rejectButton);
			frame.setBounds(100, 100, 651, 450);
				
			rejectButton.addActionListener(this);
				
			
		});
		
	}	
	
	public void keyPressed(KeyEvent e) {
	    if (e.getKeyCode()==KeyEvent.VK_ENTER){
	        System.out.println("Presed Enter");
	        
//	        JOptionPane.showMessageDialog("hi");
	    }

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="Back") {
			frame.dispose();
			HostHomepage returnTo = new HostHomepage(this.hostID);
			returnTo.frame.setVisible(true);
		}
		
		if(e.getActionCommand()=="Accept") {
			Properties.setBookedBy(this.propertyID, this.guestID);
			
			String allReq = Properties.getRequestedBy(this.propertyID);
			System.out.println(allReq);
			String temp = "";
			
			if(allReq.contains(",")) {
				String toBeReplaced = ", " + this.guestID;
				temp = allReq.replaceAll(toBeReplaced, "");
			}
			else {
				String toBeReplaced = this.guestID;
				temp = allReq.replaceAll(toBeReplaced, "");
			}
//			
			try {
				Properties.editProperty(propertyID, "requestedBy", temp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			frame.dispose();
			HostHomepage returnTo = new HostHomepage(this.hostID);
			returnTo.frame.setVisible(true);
		}
		
		if(e.getActionCommand()=="Reject") {
			String allReq = Properties.getRequestedBy(this.propertyID);
			System.out.println(allReq);
			String temp = "";
			
			if(allReq.contains(",")) {
				String toBeReplaced = ", " + this.guestID;
				temp = allReq.replaceAll(toBeReplaced, "");
			}
			else {
				String toBeReplaced = this.guestID;
				temp = allReq.replaceAll(toBeReplaced, "");
			}
//			
			try {
				Properties.editProperty(propertyID, "requestedBy", temp);
				int b_ID = Bookings.getSelectedBookingID(this.propertyID, this.guestID);
				Bookings.deleteBooking(b_ID);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispose();
			HostHomepage returnTo = new HostHomepage(this.hostID);
			returnTo.frame.setVisible(true);
		}
		
	}
}
