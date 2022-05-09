/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package info.phazor.logout;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author air-h-128k-il
 */
public class LoginCheck extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();

    String user = request.getParameter("user");
    String pass = request.getParameter("pass");

    HttpSession session = request.getSession(true);

    boolean check = authUser(user, pass);
    if (check){
      /* 認証済みにセット */
      session.setAttribute("login", "OK");

      response.sendRedirect("/logout-1.0/login");
    }else{
      /* 認証に失敗してもその場に留まる。アラート出すとか工夫の余地あり */
      session.setAttribute("status", "Not Auth");
      response.sendRedirect("/logout-1.0/login");
    }
  }

  protected boolean authUser(String user, String pass){

    /* admin, admin に固定 */
    if (user.endsWith("admin") && pass.equals("admin")){
      return true;
    }else{
      return false;
  }
    
    //return false;
  }
}