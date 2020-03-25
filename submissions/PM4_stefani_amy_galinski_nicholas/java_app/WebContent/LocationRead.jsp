<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Get a Location</title>
</head>
<body>
<form action="getlocation" method="post">
    <h1>Search for a Location by County Code</h1>
    <p>
        <label for="countycode">County Code</label>
        <input id="countycode" name="countycode" value="${fn:escapeXml(param.countycode)}">
    </p>
    <p>
        <input type="submit">
        <br/><br/><br/>
        <span id="successMessage"><b>${messages.success}</b></span>
    </p>
</form>
<h1>Matching Locations</h1>
<table border="1">
    <tr>
        <th>ZipCode</th>
        <th>LocationName</th>
        <th>Population</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${locations}" var="location" >
        <tr>
            <td><c:out value="${location.getZipCode()}" /></td>
            <td><c:out value="${location.getLocationName()}" /></td>
            <td><c:out value="${location.getPopulation()}" /></td>
            <td><a href="locationupdate?countycode=<c:out value="${location.getCountyCode}"/>">Update</a></td>
            <td><a href="locationdelete?zipcode=<c:out value="${location.getZipCode}"/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
