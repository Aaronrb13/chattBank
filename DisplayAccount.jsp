<%-- 
    Aaron Bennett
    Display Account jsp
    Lab 6 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="Buisness.Account"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Account</title>
    </head>
    <%  Account a1 = new Account(); 
    a1 = (Account)session.getAttribute("a1");
    %>
    
        <form action="http://localhost:8084/ChattBank/AccountLookupServlet" method="post">
      AcctNo: <input type="text" name="acctnotf" value=<%= a1.getAcctNo() %>> <br/>
    CustID: <input type="text" name="custidtf" value=<%= a1.getCid() %>> <br/>
    Type: <input type="text" name="typetf" value=<%= a1.getType() %>> <br/>
    Bal: <input type="text" name="baltf" value=<%= a1.getBal() %>> <br/>
        
    <input type="submit" name="submit" value="Lookup Account"/>
    <input type="reset" name="reset" value="clear"/>
        </form>
   
</html>
