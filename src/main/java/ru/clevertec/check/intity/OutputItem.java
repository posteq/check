package ru.clevertec.check.intity;

import java.math.BigDecimal;

public class OutputItem {
    private final int qty;
    private final String description;
    private final double price;
    private final BigDecimal discount;
    private final BigDecimal totalPrice;

    public OutputItem(int qty, String description, double price, BigDecimal discount, BigDecimal totalPrice) {
        this.qty = qty;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.totalPrice = totalPrice;
    }
    public String getQty() {return String.valueOf(qty);}
    public String getDescription() {
        return description;
    }
    public String getPrice() {return String.valueOf(price);}
    public BigDecimal getDiscount() {
        return discount;
    }
    public BigDecimal getTotalPrice() {return totalPrice;}
}
