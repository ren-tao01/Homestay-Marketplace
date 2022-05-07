package frontend;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.HashMap;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import backend.Bookings;
import backend.Guest;
import backend.Host;
import backend.Properties;

import java.awt.Color;
import javax.swing.JButton;

public class HostHomepage {

	JFrame frame;
	private JTable reqTable;
	private JTable reqTable2;
	private Host host;
	private static String hostID;
	private static String guestID;
	private static int propertyID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HostHomepage window = new HostHomepage("host2@test.co.uk");
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
	public HostHomepage(String hostID) {
		this.hostID = hostID;
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 635);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome! Here's your bookings!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(42, 33, 399, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Provisional Bookings");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(45, 110, 155, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 140, 590, 115);
		frame.getContentPane().add(scrollPane);
		
		DefaultTableModel tableModel = new DefaultTableModel();
		reqTable = new JTable(tableModel);
		reqTable.setForeground(Color.LIGHT_GRAY);
		reqTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tableModel.addColumn("Booking ID");
		tableModel.addColumn("Property ID");
		tableModel.addColumn("Property Name");
		tableModel.addColumn("Guest Details");
		
		reqTable.getColumnModel().getColumn(0).setPreferredWidth(40);
		reqTable.getColumnModel().getColumn(0).setMinWidth(20);
		reqTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		reqTable.getColumnModel().getColumn(1).setMinWidth(20);
		reqTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		reqTable.getColumnModel().getColumn(2).setMinWidth(20);
		reqTable.getColumnModel().getColumn(3).setPreferredWidth(100);
		reqTable.getColumnModel().getColumn(3).setMinWidth(20);
		
		List<Integer> listOfIDs = Properties.getHostsProperties(this.hostID);
		int rowCount = 0;
		for (int propid : listOfIDs) {
			String columnName = "propertyID";
			List <HashMap> listOfProperties = Properties.viewCertainProperties(columnName, Integer.toString(propid));
			// getting the details of the property
			HashMap oneProperty = listOfProperties.get(0);
			List <Integer> listOfBookings = Bookings.getBookingID("propertyID", String.valueOf(propid));
			
			for(int bookID : listOfBookings) {
				HashMap bookingDetail = Bookings.getBookingDetails(bookID);
				String g = String.valueOf(oneProperty.get("requestedBy"));
				String b = String.valueOf(bookingDetail.get("guestID"));
				if(g.equals(b)) {
					tableModel.insertRow(rowCount, new Object[] { 
							bookID , 
							propid,
							oneProperty.get("shortName") + 
								", " + oneProperty.get("houseName") + 
								", " + oneProperty.get("city"), 
							Guest.getFullName("email", String.valueOf(bookingDetail.get("guestID"))),
								
						});
						rowCount++;
				}
				
			}
			
			System.out.println(listOfBookings);
			
			
		} // end main for loop
		
		scrollPane.setViewportView(reqTable);
		
		JButton reqActionButton = new JButton("Accept / Reject A Booking");
		reqActionButton.setBounds(210, 265, 200, 30);
		frame.getContentPane().add(reqActionButton);
		
		String hostID = this.hostID;
		reqActionButton.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	        	AcceptReject2 actionWin = new AcceptReject2(hostID);
	        	actionWin.frame.setVisible(true);
	        	frame.setVisible(false);
	        }
	    });
		
		JLabel acceptedLabel = new JLabel("Accepted Bookings");
		acceptedLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		acceptedLabel.setBounds(44, 321, 155, 30);
		frame.getContentPane().add(acceptedLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(44, 353, 582, 111);
		frame.getContentPane().add(scrollPane_1);
		
		DefaultTableModel tableModel2 = new DefaultTableModel();
		JTable reqTable2 = new JTable(tableModel2);
		reqTable2.setForeground(Color.LIGHT_GRAY);
		reqTable2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tableModel2.addColumn("Property ID");
		tableModel2.addColumn("Property Name");
		tableModel2.addColumn("Guest Details");
		tableModel2.addColumn("Dates");
		
		reqTable2.getColumnModel().getColumn(0).setPreferredWidth(48);
		reqTable2.getColumnModel().getColumn(0).setMinWidth(20);
		reqTable2.getColumnModel().getColumn(1).setPreferredWidth(100);
		reqTable2.getColumnModel().getColumn(1).setMinWidth(20);
		reqTable2.getColumnModel().getColumn(2).setPreferredWidth(100);
		reqTable2.getColumnModel().getColumn(2).setMinWidth(20);
		reqTable2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		int rowCount2 = 0;
		for (int id : listOfIDs) {
			String columnName = "propertyID";
			List <HashMap> listOfProperties = Properties.viewCertainProperties(columnName, Integer.toString(id));
			HashMap oneProperty = listOfProperties.get(0);
			
			
			int gInt = (oneProperty.get("bookedBy")).toString().length();
			if (gInt != 0 ) {
					String guestid = oneProperty.get("bookedBy").toString();
					HashMap dates = Bookings.getSelectedBookingDates(id, guestid);
					System.out.println("THE DATES ARE " + dates);
					tableModel2.insertRow(rowCount2, new Object[] { 
						id , 
						oneProperty.get("shortName") + 
							", " + oneProperty.get("houseName") + 
							", " + oneProperty.get("city"), 
						Guest.getFullName("email", guestid),
						dates.get("startDate"),
									
					});
					rowCount2++;
			}
		} // end main for loop
		scrollPane_1.setViewportView(reqTable2);
		
		JButton btnNewButton1 = new JButton("View Guest Details");
		btnNewButton1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton1.setBounds(223, 465, 180, 25);
		frame.getContentPane().add(btnNewButton1);
		btnNewButton1.addActionListener(e -> {

        	HostRequestViewGuestDetails h = new HostRequestViewGuestDetails(hostID,propertyID);
        	h.frame.setVisible(true);
        	 frame.dispose();
	      });
		
		JButton btnNewButton = new JButton("View Listed Properties");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(43, 502, 220, 30);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(e -> {

        	PropertyList propertylist = new PropertyList(hostID);
        	propertylist.frame.setVisible(true);
        	 frame.dispose();
	      });
		
		JButton btnListAProperty = new JButton("List A Property");
		btnListAProperty.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnListAProperty.setBounds(300, 502, 220, 30);
		frame.getContentPane().add(btnListAProperty);
		btnListAProperty.addActionListener(e -> {

        	PropertyList propertylist = new PropertyList(hostID);
        	propertylist.frame.setVisible(true);
        	 frame.dispose();
	      });

		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogout.setBounds(44, 558, 130, 30);
		frame.getContentPane().add(btnLogout);
	    btnLogout.addActionListener(e -> {
	    	Login logout = new Login();
        	logout.frame.setVisible(true);
        	frame.dispose();
	      });
	    
		JButton readReview = new JButton("Read reviews");
		readReview.setFont(new Font("Tahoma", Font.BOLD, 15));
		readReview.setBounds(200, 558, 160, 30);
		frame.getContentPane().add(readReview);
		readReview.addActionListener(e -> {
	    	ReadReview review = new ReadReview(hostID);
        	review.frame.setVisible(true);
        	frame.dispose();
	      });

	}
}
