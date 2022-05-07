package frontend;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import backend.Properties;

import java.awt.GridBagLayout;
import java.util.HashMap;
import java.util.List;

public class EnquirerHomepage {

	private JFrame frame;
	private JTextField searchTextInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnquirerHomepage window = new EnquirerHomepage();
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
	public EnquirerHomepage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 20, 1300, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(null);
		
		JButton goToLoginButton = new JButton("Login");
		goToLoginButton.setBounds(10, 10, 90, 21);
		frame.getContentPane().add(goToLoginButton);
		
		JButton goToRegButton = new JButton("Register");
		goToRegButton.setBounds(130, 10, 100, 21);
		frame.getContentPane().add(goToRegButton);
		
		JLabel searchLabel = new JLabel("Search :");
		searchLabel.setBounds(64, 45, 60, 13);
		frame.getContentPane().add(searchLabel);
		
		searchTextInput = new JTextField();
		searchTextInput.setBounds(121, 45, 311, 19);
		searchTextInput.setColumns(10);
		frame.getContentPane().add(searchTextInput);
		
		JButton searchButton = new JButton("GO");
		searchButton.setBounds(454, 44, 60, 21);
		frame.getContentPane().add(searchButton);

		
		searchButton.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// TODO Auto-generated method stub
				String searchItems = searchTextInput.getText();
				System.out.println(searchItems);
				String columnName = "city";
				List <HashMap> listOfProperties = Properties.viewCertainProperties(columnName, searchItems);
				System.out.println(listOfProperties);
				
				int sectionSpace = 0;
				int columnSpace = 0;
				
				for(HashMap items : listOfProperties) {
//					items.get(e);
					int id = Integer.valueOf(items.get("propertyID").toString());
					
					JLabel idLabel = new JLabel("Property ID : " + id);
					idLabel.setBounds(110 + columnSpace, 70 + sectionSpace, 120, 13);
					frame.getContentPane().add(idLabel);
					
					JLabel locationLabel = new JLabel("Location :");
					locationLabel.setBounds(110 + columnSpace, 84 + sectionSpace, 60, 13);
					frame.getContentPane().add(locationLabel);
					
					JLabel locationRes = new JLabel("Location ...");
					locationRes.setBounds(170 + columnSpace, 84 + sectionSpace, 265, 13);
					String displayLocation = (String) items.get("street") + ", "
											+ (String) items.get("postcode") + " "
											+ (String) items.get("city");
					locationRes.setText(displayLocation);
					frame.getContentPane().add(locationRes);
					
					System.out.println("Searching ....");
					
					JLabel descriptionLabel = new JLabel("Description :");
					descriptionLabel.setBounds(108 + columnSpace, 105 + sectionSpace, 80, 13);
					frame.getContentPane().add(descriptionLabel);
					
					JTextArea descriptionArea = new JTextArea();
					descriptionArea.setBounds(195 + columnSpace, 105 + sectionSpace, 386, 35);
					descriptionArea.setText((String) items.get("information"));
					frame.getContentPane().add(descriptionArea);
					
					
					JLabel sleepingFac = new JLabel("Sleeping facility :");
					sleepingFac.setBounds(110 + columnSpace, 155 + sectionSpace, 100, 13);
					frame.getContentPane().add(sleepingFac);
					
					JLabel sleepingAns = new JLabel("Empty");
					sleepingAns.setBounds(230 + columnSpace, 155 + sectionSpace, 45, 13);
					if(Properties.hasSleeping(id)) {
						sleepingAns.setText("Yes");
					}
					frame.getContentPane().add(sleepingAns);
					
					JLabel bathingFac = new JLabel("Bathing facility :");
					bathingFac.setBounds(110 + columnSpace, 175 + sectionSpace, 100, 13);
					frame.getContentPane().add(bathingFac);
					
					JLabel bathingAns = new JLabel("Empty");
					bathingAns.setBounds(230 + columnSpace, 175 + sectionSpace, 45, 13);
					if(Properties.hasBathing(id)){
						bathingAns.setText("Yes");
					}
					frame.getContentPane().add(bathingAns);
					
					JLabel kitchenFac = new JLabel("Kitchen :");
					kitchenFac.setBounds(110 + columnSpace, 195 + sectionSpace, 100, 13);
					frame.getContentPane().add(kitchenFac);
					
					JLabel kitchenAns = new JLabel("Empty");
					kitchenAns.setBounds(230 + columnSpace, 195 + sectionSpace, 45, 13);
					if(Properties.hasKitchen(id)){
						kitchenAns.setText("Yes");
					}
					frame.getContentPane().add(kitchenAns);
					
					JLabel livingFac = new JLabel("Living room :");
					livingFac.setBounds(300 + columnSpace, 155 + sectionSpace, 100, 13);
					frame.getContentPane().add(livingFac);
					
					JLabel livingAns = new JLabel("Empty");
					livingAns.setBounds(420 + columnSpace, 155 + sectionSpace, 45, 13);
					if(Properties.hasLiving(id)){
						livingAns.setText("Yes");
					}
					frame.getContentPane().add(livingAns);
					
					JLabel utilityFac = new JLabel("Utility :");
					utilityFac.setBounds(300 + columnSpace, 175 + sectionSpace, 100, 13);
					frame.getContentPane().add(utilityFac);
					
					JLabel utilityAns = new JLabel("Empty");
					utilityAns.setBounds(420 + columnSpace, 175 + sectionSpace, 45, 13);
					if(Properties.hasUtility(id)){
						utilityAns.setText("Yes");
					}
					frame.getContentPane().add(utilityAns);
					
					JLabel outdoorFac = new JLabel("Outdoor :");
					outdoorFac.setBounds(300 + columnSpace, 195 + sectionSpace, 100, 13);
					frame.getContentPane().add(outdoorFac);
					
					JLabel outdoorAns = new JLabel("Empty");
					outdoorAns.setBounds(420 + columnSpace, 195 + sectionSpace, 45, 13);
					if(Properties.hasOutdoor(id)){
						outdoorAns.setText("Yes");
					}
					frame.getContentPane().add(outdoorAns);
					
					sectionSpace += 155;
					frame.setBounds(100, 20, 1301, 800);
					
					if(sectionSpace >= 580) {
						sectionSpace = 0;
						columnSpace += 610;
					}
					
				} // end for loop
				// still in search button eventListener
				
				
				
//				JLabel startDateLabel = new JLabel("Start Date :");
//				startDateLabel.setBounds(108, 337, 80, 13);
//				frame.getContentPane().add(startDateLabel);
//				
//				JLabel endDateLabel = new JLabel("End Date :");
//				endDateLabel.setBounds(110, 356, 92, 13);
//				frame.getContentPane().add(endDateLabel);

				
//				
				
			}
		}); // end searchButton event
		
		goToLoginButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// TODO Auto-generated method stub
				Login reg = new Login();
				reg.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		goToRegButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// TODO Auto-generated method stub
				Registration reg = new Registration();
				reg.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		searchButton.addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// TODO Auto-generated method stub
				String searchItems = searchTextInput.getText();
				System.out.println(Properties.getAllProperties());
			}
		});
		
	}
}
