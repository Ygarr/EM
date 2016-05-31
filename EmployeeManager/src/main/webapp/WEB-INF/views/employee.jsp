<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<title><spring:message code="label.title" /></title>
</head>
<body>

<a href="<c:url value="/logout" />">
	<spring:message code="label.logout" />
</a>
  
<h2><spring:message code="label.title" /></h2>

<form:form method="post" action="add" commandName="employee">

	<table>
		<tr>
			<td><form:label path="firstname">
				<spring:message code="label.firstname" />
			</form:label></td>
			<td><form:input path="firstname" /></td>
		</tr>
		<tr>
			<td><form:label path="lastname">
				<spring:message code="label.lastname" />
			</form:label></td>
			<td><form:input path="lastname" /></td>
		</tr>
		<tr>
			<td><form:label path="salary">
				<spring:message code="label.salary" />
			</form:label></td>
			<td><form:input path="salary" /></td>
		</tr>
		<tr>
			<td><form:label path="birthday">
				<spring:message code="label.birthday" />
			</form:label></td>
			<td><form:input path="birthday" /></td>
		</tr>
		<tr>
			<td><form:label path="active">
				<spring:message code="label.active" />
			</form:label></td>
			
			<td><form:input path="active" /></td>
		</tr>
		<tr>
			<td><form:label path="division">
				<spring:message code="label.division" />
			</form:label></td>
			<td><form:input path="division" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"
				value="<spring:message code="label.addemployee"/>" /></td>
		</tr>
	</table>
</form:form>

<h3><spring:message code="label.employees" /></h3>

<c:if test="${!empty employeeList}">
	<table class="data">
		<tr>
			<th><spring:message code="label.id" /></th>
			<th><spring:message code="label.firstname" /></th>
			<th><spring:message code="label.birthday" /></th>
			<th><spring:message code="label.salary" /></th>
			<th><spring:message code="label.active" /></th>
			<th><spring:message code="label.division" /></th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${employeeList}" var="employee">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.lastname}, ${employee.firstname}</td>
				<td>${employee.birthday}</td>
				<td>${employee.salary}</td>
				<td>${employee.active}</td>
				<td>${employee.division}</td>
				<td><a href="delete/${employee.id}"><spring:message code="label.delete" /></a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>


</body>
</html>