/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Student;
import model.StudentFacade;

/**
 *
 * @author TP037327
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @EJB
    private StudentFacade studentFacade;

    
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
        
        String username = request.getParameter("username");
        int pwd = Integer.parseInt(request.getParameter("password"));

        Student std = studentFacade.find(username);
        //Student admin = studentFacade.find(username);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */ 
           
            if(username.equals("admin") && pwd == 12345){
                    request.getRequestDispatcher("admin.jsp").include(request,response);
                    return ;
                }
            if(std != null){
                 if(std.getPassword() == pwd){
                    request.getRequestDispatcher("user.jsp").include(request,response);
                    out.print("<br><br>");
                    if(std.getGender()=='M'){
                        out.print("Welcome Mr. " + std.getId() + "!");
                    } else{
                        out.print("Welcome Ms. " + std.getId() + "!");
                    }
                    HttpSession session = request.getSession();
                    session.setAttribute("who", std);   
                }else{
                    out.print("Sorry, wrong password!<br><br>");
                    request.getRequestDispatcher("login.jsp").include(request,response);
                }
            }else{
                out.print("Sorry, wrong username!<br><br>");
                request.getRequestDispatcher("login.jsp").include(request,response);
            }   
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
