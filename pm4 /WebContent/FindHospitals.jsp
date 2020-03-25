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
	<form action="findhospitals" method="post">
		<h1>Search for a Hospital by Zip Code</h1>
		<p>
			<label for="zipcode">Zip Code</label>
			<input id="zipcode" name="zipcode" value="${fn:escapeXml(param.zipcode)}">
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	<br/>
	<div id="hospitalCreate"><a href=hospitalcreate>Create Hospital</a></div>
	<br/>
	<h1>Matching Hospitals</h1>
        <table border="1">
            <tr>
                <th>HospitalCode</th>
                <th>HospitalName</th>
                <th>ZipCode</th>
                <th>Hospital Quality</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${hospitals}" var="hospital" >
                <tr>
                    <td><c:out value="${hospital.getHospitalCode()}" /></td>
                    <td><c:out value="${hospital.getHospitalName()}" /></td>
                    <td><c:out value="${hospital.getZipCode()}" /></td>
                    <td><a href="findhospitalquality?hospitalcode=<c:out value="${hospital.getHospitalCode()}"/>">Hospital Quality</a></td>
                    <td><a href="hospitalupdate?hospitalcode=<c:out value="${hospital.getHospitalCode()}"/>&hospitalname=<c:out value="${hospital.getHospitalName()}"/>&zipcode=<c:out value="${hospital.getZipCode()}"/>">Update</a></td>
                    <td><a href="hospitaldelete?hospitalcode=<c:out value="${hospital.getHospitalCode()}"/>">Delete</a></td>
                </tr>
            </c:forEach>
       </table>
</body>
</html>
