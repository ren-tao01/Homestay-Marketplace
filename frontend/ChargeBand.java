package frontend;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import backend.ChargeBands;
import backend.Properties;

public class ChargeBand {

	JFrame frame;
	private JTextField startd;
	private JTextField startm;
	private JTextField starty;
	private JTextField endd;
	private JTextField endm;
	private JTextField endy;
	private JTextField price;
	private JTextField service;
	private JTextField cleaning;
	private static int propertyID;
	private static String hostID;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChargeBand window = new ChargeBand(hostID,propertyID);
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
	public ChargeBand(String hostID,int propertyID) {
		this.hostID = hostID;
		this.propertyID = propertyID;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Charge Bands");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(29, 29, 309, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabelw = new JLabel("**Include only numbers.**");
		lblNewLabelw.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabelw.setBounds(29, 29, 320, 80);
		frame.getContentPane().add(lblNewLabelw);
		
		JLabel lblNewLabelww = new JLabel("**Format of Date - Day: 00(2 integers), Month: 00(2 integers), Year: 0000(4 integers)**");
		lblNewLabelww.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabelww.setBounds(29, 45, 820, 80);
		frame.getContentPane().add(lblNewLabelww);
		
		JLabel lblNewLabel_sd = new JLabel("Start Day:");
		lblNewLabel_sd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_sd.setBounds(450, 100, 115, 19);
		frame.getContentPane().add(lblNewLabel_sd);
		
		startd = new JTextField();
		startd.setColumns(10);
		startd.setBounds(540, 102, 227, 17);
		frame.getContentPane().add(startd);
		
		
		JLabel lblNewLabel_sm = new JLabel("Start Month:");
		lblNewLabel_sm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_sm.setBounds(450, 120, 115, 19);
		frame.getContentPane().add(lblNewLabel_sm);
		
		startm = new JTextField();
		startm.setColumns(10);
		startm.setBounds(540, 122, 227, 17);
		frame.getContentPane().add(startm);
		
		
		JLabel lblNewLabel_sy = new JLabel("Start Year:");
		lblNewLabel_sy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_sy.setBounds(450, 140, 115, 19);
		frame.getContentPane().add(lblNewLabel_sy);
		
		starty = new JTextField();
		starty.setColumns(10);
		starty.setBounds(540, 144, 227, 17);
		frame.getContentPane().add(starty);
		
		JLabel lblNewLabel_ed = new JLabel("End Day:");
		lblNewLabel_ed.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_ed.setBounds(450, 174, 115, 19);
		frame.getContentPane().add(lblNewLabel_ed);
		
		endd = new JTextField();
		endd.setColumns(10);
		endd.setBounds(540, 175, 227, 17);
		frame.getContentPane().add(endd);
		
		JLabel lblNewLabel_em = new JLabel("End Month:");
		lblNewLabel_em.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_em.setBounds(450, 194, 115, 19);
		frame.getContentPane().add(lblNewLabel_em);
		
		endm = new JTextField();
		endm.setColumns(10);
		endm.setBounds(540, 196, 227, 17);
		frame.getContentPane().add(endm);
		
		JLabel lblNewLabel_ey = new JLabel("End Year:");
		lblNewLabel_ey.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_ey.setBounds(450, 214, 115, 19);
		frame.getContentPane().add(lblNewLabel_ey);
		
		endy = new JTextField();
		endy.setColumns(10);
		endy.setBounds(540, 216, 227, 17);
		frame.getContentPane().add(endy);
		
		JLabel lblNewLabel_1 = new JLabel("Price Per Night:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(29, 104, 115, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(172, 102, 227, 27);
		frame.getContentPane().add(price);
		
		JLabel lblNewLabel_1_1 = new JLabel("Service Charge:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(29, 174, 115, 19);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		service = new JTextField();
		service.setColumns(10);
		service.setBounds(172, 172, 227, 27);
		frame.getContentPane().add(service);
		
		JLabel lblNewLabel_1_2 = new JLabel("Cleaning Charge:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(29, 234, 155, 19);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		cleaning = new JTextField();
		cleaning.setColumns(10);
		cleaning.setBounds(172, 234, 227, 27);
		frame.getContentPane().add(cleaning);
		
		if (ChargeBands.hasChargeBand(propertyID)==true) {
			String sdd = "";
			sdd = ChargeBands.getStartDate(propertyID).toString();
			String sy = sdd.substring(0,4);
			String sm = sdd.substring(5,7);
			String sd = sdd.substring(8,10);
			startd.setText(sd);
			startm.setText(sm);
			starty.setText(sy);
			
			String edd = "";
			edd = ChargeBands.getStartDate(propertyID).toString();
			String ey = edd.substring(0,4);
			String em = edd.substring(5,7);
			String ed = edd.substring(8,10);
			endd.setText(ed);
			endm.setText(em);
			endy.setText(ey);
			
			price.setText(ChargeBands.getPricePerNight(propertyID).toString());
			service.setText(ChargeBands.getServiceCharge(propertyID).toString());
			cleaning.setText(ChargeBands.getCleaningCharge(propertyID).toString());
		}
		
		JLabel lblNewLabel_a = new JLabel(">> Click this button if this is your first time adding charge band for your property.");
		lblNewLabel_a.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_a.setBounds(130, 300, 800, 35);
		frame.getContentPane().add(lblNewLabel_a);
		
		JButton addButton = new JButton("Add");
		 addButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		 addButton.setBounds(30, 300, 80, 35);
		frame.getContentPane().add(addButton);
		 addButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource()==addButton) {
                	
                	String Id = "";

                	String startdInput = startd.getText();
                	String startmInput = startm.getText();
                	String startyInput = starty.getText();
                	String enddInput = endd.getText();
                	String endmInput = endm.getText();
                	String endyInput = endy.getText();
                	String priceInput = price.getText();
                	String serviceInput = service.getText();
                	String cleaningInput = cleaning.getText();      	
                	
                	if (startdInput.equals("") || startmInput.equals("") || startyInput.equals("") || enddInput.equals("") || endmInput.equals("") || endyInput.equals("") || priceInput.equals("") || serviceInput.equals("") || cleaningInput.equals("")) {
                		JOptionPane.showMessageDialog(null,"One or more fields empty");
                	} else {
                		
                		try {
							ChargeBands.addChargeBand(propertyID, Integer.parseInt(priceInput), Integer.parseInt(serviceInput), Integer.parseInt(cleaningInput),Integer.parseInt(startdInput),Integer.parseInt(startmInput),Integer.parseInt(startyInput),Integer.parseInt(enddInput),Integer.parseInt(endmInput),Integer.parseInt(endyInput));
                		} catch (Exception ev) {
							// TODO Auto-generated catch block
							ev.printStackTrace();
                		}
                	                		
                		PropertyList host = new PropertyList(hostID);
                    	host.frame.setVisible(true);
                   	 	frame.dispose();
                   	 	
                		JOptionPane.showMessageDialog(null, "Price added. You can now select the property(row) that you have just listed and click 'Update Facility' button to add facilities to your property!");
                		
                	}
           
                }
			}
		});
		
