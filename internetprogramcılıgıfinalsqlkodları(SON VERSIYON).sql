-- --------------------------------------------------------
-- Sunucu:                       127.0.0.1
-- Sunucu sürümü:                10.5.3-MariaDB - mariadb.org binary distribution
-- Sunucu İşletim Sistemi:       Win64
-- HeidiSQL Sürüm:               11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- aracyedekparca için veritabanı yapısı dökülüyor
CREATE DATABASE IF NOT EXISTS `aracyedekparca` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `aracyedekparca`;

-- tablo yapısı dökülüyor aracyedekparca.firma
CREATE TABLE IF NOT EXISTS `firma` (
  `firma_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `firma_ad` varchar(50) DEFAULT '0',
  `firma_aciklama` varchar(100) DEFAULT '0',
  PRIMARY KEY (`firma_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- aracyedekparca.firma: ~2 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `firma` DISABLE KEYS */;
INSERT INTO `firma` (`firma_id`, `firma_ad`, `firma_aciklama`) VALUES
	(2, 'asdasd', 'lkjlj'),
	(3, 'oook', 'uuuu');
/*!40000 ALTER TABLE `firma` ENABLE KEYS */;

-- tablo yapısı dökülüyor aracyedekparca.firma_siparis
CREATE TABLE IF NOT EXISTS `firma_siparis` (
  `firma_id` int(11) unsigned NOT NULL,
  `siparis_id` int(11) unsigned NOT NULL,
  KEY `firma_id_fk` (`firma_id`),
  KEY `siparis_id_fk` (`siparis_id`),
  CONSTRAINT `firma_id_fk` FOREIGN KEY (`firma_id`) REFERENCES `firma` (`firma_id`),
  CONSTRAINT `siparis_id_fk` FOREIGN KEY (`siparis_id`) REFERENCES `siparis` (`siparis_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- aracyedekparca.firma_siparis: ~4 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `firma_siparis` DISABLE KEYS */;
INSERT INTO `firma_siparis` (`firma_id`, `siparis_id`) VALUES
	(3, 1),
	(3, 2),
	(3, 5),
	(2, 5);
/*!40000 ALTER TABLE `firma_siparis` ENABLE KEYS */;

-- tablo yapısı dökülüyor aracyedekparca.isci
CREATE TABLE IF NOT EXISTS `isci` (
  `isci_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `isci_ad` varchar(50) NOT NULL DEFAULT '0',
  `isci_soyad` varchar(50) NOT NULL DEFAULT '0',
  `isci_tc` varchar(11) NOT NULL DEFAULT '0',
  `usta_id` int(11) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`isci_id`),
  KEY `usta_id_fk` (`usta_id`),
  CONSTRAINT `usta_id_fk` FOREIGN KEY (`usta_id`) REFERENCES `usta` (`usta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- aracyedekparca.isci: ~7 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `isci` DISABLE KEYS */;
INSERT INTO `isci` (`isci_id`, `isci_ad`, `isci_soyad`, `isci_tc`, `usta_id`) VALUES
	(9, 'fffeee', 'ttt', '1845632545', 2),
	(10, 'hjk', 'fdgd', '12312', 1),
	(12, 'aaa', 'bbb', '1845632545', 4),
	(14, 'gg', 'hh', '567', 10),
	(15, 'yu', 'uy', '666', 5),
	(16, 'dg', 'gf', '5645', 12),
	(17, 'iii', 'lll', '999', 8);
/*!40000 ALTER TABLE `isci` ENABLE KEYS */;

-- tablo yapısı dökülüyor aracyedekparca.makina
CREATE TABLE IF NOT EXISTS `makina` (
  `makina_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `makina_marka` varchar(50) DEFAULT '0',
  `makina_tur` varchar(50) DEFAULT '0',
  `isci_id` int(11) unsigned NOT NULL DEFAULT 0,
  `makinasorumlusu_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`makina_id`),
  KEY `isci_id_fk` (`isci_id`),
  KEY `makinasorumlusu_id_fk` (`makinasorumlusu_id`),
  CONSTRAINT `isci_id_fk` FOREIGN KEY (`isci_id`) REFERENCES `isci` (`isci_id`),
  CONSTRAINT `makinasorumlusu_id_fk` FOREIGN KEY (`makinasorumlusu_id`) REFERENCES `makinasorumlusu` (`makinasorumlusu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- aracyedekparca.makina: ~7 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `makina` DISABLE KEYS */;
INSERT INTO `makina` (`makina_id`, `makina_marka`, `makina_tur`, `isci_id`, `makinasorumlusu_id`) VALUES
	(1, 'dfsd', 'ggg', 10, 1),
	(3, 'gty', 'ytg', 9, 1),
	(4, 'adsas', 'asdasdsa', 10, 3),
	(5, 'ewqeq21', 'gdgd', 10, 3),
	(8, 'kkk', 'kkk', 14, 2),
	(9, 'kkkjhj', 'hjk', 12, 3),
	(10, 'sss', 'ddd', 10, 2);
/*!40000 ALTER TABLE `makina` ENABLE KEYS */;

-- tablo yapısı dökülüyor aracyedekparca.makinasorumlusu
CREATE TABLE IF NOT EXISTS `makinasorumlusu` (
  `makinasorumlusu_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `makinasorumlusu_ad` varchar(50) NOT NULL DEFAULT '0',
  `makinasorumlusu_soyad` varchar(50) NOT NULL DEFAULT '0',
  `makinasorumlusu_tc` varchar(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`makinasorumlusu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- aracyedekparca.makinasorumlusu: ~2 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `makinasorumlusu` DISABLE KEYS */;
INSERT INTO `makinasorumlusu` (`makinasorumlusu_id`, `makinasorumlusu_ad`, `makinasorumlusu_soyad`, `makinasorumlusu_tc`) VALUES
	(1, 'üoıuı', 'ıuou', '678'),
	(2, 'hjk', 'kjh', '546'),
	(3, 'ccc', 'vvv', '2234');
/*!40000 ALTER TABLE `makinasorumlusu` ENABLE KEYS */;

-- tablo yapısı dökülüyor aracyedekparca.muhasebeci
CREATE TABLE IF NOT EXISTS `muhasebeci` (
  `muhasebeci_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `muhasebeci_ad` varchar(50) NOT NULL DEFAULT '0',
  `muhasebeci_soyad` varchar(50) NOT NULL DEFAULT '0',
  `muhasebeci_tc` varchar(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`muhasebeci_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- aracyedekparca.muhasebeci: ~2 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `muhasebeci` DISABLE KEYS */;
INSERT INTO `muhasebeci` (`muhasebeci_id`, `muhasebeci_ad`, `muhasebeci_soyad`, `muhasebeci_tc`) VALUES
	(1, 'gkhnq', 'rty', '12343212'),
	(2, 'fdgdf', 'ghfghfg', '1231231'),
	(3, 'hjghjg', 'nbvnvb', '231');
/*!40000 ALTER TABLE `muhasebeci` ENABLE KEYS */;

-- tablo yapısı dökülüyor aracyedekparca.parca
CREATE TABLE IF NOT EXISTS `parca` (
  `parca_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `parca_ad` varchar(50) DEFAULT '0',
  `parca_hammadde` varchar(50) DEFAULT '0',
  `makina_id` int(11) unsigned NOT NULL DEFAULT 0,
  `parca_fiyat` int(10) unsigned NOT NULL,
  PRIMARY KEY (`parca_id`),
  KEY `makina_id_fk` (`makina_id`),
  CONSTRAINT `makina_id_fk` FOREIGN KEY (`makina_id`) REFERENCES `makina` (`makina_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- aracyedekparca.parca: ~4 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `parca` DISABLE KEYS */;
INSERT INTO `parca` (`parca_id`, `parca_ad`, `parca_hammadde`, `makina_id`, `parca_fiyat`) VALUES
	(2, 'hhh12', 'mmm', 3, 56),
	(3, 'dgffdgd', 'dgfdgg', 3, 65),
	(5, 'xcv', 'mli', 5, 78);
/*!40000 ALTER TABLE `parca` ENABLE KEYS */;

-- tablo yapısı dökülüyor aracyedekparca.siparis
CREATE TABLE IF NOT EXISTS `siparis` (
  `siparis_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `siparis_kod` varchar(50) NOT NULL DEFAULT '0',
  `siparis_parcasayi` int(10) unsigned NOT NULL DEFAULT 0,
  `parca_id` int(11) unsigned NOT NULL DEFAULT 0,
  `muhasebeci_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`siparis_id`),
  KEY `parca_id_fk` (`parca_id`),
  KEY `muhasebeci_id_fk` (`muhasebeci_id`),
  CONSTRAINT `muhasebeci_id_fk` FOREIGN KEY (`muhasebeci_id`) REFERENCES `muhasebeci` (`muhasebeci_id`),
  CONSTRAINT `parca_id_fk` FOREIGN KEY (`parca_id`) REFERENCES `parca` (`parca_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- aracyedekparca.siparis: ~2 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `siparis` DISABLE KEYS */;
INSERT INTO `siparis` (`siparis_id`, `siparis_kod`, `siparis_parcasayi`, `parca_id`, `muhasebeci_id`) VALUES
	(1, 'd34', 13, 2, 2),
	(2, 'yyyyyy', 50, 5, 1),
	(5, 'kalem', 678, 3, 3);
/*!40000 ALTER TABLE `siparis` ENABLE KEYS */;

-- tablo yapısı dökülüyor aracyedekparca.user
CREATE TABLE IF NOT EXISTS `user` (
  `kullanici_ad` varchar(50) NOT NULL,
  `sifre` varchar(50) NOT NULL,
  PRIMARY KEY (`kullanici_ad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- aracyedekparca.user: ~9 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`kullanici_ad`, `sifre`) VALUES
	('aa', 'aa'),
	('aaa', '123'),
	('ahmet', 'ahmet'),
	('asda', 'adadas'),
	('cc', 'cc'),
	('dd', 'dd'),
	('fff', 'fff'),
	('ss', 'ss'),
	('veli', 'veli'),
	('www', 'www');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- tablo yapısı dökülüyor aracyedekparca.usta
CREATE TABLE IF NOT EXISTS `usta` (
  `usta_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `usta_ad` varchar(50) NOT NULL DEFAULT '0',
  `usta_soyad` varchar(50) NOT NULL DEFAULT '0',
  `usta_tc` varchar(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`usta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- aracyedekparca.usta: ~17 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `usta` DISABLE KEYS */;
INSERT INTO `usta` (`usta_id`, `usta_ad`, `usta_soyad`, `usta_tc`) VALUES
	(1, 'ahmett', 'uysallk', '1818845346'),
	(2, 'gökhan', 'demirallll', '1818845346'),
	(4, 'isa', 'tanacı', '1547865'),
	(5, 'dasdsss', 'sdsadqqq', '123123'),
	(6, 'ttyt', 'yuı', '6676'),
	(7, 'vbn', 'nmö', '3242'),
	(8, 'zxc', 'cxzz', '12345'),
	(9, 'asd', 'dfg', '1111'),
	(10, 'qqqq', 'qqqq', '5555'),
	(11, 'zzazaza', 'zazaz', '8888'),
	(12, 'xsxsxs', 'cddcdc', '555666'),
	(13, 'eeee', 'eee', '444'),
	(14, 'fdg', 'dfgdf', '342342'),
	(15, 'fdsfd', 'gfhfg', '232'),
	(16, 'gökhan', 'demirallllfsd', '1832'),
	(17, 'qqqqqsssssqqqqqqqq', 'qqqqqqqqqqqqq', '123'),
	(18, 'qqqqwqwq', 'wewew', '1111'),
	(19, 'asdddd', 'assss', '11');
/*!40000 ALTER TABLE `usta` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
