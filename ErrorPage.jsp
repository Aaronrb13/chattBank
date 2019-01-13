<%-- 
     Aaron Bennett 
      Lab 6 Error Page JSP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import= "Buisness.Customer;" %>


<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error page</title>
    </head>
    <body>
        <% Customer c1; 
         c1 = (Customer)session.getAttribute("c1");
            String id;
            String pw;
          
        
            
            pw = request.getParameter("pwtf");
            id = request.getParameter("idtf");
         
        %>
        <h1>ERROR FOR USER LOGGING IN WITH ID: <%= c1.getCustID() %></h1>
        <h2>INVALID PASSWORD!!!</h2>
        
    </body>
</html>
