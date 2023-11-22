package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class DriverRegistrastion {

	JFrame frame;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DriverRegistrastion window = new DriverRegistrastion();
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
	public DriverRegistrastion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(0, 0, 64));
		frame.setBounds(100, 100, 594, 490);
		frame.setTitle("Zipta- Driver Registration Form");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setBounds(139, 10, 329, 44);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 85, 586, 372);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_2.setBackground(new Color(227, 241, 190));
		tabbedPane.addTab("Personal Details", null, panel_1_2, null);
		
		JLabel lblNewLabel_1 = new JLabel("Full name   :");
		lblNewLabel_1.setBounds(10, 22, 79, 13);
		panel_1_2.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(99, 19, 456, 19);
		panel_1_2.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Age    :");
		lblNewLabel_2.setBounds(10, 108, 45, 13);
		panel_1_2.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(99, 105, 96, 19);
		panel_1_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("ex : cdisura@gmail.com");
		textField_2.setColumns(10);
		textField_2.setBounds(99, 155, 208, 19);
		panel_1_2.add(textField_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email    :");
		lblNewLabel_3.setBounds(10, 158, 45, 13);
		panel_1_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mobile No    :");
		lblNewLabel_4.setBounds(10, 203, 85, 13);
		panel_1_2.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(99, 200, 208, 19);
		panel_1_2.add(textField_3);
		
		JLabel lblNewLabel_5 = new JLabel("Password   :");
		lblNewLabel_5.setBounds(10, 251, 79, 13);
		panel_1_2.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(99, 248, 186, 19);
		panel_1_2.add(textField_4);
		
		JLabel lblNewLabel_6 = new JLabel("(more than 8 characters which include .,@,1,a etc)");
		lblNewLabel_6.setForeground(new Color(77, 77, 77));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_6.setBounds(295, 251, 297, 13);
		panel_1_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("ex :0759464464");
		lblNewLabel_6_1.setForeground(new Color(77, 77, 77));
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_6_1.setBounds(315, 203, 246, 13);
		panel_1_2.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("ex : cdisura@gmail.com");
		lblNewLabel_6_2.setForeground(new Color(77, 77, 77));
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_6_2.setBounds(328, 158, 208, 13);
		panel_1_2.add(lblNewLabel_6_2);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Selection window = new Selection();
				window.selection.setVisible(true);
				frame.dispose();
				
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(128, 0, 0));
		btnNewButton_1.setBounds(21, 289, 85, 21);
		panel_1_2.add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("Gender");
		lblNewLabel_7.setBounds(10, 66, 45, 13);
		panel_1_2.add(lblNewLabel_7);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(new Color(227, 241, 190));
		rdbtnMale.setBounds(108, 62, 103, 21);
		panel_1_2.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(227, 241, 190));
		rdbtnFemale.setBounds(252, 62, 103, 21);
		panel_1_2.add(rdbtnFemale);
		
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMale.isSelected()) {
					rdbtnFemale.setSelected(false);
					
				}
			}
		});
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnFemale.isSelected()) {
					rdbtnMale.setSelected(false);
					
				}
			}
		});
		
	        
          
            
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fullName = textField.getText();
	            String age = textField_1.getText();  
	            String email = textField_2.getText();
				String password = textField_4.getText();
				 String mobileNumber = textField_3.getText(); 
				 int len_password =  password.length();
				int len = mobileNumber.length();
				 if (len != 10 && len_password<8) {
	                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number or password");
	                }else {

	                	int currentTab = tabbedPane.getSelectedIndex();
	                    if (currentTab < tabbedPane.getTabCount() - 1) {
	                        tabbedPane.setSelectedIndex(currentTab + 1);
	                    }
			       }
	    			
	                }

				
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 64, 0));
		btnNewButton.setBounds(476, 289, 85, 21);
		panel_1_2.add(btnNewButton);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Vehical Details", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1_2_3 = new JPanel();
		panel_1_2_3.setLayout(null);
		panel_1_2_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_2_3.setBackground(new Color(227, 241, 190));
		panel_1_2_3.setBounds(0, 0, 607, 346);
		panel.add(panel_1_2_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Vehical Type   :");
		lblNewLabel_1_3.setBounds(10, 22, 96, 13);
		panel_1_2_3.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2_3 = new JLabel("Vehical Brand    :");
		lblNewLabel_2_3.setBounds(10, 105, 96, 13);
		panel_1_2_3.add(lblNewLabel_2_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(200, 102, 96, 19);
		panel_1_2_3.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("ex : cdisura@gmail.com");
		textField_6.setColumns(10);
		textField_6.setBounds(200, 140, 122, 19);
		panel_1_2_3.add(textField_6);
		
		JLabel lblNewLabel_3_3 = new JLabel("Model    :");
		lblNewLabel_3_3.setBounds(10, 143, 65, 13);
		panel_1_2_3.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_4_3 = new JLabel("Vehical plate number :");
		lblNewLabel_4_3.setBounds(10, 216, 131, 13);
		panel_1_2_3.add(lblNewLabel_4_3);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(200, 213, 208, 19);
		panel_1_2_3.add(textField_7);
		
		JLabel lblNewLabel_5_3 = new JLabel("Driving License number");
		lblNewLabel_5_3.setBounds(10, 251, 122, 16);
		panel_1_2_3.add(lblNewLabel_5_3);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(200, 250, 186, 19);
		panel_1_2_3.add(textField_8);
		
		JLabel lblNewLabel_6_1_3 = new JLabel("ex: if brand is benz model- C class");
		lblNewLabel_6_1_3.setForeground(new Color(77, 77, 77));
		lblNewLabel_6_1_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_6_1_3.setBounds(338, 143, 246, 13);
		panel_1_2_3.add(lblNewLabel_6_1_3);
		
		JLabel lblNewLabel_6_2_3 = new JLabel("ex : benz,audi etc");
		lblNewLabel_6_2_3.setForeground(new Color(77, 77, 77));
		lblNewLabel_6_2_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_6_2_3.setBounds(338, 105, 208, 13);
		panel_1_2_3.add(lblNewLabel_6_2_3);
		
		JLabel lblNewLabel_7_3 = new JLabel("Number of Passanger seats   :");
		lblNewLabel_7_3.setBounds(10, 59, 177, 13);
		panel_1_2_3.add(lblNewLabel_7_3);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addItem("Car");
		comboBox_2.addItem("Bike");
		comboBox_2.addItem("Bus");
		comboBox_2.addItem("Van");
		
		comboBox_2.setBounds(200, 19, 122, 19);
		panel_1_2_3.add(comboBox_2);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(197, 56, 96, 19);
		panel_1_2_3.add(textField_9);
		
		JLabel lblNewLabel_4_1_3 = new JLabel("Vehical colour  :");
		lblNewLabel_4_1_3.setBounds(10, 183, 114, 13);
		panel_1_2_3.add(lblNewLabel_4_1_3);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(200, 180, 208, 19);
		panel_1_2_3.add(textField_10);
		
		JButton btnNewButton_4 = new JButton("Submit");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fullName = textField.getText();
	            String age = textField_1.getText();  
	            String email = textField_2.getText();
				String password = textField_4.getText();
				 String mobileNumber = textField_3.getText(); 
				 String License_number = textField_8.getText();
				String gender = "null";
				if(rdbtnMale.isSelected()) {
					 gender = "Male";
					
				}
				if(rdbtnFemale.isSelected()) {
					 gender = "Female";
				}
				 String msg = "" + fullName;
				 msg += " \n";
	                try {
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");

	                    String query = "INSERT INTO driverpersonalaccount values('" + fullName + "','" + gender + "','" + age + "','" + email + "','" + mobileNumber + "','" + password + "','"+License_number+"')";
	                    
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
	                    
	         
	                    String query_1 = "INSERT INTO drivervehicalaccount values('" + fullName + "','" + type + "','" + seats_No + "','" + brand + "','" + model + "','" + colour + "','" + plate_number + "','"+ License_number + "')";
		                  
	                    
	                    Statement sta = connection.createStatement();
	                    int x = sta.executeUpdate(query);
	                    int y = sta.executeUpdate(query_1);
	                    if (x == 0 && y==0) {
	                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(btnNewButton,
	                            "Welcome, " + msg + "Your account is sucessfully created");
	                    }
	                    connection.close();
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
	               
				ZiptaMainDriver window = new ZiptaMainDriver(fullName,password);
				window.frame.setVisible(true);
				frame.dispose();
				
				
			}
		});
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(new Color(0, 64, 0));
		btnNewButton_4.setBounds(476, 289, 85, 21);
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
		btnNewButton_1_3.setBackground(new Color(128, 0, 0));
		btnNewButton_1_3.setBounds(21, 289, 85, 21);
		panel_1_2_3.add(btnNewButton_1_3);
		
		
	}

}
