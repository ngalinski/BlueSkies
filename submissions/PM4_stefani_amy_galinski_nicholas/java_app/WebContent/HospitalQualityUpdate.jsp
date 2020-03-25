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
	<form action="hospitalqualityupdate" method="post">
		<p>
			<label for="hospitalcode">Hospital Code</label>
			<input readonly="readonly" id="hospitalcode" name="hospitalcode" value="${fn:escapeXml(param.hospitalcode)}">
		</p>

		<p>
			<label for="newoverallrating">New Overall Rating (-1 for below national average, 0 for equal to national average, 1 for above national average) Code</label>
			<input id="newoverallrating" name="newoverallrating" value="">
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