create table product
(p_type varchar(20) not null,
p_id int not null primary key auto_increment,
p_name varchar(15) not null,
p_price double not null,
p_quantity int not null,
p_image varchar(100) not null,
p_description varchar(300) null,
p_time date not null);

create table user
(u_id int primary key not null auto_increment,
u_name varchar(20) not null,
u_sex varchar(10) not null,
u_password varchar(20) not null,
u_email varchar(40) not null,
u_telephone varchar(12) null,
u_QQ varchar(15) null,
u_address varchar(200) not null,
u_date date not null
);

create table admin
(a_id int primary key auto_increment not null,
a_name varchar(20) not null,
a_password varchar(20) not null,
a_QQ varchar(15) null,
a_date date not null
);

create table user_product
(u_p_uid int not null,
u_p_pid int not null,
foreign key (u_p_uid) references user (u_id),
foreign key (u_p_pid) references product (p_id)
);

ALTER TABLE `shop`.`user_product` 
ADD COLUMN `u_p_buyTime` DATETIME NOT NULL AFTER `u_p_pid`;

create table feedback
(f_id int primary key auto_increment not null,
u_email varchar(45) not null,
f_content varchar(500) not null,
);