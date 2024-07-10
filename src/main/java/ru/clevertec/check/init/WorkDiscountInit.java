package ru.clevertec.check.init;

import ru.clevertec.check.CSVWorker.CSVReader;
import ru.clevertec.check.exception.WriteFileOutputException;
import ru.clevertec.check.intity.Discount;

import java.util.List;


public class WorkDiscountInit implements WorkDiscount {

    List<Discount> discountList;
    private static WorkDiscountInit instanceDiscount;


    private WorkDiscountInit(List<Discount> discountList){
        this.discountList = discountList;
    }

    public static WorkDiscountInit getInstance() throws WriteFileOutputException {
        if(instanceDiscount == null){
            instanceDiscount = new WorkDiscountInit(CSVReader.readDiscount());
        }
        return instanceDiscount;
    }

    @Override
    public double findByNumber(String number) {
        for(Discount i : discountList ){
            if(i.getNumber().equals(number)) {
                return i.getDiscountPercent();
            }
        }if(number != null){
            return 2;
        }
        return 0;
    }
}
