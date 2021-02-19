package by.epam.factory.pointfactory;

import by.epam.entity.CustomPoint;
import java.util.ArrayList;
import java.util.List;

public class CubePointFactory extends PointFactory {
    @Override
    public List<CustomPoint> createPoints(List<Double> numbers) {
        List<CustomPoint> points = new ArrayList<>();
        CustomPoint point1 = new CustomPoint(numbers.get(0), numbers.get(1), numbers.get(2));
        CustomPoint point2 = new CustomPoint(numbers.get(3), numbers.get(4), numbers.get(5));
        CustomPoint point3 = new CustomPoint(numbers.get(6), numbers.get(7), numbers.get(8));
        CustomPoint point4 = new CustomPoint(numbers.get(9), numbers.get(10), numbers.get(11));
        CustomPoint point5 = new CustomPoint(numbers.get(12), numbers.get(13), numbers.get(14));
        CustomPoint point6 = new CustomPoint(numbers.get(15), numbers.get(16), numbers.get(17));
        CustomPoint point7 = new CustomPoint(numbers.get(18), numbers.get(19), numbers.get(20));
        CustomPoint point8 = new CustomPoint(numbers.get(21), numbers.get(22), numbers.get(23));
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
