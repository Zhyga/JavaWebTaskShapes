package by.epam.repository;

import by.epam.comparator.CubeComparator;
import by.epam.entity.Cube;
import by.epam.entity.CustomPoint;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import by.epam.specification.Specification;
import by.epam.specification.impl.CubeIdSpecification;
import by.epam.specification.impl.CubeSurfaceAreaSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CubeRepositoryTest {
    CubeRepository cubeRepository;
    Cube cube1;
    Cube cube2;

    @BeforeClass
    public void setUp(){
        cubeRepository = CubeRepository.getInstance();
        CustomPoint point1 = new CustomPoint(12,1,1);
        CustomPoint point2 = new CustomPoint(-1,1,-1);
        CustomPoint point3 = new CustomPoint(1,1,-1);
        CustomPoint point4 = new CustomPoint(1,1,1);
        CustomPoint point5 = new CustomPoint(-1,-1,1);
        CustomPoint point6 = new CustomPoint(-1,-1,-1);
        CustomPoint point7 = new CustomPoint(1,-1,-1);
        CustomPoint point8 = new CustomPoint(1,-1,1);
        cube1 = new Cube(point1,point2,point3,point4,point5,point6,point7,point8);
        CustomPoint point11 = new CustomPoint(-24,2,1);
        CustomPoint point12 = new CustomPoint(-1,1,-3);
        CustomPoint point13 = new CustomPoint(4,5,6);
        CustomPoint point14 = new CustomPoint(11,13,12);
        CustomPoint point15 = new CustomPoint(-541,-1,1);
        CustomPoint point16 = new CustomPoint(-1,-1,54);
        CustomPoint point17 = new CustomPoint(154,11,-11);
        CustomPoint point18 = new CustomPoint(1,81,12);
        cube2 = new Cube(point11,point12,point13,point14,point15,point16,point17,point18);
    }

    @AfterClass
    public void tearDown(){
        cubeRepository = null;
        cube1 = null;
        cube2 = null;
    }

    @Test(dataProvider = "cubeData")
    public void addTest(Cube cube){
        Assert.assertTrue(cubeRepository.add(cube));
    }

    @Test(dataProvider = "cubeData")
    public void removeTest(Cube cube){
        Assert.assertTrue(cubeRepository.remove(cube));
    }

    @Test(dependsOnMethods = {"addTest"})
    public void getAllTest(){
        List<Cube> actual = cubeRepository.getAll();
        List<Cube> expected = new ArrayList<>();
        expected.add(cube1);
        expected.add(cube2);
        Assert.assertEquals(actual,expected);
    }

    @Test(dependsOnMethods = "addTest")
    public void sortTest(){
        List<Cube> expected = new ArrayList<>();
        expected.add(cube2);
        expected.add(cube1);
        List<Cube> actual = cubeRepository.sort(CubeComparator.POINT1);
        Assert.assertEquals(actual,expected);
    }

    @Test(dependsOnMethods = "addTest")
    public void queryTest(){
        List<Cube> expected = new ArrayList<>();
        expected.add(cube1);
        Specification<Cube>  specification = new CubeIdSpecification(cube1.getShapeId());
        List<Cube> actual = cubeRepository.query(specification);
        Assert.assertEquals(actual,expected);
    }


    @DataProvider(name= "cubeData")
    public Object[][] createCubeData(){
        return new Object[][]{
                {cube1},
                {cube2}
        };
    }
}
