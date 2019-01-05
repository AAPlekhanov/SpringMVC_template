<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   Hello jsp page  <br/>
   ${message}
   ${string}

   <br/>
   <br/>

   <security:authorize access="isAuthenticated()">
       info for authenticated users
   </security:authorize>


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
