package br.com.sisvenda.controller;

import br.com.sisvenda.model.FornecedorDAO;

public class FornecedorController {

	// ************************************************************************************************************
	// MÉTODO QUE SETA OS DADOS CAPTURDOS NA ENTRADA NO OBJETO CLIENTE
	// ************************************************************************************************************
	public void inserirFornecedor(String nome, String endereco, String numero, String bairro, String cidade, String uf,
			String cep, String telefone) {

		FornecedorDAO fc = new FornecedorDAO();

		fc.setNome(nome);
		fc.setEndereco(endereco);
		fc.setNumero(numero);
		fc.setBairro(bairro);
		fc.setCidade(cidade);
		fc.setUf(uf);
		fc.setCep(cep);
		fc.setTelefone(telefone);

		fc.inserir(fc);

	}

	public void excluirFornecedor(String nemo) {

		FornecedorDAO fc = new FornecedorDAO();

		fc.excluir(nemo);
	}

}
