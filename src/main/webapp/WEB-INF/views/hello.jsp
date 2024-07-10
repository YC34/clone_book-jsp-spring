<%--
  Created by IntelliJ IDEA.
  User: y_chan
  Date: 7/3/24
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
    <h2>Hello World</h2>
    <hr>
    현재 날짜와 시간은 <%= java.time.LocalDateTime.now()%>
    <hr>
    메시지 : ${msg}
</body>
</html>
