package Interface;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

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
import javax.swing.JTabbedPane;

import javax.swing.JDesktopPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

public class ZiptaMainDriver {

	JFrame frame;
	private JLabel lblNewLabel_1;
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
	private JTextField textField_10;
	private JTable table;
	private JTable table_1;
	private JTextField textField_11;
	private JLabel lblNewLabel;
	private JLabel rating_label;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnFemale;
	private JComboBox comboBox_2;
	JPanel panel_2;
	JPanel panel_4;
	JPanel panel_5;
	JPanel panel_6;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZiptaMainDriver window = new ZiptaMainDriver();
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
	public ZiptaMainDriver() {
		initialize();
	}
	public ZiptaMainDriver(String username,String password) {
		
		try {
			initialize();
			textField.setText(username);
			textField_4.setText(password);
			lblNewLabel.setText(username);
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");
			String query_1  = "select * from driverpersonalaccount  where Full_Name = '"+username+ "' and password = '"+password+"'";
			 Statement stm_1  = connection.createStatement();
			 ResultSet rs = stm_1.executeQuery(query_1);
			 String query_2  = "select * from drivervehicalaccount  where Driver_name = '"+username+ "' ";
			 Statement stm_2  = connection.createStatement();
			 ResultSet rs_1 = stm_2.executeQuery(query_2);
			 
			 if(rs.next() && rs_1.next()) {
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
			 
			 String textField_data_type = rs_1.getString(2);
			
			 if(textField_data_type == "Car") {
				 comboBox_2.setSelectedItem(rs_1.getString(2));
				 
			 }else if(textField_data_type == "Bike"){
				 comboBox_2.setSelectedItem(rs_1.getString(2));
				
			 }else if(textField_data_type == "Van"){
				 comboBox_2.setSelectedItem(rs_1.getString(2));
				
			 }else if(textField_data_type == "Bus"){
				 comboBox_2.setSelectedItem(rs_1.getString(2));
				
			 }
		   	 textField_5.setText(rs_1.getString(4));
			 textField_6.setText(rs_1.getString(5));
			 textField_7.setText(rs_1.getString(7));
			 textField_8.setText(rs_1.getString(6));
			 textField_9.setText(rs_1.getString(3));
			 textField_10.setText(rs_1.getString(8));
			 }
			 
			 
			 Statement stm_3  = connection.createStatement();
			 ResultSet rs_3 = stm_3.executeQuery("SELECT Image FROM image WHERE Name = '"+username+"' and type = 'Driver'");

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
		            
		     String query_3  = "select * from accepttable where Name_Driver = '"+username+"'";	
		     Statement stm_5  = connection.createStatement();
		     ResultSet rs_5 = stm_5.executeQuery("SELECT rate FROM history_newtrip WHERE Driver_name = '"+lblNewLabel.getText()+"'");
		     double rate= 0;
		     while (rs_5.next()) {
		    	 rate = rate + rs_5.getInt(1);	 
	            }
		     
		     String countSQL = "SELECT COUNT(*) FROM accepttable WHERE  Name_Driver = '"+username+"'";
	         PreparedStatement preparedStatement = connection.prepareStatement(countSQL);
	         ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                int rowCount = resultSet.getInt(1);
	                rate = rate/rowCount;
	                String rate_2 = String.valueOf(rate);
	                rating_label.setText(rate_2 + " Stars");
	                
	                
	            } else {
	                System.out.println("No rows match the criteria.");
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
		frame.setTitle("Zipta- Transport Management System");
		frame.setBounds(100, 100, 1070, 770);
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

                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
			}
		});
		panel.add(uploadButton);
		
		JButton btnNewButton = new JButton("Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(0, 328, 279, 40);
		panel.add(btnNewButton);
		
		JButton btnNewTrip = new JButton("New Rides");
		btnNewTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");
					String query_1  = "select * from newtrip";
					Statement stm_1  = connection.createStatement();
					ResultSet rs = stm_1.executeQuery(query_1);
					DefaultTableModel model  = (DefaultTableModel)table.getModel();
					model.setRowCount(0);
					while (rs.next()) {
	        			model.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(5),"Accept"});
	        			table.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer_1());
						table.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JTextField(),textField)); 
	        		}
					connection.close();						}
					catch(Exception ex) {
						System.out.println("Error : " + ex.getCause());
					}
			}
		});
		
		btnNewTrip.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewTrip.setBounds(0, 396, 279, 40);
		panel.add(btnNewTrip);
		
		
		JButton btnTripHistory = new JButton("Ride History");
		btnTripHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String name = textField.getText();
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");
					String query_1  = "select * from accepttable where Name_Driver = '"+name+"'";
					Statement stm_1  = connection.createStatement();
					ResultSet rs = stm_1.executeQuery(query_1);
					DefaultTableModel model  = (DefaultTableModel)table_1.getModel();
					model.setRowCount(0);
					while (rs.next()) {
						
						model.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(6),rs.getString(4)});
					}
					connection.close();	
					}
					catch(Exception e1) {
						System.out.println("Error : " + e1.getCause());
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
		
		rating_label = new JLabel("");
		rating_label.setHorizontalAlignment(SwingConstants.CENTER);
		rating_label.setForeground(Color.WHITE);
		rating_label.setFont(new Font("Tahoma", Font.BOLD, 16));
		rating_label.setBounds(37, 278, 201, 40);
		panel.add(rating_label);
		
	

		
		
		
		
		
		panel_2 = new JPanel();
		panel_2.setBounds(274, 0, 782, 733);
		frame.getContentPane().add(panel_2);
		panel_2.setBackground(new Color(254, 250, 231));
		panel_2.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 100, 792, 633);
		panel_2.add(tabbedPane);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_2.setBackground(new Color(254, 250, 231));
		tabbedPane.addTab("Personal Details", null, panel_1_2, null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Full name   :");
		lblNewLabel_1_1.setBounds(10, 93, 79, 13);
		panel_1_2.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(121, 90, 538, 19);
		panel_1_2.add(textField);
		
		JLabel lblNewLabel_2_3 = new JLabel("Age    :");
		lblNewLabel_2_3.setBounds(10, 235, 45, 13);
		panel_1_2.add(lblNewLabel_2_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(121, 232, 96, 19);
		panel_1_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("ex : cdisura@gmail.com");
		textField_2.setColumns(10);
		textField_2.setBounds(121, 301, 208, 19);
		panel_1_2.add(textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email    :");
		lblNewLabel_3.setBounds(10, 304, 45, 13);
		panel_1_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mobile No    :");
		lblNewLabel_4.setBounds(10, 382, 85, 13);
		panel_1_2.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(121, 379, 208, 19);
		panel_1_2.add(textField_3);
		
		JLabel lblNewLabel_5 = new JLabel("New Password   :");
		lblNewLabel_5.setBounds(10, 461, 79, 13);
		panel_1_2.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(121, 458, 186, 19);
		panel_1_2.add(textField_4);
		
		JLabel lblNewLabel_6 = new JLabel("(more than 8 characters which include .,@,1,a etc)");
		lblNewLabel_6.setForeground(new Color(77, 77, 77));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_6.setBounds(347, 461, 297, 13);
		panel_1_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("ex :+94759464464");
		lblNewLabel_6_1_1.setForeground(new Color(77, 77, 77));
		lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_6_1_1.setBounds(362, 382, 246, 13);
		panel_1_2.add(lblNewLabel_6_1_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("ex : cdisura@gmail.com");
		lblNewLabel_6_2.setForeground(new Color(77, 77, 77));
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_6_2.setBounds(347, 304, 208, 13);
		panel_1_2.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_7 = new JLabel("Gender");
		lblNewLabel_7.setBounds(10, 161, 45, 13);
		panel_1_2.add(lblNewLabel_7);
		
		rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBackground(new Color(254, 250, 231));
		rdbtnNewRadioButton.setBounds(121, 157, 103, 21);
		panel_1_2.add(rdbtnNewRadioButton);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(254, 250, 231));
		rdbtnFemale.setBounds(286, 157, 103, 21);
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
		
		JButton btnNewButton_2 = new JButton("Next");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int currentTab = tabbedPane.getSelectedIndex();
                if (currentTab < tabbedPane.getTabCount() - 1) {
                    tabbedPane.setSelectedIndex(currentTab + 1);
                }
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(0, 64, 0));
		btnNewButton_2.setBounds(648, 558, 85, 21);
		panel_1_2.add(btnNewButton_2);
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Vehical Details", null, panel_7, null);
		panel_7.setLayout(null);
		
		JPanel panel_1_2_3 = new JPanel();
		panel_1_2_3.setLayout(null);
		panel_1_2_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_2_3.setBackground(new Color(254, 250, 231));
		panel_1_2_3.setBounds(0, 0, 777, 606);
		panel_7.add(panel_1_2_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Vehical Type   :");
		lblNewLabel_1_3.setBounds(10, 35, 96, 13);
		panel_1_2_3.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Vehical Brand    :");
		lblNewLabel_2_3_1.setBounds(19, 163, 96, 13);
		panel_1_2_3.add(lblNewLabel_2_3_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(200, 160, 96, 19);
		panel_1_2_3.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("ex : cdisura@gmail.com");
		textField_6.setColumns(10);
		textField_6.setBounds(200, 226, 122, 19);
		panel_1_2_3.add(textField_6);
		
		JLabel lblNewLabel_3_3 = new JLabel("Model    :");
		lblNewLabel_3_3.setBounds(19, 229, 65, 13);
		panel_1_2_3.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_4_3 = new JLabel("Vehical plate number :");
		lblNewLabel_4_3.setBounds(19, 350, 131, 13);
		panel_1_2_3.add(lblNewLabel_4_3);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(200, 344, 208, 19);
		panel_1_2_3.add(textField_7);
		
		JLabel lblNewLabel_5_3 = new JLabel("Driving License number");
		lblNewLabel_5_3.setBounds(19, 402, 122, 16);
		panel_1_2_3.add(lblNewLabel_5_3);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(200, 401, 186, 19);
		panel_1_2_3.add(textField_8);
		
		JLabel lblNewLabel_6_1_3 = new JLabel("ex: if brand is benz model- C class");
		lblNewLabel_6_1_3.setForeground(new Color(77, 77, 77));
		lblNewLabel_6_1_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_6_1_3.setBounds(351, 229, 246, 13);
		panel_1_2_3.add(lblNewLabel_6_1_3);
		
		JLabel lblNewLabel_6_2_3 = new JLabel("ex : benz,audi etc");
		lblNewLabel_6_2_3.setForeground(new Color(77, 77, 77));
		lblNewLabel_6_2_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_6_2_3.setBounds(337, 163, 208, 13);
		panel_1_2_3.add(lblNewLabel_6_2_3);
		
		comboBox_2 = new JComboBox();
		
			comboBox_2.setBounds(200, 32, 122, 19);
			panel_1_2_3.add(comboBox_2);
			
			JButton btnNewButton_4 = new JButton("Submit");
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String name = lblNewLabel.getText();
					String fullName = textField.getText();
	            String age = textField_1.getText();  
	            String email = textField_2.getText();
					String password = textField_4.getText();
					 String mobileNumber = textField_3.getText(); 
					 String License_number = textField_8.getText();
					String gender = "null";
					if(rdbtnNewRadioButton.isSelected()) {
						 gender = "Male";
						
					}
					if(rdbtnFemale.isSelected()) {
						 gender = "Female";
					}
				
	                try {
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");

	                    String query = "UPDATE driverpersonalaccount SET  Full_Name = '"+fullName+"',Gender = '"+gender+"', Age = '"+age+"', Email= '"+email+"',Mobile_No= '"+mobileNumber+"' , password= '"+password+"',licence_No= '"+License_number+"' WHERE Full_Name = '"+name+"'";
	                    
	                    String type = "Car";
	                    if(comboBox_2.getSelectedItem() == "Bike") {
	                    	type = "Bike";
	                    }
	                    if(comboBox_2.getSelectedItem() == "Bus") {
	                    	type = "Bus";
	                    }
	                    if(comboBox_2.getSelectedItem() == "Van") {
	                    	type = "Van";
	                    }
	                    
	                    String seats_No = textField_9.getText();  
	                    String brand = textField_5.getText();
	                    String model = textField_6.getText();
	                    String colour = textField_10.getText();
	                    String plate_number = textField_7.getText();
	                    
	                    
	         
	                    String query_1 = "UPDATE drivervehicalaccount SET  Driver_name = '"+fullName+"',Vehical_type = '"+type+"', seats_no = '"+seats_No+"' ,brand= '"+brand+"' , model= '"+model+"',colour= '"+colour+"',plate_no= '"+plate_number+"',license_no= '"+License_number+"' WHERE Driver_name = '"+name+"'";
			                  
	                    
	                    Statement sta = connection.createStatement();
	                    sta.executeUpdate(query);
	                    sta.executeUpdate(query_1);
	                    int currentTab = tabbedPane.getSelectedIndex();
	                    if (currentTab > 0) {
	                        tabbedPane.setSelectedIndex(currentTab - 1);
	                    }
	                    JOptionPane.showMessageDialog(btnNewButton_4, "Your Account has been Updated");
	                    connection.close();
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }finally{
	                	lblNewLabel.setText(fullName);
	                	ZiptaMainDriver window = new ZiptaMainDriver(fullName,password);
	    				window.frame.setVisible(true);
	    				frame.dispose();
	                }
				}
			});
			btnNewButton_4.setForeground(Color.WHITE);
			btnNewButton_4.setBackground(new Color(0, 64, 0));
			btnNewButton_4.setBounds(651, 465, 85, 21);
			panel_1_2_3.add(btnNewButton_4);
			
			JButton btnNewButton_1_3 = new JButton("Back");
			btnNewButton_1_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int currentTab = tabbedPane.getSelectedIndex();
                if (currentTab > 0) {
                    tabbedPane.setSelectedIndex(currentTab - 1);
                }
				}
			});
			btnNewButton_1_3.setForeground(Color.WHITE);
			btnNewButton_1_3.setBackground(new Color(192, 192, 192));
			btnNewButton_1_3.setBounds(21, 465, 85, 21);
			panel_1_2_3.add(btnNewButton_1_3);
			
			JLabel lblNewLabel_7_3 = new JLabel("Number of Passanger seats   :");
			lblNewLabel_7_3.setBounds(10, 105, 177, 13);
			panel_1_2_3.add(lblNewLabel_7_3);
			
			
			
			textField_9 = new JTextField();
			textField_9.setColumns(10);
			textField_9.setBounds(200, 99, 96, 19);
			panel_1_2_3.add(textField_9);
			
			JLabel lblNewLabel_4_1_3 = new JLabel("Vehical colour  :");
			lblNewLabel_4_1_3.setBounds(19, 290, 114, 13);
			panel_1_2_3.add(lblNewLabel_4_1_3);
			
			textField_10 = new JTextField();
			textField_10.setColumns(10);
			textField_10.setBounds(200, 287, 208, 19);
			panel_1_2_3.add(textField_10);
			
			JButton btnNewButton_4_1 = new JButton("Delete");
			btnNewButton_4_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 String fullName = textField.getText(); 
					 String password = textField_4.getText();
					try {
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");

	                    String query = "DELETE FROM driverpersonalaccount WHERE Full_Name = '"+fullName+"' AND Password = '"+password+"'" ;
	                    String query_1 = "DELETE FROM drivervehicalaccount WHERE Driver_name = '"+fullName+"'" ;
	                    Statement sta = connection.createStatement();
	                    sta.executeUpdate(query);
	                    Statement sta_1 = connection.createStatement();
	                    sta_1.executeUpdate(query_1);
	                    JOptionPane.showMessageDialog(btnNewButton_4_1, "Your Account has been deleted");
	                    Starting window = new Starting();
							window.frmZiptatransport.setVisible(true);
							frame.disable();
							
	                   
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
				}
			});
			btnNewButton_4_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnNewButton_4_1.setForeground(new Color(255, 255, 0));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnNewButton_4_1.setForeground(new Color(255, 255, 255));
				}
			});
			btnNewButton_4_1.setForeground(Color.WHITE);
			btnNewButton_4_1.setBackground(new Color(128, 0, 0));
			btnNewButton_4_1.setBounds(288, 561, 122, 35);
			panel_1_2_3.add(btnNewButton_4_1);
			
			JLabel lblNewLabel_6_1_3_1 = new JLabel("Delete Account");
			lblNewLabel_6_1_3_1.setForeground(new Color(77, 77, 77));
			lblNewLabel_6_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
			lblNewLabel_6_1_3_1.setBounds(162, 572, 114, 13);
			panel_1_2_3.add(lblNewLabel_6_1_3_1);
			
			
			JPanel panel_3 = new JPanel();
			panel_3.setBounds(0, 0, 782, 125);
			panel_3.setBackground(new Color(0, 0, 64));
			panel_2.add(panel_3);
			panel_3.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("Account Details");
			lblNewLabel_2.setBounds(0, 0, 772, 100);
			panel_3.add(lblNewLabel_2);
			lblNewLabel_2.setBackground(new Color(0, 0, 64));
			lblNewLabel_2.setForeground(new Color(255, 255, 255));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 35));
			
			JButton btnNewButton_3 = new JButton("Refresh");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");
					 Statement stm_5  = connection.createStatement();
				     ResultSet rs_5 = stm_5.executeQuery("SELECT rate FROM history_newtrip WHERE Driver_name = '"+lblNewLabel.getText()+"'");
				     double rate= 0;
				     while (rs_5.next()) {
				    	 rate = rate + rs_5.getInt(1);	 
				
			            }
				     
				     String countSQL = "SELECT COUNT(*) FROM accepttable WHERE  Name_Driver = '"+lblNewLabel.getText()+"'";
			         PreparedStatement preparedStatement = connection.prepareStatement(countSQL);
			         ResultSet resultSet = preparedStatement.executeQuery();

			            if (resultSet.next()) {
			                int rowCount = resultSet.getInt(1);
			                System.out.println(rowCount);
			                rate = rate/rowCount;
			                System.out.println(rate);
			                rating_label.setText(String.valueOf(rate)+" Stars");
			                
			                
			                
			            } else {
			                System.out.println("No rows match the criteria.");
			            }
					}catch(Exception e2){
						System.out.println("Error : " + e2.getCause());
						
					}
				}
			});
			btnNewButton_3.setBackground(new Color(255, 255, 0));
			btnNewButton_3.setBounds(697, 0, 85, 21);
			panel_3.add(btnNewButton_3);
		
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
		
		JLabel lblNewLabel_2_1 = new JLabel("Ride Details");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_2_1.setBackground(new Color(0, 0, 64));
		lblNewLabel_2_1.setBounds(0, 0, 782, 100);
		panel_3_1.add(lblNewLabel_2_1);
		
		JButton btnNewButton_5 = new JButton("Refresh");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                    try {
				    
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");
					String query_1  = "select * from newtrip";
					Statement stm_1  = connection.createStatement();
					ResultSet rs = stm_1.executeQuery(query_1);
					DefaultTableModel model  = (DefaultTableModel)table.getModel();
					model.setRowCount(0);
					while (rs.next()) {
	        			model.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(5),"Accept"});
	        			table.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer_1());
						table.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JTextField(),textField)); 
	        		}
					connection.close();						}
					catch(Exception ex) {
						System.out.println("Error : " + ex.getCause());
					}
			}
		});
		btnNewButton_5.setBackground(new Color(255, 255, 0));
		btnNewButton_5.setBounds(697, 94, 85, 21);
		panel_3_1.add(btnNewButton_5);
		
		JLabel lblNewLabel_8 = new JLabel("Name");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8.setBackground(Color.WHITE);
		lblNewLabel_8.setBounds(10, 158, 91, 25);
		panel_4.add(lblNewLabel_8);
		
		JPanel panel_7_2_1 = new JPanel();
		panel_7_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_2_1.setBackground(new Color(64, 0, 0));
		panel_7_2_1.setBounds(117, 158, 111, 25);
		panel_4.add(panel_7_2_1);
		panel_7_2_1.setLayout(null);
		
		JLabel lblNewLabel_8_1 = new JLabel("PickUp");
		lblNewLabel_8_1.setBounds(30, 10, 47, 13);
		panel_7_2_1.add(lblNewLabel_8_1);
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setForeground(Color.WHITE);
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_1.setBackground(Color.WHITE);
		
		JPanel panel_7_2 = new JPanel();
		panel_7_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_2.setBackground(new Color(64, 0, 0));
		panel_7_2.setBounds(230, 158, 105, 25);
		panel_4.add(panel_7_2);
		
		JLabel lblNewLabel_8_2 = new JLabel("Destination");
		lblNewLabel_8_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_2.setForeground(Color.WHITE);
		lblNewLabel_8_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_2.setBackground(Color.WHITE);
		panel_7_2.add(lblNewLabel_8_2);
		
		JPanel panel_7_3 = new JPanel();
		panel_7_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_3.setBackground(new Color(64, 0, 0));
		panel_7_3.setBounds(448, 158, 105, 25);
		panel_4.add(panel_7_3);
		
		JLabel lblNewLabel_8_3 = new JLabel("Mobile");
		lblNewLabel_8_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3.setForeground(Color.WHITE);
		lblNewLabel_8_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_3.setBackground(Color.WHITE);
		panel_7_3.add(lblNewLabel_8_3);
		
		JPanel panel_7_4 = new JPanel();
		panel_7_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_4.setBackground(new Color(64, 0, 0));
		panel_7_4.setBounds(663, 158, 109, 25);
		panel_4.add(panel_7_4);
		
		JLabel lblNewLabel_8_4 = new JLabel("Accept");
		lblNewLabel_8_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_4.setForeground(Color.WHITE);
		lblNewLabel_8_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_4.setBackground(Color.WHITE);
		panel_7_4.add(lblNewLabel_8_4);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Name", "Pickup", "Destination", "type", "Mobile", "Cash_Card", "Accept"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBackground(new Color(236, 236, 236));
		table.setBounds(10, 182, 762, 551);
		panel_4.add(table);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_1.setBackground(new Color(64, 0, 0));
		panel_7_1.setBounds(10, 158, 105, 25);
		panel_4.add(panel_7_1);
		
		JPanel panel_7_3_2 = new JPanel();
		panel_7_3_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_3_2.setBackground(new Color(64, 0, 0));
		panel_7_3_2.setBounds(336, 158, 111, 25);
		panel_4.add(panel_7_3_2);
		
		JLabel lblNewLabel_8_3_2 = new JLabel("Type");
		lblNewLabel_8_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3_2.setForeground(Color.WHITE);
		lblNewLabel_8_3_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_3_2.setBackground(Color.WHITE);
		panel_7_3_2.add(lblNewLabel_8_3_2);
		
		JPanel panel_7_3_3 = new JPanel();
		panel_7_3_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_3_3.setBackground(new Color(64, 0, 0));
		panel_7_3_3.setBounds(556, 158, 105, 25);
		panel_4.add(panel_7_3_3);
		
		JLabel lblNewLabel_8_3_3 = new JLabel("Cash/Card");
		lblNewLabel_8_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3_3.setForeground(Color.WHITE);
		lblNewLabel_8_3_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_3_3.setBackground(Color.WHITE);
		panel_7_3_3.add(lblNewLabel_8_3_3);
		
	

		panel_5 = new JPanel();
		panel_5.setBounds(272, 0, 782, 733);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(254, 250, 231));
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBackground(new Color(0, 0, 64));
		panel_3_2.setBounds(0, 0, 782, 125);
		panel_5.add(panel_3_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Ride History");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_2_2.setBackground(new Color(0, 0, 64));
		lblNewLabel_2_2.setBounds(0, 0, 782, 100);
		panel_3_2.add(lblNewLabel_2_2);
		
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");
				String query_1  = "select * from accepttable where Name_Driver = '"+textField.getText()+"'";
				Statement stm_1  = connection.createStatement();
				ResultSet rs = stm_1.executeQuery(query_1);
				DefaultTableModel model  = (DefaultTableModel)table_1.getModel();
				model.setRowCount(0);
				
				while (rs.next()) {
					model.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(6),rs.getString(4)});
				}
				connection.close();	
				}
				catch(Exception e1) {
					System.out.println("Error : " + e1.getCause());
				}
			}
		});
		btnNewButton_1.setBackground(new Color(240, 240, 0));
		btnNewButton_1.setBounds(697, 94, 85, 21);
		panel_3_2.add(btnNewButton_1);
		
		JPanel panel_7_6 = new JPanel();
		panel_7_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_6.setBackground(new Color(64, 0, 0));
		panel_7_6.setBounds(10, 148, 152, 25);
		panel_5.add(panel_7_6);
		
		JLabel lblNewLabel_8_6 = new JLabel("Name");
		lblNewLabel_8_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_6.setForeground(Color.WHITE);
		lblNewLabel_8_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_6.setBackground(Color.WHITE);
		panel_7_6.add(lblNewLabel_8_6);
		
		JPanel panel_7_2_1_1 = new JPanel();
		panel_7_2_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_2_1_1.setBackground(new Color(64, 0, 0));
		panel_7_2_1_1.setBounds(163, 148, 152, 25);
		panel_5.add(panel_7_2_1_1);
		
		JLabel lblNewLabel_8_1_1 = new JLabel("PickUp");
		lblNewLabel_8_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_1_1.setBackground(Color.WHITE);
		panel_7_2_1_1.add(lblNewLabel_8_1_1);
		
		JPanel panel_7_2_2 = new JPanel();
		panel_7_2_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_2_2.setBackground(new Color(64, 0, 0));
		panel_7_2_2.setBounds(316, 148, 152, 25);
		panel_5.add(panel_7_2_2);
		
		JLabel lblNewLabel_8_2_1 = new JLabel("Destination");
		lblNewLabel_8_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_2_1.setForeground(Color.WHITE);
		lblNewLabel_8_2_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_2_1.setBackground(Color.WHITE);
		panel_7_2_2.add(lblNewLabel_8_2_1);
		
		JPanel panel_7_3_1 = new JPanel();
		panel_7_3_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_3_1.setBackground(new Color(64, 0, 0));
		panel_7_3_1.setBounds(623, 148, 149, 25);
		panel_5.add(panel_7_3_1);
		
		JLabel lblNewLabel_8_3_1 = new JLabel("Cash/Card");
		lblNewLabel_8_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3_1.setForeground(Color.WHITE);
		lblNewLabel_8_3_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_3_1.setBackground(Color.WHITE);
		panel_7_3_1.add(lblNewLabel_8_3_1);
		
		table_1 = new JTable();
		table_1.setEnabled(false);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Name", "PichUp", "Destination","Mobile", "Cash/Card"
			}
		));
		table_1.setFillsViewportHeight(true);
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.setBackground(new Color(236, 236, 236));
		table_1.setBounds(10, 172, 762, 551);
		panel_5.add(table_1);
		
		JPanel panel_7_2_2_1 = new JPanel();
		panel_7_2_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_2_2_1.setBackground(new Color(64, 0, 0));
		panel_7_2_2_1.setBounds(470, 148, 152, 25);
		panel_5.add(panel_7_2_2_1);
		
		JLabel lblNewLabel_8_2_1_1 = new JLabel("Mobile");
		lblNewLabel_8_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_2_1_1.setBackground(Color.WHITE);
		panel_7_2_2_1.add(lblNewLabel_8_2_1_1);
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel(new String[] {"Car", "BIke", "Van", "Bus"});
		
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
		lblNewLabel_9.setBounds(30, 158, 76, 27);
		panel_6.add(lblNewLabel_9);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(149, 162, 462, 19);
		panel_6.add(textField_11);
		
		JLabel lblNewLabel_9_1 = new JLabel("Message   :");
		lblNewLabel_9_1.setBounds(30, 234, 76, 27);
		panel_6.add(lblNewLabel_9_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(152, 235, 459, 256);
		panel_6.add(textArea);
		
		JButton btnNewButton_4_2 = new JButton("Submit");
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = textField_2.getText();
                String mobileNumber = textField_3.getText();
				String name = textField.getText();
				String subject = textField_11.getText();
				String message = textArea.getText();
				String type = "Driver";
				
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
					 JOptionPane.showMessageDialog(btnNewButton_4_2, "Successfully sent");
					 textField_11.setText(null);
			         textArea.setText(null);
				 }
			}
		});
		btnNewButton_4_2.setForeground(Color.WHITE);
		btnNewButton_4_2.setBackground(new Color(0, 64, 0));
		btnNewButton_4_2.setBounds(308, 571, 118, 35);
		panel_6.add(btnNewButton_4_2);
		
		
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

	public String textgetter() {
		
	    System.out.println(lblNewLabel.getText());
	    System.out.println(textField.getText());
	    
		return lblNewLabel.getText();
		
	}
}

