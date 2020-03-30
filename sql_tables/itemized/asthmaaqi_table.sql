DROP TABLE IF EXISTS `AsthmaAQI`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `AsthmaAQI` (
  `AsthmaAQICode` int NOT NULL AUTO_INCREMENT,
  `StateCode` varchar(2) NOT NULL,
  `UnitsReimbursed` int DEFAULT NULL,
  `GoodDaysCount` int DEFAULT NULL,
  `NumRX` int DEFAULT NULL,
  `TotalReimbursed` int DEFAULT NULL,
  `ModerateDaysCount` int DEFAULT NULL,
  `HazardousDays` int DEFAULT NULL,
  PRIMARY KEY (`AsthmaAQICode`)
) ENGINE=InnoDB AUTO_INCREMENT=1801 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;