package com.me.myapp.model;



import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "product")
public class Product implements Serializable {
	
	private static final long serialVersionUID = 5685719087426913438L;

	
	@Id
	@Column(name = "productId")
	// below line was commented earlier
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	
	@NotEmpty(message = "Product Name is mandatory")
	@Column(name = "productName")
	private String productName;
	
	@Column(name = "productCategory")
	private String productCategory;
	
	@Column(name = "productDescription")
	private String productDescription;
	
	@NotNull(message="Please provide some price")
	@Min(value = 10, message = "Minimum value should be greater than 10")
	@Column(name = "productPrice")
	private double productPrice;
	
	@Column(name = "productCondition")
	private String productCondition;
	
	@Column(name = "productStatus")
	private String productStatus;
	
	@Min(value = 1, message = "Units should be 0 or greater than 0")
	@Column(name = "unitInStock")
	private int unitInStock;
	
	@Column(name = "productManufacturer")
	private String productManufacturer;
	
	@Transient
	private MultipartFile productImage;
	
	// New code
	// Parent child relationship. Cascade type is used to delete all child if the parent is deleted. 
	// There are two types of fetch types --> Lazy and Eager. Eager will by default load ALL of the relationships related to a particular object loaded by Hibernate
	
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonIgnore
	private List<CartItem> cartItemList;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCondition() {
		return productCondition;
	}
	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public int getUnitInStock() {
		return unitInStock;
	}
	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}
	public String getProductManufacturer() {
		return productManufacturer;
	}
	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}
	
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	public List<CartItem> getCartItemList() {
		return cartItemList;
	}
	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}
	
	
//	public Product(String productId, String productName, String productCategory, String productDescription,
//			double productPrice, String productCondition, String productStatus, int unitInStock,
//			String productManufacturer) {
//		super();
//		this.productId = productId;
//		this.productName = productName;
//		this.productCategory = productCategory;
//		this.productDescription = productDescription;
//		this.productPrice = productPrice;
//		this.productCondition = productCondition;
//		this.productStatus = productStatus;
//		this.unitInStock = unitInStock;
//		this.productManufacturer = productManufacturer;
//	}
//	
//	public Product() {
//
//	}
}

