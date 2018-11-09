<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8" />
    <title><fmt:message key="login" /></title>
</head>
<body>
    <%-- TODO: #1. Set language using 'lang' request parameter --%>
    <div style="background-color:#00008b;color:#ffffff;height:20px;padding: 5px;">
        <span style="float:right;">
            <a style="color:white;" href="?lang=ja">日本</a> | <a style="color:white;" href="?lang=ko">한글</a> | <a style="color:white;" href="?lang=en">English</a>
        </span>
    </div>

    <h2><spring:message code="login_title" /></h2>

    <form method="post" action="/login">
        <spring:message code="id" />  : <input type="text" name="id" /><br />
        <spring:message code="password" /> : <input type="password" name="password" /><br />

        <input type="submit" value="<spring:message code="login_title" />" />
    </form>
</body>
</html>
