DROP TABLE IF EXISTS `Drug`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Drug` (
  `DrugID` int NOT NULL UNIQUE,
  `PharmaCompanyName` varchar(255) NOT NULL,
  `DrugName` varchar(255) NOT NULL,
  `Strength` varchar(255),
  `Route` varchar(255),
  `Unit` varchar(255),
  PRIMARY KEY (`DrugID`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;