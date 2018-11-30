create table users(
   username varchar(75) not null primary key,
   password varchar(150) not null,
   enabled boolean not null
);

create table authorities (
    username varchar(75) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);

create table persistent_logins(
   series varchar(64) not null primary key,
   username varchar(75) not null,
   token varchar(100) not null,
   last_used timestamp not null
);