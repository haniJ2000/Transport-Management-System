package Interface;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.*;
import java.io.*;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.border.BevelBorder;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImageOp;

import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ZiptaMainCustomer {

	JFrame frame;
	private JLabel lblNewLabel_1 ;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTable table;
	private JTextField textField_10;
	private JLabel lblNewLabel;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnFemale;
	JPanel panel_2;
	JPanel panel_4;
	JPanel panel_5;
	JPanel panel_6;
	private JTextField textField_11;
	private JLabel lblNewLabel_11;
	private double distance;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZiptaMainCustomer window = new ZiptaMainCustomer();
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
	public ZiptaMainCustomer() {
		initialize();
	}
	public ZiptaMainCustomer(String username,String password) {
		
		try {
			initialize();
			textField.setText(username);
			textField_4.setText(password);
			lblNewLabel.setText(username);
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");
			String query_1  = "select * from customeraccount where Full_Name = '"+username+ "' and password = '"+password+"' ";
			 Statement stm_1  = connection.createStatement();
			 ResultSet rs = stm_1.executeQuery(query_1);
			 
			 if(rs.next()) {
			 String textField_data_gender = rs.getString(2);
			
			 if(textField_data_gender == "Male") {
				 rdbtnFemale.setSelected(false);
				 rdbtnNewRadioButton.setSelected(true);
				 
			 }else{
				 rdbtnNewRadioButton.setSelected(false);
				 rdbtnFemale.setSelected(true);
			 }
		   	 textField_1.setText(rs.getString(3));
			 textField_2.setText(rs.getString(4));
			 textField_3.setText(rs.getString(5));
			 textField_4.setText(rs.getString(6));
			 }
			 Statement stm_3  = connection.createStatement();
			 ResultSet rs_3 = stm_3.executeQuery("SELECT Image FROM image WHERE Name = '"+username+"' and type = 'Customer'");

		            if (rs_3.next()) {
		                InputStream imageStream = rs_3.getBinaryStream("Image");
		                BufferedImage image = ImageIO.read(imageStream);
		                
		                double widthScale = (double) lblNewLabel_1.getWidth() / image.getWidth();
                        double heightScale = (double) lblNewLabel_1.getHeight() / image.getHeight();
                        double scale = Math.min(widthScale, heightScale);

                        // Resize the image
                        Image scaledImage = image.getScaledInstance(
                                (int) (image.getWidth() * scale),
                                (int) (image.getHeight() * scale),
                                Image.SCALE_SMOOTH
                        );
		                
		                
		                lblNewLabel_1.setIcon(new ImageIcon(scaledImage));
		            }
			 connection.close();			 
		 
       
		}catch(Exception e){
			System.out.println(e.getMessage());	
		}
		panel_4.setVisible(false);
		panel_5.setVisible(false);
		panel_6.setVisible(false);
		panel_2.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1070, 770);
		frame.setTitle("Zipta- Transport Management System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 279, 733);
		panel.setBackground(new Color(0, 0, 64));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(37, 234, 201, 40);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(25, 10, 226, 173);
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), null, new Color(192, 192, 192), null));
		panel_1.setBackground(new Color(0, 0, 64));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 226, 173);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("D:\\JAVA\\Transport Mangment System\\src\\non profile.jpg"));
		lblNewLabel_1.setPreferredSize(new Dimension(350, 350));
		
		JButton uploadButton = new JButton("Upload Image");
		uploadButton.setBounds(71, 193, 125, 25);
		uploadButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		uploadButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                    public boolean accept(File f) {
                        if (f.isDirectory()) return true;
                        String name = f.getName().toLowerCase();
                        return name.endsWith(".png") || name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".gif");
                    }

                    public String getDescription() {
                        return "Image Files";
                    }
                });

                int returnVal = fileChooser.showOpenDialog(frame);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        // Load the selected image
                        BufferedImage originalImage = ImageIO.read(file);
                        FileInputStream imageInputStream = new FileInputStream(file);
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");
                        Statement stm_3  = connection.createStatement();
           			    ResultSet rs_3 = stm_3.executeQuery("SELECT Image FROM image WHERE Name = '"+lblNewLabel.getText()+"' and type = 'Customer'");

           		            if (rs_3.next()) {
           		            	
           		                InputStream imageStream = rs_3.getBinaryStream("Image");
           		             String query_2 = "UPDATE image SET Image = ? WHERE Name = ?";
                             PreparedStatement stmt = connection.prepareStatement(query_2); 
                             stmt.setString(2, lblNewLabel.getText());
                             stmt.setBinaryStream(1, imageInputStream, (int) file.length());
                             stmt.executeUpdate();
                             JOptionPane.showMessageDialog(uploadButton," Image updated successfully.");
                             connection.close();
                             
                            }else {
                            	try (PreparedStatement stmt_11 = connection.prepareStatement("INSERT INTO image (Name,type, Image) VALUES (?, ?,?)")) {

                                	   stmt_11.setString(1, lblNewLabel.getText());
                                	   stmt_11.setString(2, "Customer");
                                	   stmt_11.setBinaryStream(3, imageInputStream, (int) file.length());
                                       stmt_11.executeUpdate();
                                       JOptionPane.showMessageDialog(uploadButton," Image Added successfully.");
                                       connection.close();
                                   } catch (Exception e1) {
                                       e1.printStackTrace();
                                   }
                            	
                            } 	 
                                


                        // Calculate the scaling factors
                        double widthScale = (double) lblNewLabel_1.getWidth() / originalImage.getWidth();
                        double heightScale = (double) lblNewLabel_1.getHeight() / originalImage.getHeight();
                        double scale = Math.min(widthScale, heightScale);

                        // Resize the image
                        Image scaledImage = originalImage.getScaledInstance(
                                (int) (originalImage.getWidth() * scale),
                                (int) (originalImage.getHeight() * scale),
                                Image.SCALE_SMOOTH
                        );

                        // Set the scaled image to the label
                        lblNewLabel_1.setIcon(new ImageIcon(scaledImage));
                        

                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
			}
		});
		panel.add(uploadButton);
		
		JButton btnNewButton = new JButton("Account");
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(0, 328, 279, 40);
		panel.add(btnNewButton);
		
		JButton btnNewTrip = new JButton("New Trip");
		btnNewTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewTrip.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewTrip.setBounds(0, 396, 279, 40);
		panel.add(btnNewTrip);
		
		
		JButton btnTripHistory = new JButton("Trip History");
		btnTripHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String name = textField.getText();
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");
					String query_1  = "select * from history_newtrip where customer_name = '"+name+"' ";
					Statement stm_1  = connection.createStatement();
					ResultSet rs = stm_1.executeQuery(query_1);
					DefaultTableModel model  = (DefaultTableModel)table.getModel();
					model.setRowCount(0);
					while (rs.next()) {
	        			model.addRow(new String[] {rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(9),rs.getString(7)});
	        			 
	        		}
					connection.close();						}
					catch(Exception ex) {
						System.out.println("Error : " + ex.getCause());
					}
			}
		});
		
		btnTripHistory.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnTripHistory.setBounds(0, 462, 279, 40);
		panel.add(btnTripHistory);
		
		JButton btnContact = new JButton("Contact");
		btnContact.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnContact.setBounds(0, 535, 279, 40);
		panel.add(btnContact);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogOut.setForeground(new Color(255, 255, 0));
				btnLogOut.setBackground(new Color(128, 0, 0));
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogOut.setForeground(new Color(0, 0, 0));
				btnLogOut.setBackground(new Color(255, 255, 255));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Starting window = new Starting();
				window.frmZiptatransport.setVisible(true);
				frame.dispose();
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogOut.setBounds(0, 683, 279, 40);
		panel.add(btnLogOut);
		
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(254, 250, 231));
		panel_4.setBounds(274, 0, 782, 733);
		frame.getContentPane().add(panel_4);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(new Color(0, 0, 64));
		panel_3_1.setBounds(0, 0, 782, 125);
		panel_4.add(panel_3_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Trip Details");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_2_1.setBackground(new Color(0, 0, 64));
		lblNewLabel_2_1.setBounds(0, 0, 782, 100);
		panel_3_1.add(lblNewLabel_2_1);
		
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_2_1.setBackground(new Color(254, 250, 231));
		panel_1_2_1.setBounds(0, 124, 782, 609);
		panel_4.add(panel_1_2_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("PickUp Place Address    :");
		lblNewLabel_1_2.setBounds(10, 22, 130, 13);
		panel_1_2_1.add(lblNewLabel_1_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(192, 19, 508, 19);
		panel_1_2_1.add(textField_5);
		
		JLabel lblNewLabel_2_4 = new JLabel("Destination Address    :");
		lblNewLabel_2_4.setBounds(10, 73, 143, 16);
		panel_1_2_1.add(lblNewLabel_2_4);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(192, 70, 508, 19);
		panel_1_2_1.add(textField_6);
		
		JLabel lblNewLabel_3_1 = new JLabel("Vehical type     :");
		lblNewLabel_3_1.setBounds(10, 137, 117, 13);
		panel_1_2_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Card Number\r\n");
		lblNewLabel_4_1.setBounds(10, 460, 130, 13);
		panel_1_2_1.add(lblNewLabel_4_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(192, 457, 236, 19);
		panel_1_2_1.add(textField_7);
		
		JLabel lblNewLabel_5_1 = new JLabel("Expaird Date");
		lblNewLabel_5_1.setBounds(10, 517, 79, 13);
		panel_1_2_1.add(lblNewLabel_5_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(243, 514, 52, 19);
		panel_1_2_1.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(404, 514, 52, 19);
		panel_1_2_1.add(textField_9);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Car", "Bike", "Van", "Bus"}));
		comboBox_2.setBounds(192, 134, 122, 19);
		panel_1_2_1.add(comboBox_2);
		
		JRadioButton rdbtnCash = new JRadioButton("Cash");
		rdbtnCash.setBackground(new Color(254, 250, 231));
		rdbtnCash.setBounds(192, 191, 103, 21);
		panel_1_2_1.add(rdbtnCash);
		
		JRadioButton rdbtnCard = new JRadioButton("Card");
		rdbtnCard.setBackground(new Color(254, 250, 231));
		rdbtnCard.setBounds(325, 191, 103, 21);
		panel_1_2_1.add(rdbtnCard);
		
		rdbtnCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnCash.isSelected()) {
					rdbtnCard.setSelected(false);
					
				}
			}
		});
		rdbtnCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnCard.isSelected()) {
					rdbtnCash.setSelected(false);
					
				}
			}
		});
		
		JComboBox comboBox_2_1 = new JComboBox();
		comboBox_2_1.setModel(new DefaultComboBoxModel(new String[] {"Visa", "Master"}));
		comboBox_2_1.setBounds(192, 406, 122, 19);
		panel_1_2_1.add(comboBox_2_1);
		
		
		JLabel lblNewLabel_6_1_2 = new JLabel("IF the payment on card\r\n");
		lblNewLabel_6_1_2.setForeground(new Color(77, 77, 77));
		lblNewLabel_6_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6_1_2.setBounds(266, 362, 246, 13);
		panel_1_2_1.add(lblNewLabel_6_1_2);
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String mobile_number = textField_3.getText();
				 String name = textField.getText();
				 String pickup = textField_5.getText(); 
				 String destination = textField_6.getText(); 
				 String type = "Car";
				 int rate = 0;
                 if(comboBox_2.getSelectedItem() == "Bike") {
                 	type = "Bike";
                 }
                 if(comboBox_2.getSelectedItem() == "Bus") {
                 	type = "Bus";
                 }
                 if(comboBox_2.getSelectedItem() == "Van") {
                 	type = "Van";
                 }
                 String card = "Visa";
                 if(comboBox_2_1.getSelectedItem() == "Master") {
                 	card = "Master";
                 }
                 String number = textField_7.getText();
                 String month = textField_8.getText();
                 String year = textField_9.getText();
                 
                 String method = "Cash";
 				if(rdbtnCash.isSelected()) {
 					 method = "Cash";
 					 
 				}
 				if(rdbtnCard.isSelected()) {
 					 method = "Card";
 					try {
 	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");

 	                    String query = "INSERT INTO paymentcard values('" + name + "','" + card + "','" + number + "','" + month + "','" + year + "')";
 	                   
 	                    Statement sta = connection.createStatement();
 	                    sta.executeUpdate(query);
 	                    
 	                  
 	                    connection.close();
 	                } catch (Exception exception) {
 	                    exception.printStackTrace();
 	                }
 					
 				}
				 
 				try {
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");

	                    String query = "INSERT INTO newtrip values('" + name + "','" + pickup + "','" + destination + "','" + type + "','" + method + "','" + mobile_number + "','" + rate + "')";
	                    Statement sta = connection.createStatement();
	                    sta.executeUpdate(query);
	                    
	                    
	                    String query_1 = "INSERT INTO history_newtrip values('" + name + "','" + pickup + "','" + destination + "','" + type + "','" + method + "','" + mobile_number + "','" + rate + "','','"+String.valueOf(distance)+"')";  
	                    Statement sta_1 = connection.createStatement();
	                    sta_1.executeUpdate(query_1);
	                    connection.close();
	                } 
 				catch (Exception exception) {
	                    exception.printStackTrace();
	                }
 				finally{
 					textField_5.setText(null); 
 					textField_6.setText(null); 
 					textField_7.setText(null);
 	                textField_8.setText(null);
 	                textField_9.setText(null);
 	                comboBox_2.setSelectedItem("Car");
 	                comboBox_2_1.setSelectedItem("Visa");
 	                rdbtnCard.setSelected(false);
 	                rdbtnCash.setSelected(true);
 	                textField_11.setText(null);
 	               lblNewLabel_11.setText(null);
 	                
 	                
 	               JOptionPane.showMessageDialog(btnNewButton_2, "Successfully sent");
 	             
 				}
 				
				
				
			}
		});
		
		
		
		
		
		
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(0, 64, 0));
		btnNewButton_2.setBounds(311, 565, 117, 34);
		panel_1_2_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_7_1 = new JLabel("Payment Method      :");
		lblNewLabel_7_1.setBounds(10, 195, 130, 13);
		panel_1_2_1.add(lblNewLabel_7_1);
		
		
		
		
		JLabel lblNewLabel_6_3_1 = new JLabel("ex: **** **** **** 1234");
		lblNewLabel_6_3_1.setForeground(new Color(77, 77, 77));
		lblNewLabel_6_3_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_6_3_1.setBounds(438, 460, 297, 13);
		panel_1_2_1.add(lblNewLabel_6_3_1);
		
		
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Month:");
		lblNewLabel_5_1_1.setBounds(186, 517, 79, 13);
		panel_1_2_1.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_1_2 = new JLabel("Year    :");
		lblNewLabel_5_1_2.setBounds(355, 517, 79, 13);
		panel_1_2_1.add(lblNewLabel_5_1_2);
		
		
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Crad type     :");
		lblNewLabel_3_1_1.setBounds(10, 409, 117, 13);
		panel_1_2_1.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_10 = new JLabel("Distance (Km)             :");
		lblNewLabel_10.setBounds(10, 255, 143, 13);
		panel_1_2_1.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Rs.");
		lblNewLabel_11.setBounds(600, 255, 172, 13);
		panel_1_2_1.add(lblNewLabel_11);
		
		textField_11 = new JTextField();
		textField_11.setBounds(192, 252, 96, 19);
		panel_1_2_1.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_10_1 = new JLabel("Price            :");
		lblNewLabel_10_1.setBounds(483, 255, 89, 13);
		panel_1_2_1.add(lblNewLabel_10_1);
		
		JButton btnNewButton_5 = new JButton("Enter");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				distance = Double.valueOf(textField_11.getText());
				
				 if(comboBox_2.getSelectedItem() == "Bike") {
					 distance = distance*40;
	                 }
	                 if(comboBox_2.getSelectedItem() == "Bus") {
	                	 distance = distance*1000;
	                 }
	                 if(comboBox_2.getSelectedItem() == "Van") {
	                	 distance = distance*500;
	                 }
	                
	                 if(comboBox_2.getSelectedItem() == "Car") {
	                	 distance = distance*70;
	                 }
	                 lblNewLabel_11.setText("Rs. "+String.valueOf(distance));
				
			}
		});
		btnNewButton_5.setBounds(309, 251, 85, 21);
		panel_1_2_1.add(btnNewButton_5);
		
	
		
		
		
		
		panel_2 = new JPanel();
		panel_2.setBounds(274, 0, 782, 733);
		frame.getContentPane().add(panel_2);
		panel_2.setBackground(new Color(254, 250, 231));
		panel_2.setLayout(null);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_2.setBackground(new Color(254, 250, 231));
		panel_1_2.setBounds(0, 117, 782, 616);
		panel_2.add(panel_1_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Full name   :");
		lblNewLabel_1_1.setBounds(16, 69, 79, 13);
		panel_1_2.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(121, 66, 456, 19);
		panel_1_2.add(textField);
		
		JLabel lblNewLabel_2_3 = new JLabel("Age    :");
		lblNewLabel_2_3.setBounds(16, 181, 45, 13);
		panel_1_2.add(lblNewLabel_2_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(121, 178, 96, 19);
		panel_1_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("ex : cdisura@gmail.com");
		textField_2.setColumns(10);
		textField_2.setBounds(121, 241, 208, 19);
		panel_1_2.add(textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email    :");
		lblNewLabel_3.setBounds(16, 244, 45, 13);
		panel_1_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mobile No    :");
		lblNewLabel_4.setBounds(16, 302, 85, 13);
		panel_1_2.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(121, 299, 208, 19);
		panel_1_2.add(textField_3);
		
		JLabel lblNewLabel_5 = new JLabel("Password   :");
		lblNewLabel_5.setBounds(16, 374, 79, 13);
		panel_1_2.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(121, 371, 186, 19);
		panel_1_2.add(textField_4);
		
		JLabel lblNewLabel_6 = new JLabel("(more than 8 characters which include .,@,1,a etc)");
		lblNewLabel_6.setForeground(new Color(77, 77, 77));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_6.setBounds(347, 374, 297, 13);
		panel_1_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("ex :+94759464464");
		lblNewLabel_6_1_1.setForeground(new Color(77, 77, 77));
		lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_6_1_1.setBounds(377, 302, 246, 13);
		panel_1_2.add(lblNewLabel_6_1_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("ex : cdisura@gmail.com");
		lblNewLabel_6_2.setForeground(new Color(77, 77, 77));
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_6_2.setBounds(362, 244, 208, 13);
		panel_1_2.add(lblNewLabel_6_2);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender = "null";
				if(rdbtnNewRadioButton.isSelected()) {
					 gender = "Male";
					
				}
				if(rdbtnFemale.isSelected()) {
					 gender = "Female";
					
				}
				
				
			       String fullName = textField.getText();
	                String age = textField_1.getText();
	                String name = lblNewLabel.getText();
	                String email = textField_2.getText();
	                String mobileNumber = textField_3.getText();
	                int len = mobileNumber.length();
	                String password = textField_4.getText();
	                int len_password =  password.length();

	                
	                if (len != 10 && len_password <8) {
	                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
	                }

	                try {
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");

	                    String query = "UPDATE customeraccount SET  Full_Name = '"+fullName+"',Gender = '"+gender+"', Age = '"+age+"', Email= '"+email+"',Mobile_No= '"+mobileNumber+"' , password= '"+password+"' WHERE Full_Name = '"+name+"'";

	                    Statement sta = connection.createStatement();
	                    sta.executeUpdate(query);
	                    JOptionPane.showMessageDialog(btnNewButton_1, "Your Account has been Updated");
	                    connection.close();
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }finally{
	                	lblNewLabel.setText(fullName);
	                	ZiptaMainCustomer window = new ZiptaMainCustomer(fullName,password);
						window.frame.setVisible(true);
	    				frame.dispose();
	                }
	
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 64, 0));
		btnNewButton_1.setBounds(274, 440, 120, 32);
		panel_1_2.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Delete");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String fullName = textField.getText(); 
				 String password = textField_4.getText();
				try {
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");

	                    String query = "DELETE FROM customeraccount WHERE Full_Name = '"+fullName+"' AND Password = '"+password+"'" ;
	                    Statement sta = connection.createStatement();
	                    sta.executeUpdate(query);
	                    JOptionPane.showMessageDialog(btnNewButton_1_1, "Your Account has been deleted");
	                    Starting window = new Starting();
						window.frmZiptatransport.setVisible(true);
						frame.disable();
						
	                   
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
				
			}
		});
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1_1.setForeground(new Color(255, 255, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1_1.setForeground(new Color(255, 255, 255));
			}
		});
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setBackground(new Color(128, 0, 0));
		btnNewButton_1_1.setBounds(25, 564, 85, 21);
		panel_1_2.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_7 = new JLabel("Gender");
		lblNewLabel_7.setBounds(16, 123, 45, 13);
		panel_1_2.add(lblNewLabel_7);
		
		rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBackground(new Color(254, 250, 231));
		rdbtnNewRadioButton.setBounds(121, 119, 103, 21);
		panel_1_2.add(rdbtnNewRadioButton);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(254, 250, 231));
		rdbtnFemale.setBounds(274, 119, 103, 21);
		panel_1_2.add(rdbtnFemale);
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					rdbtnFemale.setSelected(false);
					
				}
			}
		});
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnFemale.isSelected()) {
					rdbtnNewRadioButton.setSelected(false);
					
				}
			}
		});
		
		JLabel lblNewLabel_6_2_1 = new JLabel("Do you wnat to delete your account");
		lblNewLabel_6_2_1.setForeground(new Color(77, 77, 77));
		lblNewLabel_6_2_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_6_2_1.setBounds(16, 530, 208, 13);
		panel_1_2.add(lblNewLabel_6_2_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 64));
		panel_3.setBounds(0, 0, 782, 125);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Account Details");
		lblNewLabel_2.setBounds(0, 0, 782, 100);
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(new Color(0, 0, 64));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 35));
		
		panel_5 = new JPanel();
		panel_5.setBounds(272, 0, 782, 733);
		frame.getContentPane().add(panel_5);
		panel_5.setBackground(new Color(253, 247, 217));
		panel_5.setLayout(null);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBounds(0, 0, 782, 125);
		panel_3_2.setLayout(null);
		panel_3_2.setBackground(new Color(0, 0, 64));
		panel_5.add(panel_3_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Trip History");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_2_2.setBackground(new Color(0, 0, 64));
		lblNewLabel_2_2.setBounds(0, 0, 782, 100);
		panel_3_2.add(lblNewLabel_2_2);
		
		JButton btnNewButton_3 = new JButton("Refresh");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String name = textField.getText();
					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");
						String query_1  = "select * from history_newtrip where customer_name = '"+name+"' ";
						Statement stm_1  = connection.createStatement();
						ResultSet rs = stm_1.executeQuery(query_1);
						DefaultTableModel model  = (DefaultTableModel)table.getModel();
						model.setRowCount(0);
						while (rs.next()) {
		        			model.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(7)});
		        			 
		        		}
						connection.close();						}
						catch(Exception ex) {
							System.out.println("Error : " + ex.getCause());
						}
				
			}
		});
		btnNewButton_3.setBackground(new Color(249, 249, 0));
		btnNewButton_3.setBounds(697, 94, 85, 21);
		panel_3_2.add(btnNewButton_3);
		
		table = new JTable();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	            @Override
	            public void valueChanged(ListSelectionEvent e) {
	                if (e.getValueIsAdjusting()) {
	                    return; // Ignore extra events.
	                }

	                int selectedRow = table.getSelectedRow();
	                int selectedColumn = table.getSelectedColumn();

	                if (selectedRow >= 0 && selectedColumn == 5 ) {
	                    String cellValue = (String) table.getValueAt(selectedRow, 1);
	                    String rate_1 = JOptionPane.showInputDialog(null, "Rate 0-5");
	                    int rate = Integer.valueOf(rate_1);
	                    table.setValueAt(rate,selectedRow, selectedColumn);
	                    String Mobile = textField_3.getText();
	                    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610")) {
	                        String updateSQL = "UPDATE newtrip SET rate = ? WHERE pickup = ?"; // Modify the query accordingly
	                        
	                        PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
	                        preparedStatement.setInt(1, rate);
	                        preparedStatement.setString(2, cellValue);
	                        int rowsUpdated = preparedStatement.executeUpdate();
	                        
                            String updateSQL_1 = "UPDATE history_newtrip SET rate = ? WHERE pickup = ?"; // Modify the query accordingly
	                        
	                        PreparedStatement preparedStatement_1 = connection.prepareStatement(updateSQL_1);
	                        preparedStatement_1.setInt(1, rate);
	                        preparedStatement_1.setString(2, cellValue);
	                        int rowsUpdated_1 = preparedStatement_1.executeUpdate();

	                        if (rowsUpdated > 0) {
	                        	JOptionPane.showMessageDialog(null, "Thank you for rating");
	                            
	                        } else {
	                            System.out.println("There is a error");
	                        }
	                    } catch (Exception e4) {
	                        e4.printStackTrace();
	                    }
	                   
	                }
	                    
	                }
	            
	        });
		
		
				
				table.setBackground(new Color(236, 236, 236));
				table.setBorder(new LineBorder(new Color(0, 0, 0)));
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null},
					},
					new String[] {
						"Name", "PickUp", "Destination", "Type", "Cash/Card", "Reviewe"
					}
				) {
					boolean[] columnEditables = new boolean[] {
						false, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				table.setBounds(10, 182, 762, 551);
				panel_5.add(table);
				
				JPanel panel_7 = new JPanel();
				panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel_7.setBackground(new Color(64, 0, 0));
				panel_7.setBounds(10, 158, 128, 25);
				panel_5.add(panel_7);
				
				JLabel lblNewLabel_8 = new JLabel("Pickup");
				panel_7.add(lblNewLabel_8);
				lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_8.setForeground(new Color(255, 255, 255));
				lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_8.setBackground(new Color(255, 255, 255));
				
				JPanel panel_7_2 = new JPanel();
				panel_7_2.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel_7_2.setBackground(new Color(64, 0, 0));
				panel_7_2.setBounds(262, 158, 128, 25);
				panel_5.add(panel_7_2);
				
				JLabel lblNewLabel_8_2 = new JLabel("Type");
				lblNewLabel_8_2.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_8_2.setForeground(Color.WHITE);
				lblNewLabel_8_2.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_8_2.setBackground(Color.WHITE);
				panel_7_2.add(lblNewLabel_8_2);
				
				JPanel panel_7_3 = new JPanel();
				panel_7_3.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel_7_3.setBackground(new Color(64, 0, 0));
				panel_7_3.setBounds(391, 158, 128, 25);
				panel_5.add(panel_7_3);
				
				JLabel lblNewLabel_8_3 = new JLabel("Cash/Card");
				lblNewLabel_8_3.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_8_3.setForeground(Color.WHITE);
				lblNewLabel_8_3.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_8_3.setBackground(Color.WHITE);
				panel_7_3.add(lblNewLabel_8_3);
				
				JPanel panel_7_2_1 = new JPanel();
				panel_7_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel_7_2_1.setBackground(new Color(64, 0, 0));
				panel_7_2_1.setBounds(139, 158, 122, 25);
				panel_5.add(panel_7_2_1);
				
				JLabel lblNewLabel_8_1 = new JLabel("Destination");
				lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_8_1.setForeground(Color.WHITE);
				lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_8_1.setBackground(Color.WHITE);
				panel_7_2_1.add(lblNewLabel_8_1);
				
				JPanel panel_7_3_1 = new JPanel();
				panel_7_3_1.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel_7_3_1.setBackground(new Color(64, 0, 0));
				panel_7_3_1.setBounds(521, 158, 122, 25);
				panel_5.add(panel_7_3_1);
				
				JLabel lblNewLabel_8_3_1 = new JLabel("price");
				lblNewLabel_8_3_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_8_3_1.setForeground(Color.WHITE);
				lblNewLabel_8_3_1.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_8_3_1.setBackground(Color.WHITE);
				panel_7_3_1.add(lblNewLabel_8_3_1);
				
				JPanel panel_7_3_1_1 = new JPanel();
				panel_7_3_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel_7_3_1_1.setBackground(new Color(64, 0, 0));
				panel_7_3_1_1.setBounds(644, 158, 128, 25);
				panel_5.add(panel_7_3_1_1);
				
				JLabel lblNewLabel_8_3_1_1 = new JLabel("Rating (0-5)");
				lblNewLabel_8_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_8_3_1_1.setForeground(Color.WHITE);
				lblNewLabel_8_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblNewLabel_8_3_1_1.setBackground(Color.WHITE);
				panel_7_3_1_1.add(lblNewLabel_8_3_1_1);
		
		panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(254, 250, 231));
		panel_6.setBounds(274, 0, 782, 733);
		frame.getContentPane().add(panel_6);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBackground(new Color(0, 0, 64));
		panel_6_1.setBounds(0, 0, 782, 125);
		panel_6.add(panel_6_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Contact Details");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_6_1.setBackground(new Color(0, 0, 64));
		lblNewLabel_6_1.setBounds(0, 0, 782, 100);
		panel_6_1.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_9 = new JLabel("Subject   :");
		lblNewLabel_9.setBounds(10, 159, 76, 27);
		panel_6.add(lblNewLabel_9);
		
		textField_10 = new JTextField();
		textField_10.setBounds(129, 163, 462, 19);
		panel_6.add(textField_10);
		textField_10.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(132, 236, 459, 256);
		panel_6.add(textArea);
		
		JLabel lblNewLabel_9_1 = new JLabel("Message   :");
		lblNewLabel_9_1.setBounds(10, 235, 76, 27);
		panel_6.add(lblNewLabel_9_1);
		
		JButton btnNewButton_4 = new JButton("Submit");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = textField_2.getText();
                String mobileNumber = textField_3.getText();
				String name = textField.getText();
				String subject = textField_10.getText();
				String message = textArea.getText();
				String type = "Customer";
				
				 try {
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");

	                    String query = "INSERT INTO querries values('" + type + "','" + name + "','" + subject + "','" + message + "','" + email + "','" + mobileNumber + "')";

	                    Statement sta = connection.createStatement();
	                    sta.executeUpdate(query);
	                    connection.close();
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
				 finally {
					 JOptionPane.showMessageDialog(btnNewButton_4, "Successfully sent");
					 textField_10.setText(null);
			         textArea.setText(null);
				 }
				
				}
		});
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(new Color(0, 64, 0));
		btnNewButton_4.setBounds(288, 572, 118, 35);
		panel_6.add(btnNewButton_4);
		
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(501, 188, 1, 1);
		frame.getContentPane().add(desktopPane);
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_2.setVisible(true);
				
			}
		});
		
		
		
		
		btnNewTrip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
				panel_4.setVisible(true);
				
				
			}
		});
		
		btnTripHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.setVisible(false);
				panel_4.setVisible(false);
				panel_6.setVisible(false);
				panel_5.setVisible(true);
			}
		});
		
		btnContact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_2.setVisible(false);
				panel_6.setVisible(true);
				
			}
		});
  
	}
}
