CREATE TABLE usuario
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    nome  VARCHAR(200)          NULL,
    email VARCHAR(150)          NULL,
    PRIMARY KEY (id)
);

insert  into usuario values (1, 'Daniel Queiroz', 'daniel@gmail.com')