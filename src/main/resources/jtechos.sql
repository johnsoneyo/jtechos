-- MySQL dump 10.13  Distrib 5.5.37, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: jtechos
-- ------------------------------------------------------
-- Server version	5.5.37-0ubuntu0.14.04.1

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
-- Table structure for table `SEQUENCE`
--

DROP TABLE IF EXISTS `SEQUENCE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SEQUENCE` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SEQUENCE`
--

LOCK TABLES `SEQUENCE` WRITE;
/*!40000 ALTER TABLE `SEQUENCE` DISABLE KEYS */;
INSERT INTO `SEQUENCE` VALUES ('SEQ_GEN',950);
/*!40000 ALTER TABLE `SEQUENCE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact_us`
--

DROP TABLE IF EXISTS `contact_us`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact_us` (
  `contact_id` int(11) NOT NULL DEFAULT '0',
  `contact_org_name` varchar(32) DEFAULT NULL,
  `contact_message` varchar(256) DEFAULT NULL,
  `time_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`contact_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_us`
--

LOCK TABLES `contact_us` WRITE;
/*!40000 ALTER TABLE `contact_us` DISABLE KEYS */;
INSERT INTO `contact_us` VALUES (206,'','','2015-05-21 18:21:52'),(207,'Oracle Corporation','ORacle wants to outsource 5 developers in your team','2015-05-21 18:23:17'),(801,'Oracle organization','Oracle organization wants to hire 5 members from your team in j2ee','2015-05-27 15:28:18');
/*!40000 ALTER TABLE `contact_us` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job` (
  `job_id` varchar(32) NOT NULL DEFAULT '',
  `job_title` varchar(64) DEFAULT NULL,
  `job_desc` varchar(512) DEFAULT NULL,
  `time_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `skill_set_id` int(11) DEFAULT NULL,
  `apply_before` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`job_id`),
  KEY `FK_job_skill_set_id` (`skill_set_id`),
  CONSTRAINT `FK_job_skill_set_id` FOREIGN KEY (`skill_set_id`) REFERENCES `skill_set` (`skill_set_id`),
  CONSTRAINT `job_ibfk_1` FOREIGN KEY (`skill_set_id`) REFERENCES `skill_set` (`skill_set_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES ('JT100','J2EE Developer ','A seasoned java developer is needed  to work in a financial institution','2015-05-30 10:45:18',101,'2015-06-09 23:00:00'),('JT101','Oracle/J2EE Developer ','A backend oracle / j2ee developer is need for a role in a micro-finance bank ','2015-05-30 10:45:18',103,'2015-06-09 23:00:00'),('JT102','Spring Developer (Java) ','A java Spring developer for contract and export outsource is needed between the hours of 12:06 and 8:06 +0100 GMT ','2015-05-30 10:45:18',102,'2015-06-09 23:00:00');
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recruit`
--

DROP TABLE IF EXISTS `recruit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recruit` (
  `recruit_id` int(11) NOT NULL DEFAULT '0',
  `first_name` varchar(32) DEFAULT NULL,
  `last_name` varchar(32) DEFAULT NULL,
  `initials` varchar(8) DEFAULT NULL,
  `phone` varchar(16) DEFAULT NULL,
  `address1` varchar(256) DEFAULT NULL,
  `address2` varchar(256) DEFAULT NULL,
  `nationality` varchar(32) DEFAULT NULL,
  `state_of_residence` varchar(32) DEFAULT NULL,
  `marital_status` varchar(16) DEFAULT NULL,
  `goals` varchar(256) DEFAULT NULL,
  `weaknesses` varchar(256) DEFAULT NULL,
  `what_enhances_your_productivity` varchar(256) DEFAULT NULL,
  `why_you_left_your_last_job` varchar(256) DEFAULT NULL,
  `why_should_we_hire_you` varchar(256) DEFAULT NULL,
  `how_much_compensation_you_desire` varchar(64) DEFAULT NULL,
  `what_do_you_know_about_us` varchar(128) DEFAULT NULL,
  `languages` varchar(128) DEFAULT NULL,
  `employment_mode` varchar(32) DEFAULT NULL,
  `canTravel` tinyint(1) DEFAULT NULL,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `dob` date DEFAULT NULL,
  `resume` longblob,
  `email` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`recruit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recruit`
--

LOCK TABLES `recruit` WRITE;
/*!40000 ALTER TABLE `recruit` DISABLE KEYS */;
/*!40000 ALTER TABLE `recruit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recruit_skill_xref`
--

DROP TABLE IF EXISTS `recruit_skill_xref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recruit_skill_xref` (
  `recruit_id` int(11) DEFAULT NULL,
  `skill_set_id` int(11) DEFAULT NULL,
  KEY `FK_recruit_skill_xref_recruit_id` (`recruit_id`),
  KEY `FK_recruit_skill_xref_skill_set_id` (`skill_set_id`),
  CONSTRAINT `FK_recruit_skill_xref_recruit_id` FOREIGN KEY (`recruit_id`) REFERENCES `recruit_tech` (`recruit_id`),
  CONSTRAINT `FK_recruit_skill_xref_skill_set_id` FOREIGN KEY (`skill_set_id`) REFERENCES `skill_set` (`skill_set_id`),
  CONSTRAINT `recruit_skill_xref_ibfk_1` FOREIGN KEY (`recruit_id`) REFERENCES `recruit_tech` (`recruit_id`),
  CONSTRAINT `recruit_skill_xref_ibfk_2` FOREIGN KEY (`skill_set_id`) REFERENCES `skill_set` (`skill_set_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recruit_skill_xref`
--

LOCK TABLES `recruit_skill_xref` WRITE;
/*!40000 ALTER TABLE `recruit_skill_xref` DISABLE KEYS */;
/*!40000 ALTER TABLE `recruit_skill_xref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recruit_tech`
--

DROP TABLE IF EXISTS `recruit_tech`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recruit_tech` (
  `recruit_id` int(11) NOT NULL DEFAULT '0',
  `years_of_experience` varchar(32) DEFAULT NULL,
  `relational_database` varchar(64) DEFAULT NULL,
  `subversioning` varchar(64) DEFAULT NULL,
  `front_end_tech` varchar(64) DEFAULT NULL,
  `frame_works` varchar(128) DEFAULT NULL,
  `issue_tracking` varchar(128) DEFAULT NULL,
  `proficiency_level` varchar(32) DEFAULT NULL,
  `isMobile_dev` tinyint(1) DEFAULT NULL,
  `brief_summary_on_past_proj` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`recruit_id`),
  CONSTRAINT `FK_recruit_tech_recruit_id` FOREIGN KEY (`recruit_id`) REFERENCES `recruit` (`recruit_id`),
  CONSTRAINT `recruit_tech_ibfk_1` FOREIGN KEY (`recruit_id`) REFERENCES `recruit` (`recruit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recruit_tech`
--

LOCK TABLES `recruit_tech` WRITE;
/*!40000 ALTER TABLE `recruit_tech` DISABLE KEYS */;
/*!40000 ALTER TABLE `recruit_tech` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill_set`
--

DROP TABLE IF EXISTS `skill_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skill_set` (
  `skill_set_id` int(11) NOT NULL DEFAULT '0',
  `skill_name` varchar(32) DEFAULT NULL,
  `skill_desc` varchar(192) DEFAULT NULL,
  PRIMARY KEY (`skill_set_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill_set`
--

LOCK TABLES `skill_set` WRITE;
/*!40000 ALTER TABLE `skill_set` DISABLE KEYS */;
INSERT INTO `skill_set` VALUES (101,'J2EE Developer','A Developer who specializes in javaee framework'),(102,'Spring Developer (Java)','A Developer who specializes in spring framework'),(103,'Java/Oracle Developer ','A Developer who specializes in java front end and oracle backend ');
/*!40000 ALTER TABLE `skill_set` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-06-01 14:22:19
