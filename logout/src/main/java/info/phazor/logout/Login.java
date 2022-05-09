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
public class Login extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<html>");
    out.println("<head>");
    out.println("<title>WebOceanDolphin login</title>");
    out.println("</head>");
    out.println("<body>");

    
    HttpSession session = request.getSession(true);

    /* 認証失敗から呼び出されたのかどうか */
    Object status = session.getAttribute("status");

    if (status == "Not Auth"){
      out.println("<p>認証に失敗しました</p>");
      out.println("<p>再度ユーザー名とパスワードを入力して下さい</p>");

      //session.setAttribute("status", null);
    }
    
    
    out.println("<form method=\"POST\" action=\"/logout-1.0/logincheck\" name=\"loginform\">");
    out.println("<table>");
    out.println("<tr>");
    out.println("<td>ユーザー名</td>");
    out.println("<td><input type=\"text\" name=\"user\" size=\"32\"></td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("<td>パスワード</td>");
    out.println("<td><input type=\"password\" name=\"pass\" size=\"32\"></td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("<td><input type=\"submit\" value=\"login\"></td>");
    out.println("<td><input type=\"reset\" value=\"reset\"></td>");
    out.println("</tr>");
    out.println("</table>");
    out.println("</form>");
    
    
    
    
    out.println("<p>お知らせ</p>");
    out.println("<p><a href=\"/\">コロナ後遺症を疑っている方へ</a></p>");    
    out.println("<p>ログインに失敗すると以下のコンテンツは利用できません</p>");
    out.println("<br>");
    out.println("<p><a href=\"/logout-1.0/page1\">外来待ち受けページ</a></p>");
    out.println("<p><a href=\"/logout-1.0/page2\">患者検索ページ</a></p>");
    out.println("<p><a href=\"/logout-1.0/page3\">検査オーダーページ</a></p>");
    out.println("<p><a href=\"/logout-1.0/page4\">HorliX Web Viewer</a></p>");

    out.println("</body>");
    out.println("</html>");
  }
}