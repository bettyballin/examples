
CREATE TABLE user_roles(
  user_role_id int(10) unsigned not null AUTO_INCREMENT, 
  user_id int(10) unsigned not null, 
  authority varchar(45) not null, 
  PRIMARY KEY(user_role_id), 
  KEY FK_user_roles (user_id), 
  CONSTRAINT FK_user_roles FOREIGN KEY (user_id) REFERENCES users (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

