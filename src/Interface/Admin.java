package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.JTabbedPane;

public class Admin {

	JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTable table_1_1;
	private JTextField textField_11;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTextField textField;
	JPanel panel_2;
	JPanel panel_5_1;
	JPanel panel_5;
	JPanel panel_5_1_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
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
	public Admin() { 
		initialize();	
	}
	public Admin(String username) {
			initialize();
			panel_5_1.setVisible(false);
			panel_5.setVisible(false);
			panel_5_1_1.setVisible(true);
			panel_2.setVisible(false);
			
			
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1067, 771);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Zipta- Transport Management System (Admin)");
		frame.getContentPane().setLayout(null);
		

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Customer Name", "Gender", "Age", "Email", "Mobile"
			}
		));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 0, 64));
		panel.setBounds(0, 0, 279, 733);
		frame.getContentPane().add(panel);
		
		JButton btnCustomerDetails = new JButton("Customer Details");
		btnCustomerDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");
					String query_1  = "select * from customeraccount";
					Statement stm_1  = connection.createStatement();
					ResultSet rs = stm_1.executeQuery(query_1);
					DefaultTableModel model  = (DefaultTableModel)table_2.getModel();
					model.setRowCount(0);
					
					while (rs.next()) {
						
						model.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),"Delete"});
						table_2.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
						table_2.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JTextField(),textField));

					}
					connection.close();	
					}
					catch(Exception e1) {
						System.out.println("Error : " + e1.getCause());
					}
			}
		});
		
			btnCustomerDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnCustomerDetails.setBounds(0, 328, 279, 40);
			panel.add(btnCustomerDetails);
			
			JButton btnDriverDetails = new JButton("Driver Details");
			btnDriverDetails.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");
						String query_1  = "select * from driverpersonalaccount";
						String query_2 = "select * from drivervehicalaccount";
						Statement stm_1  = connection.createStatement();
						Statement stm_2  = connection.createStatement();
						ResultSet rs_1 = stm_2.executeQuery(query_2);
						ResultSet rs = stm_1.executeQuery(query_1);
						DefaultTableModel model  = (DefaultTableModel)table_3.getModel();
						DefaultTableModel model_1  = (DefaultTableModel)table_4.getModel();
						model.setRowCount(0);
						model_1.setRowCount(0);
						while (rs.next()&& rs_1.next()) {
		        			model.addRow(new String[] {rs_1.getString(8),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
		        			model_1.addRow(new String[] {rs_1.getString(8),rs_1.getString(7),rs_1.getString(2),rs_1.getString(4),rs_1.getString(5),"Delete"});
		        			table_4.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
							table_4.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JTextField(),textField));
		        		}
						connection.close();						}
						catch(Exception ex) {
							System.out.println("Error : " + ex.getCause());
						}
					
				}
			});
			btnDriverDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnDriverDetails.setBounds(0, 396, 279, 40);
			panel.add(btnDriverDetails);
			
			JButton btnTrips = new JButton("Trips");
			btnTrips.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");
						String query_1  = "select * from history_newtrip";
						Statement stm_1  = connection.createStatement();
						ResultSet rs = stm_1.executeQuery(query_1);
						DefaultTableModel model  = (DefaultTableModel)table.getModel();
						model.setRowCount(0);
						while (rs.next()) {
		        			model.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(8),rs.getString(7)});
		        			 
		        		}
						connection.close();						}
						catch(Exception ex) {
							System.out.println("Error : " + ex.getCause());
						}
				}
			});
			btnTrips.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnTrips.setBounds(0, 462, 279, 40);
			panel.add(btnTrips);
			
			JButton btnSentMessages = new JButton("Received Messages");
			btnSentMessages.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");
						String query = "select * from querries";
						Statement stm  = connection.createStatement();
						ResultSet rs = stm.executeQuery(query);
						DefaultTableModel model  = (DefaultTableModel)table_1_1.getModel();
						
						model.setRowCount(0);
						while (rs.next()) {
		        			model.addRow(new String[] {rs.getString(1),rs.getString(5),rs.getString(6),rs.getString(3),rs.getString(4)});
		        			
		        			 
		        		}
						connection.close();						}
						catch(Exception ex) {
							System.out.println("Error : " + ex.getCause());
						}
					
				}
			});
			btnSentMessages.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnSentMessages.setBounds(0, 535, 279, 40);
			panel.add(btnSentMessages);
			
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
			
			JLabel lblNewLabel = new JLabel("Zipta");
			lblNewLabel.setForeground(new Color(192, 192, 192));
			lblNewLabel.setFont(new Font("Castellar", Font.BOLD, 48));
			lblNewLabel.setBackground(new Color(0, 0, 64));
			lblNewLabel.setBounds(52, 53, 184, 109);
			panel.add(lblNewLabel);
			
			JLabel lblAdmin = new JLabel("Admin");
			lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
			lblAdmin.setForeground(Color.WHITE);
			lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblAdmin.setBounds(35, 201, 201, 40);
			panel.add(lblAdmin);
		
		
		panel_5_1_1 = new JPanel();
		panel_5_1_1.setLayout(null);
		panel_5_1_1.setBackground(new Color(254, 250, 231));
		panel_5_1_1.setBounds(274, 0, 782, 733);
		frame.getContentPane().add(panel_5_1_1);
		
		JPanel panel_3_2_1_1 = new JPanel();
		panel_3_2_1_1.setLayout(null);
		panel_3_2_1_1.setBackground(new Color(0, 0, 64));
		panel_3_2_1_1.setBounds(0, 0, 782, 125);
		panel_5_1_1.add(panel_3_2_1_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Customer Details");
		lblNewLabel_2_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_2_2_1_1.setBackground(new Color(0, 0, 64));
		lblNewLabel_2_2_1_1.setBounds(0, 0, 782, 100);
		panel_3_2_1_1.add(lblNewLabel_2_2_1_1);
		
		JButton btnNewButton_4 = new JButton("Refresh");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");
					String query_1  = "select * from customeraccount";
					Statement stm_1  = connection.createStatement();
					ResultSet rs = stm_1.executeQuery(query_1);
					DefaultTableModel model  = (DefaultTableModel)table_2.getModel();
					model.setRowCount(0);
					
					while (rs.next()) {
						
						model.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),"Delete"});
						table_2.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
						table_2.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JTextField(),textField));

					}
					connection.close();	
					}
					catch(Exception e1) {
						System.out.println("Error : " + e1.getCause());
					}
			}
		});
		btnNewButton_4.setBackground(new Color(217, 217, 0));
		btnNewButton_4.setBounds(697, 94, 85, 21);
		panel_3_2_1_1.add(btnNewButton_4);
		
		JPanel panel_7_6_1_1 = new JPanel();
		panel_7_6_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_6_1_1.setBackground(new Color(64, 0, 0));
		panel_7_6_1_1.setBounds(10, 148, 126, 25);
		panel_5_1_1.add(panel_7_6_1_1);
		
		JLabel lblNewLabel_8_6_1_1 = new JLabel("Customer name");
		lblNewLabel_8_6_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_6_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_6_1_1.setBackground(Color.WHITE);
		panel_7_6_1_1.add(lblNewLabel_8_6_1_1);
		
		JPanel panel_7_2_1_1_1_1 = new JPanel();
		panel_7_2_1_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_2_1_1_1_1.setBackground(new Color(64, 0, 0));
		panel_7_2_1_1_1_1.setBounds(137, 148, 126, 25);
		panel_5_1_1.add(panel_7_2_1_1_1_1);
		
		JLabel lblNewLabel_8_1_1_1_1 = new JLabel("Gender");
		lblNewLabel_8_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_1_1_1_1.setBackground(Color.WHITE);
		panel_7_2_1_1_1_1.add(lblNewLabel_8_1_1_1_1);
		
		JPanel panel_7_2_2_1_1 = new JPanel();
		panel_7_2_2_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_2_2_1_1.setBackground(new Color(64, 0, 0));
		panel_7_2_2_1_1.setBounds(264, 148, 126, 25);
		panel_5_1_1.add(panel_7_2_2_1_1);
		
		JLabel lblNewLabel_8_2_1_1_1 = new JLabel("Age");
		lblNewLabel_8_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_2_1_1_1.setBackground(Color.WHITE);
		panel_7_2_2_1_1.add(lblNewLabel_8_2_1_1_1);
		
		JPanel panel_7_3_1_2_1 = new JPanel();
		panel_7_3_1_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_3_1_2_1.setBackground(new Color(64, 0, 0));
		panel_7_3_1_2_1.setBounds(391, 148, 126, 25);
		panel_5_1_1.add(panel_7_3_1_2_1);
		
		JLabel lblNewLabel_8_3_1_2_1 = new JLabel("Email");
		lblNewLabel_8_3_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_8_3_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_3_1_2_1.setBackground(Color.WHITE);
		panel_7_3_1_2_1.add(lblNewLabel_8_3_1_2_1);
		
		table_2 = new JTable();
		table_2.setFillsViewportHeight(true);
		table_2.setCellSelectionEnabled(true);
		table_2.setColumnSelectionAllowed(true);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Customer", "Gender", "Age", "Email", "Mobile", "Delete"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_2.setBackground(new Color(236, 236, 236));
		table_2.setBounds(10, 172, 762, 551);
		panel_5_1_1.add(table_2);
		
		JPanel panel_7_3_1_1_1_1 = new JPanel();
		panel_7_3_1_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_3_1_1_1_1.setBackground(new Color(64, 0, 0));
		panel_7_3_1_1_1_1.setBounds(518, 148, 126, 25);
		panel_5_1_1.add(panel_7_3_1_1_1_1);
		
		JLabel lblNewLabel_8_3_1_1_1_1 = new JLabel("Mobile");
		lblNewLabel_8_3_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_3_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_3_1_1_1_1.setBackground(Color.WHITE);
		panel_7_3_1_1_1_1.add(lblNewLabel_8_3_1_1_1_1);
		
		JPanel panel_7_3_1_1_1_1_3 = new JPanel();
		panel_7_3_1_1_1_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_3_1_1_1_1_3.setBackground(new Color(64, 0, 0));
		panel_7_3_1_1_1_1_3.setBounds(646, 148, 126, 25);
		panel_5_1_1.add(panel_7_3_1_1_1_1_3);
		
		JLabel lblNewLabel_8_3_1_1_1_1_3 = new JLabel("Delete");
		lblNewLabel_8_3_1_1_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3_1_1_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_8_3_1_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_3_1_1_1_1_3.setBackground(Color.WHITE);
		panel_7_3_1_1_1_1_3.add(lblNewLabel_8_3_1_1_1_1_3);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(326, 258, 85, 21);
		panel_5_1_1.add(btnNewButton);
		
		panel_5_1 = new JPanel();
		panel_5_1.setBounds(271, 0, 782, 733);
		frame.getContentPane().add(panel_5_1);
		panel_5_1.setLayout(null);
		panel_5_1.setBackground(new Color(254, 250, 231));
		
		JPanel panel_3_2_1 = new JPanel();
		panel_3_2_1.setLayout(null);
		panel_3_2_1.setBackground(new Color(0, 0, 64));
		panel_3_2_1.setBounds(0, 0, 782, 125);
		panel_5_1.add(panel_3_2_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Quarries");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_2_2_1.setBackground(new Color(0, 0, 64));
		lblNewLabel_2_2_1.setBounds(0, 0, 782, 100);
		panel_3_2_1.add(lblNewLabel_2_2_1);
		
		JPanel panel_7_6_1 = new JPanel();
		panel_7_6_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_6_1.setBackground(new Color(64, 0, 0));
		panel_7_6_1.setBounds(10, 148, 136, 25);
		panel_5_1.add(panel_7_6_1);
		
		JLabel lblNewLabel_8_6_1 = new JLabel("Customer/Driver");
		lblNewLabel_8_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_6_1.setForeground(Color.WHITE);
		lblNewLabel_8_6_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_6_1.setBackground(Color.WHITE);
		panel_7_6_1.add(lblNewLabel_8_6_1);
		
		JPanel panel_7_2_1_1_1 = new JPanel();
		panel_7_2_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_2_1_1_1.setBackground(new Color(64, 0, 0));
		panel_7_2_1_1_1.setBounds(149, 148, 136, 25);
		panel_5_1.add(panel_7_2_1_1_1);
		
		JLabel lblNewLabel_8_1_1_1 = new JLabel("Email");
		lblNewLabel_8_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_1_1_1.setBackground(Color.WHITE);
		panel_7_2_1_1_1.add(lblNewLabel_8_1_1_1);
		
		JPanel panel_7_2_2_1 = new JPanel();
		panel_7_2_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_2_2_1.setBackground(new Color(64, 0, 0));
		panel_7_2_2_1.setBounds(287, 148, 136, 25);
		panel_5_1.add(panel_7_2_2_1);
		
		JLabel lblNewLabel_8_2_1_1 = new JLabel("Mobile");
		lblNewLabel_8_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_2_1_1.setBackground(Color.WHITE);
		panel_7_2_2_1.add(lblNewLabel_8_2_1_1);
		
		JPanel panel_7_3_1_2 = new JPanel();
		panel_7_3_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_3_1_2.setBackground(new Color(64, 0, 0));
		panel_7_3_1_2.setBounds(425, 148, 136, 25);
		panel_5_1.add(panel_7_3_1_2);
		
		JLabel lblNewLabel_8_3_1_2 = new JLabel("Subject");
		lblNewLabel_8_3_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3_1_2.setForeground(Color.WHITE);
		lblNewLabel_8_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_3_1_2.setBackground(Color.WHITE);
		panel_7_3_1_2.add(lblNewLabel_8_3_1_2);
		
		table_1_1 = new JTable();
		table_1_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return; // Ignore extra events.
                }

                int selectedRow = table_1_1.getSelectedRow();
                int selectedColumn = table_1_1.getSelectedColumn();

                if (selectedRow >= 0 && selectedColumn == 4 ) {
                    String cellValue = (String) table_1_1.getValueAt(selectedRow, selectedColumn);
                    JOptionPane.showMessageDialog(null,cellValue );
                    
                   
                }
                    
                }
            
        });
		table_1_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Customer Name", "Email", "Mobile", "Subject", "Quarry"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1_1.getColumnModel().getColumn(4).setPreferredWidth(147);
		table_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1_1.setBackground(new Color(236, 236, 236));
		table_1_1.setBounds(10, 172, 762, 551);
		panel_5_1.add(table_1_1);
		
		JPanel panel_7_3_1_1_1 = new JPanel();
		panel_7_3_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_3_1_1_1.setBackground(new Color(64, 0, 0));
		panel_7_3_1_1_1.setBounds(563, 148, 209, 25);
		panel_5_1.add(panel_7_3_1_1_1);
		
		JLabel lblNewLabel_8_3_1_1_1 = new JLabel("Quarry");
		lblNewLabel_8_3_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_3_1_1_1.setBackground(Color.WHITE);
		panel_7_3_1_1_1.add(lblNewLabel_8_3_1_1_1);
		
		panel_5 = new JPanel();
		panel_5.setBounds(273, 0, 782, 733);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(254, 250, 231));
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBackground(new Color(0, 0, 64));
		panel_3_2.setBounds(0, 0, 782, 125);
		panel_5.add(panel_3_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Trip Details");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_2_2.setBackground(new Color(0, 0, 64));
		lblNewLabel_2_2.setBounds(0, 0, 782, 100);
		panel_3_2.add(lblNewLabel_2_2);
		
		JButton btnNewButton_3 = new JButton("Refresh");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");
					String query_1  = "select * from history_newtrip";
					Statement stm_1  = connection.createStatement();
					ResultSet rs = stm_1.executeQuery(query_1);
					DefaultTableModel model  = (DefaultTableModel)table.getModel();
					model.setRowCount(0);
					while (rs.next()) {
	        			model.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(8),rs.getString(7)});
	        			 
	        		}
					connection.close();						}
					catch(Exception ex) {
						System.out.println("Error : " + ex.getCause());
					}
			}
		});
		btnNewButton_3.setBackground(new Color(217, 217, 0));
		btnNewButton_3.setBounds(697, 94, 85, 21);
		panel_3_2.add(btnNewButton_3);
		
		JPanel panel_7_6 = new JPanel();
		panel_7_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_6.setBackground(new Color(64, 0, 0));
		panel_7_6.setBounds(10, 148, 108, 25);
		panel_5.add(panel_7_6);
		
		JLabel lblNewLabel_8_6 = new JLabel("Customer name");
		lblNewLabel_8_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_6.setForeground(Color.WHITE);
		lblNewLabel_8_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_6.setBackground(Color.WHITE);
		panel_7_6.add(lblNewLabel_8_6);
		
		JPanel panel_7_2_1_1 = new JPanel();
		panel_7_2_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_2_1_1.setBackground(new Color(64, 0, 0));
		panel_7_2_1_1.setBounds(120, 148, 108, 25);
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
		panel_7_2_2.setBounds(229, 148, 108, 25);
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
		panel_7_3_1.setBounds(338, 148, 108, 25);
		panel_5.add(panel_7_3_1);
		
		JLabel lblNewLabel_8_3_1 = new JLabel("Cash/Card");
		lblNewLabel_8_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3_1.setForeground(Color.WHITE);
		lblNewLabel_8_3_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_3_1.setBackground(Color.WHITE);
		panel_7_3_1.add(lblNewLabel_8_3_1);
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Customer Name", "PickUp", "Destination", "Cash/Card","type", "Driver Name", "rating"
			}
		));
		table.getColumnModel().getColumn(3).setResizable(false);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBackground(new Color(236, 236, 236));
		table.setBounds(10, 172, 762, 551);
		panel_5.add(table);
		
		JPanel panel_7_3_1_1 = new JPanel();
		panel_7_3_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_3_1_1.setBackground(new Color(64, 0, 0));
		panel_7_3_1_1.setBounds(556, 148, 108, 25);
		panel_5.add(panel_7_3_1_1);
		
		JLabel lblNewLabel_8_3_1_1 = new JLabel("Driver name");
		lblNewLabel_8_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_3_1_1.setBackground(Color.WHITE);
		panel_7_3_1_1.add(lblNewLabel_8_3_1_1);
		
		JPanel panel_7_3_1_3 = new JPanel();
		panel_7_3_1_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_3_1_3.setBackground(new Color(64, 0, 0));
		panel_7_3_1_3.setBounds(447, 148, 108, 25);
		panel_5.add(panel_7_3_1_3);
		
		JLabel lblNewLabel_8_3_1_3 = new JLabel("Type");
		lblNewLabel_8_3_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3_1_3.setForeground(Color.WHITE);
		lblNewLabel_8_3_1_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_3_1_3.setBackground(Color.WHITE);
		panel_7_3_1_3.add(lblNewLabel_8_3_1_3);
		
		JPanel panel_7_3_1_1_2 = new JPanel();
		panel_7_3_1_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_3_1_1_2.setBackground(new Color(64, 0, 0));
		panel_7_3_1_1_2.setBounds(666, 148, 106, 25);
		panel_5.add(panel_7_3_1_1_2);
		
		JLabel lblNewLabel_8_3_1_1_2 = new JLabel("Rating");
		lblNewLabel_8_3_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_8_3_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_3_1_1_2.setBackground(Color.WHITE);
		panel_7_3_1_1_2.add(lblNewLabel_8_3_1_1_2);
		
		
		
		
		panel_2 = new JPanel();
		panel_2.setBounds(274, 0, 782, 733);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(254, 250, 231));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 100, 792, 633);
		panel_2.add(tabbedPane);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_2.setBackground(new Color(254, 250, 231));
		tabbedPane.addTab("Personal Details", null, panel_1_2, null);
		
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
		btnNewButton_2.setBounds(669, 585, 85, 21);
		panel_1_2.add(btnNewButton_2);
		
		table_3 = new JTable();
		table_3.setEnabled(false);
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Driver License No", "Driver name", "Gender", "Age", "Email", "Mobile"
			}
		));
		table_3.setFillsViewportHeight(true);
		table_3.setColumnSelectionAllowed(true);
		table_3.setCellSelectionEnabled(true);
		table_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_3.setBackground(new Color(236, 236, 236));
		table_3.setBounds(10, 34, 762, 551);
		panel_1_2.add(table_3);
		
		JPanel panel_7_6_1_1_1 = new JPanel();
		panel_7_6_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_6_1_1_1.setBackground(new Color(64, 0, 0));
		panel_7_6_1_1_1.setBounds(139, 10, 120, 25);
		panel_1_2.add(panel_7_6_1_1_1);
		
		JLabel lblNewLabel_8_6_1_1_1 = new JLabel("Driver name");
		lblNewLabel_8_6_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_6_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_6_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_6_1_1_1.setBackground(Color.WHITE);
		panel_7_6_1_1_1.add(lblNewLabel_8_6_1_1_1);
		
		JPanel panel_7_2_1_1_1_1_1 = new JPanel();
		panel_7_2_1_1_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_2_1_1_1_1_1.setBackground(new Color(64, 0, 0));
		panel_7_2_1_1_1_1_1.setBounds(261, 10, 127, 25);
		panel_1_2.add(panel_7_2_1_1_1_1_1);
		
		JLabel lblNewLabel_8_1_1_1_1_1 = new JLabel("Gender");
		lblNewLabel_8_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_1_1_1_1_1.setBackground(Color.WHITE);
		panel_7_2_1_1_1_1_1.add(lblNewLabel_8_1_1_1_1_1);
		
		JPanel panel_7_2_2_1_1_1 = new JPanel();
		panel_7_2_2_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_2_2_1_1_1.setBackground(new Color(64, 0, 0));
		panel_7_2_2_1_1_1.setBounds(389, 10, 127, 25);
		panel_1_2.add(panel_7_2_2_1_1_1);
		
		JLabel lblNewLabel_8_2_1_1_1_1 = new JLabel("Age");
		lblNewLabel_8_2_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_2_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_2_1_1_1_1.setBackground(Color.WHITE);
		panel_7_2_2_1_1_1.add(lblNewLabel_8_2_1_1_1_1);
		
		JPanel panel_7_3_1_2_1_1 = new JPanel();
		panel_7_3_1_2_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_3_1_2_1_1.setBackground(new Color(64, 0, 0));
		panel_7_3_1_2_1_1.setBounds(517, 10, 127, 25);
		panel_1_2.add(panel_7_3_1_2_1_1);
		
		JLabel lblNewLabel_8_3_1_2_1_1 = new JLabel("Email");
		lblNewLabel_8_3_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_3_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_3_1_2_1_1.setBackground(Color.WHITE);
		panel_7_3_1_2_1_1.add(lblNewLabel_8_3_1_2_1_1);
		
		JPanel panel_7_3_1_1_1_1_1 = new JPanel();
		panel_7_3_1_1_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_3_1_1_1_1_1.setBackground(new Color(64, 0, 0));
		panel_7_3_1_1_1_1_1.setBounds(645, 10, 127, 25);
		panel_1_2.add(panel_7_3_1_1_1_1_1);
		
		JLabel lblNewLabel_8_3_1_1_1_1_1 = new JLabel("Mobile");
		lblNewLabel_8_3_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_3_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_3_1_1_1_1_1.setBackground(Color.WHITE);
		panel_7_3_1_1_1_1_1.add(lblNewLabel_8_3_1_1_1_1_1);
		
		JPanel panel_7_6_1_1_1_1 = new JPanel();
		panel_7_6_1_1_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_6_1_1_1_1.setBackground(new Color(64, 0, 0));
		panel_7_6_1_1_1_1.setBounds(10, 10, 127, 25);
		panel_1_2.add(panel_7_6_1_1_1_1);
		
		JLabel lblNewLabel_8_6_1_1_1_1 = new JLabel("Driving License No");
		lblNewLabel_8_6_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_6_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_6_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_6_1_1_1_1.setBackground(Color.WHITE);
		panel_7_6_1_1_1_1.add(lblNewLabel_8_6_1_1_1_1);
		
		
		JPanel panel_7 = new JPanel();
		tabbedPane.addTab("Vehical Details", null, panel_7, null);
		panel_7.setLayout(null);
		
		JPanel panel_1_2_3 = new JPanel();
		panel_1_2_3.setLayout(null);
		panel_1_2_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_2_3.setBackground(new Color(254, 250, 231));
		panel_1_2_3.setBounds(0, 0, 777, 606);
		panel_7.add(panel_1_2_3);
		
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
		btnNewButton_1_3.setBounds(10, 585, 85, 21);
		panel_1_2_3.add(btnNewButton_1_3);
		
		table_4 = new JTable();
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Driving License No", "Number plate", "Type", "Brand", "Colour", "Delete"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_4.setFillsViewportHeight(true);
		table_4.setColumnSelectionAllowed(true);
		table_4.setCellSelectionEnabled(true);
		table_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_4.setBackground(new Color(236, 236, 236));
		table_4.setBounds(10, 34, 762, 551);
		panel_1_2_3.add(table_4);
		
		JPanel panel_7_6_1_1_2 = new JPanel();
		panel_7_6_1_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_6_1_1_2.setBackground(new Color(64, 0, 0));
		panel_7_6_1_1_2.setBounds(10, 10, 125, 25);
		panel_1_2_3.add(panel_7_6_1_1_2);
		
		JLabel lblNewLabel_8_6_1_1_2 = new JLabel("Driving License No");
		lblNewLabel_8_6_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_6_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_8_6_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_6_1_1_2.setBackground(Color.WHITE);
		panel_7_6_1_1_2.add(lblNewLabel_8_6_1_1_2);
		
		JPanel panel_7_2_1_1_1_1_2 = new JPanel();
		panel_7_2_1_1_1_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_2_1_1_1_1_2.setBackground(new Color(64, 0, 0));
		panel_7_2_1_1_1_1_2.setBounds(138, 10, 125, 25);
		panel_1_2_3.add(panel_7_2_1_1_1_1_2);
		
		JLabel lblNewLabel_8_1_1_1_1_2 = new JLabel("Number plate");
		lblNewLabel_8_1_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_8_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_1_1_1_1_2.setBackground(Color.WHITE);
		panel_7_2_1_1_1_1_2.add(lblNewLabel_8_1_1_1_1_2);
		
		JPanel panel_7_2_2_1_1_2 = new JPanel();
		panel_7_2_2_1_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_2_2_1_1_2.setBackground(new Color(64, 0, 0));
		panel_7_2_2_1_1_2.setBounds(265, 10, 125, 25);
		panel_1_2_3.add(panel_7_2_2_1_1_2);
		
		JLabel lblNewLabel_8_2_1_1_1_2 = new JLabel("Type ");
		lblNewLabel_8_2_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_2_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_8_2_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_2_1_1_1_2.setBackground(Color.WHITE);
		panel_7_2_2_1_1_2.add(lblNewLabel_8_2_1_1_1_2);
		
		JPanel panel_7_3_1_2_1_2 = new JPanel();
		panel_7_3_1_2_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_3_1_2_1_2.setBackground(new Color(64, 0, 0));
		panel_7_3_1_2_1_2.setBounds(392, 10, 125, 25);
		panel_1_2_3.add(panel_7_3_1_2_1_2);
		
		JLabel lblNewLabel_8_3_1_2_1_2 = new JLabel("Brand");
		lblNewLabel_8_3_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3_1_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_8_3_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_3_1_2_1_2.setBackground(Color.WHITE);
		panel_7_3_1_2_1_2.add(lblNewLabel_8_3_1_2_1_2);
		
		JPanel panel_7_3_1_1_1_1_2 = new JPanel();
		panel_7_3_1_1_1_1_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_3_1_1_1_1_2.setBackground(new Color(64, 0, 0));
		panel_7_3_1_1_1_1_2.setBounds(518, 10, 125, 25);
		panel_1_2_3.add(panel_7_3_1_1_1_1_2);
		
		JLabel lblNewLabel_8_3_1_1_1_1_2 = new JLabel("Colour");
		lblNewLabel_8_3_1_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3_1_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_8_3_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_3_1_1_1_1_2.setBackground(Color.WHITE);
		panel_7_3_1_1_1_1_2.add(lblNewLabel_8_3_1_1_1_1_2);
		
		JPanel panel_7_3_1_1_1_1_2_1 = new JPanel();
		panel_7_3_1_1_1_1_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_7_3_1_1_1_1_2_1.setBackground(new Color(64, 0, 0));
		panel_7_3_1_1_1_1_2_1.setBounds(647, 10, 125, 25);
		panel_1_2_3.add(panel_7_3_1_1_1_1_2_1);
		
		JLabel lblNewLabel_8_3_1_1_1_1_2_1 = new JLabel("Delete");
		lblNewLabel_8_3_1_1_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_3_1_1_1_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_8_3_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8_3_1_1_1_1_2_1.setBackground(Color.WHITE);
		panel_7_3_1_1_1_1_2_1.add(lblNewLabel_8_3_1_1_1_1_2_1);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(0, 0, 64));
		panel_3.setBounds(0, 0, 782, 125);
		panel_2.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Driver Details");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_2.setBackground(new Color(0, 0, 64));
		lblNewLabel_2.setBounds(0, 0, 687, 98);
		panel_3.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");
					String query_1  = "select * from driverpersonalaccount";
					String query_2 = "select * from drivervehicalaccount";
					Statement stm_1  = connection.createStatement();
					Statement stm_2  = connection.createStatement();
					ResultSet rs_1 = stm_2.executeQuery(query_2);
					ResultSet rs = stm_1.executeQuery(query_1);
					DefaultTableModel model  = (DefaultTableModel)table_3.getModel();
					DefaultTableModel model_1  = (DefaultTableModel)table_4.getModel();
					model.setRowCount(0);
					model_1.setRowCount(0);
					while (rs.next()&& rs_1.next()) {
	        			model.addRow(new String[] {rs_1.getString(8),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
	        			model_1.addRow(new String[] {rs_1.getString(8),rs_1.getString(7),rs_1.getString(2),rs_1.getString(4),rs_1.getString(5),"Delete"});
	        			table_4.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
						table_4.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JTextField(),textField));
	        		}
					connection.close();						}
					catch(Exception ex) {
						System.out.println("Error : " + ex.getCause());
					}
				
			}
		});
		btnNewButton_1.setBackground(new Color(244, 244, 0));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(697, 94, 85, 21);
		panel_3.add(btnNewButton_1);
		
		btnCustomerDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_5_1.setVisible(false);
				panel_5.setVisible(false);
				panel_5_1_1.setVisible(true);
				panel_2.setVisible(false);
				
			}
		});
		
		
		
		
		btnDriverDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.setVisible(true);
				panel_5.setVisible(false);
				panel_5_1.setVisible(false);
				panel_5_1_1.setVisible(false);
				
				
			}
		});
		
		btnTrips.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.setVisible(false);
				panel_5_1_1.setVisible(false);
				panel_5_1.setVisible(false);
				panel_5.setVisible(true);
			}
		});
		
		btnSentMessages.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_2.setVisible(false);
				panel_5.setVisible(false);
				panel_5_1_1.setVisible(false);
				panel_5_1.setVisible(true);
				
			}
		});
	}
}
