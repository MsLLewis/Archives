CREATE database archives;
USE archives;
CREATE TABLE records (
id int PRIMARY KEY auto_increment not null,
isbn int UNIQUE NOT NULL,
recordName VARCHAR(50)  );


use archives;
INSERT INTO records (isbn, recordName) VALUES
(1, 'Effective Java'),
(2, 'Clean Code'),
(3, 'Computer Programming Principles');	

