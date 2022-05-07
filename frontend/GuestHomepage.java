package frontend;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.SpringLayout;

import backend.ChargeBands;
import backend.Guest;
import backend.Properties;
import frontend.WriteReview;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;

public class GuestHomepage implements ActionListener {


	JFrame frame;
	//private JFrame frame;
	private JTextField textField;
	private JTextField searchTextInput;

	private Guest guest;
	
	private static String guestID;
	private static int propertyID;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestHomepage window = new GuestHomepage("guest2@test.co.uk");
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}

	/**
	 * Create the application.
	 */
	public GuestHomepage(String guestID) {
		this.guestID = guestID;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println("THE GUEST IS " + this.guestID);
		setFrame(new JFrame());
		getFrame().setBounds(100, 20, 1300, 800);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getFrame().getContentPane().setLayout(null);
		
		JButton homeButton = new JButton("Home");
		homeButton.setBounds(10, 10, 90, 21);
		getFrame().getContentPane().add(homeButton);
		
		JButton bookingsButton = new JButton("Bookings");
		bookingsButton.setBounds(120, 10, 90, 21);
		getFrame().getContentPane().add(bookingsButton);
		
		JButton reivewButton = new JButton("Write a review");
		reivewButton.setBounds(230, 10, 160, 21);
		frame.getContentPane().add(reivewButton);
		
		JLabel searchLabel = new JLabel("Search :");
		searchLabel.setBounds(64, 45, 60, 13);
		getFrame().getContentPane().add(searchLabel);
		
		searchTextInput = new JTextField();
		searchTextInput.setBounds(121, 42, 315, 19);
		searchTextInput.setColumns(10);
		getFrame().getContentPane().add(searchTextInput);
		
		JLabel startDateLabel = new JLabel("Start date :");
		startDateLabel.setBounds(445, 45, 70, 13);
		getFrame().getContentPane().add(startDateLabel);
		
		JTextField sDateTextInput = new JTextField();
		sDateTextInput.setBounds(515, 42, 75, 19);
		sDateTextInput.setColumns(10);
		getFrame().getContentPane().add(sDateTextInput);
		
		JLabel endDateLabel = new JLabel("End date :");
		endDateLabel.setBounds(595, 45, 60, 13);
		getFrame().getContentPane().add(endDateLabel);
		
		JTextField eDateTextInput = new JTextField();
		eDateTextInput.setBounds(655, 42, 75, 19);
		eDateTextInput.setColumns(10);
		getFrame().getContentPane().add(eDateTextInput);
		
		JLabel text = new JLabel("Date Format: yyyy-mm-dd");
		text.setBounds(445, 65, 200, 13);
		getFrame().getContentPane().add(text);
		
		JButton searchButton = new JButton("GO");
		searchButton.setBounds(750, 41, 60, 21);
		getFrame().getContentPane().add(searchButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(830, 41, 85, 21);
		getFrame().getContentPane().add(clearButton);
		
		
		
		homeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("At Homepage");
			}
		});
		
		JButton rating = new JButton("View Property Rating");
		rating.setFont(new Font("Tahoma", Font.BOLD, 12));
		rating.setBounds(430, 11, 200, 21);
		frame.getContentPane().add(rating);
		rating.addActionListener(e -> {
	    	RequestPropertyRating review = new RequestPropertyRating(propertyID);
        	review.frame.setVisible(true);
	      });
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogout.setBounds(690, 11, 100, 21);
		frame.getContentPane().add(btnLogout);
		
		//add action listener for register now button
		btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (evt.getSource()==btnLogout) {
                	
                	Login logout = new Login();
                	logout.frame.setVisible(true);
                	 frame.dispose();
                }
            }
        });
		
		String guestID = this.guestID;
		
		reivewButton.addActionListener(this);
		
		searchButton.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// TODO Auto-generated method stub
				String searchItems = searchTextInput.getText();
				
				String columnName = "city";
				List <HashMap> listOfProperties = Properties.viewCertainProperties(columnName, searchItems);
				
				int sectionSpace = 0;
				int columnSpace = 0;
				Date startD = null;
				String inputStart = sDateTextInput.getText();
				String inputEnd = eDateTextInput.getText();
				
				List <HashMap> validProps = new ArrayList();
				List <Integer> allValidPropsID =  new ArrayList();
				
				if(inputStart != "" && inputEnd != "") {
					for(HashMap items : listOfProperties) {
						int id = Integer.valueOf(items.get("propertyID").toString());
					
						System.out.println(String.valueOf(ChargeBands.getStartDate(id)));
					
						String propStart = String.valueOf(ChargeBands.getStartDate(id));
						String propEnd = String.valueOf(ChargeBands.getEndDate(id));
						
						if(propStart != "null" && propEnd != "null") {
							if(periodIsBetween(inputStart, inputEnd, propStart, propEnd)) {
								validProps.add(items);
								allValidPropsID.add(id);
							}
						}
					
					}
				}
				System.out.println("filtered properties" + validProps);
				
				for(HashMap items : validProps) {
//					items.get(e);
					int id = Integer.valueOf(items.get("propertyID").toString());
					
					JLabel idLabel = new JLabel("Property ID : " + id);
					idLabel.setBounds(110 + columnSpace, 70 + sectionSpace, 150, 13);
					getFrame().getContentPane().add(idLabel);
					
					JLabel locationLabel = new JLabel("Location :");
					locationLabel.setBounds(110 + columnSpace, 84 + sectionSpace, 60, 13);
					getFrame().getContentPane().add(locationLabel);
					
					JLabel locationRes = new JLabel("Location ...");
					locationRes.setBounds(170 + columnSpace, 84 + sectionSpace, 265, 13);
					String displayLocation = (String) items.get("street") + ", "
											+ (String) items.get("postcode") + " "
											+ (String) items.get("city");
					locationRes.setText(displayLocation);
					getFrame().getContentPane().add(locationRes);
					
					System.out.println("Searching ....");
					
					JLabel descriptionLabel = new JLabel("Description :");
					descriptionLabel.setBounds(108 + columnSpace, 105 + sectionSpace, 80, 13);
					getFrame().getContentPane().add(descriptionLabel);
					
					JTextArea descriptionArea = new JTextArea();
					descriptionArea.setBounds(195 + columnSpace, 105 + sectionSpace, 386, 35);
					descriptionArea.setText((String) items.get("information"));
					getFrame().getContentPane().add(descriptionArea);
					
					
					JLabel sleepingFac = new JLabel("Sleeping facility :");
					sleepingFac.setBounds(110 + columnSpace, 155 + sectionSpace, 100, 13);
					getFrame().getContentPane().add(sleepingFac);
					
					JLabel sleepingAns = new JLabel("Empty");
					sleepingAns.setBounds(230 + columnSpace, 155 + sectionSpace, 45, 13);
					if(Properties.hasSleeping(id)) {
						sleepingAns.setText("Yes");
					}
					getFrame().getContentPane().add(sleepingAns);
					
					JLabel bathingFac = new JLabel("Bathing facility :");
					bathingFac.setBounds(110 + columnSpace, 175 + sectionSpace, 100, 13);
					getFrame().getContentPane().add(bathingFac);
					
					JLabel bathingAns = new JLabel("Empty");
					bathingAns.setBounds(230 + columnSpace, 175 + sectionSpace, 45, 13);
					if(Properties.hasBathing(id)){
						bathingAns.setText("Yes");
					}
					getFrame().getContentPane().add(bathingAns);
					
					JLabel kitchenFac = new JLabel("Kitchen :");
					kitchenFac.setBounds(110 + columnSpace, 195 + sectionSpace, 100, 13);
					getFrame().getContentPane().add(kitchenFac);
					
					JLabel kitchenAns = new JLabel("Empty");
					kitchenAns.setBounds(230 + columnSpace, 195 + sectionSpace, 45, 13);
					if(Properties.hasKitchen(id)){
						kitchenAns.setText("Yes");
					}
					getFrame().getContentPane().add(kitchenAns);
					
					JLabel livingFac = new JLabel("Living room :");
					livingFac.setBounds(300 + columnSpace, 155 + sectionSpace, 100, 13);
					getFrame().getContentPane().add(livingFac);
					
					JLabel livingAns = new JLabel("Empty");
					livingAns.setBounds(420 + columnSpace, 155 + sectionSpace, 45, 13);
					if(Properties.hasLiving(id)){
						livingAns.setText("Yes");
					}
					getFrame().getContentPane().add(livingAns);
					
					JLabel utilityFac = new JLabel("Utility :");
					utilityFac.setBounds(300 + columnSpace, 175 + sectionSpace, 100, 13);
					getFrame().getContentPane().add(utilityFac);
					
					JLabel utilityAns = new JLabel("Empty");
					utilityAns.setBounds(420 + columnSpace, 175 + sectionSpace, 45, 13);
					if(Properties.hasUtility(id)){
						utilityAns.setText("Yes");
					}
					getFrame().getContentPane().add(utilityAns);
					
					JLabel outdoorFac = new JLabel("Outdoor :");
					outdoorFac.setBounds(300 + columnSpace, 195 + sectionSpace, 100, 13);
					getFrame().getContentPane().add(outdoorFac);
					
					JLabel outdoorAns = new JLabel("Empty");
					outdoorAns.setBounds(420 + columnSpace, 195 + sectionSpace, 45, 13);
					if(Properties.hasOutdoor(id)){
						outdoorAns.setText("Yes");
					}
					getFrame().getContentPane().add(outdoorAns);
					
					JLabel pricePerNightLabel = new JLabel("Price Per Night :");
					pricePerNightLabel.setBounds(110 + columnSpace, 215 + sectionSpace, 95, 13);
					getFrame().getContentPane().add(pricePerNightLabel);
					
					JLabel pricePerNightRes = new JLabel("$$$");
					pricePerNightRes.setBounds(205 + columnSpace, 215 + sectionSpace, 45, 13);
					getFrame().getContentPane().add(pricePerNightRes);
					
					pricePerNightRes.setText(ChargeBands.getPricePerNight(id).toString() + "£");
					
					JLabel cleaningChargeLabel = new JLabel("Cleaning :");
					cleaningChargeLabel.setBounds(255 + columnSpace, 215 + sectionSpace, 60, 13);
					getFrame().getContentPane().add(cleaningChargeLabel);
					
					JLabel cleaningChargeRes = new JLabel("$$$");
					cleaningChargeRes.setBounds(315 + columnSpace, 215 + sectionSpace, 45, 13);
					getFrame().getContentPane().add(cleaningChargeRes);
					
					cleaningChargeRes.setText(ChargeBands.getCleaningCharge(id).toString() + "£");
					
					JLabel serviceChargeLabel = new JLabel("Service :");
					serviceChargeLabel.setBounds(360 + columnSpace, 215 + sectionSpace, 60, 13);
					getFrame().getContentPane().add(serviceChargeLabel);
					
					JLabel serviceChargeRes = new JLabel("$$$");
					serviceChargeRes.setBounds(420 + columnSpace, 215 + sectionSpace, 45, 13);
					getFrame().getContentPane().add(serviceChargeRes);
					
					serviceChargeRes.setText(ChargeBands.getServiceCharge(id).toString() + "£");
					
//					JButton detailsButton = new JButton("More Details");
//					detailsButton.setBounds(470 + columnSpace, 215 + sectionSpace, 140, 15);
//					getFrame().getContentPane().add(detailsButton);
//					
//					detailsButton.addActionListener(new java.awt.event.ActionListener() {
//						@Override
//						public void actionPerformed(java.awt.event.ActionEvent e) {
//							System.out.println("this is working");
//						}
//					});
					
					sectionSpace += 175;
					getFrame().setBounds(100, 20, 1301, 800);
					
					if(sectionSpace >= 700) {
						sectionSpace = 0;
						columnSpace += 610;
					}
					
				} // end for loop
				
				String guestid = guestID;
				if(validProps.size() > 0) {
//					JButton pdetailsButton = new JButton("Details");
//					pdetailsButton.setBounds(180, 50 + sectionSpace, 80, 21);
//					frame.getContentPane().add(pdetailsButton);
					
					JButton requestButton = new JButton("Request Booking");
					requestButton.setBounds(475, 650, 250, 21);
					getFrame().getContentPane().add(requestButton);
					requestButton.addActionListener(new java.awt.event.ActionListener() {
						@Override
						public void actionPerformed(java.awt.event.ActionEvent evt) {
							GuestRequest guestReq = new GuestRequest(guestid, allValidPropsID, inputStart, inputEnd);
							guestReq.getFrame().setVisible(true);
						}
						
					});
				}
				
				JButton request2Button = new JButton("View Detailed Facility");
				request2Button.setBounds(475, 700, 250, 21);
				getFrame().getContentPane().add(request2Button);
				request2Button.addActionListener(new java.awt.event.ActionListener() {

					@Override
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						GuestRequestFacility guestReq = new GuestRequestFacility(guestID,propertyID);
						guestReq.frame.setVisible(true);
						frame.dispose();
					}
					
				});
				
				// still in search button eventListener
					
