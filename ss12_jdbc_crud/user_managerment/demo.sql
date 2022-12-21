drop database if exists demo;
create database demo;
use demo;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 name varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);
insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');

select * from users;
DELIMITER //
create procedure sp_del_user(in id_users int)
begin
	delete from users where users.id = id_users;
end;
// DELIMITER ;
call sp_del_user(3);
