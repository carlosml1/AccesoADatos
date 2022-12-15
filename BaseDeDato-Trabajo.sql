use autocines;
CREATE TABLE autocines (
    Id INT NOT NULL AUTO_INCREMENT primary key,
    Nombre VARCHAR(40) not null unique,
    Trabajador VARCHAR(40) NOT NULL UNIQUE,
    Coches VARCHAR(40) NOT NULL UNIQUE,
    Clientes VARCHAR(40) NOT NULL UNIQUE
);
Create table ciudad(
	Nombre VARCHAR(40) not null primary key,
    autocines_id int,
    foreign key (autocines_id) references autocines(id)
);
select * from autocines;
select * from ciudad;



set SQL_SAFE_UPDATES=0;
delete from autocines;
delete from ciudad;
ALTER TABLE Ciudad AUTO_INCREMENT=0;
ALTER TABLE autocines AUTO_INCREMENT=0;