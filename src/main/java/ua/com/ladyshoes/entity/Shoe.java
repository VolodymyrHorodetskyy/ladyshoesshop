package ua.com.ladyshoes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class Shoe extends Audit {

    @Column(nullable = false)
    private String model;

    @Column
    private double price;

    @OneToMany(mappedBy = "shoe")
    @JsonIgnore
    private List<InputFinanceRecord> records;

    public Shoe(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public Shoe() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<InputFinanceRecord> getRecords() {
        return records;
    }

    public void setRecords(List<InputFinanceRecord> records) {
        this.records = records;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shoe)) return false;
        Shoe shoe = (Shoe) o;
        return Double.compare(shoe.price, price) == 0 &&
                model.equals(shoe.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, price);
    }

    @Override
    public String toString() {
        return "Shoe{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
