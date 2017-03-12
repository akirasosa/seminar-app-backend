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

INSERT INTO aws_setting (username, password, access_key, secret_key, region, vpc_cidr, registration_id)
VALUES ('demo01', '=''tC*ky8Ny@]1', 'AKIAI6A6XBLQ6JMVTCOQ',
        '2ijwBC1sb5Am9Atbmsu7p4Ag4pieyNB11ddErMhi', 'ap-southeast-1',
        '10.1.0.0/16', NULL);
INSERT INTO aws_setting (username, password, access_key, secret_key, region, vpc_cidr, registration_id)
VALUES ('demo02', 'gwN!nW6-]BfS', 'AKIAIPMU3LPW6Q7A2SDQ',
        'sHcaefP0m6SmaJ7EJBvvoqS2BhUHyRjGAgykqrO5', 'ap-southeast-1',
        '10.2.0.0/16', NULL);
INSERT INTO aws_setting (username, password, access_key, secret_key, region, vpc_cidr, registration_id)
VALUES ('demo01', 'gaZ$|hv$unP^', 'AKIAJBC4NTFQU6TPPMOA',
        'PY07JqOKWA99eKYnYilIHc6NNn88B/kMZYoLskgm', 'ap-southeast-1',
        '10.3.0.0/16', NULL);

