

CREATE TABLE IF NOT EXISTS roles (
   id INT NOT NULL,
   name VARCHAR(50) NOT NULL

);

INSERT INTO roles VALUES(1,'ROLE_USER');
INSERT INTO roles VALUES(2,'ROLE_MODERATOR');
INSERT INTO roles VALUES(3,'ROLE_ADMIN');