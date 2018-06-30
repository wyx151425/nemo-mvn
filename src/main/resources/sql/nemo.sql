CREATE TABLE user
(
  id                  INT(11)   AUTO_INCREMENT,
  object_id           CHAR(32),
  status              INT(1),
  create_at           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_at           TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,

  name                VARCHAR(3),
  mobile_phone_number CHAR(11),
  password            VARCHAR(32),

  email               VARCHAR(32),
  motto               VARCHAR(100),
  profile             VARCHAR(500),
  profession          VARCHAR(32),
  location            VARCHAR(64),

  gender              VARCHAR(2),
  birthday            TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

  age                 INT(3),
  follow              INT(11),
  follower            INT(11),
  favorite            INT(11),
  book                INT(3),

  avatar              VARCHAR(256),
  portrait            VARCHAR(256),
  PRIMARY KEY (id)
)
  ENGINE = INNODB
  DEFAULT CHARSET = UTF8;

CREATE TABLE book
(
  id          INT(11)   AUTO_INCREMENT,
  object_id   CHAR(32),
  status      INT(1),
  create_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,

  author_id   INT(11),

  name        VARCHAR(32),
  style       CHAR(2),
  description VARCHAR(500),
  source      VARCHAR(256),
  cover       VARCHAR(256),

  page        INT(3),
  favor       INT(11),

  type        INT(1),
  publish     BOOLEAN,
  copyright   BOOLEAN,
  PRIMARY KEY (id)
)
  ENGINE = INNODB
  DEFAULT CHARSET = UTF8;

CREATE TABLE page
(
  id        INT(11)   AUTO_INCREMENT,
  object_id CHAR(32),
  status    INT(1),
  create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  update_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP,

  number    INT(3),
  book_id   INT(11),
  image     VARCHAR(256),
  PRIMARY KEY (id)
)
  ENGINE = INNODB
  DEFAULT CHARSET = UTF8;