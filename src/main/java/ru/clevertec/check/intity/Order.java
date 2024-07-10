package ru.clevertec.check.intity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    List<Item> items;
    String discountCardNumber;
    BigDecimal discountPercent;
    BigDecimal balance;
    public Order(ArrayList<Item> items, String discountCardNumber, double balance){
        this.items = items;
        this.discountCardNumber = discountCardNumber;
        this.balance = BigDecimal.valueOf(balance);
    }

    public List<Item> getItems() {
        return items;
    }

    public String getDiscountCardNumber() {
        return discountCardNumber;
    }

    public BigDecimal getDiscountPercent() {
        return discountPercent;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
