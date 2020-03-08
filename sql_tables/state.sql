CREATE DATABASE  IF NOT EXISTS `BlueSkiesUML` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `BlueSkiesUML`;
-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: localhost    Database: BlueSkiesUML
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `State`
--

DROP TABLE IF EXISTS `State`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `State` (
  `StateCode` varchar(2) NOT NULL,
  `StateName` varchar(255) NOT NULL,
  `Region` enum('N','W','S','E') DEFAULT NULL,
  PRIMARY KEY (`StateCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `State`
--

LOCK TABLES `State` WRITE;
/*!40000 ALTER TABLE `State` DISABLE KEYS */;
INSERT INTO `State` VALUES ('AK','Alaska',NULL),('AL','Alabama',NULL),('AR','Arkansas',NULL),('AZ','Arizona',NULL),('CA','California',NULL),('CO','Colorado',NULL),('CT','Connecticut',NULL),('DC','District of Columbia',NULL),('DE','Delaware',NULL),('FL','Florida',NULL),('GA','Georgia',NULL),('HI','Hawaii',NULL),('IA','Iowa',NULL),('ID','Idaho',NULL),('IL','Illinois',NULL),('IN','Indiana',NULL),('KS','Kansas',NULL),('KY','Kentucky',NULL),('LA','Louisiana',NULL),('MA','Massachusetts',NULL),('MD','Maryland',NULL),('ME','Maine',NULL),('MI','Michigan',NULL),('MN','Minnesota',NULL),('MO','Missouri',NULL),('MS','Mississippi',NULL),('MT','Montana',NULL),('NC','North Carolina',NULL),('ND','North Dakota',NULL),('NE','Nebraska',NULL),('NH','New Hampshire',NULL),('NJ','New Jersey',NULL),('NM','New Mexico',NULL),('NV','Nevada',NULL),('NY','New York',NULL),('OH','Ohio',NULL),('OK','Oklahoma',NULL),('OR','Oregon',NULL),('PA','Pennsylvania',NULL),('PR','Puerto Rico',NULL),('RI','Rhode Island',NULL),('SC','South Carolina',NULL),('SD','South Dakota',NULL),('TN','Tennessee',NULL),('TX','Texas',NULL),('UT','Utah',NULL),('VA','Virginia',NULL),('VT','Vermont',NULL),('WA','Washington',NULL),('WI','Wisconsin',NULL),('WV','West Virginia',NULL),('WY','Wyoming',NULL);
/*!40000 ALTER TABLE `State` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-07 20:17:15
