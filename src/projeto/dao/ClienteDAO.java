/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.dao;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import projeto.connection.ConnectionFactory;
import projeto.model.Clientes;
import projeto.util.WebServiceCep;

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
            
            
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso");
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro!!" + e);
        }
        
    }
    
    public List<Clientes> listarClientes(){
        try {
            
            List<Clientes> lista = new ArrayList<>();
            String sql = "SELECT * FROM tb_clientes";
            PreparedStatement st = conn.prepareStatement(sql);
            
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("celular"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("enderco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                lista.add(obj);
            }
            return lista; 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro !!" + e);
            return null;
        }
    }
    
    public Clientes consultaClienteNome(String nome){
        try {
            String sql = "SELECT * FROM tb_clientes WHERE nome=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nome);
            ResultSet rs = st.executeQuery();
            Clientes obj = new Clientes();
            
            if(rs.next()){
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("celular"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("enderco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
            }
            return obj; 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente n??o consta na Base de Dados");
            return null;
        }    
    }
    
    public Clientes buscaCPF(String cpf){
        try {
            String sql = "SELECT * FROM tb_clientes WHERE cpf = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cpf);
            ResultSet rs = st.executeQuery();
            Clientes cli = new Clientes();
            
            if(rs.next()){
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("nome"));
                cli.setRg(rs.getString("rg"));
                cli.setCpf(rs.getString("cpf"));
                cli.setEmail(rs.getString("email"));
                cli.setCelular(rs.getString("celular"));
                cli.setTelefone(rs.getString("telefone"));
                cli.setCep(rs.getString("cep"));
                cli.setEndereco(rs.getString("enderco"));
                cli.setNumero(rs.getInt("numero"));
                cli.setComplemento(rs.getString("complemento"));
                cli.setBairro(rs.getString("bairro"));
                cli.setCidade(rs.getString("cidade"));
                cli.setEstado(rs.getString("estado"));
            }
            return cli;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CPF n??o encontrado na Base de Dados");
            return null;
        }  
    }
    
    public List<Clientes> buscaClienteNome(String nome){
        try {
            
            List<Clientes> lista = new ArrayList<>();
            String sql = "SELECT * FROM tb_clientes WHERE nome LIKE ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nome);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("celular"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("enderco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                lista.add(obj);
            }
            return lista; 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro !!" + e);
            return null;
        }
        
    }
    
    public void alterarCliente(Clientes obj){
        try {

            String sql = "UPDATE tb_clientes SET "
                    + "nome=?, "
                    + "rg=?, "
                    + "cpf=?, "
                    + "email=?, "
                    + "telefone=?, "
                    + "celular=?, "
                    + "cep=?, "
                    + "enderco=?, "
                    + "numero=?, "
                    + "complemento=?, "
                    + "bairro=?, "
                    + "cidade=?, "
                    + "estado=? "
                    + "WHERE id= ?";
            
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
            st.setInt(14, obj.getId());
            
            st.execute();
            st.close();
            
            
            JOptionPane.showMessageDialog(null, "Dados do cliente alterados com Sucesso");
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro!!" + e);
        }
    }
    
   public void deletarCliente(Clientes obj){
       try {

            String sql = "DELETE FROM tb_cliente WHERE id = ?";
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, obj.getId());
            st.execute();
            st.close();
            JOptionPane.showMessageDialog(null, "Cliente Deletado com Sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro!!" + e);
        }
   }
   
   
   public Clientes buscaCep(String cep) {
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       
        Clientes obj = new Clientes();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setEstado(webServiceCep.getUf());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descri????o do erro: " + webServiceCep.getResultText());
            return null;
        }

    }
    
}
