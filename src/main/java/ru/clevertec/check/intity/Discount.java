package ru.clevertec.check.intity;

import com.opencsv.bean.CsvBindByName;

public class Discount {
    @CsvBindByName(column = "id", required = true)
    private int id;
    @CsvBindByName(column = "number", required = true)
    private String number;
    @CsvBindByName(column = "discount amount, %", required = true)
    private int discountPercent;

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", discountPercent=" + discountPercent +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }
}
