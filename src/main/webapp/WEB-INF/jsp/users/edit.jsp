<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>

<html>
<body>

<form:form modelAtrtibute="user">
Username: ${user.username} <br/>
Password <form:input path ="password"/> <br/>
<input type="submit" name="sava" value="Sava">
</form:form>

</body>
</html>