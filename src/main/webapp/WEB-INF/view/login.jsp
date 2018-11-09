<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Login</title>
</head>
<body>
    <h2>Member Login</h2>

    <form method="post" action="/login">
        ID : <input type="text" name="id" /><br />
        PW : <input type="password" name="password" /><br />

        <input type="submit" value="Login" />
    </form>
</body>
</html>
