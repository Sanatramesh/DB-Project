alter table account_admin
	add constraint fk_admin FOREIGN KEY (admin_id) REFERENCES account(acc_id) ON DELETE CASCADE;

alter table account_user
	add constraint fk_user FOREIGN KEY (user_id) REFERENCES account(acc_id) ON DELETE CASCADE;

alter table account_event_manager
	add constraint fk_event_manager FOREIGN KEY (event_manager_id) REFERENCES account(acc_id) ON DELETE CASCADE;

alter table account
	add constraint fk_admin_acc FOREIGN KEY (admin_acc) REFERENCES account_admin(admin_id) ON DELETE CASCADE;

alter table event
	add constraint fk_event FOREIGN KEY (manager_id) REFERENCES account_event_manager(event_manager_id) ON DELETE CASCADE;

alter table ticket
	add constraint fk_trans FOREIGN KEY (trans_id) REFERENCES transactions(trans_id) ON DELETE CASCADE;

alter table ticket
	add constraint fk_tick_event FOREIGN KEY (event_id) REFERENCES event(event_id) ON DELETE CASCADE;

alter table transactions
	add constraint fk_tran_bank FOREIGN KEY (bank_id) REFERENCES bank(bank_id) ON DELETE CASCADE;

alter table transactions
	add constraint fk_tran_usr FOREIGN KEY (user_id) REFERENCES account_user(user_id) ON DELETE CASCADE;

alter table books_for
	add constraint fk_tic_eve_usr FOREIGN KEY (usr_id) REFERENCES account_user(user_id) ON DELETE CASCADE;

alter table books_for
	add constraint fk_tic_eve_eve FOREIGN KEY (event_id) REFERENCES event(event_id) ON DELETE CASCADE;
