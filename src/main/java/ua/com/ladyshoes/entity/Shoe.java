package ua.com.ladyshoes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Shoe extends Audit {

    @Column
    private int model;

    @Column
    private double price;

    @OneToMany(mappedBy = "shoe")
    private List<InputFinanceRecord> records;

    public Shoe(int model, double price) {
        this.model = model;
        this.price = price;
    }

    public Shoe() {
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
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


}
