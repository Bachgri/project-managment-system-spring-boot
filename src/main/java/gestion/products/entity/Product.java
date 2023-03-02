package gestion.products.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	@Column(unique = true)
	private String reference;
	private String designation, discription;
	private double price;
	@OneToOne(cascade = javax.persistence.CascadeType.DETACH) 
	private Fournisseur fournisseur ;
	
	
	public Product() {}


	public Product(String reference, String designation, String discription, double price, Fournisseur fournisseur) {
		super();
		this.reference = reference;
		this.designation = designation;
		this.discription = discription;
		this.price = price;
		this.fournisseur = fournisseur;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getDiscription() {
		return discription;
	}


	public void setDiscription(String discription) {
		this.discription = discription;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Fournisseur getFournisseur() {
		return fournisseur;
	}


	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", reference=" + reference + ", designation=" + designation + ", discription="
				+ discription + ", price=" + price + ", fournisseur=" + fournisseur + "]";
	}
	
	
}
