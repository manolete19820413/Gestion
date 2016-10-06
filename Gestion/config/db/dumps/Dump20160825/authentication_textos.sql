CREATE DATABASE  IF NOT EXISTS `authentication` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `authentication`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: authentication
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
-- Table structure for table `textos`
--

DROP TABLE IF EXISTS `textos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `textos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(50) NOT NULL,
  `categoria` varchar(8) NOT NULL,
  `lenguaje` varchar(10) NOT NULL,
  `aplicacion` varchar(5) NOT NULL,
  `valor` varchar(255) DEFAULT '',
  `imagen` blob,
  `modificado` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modificado_por` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `I_UNIQUE` (`codigo`,`categoria`,`lenguaje`,`aplicacion`),
  KEY `FK_TEXT_CATE_idx` (`categoria`),
  KEY `FK_TEXT_LENG_idx` (`lenguaje`),
  KEY `FK_TEXT_MODI_P_idx` (`modificado_por`),
  KEY `FK_TEXT_APLI_idx` (`aplicacion`),
  CONSTRAINT `FK_TEXT_APLI` FOREIGN KEY (`aplicacion`) REFERENCES `aplicaciones` (`codigo`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_TEXT_CATE` FOREIGN KEY (`categoria`) REFERENCES `categorias` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_TEXT_LENG` FOREIGN KEY (`lenguaje`) REFERENCES `lenguajes` (`codigo`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_TEXT_MODI_P` FOREIGN KEY (`modificado_por`) REFERENCES `usuarios` (`id`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `textos`
--

LOCK TABLES `textos` WRITE;
/*!40000 ALTER TABLE `textos` DISABLE KEYS */;
/*!40000 ALTER TABLE `textos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-25 16:05:43
