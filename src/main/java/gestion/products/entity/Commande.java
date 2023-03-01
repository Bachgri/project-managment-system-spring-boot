package gestion.products.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "integer default 1")
	private int quantite;
	@Column(columnDefinition = "float default 0")
	private double prix_vente;
	private Timestamp timestamp;
	private String Status;
	@OneToOne(cascade = CascadeType.DETACH) 
	Client client;
	@ManyToMany(cascade = CascadeType.DETACH )
	private Set<Product> products;
	public Commande() {
	}
	public Commande(Long id, int quantite, double prive_vente, Timestamp timestamp, String status, Client client,
			Set<Product> products) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.prix_vente = prive_vente;
		this.timestamp = timestamp;
		Status = status;
		this.client = client;
		this.products = products;
	}
	public Commande(int quantite, double prive_vente, Timestamp timestamp, String status, Client client,
			Set<Product> products) {
		super();
		this.quantite = quantite;
		this.prix_vente = prive_vente;
		this.timestamp = timestamp;
		Status = status;
		this.client = client;
		this.products = products;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	public double getPrix_vente() {
		return prix_vente;
	}
	public void setPrix_vente(double prix_vente) {
		this.prix_vente = prix_vente;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Commande [id=" + id + ", quantite=" + quantite + ", prix_vente=" + prix_vente + ", timestamp="
				+ timestamp + ", Status=" + Status + ", client=" + client + ", products=" + products + "]";
	}
	
	
	
}
