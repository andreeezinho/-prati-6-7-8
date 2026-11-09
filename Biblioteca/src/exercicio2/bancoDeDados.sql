
CREATE TABLE item (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo INTEGER NOT NULL UNIQUE,
    titulo VARCHAR(150) NOT NULL,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('livro', 'revista')),
    autor VARCHAR(100),
    edicao INTEGER,
    disponivel BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE usuario (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('aluno', 'professor')),
    limite_itens INTEGER NOT NULL
);

CREATE TABLE emprestimo (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    item_id INTEGER NOT NULL REFERENCES item(id),
    usuario_id INTEGER NOT NULL REFERENCES usuario(id),
    data_retirada DATE NOT NULL,
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao DATE,
    valor_multa NUMERIC(10, 2) DEFAULT 0.00
);

--INSERINDO DADOS

INSERT INTO item (codigo, titulo, tipo, autor, edicao, disponivel)
VALUES
(1, 'Java para Iniciantes', 'livro', 'Paulo Andrade', NULL, FALSE),
(2, 'Banco de Dados SQL', 'livro', 'Carlos Souza', NULL, TRUE),
(3, 'Revista de Tecnologia', 'revista', NULL, 15, FALSE),
(4, 'Revista de Ciência', 'revista', NULL, 22, TRUE);

INSERT INTO usuario (nome, tipo, limite_itens)
VALUES
('João Silva', 'aluno', 3),
('Carlos Oliveira', 'professor', 5);

INSERT INTO emprestimo (
    item_id,
    usuario_id,
    data_retirada,
    data_devolucao_prevista,
    data_devolucao,
    valor_multa
)
VALUES
(1, 1, '2026-11-01', '2026-11-15', NULL, 0.00),
(3, 2, '2026-10-01', '2026-10-08', '2026-10-10', 2.00);