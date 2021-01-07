
create table if not exists item
(
  id   serial primary key,
  name varchar(30) not null,
  description varchar(100),
  comments varchar(200)
);