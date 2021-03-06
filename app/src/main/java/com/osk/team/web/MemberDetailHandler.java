package com.osk.team.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.osk.team.domain.Member;
import com.osk.team.service.MemberService;
//import java.text.SimpleDateFormat;

@Controller
public class MemberDetailHandler {

  MemberService memberService;

  public MemberDetailHandler(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/detail")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    Member m = memberService.get(no);
    request.setAttribute("member", m);

    return "/jsp/member/detail.jsp";

  }
}







