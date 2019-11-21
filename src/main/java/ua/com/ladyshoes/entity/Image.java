package ua.com.ladyshoes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Image extends Audit {

    @Column
    private String path;

    @ManyToOne
    @JsonIgnore
    private Item item;

    @Column
    private boolean main;

    public Image() {
    }

    public Image(String path, Item item, boolean main) {
        this.path = path;
        this.item = item;
        this.main = main;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "Image{" +
                "path='" + path + '\'' +
                ", main=" + main +
                '}';
    }
}
