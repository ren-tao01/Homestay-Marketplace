package frontend;
import backend.ChargeBands;
import backend.DBAccess;
import backend.Living;
import backend.Person;
import backend.Properties;
import frontend.HostHomepage;
import frontend.FacilityDetails;
import frontend.ChargeBand;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import org.eclipse.swt.events.MouseAdapter;
//import org.eclipse.swt.events.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.table.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class PropertyList{

	JFrame frame;
	private JTextField propertyName;
	private JTextField description;
	private JTextField houseNo;
	private JTextField houseName;
	private JTextField street;
	private JTextField city;
	private JTextField postcode;
	private HostHomepage host;
	private JTable table;
	DefaultTableModel model;
	private JTable secondTable;
	private DefaultTableModel secondModel;
	private static String hostID;
	private static int propertyID;
	private static int price;
	private static int service;
	private static int cleaning;
		
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					PropertyList window = new PropertyList(hostID);
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
	public PropertyList(String hostID) {
		this.hostID = hostID;
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(10, 10, 1100, 980);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("List A Property");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(29, 29, 309, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Property Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(29, 104, 115, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		propertyName = new JTextField();
		propertyName.setBounds(172, 102, 227, 27);
		frame.getContentPane().add(propertyName);
		propertyName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Description:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(29, 174, 115, 19);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		description = new JTextField();
		description.setColumns(10);
		description.setBounds(172, 172, 227, 27);
		frame.getContentPane().add(description);
		
		JLabel  lblNewLabel_1_1_1 = new JLabel("Breakfast Provided:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(29, 234, 157, 19);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JCheckBox breakfast = new JCheckBox("New check box");
		breakfast.setBounds(172, 232, 158, 27);
		frame.getContentPane().add(breakfast);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("House No.:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(29, 289, 157, 19);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_7 = new JLabel("(Please ensure it's a number.)");
		lblNewLabel_1_1_1_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_7.setBounds(29, 310, 220, 19);
		frame.getContentPane().add(lblNewLabel_1_1_1_7);

		
		houseNo = new JTextField();
		houseNo.setColumns(10);
		houseNo.setBounds(172, 281, 227, 27);
		frame.getContentPane().add(houseNo);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("House Name:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1.setBounds(29, 350, 157, 19);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		houseName = new JTextField();
		houseName.setColumns(10);
		houseName.setBounds(172, 350, 227, 27);
		frame.getContentPane().add(houseName);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Street:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_1.setBounds(29, 422, 157, 19);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1_1);
		
		street = new JTextField();
		street.setColumns(10);
		street.setBounds(172, 422, 227, 27);
		frame.getContentPane().add(street);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("City:");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(29, 477, 157, 19);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1_1_1);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBounds(172, 479, 227, 27);
		frame.getContentPane().add(city);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Postcode:");
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(29, 542, 157, 19);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		postcode = new JTextField();
		postcode.setColumns(10);
		postcode.setBounds(172, 542, 227, 27);
		frame.getContentPane().add(postcode);
		
		JLabel lblNewLabel_1_2 = new JLabel("Sleeping Facility:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(515, 109, 115, 19);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Bathing Facility:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(515, 179, 115, 19);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Kitchen Facility:");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2.setBounds(515, 239, 115, 19);
		frame.getContentPane().add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Living Facility:");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_3.setBounds(515, 305, 115, 19);
		frame.getContentPane().add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Utility Facility:");
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_4.setBounds(515, 373, 115, 19);
		frame.getContentPane().add(lblNewLabel_1_2_4);
		
		JLabel lblNewLabel_1_2_5 = new JLabel("Outdoor Facility:");
		lblNewLabel_1_2_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_5.setBounds(515, 443, 115, 19);
		frame.getContentPane().add(lblNewLabel_1_2_5);
		
		JCheckBox sleeping = new JCheckBox("New check box");
		sleeping.setBounds(658, 105, 158, 27);
		frame.getContentPane().add(sleeping);
		
		JCheckBox bathing = new JCheckBox("New check box");
		bathing.setBounds(658, 175, 158, 27);
		frame.getContentPane().add(bathing);
		
		JCheckBox kitchen = new JCheckBox("New check box");
		kitchen.setBounds(658, 235, 158, 27);
		frame.getContentPane().add(kitchen);
		
		JCheckBox living = new JCheckBox("New check box");
		living.setBounds(658, 306, 158, 27);
		frame.getContentPane().add(living);
		
		JCheckBox utility = new JCheckBox("New check box");
		utility.setBounds(658, 374, 158, 27);
		frame.getContentPane().add(utility);
		
		JCheckBox outdoor = new JCheckBox("New check box");
		outdoor.setBounds(658, 444, 158, 27);
		frame.getContentPane().add(outdoor);
		
		JLabel lblNewLabel_1_2_22 = new JLabel("Your Listed Properties");
		lblNewLabel_1_2_22.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2_22.setBounds(35, 600, 250, 19);
		frame.getContentPane().add(lblNewLabel_1_2_22);
		
		JButton listButton = new JButton("List A Property");
		 listButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		 listButton.setBounds(515, 500, 130, 35);
		frame.getContentPane().add( listButton);
		 listButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		 
		//add action listener for list property 
			listButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                if (evt.getSource()==listButton) {
	                	
	                	String Id = "";

	                	String propertyNameInput = propertyName.getText();
	                	String descriptionInput = description.getText();
	                	
	                	Boolean breakfastInput = breakfast.isSelected();
	                	String breakfastYes = "";
	                	if (breakfastInput == true) {
	                		breakfastYes = "true";
	                	} else {
	                		breakfastYes = "false";
	                	}
	                	
	                	String houseNoInput = houseNo.getText();
	                	String houseNameInput = houseName.getText();
	                	String streetInput = street.getText();
	                	String cityInput = city.getText();
	                	String postcodeInput = postcode.getText();
	                	
	                	Boolean sleepingInput = sleeping.isSelected();
	                	String sleepingYes = "";
	                	if (sleepingInput == true) {
	                		sleepingYes = "true";
	                	} else {
	                		sleepingYes = "false";
	                	}
	                	
	                	Boolean bathingInput = bathing.isSelected();
	                	String bathingYes = "";
	                	if (bathingInput == true) {
	                		bathingYes = "true";
	                	} else {
	                		bathingYes = "false";
	                	}
	                	
	                	Boolean kitchenInput = kitchen.isSelected();
	                	String kitchenYes = "";
	                	if (kitchenInput == true) {
	                		kitchenYes = "true";
	                	} else {
	                		kitchenYes = "false";
	                	}

	                	Boolean livingInput = living.isSelected();
	                	String livingYes = "";
	                	if (livingInput == true) {
	                		livingYes = "true";
	                	} else {
	                		livingYes = "false";
	                	}

	                	Boolean utilityInput = utility.isSelected();
	                	String utilityYes = "";
	                	if (utilityInput == true) {
	                		utilityYes = "true";
	                	} else {
	                		utilityYes = "false";
	                	}
	                	
	                	Boolean outdoorInput = outdoor.isSelected();
	                	String outdoorYes = "";
	                	if (outdoorInput == true) {
	                		outdoorYes = "true";
	                	} else {
	                		outdoorYes = "false";
	                	}
	                	
	                	                	
	                	
	                	if (propertyNameInput.equals("") || descriptionInput.equals("") || houseNoInput.equals("") || houseNameInput.equals("") || streetInput.equals("") || cityInput.equals("")
	                			|| postcodeInput.equals("") ) {
	                		JOptionPane.showMessageDialog(null,"One or more fields empty");
	                	} else {
	                		
	                		try {
								Properties.addProperty(hostID, propertyNameInput, descriptionInput, breakfastInput, Integer.parseInt(houseNoInput), houseNameInput, streetInput, cityInput, postcodeInput, sleepingInput, bathingInput, kitchenInput, livingInput, utilityInput, outdoorInput);
	                		} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
	                		}
	                		
	                		//if all field entered then store data into String array
	                		Object data[] = {Id,propertyNameInput, descriptionInput, breakfastYes, houseNoInput, houseNameInput, streetInput, cityInput, postcodeInput, sleepingYes
	                				, bathingYes, kitchenYes, livingYes, utilityYes, outdoorYes};
	                		
	                		DefaultTableModel propertyTable = (DefaultTableModel)table.getModel();
	                		propertyTable.addRow(data);
	                		
	                		HostHomepage back = new HostHomepage(hostID);
	                		back.frame.setVisible(true);
	                		frame.dispose();
	                		JOptionPane.showMessageDialog(null, "Property listed. Now, please click on 'View Listed Properties' button and select on the row of property that you have just listed in the table and click 'Add Price' button to add price and charges.");
		
	                	}
	           
	                }
	            }
	        }); 
		
		JButton updateButton = new JButton("View / Update Facility");
		updateButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		updateButton.setBounds(680, 500, 180, 35);
		frame.getContentPane().add(updateButton);
		updateButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
					
				if (row>=0) {
					//first table
					String propertyIdCell = table.getModel().getValueAt(row, 0).toString();
					int propertyIdNo = Integer.parseInt(propertyIdCell);
					
					try {
						
						JOptionPane.showMessageDialog(null, "Opening....It might take some time :)");
						FacilityDetails facility = new FacilityDetails(hostID,propertyIdNo);
                    	facility.frame.setVisible(true);
                   	 	frame.dispose();
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please select a property(row) from the table below first.");
				}
			}
		});
		
		JButton editButton = new JButton("Edit Property");
		editButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		editButton.setBounds(515, 550, 130, 35);
		frame.getContentPane().add(editButton);
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				
				if (row>=0) {
	
					try {
						
						JOptionPane.showMessageDialog(null, "Updating....");

						//to get property ID from the first table
						String propertyIdCell = table.getModel().getValueAt(row, 0).toString();
						int propertyIdNo = Integer.parseInt(propertyIdCell);
						
						String propertyNameInput = propertyName.getText(); 
						Properties.editProperty(propertyIdNo,"shortName",propertyNameInput);
						table.setValueAt(propertyNameInput, row, 1);

						String descriptionInput = description.getText();
						Properties.editProperty(propertyIdNo,"information",descriptionInput);
						table.setValueAt(descriptionInput, row, 2);

						Boolean breakfastInput = breakfast.isSelected();
	                	String breakfastYes = "";
	                	if (breakfastInput == true) {
	                		breakfastYes = "1";
	                	} else {
	                		breakfastYes = "0";
	                	}
						Properties.editProperty(propertyIdNo,"breakfast",breakfastYes);
						table.setValueAt(breakfastYes, row, 3);

						String houseNoText = houseNo.getText();
						int houseNoInput = Integer.parseInt(houseNoText);
						Properties.editProperty(propertyIdNo,"houseNumber",houseNoText);
						table.setValueAt(houseNoText, row, 4);

						String houseNameInput = houseName.getText();
						Properties.editProperty(propertyIdNo,"houseName",houseNameInput);
						table.setValueAt(houseNameInput, row, 5);

						String cityInput = city.getText();
						Properties.editProperty(propertyIdNo,"city",cityInput);
						table.setValueAt(cityInput, row, 6);

						String streetInput = street.getText();
						Properties.editProperty(propertyIdNo,"street",streetInput);
						table.setValueAt(streetInput, row, 7);

						String postcodeInput = postcode.getText();
						Properties.editProperty(propertyIdNo,"postcode",postcodeInput);
						table.setValueAt(postcodeInput, row, 8);
						
						Boolean sleepingInput = sleeping.isSelected();
	                	String sleepingYes = "";
	                	if (sleepingInput == true) {
	                		sleepingYes = "1";
	                	} else {
	                		sleepingYes = "0";
	                	}
						Properties.editProperty(propertyIdNo,"hasSleeping",sleepingYes);
						table.setValueAt(sleepingYes, row, 9);
	                	
	                	Boolean bathingInput = bathing.isSelected();
	                	String bathingYes = "";
	                	if (bathingInput == true) {
	                		bathingYes = "1";
	                	} else {
	                		bathingYes = "0";
	                	}
						Properties.editProperty(propertyIdNo,"hasBathing",bathingYes);
						table.setValueAt(bathingYes, row, 10);

	                	Boolean kitchenInput = kitchen.isSelected();
	                	String kitchenYes = "";
	                	if (kitchenInput == true) {
	                		kitchenYes = "1";
	                	} else {
	                		kitchenYes = "0";
	                	}
						Properties.editProperty(propertyIdNo,"hasKitchen",kitchenYes);
						table.setValueAt(kitchenYes, row, 11);


	                	Boolean livingInput = living.isSelected();
	                	String livingYes = "";
	                	if (livingInput == true) {
	                		livingYes = "1";
	                	} else {
	                		livingYes = "0";
	                	}
						Properties.editProperty(propertyIdNo,"hasLiving",livingYes);
						table.setValueAt(livingYes, row, 12);


	                	Boolean utilityInput = utility.isSelected();
	                	String utilityYes = "";
	                	if (utilityInput == true) {
	                		utilityYes = "1";
	                	} else {
	                		utilityYes = "0";
	                	}
						Properties.editProperty(propertyIdNo,"hasUtility",utilityYes);
						table.setValueAt(utilityYes, row, 13);


	                	Boolean outdoorInput = outdoor.isSelected();
	                	String outdoorYes = "";
	                	if (outdoorInput == true) {
	                		outdoorYes = "1";
	                	} else {
	                		outdoorYes = "0";
	                	}
						Properties.editProperty(propertyIdNo,"hasOutdoor",outdoorYes);
						table.setValueAt(outdoorYes, row, 14);
						
						JOptionPane.showMessageDialog(null, "Updated successfully.");
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            	
				} else {
					JOptionPane.showMessageDialog(null, "Please select a property(row) from the table below first.");
				}
				
			}
		});
			
		JButton deleteButton = new JButton("Delete Property");
		deleteButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		deleteButton.setBounds(680, 550, 130, 35);
		frame.getContentPane().add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int row = table.getSelectedRow();
				
				if (row>=0) {
					String cell = table.getModel().getValueAt(row, 0).toString();
					int col = Integer.parseInt(cell);
					
					try {
						Properties.deleteProperty(col);
						table.setValueAt("", row, 0);
						table.setValueAt("", row, 1);
						table.setValueAt("", row, 2);
						table.setValueAt("", row, 3);
						table.setValueAt("", row, 4);
						table.setValueAt("", row, 5);
						table.setValueAt("", row, 6);
						table.setValueAt("", row, 7);
						table.setValueAt("", row, 8);
						table.setValueAt("", row, 9);
						table.setValueAt("", row, 10);
						table.setValueAt("", row, 11);
						table.setValueAt("", row, 12);
						table.setValueAt("", row, 13);
						table.setValueAt("", row, 14);
						
						ChargeBands.deleteChargeBands(col);

						JOptionPane.showMessageDialog(null, "Property successfully deleted.");
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please select a property(row) from the table below first.");
				}
			}
		});
		
		JButton rating = new JButton("View Property Rating");
		rating.setFont(new Font("Tahoma", Font.BOLD, 12));
		rating.setBounds(830, 550, 180, 35);
		frame.getContentPane().add(rating);
		rating.addActionListener(e -> {
	    	RequestPropertyRating review = new RequestPropertyRating(propertyID);
        	review.frame.setVisible(true);
	      });
		
		JButton addButton = new JButton("Add / Edit Price");
		addButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		addButton.setBounds(880, 500, 140, 35);
		frame.getContentPane().add(addButton);
		addButton.addActionListener(e -> {
			
			int row = table.getSelectedRow();
			
			if (row>=0) {
				String cell = table.getModel().getValueAt(row, 0).toString();
				int col = Integer.parseInt(cell);

	        	ChargeBand charge = new ChargeBand(hostID,col);
	        	charge.frame.setVisible(true);
	        	 frame.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Please select a property(row) from the table below first.");
			}

	      });
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(801, 35, 106, 35);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(e -> {

        	HostHomepage host = new HostHomepage(hostID);
        	host.frame.setVisible(true);
        	 frame.dispose();
	      });

		//first table 
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 626, 1000, 177);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		
		Object [] column = {"Name", "Description", "Breakfast", "House No.", "House Name", "Street", "City", "Postcode", 
				"Sleeping", "Bathing", "Kitchen", "Living", "Utility", "Outdoor"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table); 
		table.setModel(DbUtils.resultSetToTableModel(Properties.getHostsPropertiesResultSet(hostID)));
	
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked (MouseEvent e) {
				int row = table.getSelectedRow();
				propertyName.setText(table.getModel().getValueAt(row,1).toString());
				description.setText(table.getModel().getValueAt(row,2).toString());
            	
				String breakfastInput = table.getModel().getValueAt(row,3).toString();
				if (breakfastInput == "true") {
					breakfast.setSelected(true);
            	} else {
            		breakfast.setSelected(false);
            	}
            
				houseNo.setText(table.getModel().getValueAt(row,4).toString());
				houseName.setText(table.getModel().getValueAt(row,5).toString());
				city.setText(table.getModel().getValueAt(row,6).toString());
				street.setText(table.getModel().getValueAt(row,7).toString());
				postcode.setText(table.getModel().getValueAt(row,8).toString());
				
				String sleepingInput = table.getModel().getValueAt(row,9).toString();
				if (sleepingInput == "true") {
					sleeping.setSelected(true);
            	} else {
            		sleeping.setSelected(false);
            	}
				
				String bathingInput = table.getModel().getValueAt(row,10).toString();
				if (bathingInput == "true") {
					bathing.setSelected(true);
            	} else {
            		bathing.setSelected(false);
            	}
				
				String kitchenInput = table.getModel().getValueAt(row,11).toString();
				if (kitchenInput == "true") {
					kitchen.setSelected(true);
            	} else {
            		kitchen.setSelected(false);
            	}
				
				String livingInput = table.getModel().getValueAt(row,12).toString();
				if (livingInput == "true") {
					living.setSelected(true);
            	} else {
            		living.setSelected(false);
            	}

				String utilityInput = table.getModel().getValueAt(row,13).toString();
				if (utilityInput == "true") {
					utility.setSelected(true);
            	} else {
            		utility.setSelected(false);
            	}
				
				String outdoorInput = table.getModel().getValueAt(row,14).toString();
				if (outdoorInput == "true") {
					outdoor.setSelected(true);
            	} else {
            		outdoor.setSelected(false);
            	}
				

			}
			
		});
		
	}

	
}
