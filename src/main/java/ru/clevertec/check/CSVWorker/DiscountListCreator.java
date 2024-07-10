package ru.clevertec.check.CSVWorker;

import com.opencsv.bean.CsvToBeanBuilder;
import ru.clevertec.check.exception.WriteFileOutputException;
import ru.clevertec.check.intity.Discount;
import static ru.clevertec.check.ConstantList.*;

import java.io.FileReader;
import java.util.List;


public class DiscountListCreator {
    public static List<Discount> readCSV() throws WriteFileOutputException {
        try {
            return new CsvToBeanBuilder<Discount>(new FileReader(PATH_TO_DISCOUNT))
                    .withSeparator(CSV_COLUMN_SEPARATOR)
                    .withIgnoreQuotations(true)
                    .withType(Discount.class)
                    .build()
                    .parse();
        }catch (Exception e) {
            throw new WriteFileOutputException("INTERNAL SERVER ERROR");
        }
    }
}
