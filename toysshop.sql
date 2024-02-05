# DB作成
CREATE SCHEMA `toysshopdb` ;
use `toysshopdb` ;

# adminsテーブル作成
CREATE TABLE `toysshopdb`.`admins` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `userId` VARCHAR(20) NOT NULL,
  `pass` VARCHAR(60) NOT NULL,
  `type` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `userId_UNIQUE` (`userId` ASC) VISIBLE);
  
# adminsテーブルデータ作成
INSERT INTO `toysshopdb`.`admins` (`id`, `name`, `userId`, `pass`, `type`) VALUES ('1', '山田 太郎', 'taro@abc.com', '$2a$08$4EqTe.iSHTtefvuygHjUS..j2NV0dWKUNr7IIHxVbpux4A/GczWtC', '1');
INSERT INTO `toysshopdb`.`admins` (`id`, `name`, `userId`, `pass`, `type`) VALUES ('2', '伊藤 次郎', 'jiro@abc.com', '$2a$08$RLd5TyHIlmqvy3YvwxE1K.zZYkBJfd20ail94AHbM55CWNAPahnFa', '2');

# itemsテーブルデータ作成
CREATE TABLE `toysshopdb`.`items` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(10) NOT NULL,
  `price` VARCHAR(10) NOT NULL,
  `descript` VARCHAR(300) NOT NULL,
  `pict` VARCHAR(300) NULL,
  `status` CHAR(3) NOT NULL DEFAULT 'ACT',
  `created` DATETIME NOT NULL,
  PRIMARY KEY (`id`));

# itemsテーブルデータ作成
INSERT INTO `toysshopdb`.`items` (`id`, `name`, `price`, `descript`, `status`, `created`) VALUES ('1', '商品A', '380', 'これは商品Aです', 'ACT', '2024-02-02 00:00:00');
INSERT INTO `toysshopdb`.`items` (`id`, `name`, `price`, `descript`, `status`, `created`) VALUES ('2', '商品B', '2,980', 'これは商品Bです', 'ACT', '2024-02-02 00:00:00');

# historysテーブル作成
CREATE TABLE `toysshopdb`.`historys` (
  `userId` INT NOT NULL,
  `itemId` INT NOT NULL,
  `cart` INT NOT NULL DEFAULT 0,
  `purchaseDate` DATETIME NULL);
