package br.com.maddytec.cliente.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pedido;

    @NonNull
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "item_id")
    
    private Item item;


    private Pedido() {
    	super();
    }

    public Pedido(int quantidade, Cliente cliente, Item item) {
    	super();
        this.quantidade = quantidade;
        Long id_customer = null;
		String secondName = null;
		String firstName = null;
		String cpf = null;
		this.cliente = new Cliente(id_customer, firstName, secondName, cpf);
        String nome_item = null;
		Long valor = null;
		Long id_item = null;
		this.item = new Item(id_item, nome_item, valor);
    }

    public Long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Cliente getCliente() {
    	
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

	
}
