<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Create Location</title>
</head>
<body>
<h1>Create Hospital</h1>
<form action="locationcreate" method="post">
    <p>
        <label for="zipcode">ZipCode</label>
        <input id="zipcode" name="zipcode" value="">
    </p>
    <p>
        <label for="locationname">LocationName</label>
        <input id="locationname" name="locationname" value="">
    </p>
    <p>
        <label for="statecode">StateCode</label>
        <input id="statecode" name="statecode" value="">
    </p>
    <p>
        <label for="population">Population</label>
        <input id="population" name="population" value="">
    </p>
    <p>
        <label for="countycode">CountyCode</label>
        <input id="countycode" name="countycode" value="">
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