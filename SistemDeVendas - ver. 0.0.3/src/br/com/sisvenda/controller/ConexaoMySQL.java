package br.com.sisvenda.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoMySQL {

	private static ConexaoMySQL instance = null;
	private Connection connection = null;

	private ConexaoMySQL() {
		try {

			String driverName = "com.mysql.jdbc.Driver";
			Class.forName(driverName);

			String serverName = "127.0.0.1";

			String dbName = "sysvenda";
			String url = "jdbc:mysql://" + serverName + "/" + dbName;

			String username = "root";
			String password = "";

			connection = DriverManager.getConnection(url, username, password);

			if (connection != null) {

				System.out.println("STATUS--->Conectado " + "com sucesso!");

			} else {

				String msg = "Não foi possivel realizar a conexão com o banco de dados!";
				JOptionPane.showMessageDialog(null, msg, "ERRO DE CONEXÃO", JOptionPane.ERROR_MESSAGE);

				System.err.println("STATUS--->Não foi " + "possivel realizar conexão");
			}
			connection.setAutoCommit(true);
		} catch (ClassNotFoundException e) {

			String msg = "O driver expecificado não foi encontrado.";
			JOptionPane.showMessageDialog(null, msg, "ERRO DE CONEXÃO", JOptionPane.ERROR_MESSAGE);

			System.out.println("O driver expecificado" + " nao foi encontrado.");

		} catch (SQLException e) {

			String msg = "Nao foi possivel conectar ao Banco de Dados.";
			JOptionPane.showMessageDialog(null, msg, "ERRO DE CONEXÃO", JOptionPane.ERROR_MESSAGE);

			System.out.println("Nao foi possivel" + " conectar ao Banco de Dados.");
			e.printStackTrace();
		}
	}

	public static ConexaoMySQL getInstance() {
		if (instance == null) {
			instance = new ConexaoMySQL();
		}
		return instance;
	}

	public java.sql.Connection getConnection() {
		return connection;
	}

}