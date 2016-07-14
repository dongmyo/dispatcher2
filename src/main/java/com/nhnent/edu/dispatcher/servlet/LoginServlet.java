package com.nhnent.edu.dispatcher.servlet;

import com.nhnent.edu.dispatcher.model.Member;
import com.nhnent.edu.dispatcher.repository.MemberRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// TODO: Front Controller 도입에 따라 공통 부분 제거하고 viewUrl 전달하도록 수정
public class LoginServlet extends HttpServlet {
    /* 로그인 폼 */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("viewUrl", "/login.jsp");
//        RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
//        rd.forward(req, resp);
    }

    /* 로그인 처리 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");

        ServletContext sc = req.getServletContext();

        MemberRepository memberRepository = (MemberRepository) sc.getAttribute("memberRepository");

        Member member = memberRepository.exists(id, password);
        if (member == null) {
            req.setAttribute("viewUrl", "/loginFail.jsp");
//            RequestDispatcher rd = req.getRequestDispatcher("/loginFail.jsp");
//            rd.forward(req, resp);
        }
        else {
            HttpSession session = req.getSession();
            session.setAttribute("member", member);

            req.setAttribute("viewUrl", "redirect:/member/list.do");
//            resp.sendRedirect("/member/list");
        }
    }

}
