package entyties;

import javax.persistence.*;

@Entity
@Table(name = "FREIGHT")

public class Freight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;


    @ManyToOne
    @JoinColumn(name="RELATION_ID")
    private Relation relation;


    @ManyToOne
    @JoinColumn(name="FORWARDER_ID")
    private Forwarder forwarder;

    // 1 = per To ; 2 = pauschal
    @Column(name = "TYP")
    private int typ;

    @Column(name = "FREIGHT_PER_TO")
    private int freigtPerTo;

    @Column(name = "FREIGHT_PER_ORDER")
    private int getFreigtPerOrder;



    public Freight() {

    }

    public Freight(Relation relation, Forwarder forwarder, int typ, int freigtPerTo, int getFreigtPerOrder) {
        this.relation = relation;
        this.forwarder = forwarder;
        this.typ = typ;
        this.freigtPerTo = freigtPerTo;
        this.getFreigtPerOrder = getFreigtPerOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    public Forwarder getForwarder() {
        return forwarder;
    }

    public void setForwarder(Forwarder forwarder) {
        this.forwarder = forwarder;
    }

    public int getTyp() {
        return typ;
    }

    public void setTyp(int typ) {
        this.typ = typ;
    }

    public int getFreigtPerTo() {
        return freigtPerTo;
    }

    public void setFreigtPerTo(int freigtPerTo) {
        this.freigtPerTo = freigtPerTo;
    }

    public int getGetFreigtPerOrder() {
        return getFreigtPerOrder;
    }

    public void setGetFreigtPerOrder(int getFreigtPerOrder) {
        this.getFreigtPerOrder = getFreigtPerOrder;
    }
}
