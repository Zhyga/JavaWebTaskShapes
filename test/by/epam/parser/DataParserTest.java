package by.epam.parser;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DataParserTest {
    private DataParser dataParser;

    @BeforeClass
    public void setUp() {
        dataParser = new DataParser();
    }

    @AfterClass
    public void tearDown() {
        dataParser = null;
    }

    @Test(dataProvider = "parseLineToNumberData")
    public void parseLineToNumberTest(String line, List<Double> expected){
        List<Double> actual = dataParser.parseLineToNumber(line);
        Assert.assertEquals(actual,expected);
    }

    @DataProvider(name = "parseLineToNumberData")
    public Object[][] createLineToNumberData(){
        String line1 = "1 2 3. 4";
        List<Double> expected1 = new ArrayList<>();
        expected1.add(1.0);
        expected1.add(2.0);
        expected1.add(3.0);
        expected1.add(4.0);
        String line2 = "-.1 2 3.4 54";
        List<Double> expected2 = new ArrayList<>();
        expected2.add(-.1);
        expected2.add(2.0);
        expected2.add(3.4);
        expected2.add(54.0);
        return new Object[][]{
                {line1,expected1},
                {line2,expected2}
        };
    }
}
