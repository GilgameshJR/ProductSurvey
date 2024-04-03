CREATE DATABASE  IF NOT EXISTS `productsurvey` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `productsurvey`;
-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: ratti.dynv6.net    Database: productsurvey
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
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ANSWER` varchar(255) NOT NULL,
  `QUESTION_ID` int NOT NULL,
  `RESPONSE_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ANSWER_QUESTION_ID` (`QUESTION_ID`),
  KEY `FK_ANSWER_RESPONSE_ID` (`RESPONSE_ID`),
  CONSTRAINT `FK_ANSWER_QUESTION_ID` FOREIGN KEY (`QUESTION_ID`) REFERENCES `question` (`ID`),
  CONSTRAINT `FK_ANSWER_RESPONSE_ID` FOREIGN KEY (`RESPONSE_ID`) REFERENCES `response` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`admin`@`%`*/ /*!50003 TRIGGER `UpdateMandatoryPoints` AFTER INSERT ON `answer` FOR EACH ROW UPDATE response r SET r.POINTS=r.POINTS+1 WHERE r.ID=new.RESPONSE_ID */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `offensiveword`
--

DROP TABLE IF EXISTS `offensiveword`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `offensiveword` (
  `WORD` varchar(255) NOT NULL,
  PRIMARY KEY (`WORD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offensiveword`
--

LOCK TABLES `offensiveword` WRITE;
/*!40000 ALTER TABLE `offensiveword` DISABLE KEYS */;
/*!40000 ALTER TABLE `offensiveword` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `opening`
--

DROP TABLE IF EXISTS `opening`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `opening` (
  `ID` int NOT NULL,
  `TIMESTAMP` datetime NOT NULL,
  `QUESTIONNAIRE_ID` int NOT NULL,
  `USER_USERNAME` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `opening_index` (`QUESTIONNAIRE_ID`,`TIMESTAMP`),
  KEY `FK_OPENING_USER_USERNAME` (`USER_USERNAME`),
  CONSTRAINT `FK_OPENING_QUESTIONNAIRE_ID` FOREIGN KEY (`QUESTIONNAIRE_ID`) REFERENCES `questionnaire` (`ID`),
  CONSTRAINT `FK_OPENING_USER_USERNAME` FOREIGN KEY (`USER_USERNAME`) REFERENCES `user` (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `opening`
--

LOCK TABLES `opening` WRITE;
/*!40000 ALTER TABLE `opening` DISABLE KEYS */;
/*!40000 ALTER TABLE `opening` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `PICTURE` longblob,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questionnaire`
--

DROP TABLE IF EXISTS `questionnaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questionnaire` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `DATE` date NOT NULL,
  `PRODUCT_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `DATE` (`DATE`),
  KEY `FK_QUESTIONNAIRE_PRODUCT_ID` (`PRODUCT_ID`),
  CONSTRAINT `FK_QUESTIONNAIRE_PRODUCT_ID` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionnaire`
--

LOCK TABLES `questionnaire` WRITE;
/*!40000 ALTER TABLE `questionnaire` DISABLE KEYS */;
/*!40000 ALTER TABLE `questionnaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `response`
--

DROP TABLE IF EXISTS `response`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `response` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `POINTS` int NOT NULL,
  `TIMESTAMP` datetime NOT NULL,
  `USERAGE` int DEFAULT NULL,
  `USEREXPERIENCE` int DEFAULT NULL,
  `USERSEX` int DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `QUESTIONNAIRE_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNQ_RESPONSE_0` (`username`,`QUESTIONNAIRE_ID`),
  KEY `FK_RESPONSE_QUESTIONNAIRE_ID` (`QUESTIONNAIRE_ID`),
  CONSTRAINT `FK_RESPONSE_QUESTIONNAIRE_ID` FOREIGN KEY (`QUESTIONNAIRE_ID`) REFERENCES `questionnaire` (`ID`),
  CONSTRAINT `FK_RESPONSE_username` FOREIGN KEY (`username`) REFERENCES `user` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `response`
--

LOCK TABLES `response` WRITE;
/*!40000 ALTER TABLE `response` DISABLE KEYS */;
/*!40000 ALTER TABLE `response` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`admin`@`%`*/ /*!50003 TRIGGER `UpdateOptionalPoints` BEFORE INSERT ON `response` FOR EACH ROW SET new.points=2*(
        SELECT count(new.USERAGE)+count(new.USERSEX)+count(new.USEREXPERIENCE)
    ) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `REVIEW` varchar(255) NOT NULL,
  `TIMESTAMP` datetime NOT NULL,
  `PRODUCT_ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `review_index` (`TIMESTAMP`),
  KEY `FK_REVIEW_PRODUCT_ID` (`PRODUCT_ID`),
  CONSTRAINT `FK_REVIEW_PRODUCT_ID` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `product` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence`
--

LOCK TABLES `sequence` WRITE;
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` VALUES ('SEQ_GEN',0);
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `USERNAME` varchar(255) NOT NULL,
  `ISADMIN` varchar(31) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `BLOCKED` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`USERNAME`),
  UNIQUE KEY `EMAIL` (`EMAIL`),
  UNIQUE KEY `UNQ_USER_0` (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('admin1','yes','admin1@mail.com','admin1',0),('admin2','yes','admin2@mail.com','admin2',0),('user1','no','user1@mail.com','user1',0),('user2','no','user2@mail.com','user2',0),('user3','no','user3@mail.com','user3',0),('user4','no','user4@mail.com','user4',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-17 20:35:36
