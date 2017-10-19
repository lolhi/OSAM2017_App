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
-- Table structure for table `andorid_onnara_unitname`
--

DROP TABLE IF EXISTS `andorid_onnara_unitname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `andorid_onnara_unitname` (
  `Number` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '번호',
  `Mapkey` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '아이디',
  `Name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '비밀번호',
  UNIQUE KEY `Number` (`Number`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `andorid_onnara_unitname`
--

LOCK TABLES `andorid_onnara_unitname` WRITE;
/*!40000 ALTER TABLE `andorid_onnara_unitname` DISABLE KEYS */;
INSERT INTO `andorid_onnara_unitname` VALUES (1,'수방사','육직 수도방위사령부'),(2,'52사','육직 수도방위사령부 제52향토보병사단'),(3,'56사','육직 수도방위사령부 제56향토보병사단'),(4,'60사','육직 수도방위사령부 제60동원보병사단'),(5,'특전사','육직 특수전 사령부'),(6,'미사일사','육직 미사일 사령부'),(7,'항작사','육직 항공작전사령부'),(8,'군수사','육직 군수사령부'),(9,'탄약사','육직 군수사령부 탄약지원사령부'),(10,'교육사','육직 교육사령부'),(11,'인사사','육직 인사사령부'),(12,'1군사','제1야전군사령부'),(13,'1군지사','제1야전군사령부 1군수지원사령부'),(14,'36사','제1야전군사령부 36향토보병사단'),(15,'2군단','제1야전군사령부 2군단'),(16,'7사','제1야전군사령부 2군단 7보병사단'),(17,'15사','제1야전군사령부 2군단 15보병사단'),(18,'27사','제1야전군사령부 2군단 27보병사단'),(19,'3군단','제1야전군사령부 3군단'),(20,'2사','제1야전군사령부 3군단 2보병사단'),(21,'12사','제1야전군사령부 3군단 12보병사단'),(22,'21사','제1야전군사령부 3군단 21보병사단'),(23,'8군단','제1야전군사령부 8군단'),(24,'22사','제1야전군사령부 8군단 22보병사단'),(25,'23사','제1야전군사령부 8군단 23보병사단'),(26,'2작사','제2작전사령부'),(27,'5군지사','제2작전사령부 5군수지원사령부'),(28,'31사','제2작전사령부 31향토보병사단'),(29,'32사','제2작전사령부 32향토보병사단'),(30,'35사','제2작전사령부 35향토보병사단'),(31,'37사','제2작전사령부 37향토보병사단'),(32,'39사','제2작전사령부 39향토보병사단'),(33,'50사','제2작전사령부 50향토보병사단'),(34,'53사','제2작전사령부 53향토보병사단'),(35,'3군사','제3야전군사령부'),(36,'2군지사','제3야전군사령부 2군수지원사령부'),(37,'3군지사','제3야전군사령부 3군수지원사령부'),(38,'수도군단','제3야전군사령부 수도군단'),(39,'17사','제3야전군사령부 수도군단 17보병사단'),(40,'51사','제3야전군사령부 수도군단 51향토보병사단'),(41,'55사','제3야전군사령부 수도군단 55향토보병사단'),(42,'61사','제3야전군사령부 수도군단 61동원보병사단'),(43,'1군단','제3야전군사령부 1군단'),(44,'1사','제3야전군사령부 1군단 1보병사단'),(45,'9사단','제3야전군사령부 1군단 9보병사단'),(46,'25사','제3야전군사령부 1군단 25보병사단'),(47,'30사','제3야전군사령부 1군단 30기계화보병사단'),(48,'72사','제3야전군사령부 1군단 72동원보병사단'),(49,'5군단','제3야전군사령부 5군단'),(50,'3사','제3야전군사령부 5군단 3보병사단'),(51,'6사','제3야전군사령부 5군단 6보병사단'),(52,'66사','제3야전군사령부 5군단 66동원보병사단'),(53,'75사','제3야전군사령부 5군단 75동원보병사단'),(54,'6군단','제3야전군사령부 6군단'),(55,'5사','제3야전군사령부 6군단 5보병사단'),(56,'28사','제3야전군사령부 6군단 28보병사단'),(57,'65사','제3야전군사령부 6군단 65동원보병사단'),(58,'73사','제3야전군사령부 6군단 73동원보병사단'),(59,'7군단','제3야전군사령부 7기동군단'),(60,'수기사','제3야전군사령부 7기동군단 수도기계화보병사단'),(61,'8사','제3야전군사령부 7기동군단 8기계화보병사단'),(62,'11사','제3야전군사령부 7기동군단 11기계화보병사단'),(63,'26사','제3야전군사령부 7기동군단 26기계화보병사단');
/*!40000 ALTER TABLE `andorid_onnara_unitname` ENABLE KEYS */;
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
