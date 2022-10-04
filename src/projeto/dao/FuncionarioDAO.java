/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import projeto.connection.ConnectionFactory;
import projeto.model.Funcionarios;
import projeto.util.WebServiceCep;
import projeto.view.FrmLogin;
import projeto.view.FrnMenu;

/**
 *
 * @author edir_
 */
public class FuncionarioDAO {
    
    private Connection conn;
    
    public FuncionarioDAO(){
        this.conn = new ConnectionFactory().getConnection();
    }
    
    public void cadastroFuncionario(Funcionarios obj){
        
        try {

            String sql = "INSERT INTO tb_funcionario (nome,rg,cpf,email,"
                    + "senha,cargo,nivel_acesso,telefone,celular,"
                    + "cep,enderco,numero,complemento,bairro,cidade,estado)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setString(1, obj.getNome());
            st.setString(2, obj.getRg());
            st.setString(3, obj.getCpf());
            st.setString(4, obj.getEmail());
            st.setString(5, obj.getSenha());
            st.setString(6, obj.getCargo());
            st.setString(7, obj.getNivelAcesso());
            st.setString(8, obj.getTelefone());
            st.setString(9, obj.getCelular());
            st.setString(10, obj.getCep());
            st.setString(11, obj.getEndereco());
            st.setInt(12, obj.getNumero());
            st.setString(13, obj.getComplemento());
            st.setString(14, obj.getBairro());
            st.setString(15, obj.getCidade());
            st.setString(16, obj.getEstado());
            
            st.execute();
            st.close();
            
            
            JOptionPane.showMessageDialog(null, "Funcionário Cadastrado");
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro!!" + e);
        }
        
    }
    
    public Funcionarios pesquisarFuncNome(String nome){
        try {
            String sql ="SELECT * FROM tb_funcionario WHERE nome=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nome);
            ResultSet rs = st.executeQuery();
            Funcionarios obj = new Funcionarios();
            
            if(rs.next()){
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivelAcesso(rs.getString("nivel_acesso"));
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
            JOptionPane.showMessageDialog(null, "Funcionário não consta na Base de Dados");
            return null;
        }
    }
    
    public List<Funcionarios> buscaFuncNome(String nome){
        try {
            List<Funcionarios> list = new ArrayList<>();
            String sql = "SELECT * FROM tb_funcionario WHERE nome LIKE ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nome);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Funcionarios obj = new Funcionarios();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivelAcesso(rs.getString("nivel_acesso"));
                obj.setCelular(rs.getString("celular"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("enderco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                list.add(obj);   
            }
             return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro !!" + e);
            return null;
        }
    }
    
    public List<Funcionarios> listarFunci(){
        try {
            List<Funcionarios> list = new ArrayList<>();
            String sql = "SELECT * FROM tb_funcionario";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Funcionarios obj = new Funcionarios();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivelAcesso(rs.getString("nivel_acesso"));
                obj.setCelular(rs.getString("celular"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("enderco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                list.add(obj);   
        }
            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro !!" + e);
            return null;
        }
        
    }
    
    public void alterarFuncionario(Funcionarios obj){
        try {
            String sql = "UPDATE tb_funcionario SET "
                    + "nome=?, "
                    + "rg=?, "
                    + "cpf=?, "
                    + "email=?, "
                    + "senha=?, "
                    + "cargo=?, "
                    + "nivel_acesso=?, "
                    + "telefone=?, "
                    + "celular=?, "
                    + "cep=?, "
                    + "enderco=?, "
                    + "numero=?, "
                    + "complemento=?, "
                    + "bairro=?, "
                    + "cidade=?, "
                    + "estado=? "
                    + "WHERE id=?";
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setString(1, obj.getNome());
            st.setString(2, obj.getRg());
            st.setString(3, obj.getCpf());
            st.setString(4, obj.getEmail());
            st.setString(5, obj.getSenha());
            st.setString(6, obj.getCargo());
            st.setString(7, obj.getNivelAcesso());
            st.setString(8, obj.getTelefone());
            st.setString(9, obj.getCelular());
            st.setString(10, obj.getCep());
            st.setString(11, obj.getEndereco());
            st.setInt(12, obj.getNumero());
            st.setString(13, obj.getComplemento());
            st.setString(14, obj.getBairro());
            st.setString(15, obj.getCidade());
            st.setString(16, obj.getEstado());
            st.setInt(17, obj.getId());
            
            st.execute();
            st.close();
            JOptionPane.showMessageDialog(null, "Dados do Funcionário alterados com Sucesso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro!!" + e);
        }
    }
    
    public void deletarFuncionario(Funcionarios obj){
        try {
            String sql = "DELETE FROM tb_funcionario WHERE id = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, obj.getId());
            st.execute();
            st.close();
            JOptionPane.showMessageDialog(null, "Funcionário excluído com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro!!" + e);
        }  
    }
    
    public Funcionarios buscaCep(String cep) {
       
        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
       
        Funcionarios obj = new Funcionarios();

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
    
    public void login(String email, String senha){
        try {
            String sql ="SELECT * FROM tb_funcionario WHERE email= ? and senha= ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, senha);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Bem vindo ao SCV");
                FrnMenu tela = new FrnMenu();
                tela.usuariologado=rs.getString("nome");
                tela.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Falha ao acessar o sistema");
                new FrmLogin().setVisible(true);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!!" + e);
        }
    }
    
}
