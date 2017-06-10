package br.com.sisvenda.model;

import java.sql.Connection;

import br.com.sisvenda.controller.ConexaoMySQL;

public class FornecedorDAO {

	// DECLARAÇÃO DE VARIÁVEIS
	private int idFornecedores;
	private String nome;
	private String endereco;
	private String numero;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	private String telefone;

	private FornecedorDAO forn;
	
	// MÉTODOS ACESSORES
	public int getIdFornecedores() {
		return idFornecedores;
	}

	public void setIdClientes(int Fornecedores) {
		this.idFornecedores = idFornecedores;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	// MÉTODO TOSTRING
	@Override
	public String toString() {
		return "FornecedorDAO [idFornecedores=" + idFornecedores + ", nome=" + nome + ", endereco=" + endereco + ", numero="
				+ numero + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + ", telefone="
				+ telefone + "]";
	}

	// ************************************************************************************************************
	// MÉTODO INSERIR
	// ************************************************************************************************************
	public boolean inserir(Object o) {

		try {

			forn = (FornecedorDAO) o;

			String query = "INSERT INTO fornecedores (nome, endereco, numero, bairro , cidade, uf, cep, telefone) VALUES('"
					+ forn.getNome() + "', '" + forn.getEndereco() + "', '" + forn.getNumero() + "', '" + forn.getBairro() + "', '"
					+ forn.getCidade() + "','" + forn.getUf() + "', '" + forn.getCep() + "', '" + forn.getTelefone()
					+ "')";

			Connection con = ConexaoMySQL.getInstance().getConnection();
			con.createStatement().executeUpdate(query);

			return true;

		} catch (Exception e) {
			System.err.println("Ocorreu ao inserir usuário" + e.getMessage());
		}
		return false;
	}

	public boolean atualizar(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean excluir(Object id) {
		try {

			// conexao = Conexao.conectarBanco();
			//
			// String query = "DELETE FROM usuario WHERE id = " + id;
			//
			// Statement sentenca = conexao.createStatement();
			// sentenca.execute(query);

			return true;
		} catch (Exception e) {
			System.err.println("Ocorreu um erro ao excluir usuário." + e.getMessage());
		}
		return false;
	}

	
	public Object buscarPorId(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

}
