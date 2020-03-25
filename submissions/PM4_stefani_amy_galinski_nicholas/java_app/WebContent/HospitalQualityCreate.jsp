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
	<form action="hospitalqualitycreate" method="post">
		<p>
			<label for="hospitalcode">Hospital Code</label>
			<input id="hospitalcode" name="hospitalcode" value="">
		</p>
		<p>
			<label for="overallrating">Overall Rating</label>
			<input id="overallrating" name="overallrating" value="">
		</p>
		<p>
			<label for="mortality">Mortality</label>
			<input id="mortality" name="mortality" value="">
		</p>
		<p>
			<label for="safety">Safety</label>
			<input id="safety" name="safety" value="">
		</p>
		<p>
			<label for="readmission">Readmission</label>
			<input id="readmission" name="readmission" value="">
		</p>
		<p>
			<label for="patientexperience">Patient Experience</label>
			<input id="patientexperience" name="patientexperience" value="">
		</p>
		<p>
			<label for="effectiveness">Effectiveness</label>
			<input id="effectiveness" name="effectiveness" value="">
		</p>
		<p>
			<label for="timeliness">Timeliness</label>
			<input id="timeliness" name="timeliness" value="">
		</p>
		<p>
			<label for="medicalimaging">Efficient Use Medical Imaging</label>
			<input id="medicalimaging" name="medicalimaging" value="">
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