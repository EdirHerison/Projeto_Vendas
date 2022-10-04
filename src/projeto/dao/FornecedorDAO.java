package projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import projeto.connection.ConnectionFactory;
import projeto.model.Fornecedores;
import projeto.util.WebServiceCep;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author edir_
 */
public class FornecedorDAO {
    
        private Connection conn;
    
    
    public FornecedorDAO(){
        this.conn = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarFornecedor(Fornecedores obj){
        
        try {

            String sql = "INSERT INTO tb_fornecedores (nome, cnpj, email, telefone, celular,"
                    + " cep, endereco, numero, complemento, bairro, cidade, estado)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setString(1, obj.getNome());
            st.setString(2, obj.getCnpj());
            st.setString(3, obj.getEmail());
            st.setString(4, obj.getTelefone());
            st.setString(5, obj.getCelular());
            st.setString(6, obj.getCep());
            st.setString(7, obj.getEndereco());
            st.setInt(8, obj.getNumero());
            st.setString(9, obj.getComplemento());
            st.setString(10, obj.getBairro());
            st.setString(11, obj.getCidade());
            st.setString(12, obj.getEstado());
            
            st.execute();
            st.close();
            
            
            JOptionPane.showMessageDialog(null, "Novo Fornecedor cadastrado com Sucesso");
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro!!" + e);
        }
        
    }
    
    public List<Fornecedores> listaFornecedores (){
        try {
            List<Fornecedores> lista = new ArrayList<>();
            String sql = "SELECT * FROM tb_fornecedores";
            PreparedStatement st = conn.prepareStatement(sql);
            
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Fornecedores forn = new Fornecedores();
                forn.setId(rs.getInt("id"));
                forn.setNome(rs.getString("nome"));
                forn.setCnpj(rs.getString("cnpj"));
                forn.setEmail(rs.getString("email"));
                forn.setTelefone(rs.getString("telefone"));
                forn.setCelular(rs.getString("celular"));
                forn.setCep(rs.getString("cep"));
                forn.setEndereco(rs.getString("endereco"));
                forn.setNumero(rs.getInt("numero"));
                forn.setComplemento(rs.getString("complemento"));
                forn.setBairro(rs.getNString("bairro"));
                forn.setCidade(rs.getString("cidade"));
                forn.setEstado(rs.getString("estado"));
                lista.add(forn);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro !!" + e);
            return null;
        }
    }
    
    public Fornecedores buscaFornecedorNome(String nome){
        try {
            String sql = "SELECT * FROM tb_fornecedores WHERE nome LIKE = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nome);
            ResultSet rs = st.executeQuery();
            Fornecedores forn = new Fornecedores();
            
            if(rs.next()){
                forn.setId(rs.getInt("id"));
                forn.setNome(rs.getString("nome"));
                forn.setCnpj(rs.getString("cnpj"));
                forn.setEmail(rs.getString("email"));
                forn.setTelefone(rs.getString("telefone"));
                forn.setCelular(rs.getString("celular"));
                forn.setCep(rs.getString("cep"));
                forn.setEndereco(rs.getString("endereco"));
                forn.setNumero(rs.getInt("numero"));
                forn.setComplemento(rs.getString("complemento"));
                forn.setBairro(rs.getNString("bairro"));
                forn.setCidade(rs.getString("cidade"));
                forn.setEstado(rs.getString("estado"));
               
            }
             return forn;
        } catch (Exception e) {
        }
        return null;
    }
    
    public void alteraFornecedor(Fornecedores obj){
        try {
            String sql = "UPDATE tb_fornecedores SET "
                    + "nome=?, "
                    + "cnpj=?, "
                    + "email=?, "
                    + "telefone=?, "
                    + "celular=?, "
                    + "cep=?, "
                    + "endereco=?, "
                    + "numero=?, "
                    + "complemento=?, "
                    + "bairro=?, "
                    + "cidade=?, "
                    + "estado=? "
                    + "WHERE id= ?";
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setString(1, obj.getNome());
            st.setString(2, obj.getCnpj());
            st.setString(3, obj.getEmail());
            st.setString(4, obj.getTelefone());
            st.setString(5, obj.getCelular());
            st.setString(6, obj.getCep());
            st.setString(7, obj.getEndereco());
            st.setInt(8, obj.getNumero());
            st.setString(9, obj.getComplemento());
            st.setString(10, obj.getBairro());
            st.setString(11, obj.getCidade());
            st.setString(12, obj.getEstado());
            st.setInt(13, obj.getId());
 
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null, "Fornecedor alterado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!!" + e);
        }
    }
    
    public void deletarFornecedor(Fornecedores obj){
        try {
            String sql = "DELETE FROM tb_fornecedores WHERE id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, obj.getId());
            st.execute();
            st.close();
            
            JOptionPane.showMessageDialog(null,"Fornecedor deletado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro!" + e);
        }
        
    }
    
    public Fornecedores buscaCep(String cep) {
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       
        Fornecedores obj = new Fornecedores();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setEstado(webServiceCep.getUf());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }

    }
    
}
