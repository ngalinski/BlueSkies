<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
<%@ include file ="css/normalize.css" %>
</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BlueSkies | Data Administration</title>
</head>
<body>
	<div class="container-fluid">
			<h1>BlueSkies Data Administration</h1>
			<br/>
			<div class="row">
				<div class="col">
			
				<h2>Hospital Data</h2>
				<br/>
			</div>
			</div>		
			<div class="row">
				<div class="col-lg-5 col-md-6 col mb-3">
					<h3>Create Hospital</h3>
				
					<form action="hospitalcreate" method="post">
						<div class="form-group">
							<input class="form-control" required placeholder="Hospital Name" id="hospitalname" name="hospitalname" value="">
						</div>
						<div class="form-group">
							<input class="form-control" required placeholder="Zip Code" id="zipcode" name="zipcode" value="">
						</div>
						<div class="form-group">
							<label for="hospitaltype">Hospital Type</label>
							<select class="form-control"  id="hospitaltype" name="hospitaltype">
							  <option value="Acute Care Hospitals">Acute Care Hospitals</option>
							  <option value="Critical Access Hospitals">Critical Access Hospitals</option>
							  <option value="Psychiatric">Psychiatric</option>
							  <option value="Childrens">Childrens</option>
							</select>
						</div>
						
						<div class="form-group">
							<label for="emergencyservices">Emergency Services Offered</label>
							<select class="form-control"  id="emergencyservices" name="emergencyservices">
							  <option value="1">Yes</option>
							  <option value="0">No</option>
							 </select>
						</div>
						<button type="submit" type="submit" class="btn btn-primary">Submit</button>

					</form>
					
				</div>
				
				<div class="col-lg-5 col-md-6 col mb-3">
					<h3>Find Hospitals By Zip Code</h3>
					<form action="findhospitals" method="post" >
						<div class="form-group">
							<input required placeholder="Zip Code" id="zipcode" name="zipcode" class="form-control"  value="${fn:escapeXml(param.zipcode)}">
						</div>
						<button type="submit" type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>

			</div>
			
			<br />
			<hr />
			<br />
			
			<div class="row">
				<div class="col">
			
				<h2>Geographic Data</h2>
				<br/>
			</div>
			</div>		
			<div class="row">
				<div class="col-lg-5 col-md-6 col mb-3">
					<h3>Create Location</h3>
				
					<form action="countycreate" method="post">
					   <div class="form-group">
	        				<input required placeholder="Zip Code" class="form-control" id="zipcode" name="zipcode" value="">
					   </div>
					    <div class="form-group">
	        				<input required placeholder="City or Town Name" class="form-control" id="locationname" name="locationname" value="">
					   </div>
					   <div class="form-group">
	        				<input required  placeholder="2-Digit State Abbreviation" class="form-control" id="statecode" name="statecode" value="">
					   </div>
					   <div class="form-group">
	        				<input placeholder="Population Count (Optional)" class="form-control" id="population" name="population" value="">
					   </div>
					  <div class="form-group">
	        				<input required placeholder="County Code" class="form-control" id="countycode" name="countycode" value="">
					   </div>
					   <button type="submit" type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
				
				<div class="col-lg-5 col-md-6 col mb-3">
					<h3>Create County</h3>
					<form action="countycreate" method="post" >
					   <div class="form-group">
					        <input required class="form-control" placeholder="County Name" id="countyname" name="countyname" value="">
					   </div>
					    <div class="form-group">
					        <input required placeholder="2-Digit State Abbreviation" class="form-control" id="statecode" name="statecode" value="">
					   </div>
					   <button type="submit" type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>

			</div>
			
			<br />
			<hr />
			<br />
			
			<div class="row">			
				<div class="col-lg-5 col-md-6 col mb-3">
					<h3>Find Location</h3>
					<form action="getlocation" method="post">
					   <div class="form-group">
					        <input required placeholder="Zip Code" class="form-control" id="zipcode" name="zipcode" value="">
					   </div> 
					   <button type="submit" type="submit" class="btn btn-primary">Submit</button>
					</form>
				
				</div>
				
				<div class="col-lg-5 col-md-6 col mb-3">
				
				<h3>Find County</h3>
					<form action="getcounty" method="post" >
					   <div class="form-group">
					        <input required placeholder="County Name" class="form-control" id="countyname" name="countyname" value="">
					   </div> 
					   <button type="submit" type="submit" class="btn btn-primary">Submit</button>
					</form>				
				</div>			
		</div>
</div>
	
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>