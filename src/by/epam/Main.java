package by.epam;

import by.epam.factory.pointfactory.PointForCube;
import by.epam.factory.shapefactory.CubeFactory;
import by.epam.entity.Cube;
import by.epam.entity.Point;
import by.epam.exception.CustomException;
import by.epam.parser.DataParser;
import by.epam.reader.CustomFIleReader;
import by.epam.repository.CubeRepository;
import by.epam.service.CubeVerificationService;
import by.epam.specification.Specification;
import by.epam.specification.impl.CubeIdSpecification;

import java.util.ArrayList;
import java.util.Comparator;
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
        CubeFactory cubeCreator = new CubeFactory();
        List<Double> numbers = new ArrayList<>();
        CubeRepository cubeRepository = CubeRepository.getInstance();
        PointForCube pointForCube = new PointForCube();
        List<Point> points = new ArrayList<>();
        CubeFactory cubeFactory = new CubeFactory();
        List<String> dataList = customFIleReader.readText("data/data.txt");
        for(int i = 0; i < dataList.size(); i++) {
            numbers = dataParser.parseLineToNumber(dataList.get(i));
            points = pointForCube.createPoints(numbers);
            cube = cubeFactory.createShape(points);
            cubeRepository.add(cube);
        }
        List<Cube> cubes = cubeRepository.getAll();
        for(int i = 0; i < cubes.size(); i++){
            boolean isCube = cubeVerificationService.isCubeBySides(cubes.get(i));
            System.out.println(isCube);
        }
        String idToFound = cubes.get(0).getShapeId();
        Specification<Cube> specification = new CubeIdSpecification(idToFound);
        System.out.println(specification.specify(cubes.get(0)));
        Comparator<Cube> comparator = new Comparator<Cube>() {
            @Override
            public int compare(Cube o1, Cube o2) {
                return (o1.getShapeId().compareTo(o2.getShapeId()));
            }
        };
        cubes = cubeRepository.sort(comparator);
        for(int i = 0; i < cubes.size(); i++)
            System.out.println(cubes.get(i));
        cubes = cubeRepository.query(specification);
    }
}
