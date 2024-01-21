create database demo;
use demo;
-- Tạo bảng Products
CREATE TABLE Products (
    Id INT PRIMARY KEY AUTO_INCREMENT,
    productCode VARCHAR(50) UNIQUE,
    productName VARCHAR(255),
    productPrice DECIMAL(10, 2),
    productAmount INT,
    productDescription TEXT,
    productStatus ENUM('Active', 'Inactive')
);

-- Chèn một số dữ liệu mẫu
INSERT INTO Products (productCode, productName, productPrice, productAmount, productDescription, productStatus)
VALUES
    ('P001', 'Laptop', 1200.00, 50, 'Powerful laptop with high-performance specifications.', 'Active'),
    ('P002', 'Smartphone', 699.99, 100, 'Latest model with advanced features.', 'Active'),
    ('P003', 'Headphones', 99.50, 200, 'Over-ear headphones with noise-canceling technology.', 'Inactive'),
    ('P004', 'Wireless Mouse', 29.99, 150, 'Ergonomic design for comfortable use.', 'Active');

#buoc 3

-- 1
alter table products add unique index i_productCode(productCode);
-- 2 
alter table products add index i_name_price(productName,productPrice);
-- 3 
explain select * from products 
where productPrice < 100;
#Buoc 4
-- 1
Create view v_products as 
select productCode,productName,productPrice,productStatus from products;

select * from v_products;

update v_products set productName = "Iphone" where productCode = "P001";

drop view v_products;
#Buoc 5
-- 1
delimiter //
create procedure store_product()
begin
select * from products;
end //
delimiter ;

-- 2 

delimiter //
create procedure add_product(
     p_productCode VARCHAR(50) ,
    p_productName VARCHAR(255),
    p_productPrice DECIMAL(10, 2),
    p_productAmount INT,
    p_productDescription TEXT,
    p_productStatus ENUM('Active', 'Inactive')
)
begin
insert into products(
productCode, productName, productPrice, productAmount, productDescription, productStatus)
values (
 p_productCode, p_productName, p_productPrice, p_productAmount, p_productDescription, p_productStatus
);
end //
delimiter ;
-- 3 
delimiter //
create procedure update_product(
    p_productCode VARCHAR(50) ,
    p_productName VARCHAR(255),
    p_productPrice DECIMAL(10, 2),
    p_productAmount INT,
    p_productDescription TEXT,
    p_productStatus ENUM('Active', 'Inactive')
)
begin
UPDATE products
    SET 
        productName = p_productName,
        productPrice = p_productPrice,
        productAmount = p_productAmount,
        productDescription = p_productDescription,
        productStatus = p_productStatus
    WHERE 
        productCode = p_productCode;end //
delimiter ;
-- 3
DELIMITER //

CREATE PROCEDURE delete_product_by_id(
    IN p_productId INT
)
BEGIN
    DELETE FROM Products
    WHERE Id = p_productId;
END //

DELIMITER ;