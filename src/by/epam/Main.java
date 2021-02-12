package by.epam;

import by.epam.creator.CubeCreator;
import by.epam.entity.Cube;
import by.epam.entity.Point;
import by.epam.exception.CustomException;
import by.epam.parser.DataParser;
import by.epam.reader.CustomFIleReader;
import by.epam.service.CubeVerificationService;
import by.epam.validator.LineValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws CustomException {
        String uniqueID = UUID.randomUUID().toString();
        Point point1 = new Point(-1,1,1);
        Point point2 = new Point(-1,1,-1);
        Point point3 = new Point(1,1,-1);
        Point point4 = new Point(1,1,1);
        Point point5 = new Point(-1,-1,1);
        Point point6 = new Point(-1,-1,-1);
        Point point7 = new Point(1,-1,-1);
        Point point8 = new Point(1,-1,1);
        Cube cube = new Cube(point1,point2,point3,point4,point5,point6,point7,point8);
        CubeVerificationService cubeVerificationService = new CubeVerificationService();
        CustomFIleReader customFIleReader = new CustomFIleReader();
        DataParser dataParser = new DataParser();
        CubeCreator cubeCreator = new CubeCreator();
        List<Double> numbers = new ArrayList<>();
        List<Cube> cubes = new ArrayList<>();
        List<String> dataList = customFIleReader.readText("data/data.txt");
        for(int i = 0; i < dataList.size(); i++) {
            numbers = dataParser.parseLineToNumber(dataList.get(i));
            cube = cubeCreator.createCube(numbers);
            cubes.add(cube);
        }
        for(int i = 0; i < cubes.size(); i++){
            boolean isCube = cubeVerificationService.isCube(cubes.get(i));
            System.out.println(isCube);
        }

    }
}
