package ru.clevertec.check.CSVWorker;

import com.opencsv.bean.CsvToBeanBuilder;
import ru.clevertec.check.exception.WriteFileOutputException;
import ru.clevertec.check.intity.Product;
import static ru.clevertec.check.ConstantList.*;

import java.io.FileReader;
import java.util.List;

public class ProductListCreator {
    public static List<Product> readCSV() throws WriteFileOutputException {
        try {
            return new CsvToBeanBuilder<Product>(new FileReader(PATH_TO_PRODUCT))
                    .withSeparator(CSV_COLUMN_SEPARATOR)
                    .withIgnoreQuotations(true)
                    .withType(Product.class)
                    .build()
                    .parse();
        } catch (Exception e) {
            throw new WriteFileOutputException("INTERNAL SERVER ERROR");
        }
    }
}
