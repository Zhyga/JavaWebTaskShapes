package by.epam.service;

import by.epam.entity.Cube;
import by.epam.entity.Point;
import by.epam.reader.CustomFIleReader;
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
        Point point1 = new Point(-1,1,1);
        Point point2 = new Point(-1,1,-1);
        Point point3 = new Point(1,1,-1);
        Point point4 = new Point(1,1,1);
        Point point5 = new Point(-1,-1,1);
        Point point6 = new Point(-1,-1,-1);
        Point point7 = new Point(1,-1,-1);
        Point point8 = new Point(1,-1,1);
        Cube cube = new Cube(point1,point2,point3,point4,point5,point6,point7,point8);
        Point point11 = new Point(1,1,1);
        Point point12 = new Point(65,21,-31);
        Point point13 = new Point(32,1,-56);
        Point point14 = new Point(132,1,1);
        Point point15 = new Point(-154,91,56);
        Point point16 = new Point(12,28,-34);
        Point point17 = new Point(35,76,-12);
        Point point18 = new Point(90,-1,10);
        Cube cube2 = new Cube(point11,point12,point13,point14,point15,point16,point17,point18);
        return new Object[][]{
                {cube},
                {cube2}
        };
    }
}
