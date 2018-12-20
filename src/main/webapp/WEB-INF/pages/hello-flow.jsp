
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello from "hello-flow" !!!


 <form method="post" action="${flowExecutionUrl}">
         <input type="hidden" name="_eventId" value="action"/>
         <input type="submit" value="goNext"/>
 </form>


</body>
</html>
