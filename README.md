# Application for creating Check of products in console and CSV files

This repository contains 2 branches: feature/entry-core, feature/entry-file. Each of two branches contains different application functionality.

Make sure you have the following installed:

    Java (version 21)
To run the application in the entry-file branch you need to enter a command like:
```
java -cp src ./src/main/java/ru/clevertec/check/CheckRunner.java id-quantity discountCard=xxxx balanceDebitCard=xxxx pathToFile=XXXX saveToFile=xxxx
```
Note:

    id - product identifier
    quantity - quantity of the product
    discountCard=xxxx - contains a four-digit discount card number. Information about discount cards contain ./src/main/resources/discountCards.csv)
    balanceDebitCard=xxxx - balance on the debit card.
    pathToFile=XXXX - Path to the file with product data available.
    saveToFile=xxxx - path to the file from the project root where you want to write the result.
