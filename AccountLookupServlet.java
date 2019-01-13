/*
 * Aaron Bennett
* Lab 6 
Account Lookup Servlet
 */

import Buisness.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;


/**
 *
 * @author Tim
 */
@WebServlet(urlPatterns = {"/AccountLookupServlet"})
public class AccountLookupServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String acctno;
         //   String custid;
        //    String type;
       //     String bal;
            
           acctno = request.getParameter("acctnotf");
       //    custid = request.getParameter("custidtf");
      //     type = request.getParameter("typetf");
     //      bal = request.getParameter("baltf");
            
            Account a1;
            a1 = new Account();
            a1.selectDB(acctno);
            a1.display();
           
            
            HttpSession ses1;
            ses1 = request.getSession();
            ses1.setAttribute("a1",a1);
            System.out.println("Account Added to Session");
            
            RequestDispatcher rd = request.getRequestDispatcher("/DisplayAccount.jsp");
            rd.forward(request,response);
            
            
            
             
                
             
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
