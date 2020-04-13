package codility.ecommerce;

import java.math.BigDecimal;

class SimpleSoldProduct {
    String name;
    BigDecimal price;

    public SimpleSoldProduct(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }
}
