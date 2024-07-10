package ru.clevertec.check.init;

import ru.clevertec.check.CSVWorker.CSVReader;
import ru.clevertec.check.exception.WriteFileOutputException;
import ru.clevertec.check.intity.Product;

import java.util.List;

public class WorkProductInit implements WorkProduct{

    List<Product> productList;
    private static WorkProductInit instanceProduct;


    private WorkProductInit(List<Product> productList){
        this.productList = productList;
    }

    public static WorkProductInit getInstance() throws WriteFileOutputException {
        if(instanceProduct == null){
            instanceProduct = new WorkProductInit(CSVReader.readProduct());
        }
        return instanceProduct;
    }
    @Override
    public Product findById(int id){
        for(Product i : productList){
            if(i.getId() == id)
                return i;
        }
        return null;
    }

    public List<Product> getProductList(){return productList;}
}