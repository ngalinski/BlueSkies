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
<title>BlueSkies | Zip Code Search Result</title>
</head>
<body>
	<div class="container-fluid">
		<h1>Zip Code Search Result: ${fn:escapeXml(param.zipcode)}</h1>

		<h2>
			<c:out value="${location.getLocationName()}" />,
			<c:out value="${location.getStateCode()}" />
		</h2>

		<br />
		<hr />
		<h2>City-Level Data: ${location.getLocationName()}</h2>

		<br />
		<h4>Hospitals</h4>
	
		<c:if test="${empty hospitals}">
		    No hospitals found in zip code ${location.getZipCode()}
		</c:if>
		
		<c:forEach items="${hospitals}" var="hospital">
			<h6><c:out value="${hospital.getHospital().getHospitalName()}" /></h6>
			<c:if test="${not empty hospital.getQuality()}">
				<ul>
					<li>Overall Rating: <c:out value="${hospital.getQuality().getOverallRatingString()}" /></li>
					<li>Mortality: <c:out value="${hospital.getQuality().getMortalityString()}" /></li>
					<li>Safety: <c:out value="${hospital.getQuality().getSafetyString()}" /></li>
					<li>Readmission: <c:out value="${hospital.getQuality().getReadmissionString()}" /></li>
					<li>Patient Experience: <c:out value="${hospital.getQuality().getPatientExperienceString()}" /></li>
					<li>Effectiveness: <c:out value="${hospital.getQuality().getEffectivenessString()}" /></li>
					<li>Timeliness: <c:out value="${hospital.getQuality().getTimelinessString()}" /></li>
					<li>Efficient Use Medical Imaging: <c:out value="${hospital.getQuality().getEfficientUseMedicalImagingString()}" /></li>
				</ul>
			</c:if>
			<c:if test="${empty hospital.getQuality()}">
			<p>No quality data available for this hospital.</p>
			</c:if>
		</c:forEach>
				

		<br />
		<hr />
		<h2>County-Level Data: ${county.getCountyName()} County</h2>

		<br />
		<h4>Air Quality</h4>
		
		<div class="row">
			<div class="col-6">			
				<h6>${county.getCountyName()} County</h6>
				<ul>
					<li>Good days: <c:out value="${airquality.getGoodDays()}" /></li>
					<li>Moderate days: <c:out
							value="${airquality.getModerateDays()}" />
					</li>
					<li>Unhealthy for sensitive population days: <c:out
							value="${airquality.getUnhealthyForSensitiveDays()}" /></li>
					<li>Unhealthy days: <c:out
							value="${airquality.getUnhealthyDays()}" /></li>
					<li>Very unhealthy days: <c:out
							value="${airquality.getVeryUnhealthyDays()}" /></li>
					<li>Hazardous days: <c:out
							value="${airquality.getHazardousDays()}" /></li>
					<li>Total days measured: <c:out
								value="${airquality.getDaysWithAQI()}" /></li>
				</ul>

				<ul>
					<li>Max Air Quality Index: <c:out
							value="${airquality.getMaxAQI()}" /></li>
					<li>Median Air Quality Index: <c:out
							value="${airquality.getMedianAQI()}" /></li>
				</ul>
			</div>
			<div class="col-6">
				<h6>US Averages</h6>
				<ul>
					<li>Good days: <c:out value="${avgairquality.getGoodDays()}" /></li>
					<li>Moderate days: <c:out
							value="${avgairquality.getModerateDays()}" />
					</li>
					<li>Unhealthy for sensitive population days: <c:out
							value="${avgairquality.getUnhealthyForSensitiveDays()}" /></li>
					<li>Unhealthy days: <c:out
							value="${avgairquality.getUnhealthyDays()}" /></li>
					<li>Very unhealthy days: <c:out
							value="${avgairquality.getVeryUnhealthyDays()}" /></li>
					<li>Hazardous days: <c:out
							value="${avgairquality.getHazardousDays()}" /></li>
					<li>Total days measured: <c:out
								value="${avgairquality.getDaysWithAQI()}" /></li>
				</ul>

				<ul>
					<li>Max Air Quality Index: <c:out
							value="${avgairquality.getMaxAQI()}" /></li>
					<li>Median Air Quality Index: <c:out
							value="${avgairquality.getMedianAQI()}" /></li>
				</ul>
			</div>
		</div>

		<br />
		<h4>Socioeconomic</h4>

		<h6>Education</h6>
		<div class="row">
			<div class="col-6">
				<h6>${county.getCountyName()} County</h6>
				<ul>
					<li>Less than high school diploma (%): <c:out
							value="${socioeconomic.getPercentLessThanHSDiploma()}" /></li>
					<li>High school diploma only (%): <c:out
							value="${socioeconomic.getPercentHSDiplomaOnly()}" />
					</li>
					<li>Some college (%): <c:out
							value="${socioeconomic.getPercentSomeCollegeOnly()}" />
					</li>
					<li>Bachelor's degree or more (%): <c:out
							value="${socioeconomic.getPercentBachelorsOrMore()}" />
					</li>
				</ul>
			</div>
			<div class="col-6">
				<h6>US Averages</h6>
				<ul>
					<li>Less than high school diploma (%): <c:out
							value="${avgsocioeconomic.getPercentLessThanHSDiploma()}" /></li>
					<li>High school diploma only (%): <c:out
							value="${avgsocioeconomic.getPercentHSDiplomaOnly()}" />
					</li>
					<li>Some college (%): <c:out
							value="${avgsocioeconomic.getPercentSomeCollegeOnly()}" />
					</li>
					<li>Bachelor's degree or more (%): <c:out
							value="${avgsocioeconomic.getPercentBachelorsOrMore()}" />
					</li>
				</ul>
			</div>
		</div>

		<h6>Economic</h6>
		<div class="row">
			<div class="col-6">
				<h6>${county.getCountyName()} County</h6>
				<ul>
					<li>Unemployment rate: <c:out
							value="${socioeconomic.getUnemploymentRate()}" /></li>
					<li>Percent population at or below poverty level: <c:out
							value="${socioeconomic.getPercentPopulationInPoverty()}" />
					</li>
					<li>Median Household Income: <c:out
							value="${socioeconomic.getMedianHouseholdIncome()}" />
					</li>
				</ul>
			</div>
			<div class="col-6">
				<h6>US Averages</h6>
				<ul>
					<li>Unemployment rate: <c:out
							value="${avgsocioeconomic.getUnemploymentRate()}" /></li>
					<li>Percent population at or below poverty level: <c:out
							value="${avgsocioeconomic.getPercentPopulationInPoverty()}" />
					</li>
					<li>Median Household Income: <c:out
							value="${avgsocioeconomic.getMedianHouseholdIncome()}" />
					</li>
				</ul>
			</div>
		</div>

		<br />
		<h4>Health Care Coverage</h4>

		<div class="row">
			<div class="col-6">
				<h6>${county.getCountyName()} County</h6>
				<ul>
					<li>Insured (%): <c:out
							value="${healthcarecoverage.getPercentInsured()}" /></li>
					<li>Uninsured (%): <c:out
							value="${healthcarecoverage.getPercentUninsured()}" /></li>
				</ul>
			</div>

			<div class="col-6">
				<h6>US Averages</h6>
				<ul>
					<li>Insured (%): <c:out
							value="${avghealthcarecoverage.getPercentInsured()}" /></li>
					<li>Uninsured (%): <c:out
							value="${avghealthcarecoverage.getPercentUninsured()}" /></li>
				</ul>
			</div>
		</div>

		<br />
		<hr />
		<h2>State-Level Data: ${location.getStateCode()}</h2>

		<br />
		<h4>Asthma Health Outcomes (2017)</h4>
		<div class="row">
			<div class="col-6">
				<h6>${location.getStateCode()}</h6>
				<ul>
					<c:forEach items="${asthmaimpactbymetric}" var="metric">
						<li><span class="metric-name"><c:out
									value="${metric.getKey()}" /></span>: <span class="metric-data"><c:out
									value="${metric.getValue().getDataValue()}" /></span></li>
					</c:forEach>
				</ul>
			</div>
			<div class="col-6">
				<h6>US Averages</h6>
				<ul>
					<c:forEach items="${avgasthmaimpactforstate}" var="avgmetric">
						<li><span class="metric-name"><c:out
									value="${avgmetric.getKey()}" /></span>: <span class="metric-data"><fmt:formatNumber
									maxFractionDigits="2"
									value="${avgmetric.getValue().getDataValue()}" /></span></li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<br />
		<h4>Health Care Spending (per capita)</h4>
		<div class="row">
			<div class="col-6">
				<h6>${location.getStateCode()}</h6>
				<ul>
					<li>Total spending: <c:out
							value="${healthcarespending.getTotalSpending()}" /></li>
					<li>Inpatient Services: <c:out
							value="${healthcarespending.getInpatientServices()}" /></li>
					<li>Outpatient Services: <c:out
							value="${healthcarespending.getOutpatientServices()}" /></li>
					<li>Professional Services: <c:out
							value="${healthcarespending.getProfessionalServices()}" /></li>
				</ul>
			</div>
			<div class="col-6">
				<h6>US Averages</h6>
				<ul>
					<li>Total spending: <c:out
							value="${avghealthcarespending.getTotalSpending()}" /></li>
					<li>Inpatient Services: <c:out
							value="${avghealthcarespending.getInpatientServices()}" /></li>
					<li>Outpatient Services: <c:out
							value="${avghealthcarespending.getOutpatientServices()}" /></li>
					<li>Professional Services: <c:out
							value="${avghealthcarespending.getProfessionalServices()}" /></li>
				</ul>
			</div>

		</div>
		<br />
		<h4>Health Care Utilization (per capita)</h4>
		<div class="row">
			<div class="col-6">
				<h6>${location.getStateCode()}</h6>
				<ul>
					<li>Total utilization: <c:out
							value="${healthcareutilization.getTotalUtilization()}" /></li>
					<li>Inpatient Services: <c:out
							value="${healthcareutilization.getInpatientServices()}" /></li>
					<li>Outpatient Services: <c:out
							value="${healthcareutilization.getOutpatientServices()}" /></li>
					<li>Professional Services: <c:out
							value="${healthcareutilization.getProfessionalServices()}" /></li>
				</ul>
			</div>
			<div class="col-6">
				<h6>US Averages</h6>
				<ul>
					<li>Total utilization: <c:out
							value="${avghealthcareutilization.getTotalUtilization()}" /></li>
					<li>Inpatient Services: <c:out
							value="${avghealthcareutilization.getInpatientServices()}" /></li>
					<li>Outpatient Services: <c:out
							value="${avghealthcareutilization.getOutpatientServices()}" /></li>
					<li>Professional Services: <c:out
							value="${avghealthcareutilization.getProfessionalServices()}" /></li>
				</ul>
			</div>
		</div>

		<br />
		<%-- <h4>Drug Utilization (per capita, for common asthma medications)</h4>        
       		<ul>
	       		<c:forEach items="${drugutilization}" var="drug" >
	            <li><c:out value="${drug.getDrugname()}"/>, Number Prescriptions: <c:out value="${drug.getNumrx()}" />, Total Reimbursed: <c:out value="${drug.getTotalreimbursed()}"/></li>
	            </c:forEach>
     		</ul> --%>

		<br /> <a class="btn btn-primary" href="/BlueSkies">Return to zip
			code search</a> <br /> <br />

	</div>


	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>

<!-- 
County > Socioeconomic, air quality, health care coverage
State > Health care spending, asthma impact/outcomes, drug util, healthcare util
Zip > Hospital, hospital quality
 -->