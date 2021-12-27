create database grupo_springboot01;

use grupo_springboot01;

insert into tb_cliente values(null, "010.569.654-31", "mw@gmail.com", "Michel", "(11) 99999-9999");
insert into tb_cliente values(null, "000.000.000.00", "valeria@gmail.com", "Val", "(11) 99999-8888");
insert into tb_cliente values(null, "111.111.111-11", "acaa@gmail.com", "Val", "(11) 99999-8888");

select * from tb_cliente;

desc tb_conta;
desc tb_cliente;

insert into tb_conta values (null, 11111, 1000, 0, 1);
insert into tb_conta values (null, 22223, 2000, 1, 2);
insert into tb_conta values (null, 33333, 3000, 2, 4);
