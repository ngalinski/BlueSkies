/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `DrugUtilization`
--

DROP TABLE IF EXISTS `DrugUtilization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;

CREATE TABLE `DrugUtilization` (
  `DrugUtilizationCode` int NOT NULL AUTO_INCREMENT,
  `StateCode` varchar(2) NOT NULL,
  `DrugName` varchar(255) NOT NULL,
  `NumReimbursed` decimal(15,2) NOT NULL,
  `NumRX` int NOT NULL,
  `TotalReimbursed` decimal(15,2) NOT NULL,
  `MedicaidReimbursed` decimal(15,2) NOT NULL,
  `NonMedicaidReimbursed` decimal(15,2) NOT NULL,
  `DrugCode` varchar(20) NOT NULL,
  PRIMARY KEY (`DrugUtilizationCode`),
  KEY `fk_DrugUtilizationDrugCode` (`DrugCode`),
  CONSTRAINT `fk_DrugUtilizationDrugCode` FOREIGN KEY (`DrugCode`) REFERENCES `Drug` (`DrugCode`),
  KEY `fk_DrugUtilization_StateCode` (`StateCode`),
  CONSTRAINT `fk_DrugUtilization_StateCode` FOREIGN KEY (`StateCode`) REFERENCES `State` (`StateCode`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

