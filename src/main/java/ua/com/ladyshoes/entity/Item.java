package ua.com.ladyshoes.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Item extends IdHolder {

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    @Column
    private String name;

    @Column
    private boolean available = true;

}
