package by.epam.factory.shapefactory;

import by.epam.entity.Cube;
import by.epam.entity.CustomPoint;
import java.util.List;

public class CubeFactory extends ShapeFactory{
    @Override
    public Cube createShape(List<CustomPoint> points) {
        Cube cube = new Cube(points);
        return cube;
    }
}
