package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CustomerRegistration {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerRegistration window = new CustomerRegistration();
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
	public CustomerRegistration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 601, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Zipta- Customer Registration form");
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 64));
		panel.setBounds(0, 0, 592, 104);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setBounds(106, 10, 345, 66);
		panel.add(lblNewLabel);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_2.setBackground(new Color(227, 241, 190));
		panel_1_2.setBounds(0, 104, 592, 320);
		frame.getContentPane().add(panel_1_2);
		
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
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String gender = "null";
				if(rdbtnMale.isSelected()) {
					 gender = "Male";
					
				}
				if(rdbtnFemale.isSelected()) {
					 gender = "Female";
					
				}
				
				
			        String fullName = textField.getText();
	                String age = textField_1.getText();
	                
	                String email = textField_2.getText();
	                String mobileNumber = textField_3.getText();
	                int len = mobileNumber.length();
	                String password = textField_4.getText();
	                int len_password =  password.length();

	                String msg = "" + fullName;
	                msg += " \n";
	                if (len != 10 && len_password <8) {
	                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
	                }

	                try {
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");

	                    String query = "INSERT INTO customeraccount values('" + fullName + "','" + gender + "','" + age + "','" + email + "','" + mobileNumber + "','" + password + "')";

	                    Statement sta = connection.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(btnNewButton,
	                            "Welcome, " + msg + "Your account is sucessfully created");
	                    }
	                    connection.close();
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
				ZiptaMainCustomer window = new ZiptaMainCustomer(fullName,password);
				window.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 64, 0));
		btnNewButton.setBounds(476, 289, 85, 21);
		panel_1_2.add(btnNewButton);
		
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
		
	
	}

}
