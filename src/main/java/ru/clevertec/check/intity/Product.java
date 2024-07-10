package ru.clevertec.check.intity;

import com.opencsv.bean.CsvBindByName;

public class Product {
    @CsvBindByName(column = "id", required = true)
    private int id;
    @CsvBindByName(column = "description", required = true)
    private String description;
    @CsvBindByName(column = "price, $", required = true)
    private double price;
    @CsvBindByName(column = "quantity in stock", required = true)
    private int quantity;
    @CsvBindByName(column = "wholesale product", required = true)
    private boolean sale;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", sale=" + sale +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {return quantity;}

    public boolean isSale() {
        return sale;
    }

}
