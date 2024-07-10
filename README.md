# Application for creating Check of products in console and CSV files

This repository contains 2 branches: feature/entry-core, feature/entry-file. Each of two branches contains different application functionality.

Make sure you have the following installed:

    Java (version 21)
To run the application in the entry-core branch you need to enter a command like:
```
java -cp src ./src/main/java/ru/clevertec/check/CheckRunner.java id-quantity discountCard=xxxx balanceDebitCard=xxxx
```
Note:

    id - product identifier
    quantity - quantity of the product
    discountCard=xxxx - contains a four-digit discount card number. Information about discount cards contain ./src/main/resources/discountCards.csv)
    balanceDebitCard=xxxx - balance on the debit card.
