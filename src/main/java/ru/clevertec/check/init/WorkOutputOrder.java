package ru.clevertec.check.init;

import ru.clevertec.check.intity.OutputItem;

import java.math.BigDecimal;
import java.util.List;

public interface WorkOutputOrder {
    BigDecimal totalOrderPrice();
    BigDecimal totalOrderDiscount();
    BigDecimal totalOrderPriceWithDiscounter();
    boolean enoughMoney(BigDecimal balance);
    List<OutputItem> getOutputItem();

}