//				
//				pdetailsButton.addActionListener(new java.awt.event.ActionListener() {
//
//					@Override
//					public void actionPerformed(java.awt.event.ActionEvent e) {
//						// TODO Auto-generated method stub
//					}
//				});
//				
				
			}
		}); // end searchButton event
		
		bookingsButton.addActionListener(this);
		clearButton.addActionListener(this);
//		
	}
	
	public boolean periodIsBetween(String inputStart, String inputEnd, String propStart, String propEnd) {
		System.out.println("Start date is " + inputStart);
		String[] inputSDate = inputStart.split("-");
		String[] inputEDate = inputEnd.split("-");

		String[] propSDate = propStart.split("-");
		String[] propEDate = propEnd.split("-");
		
		// 0 - year, 1 - month, 2 - day
		int inputSYear = Integer.valueOf(inputSDate[0]);
		int propSYear = Integer.valueOf(propSDate[0]);
		
		int inputSMon = Integer.valueOf(inputSDate[1]);
		int propSMon = Integer.valueOf(propSDate[1]);
		
		int inputSDay = Integer.valueOf(inputSDate[2]);
		int propSDay = Integer.valueOf(propSDate[2]);
		
		int inputEYear = Integer.valueOf(inputEDate[0]);
		int propEYear = Integer.valueOf(propEDate[0]);
		
		int inputEMon = Integer.valueOf(inputEDate[1]);
		int propEMon = Integer.valueOf(propEDate[1]);
		
		int inputEDay = Integer.valueOf(inputEDate[2]);
		int propEDay = Integer.valueOf(propEDate[2]);
		
		if(inputSYear >= propSYear && inputEYear <= propEYear && inputSYear == inputEYear) {
			if(inputSMon >= propSMon && inputEMon <= propEMon) {
				if(inputSDay >= propSDay && inputEDay <= propEDay) {
					return true;
				} else return false;
			} else return false;
		} 
		else if(inputSYear >= propSYear && inputEYear <= propEYear && inputSYear < inputEYear) {
			return true;
		}
		else return false;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		
		if(e.getActionCommand() == "Bookings") {
			GuestBookings gb = new GuestBookings(this.guestID);
			gb.frame.setVisible(true);
			getFrame().setVisible(false);
			 frame.dispose();
		}
		
		if(e.getActionCommand() == "Write a review") {
			WriteReview writereview = new WriteReview(guestID);
        	writereview.setVisible(true);
        	frame.dispose();
		}
		
		if(e.getActionCommand() == "Clear") {
			getFrame().getContentPane().removeAll();
			GuestHomepage restart = new GuestHomepage(this.guestID);
			restart.getFrame().setVisible(true);
			getFrame().setVisible(false);
		}
		
		
	}
	

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	
}
