-- MySQL dump 10.13  Distrib 5.7.25, for osx10.14 (x86_64)
--
-- Host: localhost    Database: ejabberd
-- ------------------------------------------------------
-- Server version	5.7.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;f
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
-- Table structure for table `archive`
--

DROP TABLE IF EXISTS `archive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `archive` (
  `username` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `timestamp` bigint(20) unsigned NOT NULL,
  `peer` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `bare_peer` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `xml` mediumtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `txt` mediumtext COLLATE utf8mb4_unicode_ci,
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `kind` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nick` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `id` (`id`),
  KEY `i_username_timestamp` (`username`,`timestamp`) USING BTREE,
  KEY `i_username_peer` (`username`,`peer`) USING BTREE,
  KEY `i_username_bare_peer` (`username`,`bare_peer`) USING BTREE,
  KEY `i_timestamp` (`timestamp`) USING BTREE,
  FULLTEXT KEY `i_text` (`txt`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `archive`
--

LOCK TABLES `archive` WRITE;
/*!40000 ALTER TABLE `archive` DISABLE KEYS */;
INSERT INTO `archive` VALUES ('bob',1561312897660316,'test@j','test@j','/43918754998799053561990$7f51fe65-196e-43dc-af87-baf22ca0c8d5	Hey Andre','Hey Andre',1,'chat','','2019-06-23 18:01:37'),('test',1561312897754229,'bob@j/43918754998799053561990','bob@j','$7f51fe65-196e-43dc-af87-baf22ca0c8d5	Hey Andre','Hey Andre',2,'chat','','2019-06-23 18:01:37'),('test',1561312907146575,'bob@j/43918754998799053561990','bob@j','test@J/J	577p4-136jabber:x:eventxoffline	composing\ZHey bob bX9wv3','Hey bob',3,'chat','','2019-06-23 18:01:47'),('bob',1561312907188054,'test@j/J','test@j','	/43918754998799053561990test@J/J	577p4-136jabber:x:eventxoffline	composing\ZHey bob bX9wv3','Hey bob',4,'chat','','2019-06-23 18:01:47'),('test',1561312930814691,'bob@j/43918754998799053561990','bob@j','test@J/J	577p4-140jabber:x:eventxoffline	composing\Z\nWhat\'s up? bX9wv3','What\'s up?',5,'chat','','2019-06-23 18:02:10'),('bob',1561312930857172,'test@j/J','test@j','	/43918754998799053561990test@J/J	577p4-140jabber:x:eventxoffline	composing\Z\nWhat\'s up? bX9wv3','What\'s up?',6,'chat','','2019-06-23 18:02:10'),('test',1561312953029870,'bob@j/43918754998799053561990','bob@j','test@J/J	577p4-144jabber:x:eventxoffline	composing\Z\rAre you good? bX9wv3','Are you good?',7,'chat','','2019-06-23 18:02:33'),('bob',1561312953071338,'test@j/J','test@j','	/43918754998799053561990test@J/J	577p4-144jabber:x:eventxoffline	composing\Z\rAre you good? bX9wv3','Are you good?',8,'chat','','2019-06-23 18:02:33'),('bob',1561313051120422,'test@j','test@j','\ntest@Jbob@J/Jabberhey','hey',9,'chat','','2019-06-23 18:04:11'),('test',1561313051124145,'bob@j/Jabber','bob@j','\ntest@Jbob@J/Jabberhey','hey',10,'chat','','2019-06-23 18:04:11'),('bob',1561317828157191,'test@j','test@j','\ntest@Jbob@J/Jabberhey','hey',11,'chat','','2019-06-23 19:23:48'),('test',1561317828165046,'bob@j/Jabber','bob@j','\ntest@Jbob@J/Jabberhey','hey',12,'chat','','2019-06-23 19:23:48'),('bob',1561317878310093,'andre@j','andre@j','\nandre@Jbob@J/Jabberhey','hey',13,'chat','','2019-06-23 19:24:38'),('andre',1561317878311687,'bob@j/Jabber','bob@j','\nandre@Jbob@J/Jabberhey','hey',14,'chat','','2019-06-23 19:24:38'),('admin',1561317903876292,'bob@j/Jabber','bob@j','\nadmin@Jbob@J/Jabberhey','hey',15,'chat','','2019-06-23 19:25:03'),('admin',1561318026865165,'bob@j/Jabber','bob@j','\nadmin@Jbob@J/Jabberadmin','admin',16,'chat','','2019-06-23 19:27:06'),('bob',1561318032066086,'test@j','test@j','\ntest@Jbob@J/Jabbertest','test',17,'chat','','2019-06-23 19:27:12'),('test',1561318032075096,'bob@j/Jabber','bob@j','\ntest@Jbob@J/Jabbertest','test',18,'chat','','2019-06-23 19:27:12'),('bob',1561318037003872,'andre@j','andre@j','\nandre@Jbob@J/Jabberandre','andre',19,'chat','','2019-06-23 19:27:17'),('andre',1561318037011858,'bob@j/Jabber','bob@j','\nandre@Jbob@J/Jabberandre','andre',20,'chat','','2019-06-23 19:27:17'),('admin1',1561318087001377,'bob@j/Jabber','bob@j','\nadmin1@Jbob@J/Jabberadmin1','admin1',21,'chat','','2019-06-23 19:28:07'),('admin1',1561318111355717,'bob@j','bob@j','\nbob@Jadmin1@J/Jabberbob','bob',22,'chat','','2019-06-23 19:28:31'),('test',1561318150801465,'bob@j/Jabber','bob@j','\nbob@J/Jabbertest@J/J	577p4-171jabber:x:eventxoffline	composing\ZHi Bob! bX9wv3','Hi Bob!',23,'chat','','2019-06-23 19:29:10'),('bob',1561318150841508,'test@j/J','test@j','\nbob@J/Jabbertest@J/J	577p4-171jabber:x:eventxoffline	composing\ZHi Bob! bX9wv3','Hi Bob!',24,'chat','','2019-06-23 19:29:10'),('admin',1561318180385059,'admin1@j','admin1@j','\nadmin1@Jadmin@J/Jabberadmin11','admin11',25,'chat','','2019-06-23 19:29:40'),('admin1',1561318180392252,'admin@j/Jabber','admin@j','\nadmin1@Jadmin@J/Jabberadmin11','admin11',26,'chat','','2019-06-23 19:29:40'),('andre',1561339498914303,'admin@j','admin@j','\nadmin@Jandre@J/Jabberto','to',27,'chat','','2019-06-24 01:24:58'),('admin',1561339498970201,'andre@j/Jabber','andre@j','\nadmin@Jandre@J/Jabberto','to',28,'chat','','2019-06-24 01:24:58'),('andre',1561340392720615,'admin@j/J','admin@j','\n	admin@J/Jandre@J/Jabberto','to',29,'chat','','2019-06-24 01:39:52'),('admin',1561340392728455,'andre@j/Jabber','andre@j','\n	admin@J/Jandre@J/Jabberto','to',30,'chat','','2019-06-24 01:39:52'),('andre',1561340414731861,'alice@j','alice@j','\nalice@Jandre@J/Jabberto','to',31,'chat','','2019-06-24 01:40:14'),('alice',1561340414739146,'andre@j/Jabber','andre@j','\nalice@Jandre@J/Jabberto','to',32,'chat','','2019-06-24 01:40:14'),('andre',1561340443352728,'alice@j','alice@j','\nalice@Jandre@J/Jabber	hey alice','hey alice',33,'chat','','2019-06-24 01:40:43'),('alice',1561340443360448,'andre@j/Jabber','andre@j','\nalice@Jandre@J/Jabber	hey alice','hey alice',34,'chat','','2019-06-24 01:40:43');
/*!40000 ALTER TABLE `archive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `archive_prefs`
--

DROP TABLE IF EXISTS `archive_prefs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `archive_prefs` (
  `username` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `def` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `always` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `never` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `archive_prefs`
--

LOCK TABLES `archive_prefs` WRITE;
/*!40000 ALTER TABLE `archive_prefs` DISABLE KEYS */;
INSERT INTO `archive_prefs` VALUES ('andre','always','[{<<\"admin1\">>,<<\"j\">>,<<>>}]','[]','2019-06-23 15:53:48'),('bob','roster','[{<<\"andre\">>,<<\"j\">>,<<>>}]','[]','2019-06-23 15:55:18');
/*!40000 ALTER TABLE `archive_prefs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bosh`
--

DROP TABLE IF EXISTS `bosh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bosh` (
  `sid` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `node` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `pid` text COLLATE utf8mb4_unicode_ci NOT NULL,
  UNIQUE KEY `i_bosh_sid` (`sid`(75))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bosh`
--

LOCK TABLES `bosh` WRITE;
/*!40000 ALTER TABLE `bosh` DISABLE KEYS */;
/*!40000 ALTER TABLE `bosh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caps_features`
--

DROP TABLE IF EXISTS `caps_features`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caps_features` (
  `node` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `subnode` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `feature` text COLLATE utf8mb4_unicode_ci,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `i_caps_features_node_subnode` (`node`(75),`subnode`(75))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caps_features`
--

LOCK TABLES `caps_features` WRITE;
/*!40000 ALTER TABLE `caps_features` DISABLE KEYS */;
INSERT INTO `caps_features` VALUES ('http://www.igniterealtime.org/projects/smack','njE08O0d+gOu+3R5iJiJSheFRMw=','http://jabber.org/protocol/disco#items','2019-06-23 18:00:41'),('http://www.igniterealtime.org/projects/smack','njE08O0d+gOu+3R5iJiJSheFRMw=','http://jabber.org/protocol/caps','2019-06-23 18:00:41'),('http://www.igniterealtime.org/projects/smack','njE08O0d+gOu+3R5iJiJSheFRMw=','vcard-temp','2019-06-23 18:00:41'),('http://www.igniterealtime.org/projects/smack','njE08O0d+gOu+3R5iJiJSheFRMw=','http://jabber.org/protocol/bytestreams','2019-06-23 18:00:41'),('http://www.igniterealtime.org/projects/smack','njE08O0d+gOu+3R5iJiJSheFRMw=','http://jabber.org/protocol/ibb','2019-06-23 18:00:41'),('http://www.igniterealtime.org/projects/smack','njE08O0d+gOu+3R5iJiJSheFRMw=','http://jabber.org/protocol/si','2019-06-23 18:00:41'),('http://www.igniterealtime.org/projects/smack','njE08O0d+gOu+3R5iJiJSheFRMw=','http://jabber.org/protocol/xhtml-im','2019-06-23 18:00:41'),('http://www.igniterealtime.org/projects/smack','njE08O0d+gOu+3R5iJiJSheFRMw=','jabber:x:data','2019-06-23 18:00:41'),('http://www.igniterealtime.org/projects/smack','njE08O0d+gOu+3R5iJiJSheFRMw=','http://jabber.org/protocol/chatstates','2019-06-23 18:00:41'),('http://www.igniterealtime.org/projects/smack','njE08O0d+gOu+3R5iJiJSheFRMw=','jabber:iq:version','2019-06-23 18:00:41'),('http://www.igniterealtime.org/projects/smack','njE08O0d+gOu+3R5iJiJSheFRMw=','urn:xmpp:time','2019-06-23 18:00:41'),('http://www.igniterealtime.org/projects/smack','njE08O0d+gOu+3R5iJiJSheFRMw=','jabber:iq:privacy','2019-06-23 18:00:41'),('http://www.igniterealtime.org/projects/smack','njE08O0d+gOu+3R5iJiJSheFRMw=','http://jabber.org/protocol/si/profile/file-transfer','2019-06-23 18:00:41'),('http://www.igniterealtime.org/projects/smack','njE08O0d+gOu+3R5iJiJSheFRMw=','urn:xmpp:ping','2019-06-23 18:00:41'),('http://www.igniterealtime.org/projects/smack','njE08O0d+gOu+3R5iJiJSheFRMw=','jabber:iq:last','2019-06-23 18:00:41'),('http://www.igniterealtime.org/projects/smack','njE08O0d+gOu+3R5iJiJSheFRMw=','http://jabber.org/protocol/commands','2019-06-23 18:00:41'),('http://www.igniterealtime.org/projects/smack','njE08O0d+gOu+3R5iJiJSheFRMw=','http://jabber.org/protocol/muc','2019-06-23 18:00:41'),('http://www.igniterealtime.org/projects/smack','njE08O0d+gOu+3R5iJiJSheFRMw=','http://jabber.org/protocol/xdata-validate','2019-06-23 18:00:41'),('http://www.igniterealtime.org/projects/smack','njE08O0d+gOu+3R5iJiJSheFRMw=','http://jabber.org/protocol/xdata-layout','2019-06-23 18:00:41'),('http://www.igniterealtime.org/projects/smack','njE08O0d+gOu+3R5iJiJSheFRMw=','urn:xmpp:receipts','2019-06-23 18:00:41'),('http://www.igniterealtime.org/projects/smack','njE08O0d+gOu+3R5iJiJSheFRMw=','http://jabber.org/protocol/disco#info','2019-06-23 18:00:41'),('http://www.igniterealtime.org/projects/smack','viD0To3eoSjqrBO3M8uZuX3TWkA=','http://jabber.org/protocol/disco#items','2019-06-23 18:00:43'),('http://www.igniterealtime.org/projects/smack','viD0To3eoSjqrBO3M8uZuX3TWkA=','http://jabber.org/protocol/caps','2019-06-23 18:00:43'),('http://www.igniterealtime.org/projects/smack','viD0To3eoSjqrBO3M8uZuX3TWkA=','vcard-temp','2019-06-23 18:00:43'),('http://www.igniterealtime.org/projects/smack','viD0To3eoSjqrBO3M8uZuX3TWkA=','http://jabber.org/protocol/bytestreams','2019-06-23 18:00:43'),('http://www.igniterealtime.org/projects/smack','viD0To3eoSjqrBO3M8uZuX3TWkA=','http://jabber.org/protocol/ibb','2019-06-23 18:00:43'),('http://www.igniterealtime.org/projects/smack','viD0To3eoSjqrBO3M8uZuX3TWkA=','http://jabber.org/protocol/si','2019-06-23 18:00:43'),('http://www.igniterealtime.org/projects/smack','viD0To3eoSjqrBO3M8uZuX3TWkA=','http://jabber.org/protocol/xhtml-im','2019-06-23 18:00:43'),('http://www.igniterealtime.org/projects/smack','viD0To3eoSjqrBO3M8uZuX3TWkA=','jabber:x:data','2019-06-23 18:00:43'),('http://www.igniterealtime.org/projects/smack','viD0To3eoSjqrBO3M8uZuX3TWkA=','http://jabber.org/protocol/chatstates','2019-06-23 18:00:43'),('http://www.igniterealtime.org/projects/smack','viD0To3eoSjqrBO3M8uZuX3TWkA=','jabber:iq:version','2019-06-23 18:00:43'),('http://www.igniterealtime.org/projects/smack','viD0To3eoSjqrBO3M8uZuX3TWkA=','urn:xmpp:time','2019-06-23 18:00:43'),('http://www.igniterealtime.org/projects/smack','viD0To3eoSjqrBO3M8uZuX3TWkA=','jabber:iq:privacy','2019-06-23 18:00:43'),('http://www.igniterealtime.org/projects/smack','viD0To3eoSjqrBO3M8uZuX3TWkA=','http://jabber.org/protocol/si/profile/file-transfer','2019-06-23 18:00:43'),('http://www.igniterealtime.org/projects/smack','viD0To3eoSjqrBO3M8uZuX3TWkA=','urn:xmpp:ping','2019-06-23 18:00:43'),('http://www.igniterealtime.org/projects/smack','viD0To3eoSjqrBO3M8uZuX3TWkA=','jabber:iq:last','2019-06-23 18:00:43'),('http://www.igniterealtime.org/projects/smack','viD0To3eoSjqrBO3M8uZuX3TWkA=','http://jabber.org/protocol/commands','2019-06-23 18:00:43'),('http://www.igniterealtime.org/projects/smack','viD0To3eoSjqrBO3M8uZuX3TWkA=','http://jabber.org/protocol/muc','2019-06-23 18:00:43'),('http://www.igniterealtime.org/projects/smack','viD0To3eoSjqrBO3M8uZuX3TWkA=','http://jabber.org/protocol/xdata-validate','2019-06-23 18:00:43'),('http://www.igniterealtime.org/projects/smack','viD0To3eoSjqrBO3M8uZuX3TWkA=','http://www.xmpp.org/extensions/xep-0166.html#ns','2019-06-23 18:00:43'),('http://www.igniterealtime.org/projects/smack','viD0To3eoSjqrBO3M8uZuX3TWkA=','http://jabber.org/protocol/xdata-layout','2019-06-23 18:00:43'),('http://www.igniterealtime.org/projects/smack','viD0To3eoSjqrBO3M8uZuX3TWkA=','urn:xmpp:receipts','2019-06-23 18:00:43'),('http://www.igniterealtime.org/projects/smack','viD0To3eoSjqrBO3M8uZuX3TWkA=','http://jabber.org/protocol/disco#info','2019-06-23 18:00:43'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','http://jabber.org/protocol/disco#items','2019-06-23 18:00:44'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','http://jabber.org/protocol/caps','2019-06-23 18:00:44'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','vcard-temp','2019-06-23 18:00:44'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','urn:xmpp:tmp:jingle','2019-06-23 18:00:44'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','http://jabber.org/protocol/bytestreams','2019-06-23 18:00:44'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','http://jabber.org/protocol/ibb','2019-06-23 18:00:44'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','http://jabber.org/protocol/si','2019-06-23 18:00:44'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','http://jabber.org/protocol/xhtml-im','2019-06-23 18:00:44'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','jabber:x:data','2019-06-23 18:00:44'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','http://jabber.org/protocol/chatstates','2019-06-23 18:00:44'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','jabber:iq:version','2019-06-23 18:00:44'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','urn:xmpp:time','2019-06-23 18:00:44'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','jabber:iq:privacy','2019-06-23 18:00:44'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','http://jabber.org/protocol/si/profile/file-transfer','2019-06-23 18:00:44'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','urn:xmpp:ping','2019-06-23 18:00:44'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','jabber:iq:last','2019-06-23 18:00:44'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','http://jabber.org/protocol/commands','2019-06-23 18:00:44'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','http://jabber.org/protocol/muc','2019-06-23 18:00:44'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','http://jabber.org/protocol/xdata-validate','2019-06-23 18:00:44'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','http://www.xmpp.org/extensions/xep-0166.html#ns','2019-06-23 18:00:44'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','http://jabber.org/protocol/xdata-layout','2019-06-23 18:00:44'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','urn:xmpp:receipts','2019-06-23 18:00:44'),('http://www.igniterealtime.org/projects/smack','TJuVIXqTCVfJSthaPu4MtTbaf9A=','http://jabber.org/protocol/disco#info','2019-06-23 18:00:44'),('http://swift.im','3ScHZH4hKmksks0e7RG8B4cjaT8=','http://jabber.org/protocol/chatstates','2019-06-23 18:01:22'),('http://swift.im','3ScHZH4hKmksks0e7RG8B4cjaT8=','urn:xmpp:sec-label:0','2019-06-23 18:01:22'),('http://swift.im','3ScHZH4hKmksks0e7RG8B4cjaT8=','urn:xmpp:message-correct:0','2019-06-23 18:01:22'),('http://swift.im','3ScHZH4hKmksks0e7RG8B4cjaT8=','urn:xmpp:jingle:1','2019-06-23 18:01:22'),('http://swift.im','3ScHZH4hKmksks0e7RG8B4cjaT8=','urn:xmpp:jingle:apps:file-transfer:4','2019-06-23 18:01:22'),('http://swift.im','3ScHZH4hKmksks0e7RG8B4cjaT8=','urn:xmpp:jingle:transports:ibb:1','2019-06-23 18:01:22'),('http://swift.im','3ScHZH4hKmksks0e7RG8B4cjaT8=','urn:xmpp:jingle:transports:s5b:1','2019-06-23 18:01:22'),('http://swift.im','3ScHZH4hKmksks0e7RG8B4cjaT8=','urn:xmpp:receipts','2019-06-23 18:01:22');
/*!40000 ALTER TABLE `caps_features` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `last`
--

DROP TABLE IF EXISTS `last`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `last` (
  `username` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `seconds` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `state` text COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `last`
--

LOCK TABLES `last` WRITE;
/*!40000 ALTER TABLE `last` DISABLE KEYS */;
INSERT INTO `last` VALUES ('3175433272470683','1564194882','Connection failed: connection closed'),('admin','1561322775','Connection failed: connection closed'),('admin1','1561321470','Connection failed: connection closed'),('alice','1561327761','Registered but didn\'t login'),('andre','1564194928','Connection failed: connection closed'),('bob','1561327575','Connection failed: connection closed'),('test','1561330957','Connection failed: connection closed');
/*!40000 ALTER TABLE `last` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mix_channel`
--

DROP TABLE IF EXISTS `mix_channel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mix_channel` (
  `channel` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `service` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `domain` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `jid` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `hidden` tinyint(1) NOT NULL,
  `hmac_key` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `i_mix_channel` (`channel`(191),`service`(191)),
  KEY `i_mix_channel_serv` (`service`(191))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mix_channel`
--

LOCK TABLES `mix_channel` WRITE;
/*!40000 ALTER TABLE `mix_channel` DISABLE KEYS */;
/*!40000 ALTER TABLE `mix_channel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mix_pam`
--

DROP TABLE IF EXISTS `mix_pam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mix_pam` (
  `username` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `channel` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `service` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `id` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `i_mix_pam` (`username`(191),`channel`(191),`service`(191)),
  KEY `i_mix_pam_u` (`username`(191))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mix_pam`
--

LOCK TABLES `mix_pam` WRITE;
/*!40000 ALTER TABLE `mix_pam` DISABLE KEYS */;
/*!40000 ALTER TABLE `mix_pam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mix_participant`
--

DROP TABLE IF EXISTS `mix_participant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mix_participant` (
  `channel` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `service` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `domain` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `jid` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `id` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `nick` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `i_mix_participant` (`channel`(191),`service`(191),`username`(191),`domain`(191)),
  KEY `i_mix_participant_chan_serv` (`channel`(191),`service`(191))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mix_participant`
--

LOCK TABLES `mix_participant` WRITE;
/*!40000 ALTER TABLE `mix_participant` DISABLE KEYS */;
/*!40000 ALTER TABLE `mix_participant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mix_subscription`
--

DROP TABLE IF EXISTS `mix_subscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mix_subscription` (
  `channel` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `service` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `domain` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `node` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `jid` text COLLATE utf8mb4_unicode_ci NOT NULL,
  UNIQUE KEY `i_mix_subscription` (`channel`(153),`service`(153),`username`(153),`domain`(153),`node`(153)),
  KEY `i_mix_subscription_chan_serv_ud` (`channel`(191),`service`(191),`username`(191),`domain`(191)),
  KEY `i_mix_subscription_chan_serv_node` (`channel`(191),`service`(191),`node`(191)),
  KEY `i_mix_subscription_chan_serv` (`channel`(191),`service`(191))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mix_subscription`
--

LOCK TABLES `mix_subscription` WRITE;
/*!40000 ALTER TABLE `mix_subscription` DISABLE KEYS */;
/*!40000 ALTER TABLE `mix_subscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motd`
--

DROP TABLE IF EXISTS `motd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `motd` (
  `username` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `xml` text COLLATE utf8mb4_unicode_ci,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motd`
--

LOCK TABLES `motd` WRITE;
/*!40000 ALTER TABLE `motd` DISABLE KEYS */;
/*!40000 ALTER TABLE `motd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mqtt_pub`
--

DROP TABLE IF EXISTS `mqtt_pub`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mqtt_pub` (
  `username` varchar(191) NOT NULL,
  `resource` varchar(191) NOT NULL,
  `topic` text NOT NULL,
  `qos` tinyint(4) NOT NULL,
  `payload` blob NOT NULL,
  `payload_format` tinyint(4) NOT NULL,
  `content_type` text NOT NULL,
  `response_topic` text NOT NULL,
  `correlation_data` blob NOT NULL,
  `user_properties` blob NOT NULL,
  `expiry` int(10) unsigned NOT NULL,
  UNIQUE KEY `i_mqtt_topic` (`topic`(191))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mqtt_pub`
--

LOCK TABLES `mqtt_pub` WRITE;
/*!40000 ALTER TABLE `mqtt_pub` DISABLE KEYS */;
/*!40000 ALTER TABLE `mqtt_pub` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `muc_online_room`
--

DROP TABLE IF EXISTS `muc_online_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `muc_online_room` (
  `name` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `host` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `node` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `pid` text COLLATE utf8mb4_unicode_ci NOT NULL,
  UNIQUE KEY `i_muc_online_room_name_host` (`name`(75),`host`(75)) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `muc_online_room`
--

LOCK TABLES `muc_online_room` WRITE;
/*!40000 ALTER TABLE `muc_online_room` DISABLE KEYS */;
/*!40000 ALTER TABLE `muc_online_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `muc_online_users`
--

DROP TABLE IF EXISTS `muc_online_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `muc_online_users` (
  `username` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `server` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `resource` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `host` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `node` text COLLATE utf8mb4_unicode_ci NOT NULL,
  UNIQUE KEY `i_muc_online_users` (`username`(75),`server`(75),`resource`(75),`name`(75),`host`(75)) USING BTREE,
  KEY `i_muc_online_users_us` (`username`(75),`server`(75)) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `muc_online_users`
--

LOCK TABLES `muc_online_users` WRITE;
/*!40000 ALTER TABLE `muc_online_users` DISABLE KEYS */;
/*!40000 ALTER TABLE `muc_online_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `muc_registered`
--

DROP TABLE IF EXISTS `muc_registered`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `muc_registered` (
  `jid` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `host` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `nick` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `i_muc_registered_jid_host` (`jid`(75),`host`(75)) USING BTREE,
  KEY `i_muc_registered_nick` (`nick`(75)) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `muc_registered`
--

LOCK TABLES `muc_registered` WRITE;
/*!40000 ALTER TABLE `muc_registered` DISABLE KEYS */;
/*!40000 ALTER TABLE `muc_registered` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `muc_room`
--

DROP TABLE IF EXISTS `muc_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `muc_room` (
  `name` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `host` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `opts` mediumtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `i_muc_room_name_host` (`name`(75),`host`(75)) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `muc_room`
--

LOCK TABLES `muc_room` WRITE;
/*!40000 ALTER TABLE `muc_room` DISABLE KEYS */;
/*!40000 ALTER TABLE `muc_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `muc_room_subscribers`
--

DROP TABLE IF EXISTS `muc_room_subscribers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `muc_room_subscribers` (
  `room` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `host` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `jid` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nick` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `nodes` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `i_muc_room_subscribers_host_room_jid` (`host`,`room`,`jid`),
  KEY `i_muc_room_subscribers_host_jid` (`host`,`jid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `muc_room_subscribers`
--

LOCK TABLES `muc_room_subscribers` WRITE;
/*!40000 ALTER TABLE `muc_room_subscribers` DISABLE KEYS */;
/*!40000 ALTER TABLE `muc_room_subscribers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oauth_token`
--

DROP TABLE IF EXISTS `oauth_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oauth_token` (
  `token` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `jid` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `scope` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `expire` bigint(20) NOT NULL,
  PRIMARY KEY (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oauth_token`
--

LOCK TABLES `oauth_token` WRITE;
/*!40000 ALTER TABLE `oauth_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `oauth_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privacy_default_list`
--

DROP TABLE IF EXISTS `privacy_default_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privacy_default_list` (
  `username` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privacy_default_list`
--

LOCK TABLES `privacy_default_list` WRITE;
/*!40000 ALTER TABLE `privacy_default_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `privacy_default_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privacy_list`
--

DROP TABLE IF EXISTS `privacy_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privacy_list` (
  `username` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `i_privacy_list_username_name` (`username`(75),`name`(75)) USING BTREE,
  KEY `i_privacy_list_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privacy_list`
--

LOCK TABLES `privacy_list` WRITE;
/*!40000 ALTER TABLE `privacy_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `privacy_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privacy_list_data`
--

DROP TABLE IF EXISTS `privacy_list_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privacy_list_data` (
  `id` bigint(20) DEFAULT NULL,
  `t` char(1) COLLATE utf8mb4_unicode_ci NOT NULL,
  `value` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `action` char(1) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ord` decimal(10,0) NOT NULL,
  `match_all` tinyint(1) NOT NULL,
  `match_iq` tinyint(1) NOT NULL,
  `match_message` tinyint(1) NOT NULL,
  `match_presence_in` tinyint(1) NOT NULL,
  `match_presence_out` tinyint(1) NOT NULL,
  KEY `i_privacy_list_data_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privacy_list_data`
--

LOCK TABLES `privacy_list_data` WRITE;
/*!40000 ALTER TABLE `privacy_list_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `privacy_list_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `private_storage`
--

DROP TABLE IF EXISTS `private_storage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `private_storage` (
  `username` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `namespace` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `data` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `i_private_storage_username_namespace` (`username`(75),`namespace`(75)) USING BTREE,
  KEY `i_private_storage_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `private_storage`
--

LOCK TABLES `private_storage` WRITE;
/*!40000 ALTER TABLE `private_storage` DISABLE KEYS */;
/*!40000 ALTER TABLE `private_storage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proxy65`
--

DROP TABLE IF EXISTS `proxy65`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proxy65` (
  `sid` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `pid_t` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `pid_i` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `node_t` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `node_i` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `jid_i` text COLLATE utf8mb4_unicode_ci NOT NULL,
  UNIQUE KEY `i_proxy65_sid` (`sid`(191)),
  KEY `i_proxy65_jid` (`jid_i`(191))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proxy65`
--

LOCK TABLES `proxy65` WRITE;
/*!40000 ALTER TABLE `proxy65` DISABLE KEYS */;
/*!40000 ALTER TABLE `proxy65` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pubsub_item`
--

DROP TABLE IF EXISTS `pubsub_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pubsub_item` (
  `nodeid` bigint(20) DEFAULT NULL,
  `itemid` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `publisher` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `creation` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `modification` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `payload` mediumtext COLLATE utf8mb4_unicode_ci NOT NULL,
  UNIQUE KEY `i_pubsub_item_tuple` (`nodeid`,`itemid`(36)),
  KEY `i_pubsub_item_itemid` (`itemid`(36)),
  CONSTRAINT `pubsub_item_ibfk_1` FOREIGN KEY (`nodeid`) REFERENCES `pubsub_node` (`nodeid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pubsub_item`
--

LOCK TABLES `pubsub_item` WRITE;
/*!40000 ALTER TABLE `pubsub_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `pubsub_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pubsub_node`
--

DROP TABLE IF EXISTS `pubsub_node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pubsub_node` (
  `host` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `node` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `parent` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `plugin` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `nodeid` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`nodeid`),
  UNIQUE KEY `i_pubsub_node_tuple` (`host`(71),`node`(120)),
  KEY `i_pubsub_node_parent` (`parent`(120))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pubsub_node`
--

LOCK TABLES `pubsub_node` WRITE;
/*!40000 ALTER TABLE `pubsub_node` DISABLE KEYS */;
/*!40000 ALTER TABLE `pubsub_node` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pubsub_node_option`
--

DROP TABLE IF EXISTS `pubsub_node_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pubsub_node_option` (
  `nodeid` bigint(20) DEFAULT NULL,
  `name` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `val` text COLLATE utf8mb4_unicode_ci NOT NULL,
  KEY `i_pubsub_node_option_nodeid` (`nodeid`),
  CONSTRAINT `pubsub_node_option_ibfk_1` FOREIGN KEY (`nodeid`) REFERENCES `pubsub_node` (`nodeid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pubsub_node_option`
--

LOCK TABLES `pubsub_node_option` WRITE;
/*!40000 ALTER TABLE `pubsub_node_option` DISABLE KEYS */;
/*!40000 ALTER TABLE `pubsub_node_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pubsub_node_owner`
--

DROP TABLE IF EXISTS `pubsub_node_owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pubsub_node_owner` (
  `nodeid` bigint(20) DEFAULT NULL,
  `owner` text COLLATE utf8mb4_unicode_ci NOT NULL,
  KEY `i_pubsub_node_owner_nodeid` (`nodeid`),
  CONSTRAINT `pubsub_node_owner_ibfk_1` FOREIGN KEY (`nodeid`) REFERENCES `pubsub_node` (`nodeid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pubsub_node_owner`
--

LOCK TABLES `pubsub_node_owner` WRITE;
/*!40000 ALTER TABLE `pubsub_node_owner` DISABLE KEYS */;
/*!40000 ALTER TABLE `pubsub_node_owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pubsub_state`
--

DROP TABLE IF EXISTS `pubsub_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pubsub_state` (
  `nodeid` bigint(20) DEFAULT NULL,
  `jid` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `affiliation` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `subscriptions` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `stateid` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`stateid`),
  UNIQUE KEY `i_pubsub_state_tuple` (`nodeid`,`jid`(60)),
  KEY `i_pubsub_state_jid` (`jid`(60)),
  CONSTRAINT `pubsub_state_ibfk_1` FOREIGN KEY (`nodeid`) REFERENCES `pubsub_node` (`nodeid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pubsub_state`
--

LOCK TABLES `pubsub_state` WRITE;
/*!40000 ALTER TABLE `pubsub_state` DISABLE KEYS */;
/*!40000 ALTER TABLE `pubsub_state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pubsub_subscription_opt`
--

DROP TABLE IF EXISTS `pubsub_subscription_opt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pubsub_subscription_opt` (
  `subid` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `opt_name` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `opt_value` text COLLATE utf8mb4_unicode_ci NOT NULL,
  UNIQUE KEY `i_pubsub_subscription_opt` (`subid`(32),`opt_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pubsub_subscription_opt`
--

LOCK TABLES `pubsub_subscription_opt` WRITE;
/*!40000 ALTER TABLE `pubsub_subscription_opt` DISABLE KEYS */;
/*!40000 ALTER TABLE `pubsub_subscription_opt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `push_session`
--

DROP TABLE IF EXISTS `push_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `push_session` (
  `username` text NOT NULL,
  `timestamp` bigint(20) NOT NULL,
  `service` text NOT NULL,
  `node` text NOT NULL,
  `xml` text NOT NULL,
  UNIQUE KEY `i_push_usn` (`username`(191),`service`(191),`node`(191)),
  UNIQUE KEY `i_push_ut` (`username`(191),`timestamp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `push_session`
--

LOCK TABLES `push_session` WRITE;
/*!40000 ALTER TABLE `push_session` DISABLE KEYS */;
/*!40000 ALTER TABLE `push_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roster_version`
--

DROP TABLE IF EXISTS `roster_version`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roster_version` (
  `username` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `version` text COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roster_version`
--

LOCK TABLES `roster_version` WRITE;
/*!40000 ALTER TABLE `roster_version` DISABLE KEYS */;
/*!40000 ALTER TABLE `roster_version` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rostergroups`
--

DROP TABLE IF EXISTS `rostergroups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rostergroups` (
  `username` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `jid` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `grp` text COLLATE utf8mb4_unicode_ci NOT NULL,
  KEY `pk_rosterg_user_jid` (`username`(75),`jid`(75))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rostergroups`
--

LOCK TABLES `rostergroups` WRITE;
/*!40000 ALTER TABLE `rostergroups` DISABLE KEYS */;
INSERT INTO `rostergroups` VALUES ('andre','bob@j','def'),('bob','andre@j','def'),('test','bob@j','Friends');
/*!40000 ALTER TABLE `rostergroups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rosterusers`
--

DROP TABLE IF EXISTS `rosterusers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rosterusers` (
  `username` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `jid` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nick` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `subscription` char(1) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ask` char(1) COLLATE utf8mb4_unicode_ci NOT NULL,
  `askmessage` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `server` char(1) COLLATE utf8mb4_unicode_ci NOT NULL,
  `subscribe` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` text COLLATE utf8mb4_unicode_ci,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `i_rosteru_user_jid` (`username`(75),`jid`(75)),
  KEY `i_rosteru_username` (`username`),
  KEY `i_rosteru_jid` (`jid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rosterusers`
--

LOCK TABLES `rosterusers` WRITE;
/*!40000 ALTER TABLE `rosterusers` DISABLE KEYS */;
INSERT INTO `rosterusers` VALUES ('andre','bob@j','bob','N','N','','N','','item','2019-06-23 16:51:47'),('bob','andre@j','andre','N','N','','N','','item','2019-06-23 16:52:03'),('test','bob@j','bob','B','N','','N','','item','2019-06-23 18:01:03'),('bob','test@j','','B','N','','N','','item','2019-06-23 18:01:03');
/*!40000 ALTER TABLE `rosterusers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route` (
  `domain` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `server_host` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `node` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `pid` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `local_hint` text COLLATE utf8mb4_unicode_ci NOT NULL,
  UNIQUE KEY `i_route` (`domain`(75),`server_host`(75),`node`(75),`pid`(75)),
  KEY `i_route_domain` (`domain`(75))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sm`
--

DROP TABLE IF EXISTS `sm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sm` (
  `usec` bigint(20) NOT NULL,
  `pid` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `node` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `resource` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `priority` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `info` text COLLATE utf8mb4_unicode_ci NOT NULL,
  UNIQUE KEY `i_sid` (`usec`,`pid`(75)),
  KEY `i_node` (`node`(75)),
  KEY `i_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sm`
--

LOCK TABLES `sm` WRITE;
/*!40000 ALTER TABLE `sm` DISABLE KEYS */;
/*!40000 ALTER TABLE `sm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spool`
--

DROP TABLE IF EXISTS `spool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spool` (
  `username` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `xml` mediumtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `seq` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `seq` (`seq`),
  KEY `i_despool` (`username`) USING BTREE,
  KEY `i_spool_created_at` (`created_at`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spool`
--

LOCK TABLES `spool` WRITE;
/*!40000 ALTER TABLE `spool` DISABLE KEYS */;
INSERT INTO `spool` VALUES ('admin','<message xml:lang=\'en\' to=\'admin@J\' from=\'andre@J/Jabber\' type=\'chat\' xmlns=\'jabber:client\'><archived by=\'admin@J\' id=\'1561339498970201\' xmlns=\'urn:xmpp:mam:tmp\'/><stanza-id by=\'admin@J\' id=\'1561339498970201\' xmlns=\'urn:xmpp:sid:0\'/><delay from=\'j\' stamp=\'2019-06-24T01:24:59.019578Z\' xmlns=\'urn:xmpp:delay\'>Offline Storage</delay><body>to</body></message>',13,'2019-06-24 01:24:59'),('admin','<message xml:lang=\'en\' to=\'admin@J/J\' from=\'andre@J/Jabber\' type=\'chat\' xmlns=\'jabber:client\'><archived by=\'admin@J\' id=\'1561340392728455\' xmlns=\'urn:xmpp:mam:tmp\'/><stanza-id by=\'admin@J\' id=\'1561340392728455\' xmlns=\'urn:xmpp:sid:0\'/><delay from=\'j\' stamp=\'2019-06-24T01:39:52.730250Z\' xmlns=\'urn:xmpp:delay\'>Offline Storage</delay><body>to</body></message>',14,'2019-06-24 01:39:52'),('alice','<message xml:lang=\'en\' to=\'alice@J\' from=\'andre@J/Jabber\' type=\'chat\' xmlns=\'jabber:client\'><archived by=\'alice@J\' id=\'1561340414739146\' xmlns=\'urn:xmpp:mam:tmp\'/><stanza-id by=\'alice@J\' id=\'1561340414739146\' xmlns=\'urn:xmpp:sid:0\'/><delay from=\'j\' stamp=\'2019-06-24T01:40:14.741170Z\' xmlns=\'urn:xmpp:delay\'>Offline Storage</delay><body>to</body></message>',15,'2019-06-24 01:40:14'),('alice','<message xml:lang=\'en\' to=\'alice@J\' from=\'andre@J/Jabber\' type=\'chat\' xmlns=\'jabber:client\'><archived by=\'alice@J\' id=\'1561340443360448\' xmlns=\'urn:xmpp:mam:tmp\'/><stanza-id by=\'alice@J\' id=\'1561340443360448\' xmlns=\'urn:xmpp:sid:0\'/><delay from=\'j\' stamp=\'2019-06-24T01:40:43.361586Z\' xmlns=\'urn:xmpp:delay\'>Offline Storage</delay><body>hey alice</body></message>',16,'2019-06-24 01:40:43');
/*!40000 ALTER TABLE `spool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sr_group`
--

DROP TABLE IF EXISTS `sr_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sr_group` (
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `opts` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sr_group`
--

LOCK TABLES `sr_group` WRITE;
/*!40000 ALTER TABLE `sr_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `sr_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sr_user`
--

DROP TABLE IF EXISTS `sr_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sr_user` (
  `jid` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `grp` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `i_sr_user_jid_group` (`jid`(75),`grp`(75)),
  KEY `i_sr_user_jid` (`jid`),
  KEY `i_sr_user_grp` (`grp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sr_user`
--

LOCK TABLES `sr_user` WRITE;
/*!40000 ALTER TABLE `sr_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `sr_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `serverkey` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `salt` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `iterationcount` int(11) NOT NULL DEFAULT '0',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('3175433272470683','93f77411-77ba-4343-aefe-369dd4ed1212','','',0,'2019-06-23 22:26:59'),('admin','pass','','',0,'2019-06-23 15:02:41'),('admin1','pass','','',0,'2019-06-23 15:03:17'),('alice','pass','','',0,'2019-06-23 22:09:21'),('andre','pass','','',0,'2019-06-23 15:04:27'),('bob','pass','','',0,'2019-06-23 15:18:16'),('test','pass','','',0,'2019-06-23 16:49:17'),('testuser','passw0rd','','',0,'2019-06-23 15:02:22');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vcard`
--

DROP TABLE IF EXISTS `vcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vcard` (
  `username` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `vcard` mediumtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vcard`
--

LOCK TABLES `vcard` WRITE;
/*!40000 ALTER TABLE `vcard` DISABLE KEYS */;
/*!40000 ALTER TABLE `vcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vcard_search`
--

DROP TABLE IF EXISTS `vcard_search`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vcard_search` (
  `username` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `lusername` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fn` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `lfn` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `family` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `lfamily` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `given` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `lgiven` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `middle` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `lmiddle` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nickname` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `lnickname` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `bday` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `lbday` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ctry` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `lctry` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `locality` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `llocality` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `lemail` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `orgname` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `lorgname` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `orgunit` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `lorgunit` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`lusername`),
  KEY `i_vcard_search_lfn` (`lfn`),
  KEY `i_vcard_search_lfamily` (`lfamily`),
  KEY `i_vcard_search_lgiven` (`lgiven`),
  KEY `i_vcard_search_lmiddle` (`lmiddle`),
  KEY `i_vcard_search_lnickname` (`lnickname`),
  KEY `i_vcard_search_lbday` (`lbday`),
  KEY `i_vcard_search_lctry` (`lctry`),
  KEY `i_vcard_search_llocality` (`llocality`),
  KEY `i_vcard_search_lemail` (`lemail`),
  KEY `i_vcard_search_lorgname` (`lorgname`),
  KEY `i_vcard_search_lorgunit` (`lorgunit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vcard_search`
--

LOCK TABLES `vcard_search` WRITE;
/*!40000 ALTER TABLE `vcard_search` DISABLE KEYS */;
/*!40000 ALTER TABLE `vcard_search` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-05 16:35:31
