INSERT INTO clientes (nome) VALUES ('Roberto');
INSERT INTO clientes (nome) VALUES ('Luiza');
INSERT INTO clientes (nome) VALUES ('Adam');

INSERT INTO veiculos (cor, marca, modelo, placa, cliente_id) VALUES ('Blue', 'Alga', 'BC34', 'BCD4545', 1);
INSERT INTO veiculos (cor, marca, modelo, placa, cliente_id) VALUES ('Green', 'WM', 'Sports Hibrid', 'GLK6896', 2);
INSERT INTO veiculos (cor, marca, modelo, placa, cliente_id) VALUES ('Grey', 'Tesla', 'Jungle Tank', 'MIR7838', 3);

INSERT INTO ordens_servico (descricao, preco, cliente_id, veiculo_id) VALUES ('Manutenção', 800, 1, 1)
#INSERT INTO ordens_servico (descricao, preco, cliente_id, veiculo_id) VALUES ('Manutenção', 800, 2, 2)
#INSERT INTO ordens_servico (descricao, preco, cliente_id, veiculo_id) VALUES ('Manutenção', 800, 3, 3)
