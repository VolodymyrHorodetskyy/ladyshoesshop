package ua.com.ladyshoes.entity;

import javax.persistence.Entity;

@Entity
public class ItemDescription extends Audit {

    private String whyWe;

    private String payment;

    private String howToOrder;

}
