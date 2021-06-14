package ru.tronin.Controllers;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tronin.Entities.Product;
import ru.tronin.Service.ProductRepository;

import java.util.List;
import java.util.Scanner;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConsoleController {
    @Autowired
    Scanner scanner;
    @Autowired
    ProductRepository repository;

    public void handleConsoleMsg() {
        System.out.println("Text command:");
        String msg = scanner.nextLine();
        if (msg.equals("create")) {
            System.out.println(repository.addProductToList(setProduct()));
        } else if (msg.equals("delete")) {
            System.out.println(repository.deleteProductFromList(setId()));
        } else if(msg.equals("update")){
            System.out.println(repository.updateProductInList(setProduct()));
        } else if (msg.equals("get")){
            System.out.println(repository.getProductById(setId()));
        } else if (msg.equals("getAll")){
            List<Product> list = repository.getProductList();
            list.forEach(System.out::println);
        } else if (msg.equals("size")){
            System.out.println(repository.getCountOfProducts());
        } else if (msg.equals("avg")){
            System.out.println(repository.getAverageCoastOfProducts());
        } else {
            System.out.println("Unknown message, available messages:\n create, update, delete, get, getAll, size, avg");
        }

    }

    private Integer setId(){
        int id;
        do {
            System.out.println("Insert id(integer value)");
            while (!scanner.hasNextInt()){
                System.out.println("This is not number");
                scanner.next();
            }
            id = scanner.nextInt();
        } while (id < 0);
        scanner.nextLine();
        return id;
    }

    private Product setProduct(){
        int id = setId();
        float price;
        System.out.println("Insert Name (String value)");
        String name = scanner.nextLine();
        do {
        System.out.println("Insert id(float value)");
            while (!scanner.hasNextFloat() || !scanner.hasNextInt()){
                System.out.println("This is not float");
                scanner.next();
            }
            price = scanner.hasNextFloat() ? scanner.nextFloat() : scanner.nextInt();
        } while (price < 0);
        scanner.nextLine();
        return new Product(id,name,price);
    }


}
