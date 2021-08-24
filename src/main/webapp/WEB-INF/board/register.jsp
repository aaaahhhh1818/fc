<%--
  Created by IntelliJ IDEA.
  User: 이아현
  Date: 2021-08-19
  Time: 오후 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>Register</h1>

    <form action="/board/register.do" method="post">
        <div>
            제목 : <input type="text" name="title">
        </div>
        <div>
            내용 : <textarea name="content"></textarea>
        </div>
        <div>
            작성자 : <input type="text" name="writer">
        </div>
        <div>
            <button type="submit">등록</button>
        </div>
    </form>

</body>
</html>
