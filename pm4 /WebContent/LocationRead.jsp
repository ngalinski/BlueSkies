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
    <h1>Search for a Location by Zip Code</h1>
    
     <p><span id="successMessage"><b>${messages.success}</b></span></p>
    
	<table border="1">
	    <tr>
	        <th>ZipCode</th>
	        <th>LocationName</th>
	        <th>Population</th>
	        <th>Update</th>
	        <th>Delete</th>
	    </tr>
	        <tr>
	            <td><c:out value="${location.getZipCode()}" /></td>
	            <td><c:out value="${location.getLocationName()}" /></td>
	            <td><c:out value="${location.getPopulation()}" /></td>
	            <td><a href="locationupdate?zipcode=<c:out value="${location.getZipCode()}"/>">Update</a></td>
	            <td><a href="locationdelete?zipcode=<c:out value="${location.getZipCode()}"/>">Delete</a></td>
	        </tr>
	</table>
	
	<div class="row">
		<div class="col">
		<br/><br/>
	
		<form action="getlocation" method="post">
		    <h1>Search for a Location by Zip Code</h1>
		        <label for="zipcode">Zip Code</label>
		        <input id="zipcode" name="zipcode" value="${fn:escapeXml(param.zipcode)}">
		        <input type="submit">
		</form>
	  </div>
  </div>  
  
</body>
</html>
