/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.model;

import java.util.Date;

/**
 *
 * @author edir_
 */
public class Vendas {
    private Integer id;
    private Date dataVenda;
    private Double totalVenda;
    private String observacao;
    
    private Clientes cliente;
    
    public Vendas (){
        
    }

    public Vendas(Integer id, Date dataVenda, Double totalVenda, String observacao, Clientes cliente) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.totalVenda = totalVenda;
        this.observacao = observacao;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(Double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
    
    
}
