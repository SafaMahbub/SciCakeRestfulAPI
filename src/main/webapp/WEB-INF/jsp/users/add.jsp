<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>

<html>
<body>

<form:form modelAtrtibute="user">
Username: <form:input path ="username"/> <br/>
Password <form:input path ="password"/> <br/>
<input type="submit" name="add" value="Add">
</form:form>

</body>
</html>