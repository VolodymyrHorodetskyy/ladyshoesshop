package ua.com.ladyshoes.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Item extends Audit {

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Double price;

    @Column
    private Double newPrice;

    @Column
    private LocalDate newPriceTillDate;

    @Column
    private Double cost;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Material material;

    @Column
    private Season season;

    @Column
    private boolean available = true;

    @OneToMany(mappedBy = "item")
    private List<Image> images;


    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }


    public Item(String name, String description, Double price, Double cost, List<Image> images, Material material) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.cost = cost;
        this.images = images;
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Double newPrice) {
        this.newPrice = newPrice;
    }

    public LocalDate getNewPriceTillDate() {
        return newPriceTillDate;
    }

    public void setNewPriceTillDate(LocalDate newPriceTillDate) {
        this.newPriceTillDate = newPriceTillDate;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
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
