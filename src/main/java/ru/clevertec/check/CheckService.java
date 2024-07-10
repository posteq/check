package ru.clevertec.check;

import ru.clevertec.check.CSVWorker.WriterInit;
import ru.clevertec.check.exception.WriteFileOutputException;
import ru.clevertec.check.init.*;
import ru.clevertec.check.intity.OutputItem;
import static ru.clevertec.check.ConstantList.PATH_TO_SAVE;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CheckService {
    public static final String DOLLAR = "$";
    public static final String[] HEAD_OF_OUT_LIST = {"QTY","DESCRIPTION","PRICE","DISCOUNT","TOTAL"};
    public static final String[] DOWN_OF_OUT_LIST = {"TOTAL PRICE","TOTAL DISCOUNT","TOTAL WITH DISCOUNT"};
    public static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yy.MM.yyyy");
    public static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    WorkDiscount discountList;
    WorkProduct productList ;
    WorkOutputOrder outputOrderList;
    WorkItem itemList;
    BigDecimal balance;

    public CheckService(InputData inputData) throws WriteFileOutputException {
        this.discountList = WorkDiscountInit.getInstance();
        this.productList = WorkProductInit.getInstance();
        this.itemList = WorkItemInit.getInstance(discountList , productList);
        this.outputOrderList = new WorkOutputOrderInit(discountList, productList , itemList , inputData.order);
        this.balance = inputData.order.getBalance();

    }
    public String getCheck() throws WriteFileOutputException {
        return WriterInit.outputListToString(outputOrderListToString());
    }

    public void printCheck() throws WriteFileOutputException {
        WriterInit.print(getCheck() , PATH_TO_SAVE);
    }


    public List<List<String>> outputOrderListToString() throws WriteFileOutputException {
        List<List<String>> fullOutList = new ArrayList<>();
        LocalDateTime currentDateTime = LocalDateTime.now();
        fullOutList.add(List.of("Date","Time"));
        fullOutList.add(List.of(currentDateTime.format(dateFormatter),currentDateTime.format(timeFormatter)));
        fullOutList.add(List.of());
        fullOutList.add(List.of(HEAD_OF_OUT_LIST));

        for(OutputItem i : outputOrderList.getOutputItem()){
            fullOutList.add(
                    List.of(
                            i.getQty(),
                            i.getDescription(),
                            i.getPrice()+DOLLAR,
                            i.getDiscount()+DOLLAR,
                            i.getTotalPrice()+DOLLAR
                    ));
        }
        fullOutList.add(List.of());
        fullOutList.add(List.of(DOWN_OF_OUT_LIST));
        fullOutList.add(List.of(outputOrderList.totalOrderPrice()+DOLLAR,
                outputOrderList.totalOrderDiscount()+DOLLAR,
                outputOrderList.totalOrderPriceWithDiscounter()+DOLLAR));
        if(!outputOrderList.enoughMoney(balance))
            throw new WriteFileOutputException("NOT ENOUGH MONEY");
        return fullOutList;
    }


}
