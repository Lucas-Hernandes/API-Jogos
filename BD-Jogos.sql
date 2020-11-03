CREATE database DBJOGOS;

use DBJOGOS;

CREATE TABLE Jogos
(
	id int NOT NULL AUTO_INCREMENT,
    nome varchar (100),
    genero varchar (100),
    anoLancamento int,
    constraint pkIdJogos primary key (id)
)