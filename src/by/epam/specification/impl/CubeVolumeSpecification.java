package by.epam.specification.impl;

import by.epam.entity.Cube;
import by.epam.exception.CustomException;
import by.epam.service.CubeMathService;
import by.epam.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeVolumeSpecification implements Specification<Cube> {
    private int minVolume;
    private int maxVolume;
    private static Logger logger = LogManager.getLogger();

    public CubeVolumeSpecification(int minVolume,int maxVolume){
        this.maxVolume = maxVolume;
        this.minVolume = minVolume;
    }

    @Override
    public boolean specify(Cube cube) {
        boolean result = false;
        CubeMathService cubeMathService = new CubeMathService();
        double volume = 0;
        try {
            volume = cubeMathService.calculateVolume(cube);
        } catch (CustomException e) {
            logger.error("Error with cube {}", cube,e);
        }
        if(volume > minVolume && volume < maxVolume){
            result = true;
        }
        return result;
    }
}
