package by.epam.specification.impl;

import by.epam.entity.Cube;
import by.epam.exception.CustomException;
import by.epam.service.CubeMathService;
import by.epam.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeSurfaceAreaSpecification implements Specification<Cube> {
    private int minArea;
    private int maxArea;
    private static Logger logger = LogManager.getLogger();

    public CubeSurfaceAreaSpecification(int minArea, int maxArea) {
        this.maxArea = maxArea;
        this.minArea = minArea;
    }

    @Override
    public boolean specify(Cube cube) {
        boolean result = false;
        CubeMathService cubeMathService = new CubeMathService();
        double surfaceArea = 0;
        try {
            surfaceArea = cubeMathService.calculateSurfaceArea(cube);
        } catch (CustomException e) {
            logger.error("Error with cube {}", cube,e);
        }
        if (surfaceArea > minArea && surfaceArea < maxArea) {
            result = true;
        }
        return result;
    }
}
