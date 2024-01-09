create database if not exists sale_management;
use sale_management;

create table customer (
cID varchar(50) primary key,
cName varchar(50) not null,
cAge int not null
);

create table order_customer (
oID varchar(50) primary key,
cID varchar(50) not null,
oDate date not null,
oTotalprice float not null,
foreign key (cID) references customer(cID)
);

create table order_detail (
oID varchar(50),
pID varchar(50),
odQTY int not null,
primary key(oID,pID),
foreign key (oID) references order_customer(oID),
foreign key (pID) references product(pID)
);

create table product (
pID varchar(50) primary key,
pName varchar(50) not null,
pPrice float not null
);
drop database sale_management;

