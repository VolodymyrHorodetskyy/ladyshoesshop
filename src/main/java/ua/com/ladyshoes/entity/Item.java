package ua.com.ladyshoes.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Item extends Audit {


    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Double price;

    @Column
    private Double cost;

    @Column
    private boolean available = true;

    @OneToMany(mappedBy = "item")
    private List<Image> images;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, String description, Double price, Double cost,  List<Image> images) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.cost = cost;
        this.images = images;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", cost=" + cost +
                ", available=" + available +
                '}';
    }
}
