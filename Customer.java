package Buisness;
import java.sql.*;
 
// Aaron Bennett 
// Lab 3
// Java3

// =========================== Properties ===========================
public class Customer  {
    private String CustID;
    private String CustPassword;
    private String CustFirstName;
    private String CustLastName;
    private String CustAddress;
    private String CustEmail;
    
    public AccountList clist = new AccountList();
    
    
    // ============================= Constructors ================================
    public Customer(){
        CustID = "";
        CustPassword = "";
        CustFirstName = "";
        CustLastName = "";
        CustAddress = "";
        CustEmail = "";           
    }
    
    public Customer(String cid, String pw, String fn, String ln, String add, String e){
        CustID = cid;
        CustPassword = pw;
        CustFirstName = fn;
        CustLastName = ln;
        CustAddress = add;
        CustEmail = e;
    }
    
    
    //========================= Parameters ==================================
    
    public void setCustID(String cid) {CustID = cid;}
    public String getCustID() {return CustID;}
    
    public void setCustPassword(String pw) {CustPassword = pw;}
    public String getCustPassword() {return CustPassword;}
    
    public void setCustFirstName(String fn) {CustFirstName = fn;}
    public String getCustFirstName() {return CustFirstName;}
    
    public void setCustLastName(String ln) {CustLastName = ln;}
    public String getCustLastName() {return CustLastName;}
    
    public void setCustAddress(String add) {CustAddress = add;}
    public String getCustAddress() {return CustAddress;}
    
    public void setCustEmail(String e) {CustEmail = e;}
    public String getCustEmail() {return CustEmail;}
            
    
    public void display(){
        System.out.println("Your Account Number is: "+getCustID());
        System.out.println("Your Password is: "+getCustPassword());
        System.out.println("Your First Name is: "+getCustFirstName());
        System.out.println("Your Last Name is: "+getCustLastName());
        System.out.println("Your Address is: "+getCustAddress());
        System.out.println("Your Email is: "+getCustEmail());
        clist.display();
        
    }// end display
    
    //+++++++++++++++++++++++++ DataBase Behaviors ++++++++++++++++++++++++
    
     public void selectDB(String id){
        CustID = id;
        try{
            
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");   
            
        // Load Driver
        String connURL = "jdbc:ucanaccess://c:/Users/Tim/Desktop/ChattBankACCDB1.accdb";
        
        // get connection
        Connection con = DriverManager.getConnection(connURL);
        
        // create statement
        Statement stmt = con.createStatement();
        String sql = "select * from Customers where CustID= '"+getCustID()+"'";
        // execute statement
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        
        // Process Data
       rs.next();
       setCustPassword(rs.getString(2));
       setCustFirstName(rs.getString(3));
       setCustLastName(rs.getString(4));
       setCustAddress(rs.getString(5));
       setCustEmail(rs.getString(6));
        //close connection
        con.close();
        
          
}// end try
         catch(Exception e){
            System.out.println("Error!"+e);
        }// end catch
        
    }// end select
    
     public void insertDB(String cid, String pw, String fn, String ln, String add, String e){
        CustID = cid;
        CustPassword = pw;
        CustFirstName = fn;
        CustLastName = ln;
        CustAddress = add;
        CustEmail = e;
        
        try{
            // Load Driver
        String connURL = "jdbc:ucanaccess://c:/Users/Tim/Desktop/ChattBankACCDB1.accdb";
        
        // get connection
        Connection con = DriverManager.getConnection(connURL);
        
        // create statement
        Statement stmt = con.createStatement();
        String sql = "Insert into Customers values('"+getCustID()+"',"+
                                                 "'"+getCustPassword()+"',"+
                                                 "'"+getCustFirstName()+"',"+
                                                  "'"+getCustLastName()+"',"+
                                                   "'"+getCustAddress()+"',"+
                                                    "'"+getCustEmail()+"')";
                                                         
        
        System.out.println(sql);
        int n = stmt.executeUpdate(sql);
        
        if (n==1)
            System.out.println("INSERT SUCCESSFUL!!!");
        else 
            System.out.println("INSERT FAILED*******");
        con.close();
        }
        catch(Exception e1){
            System.out.println(e1);
        }// end catch
    }// end insertDB
     
     public void deleteDB(){
        
        try{
            
            String connURL = "jdbc:ucanaccess://c:/Users/Tim/Desktop/ChattBankACCDB1.accdb";
            
             Connection con = DriverManager.getConnection(connURL);
             
              Statement stmt = con.createStatement();
              
             String sql = "Delete from Customers where CustID='"+getCustID()+"'";
             System.out.println(sql);
               int n = stmt.executeUpdate(sql);
               
               if (n==1)
                   System.out.println("DELETE SUCCESSFUL!!!");
               else
                   System.out.println("DELETE FAILED********");
               con.close();
                     
             
        }// end try
        catch(Exception e1){
            System.out.println(e1);
        }// end catch
    }// end deleteDB
    
     
   /*  public void addAccountList(String id) {
         CustID = id;
        try{
        // Load Driver
        String connURL = "jdbc:ucanaccess://c:/Users/Tim/Desktop/ChattBankACCDB1.accdb";
        
        // get connection
        Connection con = DriverManager.getConnection(connURL);
        
        // create statement
        Statement stmt = con.createStatement();
        String sql = "select AcctNo from Accounts where CustID= '"+id+"'";
        // execute statement
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        
        // Process Data
        
     while( rs.next()){
         CustID = rs.getString();
         a1.new Account();
         a1.selectDB(acctNo);
         clist.addAccount(a1);
       
        }
        //close connection
        con.close();
        
          
}// end try
        catch(Exception e){
            System.out.println("Error!"+e);
        }// end catch
         
     }
     */
     
     public static void main(String[] args){
     // Testing Customer Class
   //  Customer c1 = new Customer("10001", "password", "Soren","Zaros", "123 milkyway lane","Sorenzaros@gmail.com");
   //  c1.display();
   
   //Testing SelectDB()
  // Customer c2 = new Customer();
  // c2.selectDB("3001");
  // c2.display();
  
  // Testing InsertDB()
   // Customer c3 = new Customer();
   // c3.insertDB("10001", "password", "Soren","Zaros", "123 milkyway lane","Sorenzaros@gmail.com");
  //   c3.display();
     
  // Testing DeleteDB()
  //  Customer c4 = new Customer();
 //   c4.selectDB("10001");
 //   c4.deleteDB();
 //   c4.display();
    
     
     }
    
}// end class
