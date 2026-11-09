SELECT
    codigo,
    titulo,
    tipo,
    disponivel
FROM item;

SELECT
    usuario.nome,
    item.titulo
FROM emprestimo
INNER JOIN usuario ON emprestimo.usuario_id = usuario.id
INNER JOIN item ON emprestimo.item_id = item.id
WHERE emprestimo.data_devolucao IS NULL;

SELECT
    usuario.nome,
    SUM(emprestimo.valor_multa) AS total_multas
FROM usuario
INNER JOIN emprestimo ON usuario.id = emprestimo.usuario_id
GROUP BY usuario.id, usuario.nome;

SELECT
    item.codigo,
    item.titulo,
    item.tipo
FROM item
LEFT JOIN emprestimo ON item.id = emprestimo.item_id
WHERE emprestimo.item_id IS NULL;