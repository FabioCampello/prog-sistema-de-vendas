CREATE TABLE Clientes (
  idClientes INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  endereco VARCHAR(255) NOT NULL,
  numero INTEGER NOT NULL,
  bairro VARCHAR(60) NOT NULL,
  cidade VARCHAR(60) NOT NULL,
  uf VARCHAR(2) NOT NULL,
  cep VARCHAR(10) NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  PRIMARY KEY(idClientes)
);

CREATE TABLE Fornecedores (
  idFornecedores INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  endereco VARCHAR(255) NOT NULL,
  numero INTEGER NOT NULL,
  bairro VARCHAR(255) NOT NULL,
  cidade VARCHAR(60) NOT NULL,
  uf VARCHAR(2) NOT NULL,
  cep VARCHAR(10) NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  PRIMARY KEY(idFornecedores)
);

CREATE TABLE Produtos (
  idProdutos INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Fornecedores_idFornecedores INTEGER UNSIGNED NOT NULL,
  nome VARCHAR(255) NULL,
  valor DOUBLE NULL,
  estoque INTEGER UNSIGNED NULL,
  PRIMARY KEY(idProdutos),
  INDEX Produtos_FKIndex1(Fornecedores_idFornecedores)
);

CREATE TABLE Vendas (
  idVendas INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  Produtos_idProdutos INTEGER UNSIGNED NOT NULL,
  Clientes_idClientes INTEGER UNSIGNED NOT NULL,
  Data_vendas DATE NULL,
  PRIMARY KEY(idVendas),
  INDEX Vendas_FKIndex1(Clientes_idClientes),
  INDEX Vendas_FKIndex2(Produtos_idProdutos)
);


