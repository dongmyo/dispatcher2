package com.nhnent.edu.dispatcher.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// TODO 2: FrontController 코드 확인
// TODO 2: FrontControllerコード確認
public class FrontControllerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* content type */
        resp.setContentType("text/html; charset=UTF-8");

        String servletPath = req.getServletPath();

        String pageControllerPath = null;
        // Login. ログイン
        if ("/login.do".equals(servletPath)) {
            pageControllerPath = "/login";
        }
        // Logout. ログアウト
        else if ("/logout.do".equals(servletPath)) {
            pageControllerPath = "/logout";
        }
        // Member list. 会員リスト
        else if ("/member/list.do".equals(servletPath)) {
            pageControllerPath = "/member/list";
        }
        else {
        	throw new IllegalArgumentException("servletPath is invalid : " + servletPath);
        }

        /* Delegate to PageController. PageControllerに委任 */
        RequestDispatcher rd = req.getRequestDispatcher(pageControllerPath);
        rd.include(req, resp);

        /* Delegate to ViewPage. ViewPageに委任 */
        String viewUrl = (String) req.getAttribute("viewUrl");
        if (viewUrl.startsWith("redirect:")) {
            resp.sendRedirect(viewUrl.substring(9));
        }
        else {
            rd = req.getRequestDispatcher(viewUrl);
            rd.include(req, resp);
        }
    }

}
