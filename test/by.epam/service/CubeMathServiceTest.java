package by.epam.service;

import by.epam.entity.Cube;
import by.epam.entity.Point;
import by.epam.exception.CustomException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CubeMathServiceTest {
    CubeMathService cubeMathService;

    @BeforeClass
    public void setUp(){
        cubeMathService = new CubeMathService();
    }

    @AfterClass
    public void tearDown(){
        cubeMathService = null;
    }

    @Test(dataProvider = "calculateVolumeData")
    public void calculateVolumeTeas(Cube cube,double expected){
        double actual = 0;
        try {
            actual = cubeMathService.calculateVolume(cube);
        } catch (CustomException e) {
            Assert.fail("Cube is incorrect");
        }
        Assert.assertEquals(actual,expected);
    }

    @Test(dataProvider = "calculateSurfaceAreaData")
    public void calculateSurfaceAreaTest(Cube cube,double expected){
        double actual = 0;
        try {
            actual = cubeMathService.calculateSurfaceArea(cube);
        } catch (CustomException e) {
            Assert.fail("Cube is incorrect");
        }
        Assert.assertEquals(actual,expected);
    }

    @Test(dataProvider = "isOnCoordinateAxisData")
    public void calculateIsOnCoordinateAxis(Cube cube, boolean expected){
        boolean actual = false;
        try {
            actual = cubeMathService.isOnCoordinateAxis(cube);
            Assert.assertEquals(actual,expected);
        } catch (CustomException e) {
            Assert.fail("Cube is incorrect");
        }
    }

    @DataProvider(name= "calculateVolumeData")
    public Object[][] createCalculateVolumeData(){
        Point point1 = new Point(-1,1,1);
        Point point2 = new Point(-1,1,-1);
        Point point3 = new Point(1,1,-1);
        Point point4 = new Point(1,1,1);
        Point point5 = new Point(-1,-1,1);
        Point point6 = new Point(-1,-1,-1);
        Point point7 = new Point(1,-1,-1);
        Point point8 = new Point(1,-1,1);
        Cube cube = new Cube(point1,point2,point3,point4,point5,point6,point7,point8);
        return new Object[][]{
            {cube,8.0}
        };
    }

    @DataProvider(name= "calculateSurfaceAreaData")
    public Object[][] createCalculateSurfaceArea(){
        Point point1 = new Point(-1,1,1);
        Point point2 = new Point(-1,1,-1);
        Point point3 = new Point(1,1,-1);
        Point point4 = new Point(1,1,1);
        Point point5 = new Point(-1,-1,1);
        Point point6 = new Point(-1,-1,-1);
        Point point7 = new Point(1,-1,-1);
        Point point8 = new Point(1,-1,1);
        Cube cube = new Cube(point1,point2,point3,point4,point5,point6,point7,point8);
        Cube cube1 = null;
        return new Object[][]{
                {cube,24.0},
                {cube1, 12}
        };
    }

    @DataProvider(name= "isOnCoordinateAxisData")
    public Object[][] createIsOnCoordinateAxis(){
        Point point1 = new Point(-1,0,1);
        Point point2 = new Point(-1,1,-1);
        Point point3 = new Point(1,1,-1);
        Point point4 = new Point(1,1,1);
        Point point5 = new Point(-1,-1,1);
        Point point6 = new Point(-1,-1,-1);
        Point point7 = new Point(1,-1,-1);
        Point point8 = new Point(1,-1,1);
        Cube cube = new Cube(point1,point2,point3,point4,point5,point6,point7,point8);
        Point point11 = new Point(-1311,131,155);
        Point point12 = new Point(-6,1,21);
        Point point13 = new Point(1,1,-1);
        Point point14 = new Point(1,1,1);
        Point point15 = new Point(-1,-1,1);
        Point point16 = new Point(11,-13,1);
        Point point17 = new Point(761,-1,1);
        Point point18 = new Point(1,1,1);
        Cube cube2 = new Cube(point11,point12,point13,point14,point15,point16,point17,point18);
        return new Object[][]{
                {cube, true},
                {cube2, false}
        };
    }
}
