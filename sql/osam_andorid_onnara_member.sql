-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: osam
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `andorid_onnara_member`
--

DROP TABLE IF EXISTS `andorid_onnara_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `andorid_onnara_member` (
  `Number` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '번호',
  `Id` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '아이디',
  `Password` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '비밀번호',
  `UnitName` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '부대명',
  `Name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '이름',
  UNIQUE KEY `Number` (`Number`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `andorid_onnara_member`
--

LOCK TABLES `andorid_onnara_member` WRITE;
/*!40000 ALTER TABLE `andorid_onnara_member` DISABLE KEYS */;
INSERT INTO `andorid_onnara_member` VALUES (1,'lolhi','1234','제 2작전사령부 37향토보병사단 111연대 정보통신중대','장용주'),(2,'lolhi1','1234','제 2작전사령부 37향토보병사단 111연대 정보통신중대','조찬영'),(3,'lolhi2','1234','제 2작전사령부 37향토보병사단 111연대 정보통신중대','이효석'),(4,'qwert','12345','육직 미사일사령부','박지훈'),(5,'asdf','123451','제 3군사령부 2보병사단 31연대 정보통신중대','홍승표'),(6,'312323','213213123','제 2작전사령부 37사단 111연대 정보통신중대','서승표'),(7,'213123213','23213123','제2작전사령부 37향토보병사단 111연대 정보통신중대','박완재');
/*!40000 ALTER TABLE `andorid_onnara_member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-20  3:18:52
