package models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wiktor Szymanowski
 * Date: 20.03.2021
 */
public class Order {

    private List<ProductFromCart> listOfProducts;
    private BigDecimal totalPrice;

    public Order() {
        listOfProducts = new ArrayList<>();
    }

    public List<ProductFromCart> getListOfProducts() {
        return listOfProducts;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void addProduct(ProductFromCart productToAdd) {
        for (ProductFromCart product : listOfProducts) {
            if (product.getName().equals(productToAdd.getName())) {
                product.addProduct(productToAdd.getQuantity());
                return;
            }
        }
        listOfProducts.add(productToAdd);
    }
}
