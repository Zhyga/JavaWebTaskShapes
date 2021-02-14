package by.epam.specification;

import by.epam.entity.Cube;
import by.epam.entity.Point;
import by.epam.specification.Specification;
import by.epam.specification.impl.CubeIdSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CubeIdSpecificationTest {

    @Test
    public void cubeIdSpecificationTest(){
        Point point1 = new Point(-1,1,1);
        Point point2 = new Point(-1,1,-1);
        Point point3 = new Point(1,1,-1);
        Point point4 = new Point(1,1,1);
        Point point5 = new Point(-1,-1,1);
        Point point6 = new Point(-1,-1,-1);
        Point point7 = new Point(1,-1,-1);
        Point point8 = new Point(1,-1,1);
        Cube cube = new Cube(point1,point2,point3,point4,point5,point6,point7,point8);
        Specification<Cube> cubeIdSpecification = new CubeIdSpecification(cube.getShapeId());
        boolean actual = cubeIdSpecification.specify(cube);
        Assert.assertTrue(actual);
    }
}
