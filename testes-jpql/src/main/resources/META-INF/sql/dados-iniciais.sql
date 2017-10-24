insert into proprietario (nome, telefone, email) values ('João Bosco', '3333-3333', 'email@gmail.com');
insert into proprietario (nome, telefone, email) values ('Emília Maria', '3333-3333', 'email@gmail.com');
insert into proprietario (nome, telefone, email) values ('Solano Almeida', '3333-3333', 'email@gmail.com');
insert into proprietario (nome, telefone, email) values ('Francisco Silva', '3333-3333', 'email@gmail.com');
insert into proprietario (nome, telefone, email) values ('Marta Sales', '3333-3333', 'email@gmail.com');

insert into acessorio (descricao) values ('Bancos de couro'); 
insert into acessorio (descricao) values ('Rodas de liga leve');
insert into acessorio (descricao) values ('Central multimídia');
insert into acessorio (descricao) values ('Câmera de ré'); 
insert into acessorio (descricao) values ('Sensor de estacionamento');

insert into veiculo (fabricante, modelo, ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro, cod_proprietario) values ('Fiat', 'Palio', 2010, 2010, 15000, 'GASOLINA', '2017-03-02', 1);
insert into veiculo (fabricante, modelo, ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro, cod_proprietario) values ('Chevrolet', 'Onix', 2014, 2015, 35250, 'BICOMBUSTIVEL', '2017-03-02', 5);
insert into veiculo (fabricante, modelo, ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro, cod_proprietario) values ('VW', 'Gol', 2016, 2016, 41300, 'BICOMBUSTIVEL', '2017-03-02', 2);     
insert into veiculo (fabricante, modelo, ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro, cod_proprietario) values ('Fiat', 'Punto', 2011, 2012, 22000, 'ÁLCOOL', '2017-03-02', 3);
insert into veiculo (fabricante, modelo, ano_fabricacao, ano_modelo, valor, tipo_combustivel, data_cadastro, cod_proprietario) values ('Fiat', 'Uno', 2014, 2015, 25590, 'BICOMBUSTIVEL', '2017-03-02', 4);

insert into veiculo_acessorio (cod_veiculo, cod_acessorio) values (1, 2);
insert into veiculo_acessorio (cod_veiculo, cod_acessorio) values (1, 5);
insert into veiculo_acessorio (cod_veiculo, cod_acessorio) values (2, 1);
insert into veiculo_acessorio (cod_veiculo, cod_acessorio) values (2, 2);
insert into veiculo_acessorio (cod_veiculo, cod_acessorio) values (2, 3);
insert into veiculo_acessorio (cod_veiculo, cod_acessorio) values (2, 4);
insert into veiculo_acessorio (cod_veiculo, cod_acessorio) values (2, 5);
insert into veiculo_acessorio (cod_veiculo, cod_acessorio) values (3, 1);
insert into veiculo_acessorio (cod_veiculo, cod_acessorio) values (4, 2);
insert into veiculo_acessorio (cod_veiculo, cod_acessorio) values (4, 3);
insert into veiculo_acessorio (cod_veiculo, cod_acessorio) values (4, 4);

