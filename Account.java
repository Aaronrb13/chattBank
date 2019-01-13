/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buisness;
import java.sql.*;

/**
 *
 * @author Aaron Bennett 
 * Lab 3+4 
 * java3
 */
public class Account {
    // ======================== Properties ======================
  private String AcctNo;
  private String Cid;
  private String Type;
  private double Balance;
 // public AccountList aList = new AccountList();
    
  //====================== Constructors =========================
    // Default Constructor
    public Account(){ 
        AcctNo = "";
        Cid = "";
        Type = "";
        Balance = 0.0;
    }
    
    public Account(String an, String c, String t, double bal){
        AcctNo = an;
        Cid = c;
        Type = t;
        Balance = bal;
    }
    
    public void Deposit(double amount){
        Balance += amount;
        updateDB();
    }
    
    public void Withdraw(double amount){
    
        Balance -= amount;
        updateDB();
}
    
    
    //===================== Behaviors ===============================
    public void setAccNo(String an) {AcctNo = an;}
    public String getAcctNo() {return AcctNo;}
    
    public void setCid(String c) {Cid = c;}
    public String getCid() {return Cid;}
    
    public void setType(String t) {Type = t;}
    public String getType() {return Type;}
    
    public void setBal(double bal) {Balance = bal;}
    public double getBal() {return Balance;}
    
    public void display(){
        System.out.println("Your Account Number is: "+getAcctNo());
        System.out.println("Your Customer ID is: "+getCid());
        System.out.println("Your Account Type is: "+getType());
        System.out.println("Your Balance is: "+getBal());
    }// end display
    
    //++++++++++++++++ DB Behaviors ++++++++++++++++
    
    public void selectDB(String an){
        
         
        AcctNo = an;
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
        // Load Driver
        String connURL = "jdbc:ucanaccess://c:/Users/Tim/Desktop/ChattBankACCDB1.accdb";
        
        // get connection
        Connection con = DriverManager.getConnection(connURL);
        
        // create statement
        Statement stmt = con.createStatement();
        String sql = "select * from Accounts where AcctNo= '"+getAcctNo()+"'";
        // execute statement
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        
        // Process Data
       rs.next();
       setCid(rs.getString(2));
       setType(rs.getString(3));
       setBal(rs.getDouble(4));
        //close connection
        con.close();
        
          
}// end try
        catch(Exception e){
            System.out.println("Error!"+e);
        }// end catch
        
    }// end select
    
    public void updateDB(){
       
        try{
        // Load Driver
        String connURL = "jdbc:ucanaccess://c:/Users/Tim/Desktop/ChattBankACCDB1.accdb";
        
        // get connection
        Connection con = DriverManager.getConnection(connURL);
        
        // create statement
        Statement stmt = con.createStatement();
        String sql = "Update Accounts SET Balance= " +getBal()+ " where AcctNo= '"+getAcctNo()+"'";
        // execute statement
        System.out.println(sql);
        int n = stmt.executeUpdate(sql);
        
        // Process Data
       if (n==1)
           System.out.println("UPDATE SUCCESSFUL!!!");
       else
           System.out.println("UPDATE UNSUCESSFUL!!!");
        //close connection
        con.close();
        
          
}// end try
        catch(Exception e){
            System.out.println("Error!"+e);
        }// end catch
        
    }// end select
    
    
    public static void main(String[] args){
    //    Account a1 = new Account();
    //    a1.selectDB("90001");
   //     a1.Withdraw(300.00);
        
  //      a1.display();
    }
    
}// end class
