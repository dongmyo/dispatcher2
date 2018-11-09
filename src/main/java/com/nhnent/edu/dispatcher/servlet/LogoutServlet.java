package com.nhnent.edu.dispatcher.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();

        // TODO 4: Front Controller 도입에 따라 공통 부분 제거하고 viewUrl 전달하도록 수정
        // TODO 4: Front Controller導入により、共通部分を削除してviewUrl伝達するように修正
        req.setAttribute("viewUrl", "redirect:/login.do");
//        resp.sendRedirect("/login");
    }

}
