/*
 Aaron Bennett Lab 4 
Java 3
 */
package Buisness;

/**
 *
 * @author Tim
 */
public class AccountList {
    int count = 0;
    public Account[] alist = new Account[10];
    
    
    public void addAccount(Account a1){
        alist[count]= a1;
        count++;
             }
    public void display(){
        
    for ( int x=0; x<=(count -1); x++ )
    {
        alist[x].display();
    }
    
    
    
    }// end display
    public static void main(String[] args){
    AccountList a = new AccountList();
    a.addAccount(new Account("1234","1234","REEE",1234.0));
    a.addAccount(new Account("9999","9999","REEE",9999.0));
    a.display();
    }// end main
    
}// end class
