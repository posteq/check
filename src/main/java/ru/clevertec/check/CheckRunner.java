package ru.clevertec.check;

import ru.clevertec.check.CSVWorker.WriterInit;
import ru.clevertec.check.exception.WriteFileOutputException;

import static ru.clevertec.check.ConstantList.PATH_TO_SAVE;

public class CheckRunner {
    public static void main(String[] args) throws WriteFileOutputException {
        InputData inputData = new InputData();
        try {
            inputData.getInstance(args);
            CheckService check = new CheckService(inputData);
            check.printCheck();
        }catch (WriteFileOutputException report){
            WriterInit.print("Error\n" + report.getMessage() , PATH_TO_SAVE);
        }
    }
}
