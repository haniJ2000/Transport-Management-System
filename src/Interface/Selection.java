package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Selection {

	JFrame selection;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Selection window = new Selection();
					window.selection.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Selection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		selection = new JFrame();
		selection.setResizable(false);
		selection.getContentPane().setBackground(new Color(0, 0, 64));
		selection.setTitle("Selection Form");
		selection.getContentPane().setLayout(null);
		
		
		JButton btnNewButton = new JButton("Customer");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerRegistration window = new CustomerRegistration();
				window.frame.setVisible(true);
				selection.dispose();

			}
		});
		btnNewButton.setForeground(new Color(192, 192, 192));
		btnNewButton.setBackground(new Color(64, 0, 64));
		btnNewButton.setBounds(46, 93, 347, 69);
		selection.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Driver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DriverRegistrastion window = new DriverRegistrastion();
				window.frame.setVisible(true);
				selection.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_1.setBackground(new Color(0, 64, 0));
		btnNewButton_1.setForeground(new Color(192, 192, 192));
		btnNewButton_1.setBounds(46, 172, 347, 69);
		selection.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Registration type");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(46, 23, 347, 46);
		selection.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Starting window = new Starting();
				window.frmZiptatransport.setVisible(true);
				selection.dispose();

				
			}
		});
		btnNewButton_2.setBounds(10, 10, 85, 21);
		selection.getContentPane().add(btnNewButton_2);
		selection.setBounds(100, 100, 450, 300);
		selection.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}
