create database ss2_xdcsdlqlbh;
use ss2_xdcsdlqlbh;

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
    foreign key (pID) references product(pID)
);
