<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update a Hospital</title>
</head>
<body>
	<h1>Update Hospital</h1>
	<form action="hospitalupdate" method="post">
		<p>
			<label for="hospitalcode">Hospital Code</label>
			<input readonly="readonly" id="hospitalcode" name="hospitalcode" value="${fn:escapeXml(param.hospitalcode)}">
		</p>

		<p>
			<label for="hospitalname">New Hospital Name</label>
			<input id="hospitalname" name="hospitalname" value="${fn:escapeXml(param.hospitalname)}">
		</p>
		<p>
			<label for="zipcode">New Zip Code</label>
			<input id="zipcode" name="zipcode" value="${fn:escapeXml(param.zipcode)}">
		</p>
		<p>
			<input type="submit">
		</p>
	</form>
	<br/><br/>
	<p>
		<span id="successMessage"><b>${messages.success}</b></span>
	</p>
</body>
</html>