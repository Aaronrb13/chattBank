<%-- 
    Document   : accountlookup
    Created on : Nov 7, 2017, 2:20:09 PM
    Author     : Tim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <form action="http://localhost:8084/ChattBank/AccountLookupServlet" method="post">
        <h1>Hello World!</h1>
        AcctNo: <input type="text" name="acctnotf"> <br/>
    CustID: <input type="text" name="custidtf"> <br/>
    Type: <input type="text" name="typetf"> <br/>
    Bal: <input type="text" name="baltf"> <br/>

   <input  type="submit" value="Find">
    <input type="reset" value="Reset">
    </form>
</html>
