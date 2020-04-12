<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
  <%@include file="css/normalize.css" %>
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BlueSkies | Zip Code Search Result</title>
</head>
<body>
	<div class="container-fluid">
			<h1>Zip Code Search Result: ${fn:escapeXml(param.zipcode)}</h1>
			
			<h2><c:out value="${location.getLocationName()}" />, <c:out value="${location.getStateCode()}" /></h2>
			<br/>
			<h3>Hospitals</h3>
			<table border="1">
            <tr>
                <th>Hospital Name</th>
                <th>Overall Rating</th>
                <th>Patient Experience</th>
   
            </tr>
            <c:forEach items="${hospitals}" var="hospital" >
                <tr>
                    <td><c:out value="${hospital.getHospital().getHospitalName()}" /></td>
                    <td><c:out value="${hospital.getQuality().getOverallRating()}" /></td>
                    <td><c:out value="${hospital.getQuality().getPatientExperience()}" /></td>
                </tr>
            </c:forEach>
       		</table>
       		<br/>
       		<h3>Asthma Health Outcomes, 2017</h3>
       		<c:forEach items="${asthmaimpactbymetric}" var="metric" >
       		<div>
       			<p><span class="metric-name"><c:out value="${metric.getKey()}" /></span>: <span class="metric-data"><c:out value="${metric.getValue().getDataValue()}" /></span></p>
       		</div>
       		</c:forEach>
       		
	</div>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>

<!-- 
County > Socioeconomic, air quality, health care coverage
State > Health care spending, asthma impact/outcomes, drug util, healthcare util
Zip > Hospital, hospital quality
 -->