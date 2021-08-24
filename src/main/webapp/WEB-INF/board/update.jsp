<%--
  Created by IntelliJ IDEA.
  User: ahyun
  Date: 2021-08-22
  Time: 오후 2:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Update</h1>

<form action="/board/update.do" method="post">
    <input type="hidden" name="bno" value="${bno}">
    <div>
        제목 : <input type="text" name="title">
    </div>
    <div>
        내용 : <textarea name="content"></textarea>
    </div>
    <div>
        <button type="submit">등록</button>
    </div>
</form>

</body>
</html>
