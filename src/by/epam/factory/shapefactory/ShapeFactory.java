package by.epam.factory.shapefactory;

import by.epam.entity.Point;
import by.epam.entity.Shape;

import java.util.List;

public abstract class ShapeFactory {
    public abstract Shape createShape(List<Point> points);
}
