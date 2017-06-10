package br.com.sisvenda.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import br.com.sisvenda.model.ClienteDAO;

public class ClienteControl {
	
	ConexaoMySQL con;
	PreparedStatement pt;
	ResultSet rs;
	
	String consultaCliente = "SELECET * FROM CLIENTES WHERE NOME LIKE ?";
	
	//MÉTODO PARA LISTAR OS CLIENTES
	public List<ClienteDAO> listarClientes(String nome){
		
		List<ClienteDAO> clientes = null;
		
		try{
			
			Connection con = ConexaoMySQL.getInstance().getConnection();
			rs = con.createStatement().executeQuery(consultaCliente);
			pt.setString(1, nome);//SELECET * FROM CLIENTES WHERE NOME LIKE
			
			rs = pt.executeQuery();//AEMAZENANDO A CONSULTA DO PREPARESTATEMENT NO RESULTSET
			
			ClienteDAO cli;
			
			while(rs.next()){
				
				cli = new ClienteDAO();
				
				cli.setIdClientes(rs.getInt("idClientes"));
				cli.setNome(rs.getString("nome"));
				cli.setEndereco(rs.getString("endereco"));
				cli.setBairro(rs.getString("bairro"));
				cli.setCidade(rs.getString("cidade"));
				cli.setUf(rs.getString("uf"));
				cli.setCep(rs.getString("cep"));
				cli.setTelefone(rs.getString("telefone"));
				
				clientes.add(cli);
			
			}
			
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Listando Clientes", "Consulta de Clientes", JOptionPane.INFORMATION_MESSAGE);
		}
		
		return clientes;
	}

}
