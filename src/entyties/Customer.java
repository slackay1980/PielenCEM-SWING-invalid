package entyties;



import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    @Column(name ="CUSTOMER_NAME")
    private String customerName;
    
    @Column(name ="CUSTOMER_LABEL")
    private String customerLABEL;
    
    public String getCustomerLABEL() {
		return customerLABEL;
	}

	public void setCustomerLABEL(String customerLABEL) {
		this.customerLABEL = customerLABEL;
	}



	@Column(name ="CUSTOMER_STREET")
    private String customerStreet;
    
    @Column(name ="CUSTOMER_LAND_POSTCODE")
    private String customerLandPostCode;
    
    @Column(name ="CUSTOMER_CITY")
    private String customerCity;
    
    @Column(name ="CUSTOMER_EMPLOEE")
    private String customerEmploee;
 
    @Column(name ="CUSTOMER_TELEFONE_1")
    private String customerTelefone1;
    
    @Column(name ="CUSTOMER_TELEFONE_2")
    private String customerTelefone2;
    
    @Column(name ="CUSTOMER_TELEFONE_3")
    private String customerTelefone3;
    
    @Column(name ="CUSTOMER_EMAIL")
    private String customerEmail;
    
    @Column(name ="CUSTOMER_LOGICID")
    private String customerLogicId;
    
    @Column(name ="CUSTOMER_NOTE")
    private String customerNote;
    
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
    private List<CustomerStation> customerStations;
  
    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }


    public String getCustomerStreet() {
		return customerStreet;
	}

	public void setCustomerStreet(String customerStreet) {
		this.customerStreet = customerStreet;
	}

	public String getCustomerLandPostCode() {
		return customerLandPostCode;
	}

	public void setCustomerLandPostCode(String customerLandPostCode) {
		this.customerLandPostCode = customerLandPostCode;
	}

	public String getCustomerEmploee() {
		return customerEmploee;
	}

	public void setCustomerEmploee(String customerEmploee) {
		this.customerEmploee = customerEmploee;
	}

	public String getCustomerTelefone1() {
		return customerTelefone1;
	}

	public void setCustomerTelefone1(String customerTelefone1) {
		this.customerTelefone1 = customerTelefone1;
	}

	public String getCustomerTelefone2() {
		return customerTelefone2;
	}

	public void setCustomerTelefone2(String customerTelefone2) {
		this.customerTelefone2 = customerTelefone2;
	}

	public String getCustomerTelefone3() {
		return customerTelefone3;
	}

	public void setCustomerTelefone3(String customerTelefone3) {
		this.customerTelefone3 = customerTelefone3;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerNote() {
		return customerNote;
	}

	public void setCustomerNote(String customerNote) {
		this.customerNote = customerNote;
	}
	
	public String getCustomerLogicId() {
		return customerLogicId;
	}

	public void setCustomerLogicId(String customerLogicId) {
		this.customerLogicId = customerLogicId;
	}

	public void setId(int id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerStations(List<CustomerStation> customerStations) {
        this.customerStations = customerStations;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<CustomerStation> getCustomerStations() {
        return customerStations;
    }

	public Customer(){

    }

   
   

    public Customer(String customerName, String customerStreet, String customerLandPostCode,
			String customerCity, String customerEmploee, String customerTelefone1, String customerTelefone2,
			String customerTelefone3, String customerEmail, String customerLogicId, String customerNote) {

		this.customerName = customerName;
		this.customerStreet = customerStreet;
		this.customerLandPostCode = customerLandPostCode;
		this.customerCity = customerCity;
		this.customerEmploee = customerEmploee;
		this.customerTelefone1 = customerTelefone1;
		this.customerTelefone2 = customerTelefone2;
		this.customerTelefone3 = customerTelefone3;
		this.customerEmail = customerEmail;
		this.customerLogicId = customerLogicId;
		this.customerNote = customerNote;
		
		
	}

	

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", customerStations=" + customerStations +
                '}';
    }
}
