package frontend;
import backend.Kitchen;
import backend.Living;
import backend.Outdoor;
import backend.Sleeping;
import backend.Utility;
import backend.Bathing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

public class FacilityDetails {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private static int propertyID;	
	private static String hostID;	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacilityDetails window = new FacilityDetails(hostID,propertyID);
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
	public FacilityDetails(String hostID,int propertyID) {
		this.hostID = hostID;
		this.propertyID = propertyID;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(10, 10, 1184, 928);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Property Facility");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(38, 33, 168, 27);
		frame.getContentPane().add(lblNewLabel);
		
		//--------Sleeping Facility -------------------------------------------------------------------------
		//--------Sleeping Facility -------------------------------------------------------------------------
		
		JLabel lblSleepingFacility = new JLabel("Sleeping Facility");
		lblSleepingFacility.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSleepingFacility.setBounds(56, 111, 136, 27);
		frame.getContentPane().add(lblSleepingFacility);
		
		JLabel lblNewLabel_1 = new JLabel("Bed Linen");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(56, 148, 87, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		JCheckBox s1 = new JCheckBox("New check box");
		s1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		s1.setBounds(149, 147, 127, 21);
		frame.getContentPane().add(s1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Towel");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(56, 177, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JCheckBox s2 = new JCheckBox("New check box");
		s2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		s2.setBounds(149, 176, 127, 21);
		frame.getContentPane().add(s2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Single Bed");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(333, 181, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Double Bed");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_1.setBounds(333, 210, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_3_1);
		
		JCheckBox s3 = new JCheckBox("New check box");
		s3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		s3.setBounds(431, 180, 127, 21);
		frame.getContentPane().add(s3);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("King Size Bed");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_1_1.setBounds(333, 239, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_3_1_1);
		
		JLabel lblNewLabel_1_3_1_2 = new JLabel("Bunk Bed");
		lblNewLabel_1_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_1_2.setBounds(333, 268, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_3_1_2);
		
		JCheckBox s4 = new JCheckBox("New check box");
		s4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		s4.setBounds(430, 210, 127, 21);
		frame.getContentPane().add(s4);
		
		JCheckBox s5 = new JCheckBox("New check box");
		s5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		s5.setBounds(430, 239, 127, 21);
		frame.getContentPane().add(s5);
		
		JCheckBox s6 = new JCheckBox("New check box");
		s6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		s6.setBounds(430, 268, 127, 21);
		frame.getContentPane().add(s6);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(38, 98, 542, 244);
		frame.getContentPane().add(textArea);

		// to print the facility that are in the database
		if (Sleeping.getBedLinen(propertyID)==true) {
			s1.setSelected(true);
		}	
		if (Sleeping.getTowels(propertyID)==true) {
			s2.setSelected(true);
		}	
		if (Sleeping.getSingleBed(propertyID)==true) {
			s3.setSelected(true);
		}	
		if (Sleeping.getDoubleBed(propertyID)==true) {
			s4.setSelected(true);
		}	
		if (Sleeping.getKingSizedBed(propertyID)==true) {
			s5.setSelected(true);
		}	
		if (Sleeping.getBunkBed(propertyID)==true) {
			s6.setSelected(true);
		}	
				
		//--------Bathing Facility -------------------------------------------------------------------------
		//--------Bathing Facility ------------------------------------------------------------------------
		
		JLabel lblBathingFacility = new JLabel("Bathing Facility");
		lblBathingFacility.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBathingFacility.setBounds(56, 388, 136, 27);
		frame.getContentPane().add(lblBathingFacility);
		
		JLabel lblNewLabel_1_4 = new JLabel("Hair Dryer");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4.setBounds(56, 426, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Shampoo");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_5.setBounds(56, 455, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Toilet Paper");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_6.setBounds(56, 484, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_6);
		
		JCheckBox b1 = new JCheckBox("New check box");
		b1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		b1.setBounds(130, 426, 127, 21);
		frame.getContentPane().add(b1);
		
		JCheckBox b2 = new JCheckBox("New check box");
		b2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		b2.setBounds(130, 454, 127, 21);
		frame.getContentPane().add(b2);
		
		JCheckBox b3 = new JCheckBox("New check box");
		b3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		b3.setBounds(130, 483, 127, 21);
		frame.getContentPane().add(b3);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Toilet");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_2.setBounds(333, 455, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_3_2);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("Bath");
		lblNewLabel_1_3_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_3.setBounds(331, 484, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_3_3);
		
		JLabel lblNewLabel_1_3_4 = new JLabel("Shower");
		lblNewLabel_1_3_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_4.setBounds(331, 513, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_3_4);
		
		JLabel lblNewLabel_1_3_5 = new JLabel("Share With Host");
		lblNewLabel_1_3_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_5.setBounds(333, 542, 109, 19);
		frame.getContentPane().add(lblNewLabel_1_3_5);
		
		JCheckBox b4 = new JCheckBox("New check box");
		b4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		b4.setBounds(388, 455, 127, 21);
		frame.getContentPane().add(b4);
		
		JCheckBox b5 = new JCheckBox("New check box");
		b5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		b5.setBounds(388, 484, 127, 21);
		frame.getContentPane().add(b5);
		
		JCheckBox b6 = new JCheckBox("New check box");
		b6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		b6.setBounds(388, 514, 127, 21);
		frame.getContentPane().add(b6);
		
		JCheckBox b7 = new JCheckBox("New check box");
		b7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		b7.setBounds(448, 542, 127, 21);
		frame.getContentPane().add(b7);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(38, 371, 542, 239);
		frame.getContentPane().add(textArea_1);
		
		// to print the facility that are in the database
		if (Bathing.getHairDryer(propertyID)==true) {
			b1.setSelected(true);
		}
		if (Bathing.getShampoo(propertyID)==true) {
			b2.setSelected(true);
		}	
		if (Bathing.getToiletPaper(propertyID)==true) {
			b3.setSelected(true);
		}	
		if (Bathing.getToilet(propertyID)==true) {
			b4.setSelected(true);
		}	
		if (Bathing.getBath(propertyID)==true) {
			b5.setSelected(true);
		}	
		if (Bathing.getShower(propertyID)==true) {
			b6.setSelected(true);
		}	
		if (Bathing.getShareWithHost(propertyID)==true) {
			b7.setSelected(true);
		}	
		
		//--------Living Facility -------------------------------------------------------------------------
		//--------Living Facility -------------------------------------------------------------------------
			
		JLabel lblSleepingFacility_1 = new JLabel("Living Facility");
		lblSleepingFacility_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSleepingFacility_1.setBounds(654, 111, 136, 27);
		frame.getContentPane().add(lblSleepingFacility_1);
		
		JLabel lblNewLabel_1_7 = new JLabel("Wifi");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_7.setBounds(654, 148, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_7_1 = new JLabel("Television");
		lblNewLabel_1_7_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_7_1.setBounds(654, 177, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_7_1);
		
		JLabel lblNewLabel_1_7_2 = new JLabel("Satellite");
		lblNewLabel_1_7_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_7_2.setBounds(654, 210, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_7_2);
		
		JCheckBox l1 = new JCheckBox("New check box");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l1.setBounds(724, 148, 127, 21);
		frame.getContentPane().add(l1);
		
		JCheckBox l2 = new JCheckBox("New check box");
	    l2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l2.setBounds(724, 177, 127, 21);
		frame.getContentPane().add(l2);
		
		JCheckBox l3 = new JCheckBox("New check box");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l3.setBounds(724, 208, 127, 21);
		frame.getContentPane().add(l3);
		
		JLabel lblNewLabel_1_7_3 = new JLabel("Streaming");
		lblNewLabel_1_7_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_7_3.setBounds(873, 147, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_7_3);
		
		JLabel lblNewLabel_1_7_4 = new JLabel("DVD Player");
		lblNewLabel_1_7_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_7_4.setBounds(873, 177, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_7_4);
		
		JLabel lblNewLabel_1_7_5 = new JLabel("Board Games");
		lblNewLabel_1_7_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_7_5.setBounds(873, 210, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_7_5);
		
		JCheckBox l4 = new JCheckBox("New check box");
		l4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l4.setBounds(963, 147, 127, 21);
		frame.getContentPane().add(l4);
		
		JCheckBox l5 = new JCheckBox("New check box");
		l5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l5.setBounds(963, 177, 127, 21);
		frame.getContentPane().add(l5);
		
		JCheckBox l6 = new JCheckBox("New check box");
		l6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l6.setBounds(963, 208, 127, 21);
		frame.getContentPane().add(l6);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(632, 98, 485, 156);
		frame.getContentPane().add(textArea_2);
		
		// to print the facility that are in the database
		if (Living.getWifi(propertyID)==true) {
			l1.setSelected(true);
		}
		if (Living.getTelevision(propertyID)==true) {
			l2.setSelected(true);
		}
		if (Living.getSatellite(propertyID)==true) {
			l3.setSelected(true);
		}
		if (Living.getStreaming(propertyID)==true) {
			l4.setSelected(true);
		}
		if (Living.getDvdPlayer(propertyID)==true) {
			l5.setSelected(true);
		}
		if (Living.getBoardGames(propertyID)==true) {
			l6.setSelected(true);
		}
		
	
		//--------Utility Facility -------------------------------------------------------------------------
		//--------Utility Facility -------------------------------------------------------------------------
		
		JLabel lblSleepingFacility_1_1 = new JLabel("Utility Facility");
		lblSleepingFacility_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSleepingFacility_1_1.setBounds(654, 305, 136, 27);
		frame.getContentPane().add(lblSleepingFacility_1_1);
		
		JLabel lblNewLabel_1_7_6 = new JLabel("Central Heating");
		lblNewLabel_1_7_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_7_6.setBounds(654, 342, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_7_6);
		
		JLabel lblNewLabel_1_7_7 = new JLabel("Washing Machine");
		lblNewLabel_1_7_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_7_7.setBounds(654, 373, 109, 19);
		frame.getContentPane().add(lblNewLabel_1_7_7);
		
		JCheckBox u1 = new JCheckBox("New check box");
		u1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		u1.setBounds(762, 341, 127, 21);
		frame.getContentPane().add(u1);
		
		JCheckBox u2 = new JCheckBox("New check box");
		u2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		u2.setBounds(762, 372, 127, 21);
		frame.getContentPane().add(u2);
		
		JCheckBox u3 = new JCheckBox("New check box");
		u3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		u3.setBounds(762, 406, 127, 21);
		frame.getContentPane().add(u3);
		
		JLabel lblNewLabel_1_7_7_1 = new JLabel("Drying Machine");
		lblNewLabel_1_7_7_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_7_7_1.setBounds(654, 407, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_7_7_1);
		
		JLabel lblNewLabel_1_7_6_1 = new JLabel("Fire Extinguisher");
		lblNewLabel_1_7_6_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_7_6_1.setBounds(895, 342, 115, 19);
		frame.getContentPane().add(lblNewLabel_1_7_6_1);
		
		JLabel lblNewLabel_1_7_6_2 = new JLabel("Smoke Alarm");
		lblNewLabel_1_7_6_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_7_6_2.setBounds(895, 373, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_7_6_2);
		
		JLabel lblNewLabel_1_7_6_3 = new JLabel("First Aid Kit");
		lblNewLabel_1_7_6_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_7_6_3.setBounds(895, 407, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_7_6_3);
		
		JCheckBox u4 = new JCheckBox("New check box");
		u4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		u4.setBounds(999, 342, 127, 21);
		frame.getContentPane().add(u4);
		
		JCheckBox u5 = new JCheckBox("New check box");
		u5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		u5.setBounds(999, 373, 127, 21);
		frame.getContentPane().add(u5);
		
		JCheckBox u6 = new JCheckBox("New check box");
		u6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		u6.setBounds(999, 407, 127, 21);
		frame.getContentPane().add(u6);
		
		JTextArea textArea_2_1 = new JTextArea();
		textArea_2_1.setBounds(632, 288, 516, 157);
		frame.getContentPane().add(textArea_2_1);
		
		// to print the facility that are in the database
		if (Utility.getCentralHeating(propertyID)==true) {
			u1.setSelected(true);
		}	
		if (Utility.getWashingMachine(propertyID)==true) {
			u2.setSelected(true);
		}
		if (Utility.getDryingMachine(propertyID)==true) {
			u3.setSelected(true);
		}	
		if (Utility.getFireExtinguisher(propertyID)==true) {
			u4.setSelected(true);
		}	
		if (Utility.getSmokeAlarm(propertyID)==true) {
			u5.setSelected(true);
		}	
		if (Utility.getFirstAidKit(propertyID)==true) {
			u6.setSelected(true);
		}	
		
		
		//--------Outdoor Facility -------------------------------------------------------------------------
		//--------Outdoor Facility -------------------------------------------------------------------------
		
		JLabel lblSleepingFacility_1_1_1 = new JLabel("Outdoor Facility");
		lblSleepingFacility_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSleepingFacility_1_1_1.setBounds(654, 497, 136, 27);
		frame.getContentPane().add(lblSleepingFacility_1_1_1);
		
		JLabel lblNewLabel_1_7_6_4 = new JLabel("Free On-Site Parking");
		lblNewLabel_1_7_6_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_7_6_4.setBounds(654, 546, 127, 19);
		frame.getContentPane().add(lblNewLabel_1_7_6_4);
		
		JLabel lblNewLabel_1_7_6_4_1 = new JLabel("On-Road Parking");
		lblNewLabel_1_7_6_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_7_6_4_1.setBounds(654, 575, 127, 19);
		frame.getContentPane().add(lblNewLabel_1_7_6_4_1);
		
		JLabel lblNewLabel_1_7_6_4_5 = new JLabel("Paid Car Park");
		lblNewLabel_1_7_6_4_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_7_6_4_5.setBounds(654, 600, 127, 19);
		frame.getContentPane().add(lblNewLabel_1_7_6_4_5);
		
		JCheckBox o1 = new JCheckBox("New check box");
		o1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		o1.setBounds(787, 546, 127, 21);
		frame.getContentPane().add(o1);
		
		JCheckBox o2 = new JCheckBox("New check box");
		o2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		o2.setBounds(787, 572, 127, 21);
		frame.getContentPane().add(o2);
		
		JCheckBox o3 = new JCheckBox("New check box");
		o3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		o3.setBounds(787, 600, 127, 21);
		frame.getContentPane().add(o3);
		
		JLabel lblNewLabel_1_7_6_4_2 = new JLabel("Patio");
		lblNewLabel_1_7_6_4_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_7_6_4_2.setBounds(924, 544, 127, 19);
		frame.getContentPane().add(lblNewLabel_1_7_6_4_2);
		
		JLabel lblNewLabel_1_7_6_4_3 = new JLabel("Barbeques");
		lblNewLabel_1_7_6_4_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_7_6_4_3.setBounds(920, 572, 99, 19);
		frame.getContentPane().add(lblNewLabel_1_7_6_4_3);
		
		JCheckBox o4= new JCheckBox("New check box");
		o4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		o4.setBounds(999, 545, 127, 21);
		frame.getContentPane().add(o4);
		
		JCheckBox o5 = new JCheckBox("New check box");
		o5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		o5.setBounds(999, 571, 127, 21);
		frame.getContentPane().add(o5);
		
		JTextArea textArea_2_1_1 = new JTextArea();
		textArea_2_1_1.setBounds(632, 482, 516, 142);
		frame.getContentPane().add(textArea_2_1_1);
		
		// to print the facility that are in the database
		if (Outdoor.getFreeOnSiteParking(propertyID)==true) {
			o1.setSelected(true);
		}	
		if (Outdoor.getOnRoadParking(propertyID)==true) {
			o2.setSelected(true);
		}	
		if (Outdoor.getPaidCarPark(propertyID)==true) {
			o3.setSelected(true);
		}	
		if (Outdoor.getPatio(propertyID)==true) {
			o4.setSelected(true);
		}	
		if (Outdoor.getBarbeque(propertyID)==true) {
			o5.setSelected(true);
		}	

		
	//--------Kitchen Facility -------------------------------------------------------------------------
	//--------Kitchen Facility -------------------------------------------------------------------------
		
		JLabel lblSleepingFacility_1_1_1_1 = new JLabel("Kitchen Facility");
		lblSleepingFacility_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSleepingFacility_1_1_1_1.setBounds(56, 678, 136, 27);
		frame.getContentPane().add(lblSleepingFacility_1_1_1_1);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Refrigerator");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_1.setBounds(56, 715, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Microwave");
		lblNewLabel_1_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_1_1.setBounds(56, 749, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_4_1_1);
		
		JLabel lblNewLabel_1_4_1_2 = new JLabel("Oven");
		lblNewLabel_1_4_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_1_2.setBounds(56, 785, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_4_1_2);
		
		JLabel lblNewLabel_1_4_1_3 = new JLabel("Stove");
		lblNewLabel_1_4_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_1_3.setBounds(56, 816, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_4_1_3);
		
		JCheckBox k1 = new JCheckBox("New check box");
		k1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		k1.setBounds(149, 715, 127, 21);
		frame.getContentPane().add(k1);
		
		JCheckBox k2 = new JCheckBox("New check box");
		k2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		k2.setBounds(149, 749, 127, 21);
		frame.getContentPane().add(k2);
		
		JCheckBox k3 = new JCheckBox("New check box");
		k3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		k3.setBounds(149, 785, 127, 21);
		frame.getContentPane().add(k3);
		
		JCheckBox k4 = new JCheckBox("New check box");
		k4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		k4.setBounds(149, 816, 127, 21);
		frame.getContentPane().add(k4);
		
		JLabel lblNewLabel_1_4_1_4 = new JLabel("Dishwasher");
		lblNewLabel_1_4_1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_1_4.setBounds(344, 715, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_4_1_4);
		
		JLabel lblNewLabel_1_4_1_4_1 = new JLabel("Tableware");
		lblNewLabel_1_4_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_1_4_1.setBounds(344, 749, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_4_1_4_1);
		
		JLabel lblNewLabel_1_4_1_4_2 = new JLabel("Cookware");
		lblNewLabel_1_4_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_1_4_2.setBounds(344, 785, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_4_1_4_2);
		
		JLabel lblNewLabel_1_4_1_4_3 = new JLabel("Basic Provision");
		lblNewLabel_1_4_1_4_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_1_4_3.setBounds(344, 816, 87, 19);
		frame.getContentPane().add(lblNewLabel_1_4_1_4_3);
		
		JCheckBox k5 = new JCheckBox("New check box");
		k5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		k5.setBounds(453, 715, 127, 21);
		frame.getContentPane().add(k5);
		
		JCheckBox k6 = new JCheckBox("New check box");
		k6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		k6.setBounds(453, 749, 127, 21);
		frame.getContentPane().add(k6);
		
		JCheckBox k7 = new JCheckBox("New check box");
		k7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		k7.setBounds(453, 785, 127, 21);
		frame.getContentPane().add(k7);
		
		JCheckBox k8 = new JCheckBox("New check box");
		k8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		k8.setBounds(453, 816, 127, 21);
		frame.getContentPane().add(k8);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setBounds(38, 661, 583, 184);
		frame.getContentPane().add(textArea_1_1);
		
		// to print the facility that are in the database
		if (Kitchen.getRefrigerator(propertyID)==true) {
			k1.setSelected(true);
		}
		if (Kitchen.getMicrowave(propertyID)==true) {
			k2.setSelected(true);
		}
		if (Kitchen.getOven(propertyID)==true) {
			k3.setSelected(true);
		}
		if (Kitchen.getStove(propertyID)==true) {
			k4.setSelected(true);
		}
		if (Kitchen.getDishwasher(propertyID)==true) {
			k5.setSelected(true);
		}
		if (Kitchen.getTableware(propertyID)==true) {
			k6.setSelected(true);
		}
		if (Kitchen.getCookware(propertyID)==true) {
			k7.setSelected(true);
		}
		if (Kitchen.getBasicProvisions(propertyID)==true) {
			k8.setSelected(true);
		}
		
		JButton btnNewButton_1 = new JButton("Update Facility");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(672, 749, 168, 38);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (evt.getSource()==btnNewButton_1) {
                	
        			try {
						JOptionPane.showMessageDialog(null, "Updating....");
        				Sleeping.addSleeping(propertyID, s1.isSelected(), s2.isSelected(), s3.isSelected(), s4.isSelected(), s5.isSelected(), s6.isSelected());
						Bathing.addBathing(propertyID, b1.isSelected(), b2.isSelected(), b3.isSelected(), b4.isSelected(), b5.isSelected(), b6.isSelected(),b7.isSelected());
						Kitchen.addKitchen(propertyID, k1.isSelected(), k2.isSelected(), k3.isSelected(), k4.isSelected(), k5.isSelected(), k6.isSelected(), k7.isSelected(), k8.isSelected());
						Living.addLiving(propertyID, l1.isSelected(), l2.isSelected(), l3.isSelected(), l4.isSelected(), l5.isSelected(), l6.isSelected());
						Utility.addUtilities(propertyID, u1.isSelected(), u2.isSelected(), u3.isSelected(), u4.isSelected(), u5.isSelected(), u6.isSelected());
						Outdoor.addOutdoor(propertyID, o1.isSelected(), o2.isSelected(), o3.isSelected(), o4.isSelected(), o5.isSelected());
						JOptionPane.showMessageDialog(null, "Facility updated.");
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	
                }
            }
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(801, 35, 106, 35);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(e -> {
        	PropertyList property = new PropertyList(hostID);
        	property.frame.setVisible(true);
        	 frame.dispose();
	      });
		
		
		
	}
	
}


