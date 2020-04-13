package codility.ecommerce;

import java.math.BigDecimal;

class SoldProduct {
    String name;
    BigDecimal price;
    String currency;

    public SoldProduct(String name, BigDecimal price, String currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getCurrency() {
        return this.currency;
    }
}