Enter password: 
-- MySQL dump 10.13  Distrib 9.1.0, for Linux (x86_64)
--
-- Host: localhost    Database: airport_tracking_system
-- ------------------------------------------------------
-- Server version	9.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airport` (
  `id` bigint NOT NULL,
  `country` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES (2001,'USA','JFK International Airport'),(2002,'USA','Los Angeles International Airport'),(2003,'UK','Heathrow Airport'),(2004,'France','Charles de Gaulle Airport'),(2005,'Germany','Frankfurt Airport');
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airport_seq`
--

DROP TABLE IF EXISTS `airport_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airport_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport_seq`
--

LOCK TABLES `airport_seq` WRITE;
/*!40000 ALTER TABLE `airport_seq` DISABLE KEYS */;
INSERT INTO `airport_seq` VALUES (2005);
/*!40000 ALTER TABLE `airport_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `flight_id` bigint NOT NULL,
  `id` bigint NOT NULL,
  `passenger_id` bigint NOT NULL,
  `flight_class` enum('Business','Economy','First') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK546eybei9q7dsna94vryofrbr` (`flight_id`),
  KEY `FKabxd6qpdfkp11yan46jj1td90` (`passenger_id`),
  CONSTRAINT `FK546eybei9q7dsna94vryofrbr` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`id`),
  CONSTRAINT `FKabxd6qpdfkp11yan46jj1td90` FOREIGN KEY (`passenger_id`) REFERENCES `passenger` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (3001,4001,1001,'Economy'),(3002,4002,1002,'Business'),(3003,4003,1003,'First'),(3004,4004,1004,'Economy'),(3005,4005,1005,'Business'),(3005,4006,1013,'Business'),(3005,4007,1004,'Business'),(3002,4008,1013,'Economy');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_seq`
--

DROP TABLE IF EXISTS `booking_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_seq`
--

LOCK TABLES `booking_seq` WRITE;
/*!40000 ALTER TABLE `booking_seq` DISABLE KEYS */;
INSERT INTO `booking_seq` VALUES (4009);
/*!40000 ALTER TABLE `booking_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `arrival_airport_id` bigint DEFAULT NULL,
  `departure_airport_id` bigint DEFAULT NULL,
  `departure_date` datetime(6) DEFAULT NULL,
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKor550l1m73innd911e6nm8lj0` (`arrival_airport_id`),
  KEY `FKillsy04237nltbk2yryrbderb` (`departure_airport_id`),
  CONSTRAINT `FKillsy04237nltbk2yryrbderb` FOREIGN KEY (`departure_airport_id`) REFERENCES `airport` (`id`),
  CONSTRAINT `FKor550l1m73innd911e6nm8lj0` FOREIGN KEY (`arrival_airport_id`) REFERENCES `airport` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (2001,2002,'2024-12-01 08:00:00.000000',3001),(2002,2003,'2024-12-01 09:00:00.000000',3002),(2003,2004,'2024-12-01 10:00:00.000000',3003),(2004,2005,'2024-12-01 11:00:00.000000',3004),(2005,2001,'2024-12-01 12:00:00.000000',3005);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight_seq`
--

DROP TABLE IF EXISTS `flight_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_seq`
--

LOCK TABLES `flight_seq` WRITE;
/*!40000 ALTER TABLE `flight_seq` DISABLE KEYS */;
INSERT INTO `flight_seq` VALUES (3006);
/*!40000 ALTER TABLE `flight_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passenger` (
  `id` bigint NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (1001,'','Amr'),(1002,'','Ahmad'),(1003,'','Mohammed'),(1004,'','Omar'),(1005,'','Ali'),(1013,'$2a$10$e6zGh5wQLRvTsEKegrmqGe3ql4rYNng3hVjuB77IgopJjkZKvb7xO','Amrooo');
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger_seq`
--

DROP TABLE IF EXISTS `passenger_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passenger_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger_seq`
--

LOCK TABLES `passenger_seq` WRITE;
/*!40000 ALTER TABLE `passenger_seq` DISABLE KEYS */;
INSERT INTO `passenger_seq` VALUES (1015);
/*!40000 ALTER TABLE `passenger_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price_class`
--

DROP TABLE IF EXISTS `price_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `price_class` (
  `price` double DEFAULT NULL,
  `flight_id` bigint NOT NULL,
  `class` enum('Business','Economy','First') NOT NULL,
  PRIMARY KEY (`flight_id`,`class`),
  CONSTRAINT `FKn2fq0gvg046qn5l669gy8gl61` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price_class`
--

LOCK TABLES `price_class` WRITE;
/*!40000 ALTER TABLE `price_class` DISABLE KEYS */;
INSERT INTO `price_class` VALUES (500,3001,'Economy'),(1500,3002,'Business'),(2500,3003,'First'),(550,3004,'Economy'),(1600,3005,'Business');
/*!40000 ALTER TABLE `price_class` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-17 19:46:20
