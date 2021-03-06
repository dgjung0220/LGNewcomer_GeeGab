CREATE TABLE STORELIST (
	StoreNo INTEGER AUTO_INCREMENT PRIMARY KEY,
	StoreName STRING NOT NULL
);

CREATE TABLE CARDLIST (
	CardNo INTEGER AUTO_INCREMENT PRIMARY KEY,
	CardName STRING NOT NULL
);

CREATE TABLE DSCNT_INFO (
	CardName STRING NOT NULL,
	StoreName STRING NOT NULL,
	DiscountRate FLOAT NOT NULL,
	foreign key(CardName) REFERENCES CARDLIST(CardName),
	foreign key(StoreName) REFERENCES STORELIST(StoreName),
	primary key(CardName, StoreName)
);

CREATE TABLE Member (
	MemberNo INTEGER AUTO_INCREMENT PRIMARY KEY,
	email STRING NOT NULL,
	passwd STRING NOT NULL,
	name STRING NOT NULL,
	phone STRING NOT NULL,
	ADDR STRING NOT NULL,
);

CREATE TABLE USERCARD (
	UserCardNo INTEGER AUTO_INCREMENT PRIMARY KEY,
	cardID STRING NOT NULL,
	email STRING NOT NULL,
	cardName STRING NOT NULL,
	cardType STRING NOT NULL,
	cardAlias STRING NOT NULL,
	foreign key(email) REFERENCES Member(email),
	foreign key(cardName) REFERENCES CardLIST(cardName)
);	