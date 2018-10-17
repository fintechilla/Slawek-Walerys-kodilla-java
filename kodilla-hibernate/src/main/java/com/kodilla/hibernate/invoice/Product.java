package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="PRODUCT")
//One
public class Product {
    private int id;
    private String name;
    public List<Item> items = new ArrayList<>();

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private int getId() {
        return id;
    }
    @Column(name = "NAME")
    @NotNull
    public String getName() {
        return name;
    }
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            targetEntity = Item.class,
            mappedBy = "product"
    )
    public List<Item> getItems() {
        return items;
    }
    private void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
