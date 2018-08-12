<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>

<h3>All Events</h3>

	<c:forEach var="e" items="${events}">
		<h4>${e.getEventName()}</h4>
		<a href="${pageContext.request.contextPath}/forAll/buyTicket?eventId=${e.getEventId()}">
		Buy Ticket</a>
	</c:forEach>	
	
	<br><br>
	
</body>

</html>