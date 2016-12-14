create table account(
	acc_id char(10),
	email varchar(30) NOT NULL,
	password varchar(20) NOT NULL,
	fname varchar(20) NOT NULL,
	minit varchar(2),
	lname varchar(20) NOT NULL,
	bdate date,
	address varchar(30) NOT NULL,
	sex char(1) NOT NULL,
	account_type smallint,
	admin_acc char(10),
	constraint pk_account PRIMARY KEY (acc_id)
);

create table account_user(
	user_id char(10),
	constraint pk_account_user PRIMARY KEY (user_id)
);
	
create table account_event_manager(
	event_manager_id char(10),
	org_id char(10),
	organisation varchar(30),
	constraint pk_event_handl PRIMARY KEY (event_manager_id)
);
create table account_admin(
	admin_id char(10),
	constraint pk_account_admin PRIMARY KEY (admin_id)
);

create table event(
	event_id char(10),
	name  varchar(30) NOT NULL,
	event_date date NOT NULL,
	manager_id char(10),
	event_desc varchar(100),
	event_addr varchar(30),
	time_t time,
	ticket_price int,
	max_size int,
	avail_size int,
	constraint pk_event PRIMARY KEY (event_id)
);

create table ticket(
	ticket_id char(10),
	event_id char(10),
	cost float,
	trans_id char(10),
	seat_no smallint,
	constraint pk_ticket PRIMARY KEY (ticket_id, event_id)	
);

create table transactions(
	trans_id char(10),
	bank_id char(10) NOT NULL,
 	user_id char(10) NOT NULL,
 	trans_date date,
 	trans_time time,
 	amount int,
 	constraint pk_transaction PRIMARY KEY (trans_id)
);

create table bank(
	bank_id char(10),
	bank_name varchar(20),
	bank_addr varchar(30),
	constraint pk_bank PRIMARY KEY (bank_id)
);

create table books_for(
	books_for_id char(10),
	event_id char(10),
	usr_id char(10),
	constraint pk_tick_event PRIMARY KEY (books_for_id)
);
