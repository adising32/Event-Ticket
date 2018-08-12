<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>

<h3>Welcome home!!</h3>

	<a href="${pageContext.request.contextPath}/user/createNewEvent">Create New Event</a>
	
	<br><br>
	<c:forEach var="e" items="${events}">
		<h4>${e.getEventName()}</h4>
	</c:forEach>	
	
	<br><br>
	<form:form action="${pageContext.request.contextPath}/logout">
		<input type="submit" value="Logout">
	</form:form>
</body>

</html>