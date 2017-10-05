insert into proprietario (nome, cpf, rg, email, telefone, foto) values ('Roberto Araújo', '000.000.000-00', '000.000.000', 'robert@gmail.com', '84 3333-6655', null);
insert into proprietario (nome, cpf, rg, email, telefone, foto) values ('Alex Silva', '000.000.000-00', '000.000.000', 'alex@gmail.com', '85 3213-0051', null);
insert into proprietario (nome, cpf, rg, email, telefone, foto) values ('Maria de Sá', '000.000.000-00', '000.000.000', 'mariasa@gmail.com', '84 3305-6521', null);

insert into veiculo (ano, modelo, foto, cor, marca, id_proprietario) values (2010, 'Palio', null, 'Branco', 'Fiat', 1);
insert into veiculo (ano, modelo, foto, cor, marca, id_proprietario) values (2016, 'Onix', null, 'Cinza', 'Chevrolet', 3);

insert into locacao (num_vaga, data_entrada, data_saida, id_veiculo) values (5, '2017-06-21', '2017-06-25', 1);
insert into locacao (num_vaga, data_entrada, data_saida, id_veiculo) values (5, '2017-09-02', '2017-09-05', 1);
insert into locacao (num_vaga, data_entrada, data_saida, id_veiculo) values (5, '2017-01-12', '2017-01-20', 2);