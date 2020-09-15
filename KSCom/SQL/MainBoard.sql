create table mainboard(
	id int auto_increment primary key,
	brand varchar(45),
	name varchar(45),
	kind varchar(45),
	socket varchar(15),
	chipset varchar(45),
	form_factor varchar(45),
	image varchar(45),
	price int,
	content varchar(450),
	readcount int 
);