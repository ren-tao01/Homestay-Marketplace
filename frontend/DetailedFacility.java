package frontend;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import backend.Bathing;
import backend.Kitchen;
import backend.Living;
import backend.Outdoor;
import backend.Properties;
import backend.Sleeping;
import backend.Utility;

public class DetailedFacility {

	JFrame frame;
	private static int propertyID;
	private static String guestID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailedFacility window = new DetailedFacility(guestID,propertyID);
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
	public DetailedFacility(String guestID, int propertyID) {
		this.guestID = guestID;
		this.propertyID = propertyID;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(40, 40, 650, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Detailed Facilities");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(55, 55, 200, 20);
		frame.getContentPane().add(lblNewLabel);
		
		//sleeping 
		JLabel lblNewLabels = new JLabel("Sleeping Facility");
		lblNewLabels.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabels.setBounds(55, 115, 200, 20);
		frame.getContentPane().add(lblNewLabels);
		
		JLabel lblNewLabels1 = new JLabel("Bed Linen: ");
		lblNewLabels1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabels1.setBounds(55, 140, 200, 20);
		frame.getContentPane().add(lblNewLabels1);

		String sa = "";
		if(Sleeping.getBedLinen(propertyID)==true) {
			sa="yes";
		} else {
			sa="no";
		}
		JLabel lblNewLabelsa = new JLabel(sa);
		lblNewLabelsa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabelsa.setBounds(150, 140, 200, 20);
		frame.getContentPane().add(lblNewLabelsa);
		
		JLabel lblNewLabels2 = new JLabel("Towel: ");
		lblNewLabels2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabels2.setBounds(55, 160, 200, 20);
		frame.getContentPane().add(lblNewLabels2);
		
		String sb = "";
		if(Sleeping.getTowels(propertyID)==true) {
			sb="yes";
		} else {
			sb="no";
		}
		JLabel lblNewLabelsb = new JLabel(sb);
		lblNewLabelsb.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabelsb.setBounds(150, 160, 200, 20);
		frame.getContentPane().add(lblNewLabelsb);
		
		JLabel lblNewLabels3 = new JLabel("Single Bed: ");
		lblNewLabels3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabels3.setBounds(55, 180, 200, 20);
		frame.getContentPane().add(lblNewLabels3);
		
		String sc = "";
		if(Sleeping.getSingleBed(propertyID)==true) {
			sc="yes";
		} else {
			sc="no";
		}
		JLabel lblNewLabelsc = new JLabel(sc);
		lblNewLabelsc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabelsc.setBounds(150, 180, 200, 20);
		frame.getContentPane().add(lblNewLabelsc);
		
		JLabel lblNewLabels4 = new JLabel("Double Bed: ");
		lblNewLabels4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabels4.setBounds(55, 200, 200, 20);
		frame.getContentPane().add(lblNewLabels4);
		
		String sd = "";
		if(Sleeping.getDoubleBed(propertyID)==true) {
			sd="yes";
		} else {
			sd="no";
		}
		JLabel lblNewLabelsd = new JLabel(sd);
		lblNewLabelsd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabelsd.setBounds(150, 200, 200, 20);
		frame.getContentPane().add(lblNewLabelsd);
		
		JLabel lblNewLabels5 = new JLabel("King Size Bed: ");
		lblNewLabels5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabels5.setBounds(55, 220, 200, 20);
		frame.getContentPane().add(lblNewLabels5);
		
		String se = "";
		if(Sleeping.getKingSizedBed(propertyID)==true) {
			se="yes";
		} else {
			se="no";
		}
		JLabel lblNewLabelse = new JLabel(se);
		lblNewLabelse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabelse.setBounds(150, 220, 200, 20);
		frame.getContentPane().add(lblNewLabelse);
		
		
		JLabel lblNewLabels6 = new JLabel("Bunk Bed: ");
		lblNewLabels6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabels6.setBounds(55, 240, 200, 20);
		frame.getContentPane().add(lblNewLabels6);
		
		String sf = "";
		if(Sleeping.getBunkBed(propertyID)==true) {
			sf="yes";
		} else {
			sf="no";
		}
		JLabel lblNewLabelsf = new JLabel(sf);
		lblNewLabelsf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabelsf.setBounds(150, 240, 200, 20);
		frame.getContentPane().add(lblNewLabelsf);
		
		
		
		//bathing
				JLabel lblNewLabelb = new JLabel("Bathing Facility");
				lblNewLabelb.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabelb.setBounds(55, 270, 200, 20);
				frame.getContentPane().add(lblNewLabelb);
				
				JLabel lblNewLabelb1 = new JLabel("HairDryer: ");
				lblNewLabelb1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelb1.setBounds(55, 290, 200, 20);
				frame.getContentPane().add(lblNewLabelb1);

				String ba = "";
				if(Bathing.getHairDryer(propertyID)==true) {
					ba="yes";
				} else {
					ba="no";
				}
				JLabel lblNewLabelba = new JLabel(ba);
				lblNewLabelba.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelba.setBounds(150, 290, 200, 20);
				frame.getContentPane().add(lblNewLabelba);
				
				JLabel lblNewLabelb2 = new JLabel("Shampoo: ");
				lblNewLabelb2.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelb2.setBounds(55, 310, 200, 20);
				frame.getContentPane().add(lblNewLabelb2);

				String bb = "";
				if(Bathing.getShampoo(propertyID)==true) {
					bb="yes";
				} else {
					bb="no";
				}
				JLabel lblNewLabelbb = new JLabel(ba);
				lblNewLabelbb.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelbb.setBounds(150, 310, 200, 20);
				frame.getContentPane().add(lblNewLabelbb);
				
				JLabel lblNewLabelb3 = new JLabel("Toilet Paper: ");
				lblNewLabelb3.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelb3.setBounds(55, 330, 200, 20);
				frame.getContentPane().add(lblNewLabelb3);

				String bc = "";
				if(Bathing.getToiletPaper(propertyID)==true) {
					bc="yes";
				} else {
					bc="no";
				}
				JLabel lblNewLabelbc = new JLabel(bc);
				lblNewLabelbc.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelbc.setBounds(150, 330, 200, 20);
				frame.getContentPane().add(lblNewLabelbc);
				
				JLabel lblNewLabelb4 = new JLabel("Toilet: ");
				lblNewLabelb4.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelb4.setBounds(55, 350, 200, 20);
				frame.getContentPane().add(lblNewLabelb4);

				String bd = "";
				if(Bathing.getToilet(propertyID)==true) {
					bd="yes";
				} else {
					bd="no";
				}
				JLabel lblNewLabelbd = new JLabel(bd);
				lblNewLabelbd.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelbd.setBounds(150, 350, 200, 20);
				frame.getContentPane().add(lblNewLabelbd);
				
				JLabel lblNewLabelb5 = new JLabel("Bath: ");
				lblNewLabelb5.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelb5.setBounds(55, 370, 200, 20);
				frame.getContentPane().add(lblNewLabelb5);

				String be = "";
				if(Bathing.getBath(propertyID)==true) {
					be="yes";
				} else {
					be="no";
				}
				JLabel lblNewLabelbe = new JLabel(be);
				lblNewLabelbe.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelbe.setBounds(150, 370, 200, 20);
				frame.getContentPane().add(lblNewLabelbe);
				
				JLabel lblNewLabelb6 = new JLabel("Shower: ");
				lblNewLabelb6.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelb6.setBounds(55, 390, 200, 20);
				frame.getContentPane().add(lblNewLabelb6);

				String bf = "";
				if(Bathing.getShower(propertyID)==true) {
					bf="yes";
				} else {
					bf="no";
				}
				JLabel lblNewLabelbf = new JLabel(bf);
				lblNewLabelbf.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelbf.setBounds(150, 390, 200, 20);
				frame.getContentPane().add(lblNewLabelbf);
				
				JLabel lblNewLabelb7 = new JLabel("Share With Host: ");
				lblNewLabelb7.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelb7.setBounds(55, 410, 200, 20);
				frame.getContentPane().add(lblNewLabelb7);

				String bg = "";
				if(Bathing.getShareWithHost(propertyID)==true) {
					bg="yes";
				} else {
					bg="no";
				}
				JLabel lblNewLabelbg = new JLabel(bg);
				lblNewLabelbg.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelbg.setBounds(150, 410, 200, 20);
				frame.getContentPane().add(lblNewLabelbg);
				
				
				//kitchen
				JLabel lblNewLabelk = new JLabel("Kitchen Facility");
				lblNewLabelk.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabelk.setBounds(230, 115, 200, 20);
				frame.getContentPane().add(lblNewLabelk);
				
				
				JLabel lblNewLabelk1 = new JLabel("Refrigerator: ");
				lblNewLabelk1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelk1.setBounds(230, 140, 200, 20);
				frame.getContentPane().add(lblNewLabelk1);

				String ka = "";
				if(Kitchen.getRefrigerator(propertyID)==true) {
					ka="yes";
				} else {
					ka="no";
				}
				JLabel lblNewLabelka = new JLabel(ka);
				lblNewLabelka.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelka.setBounds(330, 140, 200, 20);
				frame.getContentPane().add(lblNewLabelka);
				
				JLabel lblNewLabelk2 = new JLabel("Microwave: ");
				lblNewLabelk2.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelk2.setBounds(230, 160, 200, 20);
				frame.getContentPane().add(lblNewLabelk2);
				
				String kb = "";
				if(Kitchen.getMicrowave(propertyID)==true) {
					kb="yes";
				} else {
					kb="no";
				}
				JLabel lblNewLabelkb = new JLabel(kb);
				lblNewLabelkb.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelkb.setBounds(330, 160, 200, 20);
				frame.getContentPane().add(lblNewLabelkb);
				
				JLabel lblNewLabelk3 = new JLabel("Oven: ");
				lblNewLabelk3.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelk3.setBounds(230, 180, 200, 20);
				frame.getContentPane().add(lblNewLabelk3);
				
				String kc = "";
				if(Kitchen.getOven(propertyID)==true) {
					kc="yes";
				} else {
					kc="no";
				}
				JLabel lblNewLabelkc = new JLabel(kc);
				lblNewLabelkc.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelkc.setBounds(330, 180, 200, 20);
				frame.getContentPane().add(lblNewLabelkc);
				
				JLabel lblNewLabelk4 = new JLabel("Stove: ");
				lblNewLabelk4.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelk4.setBounds(230, 200, 200, 20);
				frame.getContentPane().add(lblNewLabelk4);
				
				String kd = "";
				if(Kitchen.getStove(propertyID)==true) {
					kd="yes";
				} else {
					kd="no";
				}
				JLabel lblNewLabelkd = new JLabel(kd);
				lblNewLabelkd.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelkd.setBounds(330, 200, 200, 20);
				frame.getContentPane().add(lblNewLabelkd);
				
				JLabel lblNewLabelk5 = new JLabel("Dishwasher: ");
				lblNewLabelk5.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelk5.setBounds(230, 220, 200, 20);
				frame.getContentPane().add(lblNewLabelk5);
				
				String ke = "";
				if(Kitchen.getDishwasher(propertyID)==true) {
					ke="yes";
				} else {
					ke="no";
				}
				JLabel lblNewLabelke = new JLabel(ke);
				lblNewLabelke.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelke.setBounds(330, 220, 200, 20);
				frame.getContentPane().add(lblNewLabelke);
				
				
				JLabel lblNewLabelk6 = new JLabel("Tableware: ");
				lblNewLabelk6.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelk6.setBounds(230, 240, 200, 20);
				frame.getContentPane().add(lblNewLabelk6);
				
				String kf = "";
				if(Kitchen.getTableware(propertyID)==true) {
					kf="yes";
				} else {
					kf="no";
				}
				JLabel lblNewLabelkf = new JLabel(kf);
				lblNewLabelkf.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelkf.setBounds(330, 240, 200, 20);
				frame.getContentPane().add(lblNewLabelkf);
				
				JLabel lblNewLabelk7 = new JLabel("Cookware: ");
				lblNewLabelk7.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelk7.setBounds(230, 260, 200, 20);
				frame.getContentPane().add(lblNewLabelk7);
				
				String kg = "";
				if(Kitchen.getCookware(propertyID)==true) {
					kg="yes";
				} else {
					kg="no";
				}
				JLabel lblNewLabelkg = new JLabel(kg);
				lblNewLabelkg.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelkg.setBounds(330, 260, 200, 20);
				frame.getContentPane().add(lblNewLabelkg);
				
				JLabel lblNewLabelk8 = new JLabel("Basic Provision: ");
				lblNewLabelk8.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelk8.setBounds(230, 280, 200, 20);
				frame.getContentPane().add(lblNewLabelk8);
				
				String kh = "";
				if(Kitchen.getBasicProvisions(propertyID)==true) {
					kh="yes";
				} else {
					kh="no";
				}
				JLabel lblNewLabelkh = new JLabel(kh);
				lblNewLabelkh.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelkh.setBounds(330, 280, 200, 20);
				frame.getContentPane().add(lblNewLabelkh);
				
				
				//living 
				JLabel lblNewLabell = new JLabel("Living Facility");
				lblNewLabell.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabell.setBounds(400, 115, 200, 20);
				frame.getContentPane().add(lblNewLabell);
				
				JLabel lblNewLabell1 = new JLabel("Wifi: ");
				lblNewLabell1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabell1.setBounds(400, 140, 200, 20);
				frame.getContentPane().add(lblNewLabell1);

				String la = "";
				if(Living.getWifi(propertyID)==true) {
					la="yes";
				} else {
					la="no";
				}
				JLabel lblNewLabella = new JLabel(la);
				lblNewLabella.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabella.setBounds(480, 140, 200, 20);
				frame.getContentPane().add(lblNewLabella);
				
				JLabel lblNewLabell2 = new JLabel("Television: ");
				lblNewLabell2.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabell2.setBounds(400, 160, 200, 20);
				frame.getContentPane().add(lblNewLabell2);

				String lb = "";
				if(Living.getTelevision(propertyID)==true) {
					lb="yes";
				} else {
					lb="no";
				}
				JLabel lblNewLabellb = new JLabel(lb);
				lblNewLabellb.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabellb.setBounds(480, 160, 200, 20);
				frame.getContentPane().add(lblNewLabellb);
				
				JLabel lblNewLabell3 = new JLabel("Satellite: ");
				lblNewLabell3.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabell3.setBounds(400, 180, 200, 20);
				frame.getContentPane().add(lblNewLabell3);

				String lc = "";
				if(Living.getSatellite(propertyID)==true) {
					lc="yes";
				} else {
					lc="no";
				}
				JLabel lblNewLabellc = new JLabel(lc);
				lblNewLabellc.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabellc.setBounds(480, 180, 200, 20);
				frame.getContentPane().add(lblNewLabellc);
				
				JLabel lblNewLabell4 = new JLabel("Streaming: ");
				lblNewLabell4.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabell4.setBounds(400, 200, 200, 20);
				frame.getContentPane().add(lblNewLabell4);

				String ld = "";
				if(Living.getStreaming(propertyID)==true) {
					ld="yes";
				} else {
					ld="no";
				}
				JLabel lblNewLabelld = new JLabel(ld);
				lblNewLabelld.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelld.setBounds(480, 200, 200, 20);
				frame.getContentPane().add(lblNewLabelld);
				
				JLabel lblNewLabell5 = new JLabel("DVD Player: ");
				lblNewLabell5.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabell5.setBounds(400, 220, 200, 20);
				frame.getContentPane().add(lblNewLabell5);

				String le = "";
				if(Living.getDvdPlayer(propertyID)==true) {
					le="yes";
				} else {
					le="no";
				}
				JLabel lblNewLabelle = new JLabel(le);
				lblNewLabelle.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelle.setBounds(480, 220, 200, 20);
				frame.getContentPane().add(lblNewLabelle);
				
				JLabel lblNewLabell6 = new JLabel("Board Games: ");
				lblNewLabell6.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabell6.setBounds(400, 240, 200, 20);
				frame.getContentPane().add(lblNewLabell6);

				String lf = "";
				if(Living.getBoardGames(propertyID)==true) {
					lf="yes";
				} else {
					lf="no";
				}
				JLabel lblNewLabellf = new JLabel(lf);
				lblNewLabellf.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabellf.setBounds(480, 240, 200, 20);
				frame.getContentPane().add(lblNewLabellf);
				
				
				
				//utility
				JLabel lblNewLabelu = new JLabel("Utility Facility");
				lblNewLabelu.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabelu.setBounds(230, 320, 200, 20);
				frame.getContentPane().add(lblNewLabelu);
				
				JLabel lblNewLabelu1 = new JLabel("Central Heating: ");
				lblNewLabelu1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelu1.setBounds(230, 340, 200, 20);
				frame.getContentPane().add(lblNewLabelu1);

				String ua = "";
				if(Utility.getCentralHeating(propertyID)==true) {
					ua="yes";
				} else {
					ua="no";
				}
				JLabel lblNewLabelua = new JLabel(ua);
				lblNewLabelua.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelua.setBounds(330, 340, 200, 20);
				frame.getContentPane().add(lblNewLabelua);
				
				JLabel lblNewLabelu2 = new JLabel("Washing Machine: ");
				lblNewLabelu2.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelu2.setBounds(230, 360, 200, 20);
				frame.getContentPane().add(lblNewLabelu2);

				String ub = "";
				if(Utility.getWashingMachine(propertyID)==true) {
					ub="yes";
				} else {
					ub="no";
				}
				JLabel lblNewLabelub = new JLabel(ub);
				lblNewLabelub.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelub.setBounds(330, 360, 200, 20);
				frame.getContentPane().add(lblNewLabelub);
				
				JLabel lblNewLabelu3 = new JLabel("DryingMachine: ");
				lblNewLabelu3.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelu3.setBounds(230, 380, 200, 20);
				frame.getContentPane().add(lblNewLabelu3);

				String uc = "";
				if(Utility.getDryingMachine(propertyID)==true) {
					uc="yes";
				} else {
					uc="no";
				}
				JLabel lblNewLabeluc = new JLabel(uc);
				lblNewLabeluc.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabeluc.setBounds(330, 380, 200, 20);
				frame.getContentPane().add(lblNewLabeluc);
				
				JLabel lblNewLabelu4 = new JLabel("Fire Extinguisher: ");
				lblNewLabelu4.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelu4.setBounds(230, 400, 200, 20);
				frame.getContentPane().add(lblNewLabelu4);

				String ud = "";
				if(Utility.getFireExtinguisher(propertyID)==true) {
					ud="yes";
				} else {
					ud="no";
				}
				JLabel lblNewLabelud = new JLabel(ud);
				lblNewLabelud.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelud.setBounds(330, 400, 200, 20);
				frame.getContentPane().add(lblNewLabelud);
				
				JLabel lblNewLabelu5 = new JLabel("Smoke Alarm: ");
				lblNewLabelu5.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelu5.setBounds(230, 420, 200, 20);
				frame.getContentPane().add(lblNewLabelu5);

				String ue = "";
				if(Utility.getSmokeAlarm(propertyID)==true) {
					ue="yes";
				} else {
					ue="no";
				}
				JLabel lblNewLabelue = new JLabel(ue);
				lblNewLabelue.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelue.setBounds(330, 420, 200, 20);
				frame.getContentPane().add(lblNewLabelue);
				
				JLabel lblNewLabelu6 = new JLabel("First Aid Kit: ");
				lblNewLabelu6.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelu6.setBounds(230, 440, 200, 20);
				frame.getContentPane().add(lblNewLabelu6);

				String uf = "";
				if(Utility.getFirstAidKit(propertyID)==true) {
					uf="yes";
				} else {
					uf="no";
				}
				JLabel lblNewLabeluf = new JLabel(uf);
				lblNewLabeluf.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabeluf.setBounds(330, 440, 200, 20);
				frame.getContentPane().add(lblNewLabeluf);
				
				
				
				//outdoor
				JLabel lblNewLabelo = new JLabel("Outdoor Facility");
				lblNewLabelo.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabelo.setBounds(400, 320, 200, 20);
				frame.getContentPane().add(lblNewLabelo);
				
				JLabel lblNewLabelo1 = new JLabel("Free On Site Parking: ");
				lblNewLabelo1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelo1.setBounds(400, 340, 200, 20);
				frame.getContentPane().add(lblNewLabelo1);

				String oa = "";
				if(Outdoor.getFreeOnSiteParking(propertyID)==true) {
					oa="yes";
				} else {
					oa="no";
				}
				JLabel lblNewLabeloa = new JLabel(oa);
				lblNewLabeloa.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabeloa.setBounds(530, 340, 200, 20);
				frame.getContentPane().add(lblNewLabeloa);
				
				JLabel lblNewLabelo2 = new JLabel("On Road Parking: ");
				lblNewLabelo2.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelo2.setBounds(400, 360, 200, 20);
				frame.getContentPane().add(lblNewLabelo2);

				String ob = "";
				if(Outdoor.getOnRoadParking(propertyID)==true) {
					ob="yes";
				} else {
					ob="no";
				}
				JLabel lblNewLabelob = new JLabel(ob);
				lblNewLabelob.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelob.setBounds(530, 360, 200, 20);
				frame.getContentPane().add(lblNewLabelob);
				
				JLabel lblNewLabelo3 = new JLabel("Paid Car Park: ");
				lblNewLabelo3.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelo3.setBounds(400, 380, 200, 20);
				frame.getContentPane().add(lblNewLabelo3);

				String oc = "";
				if(Outdoor.getPaidCarPark(propertyID)==true) {
					oc="yes";
				} else {
					oc="no";
				}
				JLabel lblNewLabeloc = new JLabel(oc);
				lblNewLabeloc.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabeloc.setBounds(530, 380, 200, 20);
				frame.getContentPane().add(lblNewLabeloc);
				
				JLabel lblNewLabelo4 = new JLabel("Patio: ");
				lblNewLabelo4.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelo4.setBounds(400, 400, 200, 20);
				frame.getContentPane().add(lblNewLabelo4);

				String od = "";
				if(Outdoor.getPatio(propertyID)==true) {
					od="yes";
				} else {
					od="no";
				}
				JLabel lblNewLabelod = new JLabel(od);
				lblNewLabelod.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelod.setBounds(530, 400, 200, 20);
				frame.getContentPane().add(lblNewLabelod);
				
				JLabel lblNewLabelo5 = new JLabel("Barbeque: ");
				lblNewLabelo5.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabelo5.setBounds(400, 420, 200, 20);
				frame.getContentPane().add(lblNewLabelo5);

				String oe = "";
				if(Outdoor.getBarbeque(propertyID)==true) {
					oe="yes";
				} else {
					oe="no";
				}
				JLabel lblNewLabeloe = new JLabel(oe);
				lblNewLabeloe.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblNewLabeloe.setBounds(530, 420, 200, 20);
				frame.getContentPane().add(lblNewLabeloe);
				
				JButton btnBack = new JButton("Back");
				btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnBack.setBounds(179, 500, 200, 21);
				frame.getContentPane().add(btnBack);
				btnBack.addActionListener(e -> {

		        	GuestHomepage host = new GuestHomepage(guestID);
		        	host.frame.setVisible(true);
		        	 frame.dispose();
			      });
				
		JLabel l = new JLabel("");
		l.setBounds(55, 55, 100, 13);
		frame.getContentPane().add(l);
		
		
		
		
		
	}



}
