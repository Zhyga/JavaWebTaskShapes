package by.epam.factory.pointfactory;

import by.epam.entity.Point;

import java.util.List;

public abstract class PointCreator {
    public abstract List<Point> createPoints(List<Double> numbers);
}
