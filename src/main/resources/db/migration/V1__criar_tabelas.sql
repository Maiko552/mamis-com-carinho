CREATE SEQUENCE pedido_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE pedido (
  id            BIGINT PRIMARY KEY DEFAULT nextval('pedido_seq'),
  cliente_nome  VARCHAR(255) NOT NULL,
  descricao     TEXT        NOT NULL,
  data_pedido   TIMESTAMP   NOT NULL DEFAULT now(),
  data_entrega  DATE,
  status        VARCHAR(50) NOT NULL,
  valor         NUMERIC(10, 2) NOT NULL
);
