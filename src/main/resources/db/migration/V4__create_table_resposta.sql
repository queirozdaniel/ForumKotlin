CREATE TABLE resposta
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    mensagem     VARCHAR(300)          NOT NULL,
    data_criacao datetime              NOT NULL,
    autor_id     BIGINT                NOT NULL,
    topico_id    BIGINT                NOT NULL,
    solucao      BIT(1)                NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (autor_id) REFERENCES usuario (id),
    FOREIGN KEY (topico_id) REFERENCES topico (id)

);