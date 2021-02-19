package by.epam.observer.impl;

import by.epam.entity.Cube;
import by.epam.entity.CubeDataHandler;
import by.epam.exception.CustomException;
import by.epam.observer.CubeEvent;
import by.epam.observer.Observer;
import by.epam.service.CubeMathService;
import by.epam.warehouse.CubeWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeDataObserver implements Observer{
    private static Logger logger = LogManager.getLogger();

    @Override
    public void handleEvent(CubeEvent cubeEvent) {
        Cube cube = cubeEvent.getSource();
        try {
            CubeMathService cubeMathService =
                    new CubeMathService();
            double cubeSurfaceArea =
                    cubeMathService.calculateSurfaceArea(cube);
            double cubeVolume =
                    cubeMathService.calculateVolume(cube);
            CubeDataHandler cubeDataHandler =
                    new CubeDataHandler(cubeSurfaceArea, cubeVolume);
            CubeWarehouse cubeWarehouse = CubeWarehouse.getInstance();
            cubeWarehouse.put(cube.getShapeId(), cubeDataHandler);
        } catch (CustomException e) {
            logger.error("Quadrangle wasn't add to warehouse: {}", cube, e);
        }
    }
}
