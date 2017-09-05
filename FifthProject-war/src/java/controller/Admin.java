/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;
import model.StudentFacade;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "Admin", urlPatterns = {"/Admin"})
public class Admin extends HttpServlet {

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

        char gender = request.getParameter("gender").charAt(0);
        List std = studentFacade.findAll();

        try (PrintWriter out = response.getWriter()) {

            if ((gender != 'M') && (gender != 'F')) {
                out.println("Wrong input, please enter M or F");
                request.getRequestDispatcher("admin.jsp").include(request, response);
                return;
            }
            String title = "Database Result";
            String docType
                    = "<!doctype html public \"-//w3c//dtd html 4.0 "
                    + "transitional//en\">\n";
            out.println(docType
                    + "<html>\n"
                    + "<head><title>" + title + "</title></head>\n"
                    + "<h1 align=\"center\">" + title + "</h1>\n");

            out.println("<table border=\"1\" width=\"100%\">\n"
                    + "            <tr>\n"
                    + "                <th>Student Name</th>\n"
                    + "                <th>Gender</th>\n"
                    + "                <th>Balance</th>\n"
                    + "            </tr>");

            // Iterator:迭代器
            // 详解: 迭代器声明一个List类型的变量，该变量接受一个 LIST类型的迭代
            // 调用迭代器的 hasNext()方法, 则依次遍历list中的数据
            for (Iterator it = std.iterator(); it.hasNext();) {
                // 遍历每一个学生
                Student elem = (Student) it.next();

                // 当管理员输入的性别  == 学生的性别
                if (gender == elem.getGender()) {
                    // 打印当前学生信息

                    out.println("<tr>\n" + "<td>" + elem.getId() + "</td>");
                    out.println("<td>" + elem.getGender() + "</td>");
                    out.println("<td>" + elem.getBalance() + "</td>\n"
                            + "                </tr>");
                }     
            }
            out.println("</body></html>");
            request.getRequestDispatcher("admin.jsp").include(request, response);

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
