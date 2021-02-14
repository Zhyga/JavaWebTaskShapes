package by.epam.factory.pointfactory;

import by.epam.entity.Point;

import java.util.ArrayList;
import java.util.List;

public class PointForCube extends PointCreator{
    @Override
    public List<Point> createPoints(List<Double> numbers) {
        List<Point> points = new ArrayList<>();
        Point point1 = new Point(numbers.get(0), numbers.get(1), numbers.get(2));
        Point point2 = new Point(numbers.get(3), numbers.get(4), numbers.get(5));
        Point point3 = new Point(numbers.get(6), numbers.get(7), numbers.get(8));
        Point point4 = new Point(numbers.get(9), numbers.get(10), numbers.get(11));
        Point point5 = new Point(numbers.get(12), numbers.get(13), numbers.get(14));
        Point point6 = new Point(numbers.get(15), numbers.get(16), numbers.get(17));
        Point point7 = new Point(numbers.get(18), numbers.get(19), numbers.get(20));
        Point point8 = new Point(numbers.get(21), numbers.get(22), numbers.get(23));
        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);
        points.add(point5);
        points.add(point6);
        points.add(point7);
        points.add(point8);
        return points;
    }
}
