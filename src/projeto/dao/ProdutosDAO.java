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
import projeto.model.Fornecedores;
import projeto.model.Produtos;
import projeto.util.WebServiceCep;

/**
 *
 * @author edir_
 */
public class ProdutosDAO {
    
    private Connection conn;
    
    
    public ProdutosDAO(){
        this.conn = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarProduto(Produtos obj){
        
        try {

            String sql = "INSERT INTO tb_produtos (descricao, preco, qtd_estoque, for_id)"
                    + " VALUES (?, ?, ?, ?)";
            
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setString(1, obj.getDescricao());
            st.setDouble(2, obj.getPreco());
            st.setInt(3, obj.getQtdEstoque());
            st.setInt(4, obj.getFornecedor().getId());
            
            st.execute();
            st.close();
            
            
            JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso");
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro!!" + e);
        }
        
    }
    
    public List<Produtos> listarProdutos(){
        try {
            
            List<Produtos> lista = new ArrayList<>();
            String sql = "SELECT p.id, p.descricao, p.preco, p.qtd_estoque, f.nome "
                    + "FROM tb_produtos as p "
                    + "INNER JOIN tb_fornecedores as f on (p.for_id = f.id)";
            PreparedStatement st = conn.prepareStatement(sql);
            
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setQtdEstoque(rs.getInt("p.qtd_estoque"));
                obj.setPreco(rs.getDouble("p.preco"));
                
                f.setNome(rs.getString("f.nome"));
                
                obj.setFornecedor(f);
                
                lista.add(obj);
            }
            return lista; 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro !!" + e);
            return null;
        }
    }
    
    public Produtos consultaProdutoNome(String nome){
        try {
            String sql = "SELECT p.id, p.descricao, p.preco, p.qtd_estoque, f.nome "
                    + "FROM tb_produtos as p "
                    + "INNER JOIN tb_fornecedores as f on (p.for_id = f.id) "
                    + "WHERE p.descricao = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nome);
            ResultSet rs = st.executeQuery();
            Produtos obj = new Produtos();
            Fornecedores forn = new Fornecedores();
            
            if(rs.next()){
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setQtdEstoque(rs.getInt("p.qtd_estoque"));
                obj.setPreco(rs.getDouble("p.preco"));
                
                forn.setNome(rs.getString(("f.nome")));
                
                obj.setFornecedor(forn);
                
            }
            return obj;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Produto não consta na Base de Dados");
            return null;
        }    
    }
    
    public List<Produtos> buscaProdutosNome(String nome){
        try {
            
            List<Produtos> lista = new ArrayList<>();
            String sql = "SELECT p.id, p.descricao, p.preco, p.qtd_estoque, f.nome "
                    + "FROM tb_produtos as p "
                    + "INNER JOIN tb_fornecedores as f on (p.for_id = f.id) "
                    + "WHERE p.descricao LIKE ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nome);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setQtdEstoque(rs.getInt("p.qtd_estoque"));
                obj.setPreco(rs.getDouble("p.preco"));
                
                f.setNome(rs.getString("f.nome"));
                
                obj.setFornecedor(f);
                
                lista.add(obj);
            }
            return lista; 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro !!" + e);
            return null;
        }
        
    }
    
    public void alterarProduto(Produtos obj){
        try {

            String sql = "UPDATE tb_produtos SET "
                    + "descricao=?, "
                    + "preco=?, "
                    + "qtd_estoque=?, "
                    + "for_id=? "
                    + "WHERE id= ?";
            
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setString(1, obj.getDescricao());
            st.setDouble(2, obj.getPreco());
            st.setInt(3, obj.getQtdEstoque());
            st.setInt(4, obj.getFornecedor().getId());
            st.setInt(5, obj.getId());
            
            st.execute();
            st.close();
            
            
            JOptionPane.showMessageDialog(null, "Dados do produto alterados com Sucesso");
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro!!" + e);
        }
    }
    
   public void deletarProduto(Produtos obj){
       try {

            String sql = "DELETE FROM tb_produtos WHERE id = ?";
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, obj.getId());
            st.execute();
            st.close();
            JOptionPane.showMessageDialog(null, "Produto Deletado com Sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro!!" + e);
        }
   }
  
   
    
}
