package br.com.sisvenda.model;

import java.sql.Connection;
import java.sql.Statement;

import br.com.sisvenda.controller.ConexaoMySQL;

public class ClienteDAO {

	// DECLARAÇÃO DE VARIÁVEIS
	private int idClientes;
	private String nome;
	private String endereco;
	private String numero;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	private String telefone;

	private ClienteDAO user;

	// MÉTODOS ACESSORES
	public int getIdClientes() {
		return idClientes;
	}

	public void setIdClientes(int idClientes) {
		this.idClientes = idClientes;
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
		return "ClienteBean [idClientes=" + idClientes + ", nome=" + nome + ", endereco=" + endereco + ", numero="
				+ numero + ", bairro=" + bairro + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + ", telefone="
				+ telefone + "]";
	}

	// ************************************************************************************************************
	// MÉTODO INSERIR CLIENTE
	// ************************************************************************************************************
	public boolean inserir(Object o) {

		try {

			user = (ClienteDAO) o;

			String query = "INSERT INTO clientes (nome, endereco, numero, bairro , cidade, uf, cep, telefone) VALUES('"
					+ user.getNome() + "', '" + user.getEndereco() + "', '" + user.getNumero() + "', '"
					+ user.getBairro() + "', '" + user.getCidade() + "','" + user.getUf() + "', '" + user.getCep()
					+ "', '" + user.getTelefone() + "')";

			Connection con = ConexaoMySQL.getInstance().getConnection();
			con.createStatement().executeUpdate(query);

			return true;

		} catch (Exception e) {
			System.err.println("Ocorreu ao inserir usuário" + e.getMessage());
		}
		return false;
	}

	// ************************************************************************************************************
	// MÉTODO EXCLUIR CLIENTE
	// ************************************************************************************************************
	public boolean excluir(String o) {
		try {

			String query = "DELETE FROM clientes WHERE nome = '"+ o +"'";
						
			Connection con = ConexaoMySQL.getInstance().getConnection();
			con.createStatement().executeUpdate(query);

			return true;

		} catch (Exception e) {
			System.err.println("Ocorreu um erro ao excluir usuário." + e.getMessage());
		}
		return false;
	}

}
