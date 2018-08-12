<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>New Event</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/user/saveEvent" modelAttribute="event" method="POST">
			<table>
				<tbody>
					<tr>
						<td><label>Event Name:</label></td>
						<td><form:input path="eventName" /></td>
					</tr>
				
					<tr>
						<td><label>Unique Event Id:</label></td>
						<td><form:input path="eventId" /></td>
					</tr>
					
					<tr>
						<td><label>No. of tickets to publish:</label></td>
						<td><form:input path="ticketsRemaining" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
</body>
</html>