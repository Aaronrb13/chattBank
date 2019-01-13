<%-- 
    Document   : login
    Created on : Dec 6, 2017, 9:36:00 PM
    Author     : Tim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chatt Bank Login Page</title>
    </head>
    <body>
         <h1> Login Page </h1>
        <form action="http://localhost:8084/ChattBank/LoginServlet" method="post">
        ID: &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;   <input type="text" name="idtf"> <br/>
        Password: <input type="text" name="pwtf"> <br/> 

        <input type="submit" value="Login">
        <input type="reset" value="Reset">
        </form>
       
    </body>
</html>
