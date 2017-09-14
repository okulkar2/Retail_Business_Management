
import Employees.Employee_Table_Model;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


/**
 *
 * @author Chetan
 */
public class Retail_Business extends javax.swing.JFrame implements ActionListener{
    
    private JPanel employees,customers,products,suppliers,supply,purchases,logs;
    private JButton add_product_button,monthly_sale_button,add_purchase_button,show_all_products;
    private Products_Table_Model prod_model;
    private Purchases_Table_Model pur_model;
    private Customer_Table_Model cust_model;
    private Employee_Table_Model emp_model;
    private Suppliers_Table_Model supp_model;
    private Supply_Table_Model sup_model;
    private Logs_Table_Model logs_model;
    

    /**
     * Creates new form Retail_Business
     */
    public Retail_Business() {
        initComponents();
        initUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 398, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void initUI() {
        
       JFrame main=new JFrame();
       main.setLocation(300, 100);
        
       // Creating a Tabbed Pane Container which will include all tabs 
       jTabbedPane1=new JTabbedPane(JTabbedPane.LEFT);
       jTabbedPane1.setPreferredSize(new Dimension(1200, 700));
       jTabbedPane1.setForeground(Color.WHITE);
       main.getContentPane().add(jTabbedPane1);
        
       // Creating panel for Employees Tab which includes table to display employee tuples
       employees=new JPanel();
       employees.setLayout(new BorderLayout());
       emp_model=new Employee_Table_Model();
       JTable employees_table=new JTable(emp_model);
       employees_table.setFont(new Font("Serif", Font.PLAIN, 16));
       employees_table.setRowHeight(40);
       emp_model.buildDBConnection();
       JScrollPane emp_scrollpane = new JScrollPane(employees_table);
       employees.add(emp_scrollpane);
       
       // Creating panel for Customers Tab which includes table to display customer tuples
       customers=new JPanel();
       customers.setLayout(new BorderLayout());
       cust_model=new Customer_Table_Model();
       JTable customers_table=new JTable(cust_model);
       customers_table.setFont(new Font("Serif", Font.PLAIN, 16));
       customers_table.setRowHeight(40);
       cust_model.buildDBConnection();
       JScrollPane cust_scrollpane = new JScrollPane(customers_table);
       customers.add(cust_scrollpane);
        
       // Creating panel for Products Tab which includes table to display product tuples
       products=new JPanel();
       products.setLayout(new BorderLayout());
       prod_model=new Products_Table_Model();
       JTable products_table=new JTable(prod_model);
       products_table.setFont(new Font("Serif", Font.PLAIN, 16));
       products_table.setRowHeight(40);
       prod_model.buildDBConnection();
       JScrollPane prod_scrollpane = new JScrollPane(products_table);
       products.add(prod_scrollpane,BorderLayout.CENTER);
       
       // Adding Add Product and Monthly Sale button under Products Table
       JPanel product_button_panel=new JPanel(new FlowLayout());
       add_product_button=new JButton("Add Product");
       add_product_button.addActionListener(this);
       monthly_sale_button=new JButton("Monthly_Sale");
       monthly_sale_button.addActionListener(this);
       show_all_products=new JButton("All Products");
       show_all_products.addActionListener(this);
       
       product_button_panel.add(add_product_button);
       product_button_panel.add(monthly_sale_button);
       product_button_panel.add(show_all_products);
       products.add(product_button_panel,BorderLayout.SOUTH);
       
       // Creating panel for Suppliers Tab which includes table to display supplier tuples
       suppliers=new JPanel();
       suppliers.setLayout(new BorderLayout());
       supp_model=new Suppliers_Table_Model();
       JTable supp_table=new JTable(supp_model);
       supp_table.setFont(new Font("Serif",Font.PLAIN, 16));
       supp_table.setRowHeight(40);
       supp_model.buildDBConnection();
       JScrollPane supp_scrollpane = new JScrollPane(supp_table);
       suppliers.add(supp_scrollpane);
       
       // Creating panel for Supply Tab which includes table to display supply tuples
       supply=new JPanel();
       supply.setLayout(new BorderLayout());
       sup_model=new Supply_Table_Model();
       JTable sup_table=new JTable(sup_model);
       sup_table.setFont(new Font("Serif", Font.PLAIN, 16));
       sup_table.setRowHeight(40);
       sup_model.buildDBConnection();
       JScrollPane sup_scrollpane = new JScrollPane(sup_table);
       supply.add(sup_scrollpane);
       
       // Creating panel for Purchases Tab which includes table to display purchases tuples
       purchases=new JPanel();
       purchases.setLayout(new BorderLayout());
       pur_model=new Purchases_Table_Model();
       JTable pur_table=new JTable(pur_model);
       pur_table.setFont(new Font("Serif", Font.PLAIN, 16));
       pur_table.setRowHeight(40);
       pur_model.buildDBConnection();
       JScrollPane pur_scrollpane = new JScrollPane(pur_table);
       purchases.add(pur_scrollpane,BorderLayout.CENTER);
       
       // Adding Add Purchase button to the container 
       JPanel purchase_button_panel=new JPanel(new FlowLayout());
       add_purchase_button=new JButton("Add Purchase");
       add_purchase_button.addActionListener(this);
       purchase_button_panel.add(add_purchase_button);
       purchases.add(purchase_button_panel,BorderLayout.SOUTH);
       
       // Creating panel for Logs Tab which includes table to display tuples of log
       logs=new JPanel();
       logs.setLayout(new BorderLayout());
       logs_model=new Logs_Table_Model();
       JTable logs_table=new JTable(logs_model);
       logs_table.setFont(new Font("Serif", Font.PLAIN, 16));
       logs_table.setRowHeight(40);
       logs_model.buildDBConnection();
       JScrollPane log_scrollpane = new JScrollPane(logs_table);
       logs.add(log_scrollpane);
       
       
       
       // Adding Tab Components one by one
       jTabbedPane1.addTab("Employees", employees);
       jTabbedPane1.addTab("Customers", customers);
       jTabbedPane1.addTab("Products", products);
       jTabbedPane1.addTab("Suppliers", suppliers);
       jTabbedPane1.addTab("Supply",supply);
       jTabbedPane1.addTab("Purchases",purchases);
       jTabbedPane1.addTab("Logs",logs);
       
       // Customize Employees Tab
       JLabel emp_lab = new JLabel("Employees",new ImageIcon(
                this.getClass().getResource("/employee.png")),SwingConstants.CENTER);
       emp_lab.setIconTextGap(7);
       emp_lab.setFont(new Font(Font.SANS_SERIF, Font.BOLD,15));
       emp_lab.setPreferredSize(new Dimension(250, 80));
       jTabbedPane1.setTabComponentAt(0, emp_lab);
       
       JLabel cus_lab = new JLabel("Customers",new ImageIcon(
                this.getClass().getResource("/customers.jpg")),SwingConstants.CENTER);
       cus_lab.setIconTextGap(7);
       cus_lab.setFont(new Font(Font.SANS_SERIF, Font.BOLD,15));
       cus_lab.setPreferredSize(new Dimension(250, 80));
       jTabbedPane1.setTabComponentAt(1, cus_lab);
       
       JLabel prod_lab = new JLabel("Products",new ImageIcon(
                this.getClass().getResource("/product.png")),SwingConstants.CENTER);
       prod_lab.setIconTextGap(10);
       prod_lab.setFont(new Font(Font.SANS_SERIF, Font.BOLD,15));
       prod_lab.setPreferredSize(new Dimension(250, 80));
       jTabbedPane1.setTabComponentAt(2, prod_lab);
       
       JLabel supplier_lab = new JLabel("Suppliers",SwingConstants.CENTER);
       supplier_lab.setIconTextGap(7);
       supplier_lab.setFont(new Font(Font.SANS_SERIF, Font.BOLD,15));
       supplier_lab.setPreferredSize(new Dimension(250, 80));
       supplier_lab.setIcon(new ImageIcon(
                this.getClass().getResource("/supplier.jpg")));
       jTabbedPane1.setTabComponentAt(3, supplier_lab);
       
       JLabel sup_lab = new JLabel("Supply",new ImageIcon(
                this.getClass().getResource("/supply.jpg")),SwingConstants.CENTER);
       sup_lab.setFont(new Font(Font.SANS_SERIF, Font.BOLD,15));
       sup_lab.setIconTextGap(10);
       sup_lab.setPreferredSize(new Dimension(250, 80));
       jTabbedPane1.setTabComponentAt(4, sup_lab);
       
       JLabel pur_lab = new JLabel("Purchases",new ImageIcon(
                this.getClass().getResource("/purchase.png")),SwingConstants.CENTER);
       pur_lab.setFont(new Font(Font.SANS_SERIF, Font.BOLD,15));
       pur_lab.setPreferredSize(new Dimension(250, 80));
       jTabbedPane1.setTabComponentAt(5, pur_lab);
       
       JLabel log_lab = new JLabel("Logs",new ImageIcon(
                this.getClass().getResource("/employee.png")),SwingConstants.CENTER);
       log_lab.setIconTextGap(7);
       log_lab.setFont(new Font(Font.SANS_SERIF, Font.BOLD,15));
       log_lab.setPreferredSize(new Dimension(250, 80));
       jTabbedPane1.setTabComponentAt(6, log_lab);
       
       main.pack();
       main.setVisible(true);   
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    /**
     * This method is called when any of the JButton is clicked.
     * Depending on the source of button 
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add_product_button) {
            JTextField pid_text = new JTextField();
            JTextField pname_text = new JTextField();
            JTextField qoh_text = new JTextField();
            JTextField threshold_text = new JTextField();
            JTextField original_price_text = new JTextField();
            JTextField discnt_rate_text = new JTextField();
            
            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new Label("Enter ProductID :"));
            panel.add(pid_text);
            panel.add(new Label("Enter Product Name :"));
            panel.add(pname_text);
            panel.add(new Label("Enter QOH of Product :"));
            panel.add(qoh_text);
            panel.add(new Label("Enter Threshold for Product :"));
            panel.add(threshold_text);
            panel.add(new Label("Enter Original Price of Product :"));
            panel.add(original_price_text);
            panel.add(new Label("Enter Discount rate :"));
            panel.add(discnt_rate_text);
            
            int result = JOptionPane.showConfirmDialog(null, panel, "Input",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                if(prod_model!=null) {
                    
                    String pid=pid_text.getText().trim();
                    String pname=pname_text.getText().trim();
                    try {
                        int qoh=Integer.parseInt(qoh_text.getText().trim());
                        int threshold=Integer.parseInt(threshold_text.getText().trim());
                        float original_price=Float.parseFloat(original_price_text.getText().trim());
                        float discount=Float.parseFloat(discnt_rate_text.getText().trim());
                    
                        if(validate(pid)&&validate(pname)&&validate(qoh)&&validate(threshold)&&validate(original_price)&&validate(discount))  {                      
                            prod_model.add_Product(pid,pname,qoh,threshold,original_price,discount);
                            logs_model.buildDBConnection();
                        }
                        else
                            showAlertDialog("Please enter valid fields ");
                    } catch(NumberFormatException nfe) {
                        
                        showAlertDialog("Please enter valid input fields");
                    }
                }
            } else {
                System.out.println("Cancel");
            }
        }
        else if(e.getSource()==monthly_sale_button){
            System.out.println("Monthly sale button clicked");
            JTextField pid_text = new JTextField(); 
            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new Label("Enter Product ID :"));
            panel.add(pid_text);
            int result = JOptionPane.showConfirmDialog(null, panel, "Input",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                if(pur_model!=null) {
         
                    String pid=pid_text.getText().trim();
                      
                    if(validate(pid))
                        prod_model.monthly_sale_info(pid);
                    else
                        showAlertDialog("Please enter valid Product ID ");
                }
            } else {
                System.out.println("Cancel");
            }
        }
        
        else if(e.getSource()==add_purchase_button){
            JTextField eid_text = new JTextField();
            JTextField pid_text = new JTextField();
            JTextField cid_text = new JTextField();
            JTextField quantity_text = new JTextField();
            
            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new Label("Enter Employee ID :"));
            panel.add(eid_text);
            panel.add(new Label("Enter Product ID :"));
            panel.add(pid_text);
            panel.add(new Label("Enter Customer ID :"));
            panel.add(cid_text);
            panel.add(new Label("Enter Quantity of Purchase :"));
            panel.add(quantity_text);
            
            int result = JOptionPane.showConfirmDialog(null, panel, "Input",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                if(pur_model!=null) {
                    try {
                        String eid=eid_text.getText().trim();
                        String pid=pid_text.getText().trim();
                        String cid=cid_text.getText().trim();
                        int quantity=Integer.parseInt(quantity_text.getText().trim());
                        if(validate(eid) && validate(pid) && validate(cid) && validate(quantity)) {
                            pur_model.add_Purchase(eid,pid,cid,quantity);   
                            prod_model.buildDBConnection();
                            sup_model.buildDBConnection();
                            cust_model.buildDBConnection();
                            logs_model.buildDBConnection();
                        }
                        else
                            showAlertDialog("Please enter empty fields");
                     
                    } catch(NumberFormatException nfe){
                        showAlertDialog("Please enter valid number for quantity");
                        
                    }
                }
            } else {
                System.out.println("Cancel");
            }
        }
        
        else if(e.getSource()==show_all_products){
            
            if(prod_model!=null)
                prod_model.buildDBConnection();
        }
    }
    
    
    private boolean validate(String field) {
        
        if(field!=null && !field.isEmpty() && !field.equalsIgnoreCase("null"))
            return true;
        return false;
    }
    
     private boolean validate(int field) {
        
        if(field>0)
            return true;
        return false;
    }
     
     private boolean validate(float field) {
        
        if(field>0.0)
            return true;
        return false;
    }
     
    private void showAlertDialog(String message) {
        
        JFrame frame = new JFrame("Alert Dialog");
        // show a joptionpane dialog using showMessageDialog
        JOptionPane.showMessageDialog(frame,message);
    }
}
