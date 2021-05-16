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

@SuppressWarnings("serial")
@WebServlet("/club/delete")
public class ClubDeleteHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ClubService clubService = (ClubService) request.getServletContext().getAttribute("clubService");

        try {
            int no = Integer.parseInt(request.getParameter("no").trim());

            Club oldClub = clubService.get(no);
            if (oldClub == null) {
                throw new Exception("해당 번호의 클럽이 없습니다.");
            }

            Club loginUser = (Club) request.getSession().getAttribute("loginUser");//회원번호로 받기
            if (oldClub.getWriter().getNo() != loginUser.getNo()) {
                throw new Exception("삭제 권한이 없습니다!");
            }

            clubService.delete(no);

            response.sendRedirect("list");

        } catch (Exception e) {
            request.setAttribute("exception", e);
            request.getRequestDispatcher("/error").forward(request, response);
            return;
        }
    }
}
