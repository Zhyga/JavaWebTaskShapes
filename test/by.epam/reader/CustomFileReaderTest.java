package by.epam.reader;

import by.epam.exception.CustomException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.ArrayList;

public class CustomFileReaderTest {
    CustomFIleReader customFIleReader;

    @BeforeClass
    public void setUp(){
        customFIleReader = new CustomFIleReader();

    }

    @AfterClass
    public void tearDown(){
        customFIleReader = null;

    }

    @Test(dataProvider = "readTextData")
    public void readTextTest(String fileName,List<String> expected){
        List<String> actual = new ArrayList<>();
        try {
            actual = customFIleReader.readText(fileName);
            Assert.assertEquals(actual, expected);
        }
        catch (CustomException e){
            Assert.fail("No such file exist");
        }
    }

    @DataProvider(name = "readTextData")
    public Object[][] createData(){
        List<String> expected = new ArrayList<>();
        expected.add("-1.0 1.0 1.0 -1.0 1.0 -1.0 1.0 1.0 -1.0 1.0 1.0 1.0 -1.0 -1.0 1.0 -1.0 -1.0 -1.0 1.0 -1.0 -1.0 1.0 -1.0 1.0");
        expected.add("1.0 2.0 3.0 4.0 5.0 6.1 7.2 8.3 9.4 10.1 1.1 2.3 4.5 6.7 3.4 5.7 8.1 9.1 10.1 1.1 2.3 4.5 6.7 3.4");
        expected.add("-1.0 1.0 1.0 -1.0 1.0 -1.0 1.0 1.0 -1.0 1.0 1.0 1.0 -1.0 -1.0 1.0 -1.0 -1.0 -1.0 1.0 -1.0 -1.0 1.0 -1.0 1.0");
        List<String> expected2 = new ArrayList<>();
        expected2.add("-1.0 1.0 1.0 -1.0 1.0 -1.0 1.0 1.g0 -1.0 1.0 1.0 1.0 -1.0 -1.0 1.0 -1.0 -1.0 -1.0 1.0 -1.0 -1.0 1.0 -1.0 1.0");
        expected2.add("1.0 2.0 3.0 4.0 5.0 6.1 7.2 8.3 9g.4 10.1 1.1 2.3 4.5 6.7 3.4 5.7 8.1 9.1 10.1 1.1 2.3 4.5 6.7 3.4");
        expected2.add("-1.0 1.0 1.0 -1.0 1.0 -1.0 1.0 1.0 -1.0 1.0 1.0 1.0 -1.0 -1.0 1.0 -1.0 -1.0 -1.0 1.0 -1.0 -1.0 1.0 -1.0 1.0");
        return new Object[][]{
                {"data/data.txt",expected},
                 {"data/data.txt",expected2},
        };
    }
}

