-- Table: users
CREATE TABLE users (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

-- Table: roles
CREATE TABLE roles (
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB;

-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
)
  ENGINE = InnoDB;

-- Insert data

INSERT INTO users VALUES (1, 'proselyte', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG');

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_roles VALUES (1, 2);


-- --------------------------------------------------------
CREATE TABLE resources (
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  content VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB;

INSERT into resources VALUES (1, 'Hibernate - Home', 'https://www.tutorialspoint.com/hibernate/index.htm');
INSERT INTO resources VALUES (2, 'ORM - Overview', 'https://www.tutorialspoint.com/hibernate/orm_overview.htm');
INSERT INTO resources VALUES (3, 'Hibernate - Overview', 'https://www.tutorialspoint.com/hibernate/hibernate_overview.htm');

INSERT into resources VALUES (4, 'Gradle - Home', 'https://www.tutorialspoint.com/gradle/index.htm');
INSERT into resources VALUES (5, 'Gradle - Overview', 'https://www.tutorialspoint.com/gradle/gradle_overview.htm');
INSERT into resources VALUES (6, 'Gradle - Installation', 'https://www.tutorialspoint.com/gradle/gradle_installation.htm');

CREATE TABLE user_resources (
  user_id INT NOT NULL,
  resource_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (resource_id) REFERENCES resources (id),

  UNIQUE (user_id, resource_id)
)
  ENGINE = InnoDB;

INSERT INTO user_resources VALUES (1, 1);
INSERT INTO user_resources VALUES (1, 2);
INSERT INTO user_resources VALUES (1, 3);

INSERT INTO user_resources VALUES (2, 4);
INSERT INTO user_resources VALUES (2, 5);
INSERT INTO user_resources VALUES (2, 6);

select name from resources as r, user_resources as ur, users as u
where r.id = ur.resource_id and u.id = ur.user_id and u.id = 2;