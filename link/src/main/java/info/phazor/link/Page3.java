/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package info.phazor.link;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author air-h-128k-il
 */
  public class Page3 extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head>");
    out.println("<title>link test</title>");
    out.println("</head>");
    out.println("<body>");

    out.println("<p><a href=\"/link-1.0/page1\">テストページ1へ</a></p>");
    out.println("<p><a href=\"/link-1.0/page2\">テストページ2へ</a></p>");
    out.println("<p>テストページ3</p>");


    out.println("</body>");
    out.println("</html>");
  }
}