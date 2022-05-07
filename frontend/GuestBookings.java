package frontend;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import backend.Bookings;
import backend.ChargeBands;
import backend.Guest;
import backend.Properties;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

public class GuestBookings implements ActionListener {

	JFrame frame;
	
	private static String guestID;
	private static int propertyID;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestBookings window = new GuestBookings("@p.co.uk");
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
	public GuestBookings(String guestID) {
		this.guestID = guestID;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 20, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton homeButton = new JButton("Home");
		homeButton.setBounds(10, 10, 90, 21);
		frame.getContentPane().add(homeButton);
		homeButton.addActionListener(this);
		
		JButton detailsButton = new JButton("View Confidential Property Details");
		detailsButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		detailsButton.setBounds(150, 10, 300, 25);
		frame.getContentPane().add(detailsButton);
		detailsButton.addActionListener(e -> {

			GuestRequestViewProperty request = new GuestRequestViewProperty(guestID,propertyID);
	    	request.frame.setVisible(true);
	    	 frame.dispose();
	    	 
	      });
		
		JLabel bookingsLabel = new JLabel("Bookings");
		bookingsLabel.setBounds(58, 46, 76, 13);
		frame.getContentPane().add(bookingsLabel);
		
		List <HashMap> listOfProperties = Guest.viewRequestedBookings(this.guestID);
		System.out.println(listOfProperties);
		int sectionSpace = 0;
		int columnSpace = 0;
		for (HashMap booking : listOfProperties) {
			System.out.println("Getting property...");
			int propid = Integer.valueOf(booking.get("propertyID").toString());
			
			JLabel idLabel = new JLabel("Property ID : " + propid);
			idLabel.setBounds(110 + columnSpace, 70 + sectionSpace, 100, 13);
			frame.getContentPane().add(idLabel);
			
			JLabel locationLabel = new JLabel("Location :");
			locationLabel.setBounds(110 + columnSpace, 84 + sectionSpace, 60, 13);
			frame.getContentPane().add(locationLabel);
			
			JLabel locationRes = new JLabel("Location ...");
			locationRes.setBounds(170 + columnSpace, 84 + sectionSpace, 265, 13);
			String displayLocation = (String) booking.get("street") + ", "
									+ (String) booking.get("postcode") + " "
									+ (String) booking.get("city");
			locationRes.setText(displayLocation);
			frame.getContentPane().add(locationRes);
			
			JLabel descriptionLabel = new JLabel("Description :");
			descriptionLabel.setBounds(110 + columnSpace, 105 + sectionSpace, 80, 13);
			frame.getContentPane().add(descriptionLabel);
			
			JTextArea descriptionArea = new JTextArea();
			descriptionArea.setBounds(195 + columnSpace, 105 + sectionSpace, 386, 35);
			descriptionArea.setText((String) booking.get("information"));
			frame.getContentPane().add(descriptionArea);
			
			
			JLabel sleepingFac = new JLabel("Sleeping facility :");
			sleepingFac.setBounds(110 + columnSpace, 150 + sectionSpace, 100, 13);
			frame.getContentPane().add(sleepingFac);
			
			JLabel sleepingAns = new JLabel("Empty");
			sleepingAns.setBounds(230 + columnSpace, 150 + sectionSpace, 45, 13);
			if(Properties.hasSleeping(propid)) {
				sleepingAns.setText("Yes");
			}
			frame.getContentPane().add(sleepingAns);
			
			JLabel bathingFac = new JLabel("Bathing facility :");
			bathingFac.setBounds(110 + columnSpace, 170 + sectionSpace, 100, 13);
			frame.getContentPane().add(bathingFac);
			
			JLabel bathingAns = new JLabel("Empty");
			bathingAns.setBounds(230 + columnSpace, 170 + sectionSpace, 45, 13);
			if(Properties.hasBathing(propid)){
				bathingAns.setText("Yes");
			}
			frame.getContentPane().add(bathingAns);
			
			JLabel kitchenFac = new JLabel("Kitchen :");
			kitchenFac.setBounds(110 + columnSpace, 190 + sectionSpace, 100, 13);
			frame.getContentPane().add(kitchenFac);
			
			JLabel kitchenAns = new JLabel("Empty");
			kitchenAns.setBounds(230 + columnSpace, 190 + sectionSpace, 45, 13);
			if(Properties.hasKitchen(propid)){
				kitchenAns.setText("Yes");
			}
			frame.getContentPane().add(kitchenAns);
			
			JLabel livingFac = new JLabel("Living room :");
			livingFac.setBounds(300 + columnSpace, 150 + sectionSpace, 100, 13);
			frame.getContentPane().add(livingFac);
			
			JLabel livingAns = new JLabel("Empty");
			livingAns.setBounds(420 + columnSpace, 150 + sectionSpace, 45, 13);
			if(Properties.hasLiving(propid)){
				livingAns.setText("Yes");
			}
			frame.getContentPane().add(livingAns);
			
			JLabel utilityFac = new JLabel("Utility :");
			utilityFac.setBounds(300 + columnSpace, 170 + sectionSpace, 100, 13);
			frame.getContentPane().add(utilityFac);
			
			JLabel utilityAns = new JLabel("Empty");
			utilityAns.setBounds(420 + columnSpace, 170 + sectionSpace, 45, 13);
			if(Properties.hasUtility(propid)){
				utilityAns.setText("Yes");
			}
			frame.getContentPane().add(utilityAns);
			
			JLabel outdoorFac = new JLabel("Outdoor :");
			outdoorFac.setBounds(300 + columnSpace, 190 + sectionSpace, 100, 13);
			frame.getContentPane().add(outdoorFac);
			
			JLabel outdoorAns = new JLabel("Empty");
			outdoorAns.setBounds(420 + columnSpace, 190 + sectionSpace, 45, 13);
			if(Properties.hasOutdoor(propid)){
				outdoorAns.setText("Yes");
			}
			frame.getContentPane().add(outdoorAns);
			
			// DATES
			JLabel datesLabel = new JLabel("Dates :");
			datesLabel.setBounds(110 + columnSpace, 210 + sectionSpace, 60, 13);
			frame.getContentPane().add(datesLabel);
									
			JLabel datesRes = new JLabel("yyyy/mm/dd");
			datesRes.setBounds(170 + columnSpace, 210 + sectionSpace, 200, 13);
			frame.getContentPane().add(datesRes);
									
			HashMap dates = Bookings.getSelectedBookingDates(propid, this.guestID);
			String sd = dates.get("startDate").toString() + "  TO  " + dates.get("endDate").toString();
			datesRes.setText(sd);
			
			JLabel pricePerNightLabel = new JLabel("Price Per Night :");
			pricePerNightLabel.setBounds(110 + columnSpace, 230 + sectionSpace, 95, 13);
			frame.getContentPane().add(pricePerNightLabel);
			
			JLabel pricePerNightRes = new JLabel("$$$");
			pricePerNightRes.setBounds(205 + columnSpace, 230 + sectionSpace, 45, 13);
			frame.getContentPane().add(pricePerNightRes);
			
			pricePerNightRes.setText(ChargeBands.getPricePerNight(propid).toString() + "£");
			
			JLabel cleaningChargeLabel = new JLabel("Cleaning :");
			cleaningChargeLabel.setBounds(255 + columnSpace, 230 + sectionSpace, 60, 13);
			frame.getContentPane().add(cleaningChargeLabel);
			
			JLabel cleaningChargeRes = new JLabel("$$$");
			cleaningChargeRes.setBounds(315 + columnSpace, 230 + sectionSpace, 45, 13);
			frame.getContentPane().add(cleaningChargeRes);
			
			cleaningChargeRes.setText(ChargeBands.getCleaningCharge(propid).toString() + "£");
			
			JLabel serviceChargeLabel = new JLabel("Service :");
			serviceChargeLabel.setBounds(360 + columnSpace, 230 + sectionSpace, 60, 13);
			frame.getContentPane().add(serviceChargeLabel);
			
			JLabel serviceChargeRes = new JLabel("$$$");
			serviceChargeRes.setBounds(420 + columnSpace, 230 + sectionSpace, 45, 13);
			frame.getContentPane().add(serviceChargeRes);
			
			serviceChargeRes.setText(ChargeBands.getServiceCharge(propid).toString() + "£");
			
			
			// STATUS PART
			
			JLabel statusLabel = new JLabel("Status :");
			statusLabel.setBounds(250 + columnSpace, 255 + sectionSpace, 50, 13);
			frame.getContentPane().add(statusLabel);
			
			JLabel statusRes = new JLabel("None");
			statusRes.setBounds(300 + columnSpace, 250 + sectionSpace, 100, 21);
			frame.getContentPane().add(statusRes);
			
			if(Properties.getBookedBy(propid).equals(this.guestID) && Properties.getBookedBy(propid) != null) {
				statusRes.setText("Accepted");
				Font a = new Font ("TimesRoman", Font.BOLD, 18);
				statusRes.setFont(a);
			}
			else if (Properties.getBookedBy(propid) != booking.get("requestedBy")) {
				statusRes.setText("Pending");
				Font a = new Font ("TimesRoman", Font.BOLD, 18);
				statusRes.setFont(a);
			}
			
			frame.setBounds(100, 20, 1301, 800);
			sectionSpace += 190;
			if(sectionSpace >= 570) {
				sectionSpace = 0;
				columnSpace += 610;
			}
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "Home") {
			GuestHomepage guest = new GuestHomepage(this.guestID);
			guest.frame.setVisible(true);
			frame.setVisible(false);
		}
		
	}
}
