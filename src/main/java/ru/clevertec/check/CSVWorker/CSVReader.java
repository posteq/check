package ru.clevertec.check.CSVWorker;

import ru.clevertec.check.exception.WriteFileOutputException;
import ru.clevertec.check.intity.Discount;
import ru.clevertec.check.intity.Product;

import java.util.List;

public abstract class CSVReader {
    public static List<Product> readProduct() throws WriteFileOutputException {return ProductListCreator.readCSV();}

    public static List<Discount> readDiscount() throws WriteFileOutputException {return DiscountListCreator.readCSV();}
}
