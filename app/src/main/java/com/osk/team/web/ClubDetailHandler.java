package com.osk.team.web;

import com.osk.team.domain.Board;
import com.osk.team.domain.Club;
import com.osk.team.service.BoardService;
import com.osk.team.service.ClubService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;

@SuppressWarnings("serial")
@WebServlet("/club/detail")
public class ClubDetailHandler extends HttpServlet {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        ClubService clubService = (ClubService) request.getServletContext().getAttribute("clubService");
//
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//
//        int no = Integer.parseInt(request.getParameter("no"));
//
//        out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>클럽 상세</title>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<h1>클럽 상세보기</h1>");
//
//        try {
//            Club c = clubService.get(no);
//            if (c == null) {
//                out.println("<p>해당 번호의 클럽이 없습니다.</p>");
//                return;
//            }
//            out.println("<form action='update' method='post'>");
//            out.println("<table border='1'>");
//            out.println("<tbody>");
//            out.printf("<tr><th>번호</th>"
//                    + " <td><input type='text' name='no' value='%d' readonly></td></tr>\n", c.getCno());
//            out.printf("<tr><th>도착지</th>"
//                    + " <td><input name='title' type='text' value='%s'></td></tr>\n", c.getCarrive());
//            out.printf("<tr><th>가는날</th>"
//                    + " <td><textarea name='content' rows='10' cols='60'>%s</textarea></td></tr>\n", formatter.format(c.getCsdt()));
//            out.printf("<tr><th>오는날</th> <td>%s</td></tr>\n", formatter.format(c.getCedt()));
//            out.printf("<tr><th>제목</th> <td>%s</td></tr>\n", c.getCtitle());
//            out.printf("<tr><th>내용</th> <td>%s</td></tr>\n", c.getCcontent());
//            out.printf("<tr><th>인원수</th> <td>%s</td></tr>\n", c.getCtotal());
//            out.println("</tbody>");
//
//            Member loginUser = (Member) request.getSession().getAttribute("loginUser");
//            if (loginUser != null && b.getWriter().getNo() == loginUser.getNo()) {
//                out.println("<tfoot>");
//                out.println("<tr><td colspan='2'>");
//                out.println("<input type='submit' value='변경'> "
//                        + "<a href='delete?no=" + b.getNo() + "'>삭제</a> ");
//                out.println("</td></tr>");
//                out.println("</tfoot>");
//            }
//
//            out.println("</table>");
//            out.println("</form>");
//
//
//        } catch (Exception e) {
//            StringWriter strWriter = new StringWriter();
//            PrintWriter printWriter = new PrintWriter(strWriter);
//            e.printStackTrace(printWriter);
//            out.printf("<pre>%s</pre>\n", strWriter.toString());
//        }
//        out.println("<p><a href='list'>목록</a></p>");
//
//        out.println("</body>");
//        out.println("</html>");
    }
}