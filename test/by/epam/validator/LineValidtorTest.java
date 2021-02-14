package by.epam.validator;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LineValidtorTest {

    @Test(dataProvider = "isLineConformCubeData")
    public void isLineConformCubeTest(String line){
        boolean actual = LineValidator.isLineConformCube(line);
        Assert.assertTrue(actual);
    }

    @DataProvider(name= "isLineConformCubeData")
    public Object[][] createIsLineConformCubeData(){
        return new Object[][]{
                {"1.0 2.0 3.0 4.0 5.0 6.1 7.2 8.3 9.4 10.1 1.1 2.3 4.5 6.7 3.4 5.7 8.1 9.1 10.1 1.1 2.3 4.5 6.7 3.4"},
                {"df gd1 123 65 3 878"},
                {"1.0 2.0 3.0 4.0 5.0 6.1 7.2 8.3 9.4 10.1 1.1 2.3 4./5 6.7 3.4 5.7 8.1 9.1 10.1 1.1 2.3 4.5 6.7 3.4"},
                {" "}
        };
    }
}
