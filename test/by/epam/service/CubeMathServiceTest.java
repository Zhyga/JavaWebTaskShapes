package by.epam.service;

import by.epam.entity.Cube;
import by.epam.entity.CustomPoint;
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
    public void calculateVolumeTest(Cube cube,double expected){
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
        CustomPoint point1 = new CustomPoint(-1,1,1);
        CustomPoint point2 = new CustomPoint(-1,1,-1);
        CustomPoint point3 = new CustomPoint(1,1,-1);
        CustomPoint point4 = new CustomPoint(1,1,1);
        CustomPoint point5 = new CustomPoint(-1,-1,1);
        CustomPoint point6 = new CustomPoint(-1,-1,-1);
        CustomPoint point7 = new CustomPoint(1,-1,-1);
        CustomPoint point8 = new CustomPoint(1,-1,1);
        Cube cube = new Cube(point1,point2,point3,point4,point5,point6,point7,point8);
        return new Object[][]{
            {cube,8.0}
        };
    }

    @DataProvider(name= "calculateSurfaceAreaData")
    public Object[][] createCalculateSurfaceArea(){
        CustomPoint point1 = new CustomPoint(-1,1,1);
        CustomPoint point2 = new CustomPoint(-1,1,-1);
        CustomPoint point3 = new CustomPoint(1,1,-1);
        CustomPoint point4 = new CustomPoint(1,1,1);
        CustomPoint point5 = new CustomPoint(-1,-1,1);
        CustomPoint point6 = new CustomPoint(-1,-1,-1);
        CustomPoint point7 = new CustomPoint(1,-1,-1);
        CustomPoint point8 = new CustomPoint(1,-1,1);
        Cube cube = new Cube(point1,point2,point3,point4,point5,point6,point7,point8);
        Cube cube1 = null;
        return new Object[][]{
                {cube,24.0},
                {cube1, 12}
        };
    }

    @DataProvider(name= "isOnCoordinateAxisData")
    public Object[][] createIsOnCoordinateAxis(){
        CustomPoint point1 = new CustomPoint(-1,0,1);
        CustomPoint point2 = new CustomPoint(-1,1,-1);
        CustomPoint point3 = new CustomPoint(1,1,-1);
        CustomPoint point4 = new CustomPoint(1,1,1);
        CustomPoint point5 = new CustomPoint(-1,-1,1);
        CustomPoint point6 = new CustomPoint(-1,-1,-1);
        CustomPoint point7 = new CustomPoint(1,-1,-1);
        CustomPoint point8 = new CustomPoint(1,-1,1);
        Cube cube = new Cube(point1,point2,point3,point4,point5,point6,point7,point8);
        CustomPoint point11 = new CustomPoint(-1311,131,155);
        CustomPoint point12 = new CustomPoint(-6,1,21);
        CustomPoint point13 = new CustomPoint(1,1,-1);
        CustomPoint point14 = new CustomPoint(1,1,1);
        CustomPoint point15 = new CustomPoint(-1,-1,1);
        CustomPoint point16 = new CustomPoint(11,-13,1);
        CustomPoint point17 = new CustomPoint(761,-1,1);
        CustomPoint point18 = new CustomPoint(1,1,1);
        Cube cube2 = new Cube(point11,point12,point13,point14,point15,point16,point17,point18);
        return new Object[][]{
                {cube, true},
                {cube2, false}
        };
    }
}
