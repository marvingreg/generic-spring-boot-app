package generic.model.generics;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name= "items")
public class Items implements GenericModel<Items>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_generator")
	@SequenceGenerator(name = "item_generator", sequenceName = "items_id_seq", allocationSize=1)
	private Long id;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "item_description") 
	private String description;
	
	@Column(name = "item_price")
	private BigDecimal itemPrice;
	
	@Column(name = "item_image")
	private String itemImage;
	
	@Override
	public void update(Items model) {
		this.id = model.id;
		this.itemName = model.itemName;
		this.description = model.description;
		this.itemPrice = model.itemPrice;
		this.itemImage = model.itemImage;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public Items generateInstance() {
		Items createdInstance = new Items();
		createdInstance.update(this);
		
		return createdInstance;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Items [id=" + id + ", itemName=" + itemName + ", description=" + description + ", itemPrice="
				+ itemPrice + ", itemImage=" + itemImage + "]";
	}
	
	
	

}
