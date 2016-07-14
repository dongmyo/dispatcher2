package com.nhnent.edu.dispatcher.servlet;

import com.nhnent.edu.dispatcher.model.Member;
import com.nhnent.edu.dispatcher.repository.MemberRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = req.getServletContext();
        MemberRepository memberRepository = (MemberRepository) sc.getAttribute("memberRepository");

        List<Member> members = memberRepository.list();
        req.setAttribute("members", members);

        resp.setContentType("text/html; charset=UTF-8");

        RequestDispatcher rd = req.getRequestDispatcher("/memberList.jsp");
        rd.forward(req, resp);
    }

}
