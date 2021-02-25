package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name = "Car.deleteAllRows", query = "DELETE from Car")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int produced;
    private String make;
    private String model;
    private int price;
    private String owner;
    
    //TODO: Hvad er dette Jon?
    @Temporal(TemporalType.DATE)
    private Date created;
    

    public Car(int produced, String make, String model, int price, String owner) {
        this.produced = produced;
        this.make = make;
        this.model = model;
        this.price = price;
        this.owner = owner;
        this.created = new Date();
    }

    public Car() {
    }

    public Date getCreated() {
        return created;
    }
    
    public Integer getId() {
        return id;
    }

    public int getProduced() {
        return produced;
    }

    public void setProduced(int produced) {
        this.produced = produced;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Car{id=").append(id);
        sb.append(", produced=").append(produced);
        sb.append(", make=").append(make);
        sb.append(", model=").append(model);
        sb.append(", price=").append(price);
        sb.append(", owner=").append(owner);
        sb.append(", created=").append(created);
        sb.append('}');
        return sb.toString();
    }

    

}
