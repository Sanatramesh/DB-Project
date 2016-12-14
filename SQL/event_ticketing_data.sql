insert into account(acc_id,email,password,fname,minit,lname,bdate,address,sex,account_type,admin_acc) 
values ('A000000001','lijo.johny@yahoo.com','lj123','Lijo','','Johny','1992-10-05','Bangalore','M',3,NULL);

insert into account(acc_id,email,password,fname,minit,lname,bdate,address,sex,account_type,admin_acc)
values ('A000000002','sankalp.johri@yahoo.com','sj123','Sanat','','Ramesh','1994-10-10','Bangalore','M',3,NULL);

insert into account_admin(admin_id)
VALUES('A000000001');
insert into account_admin(admin_id)
VALUES('A000000002');

insert into account(acc_id,email,password,fname,minit,lname,bdate,address,sex,account_type,admin_acc)
values ('U000000001','roniit.bhimrajka@yahoo.com','rb123','Roniit','','Bhimrajka','1994-12-10','Bangalore','M',1,'A000000001');

insert into account(acc_id,email,password,fname,minit,lname,bdate,address,sex,account_type,admin_acc) 
values ('EU00000001','krishna.bhat@yahoo.com','kb123','Krishna','','Bhat','1994-12-16','Bangalore','M',2,'A000000001');

insert into account(acc_id,email,password,fname,minit,lname,bdate,address,sex,account_type,admin_acc)
values ('U000000002','sanat.r@yahoo.com','sr123','Sanat','','Ramesh','1994-10-10','Bangalore','M',1,'A000000002');

insert into account(acc_id,email,password,fname,minit,lname,bdate,address,sex,account_type,admin_acc)
values ('EU00000002','jyothi.prakash@yahoo.com','jp123','Jyothi','','Prakash','1994-9-12','Bangalore','M',2,'A000000002');


insert into bank(bank_id,bank_name,bank_addr)
values('B000000001','Bank_Of_Baroda','11,Electronic City,Bangalore');

insert into bank(bank_id,bank_name,bank_addr)
values('B000000002','ICICI','21,Electronic City,Bangalore');

insert into bank(bank_id,bank_name,bank_addr)
values('B000000003','HDFC','109,Electronic City,Bangalore');

insert into bank(bank_id,bank_name,bank_addr)
values('B000000004','State_Bank_Of_India','9c,Electronic City,Bangalore');

insert into bank(bank_id,bank_name,bank_addr)
values('B000000005','Axix_Bank','9c,Electronic City,Bangalore');

insert into account_user(user_id)
VALUES('U000000001');
insert into account_user(user_id)
VALUES('U000000002');

insert into account_event_manager(event_manager_id, org_id, organisation)
VALUES('EU00000001','O000000001', 'PVR');
insert into account_event_manager(event_manager_id, org_id, organisation)
VALUES('EU00000002','O000000002', 'IMAX');

insert into event(event_id, name, event_date, manager_id, event_desc, event_addr, time_t, ticket_price, max_size, avail_size)
VALUES('E000000001','Spandan', '2014-12-02', 'EU00000001', 'Action', 'Koramangala', '20:30:00', 500, 100, 50);
insert into event(event_id, name, event_date, manager_id, event_desc, event_addr, time_t, ticket_price, max_size, avail_size)
VALUES('E000000002','Spandan2', '2014-12-03', 'EU00000001', 'Drama', 'Elec. City', '21:30:00', 520, 120, 50);
insert into event(event_id, name, event_date, manager_id, event_desc, event_addr, time_t, ticket_price, max_size, avail_size)
VALUES('E000000003','Spandan3', '2014-12-07', 'EU00000002', 'Thriller', 'City', '22:30:00', 500, 120, 50);
insert into event(event_id, name, event_date, manager_id, event_desc, event_addr, time_t, ticket_price, max_size, avail_size)
VALUES('E000000004','Spandan2', '2014-12-02', 'EU00000001', 'Action', 'Elec. City', '20:30:00', 520, 120, 50);
insert into event(event_id, name, event_date, manager_id, event_desc, event_addr, time_t, ticket_price, max_size, avail_size)
VALUES('E000000005','Spandan4', '2014-12-02', 'EU00000002', 'Anime', 'Koramangala', '20:30:00', 520, 120, 50);

insert into transactions(trans_id, bank_id, user_id, trans_date, trans_time, amount)
VALUES('TR00000001','B000000001', 'U000000001', '2014-12-03','20:30:00', 500);
insert into transactions(trans_id, bank_id, user_id, trans_date, trans_time, amount)
VALUES('TR00000002','B000000002', 'U000000001', '2014-12-02','22:30:00', 520);
insert into transactions(trans_id, bank_id, user_id, trans_date, trans_time, amount)
VALUES('TR00000003','B000000001', 'U000000002', '2014-12-07','21:30:00', 500);

insert into ticket(ticket_id, event_id, trans_id, cost, seat_no)
VALUES('T000000001','E000000001', 'TR00000001', 550, 2 );
insert into ticket(ticket_id, event_id, trans_id, cost, seat_no)
VALUES('T000000002','E000000002', 'TR00000002', 500, 3 );
insert into ticket(ticket_id, event_id, trans_id, cost, seat_no)
VALUES('T000000003','E000000003', 'TR00000003', 507, 4 );

insert into books_for
VALUES('BF00000001', 'E000000001', 'U000000001');
insert into books_for
VALUES('BF00000002', 'E000000002', 'U000000001');
insert into books_for
VALUES('BF00000003', 'E000000003', 'U000000002');
