CREATE TABLE IF NOT EXISTS `product` (
  `id` bigint(20) NOT NULL ,
  `product_name` varchar(100) DEFAULT NULL,
  `product_height` varchar(20) DEFAULT NULL,
  `product_width` varchar(20) DEFAULT NULL,
  `product_depth` varchar(50) DEFAULT NULL,
  `id_employee` bigint(20) NOT NULL 
  PRIMARY KEY (`id`)
  FOREIGN KEY(`id`)
);