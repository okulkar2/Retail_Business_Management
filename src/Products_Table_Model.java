
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
 * @author Chetan
 */
public class Products_Table_Model extends AbstractTableModel{

    String[] prod_columns;
    int column_count;   
    Vector data;
    
    public Products_Table_Model() {
        
        //data=new Vector();
    }
    
    @Override
    public String getColumnName(int i) {
        
        return prod_columns[i];
    }
    
    @Override
    public int getRowCount() {
        
        return data.size();
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
          
            CallableStatement cs = dbConnection.prepareCall("begin ? := retail_business.show_Products(); end;");
        
	    //register the out parameter (the first parameter)
            cs.registerOutParameter(1, OracleTypes.CURSOR);
        
            // execute and retrieve the result set
            cs.execute();
            
            ResultSet resultset = (ResultSet)cs.getObject(1);
    
            ResultSetMetaData meta = resultset.getMetaData();
         
            column_count = meta.getColumnCount();
            
            prod_columns=new String[column_count];
            
            for(int i=1;i<=column_count;i++) {
                prod_columns[i-1]=meta.getColumnName(i);
            }
          
            data=new Vector();
            
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
            
            
        }
   }
    
    public void add_Product(String pid, String pname, int qoh, int threshold,float price,float discount) {
        
        try {
            
            OracleDataSource dataSource=new OracleDataSource();
       
            dataSource.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            
            Connection dbConnection=dataSource.getConnection("OMKAR KULKARNI","Rameshwar22592");
          
            CallableStatement cs = dbConnection.prepareCall("{call retail_business.add_product(?,?,?,?,?,?)}");
            
            cs.setString(1,pid);
            
            cs.setString(2,pname);
            
            cs.setInt(3,qoh);
            
            cs.setInt(4,threshold);
            
            cs.setFloat(5,price);
            
            cs.setFloat(6,discount);
            
            
            //PreparedStatement insert = conn.prepareStatement("INSERT into students VALUES(?,?,?,?,?,?)");

            
	    //register the out parameter (the first parameter)
            //cs.registerOutParameter(1, OracleTypes.CURSOR);
            
            // execute and retrieve the result set
            cs.executeUpdate();
            
            showAlertDialog("Record inserted successfully !!");
            
            if(cs!=null)
                cs.close();
            
            if(dbConnection!=null)
                dbConnection.close();
            
            buildDBConnection();
        
        } catch (SQLException ex) {
            
            System.out.println("Exception is "+ex.getMessage());
            
            if(ex.getErrorCode()==00001)
                showAlertDialog("Products ID already exists. Please enter a unique ID for product");
            else if(ex.getErrorCode()==2290)
                showAlertDialog("The value for discount should be within 0 and 0.8");
        }
        
    }
    
    public void monthly_sale_info(String pid) {
            
        try {
            
            OracleDataSource dataSource=new OracleDataSource();
       
            dataSource.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            
            Connection dbConnection=dataSource.getConnection("OMKAR KULKARNI","Rameshwar22592");
          
            CallableStatement cs = dbConnection.prepareCall("begin ? := retail_business.monthly_sale(?); end;");
        
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            
            cs.setString(2,pid);
	    //register the out parameter (the first parameter)
            
        
            // execute and retrieve the result set
            cs.execute();
            
            ResultSet resultset = (ResultSet)cs.getObject(1);
            
            System.out.println("Result set is "+resultset);
            
            ResultSetMetaData meta = resultset.getMetaData();
         
            column_count = meta.getColumnCount();
            
            prod_columns=new String[column_count];
            
            for(int i=1;i<=column_count;i++) {
                prod_columns[i-1]=meta.getColumnName(i);
            }
          
            data=new Vector();

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
            
        }catch (SQLException ex) {
            
            System.out.println("Exception is "+ex.getMessage());
            
            showAlertDialog(ex.getMessage());
        }
    }
    
    
    private void showAlertDialog(String message) {
        
        JFrame frame = new JFrame("Alert Dialog");
     
        // show a joptionpane dialog using showMessageDialog
        JOptionPane.showMessageDialog(frame,message);
    }
}
