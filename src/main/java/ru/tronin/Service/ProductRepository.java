package ru.tronin.Service;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tronin.DAO.ProductDAOImpl;
import ru.tronin.Entities.Product;

import java.util.List;

@Service
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRepository {

    //Сначала хотел заинжектить интерфейс, но тогда метод со средним значением выпадал бы
    @Autowired
    ProductDAOImpl productDao;

    public String addProductToList(Product product){
        return productDao.create(product) ? "Object successfully added" : "Object not added";
    }
    public String deleteProductFromList(Integer id){
        return productDao.deleteById(id) ? "Object successfully deleted" : "Object not deleted";
    }

    public String updateProductInList(Product product){
        return productDao.update(product) != null ? "Object(s) successfully updated" : "Object with id " + product.getId() + " not found";
    }

    public Product getProductById(Integer id){
        return productDao.getEntityById(id);
    }

    public List<Product> getProductList(){
        return productDao.getAll();
    }

    public String getCountOfProducts(){
        return "List of products contains: " + productDao.getAll().size() + " product.";
    }

    public String getAverageCoastOfProducts(){
        return "Average cost of all products is: " + (float) productDao.getAll().stream()
                .mapToDouble(Product::getCost)
                .average()
                .orElse(Double.NaN);
    }

}
