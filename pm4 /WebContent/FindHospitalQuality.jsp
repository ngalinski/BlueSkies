<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find a Hospital</title>
</head>
<body>
	<form action="findhospitalquality" method="post">
		<h1>Get Hospital Quality For Hospital Code</h1>
		<p>
			<label for="hospitalcode">Hospital Code</label>
			<input id="hospitalcode" name="hospitalcode" value="${fn:escapeXml(param.hospitalcode)}">
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	<br/>
	<h1>Hospital Quality</h1>
	<p>Below national average = -1<br/>
	Equal to national average = 0<br/>
	Above national average = 1</p>
	
        <table border="1">
            <tr>
                <th>Hospital Code</th>
                <th>Overall Rating</th>
                <th>Mortality</th>
                <th>Safety</th>
                <th>Readmission</th>
                <th>Patient Experience</th>
                <th>Effectiveness</th>
                <th>Timeliness</th>
                <th>Efficient Use of Medical Imaging</th>
            </tr>
                <tr>
                    <td><c:out value="${hospitalQuality.getHospitalCode()}" /></td>
                    <td><c:out value="${hospitalQuality.getOverallRating()}" /></td>
                    <td><c:out value="${hospitalQuality.getMortality()}" /></td>
                    <td><c:out value="${hospitalQuality.getSafety()}" /></td>
                    <td><c:out value="${hospitalQuality.getReadmission()}" /></td>
                    <td><c:out value="${hospitalQuality.getPatientExperience()}" /></td>
                    <td><c:out value="${hospitalQuality.getEffectiveness()}" /></td>
                    <td><c:out value="${hospitalQuality.getTimeliness()}" /></td>
                    <td><c:out value="${hospitalQuality.getEfficientUseMedicalImaging()}" /></td>
                </tr>
       </table>
      <p><a href="hospitalqualityupdate?hospitalcode=<c:out value="${hospitalQuality.getHospitalCode()}"/>">Update</a> | <a href="hospitalqualitydelete?hospitalqualitycode=<c:out value="${hospitalQuality.getHospitalQualityCode()}"/>">Delete</a></p>
      
      <div id="hospitalQualityCreate"><a href="hospitalqualitycreate">Create Hospital Quality Record</a></div>
      
</body>
</html>
