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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `article` */

insert  into `article`(`id`,`regDate`,`updateDate`,`boardId`,`memberId`,`title`,`body`,`blindStatus`,`blindDate`,`delStatus`,`delDate`,`hitCount`,`repliesCount`,`likeCount`,`dislikeCount`) values 
(1,'2023-08-20 15:46:31','2023-08-20 15:46:31',1,1,'바보','내용',0,NULL,0,NULL,0,0,0,0),
(2,'2023-08-20 15:46:31','2023-08-20 15:46:31',1,1,'제목1','내용1',0,NULL,0,NULL,0,0,0,0),
(3,'2023-08-20 15:46:31','2023-08-20 15:46:31',1,1,'제목2','본문2',0,NULL,0,NULL,0,0,0,0),
(4,'2023-08-20 15:46:31','2023-08-20 15:46:31',1,1,'제목3','본문3',0,NULL,0,NULL,0,0,0,0),
(5,'2023-08-20 15:46:31','2023-08-20 15:46:31',1,2,'제목4','본문4',0,NULL,0,NULL,0,0,0,0),
(6,'2023-08-20 15:46:31','2023-08-20 15:46:31',2,2,'제목5','본문5',0,NULL,0,NULL,0,0,0,0),
(7,'2023-08-20 15:46:31','2023-08-20 15:46:31',2,2,'제목6','본문6',0,NULL,0,NULL,0,0,0,0);

/*Table structure for table `board` */

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '번호',
  `regDate` datetime NOT NULL COMMENT '작성날짜',
  `updateDate` datetime NOT NULL COMMENT '수정날짜',
  `name` char(20) NOT NULL COMMENT '이름',
  `code` char(20) NOT NULL COMMENT '코드',
  `blindStatus` tinyint(1) unsigned NOT NULL DEFAULT 0 COMMENT '블라인드여부',
  `blindDate` datetime DEFAULT NULL COMMENT '블라인드날짜',
  `delStatus` tinyint(1) unsigned NOT NULL DEFAULT 0 COMMENT '삭제여부',
  `delDate` datetime DEFAULT NULL COMMENT '삭제날짜',
  `hitCount` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '조회수',
  `repliesCount` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '댓글수',
  `likeCount` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '좋아요수',
  `dislikeCount` int(10) unsigned NOT NULL DEFAULT 0 COMMENT '싫어요수',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `board` */

insert  into `board`(`id`,`regDate`,`updateDate`,`name`,`code`,`blindStatus`,`blindDate`,`delStatus`,`delDate`,`hitCount`,`repliesCount`,`likeCount`,`dislikeCount`) values 
(1,'2023-08-20 15:49:10','2023-08-20 15:49:10','공지사항','notice',0,NULL,0,NULL,0,0,0,0),
(2,'2023-08-20 15:49:10','2023-08-20 15:49:10','자유','free',0,NULL,0,NULL,0,0,0,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
