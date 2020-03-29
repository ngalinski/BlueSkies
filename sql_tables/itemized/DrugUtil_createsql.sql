DROP TABLE IF EXISTS `DrugUtilization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DrugUtilization` (
  `DrugUtilizationCode` int NOT NULL AUTO_INCREMENT,
  `StateCode` varchar(2) NOT NULL,
  `DrugName` varchar(32) DEFAULT NULL,
  `NumReimbursed` varchar(16),
  `NumRx` varchar(16),
  `TotalReimbursed` varchar(16),
  `MedicaidReimbursed` varchar(16),
  `NonMedicaidReimbursed` varchar(16),
  `NDC` long NOT NULL,
  PRIMARY KEY (`DrugUtilizationCode`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;