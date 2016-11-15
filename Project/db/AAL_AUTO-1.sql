DROP DATABASE aal_auto;
Create database AAL_AUTO;

use AAL_AUTO;

CREATE TABLE WAREHOUSE
(
	W_ID INT PRIMARY KEY AUTO_INCREMENT,
	WARE_NAME VARCHAR(100),
	WARE_ADDRESS VARCHAR(100),
	STATUS INT
);

CREATE TABLE USERS
(
	U_ID INT PRIMARY KEY AUTO_INCREMENT,
	W_ID INT,
	USERNAME VARCHAR(100),
	PASSWORDS VARCHAR(100),
	ROLES VARCHAR(20),
	CONSTRAINT FK_ORDERS_USER_WAREHOUSE FOREIGN KEY (W_ID) REFERENCES  WAREHOUSE(W_ID)
);
 
CREATE TABLE CUSTOMER
(
	C_ID INT PRIMARY KEY AUTO_INCREMENT,
	CUSTOMER_NAME VARCHAR(100),
	CUSTOMER_ADDRESS VARCHAR(200),
	PHONENUMBER TEXT,
	EMAIL VARCHAR(100),
	PASSWORDS VARCHAR(100),
	PASSPORT VARCHAR(100),
	BALANCES DOUBLE NOT NULL DEFAULT '0.0000',
	RATE INT,
	STATUS INT DEFAULT 1
);
 
CREATE TABLE CATEGORY
(
	CATE_ID INT PRIMARY KEY AUTO_INCREMENT,
	CATEGORY_NAME VARCHAR(200),
	BRAND TEXT,
	STATUS INT
);
 
CREATE TABLE PRODUCT
(
	P_ID INT PRIMARY KEY AUTO_INCREMENT,
	PRODUCT_NAME VARCHAR(200),
	CATE_ID INT,
	IMAGE_LINK VARCHAR(300),
	PRODUCT_PRICE DOUBLE NOT NULL DEFAULT '0.0000',
	QUANTITY INT DEFAULT 0,
	DESCRIPTION VARCHAR(300),
	CONSTRAINT FK_PRODUCT_CATEGORY FOREIGN KEY (CATE_ID) REFERENCES  CATEGORY(CATE_ID),
	STATUS INT
);
 
CREATE TABLE ORDERS
(
	O_ID INT PRIMARY KEY AUTO_INCREMENT,
	ORDER_IDENTIFIER VARCHAR(100),
	C_ID INT,
	W_ID INT,
	ORDER_ADDRESS VARCHAR(100),
	ORDER_DATE DATETIME,
	ORDER_STATUS VARCHAR(20),
	ORDER_NOTE VARCHAR(200),
	CONSTRAINT FK_ORDERS_CUSTOMER FOREIGN KEY (C_ID) REFERENCES  CUSTOMER(C_ID),
	CONSTRAINT FK_ORDERS_WAREHOUSE FOREIGN KEY (W_ID) REFERENCES  WAREHOUSE(W_ID)
);
 
CREATE TABLE ORDER_PRODUCT
(
	ORDER_PRODUCT_ID INT PRIMARY KEY AUTO_INCREMENT,
	O_ID INT,
	P_ID INT,
	QUANTITY INT,
	CONSTRAINT FK_ORDER_PRODUCT_PRODUCT FOREIGN KEY (P_ID) REFERENCES  PRODUCT(P_ID),
	CONSTRAINT FK_ORDER_PRODUCT_ORDERS FOREIGN KEY (O_ID) REFERENCES  ORDERS(O_ID)
);


INSERT INTO `category`(`CATEGORY_NAME`) VALUES ("� t�"),("Xe m�y");
INSERT INTO `customer`(`CUSTOMER_NAME`, `CUSTOMER_ADDRESS`, `PHONENUMBER`, `EMAIL`, `PASSWORDS`, `PASSPORT`, `BALANCES`, `RATE`) 
VALUES ("kh�i","tuyen quang","01686294092","khoibngc00847@fpt.edu.vn","123456","unknow", 100000, 10),
("quang","ha noi","123456","quangexample@fpt.edu.vn","1111","unknow",300000, 30);
INSERT INTO `warehouse`(`WARE_NAME`, `WARE_ADDRESS`) VALUES ("kho 1","cau giay"),("kho 2","hoang quoc viet");
INSERT INTO `product`(`PRODUCT_NAME`, `CATE_ID`, `IMAGE_LINK`, `PRODUCT_PRICE`, `QUANTITY`, `DESCRIPTION`) VALUES ("test1", 1, "unknow", 200000, 0,"hang moi ve"),("test2", 2, "unknow1", 10000, 0,"hang sap ve");
INSERT INTO `users`(`W_ID`, `USERNAME`, `PASSWORDS`, `ROLES`) VALUES (1, "khoibn", "123456", "admin"),(2, "khoibn1", "123456", "super admin");
INSERT INTO `orders`(`ORDER_IDENTIFIER`, `C_ID`, `W_ID`, `ORDER_ADDRESS`, `ORDER_DATE`, `ORDER_STATUS`, `ORDER_NOTE`) VALUES ("unknow", 1, 1, "big c thang long", "2014-12-10","chua xong", "shipper vo van"),("unknow1", 2, 2, "nguyen phong sac", "2014-10-10","xong", "ko co note");
INSERT INTO `order_product`(`O_ID`, `P_ID`, `QUANTITY`) VALUES (1,1,10),(1,2,5),(2,1,20),(2,2,25);



