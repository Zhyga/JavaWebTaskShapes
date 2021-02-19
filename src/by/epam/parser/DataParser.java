package by.epam.parser;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    public List<Double> parseLineToNumber(String line){
        List<Double> dataList = new ArrayList<>();
        String string[] = line.split(" ");
        for(int i = 0; i < string.length; i++){
            Double number = Double.parseDouble(string[i]);
            dataList.add(number);
        }
        return dataList;
    }
}
