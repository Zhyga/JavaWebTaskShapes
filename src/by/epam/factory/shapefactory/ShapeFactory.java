package by.epam.factory.shapefactory;

import by.epam.entity.CustomPoint;
import by.epam.entity.AbstractShape;
import java.util.List;

public abstract class ShapeFactory {
    public abstract AbstractShape createShape(List<CustomPoint> points);
}
