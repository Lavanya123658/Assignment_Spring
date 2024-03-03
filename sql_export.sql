-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: leavetrackingsystem
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Temporary view structure for view `employee_leave_summary`
--

DROP TABLE IF EXISTS `employee_leave_summary`;
/*!50001 DROP VIEW IF EXISTS `employee_leave_summary`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `employee_leave_summary` AS SELECT 
 1 AS `serial_no`,
 1 AS `name`,
 1 AS `leaves_approved`,
 1 AS `leaves_pending`,
 1 AS `leaves_rejected`,
 1 AS `leaves_remaining`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `leave`
--

DROP TABLE IF EXISTS `leave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leave` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `user_id` int NOT NULL,
  `manager_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp9lbddftjjtagpp9bwkpbqyk3` (`manager_id`),
  CONSTRAINT `FKp9lbddftjjtagpp9bwkpbqyk3` FOREIGN KEY (`manager_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave`
--

LOCK TABLES `leave` WRITE;
/*!40000 ALTER TABLE `leave` DISABLE KEYS */;
INSERT INTO `leave` VALUES (1,'Take Care','2024-07-04 05:30:00.000000','Typhoid','2024-06-29 05:30:00.000000','APPROVED','Sick',2,NULL),(2,'Stay safe','2024-07-04 05:30:00.000000','Vacation','2024-06-29 05:30:00.000000','APPROVED','Personal',2,4),(3,'Stay safe','2024-07-04 05:30:00.000000','Vacation','2024-06-29 05:30:00.000000','APPROVED','Personal',3,4),(4,'Stay safe','2024-07-04 05:30:00.000000','Vacation','2024-06-29 05:30:00.000000','APPROVED','Personal',3,1),(5,'Stay safe','2024-07-04 05:30:00.000000','Vacation','2024-06-29 05:30:00.000000','APPROVED','Personal',3,1),(6,'Stay safe','2024-07-04 05:30:00.000000','Vacation','2024-06-29 05:30:00.000000','APPROVED','Personal',12,11),(7,NULL,'2024-07-04 05:30:00.000000','Vacation','2024-06-29 05:30:00.000000','Pending','Personal',12,NULL),(8,NULL,'2024-07-04 05:30:00.000000','Vacation','2024-07-01 05:30:00.000000','Pending','Personal',19,NULL),(9,'Stay safe','2024-07-20 05:30:00.000000','Vacation','2024-07-10 05:30:00.000000','APPROVED','Personal',21,20);
/*!40000 ALTER TABLE `leave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `leave_summary`
--

DROP TABLE IF EXISTS `leave_summary`;
/*!50001 DROP VIEW IF EXISTS `leave_summary`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `leave_summary` AS SELECT 
 1 AS `serial_no`,
 1 AS `name`,
 1 AS `leaves_approved`,
 1 AS `leaves_pending`,
 1 AS `leaves_rejected`,
 1 AS `leaves_remaining`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `leave_summary_filtered`
--

DROP TABLE IF EXISTS `leave_summary_filtered`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leave_summary_filtered` (
  `serial_no` bigint NOT NULL AUTO_INCREMENT,
  `leaves_approved` int NOT NULL,
  `leaves_pending` int NOT NULL,
  `leaves_rejected` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`serial_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leave_summary_filtered`
--

LOCK TABLES `leave_summary_filtered` WRITE;
/*!40000 ALTER TABLE `leave_summary_filtered` DISABLE KEYS */;
/*!40000 ALTER TABLE `leave_summary_filtered` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `leave_summary_filtered_view`
--

DROP TABLE IF EXISTS `leave_summary_filtered_view`;
/*!50001 DROP VIEW IF EXISTS `leave_summary_filtered_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `leave_summary_filtered_view` AS SELECT 
 1 AS `serial_no`,
 1 AS `name`,
 1 AS `leaves_approved`,
 1 AS `leaves_pending`,
 1 AS `leaves_rejected`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `settings`
--

DROP TABLE IF EXISTS `settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `settings` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `max_leaves` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settings`
--

LOCK TABLES `settings` WRITE;
/*!40000 ALTER TABLE `settings` DISABLE KEYS */;
INSERT INTO `settings` VALUES (73,4,'Sick'),(74,6,'Casual'),(75,3,'Personal'),(76,6,'Earned');
/*!40000 ALTER TABLE `settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_of_joining` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `personal_email` varchar(255) DEFAULT NULL,
  `role` enum('MANAGER','EMPLOYEE') DEFAULT NULL,
  `manager_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl9blkgio1nb00hot7kaxoy7q9` (`manager_id`),
  CONSTRAINT `FKl9blkgio1nb00hot7kaxoy7q9` FOREIGN KEY (`manager_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2024-06-24 05:30:00.000000','amalak@gmail.com','9997998779','Amala G','$2a$10$oKAhD3Zlo3.cb/zMc89ZMeWWKnGTSTh79r9p/pPPfc4pK2YZqniui','amalag@gmail.com','EMPLOYEE',1),(2,'2024-06-24 05:30:00.000000','ajay@gmail.com','9997998779','Ajay G','$2a$10$Nmhmi0mS7td6FwGjvJlcpufxNuopshWPrhc.uEy0ZY96gY72wAAI2','ajayg@gmail.com','EMPLOYEE',1),(3,'2024-06-24 05:30:00.000000','amala@gmail.com','9997998779','Amala G','$2a$10$MdThPzRjeA50sOmnpr6FM.eJ3aQNuW6KSA3M2bswYGylTGnGR4CCy','amalag@gmail.com','EMPLOYEE',1),(4,'2024-06-24 05:30:00.000000','amalal@gmail.com','9997998779','Amala G','$2a$10$3UUs0jHu.q2VtYBzn1abeuQM0IMD3ojGUtR8upW4H2sYN9EyhlMmm','amalag@gmail.com','EMPLOYEE',4),(5,'2024-06-24 05:30:00.000000','amalaml@gmail.com','9997998779','Amala G','$2a$10$LZX.d9TUfO51OwyP43OAtuAEomNMx3Uv1YzlHNzj0AciI4hspx2mm','amalag@gmail.com','EMPLOYEE',5),(6,'2024-06-24 05:30:00.000000','amalalml@gmail.com','9997998779','Amala G','$2a$10$vC.uIBKsopxmSTTvRgSOM.ictYqppSBFxJq5mO8DhoKSeA1Jk69Wm','amalag@gmail.com','EMPLOYEE',6),(7,'2024-06-24 05:30:00.000000','amalalmkl@gmail.com','9997998779','Amala G','$2a$10$ZTS4yANHCssAP/sjDAtpZu9l2BOCjQ8dovOHM0DT92zNRvhoK7L0q','amalag@gmail.com','EMPLOYEE',7),(8,'2024-06-24 05:30:00.000000','am@gmail.com','9997998779','Amala G','$2a$10$0C3ejGYqjOxptv.n9yTSTepwTMcotflz60nAMmDeo.VECE5gNQyjW','amalag@gmail.com','EMPLOYEE',8),(9,'2024-03-01 05:30:00.000000','arjun@gmail.com','9997998779','Arjun G','$2a$10$5pG4hE9HV9yFrYZAh8MuheN5uc0niWXGD/F9Bb8.2/fyF2854PejG','arjung@gmail.com','MANAGER',NULL),(10,'2024-06-24 05:30:00.000000','am1@gmail.com','9997998779','Amala G','$2a$10$tCj4HZQQLDQDRIBGbYrWSede7ZJgA7MoAHwktGrUwp7sM12K/HY/m','amalag@gmail.com','EMPLOYEE',9),(11,'2024-03-01 05:30:00.000000','rekha@gmail.com','9997998779','Rekha Korepu','$2a$10$hPbYW9eoSuY25VI/SdOxa.Hwe4SqAmRgYFUQZGSHJE.UoI9G5Smc.','rekhakorepu@gmail.com','MANAGER',NULL),(12,'2024-06-24 05:30:00.000000','rahul@gmail.com','9997998779','Rahul','$2a$10$Z3IqFnBYYXUceRyXqprbxu/5KWjvfibWrbs..1OHHCsFCsc0.0BLC','amalag@gmail.com','EMPLOYEE',11),(13,'2024-03-01 05:30:00.000000','varun@gmail.com','9856741232','Varun','$2a$10$fjky2cPYJ5PPdNi8EahLGOn58zs0EbdiagD2d/vfa41b1oeSAvYXO','varun@gmail.com','MANAGER',NULL),(14,'2023-02-28 05:30:00.000000','anuhya@gmail.com','9856741232','Anuhya','$2a$10$NrEEESZP55IcwduqUwzuruXEXqug3iIm2b4/2dFWkoUmShmi9.zwa','anuhya@gmail.com','MANAGER',NULL),(15,'2022-08-09 05:30:00.000000','sailu@gmail.com','9876543210','Sailu','$2a$10$xDUZQztpCGZJ60kE62Tkg.xxwxm869kOMoQVTmB6GoeM/ypGMJPa6','sailu123@gmail.com','MANAGER',NULL),(16,'2024-03-01 05:30:00.000000','aesh@gmail.com','9856741232','Ayesha','$2a$10$aid.u7DpXAN2kU982p2N3.YmSIrQmC9TG7j1KPDs3dgaIp.Edbn2K','ay@gmail.com','MANAGER',NULL),(17,'2024-03-01 05:30:00.000000','s@gmail.com','9856741232','Sowmya','$2a$10$MQF0p2e0Omfm2IiqWUyRV.NTL6/ZJlyxiHk5mMkdAvmZ8uhUcQ1LC','sowmya@gmail.com','EMPLOYEE',15),(18,'2024-03-01 05:30:00.000000','vaishali@gmail.com','9856741232','vaishali','$2a$10$6mVkOeH3EipKcAVQEX.kheDRmRLdM6L/68bJtNeOu6B/7GgIwWwRq','vaishali@gmail.com','MANAGER',NULL),(19,'2024-03-01 05:30:00.000000','Renuka@gmail.com','9856741232','Renuka','$2a$10$ElI1YgNmrpweXd2wFQ36q.17/PSqEMjw9DAq/5cxBq9IFgXh0qGfq','Renuka@gmail.com','EMPLOYEE',13),(20,'2024-03-01 05:30:00.000000','lavanya@gmail.com','9856741232','Lavanya','$2a$10$NLcNK5COvqZt1/RR4NbOAOFUOpB5loebmiNrMJnTBgpG.rPB2EPS.','lavanya@gmail.com','MANAGER',NULL),(21,'2024-03-03 05:30:00.000000','mouni@gmail.com','9856741232','Mounika','$2a$10$ARsLIyzQbsk3URYHT8FJE.eEeOUe6YDcX1kl9.fl5cEl3fj/RPMg.','mouni@gmail.com','EMPLOYEE',20);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `employee_leave_summary`
--

/*!50001 DROP VIEW IF EXISTS `employee_leave_summary`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `employee_leave_summary` AS select row_number() OVER ()  AS `serial_no`,`u`.`name` AS `name`,sum((case when (`l`.`status` = 'APPROVED') then 1 else 0 end)) AS `leaves_approved`,sum((case when (`l`.`status` = 'PENDING') then 1 else 0 end)) AS `leaves_pending`,sum((case when (`l`.`status` = 'REJECTED') then 1 else 0 end)) AS `leaves_rejected`,((((select sum(`settings`.`max_leaves`) from `settings`) - sum((case when (`l`.`status` = 'APPROVED') then 1 else 0 end))) - sum((case when (`l`.`status` = 'PENDING') then 1 else 0 end))) - sum((case when (`l`.`status` = 'REJECTED') then 1 else 0 end))) AS `leaves_remaining` from (`leave` `l` join `user` `u` on((`l`.`user_id` = `u`.`id`))) group by `u`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `leave_summary`
--

/*!50001 DROP VIEW IF EXISTS `leave_summary`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `leave_summary` AS select row_number() OVER ()  AS `serial_no`,`u`.`name` AS `name`,sum((case when (`l`.`status` = 'APPROVED') then 1 else 0 end)) AS `leaves_approved`,sum((case when (`l`.`status` = 'PENDING') then 1 else 0 end)) AS `leaves_pending`,sum((case when (`l`.`status` = 'REJECTED') then 1 else 0 end)) AS `leaves_rejected`,((((select sum(`settings`.`max_leaves`) from `settings`) - sum((case when (`l`.`status` = 'APPROVED') then 1 else 0 end))) - sum((case when (`l`.`status` = 'PENDING') then 1 else 0 end))) - sum((case when (`l`.`status` = 'REJECTED') then 1 else 0 end))) AS `leaves_remaining` from (`leave` `l` join `user` `u` on((`l`.`user_id` = `u`.`id`))) group by `u`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `leave_summary_filtered_view`
--

/*!50001 DROP VIEW IF EXISTS `leave_summary_filtered_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `leave_summary_filtered_view` AS select row_number() OVER ()  AS `serial_no`,`u`.`name` AS `name`,sum((case when (`l`.`status` = 'APPROVED') then 1 else 0 end)) AS `leaves_approved`,sum((case when (`l`.`status` = 'PENDING') then 1 else 0 end)) AS `leaves_pending`,sum((case when (`l`.`status` = 'REJECTED') then 1 else 0 end)) AS `leaves_rejected` from (`leave` `l` join `user` `u` on((`l`.`user_id` = `u`.`id`))) where ((`l`.`start_date` between '2024-06-30' and '2024-07-05') and (`l`.`end_date` <= '2024-07-05')) group by `u`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-03 16:36:22
