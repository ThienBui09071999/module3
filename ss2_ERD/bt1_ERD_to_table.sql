create database vattu_management;
use vattu_management;
create table phonenumber (
msdt varchar(50) primary key,
phonenumber varchar(50) not null
);
create table ncc (
mncc varchar(50) primary key,
tennnc varchar(50) unique,
diachi varchar(50),
msdt varchar(50) not null,
foreign key (msdt) references phonenumber(msdt)
);
create table ddh (
sodh int primary key,
ngaydh date not null,
mncc varchar(50) not null,
foreign key (mncc) references ncc(mncc)
);
create table phieuxuat (
sopx int primary key,
ngayxuat date
);
create table vattu (
mavt varchar(50) primary key,
tenvt varchar(50) not null
);
create table phieunhap (
sopn int primary key,
ngaynhap date
);
create table pxdetails (
sopx int,
mavt varchar(50),
dongia double not null,
soluong int not null,
primary key(sopx,mavt),
foreign key (sopx) references phieuxuat(sopx),
foreign key (mavt) references vattu(mavt)
);
create table pndetails (
sopn int,
mavt varchar(50),
dongia double not null,
soluong int not null,
primary key(sopn,mavt),
foreign key (sopn) references phieunhap(sopn),
foreign key (mavt) references vattu(mavt)
);
create table orderdetails (
sodh int,
mavt varchar(50),
primary key(sodh,mavt),
foreign key (sodh) references ddh(sodh),
foreign key (mavt) references vattu(mavt)
);
