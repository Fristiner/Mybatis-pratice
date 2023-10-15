

create table t_act(
    id bigint not null  auto_increment  primary key ,
    actno varchar(255) comment '账号',
    balance decimal(15,2) comment '余额'
);

create table t_student(
    id bigint not null  auto_increment primary key ,
    name varchar(255),
    age int,
    height double,
    birth date,
    sex char(1)
);

