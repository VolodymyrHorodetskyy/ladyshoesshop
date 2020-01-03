package ua.com.ladyshoes.dto;

import ua.com.ladyshoes.entity.Image;
import ua.com.ladyshoes.entity.Material;

import java.time.LocalDate;
import java.util.List;

public class ItemDto {

    private Long id;

    private String name;

    private String description;

    private Double price;

    private Double newPrice;

    private LocalDate newPriceTillDate;

    private Double cost;

    private long discountNumberOfDays;

    private Material material;

    private List<Image> images;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public long getDiscountNumberOfDays() {
        return discountNumberOfDays;
    }

    public void setDiscountNumberOfDays(long discountNumberOfDays) {
        this.discountNumberOfDays = discountNumberOfDays;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
