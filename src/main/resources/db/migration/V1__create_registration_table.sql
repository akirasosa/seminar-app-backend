CREATE TABLE `registration` (
  `id`      BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `ip_addr` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ip_addr` (`ip_addr`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

