package frontend;

import backend.DBAccess;
import backend.Properties;
import backend.Review;
import net.proteanit.sql.DbUtils;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JButton;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

public class ReadReview{

	private JTable table;
	DefaultTableModel model;
	JFrame frame;
	private static String hostID;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					ReadReview window = new ReadReview(hostID);
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
	public ReadReview(String hostID) {
		this.hostID = hostID;
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 957, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Review");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(29, 29, 74, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 90, 900, 400);
		frame.getContentPane().add(scrollPane);
		table = new JTable();
		
		Object [] column = {"Property ID","Review", "Cleanliness Score", "Communication Score", "Accuracy Score", "Location Score", "Value Score"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table); 
		table.setModel(DbUtils.resultSetToTableModel(Review.getPropertyReviews()));
		
		JButton btn = new JButton("Back");
		btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn.setBounds(700, 40, 122, 27);
		frame.getContentPane().add(btn);
		
		//add action listener for register now button
		btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (evt.getSource()==btn) {
                	
                	HostHomepage back = new HostHomepage(hostID);
                	back.frame.setVisible(true);
                	 frame.dispose();
                }
            }
        });
	
	}
	
}
