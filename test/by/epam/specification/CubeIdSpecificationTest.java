package by.epam.specification;

import by.epam.entity.Cube;
import by.epam.entity.CustomPoint;
import by.epam.specification.impl.CubeIdSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CubeIdSpecificationTest {

    @Test
    public void cubeIdSpecificationTest(){
        CustomPoint point1 = new CustomPoint(-1,1,1);
        CustomPoint point2 = new CustomPoint(-1,1,-1);
        CustomPoint point3 = new CustomPoint(1,1,-1);
        CustomPoint point4 = new CustomPoint(1,1,1);
        CustomPoint point5 = new CustomPoint(-1,-1,1);
        CustomPoint point6 = new CustomPoint(-1,-1,-1);
        CustomPoint point7 = new CustomPoint(1,-1,-1);
        CustomPoint point8 = new CustomPoint(1,-1,1);
        Cube cube = new Cube(point1,point2,point3,point4,point5,point6,point7,point8);
        Specification<Cube> cubeIdSpecification = new CubeIdSpecification(cube.getShapeId());
        boolean actual = cubeIdSpecification.specify(cube);
        Assert.assertTrue(actual);
    }
}
