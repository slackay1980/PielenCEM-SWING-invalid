package entyties;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name= "FORWARDER")
public class Forwarder {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
	
	@OneToMany(mappedBy = "forwarder")
    private List<OrderCiment> orderCiment;

    @Column(name ="FORWARDER_NAME")
    private String forwarderName;
    
    @Column(name ="FORWARDER_STREET")
    private String forwarderStreet;
    
    @Column(name ="FORWARDER_LAND_POSTCODE")
    private String forwarderLandPostCode;
    
    @Column(name ="FORWARDER_CITY")
    private String forwarderCity;
    
    @Column(name ="FORWARDER_EMPLOEE")
    private String forwarderEmploee;
 
    @Column(name ="FORWARDER_TELEFONE_1")
    private String forwarderTelefone1;
    
    @Column(name ="FORWARDER_TELEFONE_2")
    private String forwarderTelefone2;
    
    @Column(name ="FORWARDER_TELEFONE_3")
    private String forwarderTelefone3;
    
    @Column(name ="FORWARDER_EMAIL")
    private String forwarderEmail;
    
    @Column(name ="FORWARDER_LOGICID")
    private String forwarderLogicId;
    
    @Column(name ="FORWARDER_NOTE")
    private String forwarderNote;

    
    

}
