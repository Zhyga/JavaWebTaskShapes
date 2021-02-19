package by.epam.warehouse;

import by.epam.entity.Cube;
import by.epam.entity.CubeDataHandler;
import by.epam.entity.CustomPoint;
import by.epam.exception.CustomException;
import by.epam.service.CubeMathService;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CubeWarehouseTest {
    CubeWarehouse cubeWarehouse;
    CubeDataHandler cubeDataHandler;
    CubeDataHandler cubeDataHandler2;
    CubeMathService cubeMathService;
    Cube cube1;
    Cube cube2;

    @BeforeClass
    public void setUp(){
        cubeWarehouse = CubeWarehouse.getInstance();
        cubeDataHandler = new CubeDataHandler();
        cubeDataHandler2 = new CubeDataHandler();
        cubeMathService = new CubeMathService();
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
        cubeWarehouse = null;
        cubeDataHandler = null;
        cubeDataHandler2 = null;
        cubeMathService = null;
        cube1 = null;
        cube2 = null;
    }

    @Test(dataProvider = "dataHandler")
    public void putGetTest(String key, CubeDataHandler expected){
        CubeDataHandler actual = new CubeDataHandler();
        cubeWarehouse.put(key,expected);
        actual = cubeWarehouse.get(key);
        Assert.assertEquals(actual,expected);
    }

    @Test(dataProvider = "removeTestData",dependsOnMethods = "putGetTest")
    public void removeTest(String key, Map<String,CubeDataHandler> expected){
        cubeWarehouse.remove(key);
        Map<String,CubeDataHandler> actual = cubeWarehouse.getCubeData();
        Assert.assertEquals(actual,expected);
    }

    @DataProvider(name = "removeTestData")
    public Object[][] createRemoveTestData() throws CustomException {
        Map<String,CubeDataHandler> expected = new HashMap<>();
        double volume1 = cubeMathService.calculateVolume(cube1);
        double surfaceArea1 = cubeMathService.calculateSurfaceArea(cube1);
        cubeDataHandler.setVolume(volume1);
        cubeDataHandler.setSurfaceArea(surfaceArea1);
        expected.put(cube1.getShapeId(),cubeDataHandler);
        return new Object[][]{
                {cube2.getShapeId(),expected}
        };
    }

    @DataProvider(name = "dataHandler")
    public Object[][] createDataHandler() throws CustomException {
        double volume1 = cubeMathService.calculateVolume(cube1);
        double volume2 = cubeMathService.calculateVolume(cube2);
        double surfaceArea1 = cubeMathService.calculateSurfaceArea(cube1);
        double surfaceArea2 = cubeMathService.calculateSurfaceArea(cube2);
        cubeDataHandler.setVolume(volume1);
        cubeDataHandler.setSurfaceArea(surfaceArea1);
        cubeDataHandler2.setVolume(volume2);
        cubeDataHandler2.setSurfaceArea(surfaceArea2);
        return new Object[][]{
                {cube1.getShapeId(),cubeDataHandler},
                {cube2.getShapeId(),cubeDataHandler2}
        };
    }
}
