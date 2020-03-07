<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.03.2020
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>User name: ${requestScope.user.name}</p>
<p>User second name: ${requestScope.user.secondName}</p>
<p>User surname: ${requestScope.user.surname}</p>
<p>User birthday: ${requestScope.user.birthday}</p>
<p>User address: ${requestScope.user.address}</p>
<p>User telephone: ${requestScope.user.telephone}</p>
<p>User sex: ${requestScope.user.sex}</p>
<p>User passportNumber: ${requestScope.user.passportNumber}</p>
<p>User email: ${requestScope.user.email}</p>
<p>User password: ${requestScope.user.password}</p>
<p>User login: ${requestScope.user.login}</p>

</body>
</html>
