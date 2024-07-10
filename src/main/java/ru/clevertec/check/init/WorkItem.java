package ru.clevertec.check.init;

import ru.clevertec.check.intity.Item;

import java.math.BigDecimal;

public interface WorkItem {
    BigDecimal totalItemPrice(Item item);
    BigDecimal totalItemDiscount(Item k, String discountNumber);

}
