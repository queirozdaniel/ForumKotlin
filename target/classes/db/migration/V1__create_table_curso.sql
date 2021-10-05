CREATE TABLE curso
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    nome      VARCHAR(75)          NULL,
    categoria VARCHAR(50)          NULL,
    PRIMARY KEY (id)
);

insert into curso values (1, 'Kotlin', 'PROGRAMACAO');