<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Get Counties by Name</title>
</head>
<body>
    <h1>Search for a County by Name</h1>
    <p> <span id="successMessage"><b>${messages.success}</b></span></p>

<h1>Matching Counties</h1>
<table border="1">
    <tr>
        <th>CountyCode</th>
        <th>CountyName</th>
        <th>StateCode</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${counties}" var="county" >
        <tr>
            <td><c:out value="${county.getCountyCode()}" /></td>
            <td><c:out value="${county.getCountyName()}" /></td>
            <td><c:out value="${county.getStateCode()}" /></td>
            <td><a href="countyupdate?countycode=<c:out value="${county.getCountyCode()}"/>">Update</a></td>
            <td><a href="countydelete?countycode=<c:out value="${county.getCountyCode()}"/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>

<div class="row">
	<div class="col">
	<br/><br/>
	 	<form action="getcounty" method="post">
		<p>Search for a county by name:</p>
	        <label for="countyname">County Name</label>
	        <input id="countyname" name="countyname" value="${fn:escapeXml(param.countyname)}">
	       	<input type="submit"> 
	    </form>
	  </div>
  </div>  
  
</body>
</html>
