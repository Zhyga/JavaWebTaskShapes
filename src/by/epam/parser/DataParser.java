package by.epam.parser;

import java.util.ArrayList;
import java.util.List;

public class DataParser {
    public List<Double> parseLineToNumber(String line){
        String string[] = line.split(" ");
        List<Double> dataList = new ArrayList<>();
        for(int i = 0; i < string.length; i++){
            Double number = Double.parseDouble(string[i]);
            dataList.add(number);
        }
        return dataList;
    }
}
