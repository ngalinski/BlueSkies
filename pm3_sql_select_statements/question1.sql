-- 1. What are the top 10 states with the highest health care costs relative to health care utilization per 1000 people? 
 SELECT BlueSkiesUML.HealthCareSpending.StateCode, 
	BlueSkiesUML.HealthCareSpending.TotalSpending, 
	BlueSkiesUML.HealthCareUtilization.TotalUtilization, 
  BlueSkiesUML.HealthCareSpending.TotalSpending / BlueSkiesUML.HealthCareUtilization.TotalUtilization as Ratio
		FROM BlueSkiesUML.HealthCareSpending
		LEFT JOIN BlueSkiesUML.HealthCareUtilization 
	  ON BlueSkiesUML.HealthCareSpending.StateCode = BlueSkiesUML.HealthCareUtilization.StateCode
		ORDER BY Ratio DESC
	  LIMIT 10;