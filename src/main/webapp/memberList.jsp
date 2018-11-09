<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="member" scope="session" class="com.nhnent.edu.dispatcher.model.Member" />

<!doctype html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Member List</title>
</head>
<body>
    <div style="background-color:#00008b;color:#ffffff;height:20px;padding: 5px;">
        <% if (member != null) { %>
        <span style="float:right;">
            <%= member.getId() %>
            <!-- TODO 8: FrontController가 받을 수 있도록 .do로 url 변경 -->
            <!-- TODO 8: FrontControllerが受けられるように.doにurl変更 -->
            <a style="color:white;" href="/logout">Logout</a>
        </span>
        <% } %>
    </div>

    <h1>Member List</h1>

    <c:forEach var="member" items="${members}">
        ${member.id},
        ${member.password}
        <br />
    </c:forEach>
</body>
</html>
