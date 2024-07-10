package ru.clevertec.check.CSVWorker;

import ru.clevertec.check.exception.WriteFileOutputException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterInit {

    public static final String CSV_COLUMN_SEPARATOR = ";";

    public static void print(String data , String pathToSaveFile) throws WriteFileOutputException {
        try (FileWriter fileWriter = new FileWriter(pathToSaveFile, false)) {
            fileWriter.write(data);
            System.out.println(data);
        } catch (IOException e) {
            throw new WriteFileOutputException("INTERNAL SERVER ERROR");
        }
    }

    public static String outputListToString(List<List<String>> list){
        StringBuilder stringBuilder = new StringBuilder();
        for (List<String> lists : list) {
            if (lists.isEmpty()) {
                stringBuilder.append(CSV_COLUMN_SEPARATOR);
            }
            for (String string : lists) {
                stringBuilder.append(string);
                stringBuilder.append(CSV_COLUMN_SEPARATOR);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
