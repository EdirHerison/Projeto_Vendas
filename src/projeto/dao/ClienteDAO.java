/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import projeto.connection.ConnectionFactory;
import projeto.model.Clientes;

/**
 *
 * @author edir_
 */
public class ClienteDAO {
    
    private Connection conn;
    
    
    public ClienteDAO(){
        this.conn = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarCliente(Clientes obj){
        
        try {

            String sql = "INSERT INTO tb_clientes (nome, rg, cpf, email, telefone, celular,"
                    + " cep, enderco, numero, complemento, bairro, cidade, estado)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setString(1, obj.getNome());
            st.setString(2, obj.getRg());
            st.setString(3, obj.getCpf());
            st.setString(4, obj.getEmail());
            st.setString(5, obj.getTelefone());
            st.setString(6, obj.getCelular());
            st.setString(7, obj.getCep());
            st.setString(8, obj.getEndereco());
            st.setInt(9, obj.getNumero());
            st.setString(10, obj.getComplemento());
            st.setString(11, obj.getBairro());
            st.setString(12, obj.getCidade());
            st.setString(13, obj.getEstado());
            
            st.execute();
            st.close();
            
            
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro!!" + e);
        }
        
    }
    
    public void alterarCliente(){
        
    }
    
    public void deletarCliente(){
        
    }
    
}
