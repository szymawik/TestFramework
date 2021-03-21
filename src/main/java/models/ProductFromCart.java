package models;

import java.math.BigDecimal;

/**
 * Created by Wiktor Szymanowski
 * Date: 20.03.2021
 */
public class ProductFromCart {

    private String name;
    private int catalogNumber;
    private int quantity;
    private BigDecimal price;
    private BigDecimal subtotal;

    public ProductFromCart(String name, int catalogNumber, int quantity, BigDecimal price, BigDecimal subtotal) {
        this.name = name;
        this.catalogNumber = catalogNumber;
        this.quantity = quantity;
        this.price = price;
        this.subtotal = subtotal;
    }

    public String getName() {
        return name;
    }

    public int getCatalogNumber() {
        return catalogNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    private void setQuantity(int quantity) {
        this.quantity += quantity;
    }

    private void setTotalPrice(){
        this.subtotal = price.multiply(new BigDecimal(this.quantity));
    }

    void addProduct(int quantity) {
        setQuantity(quantity);
        setTotalPrice();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProductFromCart{");
        sb.append("name='").append(name).append('\'');
        sb.append(", catalogNumber=").append(catalogNumber);
        sb.append(", quantity=").append(quantity);
        sb.append(", price=").append(price);
        sb.append(", subtotal=").append(subtotal);
        sb.append('}');
        return sb.toString();
    }
}
