package ru.tronin.DAO;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.tronin.Entities.Product;
import ru.tronin.Entities.ProductList;
import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ProductDAOImpl implements iDAO<Product, Integer>{

    @Autowired
    ProductList productList;
    List<Product> products;


    @PostConstruct
    public void init(){
        products = productList.getProducts();
    }

    @Override
    public boolean create(Product entity) {
        if (products.stream()
                .anyMatch(x->
                        x.getId().equals(entity.getId()) ||
                        x.getTitle().equals(entity.getTitle()))){
            return false;
        }
        products.add(entity);
        return true;
    }

    @Override
    public boolean deleteById(Integer id) {
        return products.removeIf(product -> product.getId().equals(id));
    }

    @Override
    public Product getEntityById(Integer id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Product update(Product entity) {
        products.stream().filter(product -> product.getId().equals(entity.getId()))
                .forEach(product -> {
                    product.setTitle(entity.getTitle());
                    product.setCost(entity.getCost());
                    }
                );

        return getEntityById(entity.getId());
    }

    @Override
    public List<Product> getAll() {
        return Collections.unmodifiableList(products);
    }
}
