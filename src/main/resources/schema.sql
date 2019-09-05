create table author
(
   author_id integer not null AUTO_INCREMENT,
   author_Name varchar(255) not null,
   primary key(author_id)
);

create table book
(
   book_id integer not null AUTO_INCREMENT,
   name varchar(255) not null,
   primary key(book_id)
);

create table publication
(
   pub_id integer not null AUTO_INCREMENT,
   name varchar(255) not null,
   year integer not null,
   primary key(pub_id)
);