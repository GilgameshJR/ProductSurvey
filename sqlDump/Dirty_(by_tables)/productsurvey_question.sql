-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: 192.168.178.32    Database: productsurvey
-- ------------------------------------------------------
-- Server version	8.0.24

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
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `QUESTION` varchar(255) NOT NULL,
  `QUESTIONNAIRE_ID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_QUESTION_QUESTIONNAIRE_ID` (`QUESTIONNAIRE_ID`),
  CONSTRAINT `FK_QUESTION_QUESTIONNAIRE_ID` FOREIGN KEY (`QUESTIONNAIRE_ID`) REFERENCES `questionnaire` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (19,'Difficult to use?',15),(20,'Ipsum?',15),(21,'Dolor?',15),(22,'Lorem?',15),(23,'Do you like it?',15),(24,'incididunt ut labore?',16),(25,' sed do eiusmod tempor?',16),(26,'Sit amet?',16),(27,'Do you like it?',16),(28,'Tell us something about build quality',16),(29,'consectetur adipiscing elit?',16),(30,'Dolore magna aliqua?',17),(31,'Is the coffee good?',17),(32,'Minim veniam?',17),(33,'Esse cillum dolore eu fugiat nulla pariatur?',18),(34,'Reprehenderit in voluptate velit?',18),(35,'Duis aute irure dolor?',18),(36,'quis nostrud exercitation?',18),(37,'Excepteur sint occaeca?',18),(38,'ullamco laboris nisi?',18),(39,'aliquip ex ea commodo?',18),(40,'Are you happy?',19),(41,'Is it sunny outside?',19),(42,'Question1',19),(43,'Do you like pizza?',20),(44,'Question number one',20),(45,'Are you happy with this product?',20),(46,'Quest one question for today',21),(47,'Mountain or sea?',22),(48,'Pizza or pasta?',22),(49,'Is it beautiful?',23),(50,'Is it pleasant to use?',23),(51,'Is it small?',23),(52,'How fast is it?',23),(53,'Is coffee good?',23),(54,'Difficult to use?',24),(55,'Ipsum?',24),(56,'Dolor?',24),(57,'Lorem?',24),(58,'Do you like it?',24),(59,'incididunt ut labore?',25),(60,' sed do eiusmod tempor?',25),(61,'Sit amet?',25),(62,'Do you like it?',26),(63,'Tell us something about build quality',26),(64,'consectetur adipiscing elit?',27),(65,'Minim veniam?',28),(66,'Esse cillum dolore eu fugiat nulla pariatur?',28),(67,'Reprehenderit in voluptate velit?',29),(68,'Duis aute irure dolor?',29),(69,'quis nostrud exercitation?',29),(70,'Excepteur sint occaeca?',29),(71,'ullamco laboris nisi?',29),(72,'aliquip ex ea commodo?',29),(73,'Are you happy?',30),(74,'Is it sunny outside?',30),(75,'Question1',31),(76,'Do you like pizza?',31),(77,'Question number one',31),(78,'Are you happy with this product?',31),(79,'Quest one question for today',32),(80,'Mountain or sea?',32),(81,'Pizza or pasta?',32),(82,'Is it beautiful?',32),(83,'Is it pleasant to use?',33),(84,'Is it small?',33),(85,'How fast is it?',33),(86,'Is coffee good?',33),(87,'Is coffee really good?',23);
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-18  0:29:37
