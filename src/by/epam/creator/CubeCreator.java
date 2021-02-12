package by.epam.creator;

import by.epam.entity.Cube;
import by.epam.entity.Point;

import java.util.List;

public class CubeCreator {
    public Cube createCube(List<Double> numbers){
        Point point1 = new Point(numbers.get(0),numbers.get(1),numbers.get(2));
        Point point2 = new Point(numbers.get(3),numbers.get(4),numbers.get(5));
        Point point3 = new Point(numbers.get(6),numbers.get(7),numbers.get(8));
        Point point4 = new Point(numbers.get(9),numbers.get(10),numbers.get(11));
        Point point5 = new Point(numbers.get(12),numbers.get(13),numbers.get(14));
        Point point6 = new Point(numbers.get(15),numbers.get(16),numbers.get(17));
        Point point7 = new Point(numbers.get(18),numbers.get(19),numbers.get(20));
        Point point8 = new Point(numbers.get(21),numbers.get(22),numbers.get(23));
        Cube cube = new Cube(point1,point2,point3,point4,point5,point6,point7,point8);
        return cube;
    }
}