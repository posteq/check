package ru.clevertec.check;

import ru.clevertec.check.exception.WriteFileOutputException;
import ru.clevertec.check.intity.Order;

public final class InputData {
    Order order;

    public InputData(){}

    public void getInstance(String[] args) throws WriteFileOutputException {
        Parser onesParser = new Parser();
        onesParser.parseToSavePath(args);
        onesParser.parseToProduct(args);
        this.order = onesParser.parseToOrder(args);
    }
}