		 JLabel lblNewLabel_e = new JLabel(">> Click this button if you have initially added a charge band for your property.");
			lblNewLabel_e.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_e.setBounds(130, 350, 800, 35);
			frame.getContentPane().add(lblNewLabel_e);
		 
		 JButton editButton = new JButton("Update");
		 editButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		 editButton.setBounds(30, 350, 80, 35);
		frame.getContentPane().add(editButton);
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==editButton) {
                	
                	String Id = "";

                	String startdInput = startd.getText();
                	String startmInput = startm.getText();
                	String startyInput = starty.getText();
                	String enddInput = endd.getText();
                	String endmInput = endm.getText();
                	String endyInput = endy.getText();
                	String priceInput = price.getText();
                	String serviceInput = service.getText();
                	String cleaningInput = cleaning.getText();      	
                	
                	if (startdInput.equals("") || startmInput.equals("") || startyInput.equals("") || enddInput.equals("") || endmInput.equals("") || endyInput.equals("") || priceInput.equals("") || serviceInput.equals("") || cleaningInput.equals("")) {
                		JOptionPane.showMessageDialog(null,"One or more fields empty");
                	} else {
                		
                		try {
                			ChargeBands.editChargeBandStartDate(propertyID, Integer.parseInt(startdInput), Integer.parseInt(startmInput), Integer.parseInt(startyInput));
                			ChargeBands.editChargeBandEndDate(propertyID, Integer.parseInt(enddInput), Integer.parseInt(endmInput), Integer.parseInt(endyInput));
							ChargeBands.editChargeBand(propertyID, "pricePerNight", priceInput);
							ChargeBands.editChargeBand(propertyID, "serviceCharge", serviceInput);
							ChargeBands.editChargeBand(propertyID, "cleaningCharge", cleaningInput);
						
                		} catch (Exception ev) {
							// TODO Auto-generated catch block
							ev.printStackTrace();
                		}
                		
                		JOptionPane.showMessageDialog(null, "Price edited and updated.");                		
                	}
           
                }
			}
		 });
		 
		 JButton backButton = new JButton("Back");
		 backButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		 backButton.setBounds(30, 400, 80, 35);
		frame.getContentPane().add(backButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PropertyList host = new PropertyList(hostID);
            	host.frame.setVisible(true);
           	 	frame.dispose();
			}
		 });
			
		 
		
	}

}
