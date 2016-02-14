/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.user;
import model.userUtilities;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/Authentication"})
public class loginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    user us;
    userUtilities userUtil;
    Cookie ck;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            us = new user();
            us.setUsername(request.getParameter("username"));
            us.setPassword(request.getParameter("password"));
            // vvvvv  checkbutton state are on OR null vvvvvv
            boolean remember = request.getParameter("remember") != null;
            
            userUtil = new userUtilities();
            userUtil.init();
            String role = userUtil.getData(us);
            if(role.equals("fail")){
                RequestDispatcher dispatch = request.getRequestDispatcher("reallogin.jsp");
                dispatch.include(request, response);
            }
            else {
                 //cookies Handeling (manufacture)
                Cookie[] packOfcookies = request.getCookies();
                if (remember){
                    ck = new Cookie("usCookie", request.getParameter("username")); //make a piece of cookie
                    ck.setMaxAge(60*60*24); //set expire to 1 day
                    response.addCookie(ck); //pack it.
                }
                else if((packOfcookies != null) && !remember){
                        for(Cookie cookie : packOfcookies){ // unpack here!!
                            if (cookie.getName().equals("usCookie")){
                                cookie.setMaxAge(0); //decay a cookie. 555+
                                response.addCookie(cookie); //this cookie will expire in 0 secound!!
                            }
                        }
                }
                RequestDispatcher dispatch = request.getRequestDispatcher(role+"page.html");
                dispatch.forward(request, response);
            }
          
            out.println("<script type=\"text/javascript\">\n" +
                "       document.getElementById('aleart').innerHTML = \"Invalid Username or Password!!\";\n" +
                " "+
                "	</script>");
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
