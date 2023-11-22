package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import java.awt.Color;




import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.image.BufferedImage;
import java.io.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Toolkit;

public class Starting {

	JFrame frmZiptatransport;
	private final JPanel panel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Starting window = new Starting();
					window.frmZiptatransport.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public Starting() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmZiptatransport = new JFrame();
		frmZiptatransport.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\JAVA\\Transport Mangment System\\src\\istockphoto-687197058-612x612.jpg"));
		frmZiptatransport.setTitle("Zipta- Transport Management System");
		frmZiptatransport.setResizable(false);
		frmZiptatransport.setBounds(100, 100, 1133, 788);
		frmZiptatransport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmZiptatransport.getContentPane().setLayout(null);
		
		BufferedImage img = null;
        try {
            img = ImageIO.read(new File("D:\\\\JAVA\\\\Transport Mangment System\\\\src\\\\istockphoto-687197058-612x612.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImagePanel imgPanel = new ImagePanel(img);
        frmZiptatransport.setContentPane(imgPanel);
        imgPanel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Zipta");
        lblNewLabel.setBackground(new Color(0, 0, 64));
        lblNewLabel.setForeground(new Color(0, 0, 64));
        lblNewLabel.setFont(new Font("Castellar", Font.BOLD, 88));
        lblNewLabel.setBounds(389, 60, 422, 109);
        imgPanel.add(lblNewLabel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(0, 0, 51,200));
        panel_1.setBounds(350, 426, 397, 257);
        imgPanel.add(panel_1);
 
        
        JButton btnNewButton = new JButton("LOG IN");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String password = passwordField_1.getText();
        		String username = textField_1.getText();
        	
        		
        		try {

            		if(password.contains("admin.123")&& username.contains("admin")) {
            			passwordField_1.setText(null);
            			textField_1.setText(null);
            			Admin window = new Admin(username);
    					window.frame.setVisible(true);
    					frmZiptatransport.dispose(); 
    					passwordField_1.setText(null);
            			textField_1.setText(null);
    					}else {
    						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");
    						String query_1  = "select * from customeraccount where Full_Name = '"+username+ "' and password = '"+password+"' ";
    						String query_2  = "select * from driverpersonalaccount where Full_Name = '"+username+ "' and password = '"+password+"' ";
    						Statement stm_1  = connection.createStatement();
    						Statement stm_2  = connection.createStatement();
    						ResultSet rs = stm_1.executeQuery(query_1);
    						ResultSet rs_1 = stm_2.executeQuery(query_2);
    						if (rs.next()) {
    	            			frmZiptatransport.dispose();
    	            			ZiptaMainCustomer window = new ZiptaMainCustomer(username,password);
    	    					window.frame.setVisible(true);
    	            		}else if(rs_1.next()) {
    	            			frmZiptatransport.dispose();
    	            			ZiptaMainDriver window = new ZiptaMainDriver(username,password);
    	    					window.frame.setVisible(true);
    	            		}else {
    	            			JOptionPane.showMessageDialog(null, "Invalid Username or Passwaord","Login Error",JOptionPane.ERROR_MESSAGE);
    	            			passwordField_1.setText(null);
    	            			textField_1.setText(null);
    	    					}
    						connection.close();
            		      }
            		
        		    }
        		catch(Exception e1){
        			System.out.println(e1.getMessage());
        		}
        			
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton.setBounds(135, 208, 126, 39);
        panel_1.add(btnNewButton);
        
        JLabel lblNewLabel_2 = new JLabel("User Name:");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setBackground(new Color(0, 0, 160));
        lblNewLabel_2.setBounds(82, 34, 90, 29);
        panel_1.add(lblNewLabel_2);
        
        textField_1 = new JTextField();
        textField_1.setToolTipText("Enter the Username");
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_1.setColumns(10);
        textField_1.setBackground(Color.LIGHT_GRAY);
        textField_1.setBounds(82, 70, 217, 39);
        panel_1.add(textField_1);
        
        JLabel lblNewLabel_3 = new JLabel("Passwaord:");
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setBackground(new Color(0, 0, 128));
        lblNewLabel_3.setBounds(85, 119, 77, 13);
        panel_1.add(lblNewLabel_3);
        
        passwordField_1 = new JPasswordField();
        passwordField_1.setToolTipText("Enter password here");
        passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        passwordField_1.setBackground(Color.LIGHT_GRAY);
        passwordField_1.setBounds(86, 142, 213, 39);
        panel_1.add(passwordField_1);
        
        textField_2 = new JTextField();
        textField_2.setText("Don't hava account?");
        textField_2.setForeground(Color.WHITE);
        textField_2.setColumns(10);
        textField_2.setBackground(new Color(0, 0, 128));
        textField_2.setBounds(498, 683, 109, 19);
        imgPanel.add(textField_2);
        
        JButton btnNewButton_1 = new JButton("Register");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Selection select = new Selection();
				select.selection.setVisible(true);
					frmZiptatransport.dispose();
				
        	}
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton_1.setBounds(479, 712, 150, 29);
        imgPanel.add(btnNewButton_1);
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setLayout(null);
        panel_1_1.setBackground(new Color(128, 0, 0,100));
        panel_1_1.setBounds(0, 0, 1119, 741);
        imgPanel.add(panel_1_1);
		
	}
	static class ImagePanel extends JPanel {
	    private BufferedImage img;

	    public ImagePanel(BufferedImage img) {
	        this.img = img;
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        if (img != null) {
	            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	        }
	    }
	}

}

