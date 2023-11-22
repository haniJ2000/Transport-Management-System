package Interface;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


class ButtonEditor extends DefaultCellEditor { 
	private static final long serialVersionUID = 1L;
	Object label;
	Object label_1;
	Object table_2;
	JTable table_3;
	JTextField text;
    protected JButton button;
    private boolean isPushed;
    String table_1;
    int i;

    public ButtonEditor(JTextField textField,JTextField text) {
        super(textField);
        this.text = text;
        button = new JButton();
        
        button.setOpaque(true);
        button.setBackground(new Color(128, 0, 0)); // Set a common background color for all buttons
        button.setForeground(Color.WHITE);
        button.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }

			
	
        });
    }
    


	public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
		
		table_3 = table;
		i = row;
		if(table.getColumnName(0)=="Customer") {
			button.setName("Delete");
			table_1=table.getColumnName(0);
			label = table.getValueAt(row, 0);
		    label_1 = table.getValueAt(row, 4);
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        button.setText("Delete");

	}else if(table.getColumnName(0)=="Driving License No") {
		button.setName("Delete");
		table_1=table.getColumnName(0);
		label = table.getValueAt(row, 0);
	    label_1 = table.getValueAt(row, 1);
	    
    if (isSelected) {
        button.setForeground(table.getSelectionForeground());
        button.setBackground(table.getSelectionBackground());
    } else {
        button.setForeground(table.getForeground());
        button.setBackground(table.getBackground());
    }
    
    button.setText("Delete");
	 
		
	
	}else if (table.getColumnName(6)=="Accept") {
		button.setName("Accept");
		table_1=table.getColumnName(0);
		table_2 = table.getColumnName(6);
		
	    
    if (isSelected) {
        button.setForeground(table.getSelectionForeground());
        button.setBackground(table.getSelectionBackground());
    } else {
        button.setForeground(table.getForeground());
        button.setBackground(table.getBackground());
    }
    
    button.setText("Accept");
	 
		
	
	}
	
	
		isPushed = true;
		 return button;	
	
    }




	public Object getCellEditorValue() {
        if (isPushed) {
        	
        	if(table_1=="Customer") {
    		try {
    			String str_1 = label.toString();
            	String str_2 = label_1.toString();
             	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");
     			String query_1  = " DELETE FROM customeraccount WHERE Full_Name = '"+str_1+"' AND Mobile_No = '"+str_2+"'";
     			Statement stm_1  = connection.createStatement();
     			stm_1.executeUpdate(query_1);
     			JOptionPane.showMessageDialog(button, " deleted");
     			DefaultTableModel model  = (DefaultTableModel)table_3.getModel();
                 model.removeRow(i);
                   connection.close();
             	connection.close();	
             	}
     		 catch(Exception e1) {
     			   System.out.println("Error : " + e1);
     		}
        	}else if(table_1=="Driving License No") {
        		try {
        			String str_1 = label.toString();
                	String str_2 = label_1.toString();
                 	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");
         			String query_1  = " DELETE FROM driverpersonalaccount WHERE licence_No = '"+str_1+"'";
         			String query_2  = " DELETE FROM driverpersonalaccount WHERE licence_No = '"+str_1+"' AND plate_no = '"+str_2+"'";
         			Statement stm_1  = connection.createStatement();
         			Statement stm_2  = connection.createStatement();
         			stm_1.executeUpdate(query_1);
         			stm_2.executeUpdate(query_2);
         			JOptionPane.showMessageDialog(button, " deleted");
         			DefaultTableModel model  = (DefaultTableModel)table_3.getModel();
	                  model.removeRow(i);
	                    connection.close();
                 	connection.close();	
                 	}
         		 catch(Exception e1) {
         			   System.out.println("Error : " + e1);
         		}
        		
        	}
        	else if(table_1=="Name") {
        		
        		if(table_2 =="Accept") {
        			 try {
        				String name = text.getText();
     					Object cellValue_name = table_3.getModel().getValueAt(i, 0);
     					Object cellValue_pickup = table_3.getModel().getValueAt(i, 1);
     					Object cellValue_destination = table_3.getModel().getValueAt(i, 2);
     					Object cellValue_cash_card = table_3.getModel().getValueAt(i, 5);
     					Object cellValue_Mobile = table_3.getModel().getValueAt(i, 4);
     					String name_customer = cellValue_name.toString();
     					String pickup = cellValue_pickup.toString();
     					String destination = cellValue_destination.toString();
     					String cash_card = cellValue_cash_card.toString();
     					String mobile = cellValue_Mobile.toString();

     					
 	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zipta", "root", "Disura.294610");
 	                    String query = "INSERT INTO accepttable values('" + name_customer + "','" + pickup + "','" + destination + "','" + cash_card + "','" + name + "','" + mobile + "')";
 	                    Statement sta = connection.createStatement();
 	                    sta.executeUpdate(query);
 	                    
 	                   String query_1  = " DELETE FROM newtrip WHERE pickup = '"+pickup+"' AND destination = '"+destination+"'";
 	       			   Statement stm_1  = connection.createStatement();
 	       			   stm_1.executeUpdate(query_1);
 	       			   
 	       		       String updateSQL = "UPDATE history_newtrip SET Driver_name = ? WHERE pickup = ?"; 
                    
                       PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
                       preparedStatement.setString(1, name);
                       preparedStatement.setString(2, pickup);
                       int rowsUpdated = preparedStatement.executeUpdate();

                      
 	                    
 	                   JOptionPane.showMessageDialog(button, " Accepted");
 	                  DefaultTableModel model  = (DefaultTableModel)table_3.getModel();
 	                  model.removeRow(i);
 	                    connection.close();
 	                } catch (Exception exception) {
 	                    exception.printStackTrace();
 	                }
        			
        		}
        		
        		
        	}
        	
        }
        isPushed = false;
        
        return table_2;
    }

    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}


