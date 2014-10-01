CREATE SCHEMA LIBRARY;
USE LIBRARY;
CREATE TABLE BOOK ( Book_id varchar(10) not null,
Title varchar(100),
CONSTRAINT pk_book_id primary key (book_id));
CREATE TABLE BOOK_AUTHORS ( Book_id varchar(10) not null,
Author_name varchar(100) not null,
Fname varchar(20),
Minit varchar(10),
Lname varchar(20),
primary key (Book_id ,Author_name),
foreign key (Book_id) references BOOK (Book_id));
CREATE TABLE LIBRARY_BRANCH ( Branch_id int not null,
Branch_name varchar(20),
Address varchar(100),
primary key (Branch_id) );
CREATE TABLE BOOK_COPIES (Book_id varchar(10) not null,
Branch_id int not null,
No_of_copies int ,
primary key(Book_id ,Branch_id),
foreign key (Book_id) references BOOK (Book_id),
foreign key (Branch_id) references LIBRARY_BRANCH (Branch_id));
CREATE TABLE BORROWER (Card_no int not null,
Fname varchar(20) not null,
Lname varchar(20) not null,
Address varchar(50) not null,
Phone varchar (14),
primary key (Card_no));
CREATE TABLE BOOK_LOANS (Loan_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
Book_id varchar(10) not null,
Branch_id int not null,
Card_no int not null,
Date_out Date,
Due_date Date,
Date_in Date,
foreign key (Book_id) references BOOK (Book_id),
foreign key (Branch_id) references LIBRARY_BRANCH (Branch_id),
foreign key (Card_no) references BORROWER (Card_no));
CREATE TABLE FINE(Loan_id INT PRIMARY KEY ,
Fine_amt DECIMAL(5,2),
PAID BOOLEAN)ENGINE=INNODB;
SET sql_mode = 'NO_ZERO_DATE';
CREATE TRIGGER `FINES_AND_DUES` AFTER INSERT ON `book_loans`
FOR EACH ROW
BEGIN
DECLARE fine_amount decimal(5,2);
IF new.`date_in` IS NULL AND new.`due_date` < CURDATE() THEN
	SET fine_amount = DATEDIFF(CURDATE(),new.`due_date`)*0.25;
	INSERT INTO FINE VALUES (NEW.loan_id,fine_amount,0);
ELSEIF new.`date_in` IS NULL AND new.`due_date` >= CURDATE() THEN
	SET fine_amount = 0.0;
	INSERT INTO FINE VALUES (NEW.loan_id,fine_amount,0);
ELSEIF new.`date_in` IS NOT NULL AND new.`date_in` > new.`due_date` THEN
	SET fine_amount = DATEDIFF(new.`date_in`,new.`due_date`)*0.25;
	INSERT INTO FINE VALUES (NEW.loan_id,fine_amount,0);
ELSEIF new.`date_in` IS NOT NULL AND new.`date_in` <= new.`due_date` THEN
	SET fine_amount = 0.0;
	INSERT INTO FINE VALUES (NEW.loan_id,0.0,0);
END IF;
END;
CREATE TRIGGER `FINE_PAYMENT` AFTER UPDATE ON `book_loans`
FOR EACH ROW
BEGIN
DECLARE fine_amount decimal(5,2);
DECLARE	loan_ids int ;
	IF new.`date_in` IS NULL AND new.`due_date` < CURDATE() THEN
		SET fine_amount = DATEDIFF(CURDATE(),new.`due_date`)*0.25;
		SET loan_ids = new.`loan_id`;
		UPDATE FINE  F set F.`fine_amt`=fine_amount WHERE F.`loan_id`=loan_ids AND F.`paid`=0;
	ELSEIF new.`date_in` IS NULL AND new.`due_date` >= CURDATE() THEN
		SET fine_amount = 0.0;
		UPDATE FINE  F set F.`fine_amt`=fine_amount WHERE F.`loan_id`=loan_ids AND F.`paid`=0;
	ELSEIF new.`date_in` IS NOT NULL AND new.`date_in` > new.`due_date` THEN
		SET fine_amount = DATEDIFF(new.`date_in`,new.`due_date`)*0.25;
		SET loan_ids = new.`loan_id`;
		UPDATE FINE  F set F.`fine_amt`=fine_amount WHERE F.`loan_id`=loan_ids AND F.`paid`=0;
	ELSEIF new.`date_in` IS NULL AND new.`date_in` <= new.`due_date` THEN
		SET fine_amount = 0.0;
		SET loan_ids = new.`loan_id`;
		UPDATE FINE  F set F.`fine_amt`=fine_amount WHERE F.`loan_id`=loan_ids AND F.`paid`=0;
	END IF;
END;
