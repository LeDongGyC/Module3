drop database if exists ss5_bt_visp;
create database ss5_bt_visp;
use ss5_bt_visp;

create table product(
	id int primary key,
    product_code int,
    product_name varchar(50),
    product_price double,
    product_amount int,
    product_description text,
    product_status bit
);

insert into product(id,product_code,product_name,product_price,product_amount,product_description,product_status) values 
(1,1, 'Iphone11', 12000, 10, 'apple', 1),
(2,2, 'Samsung Note 10', 10000, 100, 'korea', 1),
(3,3, 'Sony Z3', 15000, 15, 'sony', 0);

create unique index index_productCode on product(product_code);
explain select * from product where product_code = 1; 

create unique index index_compositeIndex on product(product_name,product_price);
explain select * from product where product_name = 'Iphone11' and product_price = 12000;

create view view_product as select product_code, product_name, product_price, product_status from product;
select * from view_product;
create or replace view view_product as select * from product;
drop view view_product;

delimiter //
create procedure get_all_product()
begin
	select * from product;
end;  
// delimiter ;
call get_all_product;

delimiter //
create procedure insert_new_product(
	id int,
	`code` int,
   `name` varchar(50),
    price double,
    amount int,
    `description` text,
    `status` bit
)
begin
	insert into product values(id,`code`,`name`,price,amount,`description`,`status`);
end;
// delimiter ;
call insert_new_product(4,4,'ViVo',10000,20,'China',1);

delimiter //
create procedure edit_product(
	product_id int,
	`code` int,
   `name` varchar(50),
    price double,
    amount int,
    `description` text,
    `status` bit
)
begin
	update product 
    set product_code = code,product_name = `name`, product_price = price,
		product_amount = amount, product_description = `description`, product_status =  `status`
	where id=product_id;
end;
// delimiter ;
call edit_product(2, 2,'Oppo a30', 8000, 35,'china', 1);

delimiter //
create procedure del_product(product_id int)
begin
	delete from product where id=product_id;
end;
// delimiter ;
call del_product(4);
call get_all_product;















