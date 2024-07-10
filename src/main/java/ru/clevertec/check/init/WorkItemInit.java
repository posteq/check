package ru.clevertec.check.init;

import ru.clevertec.check.intity.Item;
import static ru.clevertec.check.ConstantList.SALE_COUNT;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class WorkItemInit implements WorkItem {
    WorkDiscount discountList;
    WorkProduct productList;
    private static WorkItemInit instanceWorkItem;
    private WorkItemInit(WorkDiscount discountList , WorkProduct productList){
        this.discountList = discountList;
        this.productList = productList;
    }
    public static WorkItemInit getInstance(WorkDiscount discountList , WorkProduct productList){
        if(instanceWorkItem == null){
            instanceWorkItem = new WorkItemInit(discountList , productList);
        }
        return instanceWorkItem;
    }

    @Override
    public BigDecimal totalItemPrice(Item item) {
        return (BigDecimal.valueOf(productList.findById(item.getId()).getPrice())
                .multiply(BigDecimal.valueOf(item.getCount())))
                .setScale(2, RoundingMode.UP);
    }

    @Override
    public BigDecimal totalItemDiscount( Item item, String discountNumber) {
        return totalItemPrice(item)
                .multiply(BigDecimal.valueOf(getDiscount(item , discountNumber)))
                .setScale(2, RoundingMode.UP );
    }

    public double getDiscount(Item item, String discountNumber){
        if (item.getCount() > SALE_COUNT && (productList.findById(item.getId()).isSale())) {
            return ((double) 10 /100);
        }else{
            return discountList.findByNumber(discountNumber)/100;
        }
    }

}
