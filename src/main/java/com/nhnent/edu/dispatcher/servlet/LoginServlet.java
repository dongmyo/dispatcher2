package com.nhnent.edu.dispatcher.servlet;

import com.nhnent.edu.dispatcher.model.Member;
import com.nhnent.edu.dispatcher.repository.MemberRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    /* Login form */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
        rd.forward(req, resp);
    }

    /* Processing login */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");

        ServletContext sc = req.getServletContext();

        MemberRepository memberRepository = (MemberRepository) sc.getAttribute("memberRepository");

        Member member = memberRepository.exists(id, password);
        if (member == null) {
            RequestDispatcher rd = req.getRequestDispatcher("/loginFail.jsp");
            rd.forward(req, resp);
        }
        else {
            HttpSession session = req.getSession();
            session.setAttribute("member", member);

            resp.sendRedirect("/member/list");
        }
    }

}
