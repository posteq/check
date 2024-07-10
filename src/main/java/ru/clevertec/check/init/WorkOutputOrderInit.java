package ru.clevertec.check.init;

import ru.clevertec.check.exception.WriteFileOutputException;
import ru.clevertec.check.intity.Item;
import ru.clevertec.check.intity.Order;
import ru.clevertec.check.intity.OutputItem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class WorkOutputOrderInit implements WorkOutputOrder {

    WorkDiscount discountList;
    WorkProduct productList;
    WorkItem itemList;
    List<OutputItem> outputItem;
    double discountPercentOfOrder;

    public WorkOutputOrderInit(WorkDiscount discountList, WorkProduct productList, WorkItem itemList, Order order) throws WriteFileOutputException {
        this.discountList = discountList;
        this.productList = productList;
        this.itemList = itemList;
        this.outputItem = ouputOrderList(order);
    }

    public List<OutputItem> getOutputItem(){return outputItem;}

    @Override
    public BigDecimal totalOrderPrice() {
        List<BigDecimal> priceI = new ArrayList<>();
        for(OutputItem i : outputItem){
            priceI.add(new BigDecimal(String.valueOf(i.getTotalPrice())));
        }
        return priceI.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal totalOrderDiscount() {
        List<BigDecimal> saleI = new ArrayList<>();
        for(OutputItem i : outputItem){
            saleI.add(new BigDecimal(String.valueOf(i.getDiscount())));
        }
        return saleI.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal totalOrderPriceWithDiscounter() {
        return totalOrderPrice().subtract(totalOrderDiscount());
    }

    @Override
    public boolean enoughMoney(BigDecimal balance) {
        return balance.compareTo(totalOrderPriceWithDiscounter()) > 0;
    }

    private List<OutputItem>  ouputOrderList(Order order) throws WriteFileOutputException {
        try{
            List<OutputItem> calculatedOutputOrderList = new ArrayList<>();
            discountPercentOfOrder = discountList.findByNumber(order.getDiscountCardNumber());
            if(productList == null)
                throw new WriteFileOutputException("BAD REQUEST");
            for(Item k : order.getItems()){
                if(k.getCount() > productList.findById(k.getCount()).getQuantity())
                    throw new WriteFileOutputException("BAD REQUEST");
                calculatedOutputOrderList.add(new OutputItem(
                        k.getCount(),
                        productList.findById(k.getId()).getDescription(),
                        productList.findById(k.getId()).getPrice(),
                        itemList.totalItemDiscount(k, order.getDiscountCardNumber()),
                        itemList.totalItemPrice(k)
                ));
            }
            return calculatedOutputOrderList;
        }catch (Exception e){
            throw new WriteFileOutputException("INTERNAL SERVER ERROR");
        }
    }
}
