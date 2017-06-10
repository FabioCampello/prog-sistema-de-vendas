package br.com.sisvenda.controller;

import br.com.sisvenda.model.ClienteDAO;

public class ClienteController {

	// ************************************************************************************************************
	// MÉTODO QUE SETA OS DADOS CAPTURDOS NA ENTRADA NO OBJETO CLIENTE
	// ************************************************************************************************************
	public void inserirCliente(String nome, String endereco, String numero, String bairro, String cidade, String uf,
			String cep, String telefone) {

		ClienteDAO cd = new ClienteDAO();

		cd.setNome(nome);
		cd.setEndereco(endereco);
		cd.setNumero(numero);
		cd.setBairro(bairro);
		cd.setCidade(cidade);
		cd.setUf(uf);
		cd.setCep(cep);
		cd.setTelefone(telefone);

		cd.inserir(cd);

	}

	public void excluirCliente(String nemo) {

		ClienteDAO cd = new ClienteDAO();

		cd.excluir(nemo);
	}

}
