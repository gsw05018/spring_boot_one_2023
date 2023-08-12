/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 10.4.28-MariaDB : Database - hic_spring_boot
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hic_spring_boot` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `hic_spring_boot`;

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '번호',
  `regDate` datetime NOT NULL COMMENT '작성날짜',
  `updateDate` datetime NOT NULL COMMENT '수정날짜',
  `boardId` int(10) unsigned NOT NULL COMMENT '게시판번호',
  `memberId` int(10) unsigned NOT NULL COMMENT '회원번호',
  `title` char(100) NOT NULL COMMENT '제목',
  `body` text NOT NULL COMMENT '본문',
  `blindStatus` tinyint(1) unsigned NOT NULL DEFAULT 0 COMMENT '블라인드여부',
  `blindDate` datetime DEFAULT NULL COMMENT '블라인드날짜',
  `delStatus` tinyint(1) unsigned NOT NULL DEFAULT 0 COMMENT '삭제여부',
  `delDate` datetime DEFAULT NULL COMMENT '삭제날짜',
  `hitCount` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '조회수',
  `repliesCount` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '댓글수',
  `likeCount` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '좋아요수',
  `dislikeCount` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '싫어요수',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `article` */

insert  into `article`(`id`,`regDate`,`updateDate`,`boardId`,`memberId`,`title`,`body`,`blindStatus`,`blindDate`,`delStatus`,`delDate`,`hitCount`,`repliesCount`,`likeCount`,`dislikeCount`) values 
(1,'2023-08-13 00:24:19','2023-08-13 00:24:19',1,1,'제목1','본문1',0,NULL,0,NULL,0,0,0,0),
(2,'2023-08-13 00:24:19','2023-08-13 00:24:19',1,1,'제목2','본문2',0,NULL,0,NULL,0,0,0,0),
(3,'2023-08-13 00:24:19','2023-08-13 00:24:19',1,1,'제목3','본문3',0,NULL,0,NULL,0,0,0,0),
(4,'2023-08-13 00:24:19','2023-08-13 00:24:19',1,2,'제목4','본문4',0,NULL,0,NULL,0,0,0,0),
(5,'2023-08-13 00:24:19','2023-08-13 00:24:19',2,2,'제목5','본문5',0,NULL,0,NULL,0,0,0,0),
(6,'2023-08-13 00:24:19','2023-08-13 00:24:19',2,2,'제목6','본문6',0,NULL,0,NULL,0,0,0,0),
(7,'2023-08-13 00:30:33','2023-08-13 00:30:33',1,1,'한인철','선풍기',0,NULL,0,NULL,0,0,0,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
