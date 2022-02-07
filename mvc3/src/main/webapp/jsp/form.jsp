<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/quick13"  method="post">
        <!-- 表明是第几个user对象的name-->
        <input type="text" name="userList[0].name"><br/>
        <input type="text" name="userList[0].age"><br/>

        <input type="text" name="userList[1].name"><br/>
        <input type="text" name="userList[1].age"><br/>

        <input type="submit" value="提交"><br/>
    </form>
</body>
</html>