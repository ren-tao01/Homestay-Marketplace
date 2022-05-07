package frontend;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Guest;
import backend.Person;
import backend.Validate;
import backend.Review;
import frontend.GuestBookings;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;

public class WriteReview extends JFrame implements ActionListener{
	private JTextField textField;
	private JTextField textField_1;
	
	private String guestID;
//	protected Object frame;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private String guestID;

			public void run() {
				try {
					WriteReview frame = new WriteReview(guestID);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WriteReview(String guestID) {
		this.guestID = guestID;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 477);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Write a review");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 6;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_7 = new JLabel("Please write the property ID. A review of your stay and rate the final fields out of 10");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.gridwidth = 14;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 2;
		getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_1 = new JLabel("PropetyID:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 13;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 3;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblReview = new JLabel("Review:");
		GridBagConstraints gbc_lblReview = new GridBagConstraints();
		gbc_lblReview.anchor = GridBagConstraints.EAST;
		gbc_lblReview.insets = new Insets(0, 0, 5, 5);
		gbc_lblReview.gridx = 1;
		gbc_lblReview.gridy = 4;
		getContentPane().add(lblReview, gbc_lblReview);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 13;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 4;
		getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cleanliness:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 5;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JComboBox cleanliness = new JComboBox();
		cleanliness.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4","5", "6", "7", "8","9", "10"}));
		GridBagConstraints gbc_cleanliness = new GridBagConstraints();
		gbc_cleanliness.insets = new Insets(0, 0, 5, 5);
		gbc_cleanliness.fill = GridBagConstraints.HORIZONTAL;
		gbc_cleanliness.gridx = 2;
		gbc_cleanliness.gridy = 5;
		getContentPane().add(cleanliness, gbc_cleanliness);
		
		JLabel lblNewLabel_3 = new JLabel("Hosts communication:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 6;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JComboBox communication = new JComboBox();
		communication.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4","5", "6", "7", "8","9", "10"}));
		GridBagConstraints gbc_communication = new GridBagConstraints();
		gbc_communication.insets = new Insets(0, 0, 5, 5);
		gbc_communication.fill = GridBagConstraints.HORIZONTAL;
		gbc_communication.gridx = 2;
		gbc_communication.gridy = 6;
		getContentPane().add(communication, gbc_communication);
		
		JLabel lblNewLabel_4 = new JLabel("Accurasy:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 7;
		getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JComboBox accurasy = new JComboBox();
		accurasy.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4","5", "6", "7", "8","9", "10"}));
		GridBagConstraints gbc_accurasy = new GridBagConstraints();
		gbc_accurasy.insets = new Insets(0, 0, 5, 5);
		gbc_accurasy.fill = GridBagConstraints.HORIZONTAL;
		gbc_accurasy.gridx = 2;
		gbc_accurasy.gridy = 7;
		getContentPane().add(accurasy, gbc_accurasy);
		
		JLabel lblNewLabel_5 = new JLabel("Location:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 8;
		getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JComboBox location = new JComboBox();
		location.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4","5", "6", "7", "8","9", "10"}));
		GridBagConstraints gbc_location = new GridBagConstraints();
		gbc_location.insets = new Insets(0, 0, 5, 5);
		gbc_location.fill = GridBagConstraints.HORIZONTAL;
		gbc_location.gridx = 2;
		gbc_location.gridy = 8;
		getContentPane().add(location, gbc_location);
		
		JLabel lblNewLabel_6 = new JLabel("Value:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 9;
		getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JComboBox value = new JComboBox();
		value.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4","5", "6", "7", "8","9", "10"}));
		GridBagConstraints gbc_value = new GridBagConstraints();
		gbc_value.insets = new Insets(0, 0, 5, 5);
		gbc_value.fill = GridBagConstraints.HORIZONTAL;
		gbc_value.gridx = 2;
		gbc_value.gridy = 9;
		getContentPane().add(value, gbc_value);
		
		JButton backButton = new JButton("Back");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 11;
		getContentPane().add(backButton, gbc_btnNewButton);
		
		backButton.addActionListener(this);	
		
		
		JButton submitButton = new JButton("Submit");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 15;
		gbc_btnNewButton_1.gridy = 11;
		getContentPane().add(submitButton, gbc_btnNewButton_1);
		
		String guestid = this.guestID;
		
		submitButton.addActionListener(new java.awt.event.ActionListener() {
			
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
                if (evt.getSource()==submitButton) {
                	
                	int propertyID = Integer.parseInt(Validate.Validation((textField.getText())));
                	String review = Validate.Validation(textField_1.getText());
                	int cleanScore = Integer.parseInt(Validate.Validation((cleanliness.getSelectedItem().toString())));
                	int commScore = Integer.parseInt(Validate.Validation((communication.getSelectedItem().toString())));
                	int accScore = Integer.parseInt(Validate.Validation((accurasy.getSelectedItem().toString())));
                	int locoScore = Integer.parseInt(Validate.Validation((location.getSelectedItem().toString())));
                	int valScore = Integer.parseInt(Validate.Validation((value.getSelectedItem().toString())));
                	
					try {
						Review.addReview(propertyID, review, cleanScore, commScore, accScore, locoScore, valScore);
						JOptionPane.showMessageDialog(null, "Review Sent, Please do not repeat :)");
						GuestBookings guestbookings = new GuestBookings(guestid);
		            	guestbookings.frame.setVisible(true);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            };
		});

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
		if(e.getActionCommand() == "Back") {

			GuestHomepage guesthomepage = new GuestHomepage(this.guestID);
			guesthomepage.frame.setVisible(true);
        	//frame.dispose();
		}

	}
}
