package br.com.maddytec.cliente.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Compras {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_compras;
	
	public Long getId_compras() {
		return id_compras;
	}

	public void setId_compras(Long id_compras) {
		this.id_compras = id_compras;
	}

	@OneToOne
	@Transient
    @JoinColumn(name = "id_customer")
    private Cliente id_customer;
	
	@Transient
	@JoinColumn(name = "firstName")
	private Cliente firstName;
	
	@Transient
	@JoinColumn(name = "secondName")
	private Cliente secondName;
	
	@OneToOne
    @JoinColumn(name = "item_id")
	@Transient
    private Item id_item;
	
	@JoinColumn(name = "nome_item")
	@Transient
	private Item nome_item;
	
	@JoinColumn(name = "valor_item")
	@Transient
	private Item valor;
	
	@OneToOne
	@JoinColumn (name="id_pedido")
	@Transient
	private Pedido id_pedido;
	
	@JoinColumn (name = "quantidade")
	@Transient
	private Pedido quantidade;
	
	private Compras () {
		super();
	}

	public Compras(Long id_compras, Cliente id_customer, Cliente firstName, Cliente secondName, Item id_item,
			Item nome_item, Item valor, Pedido id_pedido, Pedido quantidade) {
		super();
		
		this.id_customer = id_customer;
		this.firstName = firstName;
		this.secondName = secondName;
		this.id_item = id_item;
		this.nome_item = nome_item;
		this.valor = valor;
		this.id_pedido = id_pedido;
		this.quantidade = quantidade;
	}

	

	

	public Cliente getId_customer() {
		return id_customer;
	}

	public void setId_customer(Cliente id_customer) {
		this.id_customer = id_customer;
	}

	public Cliente getFirstName() {
		return firstName;
	}

	public void setFirstName(Cliente firstName) {
		this.firstName = firstName;
	}

	public Cliente getSecondName() {
		return secondName;
	}

	public void setSecondName(Cliente secondName) {
		this.secondName = secondName;
	}

	public Item getId_item() {
		return id_item;
	}

	public void setId_item(Item id_item) {
		this.id_item = id_item;
	}

	public Item getNome_item() {
		return nome_item;
	}

	public void setNome_item(Item nome_item) {
		this.nome_item = nome_item;
	}

	public Item getValor() {
		return valor;
	}

	public void setValor(Item valor) {
		this.valor = valor;
	}

	public Pedido getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Pedido id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Pedido getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Pedido quantidade) {
		this.quantidade = quantidade;
	}
	
	
	

}
