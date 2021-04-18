package entyties;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "PRODUCT")
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    @Column(name ="PRODUCT_NAME")
    private String productName;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="producent_station_id")
    private ProducentStation producentStation;
    
    @OneToMany(mappedBy = "product")
    private List<OrderCiment> orderCiment;

	public Product() {
		
	}

	public Product(int id, String productName, ProducentStation producentStation) {
		this.id = id;
		this.productName = productName;
		this.producentStation = producentStation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProducentStation getProducentStation() {
		return producentStation;
	}

	public void setProducentStation(ProducentStation producentStation) {
		this.producentStation = producentStation;
	}
	
	
	
	

}
