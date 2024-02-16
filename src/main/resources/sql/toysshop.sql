# DB作成
CREATE DATABASE toysshopdb;

USE toysshopdb;

# adminsテーブル作成
CREATE TABLE `admins` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `userId` varchar(20) NOT NULL,
  `pass` varchar(60) NOT NULL,
  `type` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userId_UNIQUE` (`userId`)
);

# adminsテーブル、データ追加
INSERT INTO `admins` 
VALUES (1,'山田 太郎','taro@abc.com','$2a$08$4EqTe.iSHTtefvuygHjUS..j2NV0dWKUNr7IIHxVbpux4A/GczWtC',1),
(2,'伊藤 次郎','jiro@abc.com','$2a$08$RLd5TyHIlmqvy3YvwxE1K.zZYkBJfd20ail94AHbM55CWNAPahnFa',2),
(3,'田中 三郎','saburo@abc.com','$2a$08$gx2Vd3W/1Kf1NCU2Su174OHItSJ0wHWacjUGrG3W2sXmHPCqMs1gC',2);

# itemsテーブル作成
CREATE TABLE `items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `price` varchar(10) NOT NULL,
  `descript` varchar(300) NOT NULL,
  `pict` varchar(300) DEFAULT NULL,
  `created` datetime NOT NULL,
  `buyer` varchar(20) NOT NULL DEFAULT 'none',
  `purchase` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ;

# itemsテーブル、データ追加
INSERT INTO `items` 
VALUES (1,'商品A','389','これは商品Aです','tomica.jpg','ACT','2024-02-06 16:31:59','none',0),
(2,'商品B','5690','これは商品Bです','lego.jpg','2024-02-06 17:43:57','none',0),
(3,'商品C','10000','これは商品Cです','ラジコン.jpg','2024-02-06 17:44:53','none',0),
(4,'商品D','1000','これは商品Dです',NULL,'2024-02-13 00:00:00','none',0),
(5,'商品E','3890','これは商品Eです',NULL,'2024-02-13 00:00:00','none',0),
(6,'商品F','380','これは商品Fです',NULL,'2024-02-13 00:00:00','none',0),
(7,'商品G','150','これは商品Gです',NULL,'2024-02-13 00:00:00','none',0);