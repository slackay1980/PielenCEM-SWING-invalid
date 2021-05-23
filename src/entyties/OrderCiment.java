package entyties;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ORDER_CIMENT")

public class OrderCiment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	
	@ManyToOne
	@JoinColumn(name="CUSTOMER_STATION_ID")
	private CustomerStation customerStation;
	
	@ManyToOne
	@JoinColumn(name="PRODUCENT_STATION_ID")
	private ProducentStation producentStation;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="FORWARDER_ID")
	private Forwarder forwarder;

	@OneToMany(mappedBy = "orderCiment")
	private List<TransportOrder> transportOrders;

	@Column(name = "DATE")
	private Date date;

	@Column(name = "TIME_FROM")
	private Time fromTime;

	@Column(name = "TIME_TILL")
	private Time tillTime;

	
	@Column(name="CUSOMER_TXT")
	private String  customerTxt;
	
	@Column(name="CUSTOMER_STATION_TXT")
	private String  customerStationTxt;
	
	@Column(name="PRODUCT_TXT")
	private String  productTxt;
	
	@Column(name="NOTE_TXT")
	private String  noteTxt;
	
	@Column(name="DELIVERY_NOTE_ORIGIN_TXT")
	private String  deliveryNoteOriginTxt;
	
	@Column(name="TRUCK_PLACET_TXT")
	private String  truckPlacetTxt;
	
	
	@Column(name="DELIVERY_NOTE_PIELEN_TXT")
	private int deliveryNotePielen_TXT;
	
	public OrderCiment() {
	
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public CustomerStation getCustomerStation() {
		return customerStation;
	}

	public void setCustomerStation(CustomerStation customerStation) {
		this.customerStation = customerStation;
	}

	public ProducentStation getProducentStation() {
		return producentStation;
	}

	public void setProducentStation(ProducentStation producentStation) {
		this.producentStation = producentStation;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getCustomerTxt() {
		return customerTxt;
	}

	public void setCustomerTxt(String customerTxt) {
		this.customerTxt = customerTxt;
	}

	public String getCustomerStationTxt() {
		return customerStationTxt;
	}

	public void setCustomerStationTxt(String customerStationTxt) {
		this.customerStationTxt = customerStationTxt;
	}

	public String getProductTxt() {
		return productTxt;
	}

	public void setProductTxt(String productTxt) {
		this.productTxt = productTxt;
	}

	public String getNoteTxt() {
		return noteTxt;
	}

	public void setNoteTxt(String noteTxt) {
		this.noteTxt = noteTxt;
	}

	public String getDeliveryNoteOriginTxt() {
		return deliveryNoteOriginTxt;
	}

	public void setDeliveryNoteOriginTxt(String deliveryNoteOriginTxt) {
		this.deliveryNoteOriginTxt = deliveryNoteOriginTxt;
	}

	public String getTruckPlacetTxt() {
		return truckPlacetTxt;
	}

	public void setTruckPlacetTxt(String truckPlacetTxt) {
		this.truckPlacetTxt = truckPlacetTxt;
	}

	public int getDeliveryNotePielen_TXT() {
		return deliveryNotePielen_TXT;
	}

	public void setDeliveryNotePielen_TXT(int deliveryNotePielen_TXT) {
		this.deliveryNotePielen_TXT = deliveryNotePielen_TXT;
	}
	
	
	
	
	
	

}
