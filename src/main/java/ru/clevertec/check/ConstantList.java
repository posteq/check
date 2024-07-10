package ru.clevertec.check;

public abstract class ConstantList {
    public static final char CSV_COLUMN_SEPARATOR = ';';
    public static final String PATH_TO_DISCOUNT = "./src/main/resources/discountCards.csv";
    public static final String PATH_TO_PRODUCT = "./src/main/resources/products.csv";
    public static final String PATH_TO_SAVE = "./src/main/result.csv";
    public static final int SALE_COUNT = 5;

    /*
               Regex for find item , count , sale card and balance in input string
     */
    public static final String regIdCount = "\\d{1,2}\\-\\d{1,2}";
    public static final String regDiscountCard = "discountCard=\\d{4}";
    public static final String regBalanceCard = "balanceDebitCard=\\d{1,4}";

}
