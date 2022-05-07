package frontend;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import backend.Person;
import backend.Properties;

public class GuestViewDetailedPropertyInfo {

	JFrame frame;
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
					GuestViewDetailedPropertyInfo window = new GuestViewDetailedPropertyInfo(guestID,propertyID);
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
	public GuestViewDetailedPropertyInfo(String guestID,int propertyID) {
		this.guestID = guestID;
		this.propertyID = propertyID;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(451, 35, 106, 35);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(e -> {

        	GuestBookings host = new GuestBookings(guestID);
        	host.frame.setVisible(true);
        	 frame.dispose();
	      });
		
		JLabel lblNewLabel = new JLabel("Confidential Host and Property Details ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(39, 30, 337, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("Host Email: ");
		lblNewLabel1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel1.setBounds(39, 80, 237, 40);
		frame.getContentPane().add(lblNewLabel1);
				
		JLabel lblNewLabela = new JLabel(Properties.getHostID(propertyID));
		lblNewLabela.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabela.setBounds(109, 80, 237, 40);
		frame.getContentPane().add(lblNewLabela);
		
		JLabel lblNewLabel2 = new JLabel("Host Title: ");
		lblNewLabel2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel2.setBounds(39, 120, 237, 40);
		frame.getContentPane().add(lblNewLabel2);

		JLabel lblNewLabelb = new JLabel(Person.getHostTitle(Properties.getHostID(propertyID)));
		lblNewLabelb.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabelb.setBounds(109, 120, 237, 40);
		frame.getContentPane().add(lblNewLabelb);
		
		JLabel lblNewLabel3 = new JLabel("Host Forename: ");
		lblNewLabel3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel3.setBounds(39, 160, 237, 40);
		frame.getContentPane().add(lblNewLabel3);
		
		JLabel lblNewLabelc = new JLabel(Person.getHostForname(Properties.getHostID(propertyID)));
		lblNewLabelc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabelc.setBounds(149, 160, 237, 40);
		frame.getContentPane().add(lblNewLabelc);
		
		JLabel lblNewLabel4 = new JLabel("Host Surname: ");
		lblNewLabel4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel4.setBounds(39, 200, 237, 40);
		frame.getContentPane().add(lblNewLabel4);
		
		JLabel lblNewLabeld = new JLabel(Person.getHostSurname(Properties.getHostID(propertyID)));
		lblNewLabeld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabeld.setBounds(149, 200, 237, 40);
		frame.getContentPane().add(lblNewLabeld);
		
		JLabel lblNewLabel5 = new JLabel("Host Mobile Number: ");
		lblNewLabel5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel5.setBounds(39, 240, 237, 40);
		frame.getContentPane().add(lblNewLabel5);
		
		JLabel lblNewLabele = new JLabel(Person.getHostMobileNumber(Properties.getHostID(propertyID)));
		lblNewLabele.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabele.setBounds(169, 240, 237, 40);
		frame.getContentPane().add(lblNewLabele);
		
		JLabel lblNewLabel6 = new JLabel("Property Full Address: ");
		lblNewLabel6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel6.setBounds(39, 280, 237, 40);
		frame.getContentPane().add(lblNewLabel6);
		
		JLabel lblNewLabelf = new JLabel(Properties.getPrivateLocation(propertyID));
		lblNewLabelf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabelf.setBounds(169, 280, 237, 40);
		frame.getContentPane().add(lblNewLabelf);
		
		JLabel lblNewLabel7 = new JLabel(" ");
		lblNewLabel7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel7.setBounds(39, 280, 237, 40);
		frame.getContentPane().add(lblNewLabel7);
		
	
		
	
		
	}

}
