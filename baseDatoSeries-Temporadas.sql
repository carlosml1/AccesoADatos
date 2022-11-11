use bd_series;


create table series (
	id int primary key auto_increment,
	titulo varchar(100)unique not null,
    edad int,
    plataforma varchar(40),
    constraint chk_edad check (edad in(0,7,12,16,18))
);

create table temporadas (
	id int primary key auto_increment,
	num_temporada int not null,
    titulo varchar(100) not null,
    serie_id int not null,
    constraint fk_temporada foreign key(serie_id) references series(id)
);

delete from temporadas;
delete from series;

ALTER TABLE series AUTO_INCREMENT = 1;
ALTER TABLE temporadas AUTO_INCREMENT = 1;

select * from temporadas;
select * from series;
set sql_safe_updates = 0;