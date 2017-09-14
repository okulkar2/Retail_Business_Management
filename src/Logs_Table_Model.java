
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.pool.OracleDataSource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Omkar
 */
public class Logs_Table_Model extends AbstractTableModel {

    String[] log_columns;
    int column_count;   
    Vector data;
    
    public Logs_Table_Model() {
        
    }
    
    @Override
    public String getColumnName(int i) {
        
        return log_columns[i];
    }
    
    @Override
    public int getRowCount() {
        if(data!=null)
            return data.size();
        else 
            return 0;
    }

    @Override
    public int getColumnCount() {
        
        return column_count;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        return ((String[]) data.elementAt(rowIndex))[columnIndex];
    }
    
    
    public void buildDBConnection(){
      
       try {
            
            OracleDataSource dataSource=new OracleDataSource();
       
            dataSource.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            
            Connection dbConnection=dataSource.getConnection("OMKAR KULKARNI","Rameshwar22592");
          
            CallableStatement cs = dbConnection.prepareCall("begin ? := retail_business.show_Logs(); end;");
        
	    //register the out parameter (the first parameter)
            cs.registerOutParameter(1, OracleTypes.CURSOR);
        
            // execute and retrieve the result set
            cs.execute();
            
            ResultSet resultset = (ResultSet)cs.getObject(1);
    
            ResultSetMetaData meta = resultset.getMetaData();
         
            column_count = meta.getColumnCount();
            
            log_columns=new String[column_count];
            
            data=new Vector();
            
            for(int i=1;i<=column_count;i++) {
                log_columns[i-1]=meta.getColumnName(i);
            }
          
            while (resultset.next()) {
                
                String[] record=new String[column_count];
                
                for(int i=0;i<column_count;i++)
                    record[i]=resultset.getString(i+1);
                
                data.addElement(record);
            }
            
            fireTableChanged(null);
            
            fireTableDataChanged();
            
            if(cs!=null)
                cs.close();
            
            if(dbConnection!=null)
                dbConnection.close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            showAlertDialog(ex.getMessage());
        }
   }    
    
      private void showAlertDialog(String message) {
        
        JFrame frame = new JFrame("Alert Dialog");
     
        // show a joptionpane dialog using showMessageDialog
        JOptionPane.showMessageDialog(frame,message);
    }
}
