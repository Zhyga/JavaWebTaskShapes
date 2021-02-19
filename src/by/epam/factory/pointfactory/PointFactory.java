package by.epam.factory.pointfactory;

import by.epam.entity.CustomPoint;
import java.util.List;

public abstract class PointFactory {
    public abstract List<CustomPoint> createPoints(List<Double> numbers);
}
