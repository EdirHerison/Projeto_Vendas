/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.model;

/**
 *
 * @author edir_
 */
public class ItensVenda {
    
    private Integer id;
    private Integer qtd;
    private Double subTotal;
    
    private Vendas venda;
    private Produtos produto;
    
   public ItensVenda (){
       
   }

    public ItensVenda(Integer id, Integer qtd, Double subTotal, Vendas venda, Produtos produto) {
        this.id = id;
        this.qtd = qtd;
        this.subTotal = subTotal;
        this.venda = venda;
        this.produto = produto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Vendas getVenda() {
        return venda;
    }

    public void setVenda(Vendas venda) {
        this.venda = venda;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }
   
   
}
