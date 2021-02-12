package by.epam.service;

import by.epam.entity.Cube;
import by.epam.entity.Point;

public class CubeMathService extends CubeService{
    public double calculateSurfaceArea(Cube cube){
        double side = calculateDistanceBetweenPoints(cube.getPoint1(),cube.getPoint2());
        double surfaceArea = 6 * Math.pow(side,2);
        return surfaceArea;
    }

    public double calculateVolume(Cube cube){
        double side = calculateDistanceBetweenPoints(cube.getPoint1(),cube.getPoint2());
        double volume = Math.pow(side,3);
        return volume;
    }

    public boolean isOnCoordinateAxis(Cube cube){
        boolean result = false;
        if((Double.compare(cube.getPoint1().getX(),0.0) == 0) || (Double.compare(cube.getPoint1().getY(),0.0) == 0) ||
                (Double.compare(cube.getPoint1().getY(),0.0) == 0)){
            result = true;
        }
        if((Double.compare(cube.getPoint8().getX(),0.0) == 0) || (Double.compare(cube.getPoint8().getY(),0.0) == 0) ||
                (Double.compare(cube.getPoint8().getY(),0.0) == 0)){
            result = true;
        }
        return result;
    }
}
