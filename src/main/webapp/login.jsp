<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Login</title>
</head>
<body>
    <h2>Member Login</h2>

    <!-- TODO 6: FrontController가 받을 수 있도록 .do로 url 변경 -->
    <!-- TODO 6: FrontControllerが受けられるように.doにurl変更 -->
    <form action="login" method="post">
        ID : <input type="text" name="id" /><br />
        PW : <input type="password" name="password" /><br />

        <input type="submit" value="Login" />
    </form>
</body>
</html>
