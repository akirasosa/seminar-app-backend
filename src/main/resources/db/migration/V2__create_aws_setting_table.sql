CREATE TABLE `aws_setting` (
  `id`              BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `username`        VARCHAR(30)  NOT NULL,
  `password`        VARCHAR(30)  NOT NULL,
  `access_key`      VARCHAR(30)  NOT NULL,
  `secret_key`      VARCHAR(100) NOT NULL,
  `region`          VARCHAR(30)  NOT NULL,
  `vpc_cidr`        VARCHAR(30)  NOT NULL,
  `registration_id` BIGINT(20),
  PRIMARY KEY (`id`),
  KEY `FK_registration` (`registration_id`),
  CONSTRAINT `FK_registration` FOREIGN KEY (`registration_id`) REFERENCES `registration` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

