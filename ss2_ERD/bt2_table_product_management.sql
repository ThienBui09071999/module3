create database if not exists sale_management;
use sale_management;

create table customer (
cID int auto_increment primary key,
cName varchar(50) not null,
cAge int not null
);

create table order_customer (
oID int auto_increment primary key,
cID int not null,
oDate datetime not null,
oTotalprice int,
foreign key (cID) references customer(cID)
);

create table order_detail (
oID int,
pID int,
odQTY int not null,
primary key(oID,pID),
foreign key (oID) references order_customer(oID),
foreign key (pID) references product(pID)
);

create table product (
pID int auto_increment primary key,
pName varchar(50) not null,
pPrice int not null
);
drop database sale_management;

insert into customer
 values (1,'Minh Quan',10),
		(2,'Ngoc Oanh',20),
        (3,'Hong Ha',50);
        
insert into order_customer
values (1, 1, '2006-03-21', null),
    (2, 2, '2006-03-23', null),
    (3, 1, '2006-03-16', null);
    
insert into product
values (1,'May Giat',3),
		(2,'Tu Lanh',5),
        (3,'Dieu Hoa',7),
        (4,'Quat',1),
        (5,'Bep Dien',2);
        
insert into order_detail
values (1,1,3),
		(1,3,7),
        (1,4,2),
        (2,1,1),
        (3,1,8),
        (2,5,4),
        (2,3,3);
        
select * from customer;
select * from order_customer;
select * from product;
select * from order_detail;
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select oID, oDate, oTotalPrice from order_customer;
-- Hiển thị danh sách các khách hàng đã mua hàng
select c.cID, c.cName from customer c
join order_customer o on c.cID = o.cID
group by c.cID;
-- danh sách sản phẩm được mua bởi các khách
select p.pID, p.pName from product p
join order_detail o on p.pID = o.pID
group by p.pID;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select c.cID, c.cName from customer c
left join order_customer o on c.cID=o.cID
where o.oID is null;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pP)
select o.oID as `order id`, o.oDate as `order's date`, sum(od.odQTY*p.pPrice) as total from order_detail od
join order_customer o on o.oID = od.oID
join product p on p.pID = od.pID
group by o.oID;





