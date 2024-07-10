package ru.clevertec.check;

import ru.clevertec.check.exception.WriteFileOutputException;
import ru.clevertec.check.intity.Item;
import ru.clevertec.check.intity.Order;
import static ru.clevertec.check.ConstantList.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Parser {

    public Order parseToOrder(String[] input) throws WriteFileOutputException {
        ArrayList<Item> items = new ArrayList<>();
        String discountCard = null;
        double balance = 0;
        Map<Integer, Integer> Map = new HashMap<>();
        boolean checkBalance = true;
        for(String i : input){
            if(Pattern.matches(regIdCount , i)){
                String[] oo = i.split("-");
                if (Map.containsKey(Integer.parseInt(oo[0]))) {
                    Map.put(Integer.parseInt(oo[0]), Map.get(Integer.parseInt(oo[0])) + Integer.parseInt(oo[1]));
                } else {
                    Map.put(Integer.parseInt(oo[0]), Integer.parseInt(oo[1]));
                }
            }
            else if (Pattern.matches(regDiscountCard, i)) {
                String[] oo = i.split("=");
                discountCard = (oo[1]);
            } else if (Pattern.matches(regBalanceCard, i)) {
                String[] oo = i.split("=");
                balance = Integer.parseInt(oo[1]);
                checkBalance = false;
            }

        }
        if(Map.size() == 0 || checkBalance)
            throw new WriteFileOutputException("BAD REQUEST");

        for (Map.Entry<Integer, Integer> i : Map.entrySet()){
            items.add(new Item(i.getKey() , i.getValue()));
        }
        return new Order(items,discountCard,balance);
    }

    public void parseToSavePath(String[] input) throws WriteFileOutputException {
        boolean pathSaveIsPresent = false;
        for (String i : input) {
            if (Pattern.matches(regPathToSave, i)) {
                String[] oo = i.split("=");
                PATH_TO_SAVE = (oo[1]);
                pathSaveIsPresent = true;
            }
        }
            if (!pathSaveIsPresent)
                throw new WriteFileOutputException("BAD REQUEST");
    }


    public void parseToProduct(String[] input) throws WriteFileOutputException {
        for(String i : input) {
            if (Pattern.matches(regPathToProduct, i)) {
                String[] oo = i.split("=");
                PATH_TO_PRODUCT = (oo[1]);
            }
        }
        if(PATH_TO_PRODUCT == null) {
            throw new WriteFileOutputException("BAD REQUEST");
        }
    }
}
