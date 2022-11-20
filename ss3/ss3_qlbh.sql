create database ss3_qlbhang;
use ss3_qlbhang;
-- tạo bảng Customer
create table customer(
	cID int auto_increment primary key,
    cName varchar(50),
    cAge int
);

-- tạo bảng Order 
create table `order`(
	oID int auto_increment primary key,
    cID int,
    oDate date,
    oTotalPrice int
);

-- tạo bảng product 
create table product(
	pID int auto_increment primary key,
    pName varchar(50),
    pPrice varchar(50)
);

-- tạo bảng OrderDeTail
create table order_detail(
	oID int,
    pID int,
    primary key(oID,pID),
    foreign key (oID) references `order`(oID),
    foreign key (pID) references product(pID),
    odQTY int
);

-- chèn vào bảng customer 
insert into customer values 
(1,"Minh Quan",10),
(2,'Ngoc Anh',20),
(3,'Hong Ha',50);
-- chèn vào bảng order
insert into `order` values
(1,1,'2006-3-21',null),
(2,2,'2006-3-23',null),
(3,1,'2006-3-16',null);
-- chèn vào bảng product
insert into product values
(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);
-- chèn vào bảng order_detail
insert into order_detail values
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

select oID,oDate,oTotalPrice  from `order`;
select c.*,p.* from customer c
join `order` o on c.cID = o.cID
join order_detail od on o.oID = od.oID
join product p on od.pID = p.pID;
select c.* from customer c 
left join `order` o on c.cID = o.cID
group by c.cID having count(o.oID)=0;
select o.oID,o.oDate,sum(od.odQTY*p.pPrice) as tong_tien from `order` o 
join order_detail od on o.oID = od.oID
join product p on od.pID = p.pID
group by oID;
