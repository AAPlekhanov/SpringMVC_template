<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring security</title>
</head>
<body>
test Spring security
<br/>
<a href="/logout">
  Logout
</a>

<br/>
<br/>

Hello <security:authentication property="principal.username"/>

<br/>
<br/>

<security:authorize access="hasRole('user')">
    info for user
</security:authorize>


<security:authorize access="hasRole('admin')">
    info for admin
</security:authorize>
</body>
</html>
