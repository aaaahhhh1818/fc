<%--
  Created by IntelliJ IDEA.
  User: 이아현
  Date: 2021-08-19
  Time: 오전 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Read</h1>

<form action="/board/delete.do" method="post">
    <div>
        번호 : <input type="text" name="bno" value="${boardDTO.bno}" readonly>
    </div>
    <div>
        제목 : <input type="text" name="title" value="${boardDTO.title}" readonly>
    </div>
    <div>
        내용 : <input type="text" name="content" value="${boardDTO.content}" readonly>
    </div>
    <div>
        작성자 : <input type="text" name="writer" value="${boardDTO.writer}" readonly>
    </div>
    <div>
        작성일 : <input type="text" name="regdate" value="${boardDTO.regdate}" readonly>
    </div>
    <div>
        수정일 : <input type="text" name="updatedate" value="${boardDTO.updatedate}" readonly>
    </div>
    <div>
        <button type="submit">삭제하기</button>
    </div>
</form>
<a href="/board/update.do?bno=${boardDTO.bno}">수정하기</a>
<a href="/board/list.do?page=${pageDTO.page}&size=${pageDTO.size}">목록가기</a>
</body>
</html>
