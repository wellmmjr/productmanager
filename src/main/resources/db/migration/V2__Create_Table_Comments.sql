CREATE TABLE `product_comments` (
  `id` INT(10) AUTO_INCREMENT PRIMARY KEY,
  `comment_text` longtext,
  `launch_date` datetime(6) NOT NULL,
  `fkid_product` bigdecimal NOT NULL,
  `fkid_employee`bigdecimal NOT NULL
);
