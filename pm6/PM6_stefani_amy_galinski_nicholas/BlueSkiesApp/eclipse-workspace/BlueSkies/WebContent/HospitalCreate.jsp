<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a Hospital</title>
</head>
<body>
	<h1>Create Hospital</h1>
	<form action="hospitalcreate" method="post">
		<p>
			<label for="hospitalname">Hospital Name</label>
			<input id="hospitalname" name="hospitalname" value="">
		</p>
		<p>
			<label for="zipcode">Zip Code</label>
			<input id="zipcode" name="zipcode" value="">
		</p>
		<p>
			<label for="hospitaltype">Hospital Type</label>
			<select id="hospitaltype" name="hospitaltype">
			  <option value="Acute Care Hospitals">Acute Care Hospitals</option>
			  <option value="Critical Access Hospitals">Critical Access Hospitals</option>
			  <option value="Psychiatric">Psychiatric</option>
			  <option value="Childrens">Childrens</option>
			</select>
		</p>
		<p>
			<label for="emergencyservices">Emergency Services Offered</label>
			<select id="emergencyservices" name="emergencyservices">
			  <option value="1">Yes</option>
			  <option value="0">No</option>
			 </select>
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