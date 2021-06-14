package ru.tronin.Entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ProductList {

    List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>();
        products.add(new Product(1,"Apple", 1.03f));
        products.add(new Product(2,"Orange", 3.23f));
        products.add(new Product(3,"Cherry", 3.07f));
        products.add(new Product(4,"Potato", 0.79f));
        products.add(new Product(5,"Honey", 5.6f));
    }
}
