<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Update County</title>
</head>
<body>
<h1>Update County Name</h1>
<form action="countyupdate" method="post">
    <p>
        <label for="countycode">County Code</label>
        <input id="countycode" name="countycode" value="${fn:escapeXml(param.countycode)}" />
    </p>
    <p>
        <label for="countyname2">New County Name</label>
        <input id="countyname2" name="countyname2" value="${fn:escapeXml(param.countyname2)}" />
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