package by.epam.service;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CubeVerificationServiceTest {
    CubeVerificationService cubeVerificationService;

    @BeforeClass
    public void setUp(){
        cubeVerificationService = new CubeVerificationService();
    }

    @AfterClass
    public void tearDown(){
        cubeVerificationService = null;
    }
}
