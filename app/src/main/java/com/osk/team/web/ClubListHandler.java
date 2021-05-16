package com.osk.team.web;


import com.osk.team.domain.Club;
import com.osk.team.service.ClubService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

@SuppressWarnings("serial")
@WebServlet("/club/list")
public class ClubListHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ClubService clubService = (ClubService) request.getServletContext().getAttribute("clubService");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Club List</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Club List</h1>");

        out.print("<p><a href='detailSearch'>참여</a></p>");
        out.print("<p><a href='club.html'>생성</a></p>");

        try {

            List<Club> clubs = null;

            String arrive = request.getParameter("arrive");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            String theme = request.getParameter("theme");

            out.println("<form method='get'>");
            out.println("<fieldset>");
            out.println("  <legend>클럽 상세 검색</legend>");
            out.println("  <table border='1'>");
            out.println("  <tbody>");

            out.printf("  <tr> <th>도착지</th>"
                            + " <td><input type='search' name='arrive' value='%s'></td> </tr>\n",
                    arrive != null ? arrive : "");

            out.printf("  <tr> <th>가는날</th>"
                            + " <td><input type='date' name='startDate' value='%s'></td> </tr>\n",
                    startDate != null ? startDate : "");

            out.printf("  <tr> <th>오는날</th>"
                            + " <td><input type='date' name='endDate' value='%s'></td> </tr>\n",
                    endDate != null ? endDate : "");

            out.printf("  <tr> <th>테마</th>"
                            + " <td><input type='search' name='theme' value='%s'></td> </tr>\n",
                    theme != null ? theme : "");

            out.println("  <tr> <td colspan='2'><button>검색</button></td> </tr>");
            out.println("  </tbody>");
            out.println("  </table>");
            out.println("</fieldset>");
            out.println("</form>");

            if ((arrive != null && arrive.length() > 0) ||
                    (startDate != null && startDate.length() > 0) ||
                    (endDate != null && endDate.length() > 0) ||
                    (theme != null && theme.length() > 0)) {
                clubs = clubService.search(arrive, startDate, endDate, theme);
            } else {
                clubs = clubService.list();
            }

            out.println("<table border='1'>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>번호</th> <th>도착지</th> <th>가는날</th> <th>오는날</th> <th>테마</th> <th>인원수</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            for (Club c : clubs) {
                out.printf("<tr>"
                                + " <td><a href='detail?no=%1$d'>%d</a></td>"
                                + " <td>%s</td>"
                                + " <td>%s</td>"
                                + " <td>%s</td>"
                                + " <td>%s</td>"
                                + " <td>%d</td> </tr>\n",
                        c.getNo(),
                        c.getArrive(),
                        c.getStartDate(),
                        c.getEndDate(),
                        c.getTheme(),
                        c.getTotal());
            }
            out.println("</tbody>");
            out.println("</table>");

            out.println("<form action='search' method='get'>");
            out.println("<input type='text' name='keyword'> ");
            out.println("<button>검색</button>");
            out.println("</form>");

        } catch (Exception e) {
            throw new ServletException(e);
        }

        out.println("</body>");
        out.println("</html>");
    }

}
