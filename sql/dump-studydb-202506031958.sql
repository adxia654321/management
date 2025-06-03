-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: studydb
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `clazz`
--

DROP TABLE IF EXISTS `clazz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clazz` (
  `id` int NOT NULL AUTO_INCREMENT,
  `begin_date` date DEFAULT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `master_id` int DEFAULT NULL,
  `master_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `room` varchar(255) DEFAULT NULL,
  `subject` int DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clazz`
--

LOCK TABLES `clazz` WRITE;
/*!40000 ALTER TABLE `clazz` DISABLE KEYS */;
INSERT INTO `clazz` VALUES (1,'2025-02-02','2025-05-23 10:00:00.000000','2026-01-01',1,'陳曦','Java 全端班 第一期','305 ',1,'2025-05-23 10:00:00.000000'),(2,'2025-02-02','2024-08-20 09:30:00.000000','2026-01-01',6,'林墨','資料工程班 第二期','204 ',2,'2025-03-15 18:00:00.000000');
/*!40000 ALTER TABLE `clazz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dept`
--

DROP TABLE IF EXISTS `dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dept` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID，主鍵',
  `name` varchar(10) NOT NULL COMMENT '部門名稱',
  `create_time` datetime DEFAULT NULL COMMENT '建立時間',
  `update_time` datetime DEFAULT NULL COMMENT '修改時間',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='部門表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dept`
--

LOCK TABLES `dept` WRITE;
/*!40000 ALTER TABLE `dept` DISABLE KEYS */;
INSERT INTO `dept` VALUES (1,'人事部','2025-05-10 15:43:47','2025-05-10 15:43:47'),(2,'財務部','2025-05-10 15:43:47','2025-05-10 15:43:47'),(3,'研發部','2025-05-10 15:43:47','2025-05-10 15:43:47'),(4,'行銷部','2025-05-10 15:43:47','2025-05-10 15:43:47'),(6,'666','2025-05-28 21:30:08','2025-05-28 21:30:08');
/*!40000 ALTER TABLE `dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID，主鍵',
  `username` varchar(20) NOT NULL COMMENT '使用者名稱',
  `password` varchar(32) DEFAULT '123456' COMMENT '密碼',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `gender` tinyint unsigned NOT NULL COMMENT '性別，1:男，2:女',
  `phone` char(10) NOT NULL COMMENT '手機號碼（台灣格式，例如：0912345678）',
  `job` tinyint unsigned DEFAULT NULL COMMENT '職位，1 班主任，2 講師，3 學工主管，4 教研主管，5 諮詢師',
  `salary` int unsigned DEFAULT NULL COMMENT '薪資',
  `image` varchar(255) DEFAULT NULL COMMENT '頭像',
  `entry_date` date DEFAULT NULL COMMENT '入職日期',
  `dept_id` int unsigned DEFAULT NULL COMMENT '部門ID',
  `create_time` datetime DEFAULT NULL COMMENT '建立時間',
  `update_time` datetime DEFAULT NULL COMMENT '修改時間',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='員工表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES (1,'user01','pw001','陳曦',1,'0910000001',1,48000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2022-03-10',1,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(2,'user02','pw002','陳璇',2,'0910000002',2,47000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2022-06-15',2,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(3,'user03','pw003','陳翰',1,'0910000003',3,49000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2023-01-05',3,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(4,'user04','pw004','陳琛',2,'0910000004',4,51000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2023-04-20',1,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(5,'user05','pw005','陳瀾',1,'0910000005',5,50000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2022-11-11',2,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(6,'user06','pw006','林墨',2,'0910000006',1,52000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2023-06-01',3,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(7,'user07','pw007','林曦',1,'0910000007',2,47000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2022-02-12',1,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(8,'user08','pw008','林韻',2,'0910000008',3,45000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2022-10-10',2,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(9,'user09','pw009','林瑜',1,'0910000009',4,48000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2023-12-01',3,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(10,'user10','pw010','林瑤',2,'0910000010',5,53000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2023-08-22',1,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(11,'user11','pw011','張嵐',1,'0910000011',1,49000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2023-05-18',2,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(12,'user12','pw012','張辰',2,'0910000012',2,46000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2022-09-30',3,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(13,'user13','pw013','張昊',1,'0910000013',3,47000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2023-03-07',1,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(14,'user14','pw014','張澤',2,'0910000014',4,51000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2024-01-01',2,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(15,'user15','pw015','張冉',1,'0910000015',5,52000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2023-11-23',3,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(16,'user16','pw016','李雲',2,'0910000016',1,48000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2022-07-19',1,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(17,'user17','pw017','李暘',1,'0910000017',2,49000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2023-02-02',2,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(18,'user18','pw018','李晨',2,'0910000018',3,53000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2022-05-25',3,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(19,'user19','pw019','李川',1,'0910000019',4,50000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2023-07-14',1,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(20,'user20','pw020','李瑾',2,'0910000020',5,51000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2022-01-20',2,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(21,'user21','pw021','王天',1,'0910000021',1,47000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2023-06-28',3,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(22,'user22','pw022','王羽',2,'0910000022',2,49000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2022-08-08',1,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(23,'user23','pw023','王嶽',1,'0910000023',3,52000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2022-12-31',2,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(24,'user24','pw024','王昊',2,'0910000024',4,48000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2023-10-03',3,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(25,'user25','pw025','王川',1,'0910000025',5,50000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2022-06-06',1,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(26,'user26','pw026','黃宇',2,'0910000026',1,51000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2023-09-12',2,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(27,'user27','pw027','黃清',1,'0910000027',2,45000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2024-02-14',3,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(28,'user28','pw028','黃靜',2,'0910000028',3,47000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2023-05-04',1,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(29,'user29','pw029','黃澄',1,'0910000029',4,48000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2022-04-04',2,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(30,'user30','pw030','黃星',2,'0910000030',5,53000,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2023-03-17',3,'2025-05-10 15:47:49','2025-05-10 15:47:49'),(31,'user3166','123456789','林林',1,'0922345663',1,NULL,'https://i.ibb.co/mCMKtxnF/DORO-2.webp','2020-01-01',1,'2025-05-13 00:00:00','2025-05-20 20:29:41');
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_expr`
--

DROP TABLE IF EXISTS `emp_expr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_expr` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID，主鍵',
  `begin` date DEFAULT NULL COMMENT '開始時間',
  `end` date DEFAULT NULL COMMENT '結束時間',
  `company` varchar(50) DEFAULT NULL COMMENT '公司名稱',
  `job` varchar(50) DEFAULT NULL COMMENT '職位',
  `emp_id` int unsigned DEFAULT NULL COMMENT '對應的員工ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='工作經歷表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_expr`
--

LOCK TABLES `emp_expr` WRITE;
/*!40000 ALTER TABLE `emp_expr` DISABLE KEYS */;
INSERT INTO `emp_expr` VALUES (15,'2025-05-13','2025-05-14','瓜皮','java開發',31),(16,'2024-05-13','2025-05-14','mo','java開發',31);
/*!40000 ALTER TABLE `emp_expr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_log`
--

DROP TABLE IF EXISTS `emp_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_log` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID，主鍵',
  `operate_time` datetime DEFAULT NULL COMMENT '操作時間',
  `info` varchar(2000) DEFAULT NULL COMMENT '日誌信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='員工日誌表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_log`
--

LOCK TABLES `emp_log` WRITE;
/*!40000 ALTER TABLE `emp_log` DISABLE KEYS */;
INSERT INTO `emp_log` VALUES (4,'2025-05-18 09:46:56','新增員工Emp(id=36, username=Teviw, password=null, name=陳幂, gender=1, image=https://i.ibb.co/mCMKtxnF/DORO-2.webp, salary=8000, job=1, entryDate=2022-09-18, deptId=1, phone=922433556, createTime=2025-05-18T09:46:55.750139600, updateTime=2025-05-18T09:46:55.750139600, deptName=null, exprList=[EmpExpr(id=null, empId=36, begin=2012-07-01, end=2019-03-03, company=google, job=java開發), EmpExpr(id=null, empId=36, begin=2019-03-15, end=2023-03-01, company=亞馬遜, job=架構師)])'),(6,'2025-05-18 10:00:23','新增員工Emp(id=38, username=Te, password=null, name=陳陳, gender=1, image=https://i.ibb.co/mCMKtxnF/DORO-2.webp, salary=8000, job=1, entryDate=2022-09-18, deptId=1, phone=922433557, createTime=2025-05-18T10:00:22.947473700, updateTime=2025-05-18T10:00:22.947473700, deptName=null, exprList=[EmpExpr(id=null, empId=null, begin=2012-07-01, end=2019-03-03, company=google, job=java開發), EmpExpr(id=null, empId=null, begin=2019-03-15, end=2023-03-01, company=亞馬遜, job=架構師)])'),(7,'2025-05-20 20:30:47','新增員工Emp(id=null, username=ww, password=null, name=ww, gender=1, image=, salary=null, job=2, entryDate=null, deptId=1, phone=null, createTime=2025-05-20T20:30:46.537932500, updateTime=2025-05-20T20:30:46.537932500, deptName=null, exprList=null)'),(8,'2025-05-20 20:31:00','新增員工Emp(id=null, username=ww, password=null, name=ww, gender=1, image=, salary=null, job=2, entryDate=null, deptId=1, phone=null, createTime=2025-05-20T20:30:59.805763, updateTime=2025-05-20T20:30:59.805763, deptName=null, exprList=null)'),(9,'2025-05-20 20:40:29','新增員工Emp(id=null, username=ww, password=null, name=ww, gender=1, image=, salary=null, job=1, entryDate=null, deptId=1, phone=null, createTime=2025-05-20T20:40:28.033982700, updateTime=2025-05-20T20:40:28.033982700, deptName=null, exprList=null)'),(10,'2025-05-20 20:41:11','新增員工Emp(id=null, username=ww, password=null, name=ww, gender=1, image=, salary=null, job=1, entryDate=null, deptId=1, phone=null, createTime=2025-05-20T20:41:10.487176800, updateTime=2025-05-20T20:41:10.487176800, deptName=null, exprList=null)');
/*!40000 ALTER TABLE `emp_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operate_log`
--

DROP TABLE IF EXISTS `operate_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operate_log` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `operate_emp_id` int unsigned DEFAULT NULL COMMENT '操作人ID',
  `operate_time` datetime DEFAULT NULL COMMENT '操作時間',
  `class_name` varchar(100) DEFAULT NULL COMMENT '操作的類名',
  `method_name` varchar(100) DEFAULT NULL COMMENT '操作的方法名',
  `method_params` varchar(2000) DEFAULT NULL COMMENT '方法參數',
  `return_value` varchar(2000) DEFAULT NULL COMMENT '回傳值',
  `cost_time` bigint unsigned DEFAULT NULL COMMENT '方法執行耗時，單位:毫秒',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='操作日誌表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operate_log`
--

LOCK TABLES `operate_log` WRITE;
/*!40000 ALTER TABLE `operate_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `operate_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID,主鍵',
  `name` varchar(255) DEFAULT NULL,
  `no` varchar(255) DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `degree` int DEFAULT NULL,
  `graduation_date` date DEFAULT NULL COMMENT '畢業時間',
  `clazz_id` int unsigned NOT NULL COMMENT '班級ID, 關聯班級表ID',
  `violation_count` smallint DEFAULT NULL,
  `violation_score` smallint DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '創建時間',
  `update_time` datetime DEFAULT NULL COMMENT '修改時間',
  PRIMARY KEY (`id`),
  UNIQUE KEY `phone` (`phone`),
  UNIQUE KEY `no` (`no`),
  UNIQUE KEY `id_card` (`id_card`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='學員表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'洛晨','S000000004',1,'0922322444','F130299333','基隆市樂利三街',5,'2020-07-01',2,1,2,'2025-05-23 15:17:46','2025-05-23 16:31:06'),(2,'陳大文','S000000001',1,'0912345678','A123456789','台北市信義區市府路1號',4,'2022-06-30',2,0,0,'2025-05-23 15:18:00','2025-05-23 15:18:00');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'studydb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-03 19:58:21
