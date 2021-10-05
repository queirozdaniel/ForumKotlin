CREATE TABLE topico
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    titulo       VARCHAR(200)          NULL,
    mensagem     VARCHAR(255)          NULL,
    data_criacao datetime              NULL,
    curso_id     BIGINT                NULL,
    autor_id     BIGINT                NULL,
    status       VARCHAR(255)          NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (autor_id) REFERENCES usuario (id),
    FOREIGN KEY (curso_id) REFERENCES curso (id)
);
