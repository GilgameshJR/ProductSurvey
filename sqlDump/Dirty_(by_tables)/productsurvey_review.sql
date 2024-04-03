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
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (19,'Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.','2020-05-17 18:24:05',1),(20,'Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos.','2021-02-17 18:24:08',1),(21,'Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. ','2021-05-17 18:24:17',1),(22,'Good','2021-05-14 18:24:20',1),(23,'Beautiful','2021-04-17 21:24:27',1),(24,'Awful! Returned it','2021-04-23 18:24:38',1),(25,'Best coffee of my life','2019-04-17 18:24:48',1),(26,'Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?','2021-05-17 17:24:56',1),(27,'Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. ','2021-05-16 18:24:04',1),(28,'Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage.','2021-05-17 18:25:15',1),(29,'The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.','2021-05-05 18:25:19',1),(30,'Good','2021-04-23 18:24:38',2),(31,'Best coffee of my life','2021-02-17 17:24:56',2),(32,'Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage.','2021-05-17 18:25:15',2),(33,'The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.','2021-05-17 17:24:56',2),(34,'Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?','2021-05-05 18:25:19',2),(35,'Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.','2021-01-21 18:44:51',2),(36,'Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos.','2021-05-09 18:45:00',2),(37,'Beautiful','2021-05-17 18:45:06',2),(38,'Beautiful! Really','2020-05-17 18:45:09',2),(39,'Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. ','2021-02-17 18:45:16',2),(40,'Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. ','2021-02-17 18:45:16',3),(41,'Beautiful','2021-05-17 18:45:06',3),(42,'Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.','2021-01-21 18:44:51',3),(43,'Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?','2021-05-05 18:25:19',3),(44,'The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.','2021-05-17 17:24:56',3),(45,'Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage.','2021-05-17 18:25:15',3),(46,'Beautiful! Really','2020-05-17 18:45:09',3),(47,'Best coffee of my life','2021-02-17 17:24:56',3),(48,'I like it','2021-05-15 18:47:36',3),(49,'Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. ','2021-02-17 18:45:16',4),(50,'Beautiful','2021-05-17 18:45:06',4),(51,'Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam.','2021-01-21 18:44:51',4),(52,'Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?','2021-05-05 18:25:19',4),(53,'The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested.','2021-05-17 17:24:56',4),(54,'Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage.','2021-05-17 18:25:15',4),(55,'Beautiful! Really','2020-05-17 18:45:09',4),(56,'Best coffee of my life','2021-02-17 17:24:56',4),(57,'I like it','2021-05-15 18:47:36',4),(58,'Good','2021-04-23 18:24:38',4),(59,'Good','2021-04-23 18:24:38',3),(60,'Bad smell','2020-05-17 18:59:51',4);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-18  0:29:36
