package by.epam.service;

import by.epam.entity.Cube;
import by.epam.entity.CustomPoint;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CubeVerificationServiceTest {
    CubeVerificationService cubeVerificationService;

    @BeforeClass
    public void setUp() {
        cubeVerificationService = new CubeVerificationService();
    }

    @AfterClass
    public void tearDown() {
        cubeVerificationService = null;
    }

    @Test(dataProvider = "isCubeData")
    public void isCubeByPointsTest(Cube cube){
        boolean actual = cubeVerificationService.isCubeByPoints(cube);
        Assert.assertTrue(actual);
    }

    @Test(dataProvider = "isCubeData")
    public void isCubeBySides(Cube cube){
        boolean actual = cubeVerificationService.isCubeByPoints(cube);
        Assert.assertTrue(actual);
    }

    @DataProvider(name="isCubeData")
    public Object[][] createIsCubeData(){
        CustomPoint point1 = new CustomPoint(-1,1,1);
        CustomPoint point2 = new CustomPoint(-1,1,-1);
        CustomPoint point3 = new CustomPoint(1,1,-1);
        CustomPoint point4 = new CustomPoint(1,1,1);
        CustomPoint point5 = new CustomPoint(-1,-1,1);
        CustomPoint point6 = new CustomPoint(-1,-1,-1);
        CustomPoint point7 = new CustomPoint(1,-1,-1);
        CustomPoint point8 = new CustomPoint(1,-1,1);
        Cube cube = new Cube(point1,point2,point3,point4,point5,point6,point7,point8);
        CustomPoint point11 = new CustomPoint(1,1,1);
        CustomPoint point12 = new CustomPoint(65,21,-31);
        CustomPoint point13 = new CustomPoint(32,1,-56);
        CustomPoint point14 = new CustomPoint(132,1,1);
        CustomPoint point15 = new CustomPoint(-154,91,56);
        CustomPoint point16 = new CustomPoint(12,28,-34);
        CustomPoint point17 = new CustomPoint(35,76,-12);
        CustomPoint point18 = new CustomPoint(90,-1,10);
        Cube cube2 = new Cube(point11,point12,point13,point14,point15,point16,point17,point18);
        return new Object[][]{
                {cube},
                {cube2}
        };
    }
}
