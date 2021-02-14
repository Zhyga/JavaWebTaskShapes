package by.epam.specification;

import by.epam.entity.Cube;
import by.epam.entity.Point;
import by.epam.specification.Specification;
import by.epam.specification.impl.CubeSurfaceAreaSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CubeSurfaceAreaSpecificationTest {
    @Test
    public void cubeSurfaceAreaSpecificationTest(){
        Point point1 = new Point(-1,1,1);
        Point point2 = new Point(-1,1,-1);
        Point point3 = new Point(1,1,-1);
        Point point4 = new Point(1,1,1);
        Point point5 = new Point(-1,-1,1);
        Point point6 = new Point(-1,-1,-1);
        Point point7 = new Point(1,-1,-1);
        Point point8 = new Point(1,-1,1);
        Cube cube = new Cube(point1,point2,point3,point4,point5,point6,point7,point8);
        Specification<Cube> cubeSurfaceAreaSpecification = new CubeSurfaceAreaSpecification(7,40);
        boolean actual = cubeSurfaceAreaSpecification.specify(cube);
        Assert.assertTrue(actual);
    }
}
