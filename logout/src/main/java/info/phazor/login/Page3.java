/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package info.phazor.login;

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
  public class Page3 extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    String target = request.getRequestURI();

    HttpSession session = request.getSession(false);

    if (session == null){
      /* まだ認証されていない */
      session = request.getSession(true);
      session.setAttribute("target", target);

      response.sendRedirect("/login-1.0/login");
    }else{
      Object loginCheck = session.getAttribute("login");
      if (loginCheck == null){
        /* まだ認証されていない */
        session.setAttribute("target", target);
        response.sendRedirect("/login-1.0/login");
      }
    }

    out.println("<html>");
    out.println("<head>");
    out.println("<title>検査オーダー</title>");
    out.println("</head>");
    out.println("<body>");

    out.println("<p><a href=\"/login-1.0/page1\">外来待ち受け状況</a></p>");
    out.println("<p><a href=\"/login-1.0/page2\">患者検索</a></p>");
    out.println("<p>検査オーダー</p>");


    out.println("</body>");
    out.println("</html>");
  }
}